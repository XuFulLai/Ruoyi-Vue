package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 历年岗位信息对象 history_recruitment
 * 
 * @author ruoyi
 * @date 2024-03-03
 */
public class HistoryRecruitment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 年份 */
    @Excel(name = "年份")
    private String year;

    /** 岗位代码 */
    @Excel(name = "岗位代码")
    private String jobCode;

    /** 用人单位序号 */
    @Excel(name = "用人单位序号")
    private String unitSerialNumber;

    @Excel(name = "用人单位名称")
    private String unitName;

    /** 岗位类别 */
    @Excel(name = "岗位类别")
    private String jobCategory;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String jobTitle;

    /** 从事工作 */
    @Excel(name = "从事工作")
    private String jobDescription;

    /** 招考数量 */
    @Excel(name = "招考数量")
    private Long vacancies;

    /** 入围比例 */
    @Excel(name = "入围比例")
    private String qualifyingRatio;

    /** 来源类别 */
    @Excel(name = "来源类别")
    private String sourceCategory;

    /** 学历 */
    @Excel(name = "学历")
    private String educationLevel;

    /** 学位 */
    @Excel(name = "学位")
    private String degree;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 考试专业科目 */
    @Excel(name = "考试专业科目")
    private String examSubjects;

    /** 职称-高校毕业生 */
    @Excel(name = "职称-高校毕业生")
    private String academicTitleGraduate;

    /** 职称-社会人才 */
    @Excel(name = "职称-社会人才")
    private String academicTitleProfessional;

    /** 职业资格-高校毕业生 */
    @Excel(name = "职业资格-高校毕业生")
    private String vocationalQualificationGraduate;

    /** 职业资格-社会人才 */
    @Excel(name = "职业资格-社会人才")
    private String vocationalQualificationProfessional;

    /** 其他条件 */
    @Excel(name = "其他条件")
    private String otherRequirements;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workLocation;

    /** 咨询电话 */
    @Excel(name = "咨询电话")
    private String contactNumber;

    /** 面试/补录 */
    @Excel(name = "面试/补录")
    private String interviewSupplement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getYear()
    {
        return year;
    }
    public void setJobCode(String jobCode)
    {
        this.jobCode = jobCode;
    }

    public String getJobCode()
    {
        return jobCode;
    }
    public void setUnitSerialNumber(String unitSerialNumber)
    {
        this.unitSerialNumber = unitSerialNumber;
    }

    public String getUnitSerialNumber()
    {
        return unitSerialNumber;
    }
    public void setJobCategory(String jobCategory)
    {
        this.jobCategory = jobCategory;
    }

    public String getJobCategory()
    {
        return jobCategory;
    }
    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }
    public void setJobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription()
    {
        return jobDescription;
    }
    public void setVacancies(Long vacancies)
    {
        this.vacancies = vacancies;
    }

    public Long getVacancies()
    {
        return vacancies;
    }
    public void setQualifyingRatio(String qualifyingRatio)
    {
        this.qualifyingRatio = qualifyingRatio;
    }

    public String getQualifyingRatio()
    {
        return qualifyingRatio;
    }
    public void setSourceCategory(String sourceCategory)
    {
        this.sourceCategory = sourceCategory;
    }

    public String getSourceCategory()
    {
        return sourceCategory;
    }
    public void setEducationLevel(String educationLevel)
    {
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel()
    {
        return educationLevel;
    }
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getDegree()
    {
        return degree;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setExamSubjects(String examSubjects)
    {
        this.examSubjects = examSubjects;
    }

    public String getExamSubjects()
    {
        return examSubjects;
    }
    public void setAcademicTitleGraduate(String academicTitleGraduate)
    {
        this.academicTitleGraduate = academicTitleGraduate;
    }

    public String getAcademicTitleGraduate()
    {
        return academicTitleGraduate;
    }
    public void setAcademicTitleProfessional(String academicTitleProfessional)
    {
        this.academicTitleProfessional = academicTitleProfessional;
    }

    public String getAcademicTitleProfessional()
    {
        return academicTitleProfessional;
    }
    public void setVocationalQualificationGraduate(String vocationalQualificationGraduate)
    {
        this.vocationalQualificationGraduate = vocationalQualificationGraduate;
    }

    public String getVocationalQualificationGraduate()
    {
        return vocationalQualificationGraduate;
    }
    public void setVocationalQualificationProfessional(String vocationalQualificationProfessional)
    {
        this.vocationalQualificationProfessional = vocationalQualificationProfessional;
    }

    public String getVocationalQualificationProfessional()
    {
        return vocationalQualificationProfessional;
    }
    public void setOtherRequirements(String otherRequirements)
    {
        this.otherRequirements = otherRequirements;
    }

    public String getOtherRequirements()
    {
        return otherRequirements;
    }
    public void setWorkLocation(String workLocation)
    {
        this.workLocation = workLocation;
    }

    public String getWorkLocation()
    {
        return workLocation;
    }
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }
    public void setInterviewSupplement(String interviewSupplement)
    {
        this.interviewSupplement = interviewSupplement;
    }

    public String getInterviewSupplement()
    {
        return interviewSupplement;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("year", getYear())
                .append("jobCode", getJobCode())
                .append("unitSerialNumber", getUnitSerialNumber())
                .append("jobCategory", getJobCategory())
                .append("jobTitle", getJobTitle())
                .append("jobDescription", getJobDescription())
                .append("vacancies", getVacancies())
                .append("qualifyingRatio", getQualifyingRatio())
                .append("sourceCategory", getSourceCategory())
                .append("educationLevel", getEducationLevel())
                .append("degree", getDegree())
                .append("major", getMajor())
                .append("examSubjects", getExamSubjects())
                .append("academicTitleGraduate", getAcademicTitleGraduate())
                .append("academicTitleProfessional", getAcademicTitleProfessional())
                .append("vocationalQualificationGraduate", getVocationalQualificationGraduate())
                .append("vocationalQualificationProfessional", getVocationalQualificationProfessional())
                .append("otherRequirements", getOtherRequirements())
                .append("workLocation", getWorkLocation())
                .append("contactNumber", getContactNumber())
                .append("interviewSupplement", getInterviewSupplement())
                .toString();
    }
}
