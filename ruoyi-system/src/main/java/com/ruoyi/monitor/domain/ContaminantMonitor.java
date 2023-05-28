package com.ruoyi.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 污染物监测器对象 contaminant_monitor
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class ContaminantMonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 所属项目ID */
    private String organizationId;

    /** 所属标段名称 */
    private String sectionName;

    /** 所属标段ID */
    private String sectionId;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 数据段信息 */
    @Excel(name = "数据段信息")
    private String dataSegment;

    /** 数据区里的时间信息字符串 */
    private String dataTime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOrganizationId(String organizationId) 
    {
        this.organizationId = organizationId;
    }

    public String getOrganizationId() 
    {
        return organizationId;
    }
    public void setSectionName(String sectionName) 
    {
        this.sectionName = sectionName;
    }

    public String getSectionName() 
    {
        return sectionName;
    }
    public void setSectionId(String sectionId) 
    {
        this.sectionId = sectionId;
    }

    public String getSectionId() 
    {
        return sectionId;
    }
    public void setEquipmentNumber(String equipmentNumber) 
    {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentNumber() 
    {
        return equipmentNumber;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setDataSegment(String dataSegment) 
    {
        this.dataSegment = dataSegment;
    }

    public String getDataSegment() 
    {
        return dataSegment;
    }
    public void setDataTime(String dataTime) 
    {
        this.dataTime = dataTime;
    }

    public String getDataTime() 
    {
        return dataTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("organizationId", getOrganizationId())
            .append("sectionName", getSectionName())
            .append("sectionId", getSectionId())
            .append("equipmentNumber", getEquipmentNumber())
            .append("equipmentName", getEquipmentName())
            .append("dataSegment", getDataSegment())
            .append("createTime", getCreateTime())
            .append("dataTime", getDataTime())
            .toString();
    }
}
