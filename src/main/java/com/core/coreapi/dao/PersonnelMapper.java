package com.core.coreapi.dao;

import com.core.coreapi.domain.entity.Personnel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.coreapi.domain.pojo.PersonnelVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sstang
 * @since 2019-11-05
 */
@Repository
public interface PersonnelMapper extends BaseMapper<Personnel> {

    @Select("select p.id,p.lastModificationTime,p.isDeleted,p.lastName,p.firstName,p.email,p.phoneNumber," +
            "p.state,p.city,p.address_1 as address1,p.address_2 as address2,p.personnelDesc," +
            "p.personnelID,p.fullName,p.departmentID,p.position,p.userId,d.departmentName as departmentName " +
            "from personnel p left join department d on p.departmentID = d.id " +
            "where p.isDeleted = 0 and " +
            "(p.lastName like #{param} or p.firstName like #{param} or p.fullName like #{param} " +
            "or p.personnelID like #{param}) order by p.id")
    List<PersonnelVO> queryPersonnelList(@Param("param") String param);
}
