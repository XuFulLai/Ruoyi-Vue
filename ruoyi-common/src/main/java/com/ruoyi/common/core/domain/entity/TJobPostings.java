package com.ruoyi.common.core.domain.entity;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_job_postings
 *
 * @author ruoyi
 * @date 2024-02-29
 */
public class TJobPostings extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 岗位ID
     */
    private Long id;

    /**
     * 年份
     */
    @Excel(name = "年份")
    private Long year;

    /**
     * 用人单位
     */
    @Excel(name = "用人单位")
    private String employer;

    /**
     * 岗位类型
     */
    @Excel(name = "岗位类型")
    private String postType;

    /**
     * 岗位名称
     */
    @Excel(name = "岗位名称")
    private String postName;

    /**
     * 从事工作
     */
    @Excel(name = "从事工作")
    private String jobDescription;

    /**
     * 招考数量
     */
    @Excel(name = "招考数量")
    private Long recruitmentCount;

    /**
     * 入围比例
     */
    @Excel(name = "入围比例")
    private BigDecimal qualificationRatio;

    /**
     * 所学专业
     */
    @Excel(name = "所学专业")
    private String majorStudied;

    /**
     * 考试专业科目
     */
    @Excel(name = "考试专业科目")
    private String examSubjects;

    /**
     * 户籍所在地
     */
    @Excel(name = "户籍所在地")
    private String registeredResidence;

    /**
     * 工作地点
     */
    @Excel(name = "工作地点")
    private String workLocation;

    /**
     * 其他条件
     */
    @Excel(name = "其他条件")
    private String otherConditions;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;

    /**
     * 学历
     */
    @Excel(name = "学历")
    private String educationBackground;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getYear() {
        return year;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmployer() {
        return employer;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostName() {
        return postName;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setRecruitmentCount(Long recruitmentCount) {
        this.recruitmentCount = recruitmentCount;
    }

    public Long getRecruitmentCount() {
        return recruitmentCount;
    }

    public void setQualificationRatio(BigDecimal qualificationRatio) {
        this.qualificationRatio = qualificationRatio;
    }

    public BigDecimal getQualificationRatio() {
        return qualificationRatio;
    }

    public void setMajorStudied(String majorStudied) {
        this.majorStudied = majorStudied;
    }

    public String getMajorStudied() {
        return majorStudied;
    }

    public void setExamSubjects(String examSubjects) {
        this.examSubjects = examSubjects;
    }

    public String getExamSubjects() {
        return examSubjects;
    }

    public void setRegisteredResidence(String registeredResidence) {
        this.registeredResidence = registeredResidence;
    }

    public String getRegisteredResidence() {
        return registeredResidence;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("year", getYear())
                .append("employer", getEmployer())
                .append("postType", getPostType())
                .append("postName", getPostName())
                .append("jobDescription", getJobDescription())
                .append("recruitmentCount", getRecruitmentCount())
                .append("qualificationRatio", getQualificationRatio())
                .append("majorStudied", getMajorStudied())
                .append("examSubjects", getExamSubjects())
                .append("registeredResidence", getRegisteredResidence())
                .append("workLocation", getWorkLocation())
                .append("otherConditions", getOtherConditions())
                .append("sex", getSex())
                .append("educationBackground", getEducationBackground())
                .toString();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }
}
