package com.core.coreapi.service;

import com.core.coreapi.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sstang
 * @since 2020-01-01
 */
public interface UserService extends IService<User> {

    public User findByUserName(String userName);
}
