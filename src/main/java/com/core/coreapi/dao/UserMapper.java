package com.core.coreapi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.coreapi.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sstang
 * @since 2019-10-25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User findByName(@Param("userName") String userName);

    User findUserInfo(@Param("userName") String userName);

}
