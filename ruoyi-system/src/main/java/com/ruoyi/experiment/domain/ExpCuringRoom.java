package com.ruoyi.experiment.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实验养护室对象 exp_curing_room
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class ExpCuringRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 养护室设备ID */
    private String equipmentNumber;

    /** 养护室名称 */
    @Excel(name = "养护室名称")
    private String equipmentName;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gatheringTime;

    /** 温度（摄氏度） */
    @Excel(name = "温度", readConverterExp = "摄=氏度")
    private String temperature;

    /** 湿度（百分比） */
    @Excel(name = "湿度", readConverterExp = "百=分比")
    private String humidity;

    /** 电量 */
    @Excel(name = "电量")
    private BigDecimal electricQuantity;

    /** $column.columnComment */
    private Date insertTime;

    /** 删除标识(0,未删除,1.已删除) */
    private String isDeleted;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setGatheringTime(Date gatheringTime) 
    {
        this.gatheringTime = gatheringTime;
    }

    public Date getGatheringTime() 
    {
        return gatheringTime;
    }
    public void setTemperature(String temperature) 
    {
        this.temperature = temperature;
    }

    public String getTemperature() 
    {
        return temperature;
    }
    public void setHumidity(String humidity) 
    {
        this.humidity = humidity;
    }

    public String getHumidity() 
    {
        return humidity;
    }
    public void setElectricQuantity(BigDecimal electricQuantity) 
    {
        this.electricQuantity = electricQuantity;
    }

    public BigDecimal getElectricQuantity() 
    {
        return electricQuantity;
    }
    public void setInsertTime(Date insertTime) 
    {
        this.insertTime = insertTime;
    }

    public Date getInsertTime() 
    {
        return insertTime;
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
            .append("id", getId())
            .append("equipmentNumber", getEquipmentNumber())
            .append("equipmentName", getEquipmentName())
            .append("gatheringTime", getGatheringTime())
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("electricQuantity", getElectricQuantity())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
