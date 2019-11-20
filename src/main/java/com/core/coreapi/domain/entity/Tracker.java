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
public class Tracker extends Model<Tracker> {

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
     * 追踪器ID
     */
    @TableField("trackerID")
    private String trackerID;

    /**
     * 追踪器名称
     */
    @TableField("trackerName")
    private String trackerName;

    /**
     * 追踪器类型
     */
    @TableField("trackerType")
    private String trackerType;

    /**
     * 实体ID
     */
    @TableField("entityID")
    private Integer entityID;

    /**
     * 实体类型
     */
    @TableField("entityType")
    private String entityType;

    /**
     * 工地ID
     */
    @TableField("siteID")
    private Integer siteID;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
