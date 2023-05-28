package com.ruoyi.experiment.service;

import java.util.List;
import com.ruoyi.experiment.domain.ExpCuringRoom;

/**
 * 实验养护室Service接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface IExpCuringRoomService 
{
    /**
     * 查询实验养护室
     * 
     * @param id 实验养护室主键
     * @return 实验养护室
     */
    public ExpCuringRoom selectExpCuringRoomById(String id);

    /**
     * 查询实验养护室列表
     * 
     * @param expCuringRoom 实验养护室
     * @return 实验养护室集合
     */
    public List<ExpCuringRoom> selectExpCuringRoomList(ExpCuringRoom expCuringRoom);

    /**
     * 新增实验养护室
     * 
     * @param expCuringRoom 实验养护室
     * @return 结果
     */
    public int insertExpCuringRoom(ExpCuringRoom expCuringRoom);

    /**
     * 修改实验养护室
     * 
     * @param expCuringRoom 实验养护室
     * @return 结果
     */
    public int updateExpCuringRoom(ExpCuringRoom expCuringRoom);

    /**
     * 批量删除实验养护室
     * 
     * @param ids 需要删除的实验养护室主键集合
     * @return 结果
     */
    public int deleteExpCuringRoomByIds(String[] ids);

    /**
     * 删除实验养护室信息
     * 
     * @param id 实验养护室主键
     * @return 结果
     */
    public int deleteExpCuringRoomById(String id);
}
