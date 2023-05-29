package com.ruoyi.pollutant.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 污染物排放对象 pollutant_dict
 * 
 * @author liutianrui
 * @date 2023-05-29
 */
public class PollutantDict extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 污染物类别编码 */
    @Excel(name = "污染物类别编码")
    private String code;

    /** 编码对应中文名称 */
    @Excel(name = "编码对应中文名称")
    private String desCode;

    /** 原始编码 */
    private String originalCode;

    /** 浓度数据类型 N14.2:用可变长字符串形式表达的数字型，表示 14 位整数和 2 位小数，带小数点，带符号，最大长度为 18; */
    @Excel(name = "浓度数据类型 N14.2:用可变长字符串形式表达的数字型，表示 14 位整数和 2 位小数，带小数点，带符号，最大长度为 18;")
    private String consisitenceDataType;

    /** 浓度默认计量单位 例如：纳克/立方米 */
    @Excel(name = "浓度默认计量单位 例如：纳克/立方米")
    private String consisitenceMeas;

    /** 排放量默认计量单位 例如：分贝、克 */
    @Excel(name = "排放量默认计量单位 例如：分贝、克")
    private String emissionsMeas;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setDesCode(String desCode) 
    {
        this.desCode = desCode;
    }

    public String getDesCode() 
    {
        return desCode;
    }
    public void setOriginalCode(String originalCode) 
    {
        this.originalCode = originalCode;
    }

    public String getOriginalCode() 
    {
        return originalCode;
    }
    public void setConsisitenceDataType(String consisitenceDataType) 
    {
        this.consisitenceDataType = consisitenceDataType;
    }

    public String getConsisitenceDataType() 
    {
        return consisitenceDataType;
    }
    public void setConsisitenceMeas(String consisitenceMeas) 
    {
        this.consisitenceMeas = consisitenceMeas;
    }

    public String getConsisitenceMeas() 
    {
        return consisitenceMeas;
    }
    public void setEmissionsMeas(String emissionsMeas) 
    {
        this.emissionsMeas = emissionsMeas;
    }

    public String getEmissionsMeas() 
    {
        return emissionsMeas;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("desCode", getDesCode())
            .append("originalCode", getOriginalCode())
            .append("consisitenceDataType", getConsisitenceDataType())
            .append("consisitenceMeas", getConsisitenceMeas())
            .append("emissionsMeas", getEmissionsMeas())
            .toString();
    }
}
