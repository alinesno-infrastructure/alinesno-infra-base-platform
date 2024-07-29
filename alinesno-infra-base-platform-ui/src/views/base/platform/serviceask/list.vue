<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
              <el-form-item label="咨询标题" prop="askTitle">
                <el-input v-model="queryParams['condition[askTitle|like]']" placeholder="请输入咨询标题" clearable style="width: 240px" @keyup.enter="handleQuery" />
              </el-form-item>
               <el-form-item label="咨询内容" prop="askText">
                  <el-input v-model="queryParams['condition[askText|like]']" placeholder="请输入咨询内容" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="ServiceAskList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />
               <!-- 业务字段-->
               <el-table-column label="创建者"   align="center" key="creatorId" prop="creatorId" v-if="columns[0].visible" :show-overflow-tooltip="true" />
               <el-table-column label="咨询标题" align="center" key="askTitle" prop="askTitle" v-if="columns[1].visible" :show-overflow-tooltip="true" />
               <el-table-column label="咨询内容" align="center" key="askText" prop="askText" v-if="columns[2].visible" :show-overflow-tooltip="true" />
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
                           v-hasPermi="['system:ServiceAsk:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:ServiceAsk:remove']"></el-button>
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
                  <el-form-item label="咨询标题" prop="askTitle">
                     <el-input v-model="form.askTitle" placeholder="请输入咨询标题" maxlength="255" />
                  </el-form-item>
               </el-col>
            </el-row>
            <el-row>
             <el-col :span="24">
               <el-form-item label="咨询内容" prop="askText">
                 <el-input v-model="form.askText" type="textarea" placeholder="请输入咨询内容" maxlength="255" />
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

<script setup name="ServiceAsk">

import {
   listServiceAsk,
   delServiceAsk,
   getServiceAsk,
   updateServiceAsk,
   addServiceAsk
} from "@/api/base/platform/ServiceAsk.js";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const askTitles = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const ServiceAskList  = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `创建者`, visible: true },
   { key: 1, label: `咨询标题`, visible: true },
   { key: 2, label: `咨询内容`, visible: true },
   { key: 3, label: `添加时间`, visible: true },
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      creatorId: undefined,
      askTitle: undefined,
      askText: undefined
   },
   rules: {
      askTitle: [{ required: true, message: "产品名称不能为空", trigger: "blur" }] ,
      askText: [{ required: true, message: "评价内容不能为空", trigger: "blur" }]
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询产品列表 */

/** 查询应用列表 */
function getList() {
   loading.value = true;
  listServiceAsk(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      ServiceAskList.value = res.rows;
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
   const tmpAskTitles = row.askTitle || askTitles.value;
   proxy.$modal.confirm('是否确认删除咨询标题为"' + tmpAskTitles + '"的数据项？').then(function () {
      return delServiceAsk(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   askTitles.value = selection.map(item => item.askTitle);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      creatorId: undefined,
      askTitle: undefined,
      askText: undefined
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
   title.value = "添加咨询信息";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const id = row.id || ids.value;
   getServiceAsk(id).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改咨询信息";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateServiceAsk(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addServiceAsk(form.value).then(response => {
               proxy.$modal.msgSuccess("新增成功");
               open.value = false;
               getList();
            });
         }
      }
   });
};

function ServiceAskTrans(ServiceAskId) {

  var productName = '' ;
  ServiceAskList.value.filter((item) => {
    if ( item.id === ServiceAskId)
    {
      productName = item.name
    }
  });

  return productName ;

}

getList();

</script>
