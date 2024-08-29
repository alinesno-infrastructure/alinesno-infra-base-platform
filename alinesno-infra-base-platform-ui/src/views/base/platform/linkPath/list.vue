<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
              <el-form-item label="链接名称" prop="linkName">
                <el-input v-model="queryParams.linkName" placeholder="请输入链接名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
              </el-form-item>
               <el-form-item label="链接描述" prop="linkDesc">
                  <el-input v-model="queryParams['condition[linkDesc|like]']" placeholder="请输入链接描述" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="LinkPathList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <!-- 业务字段-->
               <el-table-column label="链接名称"   align="center" key="linkName" prop="linkName" v-if="columns[0].visible" :show-overflow-tooltip="true" />
               <el-table-column label="链接地址" align="center" key="linkPath" prop="linkPath" v-if="columns[1].visible" :show-overflow-tooltip="true" />
               <el-table-column label="链接描述" align="center" key="linkDesc" prop="linkDesc" v-if="columns[2].visible" :show-overflow-tooltip="true" />
               <el-table-column label="链接排序"   align="center" key="linkSort" prop="linkSort" v-if="columns[3].visible" :show-overflow-tooltip="true" />
               <el-table-column label="状态" prop="hasStatus" align="left" placeholder="0:禁用,1:开启" :width=80 v-if="columns[4].visible">
                <template #default="scope">
                  <el-switch
                      v-model="scope.row.hasStatus"
                      :active-value=0
                      :inactive-value=1
                      @change="handleStatusChange(scope.row)"
                  ></el-switch>
                </template>
               </el-table-column>
               <el-table-column label="添加时间" align="center" prop="addTime" v-if="columns[5].visible" width="160">
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.addTime) }}</span>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="修改" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:LinkPath:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:LinkPath:remove']"></el-button>
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
               <el-form-item label="链接名称" prop="linkName">
                 <el-input v-model="form.linkName"   placeholder="请输入链接名称" maxlength="255" />
               </el-form-item>
             </el-col>
           </el-row>
           <el-row>
             <el-col :span="24">
               <el-form-item label="链接地址" prop="linkPath">
                 <el-input v-model="form.linkPath" type="textarea" placeholder="请输入链接地址" maxlength="255" />
               </el-form-item>
             </el-col>
           </el-row>
           <el-row>
             <el-col :span="24">
               <el-form-item label="链接描述" prop="linkDesc">
                 <el-input v-model="form.linkDesc" type="textarea" placeholder="请输入链接地址" maxlength="255" />
               </el-form-item>
             </el-col>
           </el-row>
           <el-row>
             <el-col :span="24">
               <el-form-item label="链接排序" prop="linkDesc">
                 <el-input type="number" v-model="form.linkSort"   placeholder="请输入链接排序" maxlength="255" />
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

<script setup name="LinkPath">

import {
  listLinkPath,
  delLinkPath,
  getLinkPath,
  updateLinkPath,
  addLinkPath, changeLinkStatus
} from "@/api/base/platform/LinkPath.js";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const linkNames = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const LinkPathList  = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `链接名称`, visible: true },
   { key: 1, label: `链接地址`, visible: true },
   { key: 2, label: `链接描述`, visible: true },
   { key: 3, label: `链接排序`, visible: true },
   { key: 4, label: `状态`, visible: true },
   { key: 5, label: `添加时间`, visible: true },
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      linkName: undefined,
      linkPath: undefined,
      linkDesc: undefined,
      linkSort: undefined
   },
   rules: {
      linkName: [{ required: true, message: "链接名称不能为空", trigger: "blur" }] ,
      linkPath: [{ required: true, message: "链接地址不能为空", trigger: "blur" }] ,
      linkDesc: [{ required: false, message: "链接链接描述不能为空", trigger: "blur" }] ,
      linkSort: [{ required: false, message: "链接排序不能为空", trigger: "blur" }]
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询产品列表 */

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listLinkPath(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      LinkPathList.value = res.rows;
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
   const tmpLinkNames = row.linkName || linkNames.value;
   proxy.$modal.confirm('是否确认删除标题为"' + tmpLinkNames + '"的数据项？').then(function () {
      return delLinkPath(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   linkNames.value = selection.map(item => item.linkName);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      linkName: undefined,
      linkPath: undefined,
      linkDesc: undefined,
      linkSort: undefined
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
   title.value = "添加友情链接";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const id = row.id || ids.value;
   getLinkPath(id).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改友情链接";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateLinkPath(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addLinkPath(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

function LinkPathTrans(LinkPathId) {

  var productName = '' ;
  LinkPathList.value.filter((item) => {
    if ( item.id === LinkPathId)
    {
      productName = item.name
    }
  });

  return productName ;

}

/** 状态修改**/
function handleStatusChange(row) {
  return changeLinkStatus(row.id, row.hasStatus).then(response=>{
    if(response.code == 200){
      proxy.$modal.msgSuccess("操作成功");
      getList();
    }
  });
};

getList();

</script>
