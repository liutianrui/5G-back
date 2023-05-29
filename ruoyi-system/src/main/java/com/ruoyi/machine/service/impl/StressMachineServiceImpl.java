package com.ruoyi.machine.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.machine.mapper.StressMachineMapper;
import com.ruoyi.machine.domain.StressMachine;
import com.ruoyi.machine.service.IStressMachineService;

/**
 * 压力机Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class StressMachineServiceImpl implements IStressMachineService 
{
    @Autowired
    private StressMachineMapper stressMachineMapper;

    /**
     * 查询压力机
     * 
     * @param id 压力机主键
     * @return 压力机
     */
    @Override
    public StressMachine selectStressMachineById(String id)
    {
        return stressMachineMapper.selectStressMachineById(id);
    }

    /**
     * 查询压力机列表
     * 
     * @param stressMachine 压力机
     * @return 压力机
     */
    @Override
    public List<StressMachine> selectStressMachineList(StressMachine stressMachine)
    {
        return stressMachineMapper.selectStressMachineList(stressMachine);
    }

    /**
     * 新增压力机
     * 
     * @param stressMachine 压力机
     * @return 结果
     */
    @Override
    public int insertStressMachine(StressMachine stressMachine)
    {
        return stressMachineMapper.insertStressMachine(stressMachine);
    }

    /**
     * 修改压力机
     * 
     * @param stressMachine 压力机
     * @return 结果
     */
    @Override
    public int updateStressMachine(StressMachine stressMachine)
    {
        return stressMachineMapper.updateStressMachine(stressMachine);
    }

    /**
     * 批量删除压力机
     * 
     * @param ids 需要删除的压力机主键
     * @return 结果
     */
    @Override
    public int deleteStressMachineByIds(String[] ids)
    {
        return stressMachineMapper.deleteStressMachineByIds(ids);
    }

    /**
     * 删除压力机信息
     * 
     * @param id 压力机主键
     * @return 结果
     */
    @Override
    public int deleteStressMachineById(String id)
    {
        return stressMachineMapper.deleteStressMachineById(id);
    }
}
