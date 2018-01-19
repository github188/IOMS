package cn.com.atnc.ioms.entity.duty.atm;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayMgxTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;

@Entity
@Table(name = "TB_OM_DUTY_ATM_DAY_MGX")
public class ATMDayMgx extends MyStringUUIDEntity {
    private static final long serialVersionUID = -7017960876370690346L;
    //设备运行环境_风扇
    private StatusResultEnum env_fan;
    //设备运行环境_电源
    private StatusResultEnum env_power;
    //设备运行环境_电源
    private StatusResultEnum env_temperatuer;
    //与网控中心8850节点的连通性
    private StatusResultEnum wkzx8850_con;
    //与通信基地8830节点的连通性
    private StatusResultEnum txjd8830_con;
    //中继连通状态
    private StatusResultEnum zj_con;
    //网控中心8830连通性
    private StatusResultEnum wkzx8830_con;
    //通信基地8850连通性
    private StatusResultEnum txjd8850_con;
    //民航局空管局连通性
    private StatusResultEnum mhj_con;
    //首都机场连通性
    private StatusResultEnum capital_con;
    //十里河8850连通性
    private StatusResultEnum slh8850_con;
    //备注
    private String remark;
    // 区域
    private AtmDayMgxTabEnum area;
    // 记录日期（2017-02-07）
    private String recordDate;
    // 记录时间
    private Date recordTime;
    // 记录人
    private User creater;
    // 修改人
    private User updater;
    // 修改时间
    private Date updateTime;
    // 审核人
    private User auditer;
    // 审核时间
    private Date auditTime;
    // 审核备注
    private String auditRemark;
    
    private transient List<ATMDaySon> atmDaySons;
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "ENV_FAN")
    public StatusResultEnum getEnv_fan() {
        return env_fan;
    }
   
    public void setEnv_fan(StatusResultEnum env_fan) {
        this.env_fan = env_fan;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "ENV_POWER")
    public StatusResultEnum getEnv_power() {
        return env_power;
    }
    
    public void setEnv_power(StatusResultEnum env_power) {
        this.env_power = env_power;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "ENV_TEMPERATUER")
    public StatusResultEnum getEnv_temperatuer() {
        return env_temperatuer;
    }

    public void setEnv_temperatuer(StatusResultEnum env_temperatuer) {
        this.env_temperatuer = env_temperatuer;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "WKZX8850_CON")
    public StatusResultEnum getWkzx8850_con() {
        return wkzx8850_con;
    }
    
    public void setWkzx8850_con(StatusResultEnum wkzx8850_con) {
        this.wkzx8850_con = wkzx8850_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "TXJD8830_CON")
    public StatusResultEnum getTxjd8830_con() {
        return txjd8830_con;
    }

    public void setTxjd8830_con(StatusResultEnum txjd8830_con) {
        this.txjd8830_con = txjd8830_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "ZJ_CON")
    public StatusResultEnum getZj_con() {
        return zj_con;
    }
  
    public void setZj_con(StatusResultEnum zj_con) {
        this.zj_con = zj_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "WKZX8830_CON")
    public StatusResultEnum getWkzx8830_con() {
        return wkzx8830_con;
    }
  
    public void setWkzx8830_con(StatusResultEnum wkzx8830_con) {
        this.wkzx8830_con = wkzx8830_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "TXJD8850_CON")
    public StatusResultEnum getTxjd8850_con() {
        return txjd8850_con;
    }

    public void setTxjd8850_con(StatusResultEnum txjd8850_con) {
        this.txjd8850_con = txjd8850_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "MHJ_CON")
    public StatusResultEnum getMhj_con() {
        return mhj_con;
    }
  
    public void setMhj_con(StatusResultEnum mhj_con) {
        this.mhj_con = mhj_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "CAPITAL_CON")
    public StatusResultEnum getCapital_con() {
        return capital_con;
    }
  
    public void setCapital_con(StatusResultEnum capital_con) {
        this.capital_con = capital_con;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "SLH8850_CON")
    public StatusResultEnum getSlh8850_con() {
        return slh8850_con;
    }

    public void setSlh8850_con(StatusResultEnum slh8850_con) {
        this.slh8850_con = slh8850_con;
    }
    
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "AREA")
    public AtmDayMgxTabEnum getArea() {
        return area;
    }

    public void setArea(AtmDayMgxTabEnum area) {
        this.area = area;
    }
    @Column(name = "RECORDDATE")
    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name = "RECORDTIME")
    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    @ManyToOne
    @JoinColumn(name = "CREATER")
    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }
    @ManyToOne
    @JoinColumn(name = "UPDATER")
    public User getUpdater() {
        return updater;
    }

    public void setUpdater(User updater) {
        this.updater = updater;
    }
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name = "UPDATETIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @ManyToOne
    @JoinColumn(name = "AUDITER")
    public User getAuditer() {
        return auditer;
    }

    public void setAuditer(User auditer) {
        this.auditer = auditer;
    }

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name = "AUDITTIME")
    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Column(name = "AUDITREMARK")
    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Transient
    public List<ATMDaySon> getAtmDaySons() {
        return atmDaySons;
    }

    public void setAtmDaySons(List<ATMDaySon> atmDaySons) {
        this.atmDaySons = atmDaySons;
    }
}