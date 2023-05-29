package com.ruoyi.penetration.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 针入度实验对象 exp_penetration
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class ExpPenetration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** UUID */
    private String id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String engineeringName;

    /** 施工部位 */
    @Excel(name = "施工部位")
    private String engineeringSite;

    /** 任务单编号 与平台新建任务单一致，（平台上是手填，客户端上可从列表选择，网络不好时可新建）（客户端上新建的任务单不存在于平台的任务单表中） */
    private String taskNo;

    /** 试验类型 针入度试验为 ZRD、软化点试验为 RHD、马歇尔稳定度为 MXEWDD、延度试验为 YD */
    @Excel(name = "试验类型 针入度试验为 ZRD、软化点试验为 RHD、马歇尔稳定度为 MXEWDD、延度试验为 YD")
    private String testType;

    /** 试验名称 */
    private String testName;

    /** 试验编号 */
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

    /** 试件总数量 */
    @Excel(name = "试件总数量")
    private String testAllFr;

    /** 试件序号 */
    @Excel(name = "试件序号")
    private String testFr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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

    /** 入针时间 */
    private String penetrateTime;

    /** 针入度 */
    @Excel(name = "针入度")
    private String penetration;

    /** 针入度平均值 三次平行实验后的平均值 */
    @Excel(name = "针入度平均值 三次平行实验后的平均值")
    private String average;

    /** 针入度指数 本组试验中有效试验的平均值结果，例如针入度三次试验取得值分别为 85、90、95，平均值为90，同一组试验该值相同 */
    private String pi;

    /** $column.columnComment */
    private String curve;

    /** $column.columnComment */
    private String curve1;

    /** $column.columnComment */
    private String result;

    /** $column.columnComment */
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
    public void setPenetrateTime(String penetrateTime) 
    {
        this.penetrateTime = penetrateTime;
    }

    public String getPenetrateTime() 
    {
        return penetrateTime;
    }
    public void setPenetration(String penetration) 
    {
        this.penetration = penetration;
    }

    public String getPenetration() 
    {
        return penetration;
    }
    public void setAverage(String average) 
    {
        this.average = average;
    }

    public String getAverage() 
    {
        return average;
    }
    public void setPi(String pi) 
    {
        this.pi = pi;
    }

    public String getPi() 
    {
        return pi;
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
            .append("penetrateTime", getPenetrateTime())
            .append("penetration", getPenetration())
            .append("average", getAverage())
            .append("pi", getPi())
            .append("curve", getCurve())
            .append("curve1", getCurve1())
            .append("result", getResult())
            .append("otherInformation", getOtherInformation())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
