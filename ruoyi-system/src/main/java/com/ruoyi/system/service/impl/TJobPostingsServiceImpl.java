package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.TJobPostings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TJobPostingsMapper;
import com.ruoyi.system.service.ITJobPostingsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-29
 */
@Service
public class TJobPostingsServiceImpl implements ITJobPostingsService 
{
    @Autowired
    private TJobPostingsMapper tJobPostingsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TJobPostings selectTJobPostingsById(Long id)
    {
        return tJobPostingsMapper.selectTJobPostingsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TJobPostings> selectTJobPostingsList(TJobPostings tJobPostings)
    {
        return tJobPostingsMapper.selectTJobPostingsList(tJobPostings);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTJobPostings(TJobPostings tJobPostings)
    {
        return tJobPostingsMapper.insertTJobPostings(tJobPostings);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tJobPostings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTJobPostings(TJobPostings tJobPostings)
    {
        return tJobPostingsMapper.updateTJobPostings(tJobPostings);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTJobPostingsByIds(Long[] ids)
    {
        return tJobPostingsMapper.deleteTJobPostingsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTJobPostingsById(Long id)
    {
        return tJobPostingsMapper.deleteTJobPostingsById(id);
    }
}
