package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.TJobPostings;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-02-29
 */
public interface ITJobPostingsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TJobPostings selectTJobPostingsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TJobPostings> selectTJobPostingsList(TJobPostings tJobPostings);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 结果
     */
    public int insertTJobPostings(TJobPostings tJobPostings);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 结果
     */
    public int updateTJobPostings(TJobPostings tJobPostings);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTJobPostingsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTJobPostingsById(Long id);
}
