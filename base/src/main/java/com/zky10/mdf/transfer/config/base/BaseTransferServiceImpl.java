package com.zky10.mdf.transfer.config.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-11-02 10:30
 * @Description:
 */
public abstract class BaseTransferServiceImpl<M extends BaseMapper<T>, T extends Model> extends ServiceImpl<M,T> implements BaseTransferService<T> {

    @Override
    public abstract boolean transferToFile();

    @Override
    public abstract boolean transferToDB();

    @Override
    public Long getNeedTransCount(Long lastNumber) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("ID",lastNumber);
        return (long) this.count(queryWrapper);
    }

    @Override
    public abstract Long getMaxId();

    @Override
    public List<T> listNeedTransferData(Long start, long end) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("ID",start);
        queryWrapper.lt("ID",end);
        return this.list(queryWrapper);
    }


}
