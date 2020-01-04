package com.core.coreapi.controller;

import com.core.coreapi.domain.entity.User;
import com.core.coreapi.service.RolePermissionService;
import com.core.coreapi.service.UserRoleService;
import com.core.coreapi.service.UserService;
import com.core.coreapi.util.StringUtil;
import com.core.coreapi.util.resp.ResponseCode;
import com.core.coreapi.util.resp.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @Description:
 * http://localhost:8080
 * http://localhost:8080/#/login
 * @Author: sstang
 * @Date: 2020/01/03
 */
@RestController
@RequestMapping("/auth")
@Api(description = "登录相关接口")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 登录方法
     * 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
     * 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
     * //后台的登录处理方法参数用boolean类型接收，并且在得到身份验证Token时传入rememberMe参数
     * 上一次设置了rememberme, 本次登录是不会触发action中的login()的方法的, 即会直接进入登录状态
     * 即subject.isAuthenticated()==true，
     * 则subject.isRemembered()==false；
     * 反之一样
     *
     * @param username
     * @param password
     * @return
     * @throws AuthenticationException
     */

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/login")
    public Object loginUser(@Param("username") String username,@Param("password")  String password) throws AuthenticationException {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("msg", "登录成功");
        Subject subject = SecurityUtils.getSubject();
        //已经登录过
        /*if (subject.isAuthenticated()) {
            User user = (User) subject.getPrincipal();
            result.put("user", user);
            logger.info("subject.isAuthenticated,username:{}, login success", user.getUserName());
            return result;
        }*/
        //勾选了记住我
       /* if (subject.isRemembered()) {
            User user = (User) subject.getPrincipal();
            result.put("user", user);
            logger.info("subject.isRemembered,username:{},login success", user.getUserName());
            return result;
        }*/
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password, true);
//        usernamePasswordToken.setRememberMe(rememberMe);
        try {
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            result.put("user", user);
            logger.info("username:{},password:{} login success", username, password);
        } catch (UnknownAccountException e) {
            //用户名不存在
            result.put("code", "-1");
            result.put("msg", "用户名不存在");
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            //密码错误
            result.put("code", "-1");
            result.put("msg", "用户名或密码错误");
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());
        } catch (LockedAccountException e) {
            //账户被锁定
            result.put("code", "-1");
            result.put("msg", "账户被锁定");
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());

        } catch (ExcessiveAttemptsException e) {
            //登录失败次数超过系统最大次数,请稍后重试
            result.put("code", "-1");
            result.put("msg", "登录失败次数超过系统最大次数,请稍后重试!");
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());

        } catch (DisabledAccountException e) {
            //验证未通过,帐号已经禁止登录
            result.put("code", "-1");
            result.put("msg", "验证未通过,帐号已经禁止登录!");
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());

        } catch (AuthenticationException e) {
            //出现其他异常
            result.put("code", "-1");
            result.put("msg", e.getMessage());
            logger.error("username:{},password:{} login fail,error info is:{}", username, password, e.getMessage());
        }

        return result;
    }

    /**
     * 获取info
     *
     * @param token
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ServerResponse getInfo(@RequestParam(value = "token", required = false) String token) {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal == null) {
            return ServerResponse.customError(ResponseCode.UNAUTHORIZED);
        }
        User user = userService.findUserInfo(principal.toString());
        List<String> roles = userRoleService.findUserRoles(principal.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", principal);
        map.put("roles", roles);
        map.put("permissions", rolePermissionService.findRolePermissions(StringUtil.convertListToString(roles)));
        logger.warn("token=[{}]", token);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, map);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            //session.removeAttribute("user");
            result.put("code", "200");
            result.put("msg", "退出成功");
        } catch (Exception e) {
            logger.error("logout fail,error info is:{}", e.getMessage());
            result.put("code", "-1");
            result.put("msg", "退出异常");
        }
        return result;
    }

    /**
     * 跳转到登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    String index(HttpServletRequest request) {
        return "index";
    }

    /**
     * 跳转到登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index2(HttpServletRequest request) {
        return "index";
    }
}
