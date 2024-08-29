<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="账户名称" prop="accountName">
                  <el-input v-model="queryParams.accountName" placeholder="请输入账户名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item label="产品名称" prop="productItemName">
                  <el-input v-model="queryParams['condition[productItemName|like]']" placeholder="请输入产品名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="ProductAccessInfoList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <!-- 业务字段-->
               <el-table-column label="账户名称" align="center" key="accountName" prop="accountName" v-if="columns[0].visible" />
               <el-table-column label="产品名称" align="center" key="productItemName" prop="productItemName" v-if="columns[1].visible" :show-overflow-tooltip="true" />
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
                           v-hasPermi="['platform:ProductAccessInfo:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['platform:ProductAccessInfo:remove']"></el-button>
                     </el-tooltip>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

      <!-- 添加或修改应用配置对话框 -->
      <el-dialog :title="title" v-model="open" width="900px" append-to-body>
         <el-form :model="form" :rules="rules" ref="ProductAccessInfoRef" label-width="100px">
            <el-row>
               <el-col :span="24">
                  <el-form-item label="账户id" prop="accountId">
                     <el-input v-model="form.accountId"  type="number" placeholder="请输入账户id" maxlength="50" />
                  </el-form-item>
               </el-col>
              <el-col :span="24">
                <el-form-item label="账户名称" prop="accountName">
                  <el-input v-model="form.accountName" placeholder="请输入账户名称" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="产品id" prop="productItemId">
                  <el-input v-model="form.productItemId" type="number"   placeholder="请选择产品id" maxlength="255" />
                </el-form-item>
              </el-col>
               <el-col :span="24">
                  <el-form-item label="产品名称" prop="productItemName">
                     <el-input v-model="form.productItemName"   placeholder="请选择产品名称" maxlength="255" />
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

<script setup name="ProductAccessInfo">

import {
   listProductAccessInfo,
   delProductAccessInfo,
   getProductAccessInfo,
   updateProductAccessInfo,
   addProductAccessInfo
} from "@/api/base/platform/ProductAccessInfo";


const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const ProductAccessInfoList = ref([]);
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


// 列显隐信息
const columns = ref([
   { key: 0, label: `账户名称`, visible: true },
   { key: 1, label: `产品名称`, visible: true },
   { key: 2, label: `添加时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      accountId: undefined,
      productItemId: undefined
   },
   rules: {
      accountId: [{ required: true, message: "名称不能为空", trigger: "blur" }] ,
      productItemId: [{ required: true, message: "连接不能为空", trigger: "blur" }],
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listProductAccessInfo(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductAccessInfoList.value = res.rows;
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
   handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
   const tmpIds = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除勾选的数据项？').then(function () {
      return delProductAccessInfo(tmpIds);
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
      accountId: undefined,
      accountName: undefined,
      productItemId: undefined,
      productItemName: undefined,
   };
   proxy.resetForm("ProductAccessInfoRef");
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
   title.value = "添加产品访问记录";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const ProductAccessInfoId = row.id || ids.value;
   getProductAccessInfo(ProductAccessInfoId).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改产品访问记录";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["ProductAccessInfoRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProductAccessInfo(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductAccessInfo(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

getList();

</script>
