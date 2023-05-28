package com.ruoyi.furnace.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.furnace.mapper.ExpFurnaceMapper;
import com.ruoyi.furnace.domain.ExpFurnace;
import com.ruoyi.furnace.service.IExpFurnaceService;

/**
 * 实验炉Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class ExpFurnaceServiceImpl implements IExpFurnaceService 
{
    @Autowired
    private ExpFurnaceMapper expFurnaceMapper;

    /**
     * 查询实验炉
     * 
     * @param id 实验炉主键
     * @return 实验炉
     */
    @Override
    public ExpFurnace selectExpFurnaceById(String id)
    {
        return expFurnaceMapper.selectExpFurnaceById(id);
    }

    /**
     * 查询实验炉列表
     * 
     * @param expFurnace 实验炉
     * @return 实验炉
     */
    @Override
    public List<ExpFurnace> selectExpFurnaceList(ExpFurnace expFurnace)
    {
        return expFurnaceMapper.selectExpFurnaceList(expFurnace);
    }

    /**
     * 新增实验炉
     * 
     * @param expFurnace 实验炉
     * @return 结果
     */
    @Override
    public int insertExpFurnace(ExpFurnace expFurnace)
    {
        return expFurnaceMapper.insertExpFurnace(expFurnace);
    }

    /**
     * 修改实验炉
     * 
     * @param expFurnace 实验炉
     * @return 结果
     */
    @Override
    public int updateExpFurnace(ExpFurnace expFurnace)
    {
        return expFurnaceMapper.updateExpFurnace(expFurnace);
    }

    /**
     * 批量删除实验炉
     * 
     * @param ids 需要删除的实验炉主键
     * @return 结果
     */
    @Override
    public int deleteExpFurnaceByIds(String[] ids)
    {
        return expFurnaceMapper.deleteExpFurnaceByIds(ids);
    }

    /**
     * 删除实验炉信息
     * 
     * @param id 实验炉主键
     * @return 结果
     */
    @Override
    public int deleteExpFurnaceById(String id)
    {
        return expFurnaceMapper.deleteExpFurnaceById(id);
    }
}
