package com.zky10.mdf.transfer.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.base.common.domain.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 婚姻信息表
 * </p>
 *
 * @author cc
 * @since 2020-10-30
 */
@TableName("BD_HY")
@Data
public class BdHy extends Model<BdHy> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ID")
    private Long ID;

    /**
     * 业务类型:ia-结婚登记  ib-离婚登记 ica-补发结婚 icb-补发离婚
     */
    @TableField("YWLX")
    private String ywlx;

    /**
     * 结婚分类:1-本市与本市，2-本市与外地
     */
    @TableField("JHFL")
    private String jhfl;

    /**
     * 补领婚姻登记证类别:1-结婚证,2-离婚证
     */
    @TableField("BLLB")
    private String bllb;

    /**
     * 姓名（男）
     */
    @TableField("XM_MAN")
    private String xmMan;

    /**
     * 姓名（女）
     */
    @TableField("XM_WOMAN")
    private String xmWoman;

    /**
     * 身份证号（男）
     */
    @TableField("SFZH_MAN")
    private String sfzhMan;

    /**
     * 身份证号（女）
     */
    @TableField("SFZH_WOMAN")
    private String sfzhWoman;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 录入时间
     */
    @TableField("ENTERING_TIME")
    private LocalDateTime enteringTime;

    /**
     * 图片
     */
    @TableField("PIC")
    private String pic;

    /**
     * 登记时间
     */
    @TableField("OP_DATE")
    private String opDate;

    /**
     * 数据归属地代码
     */
    @TableField("GSDDM")
    private String gsddm;

}
