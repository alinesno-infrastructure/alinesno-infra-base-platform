<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="应用名称" prop="name">
                  <el-input v-model="queryParams.name" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item label="应用介绍" prop="productBrief">
                  <el-input v-model="queryParams['condition[productBrief|like]']" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="ProductItemList" @selection-change="handleSelectionChange">
               <el-table-column type="index" width="50" align="center" />

               <!-- 
               <el-table-column label="图标" align="center" width="60" key="icon">
                 <template #default="scope">
                    <div>
                       <img style="width:40px; height:40px" :src="'http://data.linesno.com/icons/product/' + (scope.$index + 1) + '.png'" />
                    </div>
                 </template>
               </el-table-column> 
               -->

               <!-- 业务字段-->
               <el-table-column label="应用名称" align="left" key="name" prop="name" v-if="columns[0].visible">
                   <template #default="scope">
                        <div>
                           {{ scope.row.name }}
                        </div>
                        <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.promptId">
                           {{ scope.row.productBrief }}
                        </div>
                  </template>
               </el-table-column>
               <el-table-column label="访问地址" width="150" align="center" key="link" prop="link" v-if="columns[3].visible" :show-overflow-tooltip="true">
                    <template #default="scope">
                        <el-button type="primary" text>
                            <i class="fa-solid fa-link"></i>&nbsp;
                            <el-link :underline="false" type="primary" :href="scope.row.linkPath" target="_blank">打开方案</el-link>
                        </el-button>
                    </template>
               </el-table-column>
               <el-table-column label="产品类型" align="center" key="allow_url" prop="linkPath" v-if="columns[2].visible">
                   <template #default="scope">
                      <el-select disabled v-model="scope.row.productTypeId" placeholder="请选择产品类型">
                        <el-option v-for="item in productTypeOptions"
                                :label="item.name"
                                :key="item.id"
                                :value="item.id">
                                {{ item.name }}
                        </el-option>
                      </el-select>
                   </template>
               </el-table-column>
               <el-table-column label="应用状态" align="center" width="100" key="prodStatus" prop="isPublic"  v-if="columns[3].visible" >
                 <template #default="scope">
                   <span>{{ prodStatusTrans(scope.row.prodStatus ) }}</span>
                 </template>
               </el-table-column>

               <el-table-column label="所属类型" align="center" key="typeOwner" prop="typeOwner">
                  <template #default="scope">
                     <el-button type="success" bg text v-if="scope.row.productOwner === 'platform'">
                           <i class="fa-solid fa-link"></i>&nbsp;平台
                     </el-button>
                     <el-button type="primary" bg text v-else>
                           <i class="fa-solid fa-link"></i>&nbsp;组织
                     </el-button>
                  </template>
               </el-table-column>

               <el-table-column label="是否公开" align="center" width="100" key="isPublic" prop="isPublic" v-if="columns[4].visible" >
                  <template #default="scope">
                    <span>{{ isPublicTrans(scope.row.isPublic ) }}</span>
                  </template>
               </el-table-column>

              <el-table-column label="状态" prop="hasStatus" align="left" placeholder="0:禁用,1:开启" :width=80 v-if="columns[5].visible">
                <template #default="scope">
                  <el-switch
                      v-model="scope.row.hasStatus"
                      :active-value=0
                      :inactive-value=1
                      @change="handleStatusChange(scope.row)"
                  ></el-switch>
                </template>
              </el-table-column>

               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[6].visible" width="160">
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
         <el-form :model="form" :rules="rules" ref="productItemRef" label-width="100px">
            <el-row>
               <el-col :span="24">
                  <el-form-item label="应用图标" prop="logo">
                     <!-- <el-input v-model="form.logo" placeholder="请输入应用图标" maxlength="255" /> -->

                     <el-upload action="#" list-type="picture-card" :auto-upload="false">
                           <el-icon><Plus /></el-icon>

                           <template #file="{ file }">
                              <div>
                              <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
                              <span class="el-upload-list__item-actions">
                                 <span
                                    class="el-upload-list__item-preview"
                                    @click="handlePictureCardPreview(file)"
                                 >
                                    <el-icon><zoom-in /></el-icon>
                                 </span>
                                 <span
                                    v-if="!disabled"
                                    class="el-upload-list__item-delete"
                                    @click="handleDownload(file)"
                                 >
                                    <el-icon><Download /></el-icon>
                                 </span>
                                 <span
                                    v-if="!disabled"
                                    class="el-upload-list__item-delete"
                                    @click="handleRemove(file)"
                                 >
                                    <el-icon><Delete /></el-icon>
                                 </span>
                              </span>
                              </div>
                           </template>
                        </el-upload>

                  </el-form-item>
               </el-col>
               <el-col :span="24">
                  <el-form-item label="应用名称" prop="name">
                     <el-input v-model="form.name" placeholder="请输入应用名称" maxlength="50" />
                  </el-form-item>
               </el-col>
            </el-row>
            <el-form-item label="产品类型" prop="productTypeId">
              <el-select v-model="form.productTypeId" placeholder="请选择产品类型">
                <el-option v-for="item in productTypeOptions"
                        :label="item.name"
                        :key="item.id"
                        :value="item.id">
                        {{ item.name }}
                </el-option>
              </el-select>
            </el-form-item>
            <el-row>
               <el-col :span="24">
                  <el-form-item label="应用介绍" prop="productBrief">
                     <el-input v-model="form.productBrief" type="textarea" placeholder="请输入应用介绍" maxlength="255" />
                  </el-form-item>
               </el-col>
            </el-row>
            <el-row>
               <el-col :span="24">
                  <el-form-item label="授权地址" prop="linkPath">
                     <el-input v-model="form.linkPath" placeholder="请输入授权地址" maxlength="255" />
                  </el-form-item>
               </el-col>

               <el-col :span="24">
                  <el-form-item label="应用状态" prop="prodStatus">
                     <el-radio-group v-model="form.prodStatus">
                        <el-radio
                           v-for="item in prodStatusOptions"
                           :key="item.key"
                           :label="item.key"
                        >{{ item.label }}</el-radio>
                     </el-radio-group>
                  </el-form-item>
               </el-col>

               <el-col :span="24">
                 <el-form-item label="是否公开" prop="isPublic"  >
                   <el-radio-group v-model="form.isPublic" class="myradiogroup"  @change="$forceUpdate()">
                     <el-radio :label=1>公开</el-radio>
                     <el-radio :label=0>不公开</el-radio>
                   </el-radio-group>
                 </el-form-item>
               </el-col>
            </el-row>

            <el-row>
               <el-col :span="24">
                  <el-form-item label="备注" prop="productDescribe">
                     <el-input v-model="form.productDescribe" type="textarea"  placeholder="请输入应用备注"></el-input>
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
  listProductItem,
  delProductItem,
  getProductItem,
  updateProductItem,
  addProductItem,
  changeProductStatus
} from "@/api/base/platform/product";

import {
  getAllProductType,
} from "@/api/base/platform/productType";

const router = useRouter();
const { proxy } = getCurrentInstance();
/*const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");*/

// 定义变量
const ProductItemList = ref([]);
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
const productTypeOptions = ref([]);
const roleOptions = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `应用名称`, visible: true },
   { key: 1, label: `应用描述`, visible: true },
   { key: 2, label: `授权地址`, visible: true },
   { key: 3, label: `应用状态`, visible: true },
   { key: 4, label: `是否公开`, visible: true },
   { key: 5, label: `状态`, visible: true },
   { key: 6, label: `添加时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      name: undefined,
      productBrief: undefined
   },
   rules: {
      name: [{ required: true, message: "应用名称不能为空", trigger: "blur" }] ,
      productBrief: [{ required: true, message: "应用介绍不能为空", trigger: "blur" }],
      linkPath: [{ required: true, message: "授权地址不能为空", trigger: "blur" }] ,
      prodStatus: [{ required: true , message: "应用状态不能为空", trigger: "blur"}],
      productTypeId: [{ required: true , message: "产品类型", trigger: "blur"}],
      isPublic: [{ required: true, message: "是否公开不能为空", trigger: "blur" }] ,
      productDescribe: [{ required: false, message: "备注不能为空", trigger: "blur" }]
   },
   prodStatusOptions: [
    {key: "normal", label: "正常",cantSelect: false},
    {key: "internal", label: "内测",cantSelect: false},
    {key: "public", label: "公测",cantSelect: false},
  ],
});

const { queryParams, form, rules, prodStatusOptions } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listProductItem(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ProductItemList.value = res.rows;
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
   const ProductItemIds = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除应用编号为"' + ProductItemIds + '"的数据项？').then(function () {
      return delProductItem(ProductItemIds);
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
      productBrief: undefined,
      linkPath: undefined,
      prodStatus: undefined,
      isPublic: undefined,
      productDescribe: undefined,
   };
   proxy.resetForm("productItemRef");
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
   getProductItem(ProductItemId).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 查询所有类型列表 */
function handleAllProductType() {
   getAllProductType().then(response => {
      productTypeOptions.value = response.data;
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["productItemRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateProductItem(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addProductItem(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

function isPublicTrans(value) {
  switch (value) {
    case 0:
      return "不公开";
    case 1:
      return "公开";
    default:
      return "公开";
  }
}

function prodStatusTrans(value) {
  switch (value) {
    case "normal":
      return "正常";
    case "internal":
      return "内测";
    case "public":
      return "公测";
    default:
      return "正常";
  }
}


/** 状态修改**/
function handleStatusChange(row) {
  return changeProductStatus(row.id, row.hasStatus).then(response=>{
    if(response.code == 200){
      proxy.$modal.msgSuccess("操作成功");
      getList();
    }
  });
};

handleAllProductType() ;
getList();

</script>
