package com.ruoyi.monitor.service;

import java.util.List;
import com.ruoyi.monitor.domain.ContaminantMonitor;

/**
 * 污染物监测器Service接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface IContaminantMonitorService 
{
    /**
     * 查询污染物监测器
     * 
     * @param id 污染物监测器主键
     * @return 污染物监测器
     */
    public ContaminantMonitor selectContaminantMonitorById(String id);

    /**
     * 查询污染物监测器列表
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 污染物监测器集合
     */
    public List<ContaminantMonitor> selectContaminantMonitorList(ContaminantMonitor contaminantMonitor);

    /**
     * 新增污染物监测器
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 结果
     */
    public int insertContaminantMonitor(ContaminantMonitor contaminantMonitor);

    /**
     * 修改污染物监测器
     * 
     * @param contaminantMonitor 污染物监测器
     * @return 结果
     */
    public int updateContaminantMonitor(ContaminantMonitor contaminantMonitor);

    /**
     * 批量删除污染物监测器
     * 
     * @param ids 需要删除的污染物监测器主键集合
     * @return 结果
     */
    public int deleteContaminantMonitorByIds(String[] ids);

    /**
     * 删除污染物监测器信息
     * 
     * @param id 污染物监测器主键
     * @return 结果
     */
    public int deleteContaminantMonitorById(String id);
}
