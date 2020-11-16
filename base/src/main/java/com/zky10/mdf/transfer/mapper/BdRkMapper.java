package com.zky10.mdf.transfer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zky10.mdf.transfer.pojo.entity.BdRk;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 人口基本信息表 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
public interface BdRkMapper extends BaseMapper<BdRk> {

    @Select(" SELECT ID FROM (SELECT ID FROM BD_RK ORDER BY ID DESC ) WHERE ROWNUM = 1 ")
    Long getMaxId();

}
