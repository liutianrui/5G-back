package com.ruoyi.cementstabilized.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水泥稳定碎石集料对象 cement_stabilized_macadam_collection
 * 
 * @author liutianrui
 * @date 2023-05-28
 */
public class CementStabilized extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 项目ID  */
    private String organizationId;

    /** 标段ID */
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
    private String dataNumber;

    /** 工程名称 */
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
    private Date uploadTime;

    /** $column.columnComment */
    private String proportionCode;

    /** 超标等级 */
    private String excessState;

    /** 任务单 */
    @Excel(name = "任务单")
    private String taskNo;

    /** 批次重量 每批次料的总重/吨 */
    @Excel(name = "批次重量 每批次料的总重/吨")
    private String batchWeight;

    /** 料1实际用量 */
    private String materialYield1;

    /** 料2实际用量 */
    private String materialYield2;

    /** 料3实际用量 */
    private String materialYield3;

    /** 料4实际用量 */
    private String materialYield4;

    /** 料5实际用量 */
    private String materialYield5;

    /** 料6实际用量 */
    private String materialYield6;

    /** 料7实际用量 */
    private String materialYield7;

    /** 料8实际用量 */
    private String materialYield8;

    /** 料9实际用量 */
    private String materialYield9;

    /** 料1给定 */
    private String materialGiven1;

    /** 料2给定 */
    private String materialGiven2;

    /** 料3给定 */
    private String materialGiven3;

    /** 料4给定 */
    private String materialGiven4;

    /** 料5给定 */
    private String materialGiven5;

    /** 料6给定 */
    private String materialGiven6;

    /** 料7给定 */
    private String materialGiven7;

    /** 料8给定 */
    private String materialGiven8;

    /** 料9给定 */
    private String materialGiven9;

    /** 料1流量 */
    private String materialFlow1;

    /** 料2流量 */
    private String materialFlow2;

    /** 料3流量 */
    private String materialFlow3;

    /** 料4流量 */
    private String materialFlow4;

    /** 料5流量 */
    private String materialFlow5;

    /** 料6流量 */
    private String materialFlow6;

    /** 料7流量 */
    private String materialFlow7;

    /** 料8流量 */
    private String materialFlow8;

    /** 料9流量 */
    private String materialFlow9;

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
    public void setMaterialYield1(String materialYield1) 
    {
        this.materialYield1 = materialYield1;
    }

    public String getMaterialYield1() 
    {
        return materialYield1;
    }
    public void setMaterialYield2(String materialYield2) 
    {
        this.materialYield2 = materialYield2;
    }

    public String getMaterialYield2() 
    {
        return materialYield2;
    }
    public void setMaterialYield3(String materialYield3) 
    {
        this.materialYield3 = materialYield3;
    }

    public String getMaterialYield3() 
    {
        return materialYield3;
    }
    public void setMaterialYield4(String materialYield4) 
    {
        this.materialYield4 = materialYield4;
    }

    public String getMaterialYield4() 
    {
        return materialYield4;
    }
    public void setMaterialYield5(String materialYield5) 
    {
        this.materialYield5 = materialYield5;
    }

    public String getMaterialYield5() 
    {
        return materialYield5;
    }
    public void setMaterialYield6(String materialYield6) 
    {
        this.materialYield6 = materialYield6;
    }

    public String getMaterialYield6() 
    {
        return materialYield6;
    }
    public void setMaterialYield7(String materialYield7) 
    {
        this.materialYield7 = materialYield7;
    }

    public String getMaterialYield7() 
    {
        return materialYield7;
    }
    public void setMaterialYield8(String materialYield8) 
    {
        this.materialYield8 = materialYield8;
    }

    public String getMaterialYield8() 
    {
        return materialYield8;
    }
    public void setMaterialYield9(String materialYield9) 
    {
        this.materialYield9 = materialYield9;
    }

    public String getMaterialYield9() 
    {
        return materialYield9;
    }
    public void setMaterialGiven1(String materialGiven1) 
    {
        this.materialGiven1 = materialGiven1;
    }

    public String getMaterialGiven1() 
    {
        return materialGiven1;
    }
    public void setMaterialGiven2(String materialGiven2) 
    {
        this.materialGiven2 = materialGiven2;
    }

    public String getMaterialGiven2() 
    {
        return materialGiven2;
    }
    public void setMaterialGiven3(String materialGiven3) 
    {
        this.materialGiven3 = materialGiven3;
    }

    public String getMaterialGiven3() 
    {
        return materialGiven3;
    }
    public void setMaterialGiven4(String materialGiven4) 
    {
        this.materialGiven4 = materialGiven4;
    }

    public String getMaterialGiven4() 
    {
        return materialGiven4;
    }
    public void setMaterialGiven5(String materialGiven5) 
    {
        this.materialGiven5 = materialGiven5;
    }

    public String getMaterialGiven5() 
    {
        return materialGiven5;
    }
    public void setMaterialGiven6(String materialGiven6) 
    {
        this.materialGiven6 = materialGiven6;
    }

    public String getMaterialGiven6() 
    {
        return materialGiven6;
    }
    public void setMaterialGiven7(String materialGiven7) 
    {
        this.materialGiven7 = materialGiven7;
    }

    public String getMaterialGiven7() 
    {
        return materialGiven7;
    }
    public void setMaterialGiven8(String materialGiven8) 
    {
        this.materialGiven8 = materialGiven8;
    }

    public String getMaterialGiven8() 
    {
        return materialGiven8;
    }
    public void setMaterialGiven9(String materialGiven9) 
    {
        this.materialGiven9 = materialGiven9;
    }

    public String getMaterialGiven9() 
    {
        return materialGiven9;
    }
    public void setMaterialFlow1(String materialFlow1) 
    {
        this.materialFlow1 = materialFlow1;
    }

    public String getMaterialFlow1() 
    {
        return materialFlow1;
    }
    public void setMaterialFlow2(String materialFlow2) 
    {
        this.materialFlow2 = materialFlow2;
    }

    public String getMaterialFlow2() 
    {
        return materialFlow2;
    }
    public void setMaterialFlow3(String materialFlow3) 
    {
        this.materialFlow3 = materialFlow3;
    }

    public String getMaterialFlow3() 
    {
        return materialFlow3;
    }
    public void setMaterialFlow4(String materialFlow4) 
    {
        this.materialFlow4 = materialFlow4;
    }

    public String getMaterialFlow4() 
    {
        return materialFlow4;
    }
    public void setMaterialFlow5(String materialFlow5) 
    {
        this.materialFlow5 = materialFlow5;
    }

    public String getMaterialFlow5() 
    {
        return materialFlow5;
    }
    public void setMaterialFlow6(String materialFlow6) 
    {
        this.materialFlow6 = materialFlow6;
    }

    public String getMaterialFlow6() 
    {
        return materialFlow6;
    }
    public void setMaterialFlow7(String materialFlow7) 
    {
        this.materialFlow7 = materialFlow7;
    }

    public String getMaterialFlow7() 
    {
        return materialFlow7;
    }
    public void setMaterialFlow8(String materialFlow8) 
    {
        this.materialFlow8 = materialFlow8;
    }

    public String getMaterialFlow8() 
    {
        return materialFlow8;
    }
    public void setMaterialFlow9(String materialFlow9) 
    {
        this.materialFlow9 = materialFlow9;
    }

    public String getMaterialFlow9() 
    {
        return materialFlow9;
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
            .append("materialYield1", getMaterialYield1())
            .append("materialYield2", getMaterialYield2())
            .append("materialYield3", getMaterialYield3())
            .append("materialYield4", getMaterialYield4())
            .append("materialYield5", getMaterialYield5())
            .append("materialYield6", getMaterialYield6())
            .append("materialYield7", getMaterialYield7())
            .append("materialYield8", getMaterialYield8())
            .append("materialYield9", getMaterialYield9())
            .append("materialGiven1", getMaterialGiven1())
            .append("materialGiven2", getMaterialGiven2())
            .append("materialGiven3", getMaterialGiven3())
            .append("materialGiven4", getMaterialGiven4())
            .append("materialGiven5", getMaterialGiven5())
            .append("materialGiven6", getMaterialGiven6())
            .append("materialGiven7", getMaterialGiven7())
            .append("materialGiven8", getMaterialGiven8())
            .append("materialGiven9", getMaterialGiven9())
            .append("materialFlow1", getMaterialFlow1())
            .append("materialFlow2", getMaterialFlow2())
            .append("materialFlow3", getMaterialFlow3())
            .append("materialFlow4", getMaterialFlow4())
            .append("materialFlow5", getMaterialFlow5())
            .append("materialFlow6", getMaterialFlow6())
            .append("materialFlow7", getMaterialFlow7())
            .append("materialFlow8", getMaterialFlow8())
            .append("materialFlow9", getMaterialFlow9())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
