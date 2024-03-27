package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技能岗位计划对象 recruitment
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
public class Recruitment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 用人单位 */
    @Excel(name = "用人单位")
    private String unitName;

    /** 招录岗位 */
    @Excel(name = "招录岗位")
    private String jobTitle;

    /** 岗位代码 */
    @Excel(name = "岗位代码")
    private String jobCode;

    /** 招录数量 */
    @Excel(name = "招录数量")
    private Long vacancies;

    /** 面试比例 */
    @Excel(name = "面试比例")
    private String interviewRatio;

    /** 岗位类型 */
    @Excel(name = "岗位类型")
    private String jobCategory;

    /** 岗位等级 */
    @Excel(name = "岗位等级")
    private String jobLevel;

    /** 从事工作 */
    @Excel(name = "从事工作")
    private String jobDescription;

    /** 最低学历 */
    @Excel(name = "最低学历")
    private String minEducation;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 职业技能资格要求 */
    @Excel(name = "职业技能资格要求")
    private String vocationalSkillQualification;

    /** 户籍所在地要求 */
    @Excel(name = "户籍所在地要求")
    private String householdRegistrationLocation;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 其他条件 */
    @Excel(name = "其他条件")
    private String otherRequirements;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workLocation;

    /** 重要说明 */
    @Excel(name = "重要说明")
    private String importantNotes;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String maritalStatus;

    /** 考试科目 */
    @Excel(name = "考试科目")
    private String examSubjects;

    /** 招聘来源 */
    @Excel(name = "招聘来源")
    private String recruitmentSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }

    public String getUnitName()
    {
        return unitName;
    }
    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }
    public void setJobCode(String jobCode)
    {
        this.jobCode = jobCode;
    }

    public String getJobCode()
    {
        return jobCode;
    }
    public void setVacancies(Long vacancies)
    {
        this.vacancies = vacancies;
    }

    public Long getVacancies()
    {
        return vacancies;
    }
    public void setInterviewRatio(String interviewRatio)
    {
        this.interviewRatio = interviewRatio;
    }

    public String getInterviewRatio()
    {
        return interviewRatio;
    }
    public void setJobCategory(String jobCategory)
    {
        this.jobCategory = jobCategory;
    }

    public String getJobCategory()
    {
        return jobCategory;
    }
    public void setJobLevel(String jobLevel)
    {
        this.jobLevel = jobLevel;
    }

    public String getJobLevel()
    {
        return jobLevel;
    }
    public void setJobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription()
    {
        return jobDescription;
    }
    public void setMinEducation(String minEducation)
    {
        this.minEducation = minEducation;
    }

    public String getMinEducation()
    {
        return minEducation;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setVocationalSkillQualification(String vocationalSkillQualification)
    {
        this.vocationalSkillQualification = vocationalSkillQualification;
    }

    public String getVocationalSkillQualification()
    {
        return vocationalSkillQualification;
    }
    public void setHouseholdRegistrationLocation(String householdRegistrationLocation)
    {
        this.householdRegistrationLocation = householdRegistrationLocation;
    }

    public String getHouseholdRegistrationLocation()
    {
        return householdRegistrationLocation;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
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
    public void setImportantNotes(String importantNotes)
    {
        this.importantNotes = importantNotes;
    }

    public String getImportantNotes()
    {
        return importantNotes;
    }
    public void setMaritalStatus(String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus()
    {
        return maritalStatus;
    }
    public void setExamSubjects(String examSubjects)
    {
        this.examSubjects = examSubjects;
    }

    public String getExamSubjects()
    {
        return examSubjects;
    }
    public void setRecruitmentSource(String recruitmentSource)
    {
        this.recruitmentSource = recruitmentSource;
    }

    public String getRecruitmentSource()
    {
        return recruitmentSource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("unitName", getUnitName())
                .append("jobTitle", getJobTitle())
                .append("jobCode", getJobCode())
                .append("vacancies", getVacancies())
                .append("interviewRatio", getInterviewRatio())
                .append("jobCategory", getJobCategory())
                .append("jobLevel", getJobLevel())
                .append("jobDescription", getJobDescription())
                .append("minEducation", getMinEducation())
                .append("major", getMajor())
                .append("vocationalSkillQualification", getVocationalSkillQualification())
                .append("householdRegistrationLocation", getHouseholdRegistrationLocation())
                .append("gender", getGender())
                .append("otherRequirements", getOtherRequirements())
                .append("workLocation", getWorkLocation())
                .append("importantNotes", getImportantNotes())
                .append("maritalStatus", getMaritalStatus())
                .append("examSubjects", getExamSubjects())
                .append("recruitmentSource", getRecruitmentSource())
                .toString();
    }
}
