package com.zky10.mdf.transfer.service.impl;

import com.zky10.mdf.transfer.config.base.BaseTransferServiceImpl;
import com.zky10.mdf.transfer.mapper.BdHyMapper;
import com.zky10.mdf.transfer.pojo.entity.BdHy;
import com.zky10.mdf.transfer.service.BdHyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 婚姻信息表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
@Service
@Slf4j
public class BdHyServiceImpl extends BaseTransferServiceImpl<BdHyMapper, BdHy> implements BdHyService {

    @Autowired
    private BdHyMapper bdHyMapper;

    @Override
    public Long getMaxId() {
        return bdHyMapper.getMaxId();
    }

}
