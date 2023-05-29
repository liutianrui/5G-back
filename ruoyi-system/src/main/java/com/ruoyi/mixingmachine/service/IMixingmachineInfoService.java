package com.ruoyi.mixingmachine.service;

import java.util.List;
import com.ruoyi.mixingmachine.domain.MixingmachineInfo;

/**
 * 搅拌机信息Service接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface IMixingmachineInfoService 
{
    /**
     * 查询搅拌机信息
     * 
     * @param mixingmachineId 搅拌机信息主键
     * @return 搅拌机信息
     */
    public MixingmachineInfo selectMixingmachineInfoByMixingmachineId(String mixingmachineId);

    /**
     * 查询搅拌机信息列表
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 搅拌机信息集合
     */
    public List<MixingmachineInfo> selectMixingmachineInfoList(MixingmachineInfo mixingmachineInfo);

    /**
     * 新增搅拌机信息
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 结果
     */
    public int insertMixingmachineInfo(MixingmachineInfo mixingmachineInfo);

    /**
     * 修改搅拌机信息
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 结果
     */
    public int updateMixingmachineInfo(MixingmachineInfo mixingmachineInfo);

    /**
     * 批量删除搅拌机信息
     * 
     * @param mixingmachineIds 需要删除的搅拌机信息主键集合
     * @return 结果
     */
    public int deleteMixingmachineInfoByMixingmachineIds(String[] mixingmachineIds);

    /**
     * 删除搅拌机信息信息
     * 
     * @param mixingmachineId 搅拌机信息主键
     * @return 结果
     */
    public int deleteMixingmachineInfoByMixingmachineId(String mixingmachineId);
}
