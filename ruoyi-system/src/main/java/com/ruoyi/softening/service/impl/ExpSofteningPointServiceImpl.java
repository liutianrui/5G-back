package com.ruoyi.softening.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.softening.mapper.ExpSofteningPointMapper;
import com.ruoyi.softening.domain.ExpSofteningPoint;
import com.ruoyi.softening.service.IExpSofteningPointService;

/**
 * 软化点实验Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class ExpSofteningPointServiceImpl implements IExpSofteningPointService 
{
    @Autowired
    private ExpSofteningPointMapper expSofteningPointMapper;

    /**
     * 查询软化点实验
     * 
     * @param id 软化点实验主键
     * @return 软化点实验
     */
    @Override
    public ExpSofteningPoint selectExpSofteningPointById(String id)
    {
        return expSofteningPointMapper.selectExpSofteningPointById(id);
    }

    /**
     * 查询软化点实验列表
     * 
     * @param expSofteningPoint 软化点实验
     * @return 软化点实验
     */
    @Override
    public List<ExpSofteningPoint> selectExpSofteningPointList(ExpSofteningPoint expSofteningPoint)
    {
        return expSofteningPointMapper.selectExpSofteningPointList(expSofteningPoint);
    }

    /**
     * 新增软化点实验
     * 
     * @param expSofteningPoint 软化点实验
     * @return 结果
     */
    @Override
    public int insertExpSofteningPoint(ExpSofteningPoint expSofteningPoint)
    {
        return expSofteningPointMapper.insertExpSofteningPoint(expSofteningPoint);
    }

    /**
     * 修改软化点实验
     * 
     * @param expSofteningPoint 软化点实验
     * @return 结果
     */
    @Override
    public int updateExpSofteningPoint(ExpSofteningPoint expSofteningPoint)
    {
        return expSofteningPointMapper.updateExpSofteningPoint(expSofteningPoint);
    }

    /**
     * 批量删除软化点实验
     * 
     * @param ids 需要删除的软化点实验主键
     * @return 结果
     */
    @Override
    public int deleteExpSofteningPointByIds(String[] ids)
    {
        return expSofteningPointMapper.deleteExpSofteningPointByIds(ids);
    }

    /**
     * 删除软化点实验信息
     * 
     * @param id 软化点实验主键
     * @return 结果
     */
    @Override
    public int deleteExpSofteningPointById(String id)
    {
        return expSofteningPointMapper.deleteExpSofteningPointById(id);
    }
}
