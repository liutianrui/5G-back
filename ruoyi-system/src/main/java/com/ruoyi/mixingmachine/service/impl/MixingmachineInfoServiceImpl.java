package com.ruoyi.mixingmachine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mixingmachine.mapper.MixingmachineInfoMapper;
import com.ruoyi.mixingmachine.domain.MixingmachineInfo;
import com.ruoyi.mixingmachine.service.IMixingmachineInfoService;

/**
 * 搅拌机信息Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class MixingmachineInfoServiceImpl implements IMixingmachineInfoService 
{
    @Autowired
    private MixingmachineInfoMapper mixingmachineInfoMapper;

    /**
     * 查询搅拌机信息
     * 
     * @param mixingmachineId 搅拌机信息主键
     * @return 搅拌机信息
     */
    @Override
    public MixingmachineInfo selectMixingmachineInfoByMixingmachineId(String mixingmachineId)
    {
        return mixingmachineInfoMapper.selectMixingmachineInfoByMixingmachineId(mixingmachineId);
    }

    /**
     * 查询搅拌机信息列表
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 搅拌机信息
     */
    @Override
    public List<MixingmachineInfo> selectMixingmachineInfoList(MixingmachineInfo mixingmachineInfo)
    {
        return mixingmachineInfoMapper.selectMixingmachineInfoList(mixingmachineInfo);
    }

    /**
     * 新增搅拌机信息
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 结果
     */
    @Override
    public int insertMixingmachineInfo(MixingmachineInfo mixingmachineInfo)
    {
        mixingmachineInfo.setCreateTime(DateUtils.getNowDate());
        return mixingmachineInfoMapper.insertMixingmachineInfo(mixingmachineInfo);
    }

    /**
     * 修改搅拌机信息
     * 
     * @param mixingmachineInfo 搅拌机信息
     * @return 结果
     */
    @Override
    public int updateMixingmachineInfo(MixingmachineInfo mixingmachineInfo)
    {
        return mixingmachineInfoMapper.updateMixingmachineInfo(mixingmachineInfo);
    }

    /**
     * 批量删除搅拌机信息
     * 
     * @param mixingmachineIds 需要删除的搅拌机信息主键
     * @return 结果
     */
    @Override
    public int deleteMixingmachineInfoByMixingmachineIds(String[] mixingmachineIds)
    {
        return mixingmachineInfoMapper.deleteMixingmachineInfoByMixingmachineIds(mixingmachineIds);
    }

    /**
     * 删除搅拌机信息信息
     * 
     * @param mixingmachineId 搅拌机信息主键
     * @return 结果
     */
    @Override
    public int deleteMixingmachineInfoByMixingmachineId(String mixingmachineId)
    {
        return mixingmachineInfoMapper.deleteMixingmachineInfoByMixingmachineId(mixingmachineId);
    }
}
