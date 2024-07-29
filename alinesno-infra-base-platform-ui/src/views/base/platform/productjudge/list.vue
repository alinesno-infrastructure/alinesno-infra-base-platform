<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
              <el-form-item label="产品名称" prop="productItemId">
                <el-select v-model="queryParams.productItemId" placeholder="请选择产品名称"  style="width:360px" clearable  filterable  @keyup.enter="handleQuery">
                  <el-option  v-for="item in productItemList"
                              :key="item.id"
                              :label="item.name"
                              :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
               <el-form-item label="评价内容" prop="content">
                  <el-input v-model="queryParams['condition[content|like]']" placeholder="请输入评价内容" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item>
                  <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                  <el-button icon="Refresh" @click="resetQuery">重置</el-button>
               </el-form-item>
            </el-form>

            <el-row :gutter="10" class="mb8">

               <el-col :span="1.5">
                  <el-button type="primary" plain icon="Plus" @click="handleAdd">新增</el-button>
               </el-col>
               <el-col :span="1.5">
                  <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate">修改</el-button>
               </el-col>
               <el-col :span="1.5">
                  <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete">删除</el-button>
               </el-col>

               <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
            </el-row>

            <el-table v-loading="loading" :data="ProductJudgeList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <!-- 业务字段-->
               <el-table-column label="产品名称" align="center" key="productItemId" prop="productItemId" v-if="columns[0].visible" >
                   <template #default="scope">
                     <span>{{ productItemTrans(scope.row.productItemId ) }}</span>
                   </template>
               </el-table-column>
               <el-table-column label="评价内容" align="center" key="content" prop="content" v-if="columns[1].visible" :show-overflow-tooltip="true" />
               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[2].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="修改" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:ProductJudge:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:ProductJudge:remove']"></el-button>
                     </el-tooltip>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

      <!-- 添加或修改应用配置对话框 -->
      <el-dialog :title="title" v-model="open" width="600px" append-to-body>
         <el-form :model="form" :rules="rules" ref="databaseRef" label-width="100px">
            <el-row>
               <el-col :span="24">
                  <el-form-item label="产品名称" prop="productItemId">
                    <el-select v-model="form.productItemId" placeholder="请选择产品名称"  style="width:360px" clearable  filterable >
                      <el-option  v-for="item in productItemList"
                                  :key="item.id"
                                  :label="item.name"
                                  :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
               </el-col>
            </el-row>
            <el-row>
               <el-col :span="24">
                  <el-form-item label="应用评价" prop="content">
                     <el-input v-model="form.content" type="textarea"  style="width:360px" placeholder="请输入应用评价" maxlength="255" />
                  </el-form-item>
               </el-col>
            </el-row>
         </el-form>
         <template #footer>
            <div class="dialog-footer">
               <el-button type="primary" @click="submitForm">确 定</el-button>
               <el-button @click="cancel">取 消</el-button>
            </div>
         </template>
      </el-dialog>

   </div>
</template>

<script setup name="ProductJudge">

import {
   listProductJudge,
   delProductJudge,
   getProductJudge,
   updateProductJudge,
   addProductJudge
} from "@/api/base/platform/ProductJudge.js";
import { listProductItem } from "@/api/base/platform/product";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const ProductJudgeList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const contents = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const productItemList  = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `产品名称`, visible: true },
   { key: 1, label: `评价内容`, visible: true },
   { key: 2, label: `添加时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      productItemId: undefined,
      content: undefined
   },
   queryOtherParams: {
    pageNum: 1,
    pageSize: 1000
   },
   rules: {
      productItemId: [{ required: true, message: "产品名称不能为空", trigger: "blur" }] ,
      content: [{ required: true, message: "评价内容不能为空", trigger: "blur" }]
   }
});

const { queryParams, form, rules, queryOtherParams
} = toRefs(data);

/** 查询产品列表 */
function getProductItemList() {
  listProductItem(proxy.addDateRange(queryOtherParams.value, dateRange.value)).then(res => {
    productItemList.value = res.rows;
  });
};

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listProductJudge(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductJudgeList.value = res.rows;
      total.value = res.total;
   });
};

/** 搜索按钮操作 */
function handleQuery() {
   queryParams.value.pageNum = 1;
   getList();
};

/** 重置按钮操作 */
function resetQuery() {
   dateRange.value = [];
   proxy.resetForm("queryRef");
   queryParams.value.deptId = undefined;
   proxy.$refs.deptTreeRef.setCurrentKey(null);
   handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
   const tmpIds = row.id || ids.value;
   const tmpContents = row.content || contents.value;
   proxy.$modal.confirm('是否确认删除评价内容为"' + tmpContents + '"的数据项？').then(function () {
      return delProductJudge(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   contents.value = selection.map(item => item.content);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      productItemId: undefined,
      content: undefined,
   };
   proxy.resetForm("databaseRef");
};
/** 取消按钮 */
function cancel() {
   open.value = false;
   reset();
};

/** 新增按钮操作 */
function handleAdd() {
   reset();
   open.value = true;
   title.value = "添加应用";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const id = row.id || ids.value;
   getProductJudge(id).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProductJudge(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductJudge(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

function productItemTrans(productItemId) {

  var productName = '' ;
  productItemList.value.filter((item) => {
    if ( item.id === productItemId)
    {
      productName = item.name
    }
  });

  return productName ;

}

getProductItemList()
getList();

</script>
