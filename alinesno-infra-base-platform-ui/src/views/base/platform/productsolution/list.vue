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
               <el-form-item label="方案名称" prop="solutionId">
                 <el-select v-model="queryParams.solutionId" placeholder="请选择方案名称"  style="width:360px" clearable  filterable @keyup.enter="handleQuery">
                   <el-option  v-for="item in solutionList"
                               :key="item.id"
                               :label="item.title"
                               :value="item.id">
                   </el-option>
                 </el-select>
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

            <el-table v-loading="loading" :data="ProductSolutionList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <!-- 业务字段-->
               <el-table-column label="产品名称" align="center" key="productItemId" prop="productItemId"  v-if="columns[0].visible" >
                  <template #default="scope">
                    <span>{{ productItemTrans(scope.row.productItemId ) }}</span>
                  </template>
                </el-table-column>

               <el-table-column label="方案名称" align="center" key="solutionId" prop="solutionId" v-if="columns[1].visible" :show-overflow-tooltip="true" >
                 <template #default="scope">
                   <span>{{ solutionTrans(scope.row.solutionId ) }}</span>
                 </template>
               </el-table-column>

              <el-table-column label="状态" prop="hasStatus" align="left" placeholder="0:禁用,1:开启" :width=80 v-if="columns[2].visible">
                <template #default="scope">
                  <el-switch
                      v-model="scope.row.hasStatus"
                      :active-value=0
                      :inactive-value=1
                      @change="handleStatusChange(scope.row)"
                  ></el-switch>
                </template>
              </el-table-column>
              
               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[3].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="修改" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:ProductSolution:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:ProductSolution:remove']"></el-button>
                     </el-tooltip>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

      <!-- 添加或修改应用配置对话框 -->
      <el-dialog :title="title" v-model="open" width="900px" append-to-body>
         <el-form :model="form" :rules="rules" ref="databaseRef" label-width="100px">
            <el-row>
               <el-col :span="24">
                  <el-form-item label="应用名称" prop="productItemId">
                    <el-select v-model="form.productItemId" placeholder="请选择应用名称"  style="width:360px" clearable  filterable >
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
                  <el-form-item label="方案名称" prop="solutionId">
                    <el-select v-model="form.solutionId" placeholder="请选择应用方案"  style="width:360px" clearable  filterable >
                      <el-option  v-for="item in solutionList"
                                  :key="item.id"
                                  :label="item.title"
                                  :value="item.id">
                      </el-option>
                    </el-select>
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

<script setup name="ProductSolution">

import { listProductItem } from "@/api/base/platform/product";
import { listSolutionManage } from "@/api/base/platform/SolutionManage";

import {
  listProductSolution,
  delProductSolution,
  getProductSolution,
  updateProductSolution,
  addProductSolution
} from "@/api/base/platform/ProductSolution";



const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const ProductSolutionList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const productItemList  = ref([]);
const solutionList  = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `产品名称`, visible: true },
   { key: 1, label: `方案名称`, visible: true },
   { key: 2, label: `状态`, visible: true },
   { key: 3, label: `添加时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      productItemId: undefined,
      solutionId: undefined
   },
   queryOtherParams: {
      pageNum: 1,
      pageSize: 1000
   },
   rules: {
      productItemId: [{ required: true, message: "产品名称不能为空", trigger: "blur" }] ,
      solutionId: [{ required: true, message: "方案名称不能为空", trigger: "blur" }],
   }
});

const { queryParams, form, rules, queryOtherParams } = toRefs(data);

/** 查询产品列表 */
function getProductItemList() {
  listProductItem(proxy.addDateRange(queryOtherParams.value, dateRange.value)).then(res => {
    productItemList.value = res.rows;
  });
};

/** 查询方案列表 */
function getSolutionList() {
  listSolutionManage(proxy.addDateRange(queryOtherParams.value, dateRange.value)).then(res => {
    solutionList.value = res.rows;
  });
};

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listProductSolution(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductSolutionList.value = res.rows;
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
   const ProductSolutionIds = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除应用编号为"' + ProductSolutionIds + '"的数据项？').then(function () {
      return delProductSolution(ProductSolutionIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      productItemId: undefined,
      solutionId: undefined
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
   const ProductSolutionId = row.id || ids.value;
   getProductSolution(ProductSolutionId).then(response => {
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
            updateProductSolution(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductSolution(form.value).then(response => {
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

function solutionTrans(solutionId) {

  var solutionName = '' ;
  solutionList.value.filter((item) => {
    if ( item.id === solutionId)
    {
      solutionName = item.name
    }
  });

  return solutionName ;

}

getProductItemList();
getSolutionList();
getList();

</script>
