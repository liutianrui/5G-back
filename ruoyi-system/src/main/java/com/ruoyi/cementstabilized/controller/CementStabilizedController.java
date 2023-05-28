package com.ruoyi.cementstabilized.controller;

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
import com.ruoyi.cementstabilized.domain.CementStabilized;
import com.ruoyi.cementstabilized.service.ICementStabilizedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水泥稳定碎石集料Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/cementstabilized/cementstabilized")
public class CementStabilizedController extends BaseController
{
    @Autowired
    private ICementStabilizedService cementStabilizedService;

    /**
     * 查询水泥稳定碎石集料列表
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:list')")
    @GetMapping("/list")
    public TableDataInfo list(CementStabilized cementStabilized)
    {
        startPage();
        List<CementStabilized> list = cementStabilizedService.selectCementStabilizedList(cementStabilized);
        return getDataTable(list);
    }

    /**
     * 导出水泥稳定碎石集料列表
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:export')")
    @Log(title = "水泥稳定碎石集料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CementStabilized cementStabilized)
    {
        List<CementStabilized> list = cementStabilizedService.selectCementStabilizedList(cementStabilized);
        ExcelUtil<CementStabilized> util = new ExcelUtil<CementStabilized>(CementStabilized.class);
        util.exportExcel(response, list, "水泥稳定碎石集料数据");
    }

    /**
     * 获取水泥稳定碎石集料详细信息
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(cementStabilizedService.selectCementStabilizedById(id));
    }

    /**
     * 新增水泥稳定碎石集料
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:add')")
    @Log(title = "水泥稳定碎石集料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CementStabilized cementStabilized)
    {
        return toAjax(cementStabilizedService.insertCementStabilized(cementStabilized));
    }

    /**
     * 修改水泥稳定碎石集料
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:edit')")
    @Log(title = "水泥稳定碎石集料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CementStabilized cementStabilized)
    {
        return toAjax(cementStabilizedService.updateCementStabilized(cementStabilized));
    }

    /**
     * 删除水泥稳定碎石集料
     */
    @PreAuthorize("@ss.hasPermi('cementstabilized:cementstabilized:remove')")
    @Log(title = "水泥稳定碎石集料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(cementStabilizedService.deleteCementStabilizedByIds(ids));
    }
}
