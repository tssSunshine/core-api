package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Tracker;
import com.core.coreapi.dao.TrackerMapper;
import com.core.coreapi.service.TrackerService;
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
public class TrackerServiceImpl extends ServiceImpl<TrackerMapper, Tracker> implements TrackerService {

}
