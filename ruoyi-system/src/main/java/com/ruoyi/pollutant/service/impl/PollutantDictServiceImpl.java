package com.ruoyi.pollutant.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pollutant.mapper.PollutantDictMapper;
import com.ruoyi.pollutant.domain.PollutantDict;
import com.ruoyi.pollutant.service.IPollutantDictService;

/**
 * 污染物排放Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class PollutantDictServiceImpl implements IPollutantDictService 
{
    @Autowired
    private PollutantDictMapper pollutantDictMapper;

    /**
     * 查询污染物排放
     * 
     * @param id 污染物排放主键
     * @return 污染物排放
     */
    @Override
    public PollutantDict selectPollutantDictById(String id)
    {
        return pollutantDictMapper.selectPollutantDictById(id);
    }

    /**
     * 查询污染物排放列表
     * 
     * @param pollutantDict 污染物排放
     * @return 污染物排放
     */
    @Override
    public List<PollutantDict> selectPollutantDictList(PollutantDict pollutantDict)
    {
        return pollutantDictMapper.selectPollutantDictList(pollutantDict);
    }

    /**
     * 新增污染物排放
     * 
     * @param pollutantDict 污染物排放
     * @return 结果
     */
    @Override
    public int insertPollutantDict(PollutantDict pollutantDict)
    {
        return pollutantDictMapper.insertPollutantDict(pollutantDict);
    }

    /**
     * 修改污染物排放
     * 
     * @param pollutantDict 污染物排放
     * @return 结果
     */
    @Override
    public int updatePollutantDict(PollutantDict pollutantDict)
    {
        return pollutantDictMapper.updatePollutantDict(pollutantDict);
    }

    /**
     * 批量删除污染物排放
     * 
     * @param ids 需要删除的污染物排放主键
     * @return 结果
     */
    @Override
    public int deletePollutantDictByIds(String[] ids)
    {
        return pollutantDictMapper.deletePollutantDictByIds(ids);
    }

    /**
     * 删除污染物排放信息
     * 
     * @param id 污染物排放主键
     * @return 结果
     */
    @Override
    public int deletePollutantDictById(String id)
    {
        return pollutantDictMapper.deletePollutantDictById(id);
    }
}
