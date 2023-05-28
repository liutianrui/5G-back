package com.ruoyi.asphalt.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 沥青混凝土收集对象 asphalt_concrete_collection
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class AsphaltConcreteCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String organizationId;

    /** 标段ID */
    @Excel(name = "标段ID")
    private String sectionId;

    /** 拌合站编号 */
    @Excel(name = "拌合站编号")
    private String mixingStationCode;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 搅拌机名称 */
    @Excel(name = "搅拌机名称")
    private String mixingMachineName;

    /** 数据编号 */
    @Excel(name = "数据编号")
    private String dataNumber;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String projectName;

    /** 施工地点 */
    @Excel(name = "施工地点")
    private String constructionSite;

    /** 出料时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出料时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dischargingTime;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gatheringTime;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String proportionCode;

    /** 超标等级 (0:未超标,1:初级超标,2:中级超标,3:高级超标) */
    @Excel(name = "超标等级 (0:未超标,1:初级超标,2:中级超标,3:高级超标)")
    private String excessState;

    /** 任务单（工单） */
    @Excel(name = "任务单", readConverterExp = "工=单")
    private String taskNo;

    /** 盘重 */
    @Excel(name = "盘重")
    private String batchWeight;

    /** 客户端编号 */
    @Excel(name = "客户端编号")
    private String clientNumber;

    /** 使用部位,沥青混凝土的使用层位：1-上面层2-中面层3-下面层 */
    @Excel(name = "使用部位,沥青混凝土的使用层位：1-上面层2-中面层3-下面层")
    private String layerPosition;

    /** 搅拌时长 */
    @Excel(name = "搅拌时长")
    private String mixingDuration;

    /** 出料温度 */
    @Excel(name = "出料温度")
    private String temperature;

    /** 油石比实际值 */
    @Excel(name = "油石比实际值")
    private BigDecimal asphaltAggregateRatioAct;

    /** 施工沥青用量 */
    @Excel(name = "施工沥青用量")
    private BigDecimal asphaltAct;

    /** 骨料1实际 */
    @Excel(name = "骨料1实际")
    private BigDecimal sand1Act;

    /** 骨料2实际 */
    @Excel(name = "骨料2实际")
    private BigDecimal sand2Act;

    /** 骨料3实际 */
    @Excel(name = "骨料3实际")
    private BigDecimal gravel1Act;

    /** 骨料4实际 */
    @Excel(name = "骨料4实际")
    private BigDecimal gravel2Act;

    /** 骨料5实际 */
    @Excel(name = "骨料5实际")
    private BigDecimal gravel3Act;

    /** 骨料6实际 */
    @Excel(name = "骨料6实际")
    private BigDecimal gravel4Act;

    /** 水泥实际 */
    @Excel(name = "水泥实际")
    private BigDecimal cement1Act;

    /** 再生料实际 */
    @Excel(name = "再生料实际")
    private BigDecimal recycledMaterialAct;

    /** 矿粉实际 */
    @Excel(name = "矿粉实际")
    private BigDecimal slagPowderAct;

    /** 油石比理论值 */
    @Excel(name = "油石比理论值")
    private BigDecimal asphaltAggregateRatioTheo;

    /** 沥青目标（施工）配比用量 */
    @Excel(name = "沥青目标", readConverterExp = "施=工")
    private BigDecimal asphaltTheo;

    /** 骨料1目标（施工）配比用量 */
    @Excel(name = "骨料1目标", readConverterExp = "施=工")
    private BigDecimal sand1Theo;

    /** 骨料2目标（施工）配比用量 */
    @Excel(name = "骨料2目标", readConverterExp = "施=工")
    private BigDecimal sand2Theo;

    /** 骨料3目标（施工）配比用量 */
    @Excel(name = "骨料3目标", readConverterExp = "施=工")
    private BigDecimal gravel1Theo;

    /** 骨料4目标（施工）配比用量 */
    @Excel(name = "骨料4目标", readConverterExp = "施=工")
    private BigDecimal gravel2Theo;

    /** 骨料5目标（施工）配比用量 */
    @Excel(name = "骨料5目标", readConverterExp = "施=工")
    private BigDecimal gravel3Theo;

    /** 骨料6目标（施工）配比用量 */
    @Excel(name = "骨料6目标", readConverterExp = "施=工")
    private BigDecimal gravel4Theo;

    /** 矿粉目标（施工）配比用量 */
    @Excel(name = "矿粉目标", readConverterExp = "施=工")
    private BigDecimal slagPowderTheo;

    /** 水泥目标（施工）配比用量 */
    @Excel(name = "水泥目标", readConverterExp = "施=工")
    private BigDecimal cement1Theo;

    /** 再生料 目标（施工）配比用量 */
    @Excel(name = "再生料 目标", readConverterExp = "施=工")
    private BigDecimal recycledMaterialTheo;

    /** 骨料1实际值的百分比 */
    @Excel(name = "骨料1实际值的百分比")
    private BigDecimal sand1ActPct;

    /** 骨料2实际值的百分比 */
    @Excel(name = "骨料2实际值的百分比")
    private BigDecimal sand2ActPct;

    /** 骨料3实际值的百分比 */
    @Excel(name = "骨料3实际值的百分比")
    private BigDecimal gravel1ActPct;

    /** 骨料4实际值的百分比 */
    @Excel(name = "骨料4实际值的百分比")
    private BigDecimal gravel2ActPct;

    /** 骨料5实际值的百分比 */
    @Excel(name = "骨料5实际值的百分比")
    private BigDecimal gravel3ActPct;

    /** 骨料6实际值的百分比 */
    @Excel(name = "骨料6实际值的百分比")
    private BigDecimal gravel4ActPct;

    /** 矿粉百分比 */
    @Excel(name = "矿粉百分比")
    private BigDecimal slagPowderActPct;

    /** 水泥百分比 */
    @Excel(name = "水泥百分比")
    private BigDecimal cement1ActPct;

    /** 再生料百分比 */
    @Excel(name = "再生料百分比")
    private BigDecimal recycledMaterialActPct;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date insertDate;

    /** 删除标识(0,未删除,1.已删除) */
    @Excel(name = "删除标识(0,未删除,1.已删除)")
    private String isDeleted;

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
    public void setSectionId(String sectionId) 
    {
        this.sectionId = sectionId;
    }

    public String getSectionId() 
    {
        return sectionId;
    }
    public void setMixingStationCode(String mixingStationCode) 
    {
        this.mixingStationCode = mixingStationCode;
    }

    public String getMixingStationCode() 
    {
        return mixingStationCode;
    }
    public void setEquipmentNumber(String equipmentNumber) 
    {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentNumber() 
    {
        return equipmentNumber;
    }
    public void setMixingMachineName(String mixingMachineName) 
    {
        this.mixingMachineName = mixingMachineName;
    }

    public String getMixingMachineName() 
    {
        return mixingMachineName;
    }
    public void setDataNumber(String dataNumber) 
    {
        this.dataNumber = dataNumber;
    }

    public String getDataNumber() 
    {
        return dataNumber;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setConstructionSite(String constructionSite) 
    {
        this.constructionSite = constructionSite;
    }

    public String getConstructionSite() 
    {
        return constructionSite;
    }
    public void setDischargingTime(Date dischargingTime) 
    {
        this.dischargingTime = dischargingTime;
    }

    public Date getDischargingTime() 
    {
        return dischargingTime;
    }
    public void setGatheringTime(Date gatheringTime) 
    {
        this.gatheringTime = gatheringTime;
    }

    public Date getGatheringTime() 
    {
        return gatheringTime;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setProportionCode(String proportionCode) 
    {
        this.proportionCode = proportionCode;
    }

    public String getProportionCode() 
    {
        return proportionCode;
    }
    public void setExcessState(String excessState) 
    {
        this.excessState = excessState;
    }

    public String getExcessState() 
    {
        return excessState;
    }
    public void setTaskNo(String taskNo) 
    {
        this.taskNo = taskNo;
    }

    public String getTaskNo() 
    {
        return taskNo;
    }
    public void setBatchWeight(String batchWeight) 
    {
        this.batchWeight = batchWeight;
    }

    public String getBatchWeight() 
    {
        return batchWeight;
    }
    public void setClientNumber(String clientNumber) 
    {
        this.clientNumber = clientNumber;
    }

    public String getClientNumber() 
    {
        return clientNumber;
    }
    public void setLayerPosition(String layerPosition) 
    {
        this.layerPosition = layerPosition;
    }

    public String getLayerPosition() 
    {
        return layerPosition;
    }
    public void setMixingDuration(String mixingDuration) 
    {
        this.mixingDuration = mixingDuration;
    }

    public String getMixingDuration() 
    {
        return mixingDuration;
    }
    public void setTemperature(String temperature) 
    {
        this.temperature = temperature;
    }

    public String getTemperature() 
    {
        return temperature;
    }
    public void setAsphaltAggregateRatioAct(BigDecimal asphaltAggregateRatioAct) 
    {
        this.asphaltAggregateRatioAct = asphaltAggregateRatioAct;
    }

    public BigDecimal getAsphaltAggregateRatioAct() 
    {
        return asphaltAggregateRatioAct;
    }
    public void setAsphaltAct(BigDecimal asphaltAct) 
    {
        this.asphaltAct = asphaltAct;
    }

    public BigDecimal getAsphaltAct() 
    {
        return asphaltAct;
    }
    public void setSand1Act(BigDecimal sand1Act) 
    {
        this.sand1Act = sand1Act;
    }

    public BigDecimal getSand1Act() 
    {
        return sand1Act;
    }
    public void setSand2Act(BigDecimal sand2Act) 
    {
        this.sand2Act = sand2Act;
    }

    public BigDecimal getSand2Act() 
    {
        return sand2Act;
    }
    public void setGravel1Act(BigDecimal gravel1Act) 
    {
        this.gravel1Act = gravel1Act;
    }

    public BigDecimal getGravel1Act() 
    {
        return gravel1Act;
    }
    public void setGravel2Act(BigDecimal gravel2Act) 
    {
        this.gravel2Act = gravel2Act;
    }

    public BigDecimal getGravel2Act() 
    {
        return gravel2Act;
    }
    public void setGravel3Act(BigDecimal gravel3Act) 
    {
        this.gravel3Act = gravel3Act;
    }

    public BigDecimal getGravel3Act() 
    {
        return gravel3Act;
    }
    public void setGravel4Act(BigDecimal gravel4Act) 
    {
        this.gravel4Act = gravel4Act;
    }

    public BigDecimal getGravel4Act() 
    {
        return gravel4Act;
    }
    public void setCement1Act(BigDecimal cement1Act) 
    {
        this.cement1Act = cement1Act;
    }

    public BigDecimal getCement1Act() 
    {
        return cement1Act;
    }
    public void setRecycledMaterialAct(BigDecimal recycledMaterialAct) 
    {
        this.recycledMaterialAct = recycledMaterialAct;
    }

    public BigDecimal getRecycledMaterialAct() 
    {
        return recycledMaterialAct;
    }
    public void setSlagPowderAct(BigDecimal slagPowderAct) 
    {
        this.slagPowderAct = slagPowderAct;
    }

    public BigDecimal getSlagPowderAct() 
    {
        return slagPowderAct;
    }
    public void setAsphaltAggregateRatioTheo(BigDecimal asphaltAggregateRatioTheo) 
    {
        this.asphaltAggregateRatioTheo = asphaltAggregateRatioTheo;
    }

    public BigDecimal getAsphaltAggregateRatioTheo() 
    {
        return asphaltAggregateRatioTheo;
    }
    public void setAsphaltTheo(BigDecimal asphaltTheo) 
    {
        this.asphaltTheo = asphaltTheo;
    }

    public BigDecimal getAsphaltTheo() 
    {
        return asphaltTheo;
    }
    public void setSand1Theo(BigDecimal sand1Theo) 
    {
        this.sand1Theo = sand1Theo;
    }

    public BigDecimal getSand1Theo() 
    {
        return sand1Theo;
    }
    public void setSand2Theo(BigDecimal sand2Theo) 
    {
        this.sand2Theo = sand2Theo;
    }

    public BigDecimal getSand2Theo() 
    {
        return sand2Theo;
    }
    public void setGravel1Theo(BigDecimal gravel1Theo) 
    {
        this.gravel1Theo = gravel1Theo;
    }

    public BigDecimal getGravel1Theo() 
    {
        return gravel1Theo;
    }
    public void setGravel2Theo(BigDecimal gravel2Theo) 
    {
        this.gravel2Theo = gravel2Theo;
    }

    public BigDecimal getGravel2Theo() 
    {
        return gravel2Theo;
    }
    public void setGravel3Theo(BigDecimal gravel3Theo) 
    {
        this.gravel3Theo = gravel3Theo;
    }

    public BigDecimal getGravel3Theo() 
    {
        return gravel3Theo;
    }
    public void setGravel4Theo(BigDecimal gravel4Theo) 
    {
        this.gravel4Theo = gravel4Theo;
    }

    public BigDecimal getGravel4Theo() 
    {
        return gravel4Theo;
    }
    public void setSlagPowderTheo(BigDecimal slagPowderTheo) 
    {
        this.slagPowderTheo = slagPowderTheo;
    }

    public BigDecimal getSlagPowderTheo() 
    {
        return slagPowderTheo;
    }
    public void setCement1Theo(BigDecimal cement1Theo) 
    {
        this.cement1Theo = cement1Theo;
    }

    public BigDecimal getCement1Theo() 
    {
        return cement1Theo;
    }
    public void setRecycledMaterialTheo(BigDecimal recycledMaterialTheo) 
    {
        this.recycledMaterialTheo = recycledMaterialTheo;
    }

    public BigDecimal getRecycledMaterialTheo() 
    {
        return recycledMaterialTheo;
    }
    public void setSand1ActPct(BigDecimal sand1ActPct) 
    {
        this.sand1ActPct = sand1ActPct;
    }

    public BigDecimal getSand1ActPct() 
    {
        return sand1ActPct;
    }
    public void setSand2ActPct(BigDecimal sand2ActPct) 
    {
        this.sand2ActPct = sand2ActPct;
    }

    public BigDecimal getSand2ActPct() 
    {
        return sand2ActPct;
    }
    public void setGravel1ActPct(BigDecimal gravel1ActPct) 
    {
        this.gravel1ActPct = gravel1ActPct;
    }

    public BigDecimal getGravel1ActPct() 
    {
        return gravel1ActPct;
    }
    public void setGravel2ActPct(BigDecimal gravel2ActPct) 
    {
        this.gravel2ActPct = gravel2ActPct;
    }

    public BigDecimal getGravel2ActPct() 
    {
        return gravel2ActPct;
    }
    public void setGravel3ActPct(BigDecimal gravel3ActPct) 
    {
        this.gravel3ActPct = gravel3ActPct;
    }

    public BigDecimal getGravel3ActPct() 
    {
        return gravel3ActPct;
    }
    public void setGravel4ActPct(BigDecimal gravel4ActPct) 
    {
        this.gravel4ActPct = gravel4ActPct;
    }

    public BigDecimal getGravel4ActPct() 
    {
        return gravel4ActPct;
    }
    public void setSlagPowderActPct(BigDecimal slagPowderActPct) 
    {
        this.slagPowderActPct = slagPowderActPct;
    }

    public BigDecimal getSlagPowderActPct() 
    {
        return slagPowderActPct;
    }
    public void setCement1ActPct(BigDecimal cement1ActPct) 
    {
        this.cement1ActPct = cement1ActPct;
    }

    public BigDecimal getCement1ActPct() 
    {
        return cement1ActPct;
    }
    public void setRecycledMaterialActPct(BigDecimal recycledMaterialActPct) 
    {
        this.recycledMaterialActPct = recycledMaterialActPct;
    }

    public BigDecimal getRecycledMaterialActPct() 
    {
        return recycledMaterialActPct;
    }
    public void setInsertDate(Date insertDate) 
    {
        this.insertDate = insertDate;
    }

    public Date getInsertDate() 
    {
        return insertDate;
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
            .append("organizationId", getOrganizationId())
            .append("sectionId", getSectionId())
            .append("mixingStationCode", getMixingStationCode())
            .append("equipmentNumber", getEquipmentNumber())
            .append("mixingMachineName", getMixingMachineName())
            .append("dataNumber", getDataNumber())
            .append("projectName", getProjectName())
            .append("constructionSite", getConstructionSite())
            .append("dischargingTime", getDischargingTime())
            .append("gatheringTime", getGatheringTime())
            .append("uploadTime", getUploadTime())
            .append("proportionCode", getProportionCode())
            .append("excessState", getExcessState())
            .append("taskNo", getTaskNo())
            .append("batchWeight", getBatchWeight())
            .append("clientNumber", getClientNumber())
            .append("layerPosition", getLayerPosition())
            .append("mixingDuration", getMixingDuration())
            .append("temperature", getTemperature())
            .append("asphaltAggregateRatioAct", getAsphaltAggregateRatioAct())
            .append("asphaltAct", getAsphaltAct())
            .append("sand1Act", getSand1Act())
            .append("sand2Act", getSand2Act())
            .append("gravel1Act", getGravel1Act())
            .append("gravel2Act", getGravel2Act())
            .append("gravel3Act", getGravel3Act())
            .append("gravel4Act", getGravel4Act())
            .append("cement1Act", getCement1Act())
            .append("recycledMaterialAct", getRecycledMaterialAct())
            .append("slagPowderAct", getSlagPowderAct())
            .append("asphaltAggregateRatioTheo", getAsphaltAggregateRatioTheo())
            .append("asphaltTheo", getAsphaltTheo())
            .append("sand1Theo", getSand1Theo())
            .append("sand2Theo", getSand2Theo())
            .append("gravel1Theo", getGravel1Theo())
            .append("gravel2Theo", getGravel2Theo())
            .append("gravel3Theo", getGravel3Theo())
            .append("gravel4Theo", getGravel4Theo())
            .append("slagPowderTheo", getSlagPowderTheo())
            .append("cement1Theo", getCement1Theo())
            .append("recycledMaterialTheo", getRecycledMaterialTheo())
            .append("sand1ActPct", getSand1ActPct())
            .append("sand2ActPct", getSand2ActPct())
            .append("gravel1ActPct", getGravel1ActPct())
            .append("gravel2ActPct", getGravel2ActPct())
            .append("gravel3ActPct", getGravel3ActPct())
            .append("gravel4ActPct", getGravel4ActPct())
            .append("slagPowderActPct", getSlagPowderActPct())
            .append("cement1ActPct", getCement1ActPct())
            .append("recycledMaterialActPct", getRecycledMaterialActPct())
            .append("insertDate", getInsertDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
