package com.ruoyi.monitor.controller;

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
import com.ruoyi.monitor.domain.ContaminantMonitor;
import com.ruoyi.monitor.service.IContaminantMonitorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 污染物监测器Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/contaminant/monitor")
public class ContaminantMonitorController extends BaseController
{
    @Autowired
    private IContaminantMonitorService contaminantMonitorService;

    /**
     * 查询污染物监测器列表
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(ContaminantMonitor contaminantMonitor)
    {
        startPage();
        List<ContaminantMonitor> list = contaminantMonitorService.selectContaminantMonitorList(contaminantMonitor);
        return getDataTable(list);
    }

    /**
     * 导出污染物监测器列表
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:export')")
    @Log(title = "污染物监测器", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ContaminantMonitor contaminantMonitor)
    {
        List<ContaminantMonitor> list = contaminantMonitorService.selectContaminantMonitorList(contaminantMonitor);
        ExcelUtil<ContaminantMonitor> util = new ExcelUtil<ContaminantMonitor>(ContaminantMonitor.class);
        util.exportExcel(response, list, "污染物监测器数据");
    }

    /**
     * 获取污染物监测器详细信息
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(contaminantMonitorService.selectContaminantMonitorById(id));
    }

    /**
     * 新增污染物监测器
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:add')")
    @Log(title = "污染物监测器", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ContaminantMonitor contaminantMonitor)
    {
        return toAjax(contaminantMonitorService.insertContaminantMonitor(contaminantMonitor));
    }

    /**
     * 修改污染物监测器
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:edit')")
    @Log(title = "污染物监测器", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ContaminantMonitor contaminantMonitor)
    {
        return toAjax(contaminantMonitorService.updateContaminantMonitor(contaminantMonitor));
    }

    /**
     * 删除污染物监测器
     */
    @PreAuthorize("@ss.hasPermi('contaminant:monitor:remove')")
    @Log(title = "污染物监测器", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(contaminantMonitorService.deleteContaminantMonitorByIds(ids));
    }
}
