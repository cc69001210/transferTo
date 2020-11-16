package com.zky10.mdf.transfer.service.impl;

import com.zky10.mdf.transfer.config.base.BaseTransferServiceImpl;
import com.zky10.mdf.transfer.mapper.ZazsYsrkMapper;
import com.zky10.mdf.transfer.pojo.entity.ZazsYsrk;
import com.zky10.mdf.transfer.service.ZazsYsrkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
@Service
public class ZazsYsrkServiceImpl extends BaseTransferServiceImpl<ZazsYsrkMapper, ZazsYsrk> implements ZazsYsrkService {

    @Autowired
    private ZazsYsrkMapper zazsYsrkMapper;


    @Override
    public Long getMaxId() {
        return zazsYsrkMapper.getMaxId();
    }
}
