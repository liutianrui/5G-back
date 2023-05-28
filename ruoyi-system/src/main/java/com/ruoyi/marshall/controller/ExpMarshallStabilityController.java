package com.ruoyi.marshall.controller;

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
import com.ruoyi.marshall.domain.ExpMarshallStability;
import com.ruoyi.marshall.service.IExpMarshallStabilityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 马歇尔稳定性实验Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/marshall/marshallstability")
public class ExpMarshallStabilityController extends BaseController
{
    @Autowired
    private IExpMarshallStabilityService expMarshallStabilityService;

    /**
     * 查询马歇尔稳定性实验列表
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpMarshallStability expMarshallStability)
    {
        startPage();
        List<ExpMarshallStability> list = expMarshallStabilityService.selectExpMarshallStabilityList(expMarshallStability);
        return getDataTable(list);
    }

    /**
     * 导出马歇尔稳定性实验列表
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:export')")
    @Log(title = "马歇尔稳定性实验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpMarshallStability expMarshallStability)
    {
        List<ExpMarshallStability> list = expMarshallStabilityService.selectExpMarshallStabilityList(expMarshallStability);
        ExcelUtil<ExpMarshallStability> util = new ExcelUtil<ExpMarshallStability>(ExpMarshallStability.class);
        util.exportExcel(response, list, "马歇尔稳定性实验数据");
    }

    /**
     * 获取马歇尔稳定性实验详细信息
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expMarshallStabilityService.selectExpMarshallStabilityById(id));
    }

    /**
     * 新增马歇尔稳定性实验
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:add')")
    @Log(title = "马歇尔稳定性实验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpMarshallStability expMarshallStability)
    {
        return toAjax(expMarshallStabilityService.insertExpMarshallStability(expMarshallStability));
    }

    /**
     * 修改马歇尔稳定性实验
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:edit')")
    @Log(title = "马歇尔稳定性实验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpMarshallStability expMarshallStability)
    {
        return toAjax(expMarshallStabilityService.updateExpMarshallStability(expMarshallStability));
    }

    /**
     * 删除马歇尔稳定性实验
     */
    @PreAuthorize("@ss.hasPermi('marshall:marshallstability:remove')")
    @Log(title = "马歇尔稳定性实验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expMarshallStabilityService.deleteExpMarshallStabilityByIds(ids));
    }
}
