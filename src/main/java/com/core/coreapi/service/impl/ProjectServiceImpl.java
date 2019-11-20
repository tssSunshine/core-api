package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Project;
import com.core.coreapi.dao.ProjectMapper;
import com.core.coreapi.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sstang
 * @since 2019-11-15
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int delete(int id) {
        return projectMapper.deleteById(id);
    }
}
