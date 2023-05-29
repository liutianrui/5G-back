package com.ruoyi.video.service;

import java.util.List;
import com.ruoyi.video.domain.VideoInfo;

/**
 * 视频监控信息Service接口
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public interface IVideoInfoService 
{
    /**
     * 查询视频监控信息
     * 
     * @param id 视频监控信息主键
     * @return 视频监控信息
     */
    public VideoInfo selectVideoInfoById(String id);

    /**
     * 查询视频监控信息列表
     * 
     * @param videoInfo 视频监控信息
     * @return 视频监控信息集合
     */
    public List<VideoInfo> selectVideoInfoList(VideoInfo videoInfo);

    /**
     * 新增视频监控信息
     * 
     * @param videoInfo 视频监控信息
     * @return 结果
     */
    public int insertVideoInfo(VideoInfo videoInfo);

    /**
     * 修改视频监控信息
     * 
     * @param videoInfo 视频监控信息
     * @return 结果
     */
    public int updateVideoInfo(VideoInfo videoInfo);

    /**
     * 批量删除视频监控信息
     * 
     * @param ids 需要删除的视频监控信息主键集合
     * @return 结果
     */
    public int deleteVideoInfoByIds(String[] ids);

    /**
     * 删除视频监控信息信息
     * 
     * @param id 视频监控信息主键
     * @return 结果
     */
    public int deleteVideoInfoById(String id);
}
