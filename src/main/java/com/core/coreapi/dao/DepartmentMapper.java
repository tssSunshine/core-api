package com.core.coreapi.dao;

import com.core.coreapi.domain.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.coreapi.domain.pojo.DepartmentVO;
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
 * @since 2019-11-01
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("select d.id,d.lastModificationTime,d.isDeleted,d.departmentID,d.departmentName,d.departmentDesc," +
            "d.departmentPhoneNumber,d.departmentHeadId,d.departmentDeputyId," +
            "p.fullName as departmentHeadName,p.phoneNumber as departmentHeadPhoneNum "+
            "from department d left join personnel p on d.departmentHeadId = p.id " +
            "where d.isDeleted = 0 and " +
            "(d.departmentID like #{param} or d.departmentName like #{param}) order by id")
    List<DepartmentVO> findDepartmentList(@Param("param") String param);

}
