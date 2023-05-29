package com.ruoyi.video.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.video.mapper.VideoInfoMapper;
import com.ruoyi.video.domain.VideoInfo;
import com.ruoyi.video.service.IVideoInfoService;

/**
 * 视频监控信息Service业务层处理
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
@Service
public class VideoInfoServiceImpl implements IVideoInfoService 
{
    @Autowired
    private VideoInfoMapper videoInfoMapper;

    /**
     * 查询视频监控信息
     * 
     * @param id 视频监控信息主键
     * @return 视频监控信息
     */
    @Override
    public VideoInfo selectVideoInfoById(String id)
    {
        return videoInfoMapper.selectVideoInfoById(id);
    }

    /**
     * 查询视频监控信息列表
     * 
     * @param videoInfo 视频监控信息
     * @return 视频监控信息
     */
    @Override
    public List<VideoInfo> selectVideoInfoList(VideoInfo videoInfo)
    {
        return videoInfoMapper.selectVideoInfoList(videoInfo);
    }

    /**
     * 新增视频监控信息
     * 
     * @param videoInfo 视频监控信息
     * @return 结果
     */
    @Override
    public int insertVideoInfo(VideoInfo videoInfo)
    {
        return videoInfoMapper.insertVideoInfo(videoInfo);
    }

    /**
     * 修改视频监控信息
     * 
     * @param videoInfo 视频监控信息
     * @return 结果
     */
    @Override
    public int updateVideoInfo(VideoInfo videoInfo)
    {
        return videoInfoMapper.updateVideoInfo(videoInfo);
    }

    /**
     * 批量删除视频监控信息
     * 
     * @param ids 需要删除的视频监控信息主键
     * @return 结果
     */
    @Override
    public int deleteVideoInfoByIds(String[] ids)
    {
        return videoInfoMapper.deleteVideoInfoByIds(ids);
    }

    /**
     * 删除视频监控信息信息
     * 
     * @param id 视频监控信息主键
     * @return 结果
     */
    @Override
    public int deleteVideoInfoById(String id)
    {
        return videoInfoMapper.deleteVideoInfoById(id);
    }
}
