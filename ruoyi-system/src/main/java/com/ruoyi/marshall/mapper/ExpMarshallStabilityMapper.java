package com.ruoyi.marshall.mapper;

import java.util.List;
import com.ruoyi.marshall.domain.ExpMarshallStability;

/**
 * 马歇尔稳定性实验Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface ExpMarshallStabilityMapper 
{
    /**
     * 查询马歇尔稳定性实验
     * 
     * @param id 马歇尔稳定性实验主键
     * @return 马歇尔稳定性实验
     */
    public ExpMarshallStability selectExpMarshallStabilityById(String id);

    /**
     * 查询马歇尔稳定性实验列表
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 马歇尔稳定性实验集合
     */
    public List<ExpMarshallStability> selectExpMarshallStabilityList(ExpMarshallStability expMarshallStability);

    /**
     * 新增马歇尔稳定性实验
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 结果
     */
    public int insertExpMarshallStability(ExpMarshallStability expMarshallStability);

    /**
     * 修改马歇尔稳定性实验
     * 
     * @param expMarshallStability 马歇尔稳定性实验
     * @return 结果
     */
    public int updateExpMarshallStability(ExpMarshallStability expMarshallStability);

    /**
     * 删除马歇尔稳定性实验
     * 
     * @param id 马歇尔稳定性实验主键
     * @return 结果
     */
    public int deleteExpMarshallStabilityById(String id);

    /**
     * 批量删除马歇尔稳定性实验
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpMarshallStabilityByIds(String[] ids);
}
