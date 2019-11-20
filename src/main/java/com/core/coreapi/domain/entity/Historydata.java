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
public class Historydata extends Model<Historydata> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer color;

    private String coordinate;

    private String address;

    private String lng;

    private Integer type;

    private String speed;

    private String license;

    @TableField("positionDate")
    private String positionDate;

    @TableField("dispatchNo")
    private String dispatchNo;

    private String course;

    private String lat;

    @TableField("createDate")
    private String createDate;

    private String source;

    @TableField("accStatus")
    private String accStatus;

    private String receiveTime;

    private String sim;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
