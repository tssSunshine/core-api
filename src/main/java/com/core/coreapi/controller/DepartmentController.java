package com.core.coreapi.controller;


import com.core.coreapi.domain.entity.Department;
import com.core.coreapi.domain.pojo.DepartmentVO;
import com.core.coreapi.service.DepartmentService;
import com.core.coreapi.util.DateUtil;
import com.core.coreapi.util.resp.ResponseCode;
import com.core.coreapi.util.resp.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  部门管理前端控制器
 * </p>
 *
 * @author sstang
 * @since 2019-11-01
 */
@RestController
@RequestMapping("/department")
@Api(description = "部门相关接口")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "保存部门信息", notes = "保存部门信息", httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/saveDepartment")
    public Object saveDepartment(@RequestBody Department department) {
        department.setLastModificationTime(DateUtil.parseDate(LocalDateTime.now()));
        boolean flag = departmentService.saveOrUpdate(department);
        if (flag) {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_SUCCESS);
        } else {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_FAILED);
        }
    }

    @ApiOperation(value = "删除部门信息", notes = "删除部门信息", httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/deleteDepartment")
    public Object deleteDepartment(String ids) {
        int count = 0;
        if (StringUtils.isBlank(ids)) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        List<Integer> removeIds = new ArrayList<>();
        String[] str = ids.split(",");
        if (str != null && str.length > 0) {
            for (String id : str) {
                count += departmentService.delete(Integer.parseInt(id));
            }
        }
        if (str.length > 0 && str.length == count) {
            return ServerResponse.success(ResponseCode.DEL_SUCCESS);
        } else {
            return ServerResponse.success(ResponseCode.DEL_FAILED);
        }
    }

    @ApiOperation(value = "查询部门列表",notes = "查询部门列表",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findAll")
    public Object findAll() {
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, departmentService.list());
    }

    @ApiOperation(value = "查询部门列表",notes = "查询部门列表",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findDepartmentList")
    public Object findDepartmentList(String param) {
        List<DepartmentVO> departmentVOList = departmentService.findDepartmentList(param);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, departmentVOList);
    }

    @ApiOperation(value = "根据ID查询部门信息",notes = "根据ID查询部门信息",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findDepartmentById")
    public Object findDepartmentById(String id) {
        if (StringUtils.isBlank(id)) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, departmentService.getById(Integer.parseInt(id)));
    }
}
