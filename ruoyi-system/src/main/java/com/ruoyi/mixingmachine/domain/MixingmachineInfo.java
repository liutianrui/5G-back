package com.ruoyi.mixingmachine.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 搅拌机信息对象 mixingmachine_info
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class MixingmachineInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private String mixingmachineId;

    /** 拌合站编号 */
    @Excel(name = "拌合站编号")
    private String mixingStationCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String mixingMachineName;

    /** 缩写 */
    @Excel(name = "缩写")
    private String abbreviation;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 制造商 */
    @Excel(name = "制造商")
    private String manufacturer;

    /** 项目标段id */
    @Excel(name = "项目标段id")
    private String sectionProjectId;

    /** $column.columnComment */
    private String itemId;

    /** 删除标识(0,未删除,1.已删除) */
    private String isDeleted;

    public void setMixingmachineId(String mixingmachineId) 
    {
        this.mixingmachineId = mixingmachineId;
    }

    public String getMixingmachineId() 
    {
        return mixingmachineId;
    }
    public void setMixingStationCode(String mixingStationCode) 
    {
        this.mixingStationCode = mixingStationCode;
    }

    public String getMixingStationCode() 
    {
        return mixingStationCode;
    }
    public void setMixingMachineName(String mixingMachineName) 
    {
        this.mixingMachineName = mixingMachineName;
    }

    public String getMixingMachineName() 
    {
        return mixingMachineName;
    }
    public void setAbbreviation(String abbreviation) 
    {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() 
    {
        return abbreviation;
    }
    public void setEquipmentNumber(String equipmentNumber) 
    {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentNumber() 
    {
        return equipmentNumber;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setSectionProjectId(String sectionProjectId) 
    {
        this.sectionProjectId = sectionProjectId;
    }

    public String getSectionProjectId() 
    {
        return sectionProjectId;
    }
    public void setItemId(String itemId) 
    {
        this.itemId = itemId;
    }

    public String getItemId() 
    {
        return itemId;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mixingmachineId", getMixingmachineId())
            .append("mixingStationCode", getMixingStationCode())
            .append("mixingMachineName", getMixingMachineName())
            .append("abbreviation", getAbbreviation())
            .append("equipmentNumber", getEquipmentNumber())
            .append("manufacturer", getManufacturer())
            .append("sectionProjectId", getSectionProjectId())
            .append("itemId", getItemId())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
