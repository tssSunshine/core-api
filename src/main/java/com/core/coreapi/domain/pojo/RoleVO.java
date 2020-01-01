package com.core.coreapi.domain.pojo;

import com.core.coreapi.domain.entity.Permission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleVO implements Serializable {
    private String roleId;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions = new ArrayList<>();

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
