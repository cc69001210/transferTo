package com.zky10.mdf.transfer.service.impl;

import com.zky10.mdf.transfer.mapper.BaseSelectMapper;
import com.zky10.mdf.transfer.service.BaseSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 婚姻信息表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
@Service
public class BaseSelectServiceImpl implements BaseSelectService {

    @Autowired
    private BaseSelectMapper baseSelectMapper;

    @Override
    public List<String> getExistTables(List<String> tables) {
        return baseSelectMapper.getExistTables(tables);
    }
}
