package com.ruoyi.machine.mapper;

import java.util.List;
import com.ruoyi.machine.domain.StressMachine;

/**
 * 压力机Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface StressMachineMapper 
{
    /**
     * 查询压力机
     * 
     * @param id 压力机主键
     * @return 压力机
     */
    public StressMachine selectStressMachineById(String id);

    /**
     * 查询压力机列表
     * 
     * @param stressMachine 压力机
     * @return 压力机集合
     */
    public List<StressMachine> selectStressMachineList(StressMachine stressMachine);

    /**
     * 新增压力机
     * 
     * @param stressMachine 压力机
     * @return 结果
     */
    public int insertStressMachine(StressMachine stressMachine);

    /**
     * 修改压力机
     * 
     * @param stressMachine 压力机
     * @return 结果
     */
    public int updateStressMachine(StressMachine stressMachine);

    /**
     * 删除压力机
     * 
     * @param id 压力机主键
     * @return 结果
     */
    public int deleteStressMachineById(String id);

    /**
     * 批量删除压力机
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStressMachineByIds(String[] ids);
}
