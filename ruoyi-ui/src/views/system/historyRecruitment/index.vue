<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="" prop="jobCode">
        <el-input
          v-model="queryParams.jobCode"
          placeholder="请输入岗位代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="year">
        <el-date-picker clearable
                        v-model="queryParams.year"
                        type="year"
                        value-format="yyyy"
                        placeholder="请选择时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="" prop="jobCategory">
        <el-input
          v-model="queryParams.jobCategory"
          placeholder="请输入岗位类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="jobTitle">
        <el-input
          v-model="queryParams.jobTitle"
          placeholder="请输入岗位名称"
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
      <el-form-item label="" prop="educationLevel">
        <el-input
          v-model="queryParams.educationLevel"
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
      <el-form-item label="" prop="contactNumber">
        <el-input
          v-model="queryParams.contactNumber"
          placeholder="请输入咨询电话"
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
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出
        </el-button>
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

    <el-table v-loading="loading" :data="historyRecruitmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="时间" align="center" prop="year" width="60"/>
      <el-table-column label="岗位代码" align="center" prop="jobCode"/>
      <el-table-column label="用人单位及招考岗位" align="center" prop="">
        <el-table-column label="用人单位序号" align="center" prop="unitSerialNumber"/>
        <el-table-column label="用人单位名称" align="center" prop="unitName"/>
        <el-table-column label="岗位类别" align="center" prop="jobCategory"/>
        <el-table-column label="岗位名称" align="center" prop="jobTitle"/>
        <el-table-column label="从事工作" align="center" prop="jobDescription"/>
        <el-table-column label="招考数量" align="center" prop="vacancies"/>
        <el-table-column label="入围比例" align="center" prop="qualifyingRatio"/>
      </el-table-column>
      <el-table-column label="招考条件" align="center" prop="">
        <el-table-column label="学历" align="center" prop="educationLevel"/>
        <el-table-column label="所学专业" align="center" prop="major"/>
        <el-table-column label="考试专业科目" align="center" prop="examSubjects"/>
      </el-table-column>
      <el-table-column label="工作地点" align="center" prop="workLocation"/>
      <el-table-column label="咨询电话" align="center" prop="contactNumber"/>
      <el-table-column label="面试/补录" align="center" prop="interviewSupplement"/>
      <el-table-column label="来源类别" align="center" prop="sourceCategory"/>
      <el-table-column label="学位" align="center" prop="degree"/>
      <el-table-column label="职称" align="center" prop="academicTitleGraduate">
        <el-table-column label="高校毕业生" align="center" prop="academicTitleGraduate"/>
        <el-table-column label="社会人才" align="center" prop="academicTitleProfessional"/>
      </el-table-column>
      <el-table-column label="职业资格" align="center" prop="">
        <el-table-column label="高校毕业生" align="center" prop="vocationalQualificationGraduate"></el-table-column>
        <el-table-column label="社会人才" align="center" prop="vocationalQualificationProfessional"></el-table-column>
      </el-table-column>
      <el-table-column label="其他条件" align="center" prop="otherRequirements"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除
          </el-button>
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

    <!-- 添加或修改历年岗位信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="岗位代码" prop="jobCode">
          <el-input v-model="form.jobCode" placeholder="请输入岗位代码"/>
        </el-form-item>
        <el-form-item label="时间" prop="year">
          <el-date-picker clearable
                          v-model="form.year"
                          type="year"
                          value-format="yyyy"
                          placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用人单位序号" prop="unitSerialNumber">
          <el-input v-model="form.unitSerialNumber" placeholder="请输入用人单位序号"/>
        </el-form-item>
        <el-form-item label="岗位类别" prop="jobCategory">
          <el-input v-model="form.jobCategory" placeholder="请输入岗位类别"/>
        </el-form-item>
        <el-form-item label="岗位名称" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入岗位名称"/>
        </el-form-item>
        <el-form-item label="从事工作" prop="jobDescription">
          <el-input v-model="form.jobDescription" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="招考数量" prop="vacancies">
          <el-input v-model="form.vacancies" placeholder="请输入招考数量"/>
        </el-form-item>
        <el-form-item label="入围比例" prop="qualifyingRatio">
          <el-input v-model="form.qualifyingRatio" placeholder="请输入入围比例"/>
        </el-form-item>
        <el-form-item label="来源类别" prop="sourceCategory">
          <el-input v-model="form.sourceCategory" placeholder="请输入来源类别"/>
        </el-form-item>
        <el-form-item label="学历" prop="educationLevel">
          <el-input v-model="form.educationLevel" placeholder="请输入学历"/>
        </el-form-item>
        <el-form-item label="学位" prop="degree">
          <el-input v-model="form.degree" placeholder="请输入学位"/>
        </el-form-item>
        <el-form-item label="所学专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入所学专业"/>
        </el-form-item>
        <el-form-item label="考试专业科目" prop="examSubjects">
          <el-input v-model="form.examSubjects" placeholder="请输入考试专业科目"/>
        </el-form-item>
        <el-form-item label="职称-高校毕业生" prop="academicTitleGraduate">
          <el-input v-model="form.academicTitleGraduate" placeholder="请输入职称-高校毕业生"/>
        </el-form-item>
        <el-form-item label="职称-社会人才" prop="academicTitleProfessional">
          <el-input v-model="form.academicTitleProfessional" placeholder="请输入职称-社会人才"/>
        </el-form-item>
        <el-form-item label="职业资格-高校毕业生" prop="vocationalQualificationGraduate">
          <el-input v-model="form.vocationalQualificationGraduate" placeholder="请输入职业资格-高校毕业生"/>
        </el-form-item>
        <el-form-item label="职业资格-社会人才" prop="vocationalQualificationProfessional">
          <el-input v-model="form.vocationalQualificationProfessional" placeholder="请输入职业资格-社会人才"/>
        </el-form-item>
        <el-form-item label="其他条件" prop="otherRequirements">
          <el-input v-model="form.otherRequirements" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="工作地点" prop="workLocation">
          <el-input v-model="form.workLocation" placeholder="请输入工作地点"/>
        </el-form-item>
        <el-form-item label="咨询电话" prop="contactNumber">
          <el-input v-model="form.contactNumber" placeholder="请输入咨询电话"/>
        </el-form-item>
        <el-form-item label="面试/补录" prop="interviewSupplement">
          <el-input v-model="form.interviewSupplement" placeholder="请输入面试/补录"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 用户导入对话框 -->
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
            是否更新已经存在的用户数据
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
import {
  listHistoryRecruitment,
  getHistoryRecruitment,
  delHistoryRecruitment,
  addHistoryRecruitment,
  updateHistoryRecruitment
} from "@/api/bussiness/historyRecruitment";
import {getToken} from "@/utils/auth"

export default {
  name: "HistoryRecruitment",
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
      // 历年岗位信息表格数据
      historyRecruitmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        jobCode: null,
        year: null,
        unitSerialNumber: null,
        jobCategory: null,
        jobTitle: null,
        jobDescription: null,
        vacancies: null,
        qualifyingRatio: null,
        sourceCategory: null,
        educationLevel: null,
        degree: null,
        major: null,
        examSubjects: null,
        academicTitleGraduate: null,
        academicTitleProfessional: null,
        vocationalQualificationGraduate: null,
        vocationalQualificationProfessional: null,
        otherRequirements: null,
        workLocation: null,
        contactNumber: null,
        interviewSupplement: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/historyRecruitment/importData"
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询历年岗位信息列表 */
    getList() {
      this.loading = true;
      listHistoryRecruitment(this.queryParams).then(response => {
        this.historyRecruitmentList = response.rows;
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
        id: null,
        jobCode: null,
        year: null,
        unitSerialNumber: null,
        jobCategory: null,
        jobTitle: null,
        jobDescription: null,
        vacancies: null,
        qualifyingRatio: null,
        sourceCategory: null,
        educationLevel: null,
        degree: null,
        major: null,
        examSubjects: null,
        academicTitleGraduate: null,
        academicTitleProfessional: null,
        vocationalQualificationGraduate: null,
        vocationalQualificationProfessional: null,
        otherRequirements: null,
        workLocation: null,
        contactNumber: null,
        interviewSupplement: null
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
      this.ids = selection.map(item => item.jobCode)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加历年岗位信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.form = row;
      this.open = true;
      this.title = "修改管理岗计划";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.jobCode != null) {
            updateHistoryRecruitment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHistoryRecruitment(this.form).then(response => {
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
      const jobCodes = row.jobCode || this.ids;
      this.$modal.confirm('是否确认删除历年岗位信息编号为"' + jobCodes + '"的数据项？').then(function () {
        return delHistoryRecruitment(jobCodes);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/historyRecruitment/export', {
        ...this.queryParams
      }, `historyRecruitment_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "数据导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/historyRecruitment/importTemplate', {}, `stu_base_template_${new Date().getTime()}.xlsx`)
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
