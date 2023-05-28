package com.ruoyi.asphalt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.asphalt.mapper.AsphaltConcreteCollectionMapper;
import com.ruoyi.asphalt.domain.AsphaltConcreteCollection;
import com.ruoyi.asphalt.service.IAsphaltConcreteCollectionService;

/**
 * 沥青混凝土收集Service业务层处理
 *
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class AsphaltConcreteCollectionServiceImpl implements IAsphaltConcreteCollectionService
{
    @Autowired
    private AsphaltConcreteCollectionMapper asphaltConcreteCollectionMapper;

    /**
     * 查询沥青混凝土收集
     *
     * @param id 沥青混凝土收集主键
     * @return 沥青混凝土收集
     */
    @Override
    public AsphaltConcreteCollection selectAsphaltConcreteCollectionById(String id)
    {
        return asphaltConcreteCollectionMapper.selectAsphaltConcreteCollectionById(id);
    }

    /**
     * 查询沥青混凝土收集列表
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 沥青混凝土收集
     */
    @Override
    public List<AsphaltConcreteCollection> selectAsphaltConcreteCollectionList(AsphaltConcreteCollection asphaltConcreteCollection)
    {
        return asphaltConcreteCollectionMapper.selectAsphaltConcreteCollectionList(asphaltConcreteCollection);
    }

    /**
     * 新增沥青混凝土收集
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 结果
     */
    @Override
    public int insertAsphaltConcreteCollection(AsphaltConcreteCollection asphaltConcreteCollection)
    {
        return asphaltConcreteCollectionMapper.insertAsphaltConcreteCollection(asphaltConcreteCollection);
    }

    /**
     * 修改沥青混凝土收集
     *
     * @param asphaltConcreteCollection 沥青混凝土收集
     * @return 结果
     */
    @Override
    public int updateAsphaltConcreteCollection(AsphaltConcreteCollection asphaltConcreteCollection)
    {
        return asphaltConcreteCollectionMapper.updateAsphaltConcreteCollection(asphaltConcreteCollection);
    }

    /**
     * 批量删除沥青混凝土收集
     *
     * @param ids 需要删除的沥青混凝土收集主键
     * @return 结果
     */
    @Override
    public int deleteAsphaltConcreteCollectionByIds(String[] ids)
    {
        return asphaltConcreteCollectionMapper.deleteAsphaltConcreteCollectionByIds(ids);
    }

    /**
     * 删除沥青混凝土收集信息
     *
     * @param id 沥青混凝土收集主键
     * @return 结果
     */
    @Override
    public int deleteAsphaltConcreteCollectionById(String id)
    {
        return asphaltConcreteCollectionMapper.deleteAsphaltConcreteCollectionById(id);
    }

    @Override
    public List<Map<String, Object>> queryBar(Map<String, Object> params) {
        return asphaltConcreteCollectionMapper.queryBar(params);
    }
}
