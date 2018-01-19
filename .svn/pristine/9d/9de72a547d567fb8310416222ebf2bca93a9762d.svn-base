package cn.com.atnc.ioms.entity.duty.fax.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;
/**
 * ATN-AMSH系统检查（自动）
 *
 * @author 韩天驭
 * @2017年2月6日 上午10:33:58
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_ATN_AMSH")
public class FaxAtnDay extends MyStringUUIDEntity {
	private static final long serialversionUID = 1L;

	private FaxStatus bjAtnNec1;
	private FaxStatus bjAtnNec2;
	private FaxStatus oracleNec;
	private FaxStatus routermanageNec;

	private FaxStatus mtaNec;
	private FaxStatus idrp;
	private FaxStatus dbOpt;
	private FaxStatus dmPro;
	private FaxStatus r25Pro;
	private FaxStatus backupDmPro;

	// 巡检时间
	private Date checkTime;
	// 创建日期
	private Date createTime;
	// 创建人
	private User creater;
	// 修改时间
	private Date updateTime;
	// 修改人
	private User updter;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AMHS_BJATN1_NEC")
	public FaxStatus getBjAtnNec1() {
		return bjAtnNec1;
	}
	public void setBjAtnNec1(FaxStatus bjAtnNec1) {
		this.bjAtnNec1 = bjAtnNec1;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AMHS_BJATN2_NEC")
	public FaxStatus getBjAtnNec2() {
		return bjAtnNec2;
	}
	public void setBjAtnNec2(FaxStatus bjAtnNec2) {
		this.bjAtnNec2 = bjAtnNec2;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AMHS_ORACLE_NEC")
	public FaxStatus getOracleNec() {
		return oracleNec;
	}
	public void setOracleNec(FaxStatus oracleNec) {
		this.oracleNec = oracleNec;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AMHS_ROUTERMANAGE_NEC")
	public FaxStatus getRoutermanageNec() {
		return routermanageNec;
	}
	public void setRoutermanageNec(FaxStatus routermanageNec) {
		this.routermanageNec = routermanageNec;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AMHS_MTA_NEC")
	public FaxStatus getMtaNec() {
		return mtaNec;
	}
	public void setMtaNec(FaxStatus mtaNec) {
		this.mtaNec = mtaNec;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ATN_IDRP")
	public FaxStatus getIdrp() {
		return idrp;
	}
	public void setIdrp(FaxStatus idrp) {
		this.idrp = idrp;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AFTN_DB_OPT")
	public FaxStatus getDbOpt() {
		return dbOpt;
	}
	public void setDbOpt(FaxStatus dbOpt) {
		this.dbOpt = dbOpt;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AFTN_DM_PRO")
	public FaxStatus getDmPro() {
		return dmPro;
	}
	public void setDmPro(FaxStatus dmPro) {
		this.dmPro = dmPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AFTN_R25_PRO")
	public FaxStatus getR25Pro() {
		return r25Pro;
	}
	public void setR25Pro(FaxStatus r25Pro) {
		this.r25Pro = r25Pro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AFTN_BACKUP_DM_PRO")
	public FaxStatus getBackupDmPro() {
		return backupDmPro;
	}
	public void setBackupDmPro(FaxStatus backupDmPro) {
		this.backupDmPro = backupDmPro;
	}
	
	@Column(name = "CHECK_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	
	@Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATER")
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	@Column(name = "UPDATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@ManyToOne
	@JoinColumn(name="UPDTER")
	public User getUpdter() {
		return updter;
	}
	public void setUpdter(User updter) {
		this.updter = updter;
	}
	
	
}
