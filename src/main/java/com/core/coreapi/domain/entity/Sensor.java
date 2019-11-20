package com.core.coreapi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sstang
 * @since 2019-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sensor extends Model<Sensor> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 最后更新时间
     */
    @TableField("lastModificationTime")
    private String lastModificationTime;

    /**
     * 删除标识
     */
    @TableField("isDeleted")
    private Integer isDeleted;

    /**
     * 监测点ID
     */
    @TableField("sensorID")
    private String sensorID;

    /**
     * 监测点名称
     */
    @TableField("sensorName")
    private String sensorName;

    /**
     * 工地ID
     */
    @TableField("siteID")
    private Integer siteID;

    /**
     * 监测点负责人ID
     */
    @TableField("sensorManagerID")
    private Integer sensorManagerID;

    /**
     * 监测点描述
     */
    @TableField("sensorDesc")
    private String sensorDesc;

    /**
     * 安装日期
     */
    @TableField("installationDate")
    private String installationDate;

    /**
     * 拆除日期
     */
    @TableField("removalDate")
    private String removalDate;

    /**
     * 监测点状态
     */
    @TableField("sensorState")
    private Integer sensorState;

    /**
     * 最大值
     */
    @TableField("maxValue")
    private Float maxValue;

    /**
     * 最小值
     */
    @TableField("minValue")
    private Float minValue;

    /**
     * 监测点类型描述
     */
    @TableField("sensorTypeDesc")
    private String sensorTypeDesc;

    /**
     * 监测值
     */
    @TableField("sensorValue")
    private Float sensorValue;

    /**
     * 单位
     */
    private String unit;

    /**
     * 预警值下限
     */
    @TableField("alarmMinValue")
    private Float alarmMinValue;

    /**
     * 预警区上限
     */
    @TableField("alarmMaxValue")
    private Float alarmMaxValue;

    /**
     * 安全区下限
     */
    @TableField("safeMinValue")
    private Float safeMinValue;

    /**
     * 安全区上限
     */
    @TableField("safeMaxValue")
    private Float safeMaxValue;

    /**
     * 预警状态
     */
    @TableField("alarmState")
    private Integer alarmState;

    /**
     * 预警短信发送状态
     */
    @TableField("isSendFlag")
    private Integer isSendFlag;

    @TableField("coordinatesX")
    private Float coordinatesX;

    @TableField("coordinatesY")
    private Float coordinatesY;

    /**
     * 转换公式
     */
    private String formula;

    /**
     * 初始值
     */
    @TableField("initialValue")
    private Float initialValue;

    @TableField("sensorType")
    private String sensorType;

    @TableField("timeZone")
    private String timeZone;

    @TableField("updateUserId")
    private Integer updateUserId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
