package com.core.coreapi.service;

import com.core.coreapi.domain.entity.Personnel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.core.coreapi.domain.pojo.PersonnelVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sstang
 * @since 2019-11-05
 */
public interface PersonnelService extends IService<Personnel> {

    List<PersonnelVO> queryPersonnelList(String param);

    int delete(int id);
}
