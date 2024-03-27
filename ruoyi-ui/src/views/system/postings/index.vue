<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="" prop="unitName">
        <el-input
          v-model="queryParams.unitName"
          placeholder="请输入用人单位名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="jobTitle">
        <el-input
          v-model="queryParams.jobTitle"
          placeholder="请输入招录岗位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="jobCode">
        <el-input
          v-model="queryParams.jobCode"
          placeholder="请输入岗位代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="jobCategory">
        <el-input
          v-model="queryParams.jobCategory"
          placeholder="请输入岗位类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option label="男" value="男"/>
          <el-option label="女" value="女"/>
        </el-select>
      </el-form-item>
      <!--学历-->
      <el-form-item label="" prop="minEducation">
        <el-input
          v-model="queryParams.minEducation"
          placeholder="请输入学历类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="workLocation">
        <el-input
          v-model="queryParams.workLocation"
          placeholder="请输入工作地点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="major">
        <el-input
          v-model="queryParams.major"
          placeholder="请输入所学专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['bussiness:recruitment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bussiness:recruitment:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入
        </el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="recruitmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用人单位名称" align="center" prop="unitName" />
      <el-table-column label="招录岗位" align="center" prop="jobTitle" />
      <el-table-column label="岗位代码" align="center" prop="jobCode" />
      <el-table-column label="招录数量" align="center" prop="vacancies" />
      <el-table-column label="面试比例" align="center" prop="interviewRatio" />
      <el-table-column label="岗位类型" align="center" prop="jobCategory" />
      <el-table-column label="岗位等级" align="center" prop="jobLevel" />
      <el-table-column label="从事工作描述" align="center" prop="jobDescription" />
      <el-table-column label="最低学历要求" align="center" prop="minEducation" />
      <el-table-column label="户籍所在地要求" align="center" prop="householdRegistrationLocation" />
      <el-table-column label="性别要求" align="center" prop="gender" />
      <el-table-column label="工作地点" align="center" prop="workLocation" />
      <el-table-column label="考试科目" align="center" prop="examSubjects" />
      <el-table-column label="招聘来源" align="center" prop="recruitmentSource" />
      <el-table-column label="其他条件" align="center" prop="otherRequirements" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改技能岗位计划对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用人单位名称" prop="unitName">
          <el-input v-model="form.unitName" placeholder="请输入用人单位名称" />
        </el-form-item>
        <el-form-item label="招录岗位" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入招录岗位" />
        </el-form-item>
        <el-form-item label="岗位代码" prop="jobCode">
          <el-input v-model="form.jobCode" placeholder="请输入岗位代码" />
        </el-form-item>
        <el-form-item label="招录数量" prop="vacancies">
          <el-input v-model="form.vacancies" placeholder="请输入招录数量" />
        </el-form-item>
        <el-form-item label="面试比例" prop="interviewRatio">
          <el-input v-model="form.interviewRatio" placeholder="请输入面试比例" />
        </el-form-item>
        <el-form-item label="岗位类型" prop="jobCategory">
          <el-input v-model="form.jobCategory" placeholder="请输入岗位类型" />
        </el-form-item>
        <el-form-item label="岗位等级" prop="jobLevel">
          <el-input v-model="form.jobLevel" placeholder="请输入岗位等级" />
        </el-form-item>
        <el-form-item label="从事工作描述" prop="jobDescription">
          <el-input v-model="form.jobDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="最低学历要求" prop="minEducation">
          <el-input v-model="form.minEducation" placeholder="请输入最低学历要求" />
        </el-form-item>
        <el-form-item label="专业要求" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业要求" />
        </el-form-item>
        <el-form-item label="职业技能资格要求" prop="vocationalSkillQualification">
          <el-input v-model="form.vocationalSkillQualification" placeholder="请输入职业技能资格要求" />
        </el-form-item>
        <el-form-item label="户籍所在地要求" prop="householdRegistrationLocation">
          <el-input v-model="form.householdRegistrationLocation" placeholder="请输入户籍所在地要求" />
        </el-form-item>
        <el-form-item label="性别要求" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别要求" />
        </el-form-item>
        <el-form-item label="其他条件" prop="otherRequirements">
          <el-input v-model="form.otherRequirements" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作地点" prop="workLocation">
          <el-input v-model="form.workLocation" placeholder="请输入工作地点" />
        </el-form-item>
        <el-form-item label="重要说明" prop="importantNotes">
          <el-input v-model="form.importantNotes" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="考试科目" prop="examSubjects">
          <el-input v-model="form.examSubjects" placeholder="请输入考试科目" />
        </el-form-item>
        <el-form-item label="招聘来源" prop="recruitmentSource">
          <el-input v-model="form.recruitmentSource" placeholder="请输入招聘来源" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport"/>
            是否更新已经存在的数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                   @click="importTemplate">下载模板
          </el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRecruitment, getRecruitment, delRecruitment, addRecruitment, updateRecruitment } from "@/api/bussiness/recruitment";
import {getToken} from "@/utils/auth";

export default {
  name: "Recruitment",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 技能岗位计划表格数据
      recruitmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        unitName: null,
        jobTitle: null,
        jobCode: null,
        vacancies: null,
        interviewRatio: null,
        jobCategory: null,
        jobLevel: null,
        jobDescription: null,
        minEducation: null,
        major: null,
        vocationalSkillQualification: null,
        householdRegistrationLocation: null,
        gender: null,
        otherRequirements: null,
        workLocation: null,
        importantNotes: null,
        maritalStatus: null,
        examSubjects: null,
        recruitmentSource: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      upload: {
        // 是否显示弹出层（导入）
        open: false,
        // 弹出层标题（导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/bussiness/recruitment/importData"
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询技能岗位计划列表 */
    getList() {
      this.loading = true;
      listRecruitment(this.queryParams).then(response => {
        this.recruitmentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        unitName: null,
        jobTitle: null,
        jobCode: null,
        vacancies: null,
        interviewRatio: null,
        jobCategory: null,
        jobLevel: null,
        jobDescription: null,
        minEducation: null,
        major: null,
        vocationalSkillQualification: null,
        householdRegistrationLocation: null,
        gender: null,
        otherRequirements: null,
        workLocation: null,
        importantNotes: null,
        maritalStatus: null,
        examSubjects: null,
        recruitmentSource: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.unitName)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加技能岗位计划";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.form  = row;
      this.open = true;
      this.title = "修改技能岗位计划";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.unitName != null) {
            updateRecruitment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecruitment(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const unitNames = row.unitName || this.ids;
      this.$modal.confirm('是否确认删除技能岗位计划编号为"' + unitNames + '"的数据项？').then(function() {
        return delRecruitment(unitNames);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bussiness/recruitment/export', {
        ...this.queryParams
      }, `recruitment_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('bussiness/recruitment/importTemplate', {}, `stu_base_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", {dangerouslyUseHTMLString: true});
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
