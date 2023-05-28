package com.ruoyi.cementstabilized.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cementstabilized.mapper.CementStabilizedMapper;
import com.ruoyi.cementstabilized.domain.CementStabilized;
import com.ruoyi.cementstabilized.service.ICementStabilizedService;

/**
 * 水泥稳定碎石集料Service业务层处理
 *
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class CementStabilizedServiceImpl implements ICementStabilizedService
{
    @Autowired
    private CementStabilizedMapper cementStabilizedMapper;

    /**
     * 查询水泥稳定碎石集料
     *
     * @param id 水泥稳定碎石集料主键
     * @return 水泥稳定碎石集料
     */
    @Override
    public CementStabilized selectCementStabilizedById(String id)
    {
        return cementStabilizedMapper.selectCementStabilizedById(id);
    }

    /**
     * 查询水泥稳定碎石集料列表
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 水泥稳定碎石集料
     */
    @Override
    public List<CementStabilized> selectCementStabilizedList(CementStabilized cementStabilized)
    {
        return cementStabilizedMapper.selectCementStabilizedList(cementStabilized);
    }

    /**
     * 新增水泥稳定碎石集料
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 结果
     */
    @Override
    public int insertCementStabilized(CementStabilized cementStabilized)
    {
        return cementStabilizedMapper.insertCementStabilized(cementStabilized);
    }

    /**
     * 修改水泥稳定碎石集料
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 结果
     */
    @Override
    public int updateCementStabilized(CementStabilized cementStabilized)
    {
        return cementStabilizedMapper.updateCementStabilized(cementStabilized);
    }

    /**
     * 批量删除水泥稳定碎石集料
     *
     * @param ids 需要删除的水泥稳定碎石集料主键
     * @return 结果
     */
    @Override
    public int deleteCementStabilizedByIds(String[] ids)
    {
        return cementStabilizedMapper.deleteCementStabilizedByIds(ids);
    }

    /**
     * 删除水泥稳定碎石集料信息
     *
     * @param id 水泥稳定碎石集料主键
     * @return 结果
     */
    @Override
    public int deleteCementStabilizedById(String id)
    {
        return cementStabilizedMapper.deleteCementStabilizedById(id);
    }

    @Override
    public List<Map<String, Object>> queryBar(Map<String, Object> params) {
        return cementStabilizedMapper.queryBar(params);
    }
}
