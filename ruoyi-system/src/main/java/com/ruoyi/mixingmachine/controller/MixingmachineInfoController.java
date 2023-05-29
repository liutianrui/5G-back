package com.ruoyi.mixingmachine.controller;

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
import com.ruoyi.mixingmachine.domain.MixingmachineInfo;
import com.ruoyi.mixingmachine.service.IMixingmachineInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 搅拌机信息Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/mixingmachine/mixingmachineinfo")
public class MixingmachineInfoController extends BaseController
{
    @Autowired
    private IMixingmachineInfoService mixingmachineInfoService;

    /**
     * 查询搅拌机信息列表
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MixingmachineInfo mixingmachineInfo)
    {
        startPage();
        List<MixingmachineInfo> list = mixingmachineInfoService.selectMixingmachineInfoList(mixingmachineInfo);
        return getDataTable(list);
    }

    /**
     * 导出搅拌机信息列表
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:export')")
    @Log(title = "搅拌机信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MixingmachineInfo mixingmachineInfo)
    {
        List<MixingmachineInfo> list = mixingmachineInfoService.selectMixingmachineInfoList(mixingmachineInfo);
        ExcelUtil<MixingmachineInfo> util = new ExcelUtil<MixingmachineInfo>(MixingmachineInfo.class);
        util.exportExcel(response, list, "搅拌机信息数据");
    }

    /**
     * 获取搅拌机信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:query')")
    @GetMapping(value = "/{mixingmachineId}")
    public AjaxResult getInfo(@PathVariable("mixingmachineId") String mixingmachineId)
    {
        return success(mixingmachineInfoService.selectMixingmachineInfoByMixingmachineId(mixingmachineId));
    }

    /**
     * 新增搅拌机信息
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:add')")
    @Log(title = "搅拌机信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MixingmachineInfo mixingmachineInfo)
    {
        return toAjax(mixingmachineInfoService.insertMixingmachineInfo(mixingmachineInfo));
    }

    /**
     * 修改搅拌机信息
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:edit')")
    @Log(title = "搅拌机信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MixingmachineInfo mixingmachineInfo)
    {
        return toAjax(mixingmachineInfoService.updateMixingmachineInfo(mixingmachineInfo));
    }

    /**
     * 删除搅拌机信息
     */
    @PreAuthorize("@ss.hasPermi('mixingmachine:mixingmachineinfo:remove')")
    @Log(title = "搅拌机信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{mixingmachineIds}")
    public AjaxResult remove(@PathVariable String[] mixingmachineIds)
    {
        return toAjax(mixingmachineInfoService.deleteMixingmachineInfoByMixingmachineIds(mixingmachineIds));
    }
}
