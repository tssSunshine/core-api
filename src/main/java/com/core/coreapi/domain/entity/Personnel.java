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
 * 员工实体类
 * </p>
 *
 * @author sstang
 * @since 2019-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Personnel implements Serializable {

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
     * 删除标识（0：未删除；1：已删除）
     */
    @TableField("isDeleted")
    @TableLogic
    private Integer isDeleted;

    /**
     * 名
     */
    @TableField("lastName")
    private String lastName;

    /**
     * 姓
     */
    @TableField("firstName")
    private String firstName;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 联系电话
     */
    @TableField("phoneNumber")
    private String phoneNumber;

    /**
     * 省
     */
    private String state;

    /**
     * 市
     */
    private String city;

    /**
     * 联系地址1
     */
    @TableField("address_1")
    private String address1;

    /**
     * 联系地址2
     */
    @TableField("address_2")
    private String address2;

    /**
     * 员工描述
     */
    @TableField("personnelDesc")
    private String personnelDesc;

    /**
     * 员工ID
     */
    @TableField("personnelID")
    private String personnelID;

    /**
     * 姓名
     */
    @TableField("fullName")
    private String fullName;

    /**
     * 部门ID
     */
    @TableField("departmentID")
    private Integer departmentID;

    private Integer position;

    /**
     * 用户ID
     */
    @TableField("userId")
    private Integer userId;

}
