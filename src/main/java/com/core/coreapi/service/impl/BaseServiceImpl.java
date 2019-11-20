package com.core.coreapi.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.coreapi.service.BaseService;
import com.core.coreapi.util.resp.ResponseCode;
import com.core.coreapi.util.resp.ServerResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseServiceImpl implements BaseService {

    private BaseMapper baseMapper;

    public BaseServiceImpl(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int deleteById(int id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(String ids) {
        int count = 0;
        if (StringUtils.isBlank(ids)) {
            return -1;
        }
        List<Integer> removeIds = new ArrayList<>();
        String[] str = ids.split(",");
        if (str != null && str.length > 0) {
            for (String id : str) {
                count += this.deleteById(Integer.parseInt(id));
            }
        }
        return count;
    }
}
