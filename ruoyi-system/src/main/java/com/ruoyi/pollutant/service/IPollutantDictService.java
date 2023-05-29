package com.ruoyi.pollutant.service;

import java.util.List;
import com.ruoyi.pollutant.domain.PollutantDict;

/**
 * 污染物排放Service接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface IPollutantDictService 
{
    /**
     * 查询污染物排放
     * 
     * @param id 污染物排放主键
     * @return 污染物排放
     */
    public PollutantDict selectPollutantDictById(String id);

    /**
     * 查询污染物排放列表
     * 
     * @param pollutantDict 污染物排放
     * @return 污染物排放集合
     */
    public List<PollutantDict> selectPollutantDictList(PollutantDict pollutantDict);

    /**
     * 新增污染物排放
     * 
     * @param pollutantDict 污染物排放
     * @return 结果
     */
    public int insertPollutantDict(PollutantDict pollutantDict);

    /**
     * 修改污染物排放
     * 
     * @param pollutantDict 污染物排放
     * @return 结果
     */
    public int updatePollutantDict(PollutantDict pollutantDict);

    /**
     * 批量删除污染物排放
     * 
     * @param ids 需要删除的污染物排放主键集合
     * @return 结果
     */
    public int deletePollutantDictByIds(String[] ids);

    /**
     * 删除污染物排放信息
     * 
     * @param id 污染物排放主键
     * @return 结果
     */
    public int deletePollutantDictById(String id);
}
