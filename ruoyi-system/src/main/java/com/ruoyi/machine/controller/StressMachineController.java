package com.ruoyi.machine.controller;

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
import com.ruoyi.machine.domain.StressMachine;
import com.ruoyi.machine.service.IStressMachineService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 压力机Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/machine/stressmachine")
public class StressMachineController extends BaseController
{
    @Autowired
    private IStressMachineService stressMachineService;

    /**
     * 查询压力机列表
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:list')")
    @GetMapping("/list")
    public TableDataInfo list(StressMachine stressMachine)
    {
        startPage();
        List<StressMachine> list = stressMachineService.selectStressMachineList(stressMachine);
        return getDataTable(list);
    }

    /**
     * 导出压力机列表
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:export')")
    @Log(title = "压力机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StressMachine stressMachine)
    {
        List<StressMachine> list = stressMachineService.selectStressMachineList(stressMachine);
        ExcelUtil<StressMachine> util = new ExcelUtil<StressMachine>(StressMachine.class);
        util.exportExcel(response, list, "压力机数据");
    }

    /**
     * 获取压力机详细信息
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(stressMachineService.selectStressMachineById(id));
    }

    /**
     * 新增压力机
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:add')")
    @Log(title = "压力机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StressMachine stressMachine)
    {
        return toAjax(stressMachineService.insertStressMachine(stressMachine));
    }

    /**
     * 修改压力机
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:edit')")
    @Log(title = "压力机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StressMachine stressMachine)
    {
        return toAjax(stressMachineService.updateStressMachine(stressMachine));
    }

    /**
     * 删除压力机
     */
    @PreAuthorize("@ss.hasPermi('machine:stressmachine:remove')")
    @Log(title = "压力机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(stressMachineService.deleteStressMachineByIds(ids));
    }
}
