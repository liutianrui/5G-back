package com.ruoyi.video.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频监控信息对象 video_info
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class VideoInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 视频名称 */
    @Excel(name = "视频名称")
    private String videoName;

    /** 设备序列号 */
    @Excel(name = "设备序列号")
    private String deviceSerial;

    /** 通道号 */
    @Excel(name = "通道号")
    private String channelNo;

    /** 验证码 */
    @Excel(name = "验证码")
    private String vilidCode;

    /** 访问令牌 */
    @Excel(name = "访问令牌")
    private String accessToken;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setVideoName(String videoName) 
    {
        this.videoName = videoName;
    }

    public String getVideoName() 
    {
        return videoName;
    }
    public void setDeviceSerial(String deviceSerial) 
    {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceSerial() 
    {
        return deviceSerial;
    }
    public void setChannelNo(String channelNo) 
    {
        this.channelNo = channelNo;
    }

    public String getChannelNo() 
    {
        return channelNo;
    }
    public void setVilidCode(String vilidCode) 
    {
        this.vilidCode = vilidCode;
    }

    public String getVilidCode() 
    {
        return vilidCode;
    }
    public void setAccessToken(String accessToken) 
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken() 
    {
        return accessToken;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("videoName", getVideoName())
            .append("deviceSerial", getDeviceSerial())
            .append("channelNo", getChannelNo())
            .append("vilidCode", getVilidCode())
            .append("accessToken", getAccessToken())
            .toString();
    }
}
