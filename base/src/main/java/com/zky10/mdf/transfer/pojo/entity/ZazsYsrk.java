package com.zky10.mdf.transfer.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2020-11-16
 */
@TableName("ZAZS_YSRK")
public class ZazsYsrk extends Model<ZazsYsrk> {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId("ID")
    private Long id;

    /**
     * 注销标识代码(1.正常2.注销)
     */
    @TableField("ZXBZDM")
    private Long zxbzdm;

    /**
     * 实有人口类别代码
     */
    @TableField("SYRKLBDM")
    private Double syrklbdm;

    /**
     * 实有人口类别名称
     */
    @TableField("SYRKLBMC")
    private String syrklbmc;

    /**
     * 户号
     */
    @TableField("HH")
    private String hh;

    /**
     * 与户主关系
     */
    @TableField("YHZGX")
    private String yhzgx;

    /**
     * 普查标志（1.已普查2.未普查）
     */
    @TableField("PCBZ")
    private Long pcbz;

    /**
     * 姓名
     */
    @TableField("XM")
    private String xm;

    /**
     * 外文姓
     */
    @TableField("WWX")
    private String wwx;

    /**
     * 外文名
     */
    @TableField("WWM")
    private String wwm;

    /**
     * 性别代码（1.男2.女）
     */
    @TableField("XBDM")
    private Long xbdm;

    /**
     * 性别名称
     */
    @TableField("XBMC")
    private String xbmc;

    /**
     * 民族代码
     */
    @TableField("MZDM")
    private Long mzdm;

    /**
     * 民族名臣
     */
    @TableField("MZMC")
    private String mzmc;

    /**
     * 出生日期
     */
    @TableField("CSRQ")
    private LocalDateTime csrq;

    /**
     * 公民身份证号
     */
    @TableField("GMSFHM")
    private String gmsfhm;

    /**
     * 户籍地
     */
    @TableField("HJD")
    private String hjd;

    /**
     * 实际居住地
     */
    @TableField("SJJZD")
    private String sjjzd;

    /**
     * 外出日期
     */
    @TableField("WCRQ")
    private LocalDateTime wcrq;

    /**
     * 职业
     */
    @TableField("ZY")
    private String zy;

    /**
     * 文化程度
     */
    @TableField("WHCD")
    private String whcd;

    /**
     * 户关系
     */
    @TableField("HGX")
    private String hgx;

    /**
     * 联系方式
     */
    @TableField("LXFS")
    private Long lxfs;

    /**
     * 所属区划
     */
    @TableField("SSQH")
    private String ssqh;

    /**
     * 维护标志代码（1.已维护2.未维护）
     */
    @TableField("WHBSDM")
    private Long whbsdm;

    /**
     * 维护标志名称
     */
    @TableField("WHBZMC")
    private String whbzmc;

    /**
     * 维护时间
     */
    @TableField("WHSJ")
    private LocalDateTime whsj;

    /**
     * 注销标识名称
     */
    @TableField("ZXBZMC")
    private String zxbzmc;

    /**
     * 普查人ID
     */
    @TableField("PCRID")
    private Long pcrid;

    /**
     * 普查人
     */
    @TableField("PCR")
    private String pcr;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 状态：1—有效，2--无效，0--不做物理删除。
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 来宁日期
     */
    @TableField("LNRQ")
    private LocalDateTime lnrq;

    /**
     *  登记日期
     */
    @TableField("DJRQ")
    private LocalDateTime djrq;

    /**
     *  所在地区
     */
    @TableField("SZDQ")
    private String szdq;

    /**
     *  详细地址
     */
    @TableField("XXDZ")
    private String xxdz;

    /**
     * 区分局
     */
    @TableField("QFJ")
    private String qfj;

    /**
     * 派出所
     */
    @TableField("PCS")
    private String pcs;

    /**
     * 街路巷
     */
    @TableField("JLX")
    private String jlx;

    /**
     * 门牌号
     */
    @TableField("MPH")
    private String mph;

    /**
     * 人号
     */
    @TableField("RH")
    private String rh;

    /**
     * 信息级别
     */
    @TableField("XXJB")
    private String xxjb;

    /**
     * 服务处所
     */
    @TableField("FWCS")
    private String fwcs;


    public Long getId() {
        return id;
    }

    public ZazsYsrk setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getZxbzdm() {
        return zxbzdm;
    }

    public ZazsYsrk setZxbzdm(Long zxbzdm) {
        this.zxbzdm = zxbzdm;
        return this;
    }

    public Double getSyrklbdm() {
        return syrklbdm;
    }

    public ZazsYsrk setSyrklbdm(Double syrklbdm) {
        this.syrklbdm = syrklbdm;
        return this;
    }

    public String getSyrklbmc() {
        return syrklbmc;
    }

    public ZazsYsrk setSyrklbmc(String syrklbmc) {
        this.syrklbmc = syrklbmc;
        return this;
    }

    public String getHh() {
        return hh;
    }

    public ZazsYsrk setHh(String hh) {
        this.hh = hh;
        return this;
    }

    public String getYhzgx() {
        return yhzgx;
    }

    public ZazsYsrk setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
        return this;
    }

    public Long getPcbz() {
        return pcbz;
    }

    public ZazsYsrk setPcbz(Long pcbz) {
        this.pcbz = pcbz;
        return this;
    }

    public String getXm() {
        return xm;
    }

    public ZazsYsrk setXm(String xm) {
        this.xm = xm;
        return this;
    }

    public String getWwx() {
        return wwx;
    }

    public ZazsYsrk setWwx(String wwx) {
        this.wwx = wwx;
        return this;
    }

    public String getWwm() {
        return wwm;
    }

    public ZazsYsrk setWwm(String wwm) {
        this.wwm = wwm;
        return this;
    }

    public Long getXbdm() {
        return xbdm;
    }

    public ZazsYsrk setXbdm(Long xbdm) {
        this.xbdm = xbdm;
        return this;
    }

    public String getXbmc() {
        return xbmc;
    }

    public ZazsYsrk setXbmc(String xbmc) {
        this.xbmc = xbmc;
        return this;
    }

    public Long getMzdm() {
        return mzdm;
    }

    public ZazsYsrk setMzdm(Long mzdm) {
        this.mzdm = mzdm;
        return this;
    }

    public String getMzmc() {
        return mzmc;
    }

    public ZazsYsrk setMzmc(String mzmc) {
        this.mzmc = mzmc;
        return this;
    }

    public LocalDateTime getCsrq() {
        return csrq;
    }

    public ZazsYsrk setCsrq(LocalDateTime csrq) {
        this.csrq = csrq;
        return this;
    }

    public String getGmsfhm() {
        return gmsfhm;
    }

    public ZazsYsrk setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
        return this;
    }

    public String getHjd() {
        return hjd;
    }

    public ZazsYsrk setHjd(String hjd) {
        this.hjd = hjd;
        return this;
    }

    public String getSjjzd() {
        return sjjzd;
    }

    public ZazsYsrk setSjjzd(String sjjzd) {
        this.sjjzd = sjjzd;
        return this;
    }

    public LocalDateTime getWcrq() {
        return wcrq;
    }

    public ZazsYsrk setWcrq(LocalDateTime wcrq) {
        this.wcrq = wcrq;
        return this;
    }

    public String getZy() {
        return zy;
    }

    public ZazsYsrk setZy(String zy) {
        this.zy = zy;
        return this;
    }

    public String getWhcd() {
        return whcd;
    }

    public ZazsYsrk setWhcd(String whcd) {
        this.whcd = whcd;
        return this;
    }

    public String getHgx() {
        return hgx;
    }

    public ZazsYsrk setHgx(String hgx) {
        this.hgx = hgx;
        return this;
    }

    public Long getLxfs() {
        return lxfs;
    }

    public ZazsYsrk setLxfs(Long lxfs) {
        this.lxfs = lxfs;
        return this;
    }

    public String getSsqh() {
        return ssqh;
    }

    public ZazsYsrk setSsqh(String ssqh) {
        this.ssqh = ssqh;
        return this;
    }

    public Long getWhbsdm() {
        return whbsdm;
    }

    public ZazsYsrk setWhbsdm(Long whbsdm) {
        this.whbsdm = whbsdm;
        return this;
    }

    public String getWhbzmc() {
        return whbzmc;
    }

    public ZazsYsrk setWhbzmc(String whbzmc) {
        this.whbzmc = whbzmc;
        return this;
    }

    public LocalDateTime getWhsj() {
        return whsj;
    }

    public ZazsYsrk setWhsj(LocalDateTime whsj) {
        this.whsj = whsj;
        return this;
    }

    public String getZxbzmc() {
        return zxbzmc;
    }

    public ZazsYsrk setZxbzmc(String zxbzmc) {
        this.zxbzmc = zxbzmc;
        return this;
    }

    public Long getPcrid() {
        return pcrid;
    }

    public ZazsYsrk setPcrid(Long pcrid) {
        this.pcrid = pcrid;
        return this;
    }

    public String getPcr() {
        return pcr;
    }

    public ZazsYsrk setPcr(String pcr) {
        this.pcr = pcr;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ZazsYsrk setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ZazsYsrk setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getLnrq() {
        return lnrq;
    }

    public ZazsYsrk setLnrq(LocalDateTime lnrq) {
        this.lnrq = lnrq;
        return this;
    }

    public LocalDateTime getDjrq() {
        return djrq;
    }

    public ZazsYsrk setDjrq(LocalDateTime djrq) {
        this.djrq = djrq;
        return this;
    }

    public String getSzdq() {
        return szdq;
    }

    public ZazsYsrk setSzdq(String szdq) {
        this.szdq = szdq;
        return this;
    }

    public String getXxdz() {
        return xxdz;
    }

    public ZazsYsrk setXxdz(String xxdz) {
        this.xxdz = xxdz;
        return this;
    }

    public String getQfj() {
        return qfj;
    }

    public ZazsYsrk setQfj(String qfj) {
        this.qfj = qfj;
        return this;
    }

    public String getPcs() {
        return pcs;
    }

    public ZazsYsrk setPcs(String pcs) {
        this.pcs = pcs;
        return this;
    }

    public String getJlx() {
        return jlx;
    }

    public ZazsYsrk setJlx(String jlx) {
        this.jlx = jlx;
        return this;
    }

    public String getMph() {
        return mph;
    }

    public ZazsYsrk setMph(String mph) {
        this.mph = mph;
        return this;
    }

    public String getRh() {
        return rh;
    }

    public ZazsYsrk setRh(String rh) {
        this.rh = rh;
        return this;
    }

    public String getXxjb() {
        return xxjb;
    }

    public ZazsYsrk setXxjb(String xxjb) {
        this.xxjb = xxjb;
        return this;
    }

    public String getFwcs() {
        return fwcs;
    }

    public ZazsYsrk setFwcs(String fwcs) {
        this.fwcs = fwcs;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ZazsYsrk{" +
        "id=" + id +
        ", zxbzdm=" + zxbzdm +
        ", syrklbdm=" + syrklbdm +
        ", syrklbmc=" + syrklbmc +
        ", hh=" + hh +
        ", yhzgx=" + yhzgx +
        ", pcbz=" + pcbz +
        ", xm=" + xm +
        ", wwx=" + wwx +
        ", wwm=" + wwm +
        ", xbdm=" + xbdm +
        ", xbmc=" + xbmc +
        ", mzdm=" + mzdm +
        ", mzmc=" + mzmc +
        ", csrq=" + csrq +
        ", gmsfhm=" + gmsfhm +
        ", hjd=" + hjd +
        ", sjjzd=" + sjjzd +
        ", wcrq=" + wcrq +
        ", zy=" + zy +
        ", whcd=" + whcd +
        ", hgx=" + hgx +
        ", lxfs=" + lxfs +
        ", ssqh=" + ssqh +
        ", whbsdm=" + whbsdm +
        ", whbzmc=" + whbzmc +
        ", whsj=" + whsj +
        ", zxbzmc=" + zxbzmc +
        ", pcrid=" + pcrid +
        ", pcr=" + pcr +
        ", remark=" + remark +
        ", status=" + status +
        ", lnrq=" + lnrq +
        ", djrq=" + djrq +
        ", szdq=" + szdq +
        ", xxdz=" + xxdz +
        ", qfj=" + qfj +
        ", pcs=" + pcs +
        ", jlx=" + jlx +
        ", mph=" + mph +
        ", rh=" + rh +
        ", xxjb=" + xxjb +
        ", fwcs=" + fwcs +
        "}";
    }
}
