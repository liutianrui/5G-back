package com.ruoyi.video.controller;

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
import com.ruoyi.video.domain.VideoInfo;
import com.ruoyi.video.service.IVideoInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频监控信息Controller
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@RestController
@RequestMapping("/video/videoinfo")
public class VideoInfoController extends BaseController
{
    @Autowired
    private IVideoInfoService videoInfoService;

    /**
     * 查询视频监控信息列表
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(VideoInfo videoInfo)
    {
        startPage();
        List<VideoInfo> list = videoInfoService.selectVideoInfoList(videoInfo);
        return getDataTable(list);
    }

    /**
     * 导出视频监控信息列表
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:export')")
    @Log(title = "视频监控信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VideoInfo videoInfo)
    {
        List<VideoInfo> list = videoInfoService.selectVideoInfoList(videoInfo);
        ExcelUtil<VideoInfo> util = new ExcelUtil<VideoInfo>(VideoInfo.class);
        util.exportExcel(response, list, "视频监控信息数据");
    }

    /**
     * 获取视频监控信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(videoInfoService.selectVideoInfoById(id));
    }

    /**
     * 新增视频监控信息
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:add')")
    @Log(title = "视频监控信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VideoInfo videoInfo)
    {
        return toAjax(videoInfoService.insertVideoInfo(videoInfo));
    }

    /**
     * 修改视频监控信息
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:edit')")
    @Log(title = "视频监控信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VideoInfo videoInfo)
    {
        return toAjax(videoInfoService.updateVideoInfo(videoInfo));
    }

    /**
     * 删除视频监控信息
     */
    @PreAuthorize("@ss.hasPermi('video:videoinfo:remove')")
    @Log(title = "视频监控信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(videoInfoService.deleteVideoInfoByIds(ids));
    }
}
