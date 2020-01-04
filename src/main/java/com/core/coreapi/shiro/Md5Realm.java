package com.core.coreapi.shiro;

import com.alibaba.fastjson.JSONObject;
import com.core.coreapi.domain.entity.Permission;
import com.core.coreapi.domain.entity.Role;
import com.core.coreapi.domain.entity.User;
import com.core.coreapi.domain.pojo.RoleVO;
import com.core.coreapi.domain.pojo.UserVO;
import com.core.coreapi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 自定义Realm，认证用户，授权
 * @Author: sstang
 * @Date: 2020/01/01
 */
public class Md5Realm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(Md5Realm.class);
    /**
     * 延迟加载bean,解决缓存Cache不能正常使用;事务Transaction注解不能正常运行
     */
    @Autowired
    private UserService userService;

    /**
     * 认证.登录
     * doGetAuthenticationInfo这个方法是在用户登录的时候调用的
     * 也就是执行SecurityUtils.getSubject().login()的时候调用；(即:登录验证)
     * 验证通过后会用户保存在缓存中的
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("##################执行Shiro登录认证##################");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.findByUserName(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassWord(), getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * doGetAuthorizationInfo方法是在我们调用
     * SecurityUtils.getSubject().isPermitted（）这个方法，
     * 授权后用户角色及权限会保存在缓存中的
     *
     * @param principal
     * @return
     * @RequiresPermissions这个注解起始就是在执行SecurityUtils.getSubject().isPermitted（）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();
        //查询数据库
        user = userService.findUserInfo(user.getUserName());
        logger.info("##################执行Shiro权限授权##################user info is：{}" + JSONObject.toJSONString(user));
        Set<String> userPermissions = new HashSet<String>();
        Set<String> userRoles = new HashSet<String>();
        for (Role role : user.getRoles()) {
            userRoles.add(role.getRoleName());
            List<Permission> rolePermissions = role.getPermissions();
            for (Permission permission : rolePermissions) {
                userPermissions.add(permission.getPermName());
            }
        }
        //角色名集合
        info.setRoles(userRoles);
        //权限名集合,将权限放入shiro中,
        // 这里可以把url，按钮，菜单，api等当做资源来进行权限控制，从而对用户进行权限控制
        info.addStringPermissions(userPermissions);
        return info;
    }

    private static final String SALT = "abc";
    private static final int hashIterations = 2;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", SALT, hashIterations);//22d70c2e5b86d3c9f25735ebbabf40af
        System.out.println(md5Hash);
    }
}
