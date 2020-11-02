package com.zky10.mdf.transfer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zky10.mdf.transfer.pojo.entity.BdHy;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 婚姻信息表 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
public interface BdHyMapper extends BaseMapper<BdHy> {

    @Select(" SELECT ID FROM BD_HY WHERE ROWNUM = 1 ORDER BY ID DESC ")
    Long getMaxId();

}
