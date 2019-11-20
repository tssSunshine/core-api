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
public class Site extends Model<Site> {

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
     * 删除标志
     */
    @TableField("isDeleted")
    private Integer isDeleted;

    /**
     * 项目ID
     */
    @TableField("projectID")
    private Integer projectID;

    /**
     * 工地ID
     */
    @TableField("siteID")
    private String siteID;

    /**
     * 工地名称
     */
    @TableField("siteName")
    private String siteName;

    /**
     * 工地负责人ID
     */
    @TableField("siteManagerID")
    private Integer siteManagerID;

    /**
     * 省
     */
    private String state;

    /**
     * 市
     */
    private String city;

    /**
     * 地址1
     */
    private String address1;

    /**
     * 地址2
     */
    private String address2;

    /**
     * 描述
     */
    @TableField("siteDesc")
    private String siteDesc;

    /**
     * 计划动工时间
     */
    @TableField("scheduledStartDate")
    private String scheduledStartDate;

    /**
     * 计划竣工时间
     */
    @TableField("scheduledCompletionDate")
    private String scheduledCompletionDate;

    /**
     * 实际动工时间
     */
    @TableField("actualStartDate")
    private String actualStartDate;

    /**
     * 实际竣工时间
     */
    @TableField("actualCompletionDate")
    private String actualCompletionDate;

    /**
     * 完成进度
     */
    @TableField("currentProgressPercent")
    private Integer currentProgressPercent;

    @TableField("currentProgressDesc")
    private String currentProgressDesc;

    @TableField("alarmState")
    private Integer alarmState;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
