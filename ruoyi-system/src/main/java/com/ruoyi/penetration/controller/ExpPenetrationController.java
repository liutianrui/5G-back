package com.ruoyi.penetration.controller;

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
import com.ruoyi.penetration.domain.ExpPenetration;
import com.ruoyi.penetration.service.IExpPenetrationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 针入度实验Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/penetration/exppenetration")
public class ExpPenetrationController extends BaseController
{
    @Autowired
    private IExpPenetrationService expPenetrationService;

    /**
     * 查询针入度实验列表
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpPenetration expPenetration)
    {
        startPage();
        List<ExpPenetration> list = expPenetrationService.selectExpPenetrationList(expPenetration);
        return getDataTable(list);
    }

    /**
     * 导出针入度实验列表
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:export')")
    @Log(title = "针入度实验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpPenetration expPenetration)
    {
        List<ExpPenetration> list = expPenetrationService.selectExpPenetrationList(expPenetration);
        ExcelUtil<ExpPenetration> util = new ExcelUtil<ExpPenetration>(ExpPenetration.class);
        util.exportExcel(response, list, "针入度实验数据");
    }

    /**
     * 获取针入度实验详细信息
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expPenetrationService.selectExpPenetrationById(id));
    }

    /**
     * 新增针入度实验
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:add')")
    @Log(title = "针入度实验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpPenetration expPenetration)
    {
        return toAjax(expPenetrationService.insertExpPenetration(expPenetration));
    }

    /**
     * 修改针入度实验
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:edit')")
    @Log(title = "针入度实验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpPenetration expPenetration)
    {
        return toAjax(expPenetrationService.updateExpPenetration(expPenetration));
    }

    /**
     * 删除针入度实验
     */
    @PreAuthorize("@ss.hasPermi('penetration:exppenetration:remove')")
    @Log(title = "针入度实验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expPenetrationService.deleteExpPenetrationByIds(ids));
    }
}
