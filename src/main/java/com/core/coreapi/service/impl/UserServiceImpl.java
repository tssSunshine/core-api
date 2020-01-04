package com.core.coreapi.service.impl;

import com.core.coreapi.dao.UserMapper;
import com.core.coreapi.domain.entity.User;
import com.core.coreapi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sstang
 * @since 2020-01-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return null;
        }
        return userMapper.findByName(userName);
    }

    @Override
    public User findUserInfo(String userName) {
       if (StringUtils.isBlank(userName)) {
           return null;
       }
       return userMapper.findUserInfo(userName);
    }
}
