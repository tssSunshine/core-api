package com.core.coreapi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  部门信息实体类
 * </p>
 *
 * @author sstang
 * @since 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Department implements Serializable {

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
     * 删除标志（0：未删除；1：已删除）
     */
    @TableField("isDeleted")
    @TableLogic
    private Integer isDeleted;

    /**
     * 部门ID
     */
    @TableField("departmentID")
    private String departmentID;

    /**
     * 部门名称
     */
    @TableField("departmentName")
    private String departmentName;

    /**
     * 部门描述
     */
    @TableField("departmentDesc")
    private String departmentDesc;

    /**
     * 部门电话
     */
    @TableField("departmentPhoneNumber")
    private String departmentPhoneNumber;

    /**
     * 项目主负责人ID
     */
    @TableField("departmentHeadId")
    private Integer departmentHeadId;

    /**
     * 项目副负责人ID
     */
    @TableField("departmentDeputyId")
    private Integer departmentDeputyId;

}
