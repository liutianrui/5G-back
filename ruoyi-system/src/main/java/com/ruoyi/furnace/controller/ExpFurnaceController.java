package com.ruoyi.furnace.controller;

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
import com.ruoyi.furnace.domain.ExpFurnace;
import com.ruoyi.furnace.service.IExpFurnaceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实验炉Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/furnace/expfurnace")
public class ExpFurnaceController extends BaseController
{
    @Autowired
    private IExpFurnaceService expFurnaceService;

    /**
     * 查询实验炉列表
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpFurnace expFurnace)
    {
        startPage();
        List<ExpFurnace> list = expFurnaceService.selectExpFurnaceList(expFurnace);
        return getDataTable(list);
    }

    /**
     * 导出实验炉列表
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:export')")
    @Log(title = "实验炉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpFurnace expFurnace)
    {
        List<ExpFurnace> list = expFurnaceService.selectExpFurnaceList(expFurnace);
        ExcelUtil<ExpFurnace> util = new ExcelUtil<ExpFurnace>(ExpFurnace.class);
        util.exportExcel(response, list, "实验炉数据");
    }

    /**
     * 获取实验炉详细信息
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expFurnaceService.selectExpFurnaceById(id));
    }

    /**
     * 新增实验炉
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:add')")
    @Log(title = "实验炉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpFurnace expFurnace)
    {
        return toAjax(expFurnaceService.insertExpFurnace(expFurnace));
    }

    /**
     * 修改实验炉
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:edit')")
    @Log(title = "实验炉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpFurnace expFurnace)
    {
        return toAjax(expFurnaceService.updateExpFurnace(expFurnace));
    }

    /**
     * 删除实验炉
     */
    @PreAuthorize("@ss.hasPermi('furnace:expfurnace:remove')")
    @Log(title = "实验炉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expFurnaceService.deleteExpFurnaceByIds(ids));
    }
}
