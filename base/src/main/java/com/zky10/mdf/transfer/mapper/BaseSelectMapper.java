package com.zky10.mdf.transfer.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 婚姻信息表 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
public interface BaseSelectMapper  {

    List<String> getExistTables(@Param("tables") List<String> tables);
}
