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
 * 军航转报系统检查（自动）
 *
 * @author 韩天驭
 * @2017年2月3日 下午4:06:22
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_MILITARY")
public class FaxMilitaryDay extends MyStringUUIDEntity {
	private static final long serialversionUID = 1L;
	// 库操作进程是否正常（主用军航转报机）
	private FaxStatus hostMon;
	// 双机进程是否正常（主用军航转报机）
	private FaxStatus hostAfs;
	// 库操作进程是否正常（主用军航转报机）
	private FaxStatus backupMon;
	// 双机进程是否正常（主用军航转报机）
	private FaxStatus backupAfs;

	// 军航同步信道
	private FaxStatus synChannel;

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
	@Column(name = "HOST_MA_DMHS_MON")
	public FaxStatus getHostMon() {
		return hostMon;
	}
	public void setHostMon(FaxStatus hostMon) {
		this.hostMon = hostMon;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_MA_DMHS_AFS")
	public FaxStatus getHostAfs() {
		return hostAfs;
	}
	public void setHostAfs(FaxStatus hostAfs) {
		this.hostAfs = hostAfs;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_MA_DMHS_MON")
	public FaxStatus getBackupMon() {
		return backupMon;
	}
	public void setBackupMon(FaxStatus backupMon) {
		this.backupMon = backupMon;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_MA_DMHS_AFS")
	public FaxStatus getBackupAfs() {
		return backupAfs;
	}
	public void setBackupAfs(FaxStatus backupAfs) {
		this.backupAfs = backupAfs;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "MA_SYN_CHANNEL")
	public FaxStatus getSynChannel() {
		return synChannel;
	}
	public void setSynChannel(FaxStatus synChannel) {
		this.synChannel = synChannel;
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
