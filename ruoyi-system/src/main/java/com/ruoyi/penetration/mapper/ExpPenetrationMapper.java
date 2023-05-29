package com.ruoyi.penetration.mapper;

import java.util.List;
import com.ruoyi.penetration.domain.ExpPenetration;

/**
 * 针入度实验Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface ExpPenetrationMapper 
{
    /**
     * 查询针入度实验
     * 
     * @param id 针入度实验主键
     * @return 针入度实验
     */
    public ExpPenetration selectExpPenetrationById(String id);

    /**
     * 查询针入度实验列表
     * 
     * @param expPenetration 针入度实验
     * @return 针入度实验集合
     */
    public List<ExpPenetration> selectExpPenetrationList(ExpPenetration expPenetration);

    /**
     * 新增针入度实验
     * 
     * @param expPenetration 针入度实验
     * @return 结果
     */
    public int insertExpPenetration(ExpPenetration expPenetration);

    /**
     * 修改针入度实验
     * 
     * @param expPenetration 针入度实验
     * @return 结果
     */
    public int updateExpPenetration(ExpPenetration expPenetration);

    /**
     * 删除针入度实验
     * 
     * @param id 针入度实验主键
     * @return 结果
     */
    public int deleteExpPenetrationById(String id);

    /**
     * 批量删除针入度实验
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpPenetrationByIds(String[] ids);
}
