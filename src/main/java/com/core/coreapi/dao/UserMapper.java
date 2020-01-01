package com.core.coreapi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.coreapi.domain.entity.User;
import com.core.coreapi.domain.pojo.UserVO;
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

    @Select("select * from user where userName = #{userName}")
    User findByName(String userName);

    UserVO findUserInfo(String userName);

}
