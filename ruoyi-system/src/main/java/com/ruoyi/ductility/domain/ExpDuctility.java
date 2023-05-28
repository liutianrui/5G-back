package com.ruoyi.ductility.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 延展性实验对象 exp_ductility
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class ExpDuctility extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 工程名称 */
    private String engineeringName;

    /** 工程（施工）部位 */
    @Excel(name = "工程", readConverterExp = "施=工")
    private String engineeringSite;

    /** 任务编号 */
    private String taskNo;

    /** 试验类型 */
    private String testType;

    /** 试验名称 */
    @Excel(name = "试验名称")
    private String testName;

    /** 试验编号（组号） */
    private String testNo;

    /** 组号 */
    private String groupId;

    /** 试验日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "试验日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testDate;

    /** 试验人员 */
    private String tester;

    /** 样品名称 */
    @Excel(name = "样品名称")
    private String sampleName;

    /** 试件总数 */
    @Excel(name = "试件总数")
    private String testAllFr;

    /** 试验次数(试件数量) */
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

    /** 试验温度 */
    private String testTemp;

    /** 延伸速度 */
    @Excel(name = "延伸速度")
    private String extensionSpeed;

    /** 延伸值 */
    @Excel(name = "延伸值")
    private String ductility;

    /** 平均延度 */
    @Excel(name = "平均延度")
    private String averageDuctility;

    /** $column.columnComment */
    private String curve;

    /** $column.columnComment */
    private String curve1;

    /** 是否合格 */
    @Excel(name = "是否合格")
    private String result;

    /** 其他信息 */
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
    public void setTestTemp(String testTemp) 
    {
        this.testTemp = testTemp;
    }

    public String getTestTemp() 
    {
        return testTemp;
    }
    public void setExtensionSpeed(String extensionSpeed) 
    {
        this.extensionSpeed = extensionSpeed;
    }

    public String getExtensionSpeed() 
    {
        return extensionSpeed;
    }
    public void setDuctility(String ductility) 
    {
        this.ductility = ductility;
    }

    public String getDuctility() 
    {
        return ductility;
    }
    public void setAverageDuctility(String averageDuctility) 
    {
        this.averageDuctility = averageDuctility;
    }

    public String getAverageDuctility() 
    {
        return averageDuctility;
    }
    public void setCurve(String curve) 
    {
        this.curve = curve;
    }

    public String getCurve() 
    {
        return curve;
    }
    public void setCurve1(String curve1) 
    {
        this.curve1 = curve1;
    }

    public String getCurve1() 
    {
        return curve1;
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
            .append("testTemp", getTestTemp())
            .append("extensionSpeed", getExtensionSpeed())
            .append("ductility", getDuctility())
            .append("averageDuctility", getAverageDuctility())
            .append("curve", getCurve())
            .append("curve1", getCurve1())
            .append("result", getResult())
            .append("otherInformation", getOtherInformation())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
