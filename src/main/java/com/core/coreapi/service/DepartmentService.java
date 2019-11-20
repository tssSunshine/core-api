package com.core.coreapi.service;

import com.core.coreapi.domain.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.core.coreapi.domain.pojo.DepartmentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sstang
 * @since 2019-11-01
 */
public interface DepartmentService extends IService<Department> {

    List<DepartmentVO> findDepartmentList(String param);

    int delete(int id);
}
