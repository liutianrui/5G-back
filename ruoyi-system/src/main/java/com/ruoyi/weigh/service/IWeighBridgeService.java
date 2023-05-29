package com.ruoyi.weigh.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.weigh.domain.WeighBridge;

/**
 * 地磅Service接口
 *
 * @author liutianrui
 * @date 2023-05-29
 */
public interface IWeighBridgeService
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
     * 批量删除地磅
     *
     * @param ids 需要删除的地磅主键集合
     * @return 结果
     */
    public int deleteWeighBridgeByIds(String[] ids);

    /**
     * 删除地磅信息
     *
     * @param id 地磅主键
     * @return 结果
     */
    public int deleteWeighBridgeById(String id);

    //查询柱状图数据，按天分组
    List<Map<String,Object>> queryByBar(Map<String,Object> params);

    //查询柱状图数据，按物料种类分组
    List<Map<String,Object>> queryByPie(Map<String,Object> params);
}
