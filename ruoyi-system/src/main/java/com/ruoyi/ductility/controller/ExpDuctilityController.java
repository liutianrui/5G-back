package com.ruoyi.ductility.controller;

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
import com.ruoyi.ductility.domain.ExpDuctility;
import com.ruoyi.ductility.service.IExpDuctilityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 延展性实验Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/ductility/expductility")
public class ExpDuctilityController extends BaseController
{
    @Autowired
    private IExpDuctilityService expDuctilityService;

    /**
     * 查询延展性实验列表
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpDuctility expDuctility)
    {
        startPage();
        List<ExpDuctility> list = expDuctilityService.selectExpDuctilityList(expDuctility);
        return getDataTable(list);
    }

    /**
     * 导出延展性实验列表
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:export')")
    @Log(title = "延展性实验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpDuctility expDuctility)
    {
        List<ExpDuctility> list = expDuctilityService.selectExpDuctilityList(expDuctility);
        ExcelUtil<ExpDuctility> util = new ExcelUtil<ExpDuctility>(ExpDuctility.class);
        util.exportExcel(response, list, "延展性实验数据");
    }

    /**
     * 获取延展性实验详细信息
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expDuctilityService.selectExpDuctilityById(id));
    }

    /**
     * 新增延展性实验
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:add')")
    @Log(title = "延展性实验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpDuctility expDuctility)
    {
        return toAjax(expDuctilityService.insertExpDuctility(expDuctility));
    }

    /**
     * 修改延展性实验
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:edit')")
    @Log(title = "延展性实验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpDuctility expDuctility)
    {
        return toAjax(expDuctilityService.updateExpDuctility(expDuctility));
    }

    /**
     * 删除延展性实验
     */
    @PreAuthorize("@ss.hasPermi('ductility:expductility:remove')")
    @Log(title = "延展性实验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expDuctilityService.deleteExpDuctilityByIds(ids));
    }
}
