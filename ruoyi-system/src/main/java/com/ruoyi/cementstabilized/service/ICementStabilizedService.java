package com.ruoyi.cementstabilized.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.cementstabilized.domain.CementStabilized;

/**
 * 水泥稳定碎石集料Service接口
 *
 * @author liutianrui
 * @date 2023-05-28
 */
public interface ICementStabilizedService
{
    /**
     * 查询水泥稳定碎石集料
     *
     * @param id 水泥稳定碎石集料主键
     * @return 水泥稳定碎石集料
     */
    public CementStabilized selectCementStabilizedById(String id);

    /**
     * 查询水泥稳定碎石集料列表
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 水泥稳定碎石集料集合
     */
    public List<CementStabilized> selectCementStabilizedList(CementStabilized cementStabilized);

    /**
     * 新增水泥稳定碎石集料
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 结果
     */
    public int insertCementStabilized(CementStabilized cementStabilized);

    /**
     * 修改水泥稳定碎石集料
     *
     * @param cementStabilized 水泥稳定碎石集料
     * @return 结果
     */
    public int updateCementStabilized(CementStabilized cementStabilized);

    /**
     * 批量删除水泥稳定碎石集料
     *
     * @param ids 需要删除的水泥稳定碎石集料主键集合
     * @return 结果
     */
    public int deleteCementStabilizedByIds(String[] ids);

    /**
     * 删除水泥稳定碎石集料信息
     *
     * @param id 水泥稳定碎石集料主键
     * @return 结果
     */
    public int deleteCementStabilizedById(String id);

    //查询柱状图数据，按天分组
    List<Map<String,Object>> queryBar(Map<String,Object> params);
}
