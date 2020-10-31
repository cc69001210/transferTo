package com.zky10.mdf.transfer.service;

import com.zky10.mdf.transfer.config.base.BaseTransferService;
import com.zky10.mdf.transfer.pojo.entity.BdHy;

import java.util.List;

/**
 * <p>
 * 婚姻信息表 服务类
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
public interface BdHyService extends BaseTransferService<BdHy> {

    Long getNeedTransCount(Long lastNumber);

    Long getMaxId();

    List<BdHy> listByStartAndEnd(Long start, long end);
}
