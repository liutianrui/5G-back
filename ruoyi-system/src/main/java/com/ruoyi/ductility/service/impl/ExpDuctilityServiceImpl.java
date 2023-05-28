package com.ruoyi.ductility.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ductility.mapper.ExpDuctilityMapper;
import com.ruoyi.ductility.domain.ExpDuctility;
import com.ruoyi.ductility.service.IExpDuctilityService;

/**
 * 延展性实验Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@Service
public class ExpDuctilityServiceImpl implements IExpDuctilityService 
{
    @Autowired
    private ExpDuctilityMapper expDuctilityMapper;

    /**
     * 查询延展性实验
     * 
     * @param id 延展性实验主键
     * @return 延展性实验
     */
    @Override
    public ExpDuctility selectExpDuctilityById(String id)
    {
        return expDuctilityMapper.selectExpDuctilityById(id);
    }

    /**
     * 查询延展性实验列表
     * 
     * @param expDuctility 延展性实验
     * @return 延展性实验
     */
    @Override
    public List<ExpDuctility> selectExpDuctilityList(ExpDuctility expDuctility)
    {
        return expDuctilityMapper.selectExpDuctilityList(expDuctility);
    }

    /**
     * 新增延展性实验
     * 
     * @param expDuctility 延展性实验
     * @return 结果
     */
    @Override
    public int insertExpDuctility(ExpDuctility expDuctility)
    {
        return expDuctilityMapper.insertExpDuctility(expDuctility);
    }

    /**
     * 修改延展性实验
     * 
     * @param expDuctility 延展性实验
     * @return 结果
     */
    @Override
    public int updateExpDuctility(ExpDuctility expDuctility)
    {
        return expDuctilityMapper.updateExpDuctility(expDuctility);
    }

    /**
     * 批量删除延展性实验
     * 
     * @param ids 需要删除的延展性实验主键
     * @return 结果
     */
    @Override
    public int deleteExpDuctilityByIds(String[] ids)
    {
        return expDuctilityMapper.deleteExpDuctilityByIds(ids);
    }

    /**
     * 删除延展性实验信息
     * 
     * @param id 延展性实验主键
     * @return 结果
     */
    @Override
    public int deleteExpDuctilityById(String id)
    {
        return expDuctilityMapper.deleteExpDuctilityById(id);
    }
}
