package com.ruoyi.furnace.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实验炉对象 exp_furnace
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class ExpFurnace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 设备编号 */
    private String equipmentNumber;

    /** 设备名称 */
    private String equipmentName;

    /** 工程名称 */
    private String engineeringName;

    /** 工程（施工）部位 */
    private String engineeringSite;

    /** 任务编号 */
    private String taskNo;

    /** 试验类型 针入度试验为 ZRD、软化点试验为 RHD、马歇尔稳定度为 MXEWDD、延度试验为 YD */
    private String testType;

    /** 试验名称 */
    @Excel(name = "试验名称")
    private String testName;

    /** 试验编号（组号） */
    private String testNo;

    /** 组号 */
    private String groupId;

    /** 试验日期 */
    private Date testDate;

    /** 试验人员 */
    private String tester;

    /** 沥青种类 */
    @Excel(name = "沥青种类")
    private String sampleName;

    /** 试件总数量 */
    @Excel(name = "试件总数量")
    private String testAllFr;

    /** 试验次数(试件数量) */
    @Excel(name = "试验次数(试件数量)")
    private String testFr;

    /** $column.columnComment */
    private String sampleNo;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 混合料类型 */
    @Excel(name = "混合料类型")
    private String concreteType;

    /** 原始重量 */
    @Excel(name = "原始重量")
    private BigDecimal originalWeight;

    /** 损失重量 */
    @Excel(name = "损失重量")
    private BigDecimal lostWeight;

    /** 补偿重量 */
    @Excel(name = "补偿重量")
    private BigDecimal compensationWeight;

    /** 补偿系数 */
    private BigDecimal compensationCoefficient;

    /** 沥青含量 */
    @Excel(name = "沥青含量")
    private BigDecimal asphaltContent;

    /** 油石比 */
    @Excel(name = "油石比")
    private String asphaltAggregateRatio;

    /** 主温 */
    @Excel(name = "主温")
    private String mainTemperature;

    /** 试验时间（时分秒） */
    @Excel(name = "试验时间", readConverterExp = "时=分秒")
    private String testDuration;

    /** 损失量曲线图 */
    private String curveLost;

    /** 温度曲线图 */
    private String curveTemperature;

    /** 时间曲线图 */
    private String curveTime;

    /** 是否合格（0合格，1不合格） */
    @Excel(name = "是否合格", readConverterExp = "0=合格，1不合格")
    private String result;

    /** 备注 */
    private String otherInformation;

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
    public void setEngineeringName(String engineeringName) 
    {
        this.engineeringName = engineeringName;
    }

    public String getEngineeringName() 
    {
        return engineeringName;
    }
    public void setEngineeringSite(String engineeringSite) 
    {
        this.engineeringSite = engineeringSite;
    }

    public String getEngineeringSite() 
    {
        return engineeringSite;
    }
    public void setTaskNo(String taskNo) 
    {
        this.taskNo = taskNo;
    }

    public String getTaskNo() 
    {
        return taskNo;
    }
    public void setTestType(String testType) 
    {
        this.testType = testType;
    }

    public String getTestType() 
    {
        return testType;
    }
    public void setTestName(String testName) 
    {
        this.testName = testName;
    }

    public String getTestName() 
    {
        return testName;
    }
    public void setTestNo(String testNo) 
    {
        this.testNo = testNo;
    }

    public String getTestNo() 
    {
        return testNo;
    }
    public void setGroupId(String groupId) 
    {
        this.groupId = groupId;
    }

    public String getGroupId() 
    {
        return groupId;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setTester(String tester) 
    {
        this.tester = tester;
    }

    public String getTester() 
    {
        return tester;
    }
    public void setSampleName(String sampleName) 
    {
        this.sampleName = sampleName;
    }

    public String getSampleName() 
    {
        return sampleName;
    }
    public void setTestAllFr(String testAllFr) 
    {
        this.testAllFr = testAllFr;
    }

    public String getTestAllFr() 
    {
        return testAllFr;
    }
    public void setTestFr(String testFr) 
    {
        this.testFr = testFr;
    }

    public String getTestFr() 
    {
        return testFr;
    }
    public void setSampleNo(String sampleNo) 
    {
        this.sampleNo = sampleNo;
    }

    public String getSampleNo() 
    {
        return sampleNo;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setConcreteType(String concreteType) 
    {
        this.concreteType = concreteType;
    }

    public String getConcreteType() 
    {
        return concreteType;
    }
    public void setOriginalWeight(BigDecimal originalWeight) 
    {
        this.originalWeight = originalWeight;
    }

    public BigDecimal getOriginalWeight() 
    {
        return originalWeight;
    }
    public void setLostWeight(BigDecimal lostWeight) 
    {
        this.lostWeight = lostWeight;
    }

    public BigDecimal getLostWeight() 
    {
        return lostWeight;
    }
    public void setCompensationWeight(BigDecimal compensationWeight) 
    {
        this.compensationWeight = compensationWeight;
    }

    public BigDecimal getCompensationWeight() 
    {
        return compensationWeight;
    }
    public void setCompensationCoefficient(BigDecimal compensationCoefficient) 
    {
        this.compensationCoefficient = compensationCoefficient;
    }

    public BigDecimal getCompensationCoefficient() 
    {
        return compensationCoefficient;
    }
    public void setAsphaltContent(BigDecimal asphaltContent) 
    {
        this.asphaltContent = asphaltContent;
    }

    public BigDecimal getAsphaltContent() 
    {
        return asphaltContent;
    }
    public void setAsphaltAggregateRatio(String asphaltAggregateRatio) 
    {
        this.asphaltAggregateRatio = asphaltAggregateRatio;
    }

    public String getAsphaltAggregateRatio() 
    {
        return asphaltAggregateRatio;
    }
    public void setMainTemperature(String mainTemperature) 
    {
        this.mainTemperature = mainTemperature;
    }

    public String getMainTemperature() 
    {
        return mainTemperature;
    }
    public void setTestDuration(String testDuration) 
    {
        this.testDuration = testDuration;
    }

    public String getTestDuration() 
    {
        return testDuration;
    }
    public void setCurveLost(String curveLost) 
    {
        this.curveLost = curveLost;
    }

    public String getCurveLost() 
    {
        return curveLost;
    }
    public void setCurveTemperature(String curveTemperature) 
    {
        this.curveTemperature = curveTemperature;
    }

    public String getCurveTemperature() 
    {
        return curveTemperature;
    }
    public void setCurveTime(String curveTime) 
    {
        this.curveTime = curveTime;
    }

    public String getCurveTime() 
    {
        return curveTime;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setOtherInformation(String otherInformation) 
    {
        this.otherInformation = otherInformation;
    }

    public String getOtherInformation() 
    {
        return otherInformation;
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
            .append("engineeringName", getEngineeringName())
            .append("engineeringSite", getEngineeringSite())
            .append("taskNo", getTaskNo())
            .append("testType", getTestType())
            .append("testName", getTestName())
            .append("testNo", getTestNo())
            .append("groupId", getGroupId())
            .append("testDate", getTestDate())
            .append("tester", getTester())
            .append("sampleName", getSampleName())
            .append("testAllFr", getTestAllFr())
            .append("testFr", getTestFr())
            .append("sampleNo", getSampleNo())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("uploadTime", getUploadTime())
            .append("concreteType", getConcreteType())
            .append("originalWeight", getOriginalWeight())
            .append("lostWeight", getLostWeight())
            .append("compensationWeight", getCompensationWeight())
            .append("compensationCoefficient", getCompensationCoefficient())
            .append("asphaltContent", getAsphaltContent())
            .append("asphaltAggregateRatio", getAsphaltAggregateRatio())
            .append("mainTemperature", getMainTemperature())
            .append("testDuration", getTestDuration())
            .append("curveLost", getCurveLost())
            .append("curveTemperature", getCurveTemperature())
            .append("curveTime", getCurveTime())
            .append("result", getResult())
            .append("otherInformation", getOtherInformation())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
