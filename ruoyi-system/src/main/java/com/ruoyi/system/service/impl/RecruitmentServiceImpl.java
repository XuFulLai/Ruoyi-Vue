package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Objects;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.domain.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecruitmentMapper;
import com.ruoyi.system.domain.Recruitment;
import com.ruoyi.system.service.IRecruitmentService;
import org.springframework.util.CollectionUtils;

import javax.validation.Validator;

/**
 * 技能岗位计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-02
 */
@Service
public class RecruitmentServiceImpl implements IRecruitmentService 
{
    @Autowired
    private RecruitmentMapper recruitmentMapper;
    @Autowired
    protected Validator validator;

    /**
     * 查询技能岗位计划
     * 
     * @param unitName 技能岗位计划主键
     * @return 技能岗位计划
     */
    @Override
    public Recruitment selectRecruitmentByUnitName(String unitName)
    {
        return recruitmentMapper.selectRecruitmentByUnitName(unitName);
    }

    /**
     * 查询技能岗位计划列表
     * 
     * @param recruitment 技能岗位计划
     * @return 技能岗位计划
     */
    @Override
    public List<Recruitment> selectRecruitmentList(Recruitment recruitment)
    {
        return recruitmentMapper.selectRecruitmentList(recruitment);
    }

    /**
     * 新增技能岗位计划
     * 
     * @param recruitment 技能岗位计划
     * @return 结果
     */
    @Override
    public int insertRecruitment(Recruitment recruitment)
    {
        return recruitmentMapper.insertRecruitment(recruitment);
    }

    /**
     * 修改技能岗位计划
     * 
     * @param recruitment 技能岗位计划
     * @return 结果
     */
    @Override
    public int updateRecruitment(Recruitment recruitment)
    {
        return recruitmentMapper.updateRecruitment(recruitment);
    }

    /**
     * 批量删除技能岗位计划
     * 
     * @param unitNames 需要删除的技能岗位计划主键
     * @return 结果
     */
    @Override
    public int deleteRecruitmentByUnitNames(String[] unitNames)
    {
        return recruitmentMapper.deleteRecruitmentByUnitNames(unitNames);
    }

    /**
     * 删除技能岗位计划信息
     * 
     * @param unitName 技能岗位计划主键
     * @return 结果
     */
    @Override
    public int deleteRecruitmentByUnitName(String unitName)
    {
        return recruitmentMapper.deleteRecruitmentByUnitName(unitName);
    }

    @Override
    public String importData(List<Recruitment> recruitmentList, Boolean updateSupport, String operName) {
        if (CollectionUtils.isEmpty(recruitmentList)) {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Recruitment Recruitment : recruitmentList) {
            try {
                // 验证是否存在这个岗位编号
                Recruitment existingRecruitment = recruitmentMapper.selectRecruitmentByJobCode(Recruitment.getJobCode());
                if (Objects.isNull(existingRecruitment)) {
                    BeanValidators.validateWithException(validator, Recruitment);
                    Recruitment.setCreateBy(operName);
                    this.insertRecruitment(Recruitment);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、岗位编号 " + Recruitment.getJobCode() + " 导入成功");
                } else if (updateSupport) {
                    BeanValidators.validateWithException(validator, Recruitment);
                    Recruitment.setUpdateBy(operName);
                    this.updateRecruitment(Recruitment);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、岗位编号 " + Recruitment.getJobCode() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、岗位编号 " + Recruitment.getJobCode() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、岗位编号 " + Recruitment.getJobCode() + " 导入失败：";
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
    public Recruitment selectRecruitmentById(Long id) {
        return recruitmentMapper.selectRecruitmentById(id);
    }
}
