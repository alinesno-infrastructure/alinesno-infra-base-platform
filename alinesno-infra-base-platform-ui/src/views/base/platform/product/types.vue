<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="父类型" prop="parentId">
                 <el-select v-model="queryParams.parentId" placeholder="请选择父类型"  style="width:360px" clearable  filterable @keyup.enter="handleQuery" >
                   <el-option  v-for="item in ProductTypeList"
                               :key="item.id"
                               :label="item.name"
                               :value="item.id">
                   </el-option>
                 </el-select>
               </el-form-item>
               <el-form-item label="名称" prop="name">
                  <el-input v-model="queryParams['condition[name|like]']" placeholder="请输入类型名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="ProductTypeList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <el-table-column label="图标" align="center" with="80" key="status" v-if="columns[2].visible">
               </el-table-column>

               <!-- 业务字段-->
               <el-table-column label="类型名称" align="center" key="name" prop="name" v-if="columns[0].visible" />
               <el-table-column label="父类型名称" align="center" key="parentId" prop="parentId" v-if="columns[1].visible" >
                 <template #default="scope">
                   <span>{{ filterType(scope.row.parentId ) }}</span>
                 </template>
               </el-table-column>
               <el-table-column label="类型描述" align="center" key="typeDescribe" prop="typeDescribe" v-if="columns[2].visible" :show-overflow-tooltip="true" />
               <el-table-column label="状态" prop="hasStatus" align="left" placeholder="0:禁用,1:开启" :width=80 v-if="columns[3].visible">
                  <template #default="scope">
                    <el-switch
                        v-model="scope.row.hasStatus"
                        :active-value=0
                        :inactive-value=1
                        @change="handleStatusChange(scope.row)"
                    ></el-switch>
                  </template>
               </el-table-column>

               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[4].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="修改" placement="top" v-if="scope.row.ProductItemId !== 1">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:ProductItem:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.ProductItemId !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:ProductItem:remove']"></el-button>
                     </el-tooltip>
                  </template>

               </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

      <!-- 添加或修改应用配置对话框 -->
      <el-dialog :title="title" v-model="open" width="900px" append-to-body>
         <el-form :model="form" :rules="rules" ref="ProductTypeRef" label-width="100px">
            <el-row>
              <el-col :span="24">
                <el-form-item label="父类型" prop="parentId">
                  <el-select v-model="form.parentId" placeholder="请选择父类型"  style="width:360px" clearable  filterable >
                    <el-option  v-for="item in ProductTypeList"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

               <el-col :span="24">
                  <el-form-item label="类型名称" prop="name">
                     <el-input v-model="form.name" placeholder="请输入产品类型名称" maxlength="50" />
                  </el-form-item>
               </el-col>
            </el-row>
            <el-row>
               <el-col :span="24">
                  <el-form-item label="类型描述" prop="typeDescribe">
                     <el-input v-model="form.typeDescribe" type="textarea" placeholder="请输入产品类型描述" maxlength="255" />
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

<script setup name="ProductItem">

import {
   listProductType,
   delProductType,
   getProductType,
   updateProductType,
   addProductType,
   changeProductStatus
} from "@/api/base/platform/productType";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const ProductTypeList = ref([]);
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
   { key: 0, label: `类型名称`, visible: true },
   { key: 1, label: `父类型`, visible: true },
   { key: 2, label: `类型描述`, visible: true },
   { key: 3, label: `状态`, visible: true },
   { key: 4, label: `添加时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      name: undefined,
      typeDescribe: undefined,
      parentId: undefined,
      sortNumber: undefined,
      remark: undefined
   },
   rules: {
      name: [{ required: true, message: "类型名称不能为空", trigger: "blur" }] ,
      typeDescribe: [{ required: true, message: "类型描述不能为空", trigger: "blur" }] ,
      parentId: [{ required: false, message: "父类型不能为空", trigger: "blur" }],
      sortNumber: [{ required: false, message: "排序不能为空", trigger: "blur" }] ,
      remark: [{ required: false, message: "备注不能为空", trigger: "blur" }]
   }
});



const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listProductType(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductTypeList.value = res.rows;
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
   proxy.$modal.confirm('是否确认删除应用编号为"' + tmpIds + '"的数据项？').then(function () {
      return delProductType(tmpIds);
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
      name: undefined,
      typeDescribe: undefined,
      sortNumber: undefined,
      parentId: undefined,
      remark: undefined,
   };
   proxy.resetForm("ProductTypeRef");
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
   const ProductItemId = row.id || ids.value;
   getProductType(ProductItemId).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["ProductTypeRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProductType(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductType(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

/** 状态修改**/
function handleStatusChange(row) {
  return changeProductStatus(row.id, row.hasStatus).then(response=>{
    if(response.code == 200){
      proxy.$modal.msgSuccess("操作成功");
      getList();
    }
  });
}

function filterType(parentId){
  var parentName = '' ;
  ProductTypeList.value.filter((item) => {
    if ( item.id === parentId)
    {
      parentName = item.name
    }
  });

  return parentName ;

}


getList();

</script>
