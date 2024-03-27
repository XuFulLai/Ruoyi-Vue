package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HistoryRecruitment;

/**
 * 历年岗位信息Service接口
 * 
 * @author ruoyi
 * @date 2024-03-03
 */
public interface IHistoryRecruitmentService 
{
    /**
     * 查询历年岗位信息
     * 
     * @param jobCode 历年岗位信息主键
     * @return 历年岗位信息
     */
    public HistoryRecruitment selectHistoryRecruitmentByJobCode(String jobCode);

    /**
     * 查询历年岗位信息列表
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 历年岗位信息集合
     */
    public List<HistoryRecruitment> selectHistoryRecruitmentList(HistoryRecruitment historyRecruitment);

    /**
     * 新增历年岗位信息
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 结果
     */
    public int insertHistoryRecruitment(HistoryRecruitment historyRecruitment);

    /**
     * 修改历年岗位信息
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 结果
     */
    public int updateHistoryRecruitment(HistoryRecruitment historyRecruitment);

    /**
     * 批量删除历年岗位信息
     * 
     * @param jobCodes 需要删除的历年岗位信息主键集合
     * @return 结果
     */
    public int deleteHistoryRecruitmentByJobCodes(String[] jobCodes);

    /**
     * 删除历年岗位信息信息
     * 
     * @param jobCode 历年岗位信息主键
     * @return 结果
     */
    public int deleteHistoryRecruitmentByJobCode(String jobCode);

    String importData(List<HistoryRecruitment> historyRecruitmentList, Boolean updateSupport, String operName);

    public HistoryRecruitment selectHistoryRecruitmentById(Long id);
}
