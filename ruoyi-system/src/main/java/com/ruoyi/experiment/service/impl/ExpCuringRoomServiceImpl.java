package com.ruoyi.experiment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.experiment.mapper.ExpCuringRoomMapper;
import com.ruoyi.experiment.domain.ExpCuringRoom;
import com.ruoyi.experiment.service.IExpCuringRoomService;

/**
 * 实验养护室Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class ExpCuringRoomServiceImpl implements IExpCuringRoomService 
{
    @Autowired
    private ExpCuringRoomMapper expCuringRoomMapper;

    /**
     * 查询实验养护室
     * 
     * @param id 实验养护室主键
     * @return 实验养护室
     */
    @Override
    public ExpCuringRoom selectExpCuringRoomById(String id)
    {
        return expCuringRoomMapper.selectExpCuringRoomById(id);
    }

    /**
     * 查询实验养护室列表
     * 
     * @param expCuringRoom 实验养护室
     * @return 实验养护室
     */
    @Override
    public List<ExpCuringRoom> selectExpCuringRoomList(ExpCuringRoom expCuringRoom)
    {
        return expCuringRoomMapper.selectExpCuringRoomList(expCuringRoom);
    }

    /**
     * 新增实验养护室
     * 
     * @param expCuringRoom 实验养护室
     * @return 结果
     */
    @Override
    public int insertExpCuringRoom(ExpCuringRoom expCuringRoom)
    {
        return expCuringRoomMapper.insertExpCuringRoom(expCuringRoom);
    }

    /**
     * 修改实验养护室
     * 
     * @param expCuringRoom 实验养护室
     * @return 结果
     */
    @Override
    public int updateExpCuringRoom(ExpCuringRoom expCuringRoom)
    {
        return expCuringRoomMapper.updateExpCuringRoom(expCuringRoom);
    }

    /**
     * 批量删除实验养护室
     * 
     * @param ids 需要删除的实验养护室主键
     * @return 结果
     */
    @Override
    public int deleteExpCuringRoomByIds(String[] ids)
    {
        return expCuringRoomMapper.deleteExpCuringRoomByIds(ids);
    }

    /**
     * 删除实验养护室信息
     * 
     * @param id 实验养护室主键
     * @return 结果
     */
    @Override
    public int deleteExpCuringRoomById(String id)
    {
        return expCuringRoomMapper.deleteExpCuringRoomById(id);
    }
}
