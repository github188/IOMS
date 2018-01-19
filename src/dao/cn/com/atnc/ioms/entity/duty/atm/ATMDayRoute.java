/**
 * @Title:AtmDay.java
 * @author shijiyong
 * @data 2016年9月21日上午10:33:03
 * @version v1.0
 */
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
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;

/**
 * ATM日检业务路由器
 * @author 王凌斌 
 * @2017年2月9日 下午1:31:47
 */
@Entity
@Table(name = "TB_OM_DUTY_ATM_DAY_ROUTE")
public class ATMDayRoute extends MyStringUUIDEntity {

	private static final long serialVersionUID = -7017960876370690346L;
	// 远程访问
	private StatusResultEnum telnet;
	// cpu利用率
	private String cpu;
	// 备注
	private String remark;
	// 区域：北京网控中心/民航局空管局
	private AtmDayTabEnum area;
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
	@Column(name = "TELNET")
	public StatusResultEnum getTelnet() {
		return telnet;
	}

	public void setTelnet(StatusResultEnum telnet) {
		this.telnet = telnet;
	}

	@Column(name = "CPU")
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
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
	public AtmDayTabEnum getArea() {
		return area;
	}

	public void setArea(AtmDayTabEnum area) {
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