package com.ruoyi.weigh.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.weigh.domain.WeighBridge;
import com.ruoyi.weigh.service.IWeighBridgeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地磅Controller
 *
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/weigh/bridge")
public class WeighBridgeController extends BaseController
{
    @Autowired
    private IWeighBridgeService weighBridgeService;

    /**
     * 查询地磅列表
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:list')")
    @GetMapping("/list")
    public TableDataInfo list(WeighBridge weighBridge)
    {
        startPage();
        List<WeighBridge> list = weighBridgeService.selectWeighBridgeList(weighBridge);
        return getDataTable(list);
    }

    /**
     * 导出地磅列表
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:export')")
    @Log(title = "地磅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WeighBridge weighBridge)
    {
        List<WeighBridge> list = weighBridgeService.selectWeighBridgeList(weighBridge);
        ExcelUtil<WeighBridge> util = new ExcelUtil<WeighBridge>(WeighBridge.class);
        util.exportExcel(response, list, "地磅数据");
    }

    /**
     * 获取地磅详细信息
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(weighBridgeService.selectWeighBridgeById(id));
    }

    /**
     * 新增地磅
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:add')")
    @Log(title = "地磅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WeighBridge weighBridge)
    {
        return toAjax(weighBridgeService.insertWeighBridge(weighBridge));
    }

    /**
     * 修改地磅
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:edit')")
    @Log(title = "地磅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WeighBridge weighBridge)
    {
        return toAjax(weighBridgeService.updateWeighBridge(weighBridge));
    }

    /**
     * 删除地磅
     */
    @PreAuthorize("@ss.hasPermi('weigh:bridge:remove')")
    @Log(title = "地磅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(weighBridgeService.deleteWeighBridgeByIds(ids));
    }

    @GetMapping("queryBar")
//    @ApiOperation("查询柱状图")
//    @PreAuthorize("hasAuthority('weightbridge:queryBar')")
    public Result queryBar(@RequestParam Map<String,Object> params){
        List<Map<String, Object>> mapList = weighBridgeService.queryByBar(params);
        return Result.ok(mapList);
    }

    @GetMapping("queryPie")
//    @ApiOperation("查询饼图")
//    @PreAuthorize("hasAuthority('weightbridge:queryPie')")
    public Result queryPie(@RequestParam Map<String,Object> params){
        List<Map<String, Object>> mapList = weighBridgeService.queryByPie(params);
        return Result.ok(mapList);
    }
}
