package com.core.coreapi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.core.coreapi.domain.pojo.RoleVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sstang
 * @since 2020-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @TableField("userName")
    private String userName;

    private String phone;

    private Integer sex;

    @TableField("realName")
    private String realName;

    @TableField("passWord")
    private String passWord;

    private String email;

    private String photo;

    @TableField("createTime")
    private String createTime;

    @TableField("updateTime")
    private String updateTime;

    private Integer status;

    private List<Role> roles = new ArrayList<>();


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
