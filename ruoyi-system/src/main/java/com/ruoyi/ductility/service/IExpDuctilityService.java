package com.ruoyi.ductility.service;

import java.util.List;
import com.ruoyi.ductility.domain.ExpDuctility;

/**
 * 延展性实验Service接口
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public interface IExpDuctilityService 
{
    /**
     * 查询延展性实验
     * 
     * @param id 延展性实验主键
     * @return 延展性实验
     */
    public ExpDuctility selectExpDuctilityById(String id);

    /**
     * 查询延展性实验列表
     * 
     * @param expDuctility 延展性实验
     * @return 延展性实验集合
     */
    public List<ExpDuctility> selectExpDuctilityList(ExpDuctility expDuctility);

    /**
     * 新增延展性实验
     * 
     * @param expDuctility 延展性实验
     * @return 结果
     */
    public int insertExpDuctility(ExpDuctility expDuctility);

    /**
     * 修改延展性实验
     * 
     * @param expDuctility 延展性实验
     * @return 结果
     */
    public int updateExpDuctility(ExpDuctility expDuctility);

    /**
     * 批量删除延展性实验
     * 
     * @param ids 需要删除的延展性实验主键集合
     * @return 结果
     */
    public int deleteExpDuctilityByIds(String[] ids);

    /**
     * 删除延展性实验信息
     * 
     * @param id 延展性实验主键
     * @return 结果
     */
    public int deleteExpDuctilityById(String id);
}
