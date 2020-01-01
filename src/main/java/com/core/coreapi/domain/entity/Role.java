package com.core.coreapi.domain.entity;

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
 * @since 2020-01-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId("roleId")
    private String roleId;

    @TableField("roleName")
    private String roleName;

    @TableField("roleDesc")
    private String roleDesc;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
