package com.ruoyi.softening.mapper;

import java.util.List;
import com.ruoyi.softening.domain.ExpSofteningPoint;

/**
 * 软化点实验Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface ExpSofteningPointMapper 
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
     * 删除软化点实验
     * 
     * @param id 软化点实验主键
     * @return 结果
     */
    public int deleteExpSofteningPointById(String id);

    /**
     * 批量删除软化点实验
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpSofteningPointByIds(String[] ids);
}
