package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Personnel;
import com.core.coreapi.dao.PersonnelMapper;
import com.core.coreapi.domain.pojo.PersonnelVO;
import com.core.coreapi.service.PersonnelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sstang
 * @since 2019-11-05
 */
@Service
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, Personnel> implements PersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;

    @Override
    public List<PersonnelVO> queryPersonnelList(String param) {
        if (param != null) {
            param = "%" + param + "%";
        } else {
            param = "%%";
        }
        return personnelMapper.queryPersonnelList(param);
    }

    @Override
    public int delete(int id) {
        return personnelMapper.deleteById(id);
    }
}
