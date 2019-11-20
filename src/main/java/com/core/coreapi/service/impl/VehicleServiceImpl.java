package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Vehicle;
import com.core.coreapi.dao.VehicleMapper;
import com.core.coreapi.service.VehicleService;
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
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle> implements VehicleService {

}
