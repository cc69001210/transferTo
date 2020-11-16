package com.zky10.mdf.transfer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zky10.mdf.transfer.pojo.entity.ZazsYsrk;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
public interface ZazsYsrkMapper extends BaseMapper<ZazsYsrk> {

    @Select(" SELECT ID FROM ZAZS_YSRK WHERE ROWNUM = 1 ORDER BY ID DESC ")
    Long getMaxId();

}
