package com.core.coreapi.service.impl;

import com.core.coreapi.dao.UserMapper;
import com.core.coreapi.domain.entity.User;
import com.core.coreapi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sstang
 * @since 2019-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String userName) {
        return userMapper.findByName(userName);
    }
}
