package com.ruoyi.pollutant.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.pollutant.domain.PollutantDict;
import com.ruoyi.pollutant.service.IPollutantDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 污染物排放Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/pollutant/pollutantdict")
public class PollutantDictController extends BaseController
{
    @Autowired
    private IPollutantDictService pollutantDictService;

    /**
     * 查询污染物排放列表
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:list')")
    @GetMapping("/list")
    public TableDataInfo list(PollutantDict pollutantDict)
    {
        startPage();
        List<PollutantDict> list = pollutantDictService.selectPollutantDictList(pollutantDict);
        return getDataTable(list);
    }

    /**
     * 导出污染物排放列表
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:export')")
    @Log(title = "污染物排放", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PollutantDict pollutantDict)
    {
        List<PollutantDict> list = pollutantDictService.selectPollutantDictList(pollutantDict);
        ExcelUtil<PollutantDict> util = new ExcelUtil<PollutantDict>(PollutantDict.class);
        util.exportExcel(response, list, "污染物排放数据");
    }

    /**
     * 获取污染物排放详细信息
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(pollutantDictService.selectPollutantDictById(id));
    }

    /**
     * 新增污染物排放
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:add')")
    @Log(title = "污染物排放", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PollutantDict pollutantDict)
    {
        return toAjax(pollutantDictService.insertPollutantDict(pollutantDict));
    }

    /**
     * 修改污染物排放
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:edit')")
    @Log(title = "污染物排放", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PollutantDict pollutantDict)
    {
        return toAjax(pollutantDictService.updatePollutantDict(pollutantDict));
    }

    /**
     * 删除污染物排放
     */
    @PreAuthorize("@ss.hasPermi('pollutant:pollutantdict:remove')")
    @Log(title = "污染物排放", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(pollutantDictService.deletePollutantDictByIds(ids));
    }
}
