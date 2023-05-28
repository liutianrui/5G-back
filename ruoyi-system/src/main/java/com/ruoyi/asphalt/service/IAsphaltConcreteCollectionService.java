package com.ruoyi.asphalt.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.asphalt.domain.AsphaltConcreteCollection;

/**
 * 沥青混凝土收集Service接口
 *
 * @author liutianrui
 * @date 2023-05-28
 */
public interface IAsphaltConcreteCollectionService
{
    /**
     * 查询沥青混凝土收集
     *
     * @param id 沥青混凝土收集主键
     * @return 沥青混凝土收集
     */
    public AsphaltConcreteCollection selectAsphaltConcreteCollectionById(String id);

    /**
     * 查询沥青混凝土收集列表
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 沥青混凝土收集集合
     */
    public List<AsphaltConcreteCollection> selectAsphaltConcreteCollectionList(AsphaltConcreteCollection asphaltConcreteCollection);

    /**
     * 新增沥青混凝土收集
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 结果
     */
    public int insertAsphaltConcreteCollection(AsphaltConcreteCollection asphaltConcreteCollection);

    /**
     * 修改沥青混凝土收集
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 结果
     */
    public int updateAsphaltConcreteCollection(AsphaltConcreteCollection asphaltConcreteCollection);

    /**
     * 批量删除沥青混凝土收集
     *
     * @param ids 需要删除的沥青混凝土收集主键集合
     * @return 结果
     */
    public int deleteAsphaltConcreteCollectionByIds(String[] ids);

    /**
     * 删除沥青混凝土收集信息
     *
     * @param id 沥青混凝土收集主键
     * @return 结果
     */
    public int deleteAsphaltConcreteCollectionById(String id);

    //查询柱状图数据，按天分组
    List<Map<String,Object>> queryBar(Map<String,Object> params);
}
