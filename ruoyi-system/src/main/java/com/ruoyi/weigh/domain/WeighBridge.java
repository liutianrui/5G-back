package com.ruoyi.weigh.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地磅对象 weigh_bridge
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class WeighBridge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据唯一性识别 */
    private String id;

    /** 任务单ID */
    private String taskNo;

    /** 所属项目ID */
    private String organizationId;

    /** 所属标段名称 */
    @Excel(name = "所属标段名称")
    private String sectionName;

    /** 所属标段ID */
    private String sectionId;

    /** 所属拌合站名称 */
    private String mixingStationName;

    /** 所属拌合站ID */
    private String mixingStationCode;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String equipmentNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 品牌 */
    private String materialBrand;

    /** 供应商（销售商） */
    @Excel(name = "供应商", readConverterExp = "销=售商")
    private String materialVendor;

    /** 物资种类（货名） */
    @Excel(name = "物资种类", readConverterExp = "货=名")
    private String materialType;

    /** 物资规格 */
    @Excel(name = "物资规格")
    private String materialSpec;

    /** 批次 */
    private String materialBatch;

    /** 生产日期 */
    private Date productionDate;

    /** 发货地点 */
    @Excel(name = "发货地点")
    private String sendingPlace;

    /** 收货地点 */
    @Excel(name = "收货地点")
    private String receivingPlace;

    /** 毛重（吨） */
    @Excel(name = "毛重", readConverterExp = "吨=")
    private BigDecimal grossWeight;

    /** 皮重车重（吨） */
    @Excel(name = "皮重车重", readConverterExp = "吨=")
    private BigDecimal tareWeight;

    /** 净重（吨） */
    @Excel(name = "净重", readConverterExp = "吨=")
    private BigDecimal netWeight;

    /** 扣量（吨） */
    private BigDecimal deduction;

    /** 结算重量（吨） */
    @Excel(name = "结算重量", readConverterExp = "吨=")
    private BigDecimal countingWeight;

    /** 实际重量（吨） */
    @Excel(name = "实际重量", readConverterExp = "吨=")
    private BigDecimal actualWeight;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 进场时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 出场时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exitTime;

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
    public void setTaskNo(String taskNo) 
    {
        this.taskNo = taskNo;
    }

    public String getTaskNo() 
    {
        return taskNo;
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
    public void setMixingStationName(String mixingStationName) 
    {
        this.mixingStationName = mixingStationName;
    }

    public String getMixingStationName() 
    {
        return mixingStationName;
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
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
    }
    public void setMaterialVendor(String materialVendor) 
    {
        this.materialVendor = materialVendor;
    }

    public String getMaterialVendor() 
    {
        return materialVendor;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setMaterialSpec(String materialSpec) 
    {
        this.materialSpec = materialSpec;
    }

    public String getMaterialSpec() 
    {
        return materialSpec;
    }
    public void setMaterialBatch(String materialBatch) 
    {
        this.materialBatch = materialBatch;
    }

    public String getMaterialBatch() 
    {
        return materialBatch;
    }
    public void setProductionDate(Date productionDate) 
    {
        this.productionDate = productionDate;
    }

    public Date getProductionDate() 
    {
        return productionDate;
    }
    public void setSendingPlace(String sendingPlace) 
    {
        this.sendingPlace = sendingPlace;
    }

    public String getSendingPlace() 
    {
        return sendingPlace;
    }
    public void setReceivingPlace(String receivingPlace) 
    {
        this.receivingPlace = receivingPlace;
    }

    public String getReceivingPlace() 
    {
        return receivingPlace;
    }
    public void setGrossWeight(BigDecimal grossWeight) 
    {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getGrossWeight() 
    {
        return grossWeight;
    }
    public void setTareWeight(BigDecimal tareWeight) 
    {
        this.tareWeight = tareWeight;
    }

    public BigDecimal getTareWeight() 
    {
        return tareWeight;
    }
    public void setNetWeight(BigDecimal netWeight) 
    {
        this.netWeight = netWeight;
    }

    public BigDecimal getNetWeight() 
    {
        return netWeight;
    }
    public void setDeduction(BigDecimal deduction) 
    {
        this.deduction = deduction;
    }

    public BigDecimal getDeduction() 
    {
        return deduction;
    }
    public void setCountingWeight(BigDecimal countingWeight) 
    {
        this.countingWeight = countingWeight;
    }

    public BigDecimal getCountingWeight() 
    {
        return countingWeight;
    }
    public void setActualWeight(BigDecimal actualWeight) 
    {
        this.actualWeight = actualWeight;
    }

    public BigDecimal getActualWeight() 
    {
        return actualWeight;
    }
    public void setCarNumber(String carNumber) 
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber() 
    {
        return carNumber;
    }
    public void setEntryTime(Date entryTime) 
    {
        this.entryTime = entryTime;
    }

    public Date getEntryTime() 
    {
        return entryTime;
    }
    public void setExitTime(Date exitTime) 
    {
        this.exitTime = exitTime;
    }

    public Date getExitTime() 
    {
        return exitTime;
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
            .append("taskNo", getTaskNo())
            .append("organizationId", getOrganizationId())
            .append("sectionName", getSectionName())
            .append("sectionId", getSectionId())
            .append("mixingStationName", getMixingStationName())
            .append("mixingStationCode", getMixingStationCode())
            .append("equipmentNumber", getEquipmentNumber())
            .append("equipmentName", getEquipmentName())
            .append("materialBrand", getMaterialBrand())
            .append("materialVendor", getMaterialVendor())
            .append("materialType", getMaterialType())
            .append("materialSpec", getMaterialSpec())
            .append("materialBatch", getMaterialBatch())
            .append("productionDate", getProductionDate())
            .append("sendingPlace", getSendingPlace())
            .append("receivingPlace", getReceivingPlace())
            .append("grossWeight", getGrossWeight())
            .append("tareWeight", getTareWeight())
            .append("netWeight", getNetWeight())
            .append("deduction", getDeduction())
            .append("countingWeight", getCountingWeight())
            .append("actualWeight", getActualWeight())
            .append("carNumber", getCarNumber())
            .append("entryTime", getEntryTime())
            .append("exitTime", getExitTime())
            .append("insertTime", getInsertTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
