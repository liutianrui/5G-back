package com.ruoyi.furnace.mapper;

import java.util.List;
import com.ruoyi.furnace.domain.ExpFurnace;

/**
 * 实验炉Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface ExpFurnaceMapper 
{
    /**
     * 查询实验炉
     * 
     * @param id 实验炉主键
     * @return 实验炉
     */
    public ExpFurnace selectExpFurnaceById(String id);

    /**
     * 查询实验炉列表
     * 
     * @param expFurnace 实验炉
     * @return 实验炉集合
     */
    public List<ExpFurnace> selectExpFurnaceList(ExpFurnace expFurnace);

    /**
     * 新增实验炉
     * 
     * @param expFurnace 实验炉
     * @return 结果
     */
    public int insertExpFurnace(ExpFurnace expFurnace);

    /**
     * 修改实验炉
     * 
     * @param expFurnace 实验炉
     * @return 结果
     */
    public int updateExpFurnace(ExpFurnace expFurnace);

    /**
     * 删除实验炉
     * 
     * @param id 实验炉主键
     * @return 结果
     */
    public int deleteExpFurnaceById(String id);

    /**
     * 批量删除实验炉
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpFurnaceByIds(String[] ids);
}
