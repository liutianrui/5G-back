package com.ruoyi.weigh.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.weigh.domain.WeighBridge;

/**
 * 地磅Mapper接口
 *
 * @author liutianrui
 * @date 2023-05-29
 */
public interface WeighBridgeMapper
{
    /**
     * 查询地磅
     *
     * @param id 地磅主键
     * @return 地磅
     */
    public WeighBridge selectWeighBridgeById(String id);

    /**
     * 查询地磅列表
     *
     * @param weighBridge 地磅
     * @return 地磅集合
     */
    public List<WeighBridge> selectWeighBridgeList(WeighBridge weighBridge);

    /**
     * 新增地磅
     *
     * @param weighBridge 地磅
     * @return 结果
     */
    public int insertWeighBridge(WeighBridge weighBridge);

    /**
     * 修改地磅
     *
     * @param weighBridge 地磅
     * @return 结果
     */
    public int updateWeighBridge(WeighBridge weighBridge);

    /**
     * 删除地磅
     *
     * @param id 地磅主键
     * @return 结果
     */
    public int deleteWeighBridgeById(String id);

    /**
     * 批量删除地磅
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWeighBridgeByIds(String[] ids);

    //查询柱状图数据，按天分组
    List<Map<String,Object>> queryByBar(Map<String,Object> params);

    //查询饼图数据，按天分组
    List<Map<String,Object>> queryByPie(Map<String,Object> params);

    //查询默认的最新时间和最近七天的时间
    Map queryTime();
}
