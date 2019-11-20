package com.core.coreapi.controller;


import com.core.coreapi.domain.entity.User;
import com.core.coreapi.service.UserService;
import com.core.coreapi.util.resp.ResponseCode;
import com.core.coreapi.util.resp.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sstang
 * @since 2019-10-25
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "保存用户",notes = "保存用户",httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/save")
    public Object saveUser(@RequestBody User user){
       boolean result = userService.save(user);
       return result;
    }

    @ApiOperation(value = "查询所有用户",notes = "查询所有用户",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findAllUser")
    public Object findAllUser() {
        List<User> users = userService.list();
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, users);
    }

    @ApiOperation(value = "根据用户名查询用户",notes = "根据用户名查询用户",httpMethod = "GET")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/findByName")
    public Object findByName(String userName ) {
        User user = userService.findByName(userName);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, user);
    }
}
