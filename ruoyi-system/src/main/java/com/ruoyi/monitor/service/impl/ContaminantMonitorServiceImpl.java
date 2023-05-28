package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.monitor.mapper.ContaminantMonitorMapper;
import com.ruoyi.monitor.domain.ContaminantMonitor;
import com.ruoyi.monitor.service.IContaminantMonitorService;

/**
 * 污染物监测器Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class ContaminantMonitorServiceImpl implements IContaminantMonitorService 
{
    @Autowired
    private ContaminantMonitorMapper contaminantMonitorMapper;

    /**
     * 查询污染物监测器
     * 
     * @param id 污染物监测器主键
     * @return 污染物监测器
     */
    @Override
    public ContaminantMonitor selectContaminantMonitorById(String id)
    {
        return contaminantMonitorMapper.selectContaminantMonitorById(id);
    }

    /**
     * 查询污染物监测器列表
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 污染物监测器
     */
    @Override
    public List<ContaminantMonitor> selectContaminantMonitorList(ContaminantMonitor contaminantMonitor)
    {
        return contaminantMonitorMapper.selectContaminantMonitorList(contaminantMonitor);
    }

    /**
     * 新增污染物监测器
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 结果
     */
    @Override
    public int insertContaminantMonitor(ContaminantMonitor contaminantMonitor)
    {
        contaminantMonitor.setCreateTime(DateUtils.getNowDate());
        return contaminantMonitorMapper.insertContaminantMonitor(contaminantMonitor);
    }

    /**
     * 修改污染物监测器
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 结果
     */
    @Override
    public int updateContaminantMonitor(ContaminantMonitor contaminantMonitor)
    {
        return contaminantMonitorMapper.updateContaminantMonitor(contaminantMonitor);
    }

    /**
     * 批量删除污染物监测器
     * 
     * @param ids 需要删除的污染物监测器主键
     * @return 结果
     */
    @Override
    public int deleteContaminantMonitorByIds(String[] ids)
    {
        return contaminantMonitorMapper.deleteContaminantMonitorByIds(ids);
    }

    /**
     * 删除污染物监测器信息
     * 
     * @param id 污染物监测器主键
     * @return 结果
     */
    @Override
    public int deleteContaminantMonitorById(String id)
    {
        return contaminantMonitorMapper.deleteContaminantMonitorById(id);
    }
}
