package com.ruoyi.monitor.mapper;

import java.util.List;
import com.ruoyi.monitor.domain.ContaminantMonitor;

/**
 * 污染物监测器Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface ContaminantMonitorMapper 
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
     * 删除污染物监测器
     * 
     * @param id 污染物监测器主键
     * @return 结果
     */
    public int deleteContaminantMonitorById(String id);

    /**
     * 批量删除污染物监测器
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteContaminantMonitorByIds(String[] ids);
}
