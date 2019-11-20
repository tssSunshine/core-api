package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Sensor;
import com.core.coreapi.dao.SensorMapper;
import com.core.coreapi.service.SensorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SensorServiceImpl extends ServiceImpl<SensorMapper, Sensor> implements SensorService {

}
