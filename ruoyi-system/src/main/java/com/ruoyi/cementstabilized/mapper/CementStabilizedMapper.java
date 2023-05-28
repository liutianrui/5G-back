package com.ruoyi.cementstabilized.mapper;

import java.util.List;
import com.ruoyi.cementstabilized.domain.CementStabilized;

/**
 * 水泥稳定碎石集料Mapper接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface CementStabilizedMapper 
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
     * 删除水泥稳定碎石集料
     * 
     * @param id 水泥稳定碎石集料主键
     * @return 结果
     */
    public int deleteCementStabilizedById(String id);

    /**
     * 批量删除水泥稳定碎石集料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCementStabilizedByIds(String[] ids);
}
