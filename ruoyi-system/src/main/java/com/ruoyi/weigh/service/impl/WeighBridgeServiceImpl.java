package com.ruoyi.weigh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.weigh.mapper.WeighBridgeMapper;
import com.ruoyi.weigh.domain.WeighBridge;
import com.ruoyi.weigh.service.IWeighBridgeService;

/**
 * 地磅Service业务层处理
 *
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class WeighBridgeServiceImpl implements IWeighBridgeService
{
    @Autowired
    private WeighBridgeMapper weighBridgeMapper;

    /**
     * 查询地磅
     *
     * @param id 地磅主键
     * @return 地磅
     */
    @Override
    public WeighBridge selectWeighBridgeById(String id)
    {
        return weighBridgeMapper.selectWeighBridgeById(id);
    }

    /**
     * 查询地磅列表
     *
     * @param weighBridge 地磅
     * @return 地磅
     */
    @Override
    public List<WeighBridge> selectWeighBridgeList(WeighBridge weighBridge)
    {
        return weighBridgeMapper.selectWeighBridgeList(weighBridge);
    }

    /**
     * 新增地磅
     *
     * @param weighBridge 地磅
     * @return 结果
     */
    @Override
    public int insertWeighBridge(WeighBridge weighBridge)
    {
        return weighBridgeMapper.insertWeighBridge(weighBridge);
    }

    /**
     * 修改地磅
     *
     * @param weighBridge 地磅
     * @return 结果
     */
    @Override
    public int updateWeighBridge(WeighBridge weighBridge)
    {
        return weighBridgeMapper.updateWeighBridge(weighBridge);
    }

    /**
     * 批量删除地磅
     *
     * @param ids 需要删除的地磅主键
     * @return 结果
     */
    @Override
    public int deleteWeighBridgeByIds(String[] ids)
    {
        return weighBridgeMapper.deleteWeighBridgeByIds(ids);
    }

    /**
     * 删除地磅信息
     *
     * @param id 地磅主键
     * @return 结果
     */
    @Override
    public int deleteWeighBridgeById(String id)
    {
        return weighBridgeMapper.deleteWeighBridgeById(id);
    }

    @Override
    public List<Map<String, Object>> queryByBar(Map<String, Object> params) {

        if (params.get("minTime") != null && params.get("maxTime") != null) {
            String minTime = params.get("minTime").toString();
            String maxTime = params.get("maxTime").toString();
            //判断是否传递了时间范围，如果没传默认查询最新的七天时间数据
            List<Map<String, Object>> mapList = weighBridgeMapper.queryByBar(params);
            return mapList;

        } else {
            Map map = weighBridgeMapper.queryTime();
            params.put("minTime", map.get("minTime"));
            params.put("maxTime", map.get("maxTime"));
            List<Map<String, Object>> mapList = weighBridgeMapper.queryByBar(params);
            return mapList;
        }
    }

    @Override
    public List<Map<String, Object>> queryByPie(Map<String, Object> params) {
//        if (params.get("minTime") != null && params.get("maxTime") != null) {
//            String minTime = params.get("minTime").toString();
//            String maxTime = params.get("maxTime").toString();
//            //判断是否传递了时间范围，如果没传默认查询最新的七天时间数据
//            List<Map<String, Object>> mapList = weightBridgeMapper.queryByPie(params);
//            return mapList;
//
//        } else {
//        Map map = weightBridgeMapper.queryTime();
//        params.put("minTime", map.get("minTime"));
//        params.put("maxTime", map.get("maxTime"));
        List<Map<String, Object>> mapList = weighBridgeMapper.queryByPie(params);
        return mapList;
//        }
    }
}
