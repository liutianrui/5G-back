package com.ruoyi.experiment.controller;

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
import com.ruoyi.experiment.domain.ExpCuringRoom;
import com.ruoyi.experiment.service.IExpCuringRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实验养护室Controller
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
@RestController
@RequestMapping("/experiment/curingroom")
public class ExpCuringRoomController extends BaseController
{
    @Autowired
    private IExpCuringRoomService expCuringRoomService;

    /**
     * 查询实验养护室列表
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExpCuringRoom expCuringRoom)
    {
        startPage();
        List<ExpCuringRoom> list = expCuringRoomService.selectExpCuringRoomList(expCuringRoom);
        return getDataTable(list);
    }

    /**
     * 导出实验养护室列表
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:export')")
    @Log(title = "实验养护室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExpCuringRoom expCuringRoom)
    {
        List<ExpCuringRoom> list = expCuringRoomService.selectExpCuringRoomList(expCuringRoom);
        ExcelUtil<ExpCuringRoom> util = new ExcelUtil<ExpCuringRoom>(ExpCuringRoom.class);
        util.exportExcel(response, list, "实验养护室数据");
    }

    /**
     * 获取实验养护室详细信息
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(expCuringRoomService.selectExpCuringRoomById(id));
    }

    /**
     * 新增实验养护室
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:add')")
    @Log(title = "实验养护室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExpCuringRoom expCuringRoom)
    {
        return toAjax(expCuringRoomService.insertExpCuringRoom(expCuringRoom));
    }

    /**
     * 修改实验养护室
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:edit')")
    @Log(title = "实验养护室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExpCuringRoom expCuringRoom)
    {
        return toAjax(expCuringRoomService.updateExpCuringRoom(expCuringRoom));
    }

    /**
     * 删除实验养护室
     */
    @PreAuthorize("@ss.hasPermi('experiment:curingroom:remove')")
    @Log(title = "实验养护室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(expCuringRoomService.deleteExpCuringRoomByIds(ids));
    }
}
