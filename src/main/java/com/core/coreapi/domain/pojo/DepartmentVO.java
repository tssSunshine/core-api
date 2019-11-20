package com.core.coreapi.domain.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DepartmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String lastModificationTime;
    private Integer isDeleted;
    private String departmentID;
    private String departmentName;
    private String departmentDesc;
    private String departmentPhoneNumber;
    private Integer departmentHeadId;
    private String departmentHeadName;
    private String departmentHeadPhoneNum;
    private Integer departmentDeputyId;
    private String departmentDeputyName;
    private String departmentDeputyPhoneNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(String lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentPhoneNumber() {
        return departmentPhoneNumber;
    }

    public void setDepartmentPhoneNumber(String departmentPhoneNumber) {
        this.departmentPhoneNumber = departmentPhoneNumber;
    }

    public Integer getDepartmentHeadId() {
        return departmentHeadId;
    }

    public void setDepartmentHeadId(Integer departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }

    public String getDepartmentHeadName() {
        return departmentHeadName;
    }

    public void setDepartmentHeadName(String departmentHeadName) {
        this.departmentHeadName = departmentHeadName;
    }

    public Integer getDepartmentDeputyId() {
        return departmentDeputyId;
    }

    public void setDepartmentDeputyId(Integer departmentDeputyId) {
        this.departmentDeputyId = departmentDeputyId;
    }

    public String getDepartmentDeputyName() {
        return departmentDeputyName;
    }

    public void setDepartmentDeputyName(String departmentDeputyName) {
        this.departmentDeputyName = departmentDeputyName;
    }

    public String getDepartmentHeadPhoneNum() {
        return departmentHeadPhoneNum;
    }

    public void setDepartmentHeadPhoneNum(String departmentHeadPhoneNum) {
        this.departmentHeadPhoneNum = departmentHeadPhoneNum;
    }

    public String getDepartmentDeputyPhoneNum() {
        return departmentDeputyPhoneNum;
    }

    public void setDepartmentDeputyPhoneNum(String departmentDeputyPhoneNum) {
        this.departmentDeputyPhoneNum = departmentDeputyPhoneNum;
    }
}
