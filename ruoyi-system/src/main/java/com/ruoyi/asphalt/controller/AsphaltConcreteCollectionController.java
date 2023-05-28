package com.ruoyi.asphalt.controller;

import com.ruoyi.asphalt.domain.AsphaltConcreteCollection;
import com.ruoyi.asphalt.service.IAsphaltConcreteCollectionService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.Result;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 沥青混凝土收集Controller
 *
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/asphalt/asphalt_concrete_collection")
public class AsphaltConcreteCollectionController extends BaseController
{
    @Autowired
    private IAsphaltConcreteCollectionService asphaltConcreteCollectionService;

    /**
     * 查询沥青混凝土收集列表
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:list')")
    @GetMapping("/list")
    public TableDataInfo list(AsphaltConcreteCollection asphaltConcreteCollection)
    {
        startPage();
        List<AsphaltConcreteCollection> list = asphaltConcreteCollectionService.selectAsphaltConcreteCollectionList(asphaltConcreteCollection);
        return getDataTable(list);
    }

    /**
     * 导出沥青混凝土收集列表
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:export')")
    @Log(title = "沥青混凝土收集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AsphaltConcreteCollection asphaltConcreteCollection)
    {
        List<AsphaltConcreteCollection> list = asphaltConcreteCollectionService.selectAsphaltConcreteCollectionList(asphaltConcreteCollection);
        ExcelUtil<AsphaltConcreteCollection> util = new ExcelUtil<AsphaltConcreteCollection>(AsphaltConcreteCollection.class);
        util.exportExcel(response, list, "沥青混凝土收集数据");
    }

    /**
     * 获取沥青混凝土收集详细信息
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(asphaltConcreteCollectionService.selectAsphaltConcreteCollectionById(id));
    }

    /**
     * 新增沥青混凝土收集
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:add')")
    @Log(title = "沥青混凝土收集", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AsphaltConcreteCollection asphaltConcreteCollection)
    {
        return toAjax(asphaltConcreteCollectionService.insertAsphaltConcreteCollection(asphaltConcreteCollection));
    }

    /**
     * 修改沥青混凝土收集
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:edit')")
    @Log(title = "沥青混凝土收集", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AsphaltConcreteCollection asphaltConcreteCollection)
    {
        return toAjax(asphaltConcreteCollectionService.updateAsphaltConcreteCollection(asphaltConcreteCollection));
    }

    /**
     * 删除沥青混凝土收集
     */
    @PreAuthorize("@ss.hasPermi('asphalt:asphalt_concrete_collection:remove')")
    @Log(title = "沥青混凝土收集", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(asphaltConcreteCollectionService.deleteAsphaltConcreteCollectionByIds(ids));
    }

    @GetMapping("queryBar")
//    @ApiOperation("查询柱状图")
//    @PreAuthorize("hasAuthority('cementstabilizedmacadamcollection:queryBar')")
    public Result queryBar(@RequestParam Map<String,Object> params){
        List<Map<String, Object>> mapList = asphaltConcreteCollectionService.queryBar(params);
        return Result.ok(mapList);
    }
}
