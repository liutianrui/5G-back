package com.ruoyi.machine.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 压力机对象 stress_machine
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class StressMachine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据id */
    private String id;

    /** 所属项目 */
    private String organizationId;

    /** 所属标段项目 */
    private String sectionId;

    /** 标段名称 */
    @Excel(name = "标段名称")
    private String sectionName;

    /** 试验机ID */
    private String equipmentNumber;

    /** 试验机名称 */
    @Excel(name = "试验机名称")
    private String equipmentName;

    /** 工程名称 */
    private String projectName;

    /** 施工部位 */
    @Excel(name = "施工部位")
    private String constructionSpot;

    /** 试验类型 */
    @Excel(name = "试验类型")
    private String testType;

    /** 试验id */
    private String testId;

    /** 试验日期 */
    private Date testDate;

    /** 龄期 */
    @Excel(name = "龄期")
    private String concreteAge;

    /** 试件面积 */
    @Excel(name = "试件面积")
    private String cubeArea;

    /** 试件编号 */
    @Excel(name = "试件编号")
    private String cubeCode;

    /** 试块个数 */
    @Excel(name = "试块个数")
    private Long cubeCount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String loadValue;

    /** 抗压强度 */
    @Excel(name = "抗压强度")
    private String compressiveStrength;

    /** 强度代表值 */
    @Excel(name = "强度代表值")
    private String representativeStrength;

    /** 设计强度 */
    @Excel(name = "设计强度")
    private String designStrength;

    /** 评定结果 0合格，1不合格，2无效，3作废 */
    private Long testEvaluation;

    /** $column.columnComment */
    private String graphId;

    /** 过程压力 */
    @Excel(name = "过程压力")
    private String processStress;

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
    public void setSectionName(String sectionName) 
    {
        this.sectionName = sectionName;
    }

    public String getSectionName() 
    {
        return sectionName;
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
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setConstructionSpot(String constructionSpot) 
    {
        this.constructionSpot = constructionSpot;
    }

    public String getConstructionSpot() 
    {
        return constructionSpot;
    }
    public void setTestType(String testType) 
    {
        this.testType = testType;
    }

    public String getTestType() 
    {
        return testType;
    }
    public void setTestId(String testId) 
    {
        this.testId = testId;
    }

    public String getTestId() 
    {
        return testId;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setConcreteAge(String concreteAge) 
    {
        this.concreteAge = concreteAge;
    }

    public String getConcreteAge() 
    {
        return concreteAge;
    }
    public void setCubeArea(String cubeArea) 
    {
        this.cubeArea = cubeArea;
    }

    public String getCubeArea() 
    {
        return cubeArea;
    }
    public void setCubeCode(String cubeCode) 
    {
        this.cubeCode = cubeCode;
    }

    public String getCubeCode() 
    {
        return cubeCode;
    }
    public void setCubeCount(Long cubeCount) 
    {
        this.cubeCount = cubeCount;
    }

    public Long getCubeCount() 
    {
        return cubeCount;
    }
    public void setLoadValue(String loadValue) 
    {
        this.loadValue = loadValue;
    }

    public String getLoadValue() 
    {
        return loadValue;
    }
    public void setCompressiveStrength(String compressiveStrength) 
    {
        this.compressiveStrength = compressiveStrength;
    }

    public String getCompressiveStrength() 
    {
        return compressiveStrength;
    }
    public void setRepresentativeStrength(String representativeStrength) 
    {
        this.representativeStrength = representativeStrength;
    }

    public String getRepresentativeStrength() 
    {
        return representativeStrength;
    }
    public void setDesignStrength(String designStrength) 
    {
        this.designStrength = designStrength;
    }

    public String getDesignStrength() 
    {
        return designStrength;
    }
    public void setTestEvaluation(Long testEvaluation) 
    {
        this.testEvaluation = testEvaluation;
    }

    public Long getTestEvaluation() 
    {
        return testEvaluation;
    }
    public void setGraphId(String graphId) 
    {
        this.graphId = graphId;
    }

    public String getGraphId() 
    {
        return graphId;
    }
    public void setProcessStress(String processStress) 
    {
        this.processStress = processStress;
    }

    public String getProcessStress() 
    {
        return processStress;
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
            .append("sectionName", getSectionName())
            .append("equipmentNumber", getEquipmentNumber())
            .append("equipmentName", getEquipmentName())
            .append("projectName", getProjectName())
            .append("constructionSpot", getConstructionSpot())
            .append("testType", getTestType())
            .append("testId", getTestId())
            .append("testDate", getTestDate())
            .append("concreteAge", getConcreteAge())
            .append("cubeArea", getCubeArea())
            .append("cubeCode", getCubeCode())
            .append("cubeCount", getCubeCount())
            .append("loadValue", getLoadValue())
            .append("compressiveStrength", getCompressiveStrength())
            .append("representativeStrength", getRepresentativeStrength())
            .append("designStrength", getDesignStrength())
            .append("testEvaluation", getTestEvaluation())
            .append("graphId", getGraphId())
            .append("processStress", getProcessStress())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
