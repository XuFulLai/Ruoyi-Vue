package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Objects;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HistoryRecruitmentMapper;
import com.ruoyi.system.domain.HistoryRecruitment;
import com.ruoyi.system.service.IHistoryRecruitmentService;
import org.springframework.util.CollectionUtils;

import javax.validation.Validator;

/**
 * 历年岗位信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-03
 */
@Service
public class HistoryRecruitmentServiceImpl implements IHistoryRecruitmentService 
{
    @Autowired
    private HistoryRecruitmentMapper historyRecruitmentMapper;

    @Autowired
    private Validator validator;

    /**
     * 查询历年岗位信息
     * 
     * @param jobCode 历年岗位信息主键
     * @return 历年岗位信息
     */
    @Override
    public HistoryRecruitment selectHistoryRecruitmentByJobCode(String jobCode)
    {
        return historyRecruitmentMapper.selectHistoryRecruitmentByJobCode(jobCode);
    }

    /**
     * 查询历年岗位信息列表
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 历年岗位信息
     */
    @Override
    public List<HistoryRecruitment> selectHistoryRecruitmentList(HistoryRecruitment historyRecruitment)
    {
        return historyRecruitmentMapper.selectHistoryRecruitmentList(historyRecruitment);
    }

    /**
     * 新增历年岗位信息
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 结果
     */
    @Override
    public int insertHistoryRecruitment(HistoryRecruitment historyRecruitment)
    {
        return historyRecruitmentMapper.insertHistoryRecruitment(historyRecruitment);
    }

    /**
     * 修改历年岗位信息
     * 
     * @param historyRecruitment 历年岗位信息
     * @return 结果
     */
    @Override
    public int updateHistoryRecruitment(HistoryRecruitment historyRecruitment)
    {
        return historyRecruitmentMapper.updateHistoryRecruitment(historyRecruitment);
    }

    /**
     * 批量删除历年岗位信息
     * 
     * @param jobCodes 需要删除的历年岗位信息主键
     * @return 结果
     */
    @Override
    public int deleteHistoryRecruitmentByJobCodes(String[] jobCodes)
    {
        return historyRecruitmentMapper.deleteHistoryRecruitmentByJobCodes(jobCodes);
    }

    /**
     * 删除历年岗位信息信息
     * 
     * @param jobCode 历年岗位信息主键
     * @return 结果
     */
    @Override
    public int deleteHistoryRecruitmentByJobCode(String jobCode)
    {
        return historyRecruitmentMapper.deleteHistoryRecruitmentByJobCode(jobCode);
    }

    @Override
    public String importData(List<HistoryRecruitment> historyRecruitmentList, Boolean isUpdateSupport, String operName) {
        if (CollectionUtils.isEmpty(historyRecruitmentList)) {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (HistoryRecruitment historyRecruitment : historyRecruitmentList) {
            try {
                // 验证是否存在这个岗位编号
                HistoryRecruitment existingRecruitment = historyRecruitmentMapper.selectHistoryRecruitmentByJobCode(historyRecruitment.getJobCode());
                if (Objects.isNull(existingRecruitment)) {
                    BeanValidators.validateWithException(validator, historyRecruitment);
                    historyRecruitment.setCreateBy(operName);
                    this.insertHistoryRecruitment(historyRecruitment);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、岗位编号 " + historyRecruitment.getJobCode() + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, historyRecruitment);
                    historyRecruitment.setUpdateBy(operName);
                    this.updateHistoryRecruitment(historyRecruitment);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、岗位编号 " + historyRecruitment.getJobCode() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、岗位编号 " + historyRecruitment.getJobCode() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、岗位编号 " + historyRecruitment.getJobCode() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
//                log.error(() -> msg, e);

            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public HistoryRecruitment selectHistoryRecruitmentById(Long id) {
        return historyRecruitmentMapper.selectHistoryRecruitmentById(id);
    }
}
