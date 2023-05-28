package com.ruoyi.marshall.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.marshall.mapper.ExpMarshallStabilityMapper;
import com.ruoyi.marshall.domain.ExpMarshallStability;
import com.ruoyi.marshall.service.IExpMarshallStabilityService;

/**
 * 马歇尔稳定性实验Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class ExpMarshallStabilityServiceImpl implements IExpMarshallStabilityService 
{
    @Autowired
    private ExpMarshallStabilityMapper expMarshallStabilityMapper;

    /**
     * 查询马歇尔稳定性实验
     * 
     * @param id 马歇尔稳定性实验主键
     * @return 马歇尔稳定性实验
     */
    @Override
    public ExpMarshallStability selectExpMarshallStabilityById(String id)
    {
        return expMarshallStabilityMapper.selectExpMarshallStabilityById(id);
    }

    /**
     * 查询马歇尔稳定性实验列表
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 马歇尔稳定性实验
     */
    @Override
    public List<ExpMarshallStability> selectExpMarshallStabilityList(ExpMarshallStability expMarshallStability)
    {
        return expMarshallStabilityMapper.selectExpMarshallStabilityList(expMarshallStability);
    }

    /**
     * 新增马歇尔稳定性实验
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 结果
     */
    @Override
    public int insertExpMarshallStability(ExpMarshallStability expMarshallStability)
    {
        return expMarshallStabilityMapper.insertExpMarshallStability(expMarshallStability);
    }

    /**
     * 修改马歇尔稳定性实验
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 结果
     */
    @Override
    public int updateExpMarshallStability(ExpMarshallStability expMarshallStability)
    {
        return expMarshallStabilityMapper.updateExpMarshallStability(expMarshallStability);
    }

    /**
     * 批量删除马歇尔稳定性实验
     * 
     * @param ids 需要删除的马歇尔稳定性实验主键
     * @return 结果
     */
    @Override
    public int deleteExpMarshallStabilityByIds(String[] ids)
    {
        return expMarshallStabilityMapper.deleteExpMarshallStabilityByIds(ids);
    }

    /**
     * 删除马歇尔稳定性实验信息
     * 
     * @param id 马歇尔稳定性实验主键
     * @return 结果
     */
    @Override
    public int deleteExpMarshallStabilityById(String id)
    {
        return expMarshallStabilityMapper.deleteExpMarshallStabilityById(id);
    }
}
