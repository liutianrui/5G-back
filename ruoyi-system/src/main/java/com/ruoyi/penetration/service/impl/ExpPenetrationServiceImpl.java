package com.ruoyi.penetration.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.penetration.mapper.ExpPenetrationMapper;
import com.ruoyi.penetration.domain.ExpPenetration;
import com.ruoyi.penetration.service.IExpPenetrationService;

/**
 * 针入度实验Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class ExpPenetrationServiceImpl implements IExpPenetrationService 
{
    @Autowired
    private ExpPenetrationMapper expPenetrationMapper;

    /**
     * 查询针入度实验
     * 
     * @param id 针入度实验主键
     * @return 针入度实验
     */
    @Override
    public ExpPenetration selectExpPenetrationById(String id)
    {
        return expPenetrationMapper.selectExpPenetrationById(id);
    }

    /**
     * 查询针入度实验列表
     * 
     * @param expPenetration 针入度实验
     * @return 针入度实验
     */
    @Override
    public List<ExpPenetration> selectExpPenetrationList(ExpPenetration expPenetration)
    {
        return expPenetrationMapper.selectExpPenetrationList(expPenetration);
    }

    /**
     * 新增针入度实验
     * 
     * @param expPenetration 针入度实验
     * @return 结果
     */
    @Override
    public int insertExpPenetration(ExpPenetration expPenetration)
    {
        return expPenetrationMapper.insertExpPenetration(expPenetration);
    }

    /**
     * 修改针入度实验
     * 
     * @param expPenetration 针入度实验
     * @return 结果
     */
    @Override
    public int updateExpPenetration(ExpPenetration expPenetration)
    {
        return expPenetrationMapper.updateExpPenetration(expPenetration);
    }

    /**
     * 批量删除针入度实验
     * 
     * @param ids 需要删除的针入度实验主键
     * @return 结果
     */
    @Override
    public int deleteExpPenetrationByIds(String[] ids)
    {
        return expPenetrationMapper.deleteExpPenetrationByIds(ids);
    }

    /**
     * 删除针入度实验信息
     * 
     * @param id 针入度实验主键
     * @return 结果
     */
    @Override
    public int deleteExpPenetrationById(String id)
    {
        return expPenetrationMapper.deleteExpPenetrationById(id);
    }
}
