package com.ruoyi.softening.service;

import java.util.List;
import com.ruoyi.softening.domain.ExpSofteningPoint;

/**
 * 软化点实验Service接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface IExpSofteningPointService 
{
    /**
     * 查询软化点实验
     * 
     * @param id 软化点实验主键
     * @return 软化点实验
     */
    public ExpSofteningPoint selectExpSofteningPointById(String id);

    /**
     * 查询软化点实验列表
     * 
     * @param expSofteningPoint 软化点实验
     * @return 软化点实验集合
     */
    public List<ExpSofteningPoint> selectExpSofteningPointList(ExpSofteningPoint expSofteningPoint);

    /**
     * 新增软化点实验
     * 
     * @param expSofteningPoint 软化点实验
     * @return 结果
     */
    public int insertExpSofteningPoint(ExpSofteningPoint expSofteningPoint);

    /**
     * 修改软化点实验
     * 
     * @param expSofteningPoint 软化点实验
     * @return 结果
     */
    public int updateExpSofteningPoint(ExpSofteningPoint expSofteningPoint);

    /**
     * 批量删除软化点实验
     * 
     * @param ids 需要删除的软化点实验主键集合
     * @return 结果
     */
    public int deleteExpSofteningPointByIds(String[] ids);

    /**
     * 删除软化点实验信息
     * 
     * @param id 软化点实验主键
     * @return 结果
     */
    public int deleteExpSofteningPointById(String id);
}
