<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
              <el-form-item label="标题" prop="title">
                <el-input v-model="queryParams.title" placeholder="请输入标题" clearable style="width: 240px" @keyup.enter="handleQuery" />
              </el-form-item>
               <el-form-item label="建议内容" prop="problemDesc">
                  <el-input v-model="queryParams.problemDesc" placeholder="请输入建议内容" clearable style="width: 240px" @keyup.enter="handleQuery" />
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

            <el-table v-loading="loading" :data="FeedBackList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="50" align="center" />

               <!-- 业务字段-->
               <el-table-column label="创建者"   align="center" key="accountId" width="100" prop="accountId" v-if="columns[0].visible" :show-overflow-tooltip="true">
                 <template #default="scope">
                    <div>
                       <img style="width:30px; height:30px" :src="'http://data.linesno.com/icons/product/' + (scope.$index + 1) + '.png'" />
                    </div>
                 </template>
               </el-table-column>

               <el-table-column label="建议内容" align="left" key="problemDesc" prop="problemDesc" v-if="columns[2].visible" :show-overflow-tooltip="true" />
               <el-table-column label="评价级别" align="center" key="grade" prop="grade" width="100" v-if="columns[1].visible" :show-overflow-tooltip="true" />
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
                           v-hasPermi="['system:FeedBack:edit']"></el-button>
                     </el-tooltip>
                     <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:FeedBack:remove']"></el-button>
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
                  <el-form-item label="标题" prop="title">
                     <el-input v-model="form.title"  placeholder="请输入标题" maxlength="255" />
                  </el-form-item>
               </el-col>
            </el-row>
            <el-row>
             <el-col :span="24">
               <el-form-item label="建议内容" prop="problemDesc">
                 <el-input v-model="form.problemDesc" type="textarea" placeholder="请输入建议内容" maxlength="255" />
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

<script setup name="FeedBack">

import {
  listSuggest,
  delSuggest,
  getSuggest,
  updateSuggest,
  addSuggest
} from "@/api/base/platform/suggest.js";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable, sys_user_sex } = proxy.useDict("sys_normal_disable", "sys_user_sex");

// 定义变量
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const titles = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const FeedBackList  = ref([]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `创建者`, visible: true },
   { key: 1, label: `建议标题`, visible: true },
   { key: 2, label: `建议内容`, visible: true },
   { key: 3, label: `添加时间`, visible: true },
]);


const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      accountId: undefined,
      title: undefined,
      problemDesc: undefined
   },
   rules: {
      title: [{ required: true, message: "标题不能为空", trigger: "blur" }] ,
      problemDesc: [{ required: true, message: "建议内容不能为空", trigger: "blur" }]
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询产品列表 */

/** 查询应用列表 */
function getList() {
   loading.value = true;
  listSuggest(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      FeedBackList.value = res.rows;
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
   const tmpTitles = row.title || titles.value;
   proxy.$modal.confirm('是否确认删除标题为"' + tmpTitles + '"的数据项？').then(function () {
      return delSuggest(tmpIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   titles.value = selection.map(item => item.title);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      creatorId: undefined,
      title: undefined,
      problemDesc: undefined
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
   title.value = "添加建议反馈";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const id = row.id || ids.value;
   getSuggest(id).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改建议反馈";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.id != undefined) {
            updateSuggest(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addSuggest(form.value).then(response => {
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
