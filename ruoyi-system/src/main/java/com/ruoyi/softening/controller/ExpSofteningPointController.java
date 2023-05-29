package com.ruoyi.softening.controller;

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
import com.ruoyi.softening.domain.ExpSofteningPoint;
import com.ruoyi.softening.service.IExpSofteningPointService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 软化点实验Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/softening/softeningpoint")
public class ExpSofteningPointController extends BaseController
{
    @Autowired
    private IExpSofteningPointService expSofteningPointService;

    /**
     * 查询软化点实验列表
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpSofteningPoint expSofteningPoint)
    {
        startPage();
        List<ExpSofteningPoint> list = expSofteningPointService.selectExpSofteningPointList(expSofteningPoint);
        return getDataTable(list);
    }

    /**
     * 导出软化点实验列表
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:export')")
    @Log(title = "软化点实验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpSofteningPoint expSofteningPoint)
    {
        List<ExpSofteningPoint> list = expSofteningPointService.selectExpSofteningPointList(expSofteningPoint);
        ExcelUtil<ExpSofteningPoint> util = new ExcelUtil<ExpSofteningPoint>(ExpSofteningPoint.class);
        util.exportExcel(response, list, "软化点实验数据");
    }

    /**
     * 获取软化点实验详细信息
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expSofteningPointService.selectExpSofteningPointById(id));
    }

    /**
     * 新增软化点实验
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:add')")
    @Log(title = "软化点实验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpSofteningPoint expSofteningPoint)
    {
        return toAjax(expSofteningPointService.insertExpSofteningPoint(expSofteningPoint));
    }

    /**
     * 修改软化点实验
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:edit')")
    @Log(title = "软化点实验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpSofteningPoint expSofteningPoint)
    {
        return toAjax(expSofteningPointService.updateExpSofteningPoint(expSofteningPoint));
    }

    /**
     * 删除软化点实验
     */
    @PreAuthorize("@ss.hasPermi('softening:softeningpoint:remove')")
    @Log(title = "软化点实验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expSofteningPointService.deleteExpSofteningPointByIds(ids));
    }
}
