package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Recruitment;

/**
 * 技能岗位计划Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
public interface RecruitmentMapper 
{
    

    /**
     * 查询技能岗位计划
     * 
     * @param unitName 技能岗位计划主键
     * @return 技能岗位计划
     */
    public Recruitment selectRecruitmentByUnitName(String unitName);
    public Recruitment selectRecruitmentById(Long id);

    /**
     * 查询技能岗位计划列表
     * 
     * @param recruitment 技能岗位计划
     * @return 技能岗位计划集合
     */
    public List<Recruitment> selectRecruitmentList(Recruitment recruitment);

    /**
     * 新增技能岗位计划
     * 
     * @param recruitment 技能岗位计划
     * @return 结果
     */
    public int insertRecruitment(Recruitment recruitment);

    /**
     * 修改技能岗位计划
     * 
     * @param recruitment 技能岗位计划
     * @return 结果
     */
    public int updateRecruitment(Recruitment recruitment);

    /**
     * 删除技能岗位计划
     * 
     * @param unitName 技能岗位计划主键
     * @return 结果
     */
    public int deleteRecruitmentByUnitName(String unitName);

    /**
     * 批量删除技能岗位计划
     * 
     * @param unitNames 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecruitmentByUnitNames(String[] unitNames);

    Recruitment selectRecruitmentByJobCode(String jobCode);
}
