package com.core.coreapi.service;

import com.core.coreapi.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sstang
 * @since 2019-10-25
 */
public interface UserService extends IService<User> {

    User findByName(String userName);
}
