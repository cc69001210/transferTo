package com.zky10.mdf.transfer.service.impl;

import com.zky10.mdf.transfer.config.base.BaseTransferServiceImpl;
import com.zky10.mdf.transfer.mapper.BdRkMapper;
import com.zky10.mdf.transfer.pojo.entity.BdRk;
import com.zky10.mdf.transfer.service.BdRkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人口基本信息表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
@Service
public class BdRkServiceImpl extends BaseTransferServiceImpl<BdRkMapper, BdRk> implements BdRkService {

    @Value("${page.pageSize}")
    private Integer pageSize;

    @Autowired
    private BdRkMapper bdRkMapper;

    @Override
    public Long getMaxId() {
        return bdRkMapper.getMaxId();
    }
}
