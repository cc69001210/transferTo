package com.zky10.mdf.transfer.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 人口基本信息表
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
@TableName("BD_RK")
public class BdRk extends Model<BdRk> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableField("ID")
    private Long id;

    /**
     * 姓名
     */
    @TableField("XM")
    private String xm;

    /**
     * 曾用名
     */
    @TableField("CYM")
    private String cym;

    /**
     * 性别
     */
    @TableField("XB")
    private String xb;

    /**
     * 民族
     */
    @TableField("MZ")
    private String mz;

    /**
     * 出生日期
     */
    @TableField("CSRQ")
    private String csrq;

    /**
     * 身份证号
     */
    @TableField("SFZH")
    private String sfzh;

    /**
     * 电话
     */
    @TableField("DH")
    private String dh;

    /**
     * 户籍地址
     */
    @TableField("HJDZ")
    private String hjdz;

    /**
     * 现住地址
     */
    @TableField("XZDZ")
    private String xzdz;

    /**
     * 职业
     */
    @TableField("ZY")
    private String zy;

    /**
     * 文化程度代码
     */
    @TableField("WHCD_DM")
    private String whcdDm;

    /**
     * 文化程度
     */
    @TableField("WHCD")
    private String whcd;

    /**
     * 婚姻状况代码
     */
    @TableField("HYZK_DM")
    private String hyzkDm;

    /**
     * 婚姻状况
     */
    @TableField("HYZK")
    private String hyzk;

    /**
     * 兵役状况代码
     */
    @TableField("BYZK_DM")
    private String byzkDm;

    /**
     * 兵役状况
     */
    @TableField("BYZK")
    private String byzk;

    /**
     * 经度
     */
    @TableField("LONGITUDE")
    private String longitude;

    /**
     * 纬度
     */
    @TableField("LATITUDE")
    private String latitude;

    /**
     * 图片
     */
    @TableField("PIC")
    private String pic;

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
     * 民族代码
     */
    @TableField("MZ_DM")
    private String mzDm;

    /**
     * 性别代码
     */
    @TableField("XB_DM")
    private String xbDm;

    /**
     * 录入时间
     */
    @TableField("ENTERING_TIME")
    private LocalDateTime enteringTime;

    /**
     * 户号
     */
    @TableField("HH")
    private String hh;

    /**
     * 家庭关系名称
     */
    @TableField("JTGX_MC")
    private String jtgxMc;

    /**
     * 家庭关系代码
     */
    @TableField("JTGX_DM")
    private String jtgxDm;

    /**
     * 数据归属地代码
     */
    @TableField("GSDDM")
    private String gsddm;


    public Long getId() {
        return id;
    }

    public BdRk setId(Long id) {
        this.id = id;
        return this;
    }

    public String getXm() {
        return xm;
    }

    public BdRk setXm(String xm) {
        this.xm = xm;
        return this;
    }

    public String getCym() {
        return cym;
    }

    public BdRk setCym(String cym) {
        this.cym = cym;
        return this;
    }

    public String getXb() {
        return xb;
    }

    public BdRk setXb(String xb) {
        this.xb = xb;
        return this;
    }

    public String getMz() {
        return mz;
    }

    public BdRk setMz(String mz) {
        this.mz = mz;
        return this;
    }

    public String getCsrq() {
        return csrq;
    }

    public BdRk setCsrq(String csrq) {
        this.csrq = csrq;
        return this;
    }

    public String getSfzh() {
        return sfzh;
    }

    public BdRk setSfzh(String sfzh) {
        this.sfzh = sfzh;
        return this;
    }

    public String getDh() {
        return dh;
    }

    public BdRk setDh(String dh) {
        this.dh = dh;
        return this;
    }

    public String getHjdz() {
        return hjdz;
    }

    public BdRk setHjdz(String hjdz) {
        this.hjdz = hjdz;
        return this;
    }

    public String getXzdz() {
        return xzdz;
    }

    public BdRk setXzdz(String xzdz) {
        this.xzdz = xzdz;
        return this;
    }

    public String getZy() {
        return zy;
    }

    public BdRk setZy(String zy) {
        this.zy = zy;
        return this;
    }

    public String getWhcdDm() {
        return whcdDm;
    }

    public BdRk setWhcdDm(String whcdDm) {
        this.whcdDm = whcdDm;
        return this;
    }

    public String getWhcd() {
        return whcd;
    }

    public BdRk setWhcd(String whcd) {
        this.whcd = whcd;
        return this;
    }

    public String getHyzkDm() {
        return hyzkDm;
    }

    public BdRk setHyzkDm(String hyzkDm) {
        this.hyzkDm = hyzkDm;
        return this;
    }

    public String getHyzk() {
        return hyzk;
    }

    public BdRk setHyzk(String hyzk) {
        this.hyzk = hyzk;
        return this;
    }

    public String getByzkDm() {
        return byzkDm;
    }

    public BdRk setByzkDm(String byzkDm) {
        this.byzkDm = byzkDm;
        return this;
    }

    public String getByzk() {
        return byzk;
    }

    public BdRk setByzk(String byzk) {
        this.byzk = byzk;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public BdRk setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public BdRk setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getPic() {
        return pic;
    }

    public BdRk setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BdRk setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public BdRk setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getMzDm() {
        return mzDm;
    }

    public BdRk setMzDm(String mzDm) {
        this.mzDm = mzDm;
        return this;
    }

    public String getXbDm() {
        return xbDm;
    }

    public BdRk setXbDm(String xbDm) {
        this.xbDm = xbDm;
        return this;
    }

    public LocalDateTime getEnteringTime() {
        return enteringTime;
    }

    public BdRk setEnteringTime(LocalDateTime enteringTime) {
        this.enteringTime = enteringTime;
        return this;
    }

    public String getHh() {
        return hh;
    }

    public BdRk setHh(String hh) {
        this.hh = hh;
        return this;
    }

    public String getJtgxMc() {
        return jtgxMc;
    }

    public BdRk setJtgxMc(String jtgxMc) {
        this.jtgxMc = jtgxMc;
        return this;
    }

    public String getJtgxDm() {
        return jtgxDm;
    }

    public BdRk setJtgxDm(String jtgxDm) {
        this.jtgxDm = jtgxDm;
        return this;
    }

    public String getGsddm() {
        return gsddm;
    }

    public BdRk setGsddm(String gsddm) {
        this.gsddm = gsddm;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "BdRk{" +
        "id=" + id +
        ", xm=" + xm +
        ", cym=" + cym +
        ", xb=" + xb +
        ", mz=" + mz +
        ", csrq=" + csrq +
        ", sfzh=" + sfzh +
        ", dh=" + dh +
        ", hjdz=" + hjdz +
        ", xzdz=" + xzdz +
        ", zy=" + zy +
        ", whcdDm=" + whcdDm +
        ", whcd=" + whcd +
        ", hyzkDm=" + hyzkDm +
        ", hyzk=" + hyzk +
        ", byzkDm=" + byzkDm +
        ", byzk=" + byzk +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", pic=" + pic +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", mzDm=" + mzDm +
        ", xbDm=" + xbDm +
        ", enteringTime=" + enteringTime +
        ", hh=" + hh +
        ", jtgxMc=" + jtgxMc +
        ", jtgxDm=" + jtgxDm +
        ", gsddm=" + gsddm +
        "}";
    }
}
