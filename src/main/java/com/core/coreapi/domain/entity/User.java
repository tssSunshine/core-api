package com.core.coreapi.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2020-01-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableField("userId")
    private String userId;

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


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
