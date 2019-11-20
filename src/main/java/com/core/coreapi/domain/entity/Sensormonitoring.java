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
public class Sensormonitoring extends Model<Sensormonitoring> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 删除标识
     */
    @TableField("isDeleted")
    private Integer isDeleted;

    /**
     * 监测点ID
     */
    @TableField("sensorID")
    private Integer sensorID;

    /**
     * 监测值
     */
    @TableField("sensorValue")
    private Float sensorValue;

    /**
     * 读取时间
     */
    @TableField("timeRead")
    private String timeRead;

    /**
     * 上报时间
     */
    @TableField("timeSent")
    private String timeSent;

    /**
     * 保存时间
     */
    @TableField("timeSaved")
    private String timeSaved;

    /**
     * 显示值
     */
    @TableField("showValue")
    private Float showValue;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
