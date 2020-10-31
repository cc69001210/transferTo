package com.zky10.mdf.transfer.config.base;

import com.cc.base.common.service.BaseService;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 11:46
 * @Description:
 */
public interface BaseTransferService<T> extends BaseService<T> {

    boolean transferToFile();
}
