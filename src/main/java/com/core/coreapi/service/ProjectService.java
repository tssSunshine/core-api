package com.core.coreapi.service;

import com.core.coreapi.domain.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sstang
 * @since 2019-11-15
 */
public interface ProjectService extends IService<Project> {

    int delete(int id);
}
