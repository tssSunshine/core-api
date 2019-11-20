package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Department;
import com.core.coreapi.dao.DepartmentMapper;
import com.core.coreapi.domain.pojo.DepartmentVO;
import com.core.coreapi.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sstang
 * @since 2019-11-01
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentVO> findDepartmentList(String param) {
        if (param != null) {
            param = "%" + param + "%";
        } else {
            param = "%%";
        }
        return departmentMapper.findDepartmentList(param);
    }

    @Override
    public int delete(int id) {
        return departmentMapper.deleteById(id);
    }
}
