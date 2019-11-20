package com.core.coreapi.service.impl;

import com.core.coreapi.domain.entity.Site;
import com.core.coreapi.dao.SiteMapper;
import com.core.coreapi.service.SiteService;
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
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements SiteService {

}
