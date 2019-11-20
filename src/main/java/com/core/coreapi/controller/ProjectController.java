package com.core.coreapi.controller;


import com.core.coreapi.service.ProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sstang
 * @since 2019-11-15
 */
@RestController
@RequestMapping("/project")
@Api(description = "项目相关接口")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


}
