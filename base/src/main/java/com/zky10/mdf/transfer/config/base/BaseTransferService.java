package com.zky10.mdf.transfer.config.base;


import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 11:46
 * @Description:
 */
public interface BaseTransferService<T> extends IService<T> {

    boolean transferToFile();

    boolean transferToDB();

    Long getNeedTransCount(Long lastNumber);

    Long getMaxId();

    List<T> listNeedTransferData(Long start, long end);
}
