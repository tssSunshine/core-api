package com.core.coreapi.controller;


import com.core.coreapi.domain.entity.Personnel;
import com.core.coreapi.domain.pojo.PersonnelVO;
import com.core.coreapi.service.PersonnelService;
import com.core.coreapi.util.DateUtil;
import com.core.coreapi.util.resp.ResponseCode;
import com.core.coreapi.util.resp.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sstang
 * @since 2019-11-05
 */
@RestController
@RequestMapping("/personnel")
@Api(description = "员工相关接口")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @ApiOperation(value = "查询员工列表",notes = "查询员工列表",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findAll")
    public Object findAll() {
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, personnelService.list());
    }

    @ApiOperation(value = "条件查询员工列表",notes = "条件查询员工列表",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/queryPersonnelList")
    public Object queryPersonnelList(String param) {
        List<PersonnelVO> personnelVOList = personnelService.queryPersonnelList(param);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, personnelVOList);
    }

    @ApiOperation(value = "根据ID查询员工信息",notes = "根据ID查询员工信息",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findById")
    public Object findById(String id) {
        if (StringUtils.isBlank(id)) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, personnelService.getById(Integer.parseInt(id)));
    }

    @ApiOperation(value = "保存员工信息",notes = "保存员工信息",httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/savePersonnel")
    public Object savePersonnel(@RequestBody Personnel personnel) {
        personnel.setLastModificationTime(DateUtil.parseDate(LocalDateTime.now()));
        String fullName = personnel.getFirstName() + personnel.getLastName();
        personnel.setFullName(fullName);
        boolean flag = personnelService.saveOrUpdate(personnel);
        if (flag) {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_SUCCESS);
        } else {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_FAILED);
        }
    }

    @ApiOperation(value = "删除员工信息",notes = "删除员工信息",httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/deletePersonnel")
    public Object deletePersonnel(String ids) {
        int count = 0;
        if (StringUtils.isBlank(ids)) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        List<Integer> removeIds = new ArrayList<>();
        String[] str = ids.split(",");
        if (str != null && str.length > 0) {
            for (String id : str) {
                count += personnelService.delete(Integer.parseInt(id));
            }
        }
        if (str.length > 0 && str.length == count) {
            return ServerResponse.success(ResponseCode.DEL_SUCCESS);
        } else {
            return ServerResponse.success(ResponseCode.DEL_FAILED);
        }
    }

}
