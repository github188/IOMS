/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-3-1 下午03:56:47
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.duty.satellite.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;

/**
 * 卫星巡检抽象类
 *
 * @author 段衍林
 * @2017年2月13日 上午11:30:41
 */
@MappedSuperclass
public class BaseSatelliteInfo extends StringUUIDEntity {

	private static final long serialVersionUID = 5465759334532049283L;

	private SatelliteCheckContent checkContent; // 巡检内容
	private Date createDate; // 创建日期
	private Date createTime; // 创建时间
	private User creater;// 创建人
	private Date updateTime; // 更新时间
	private User updater;// 更新操作人
	private User auditer;// 审核人
	private Date auditTime;// 审核时间
	private String auditRemark;// 审核备注

	public BaseSatelliteInfo() {
		super();
	}

	public BaseSatelliteInfo(Date createDate, Date createTime, User creater) {
		super();
		this.createDate = createDate;
		this.createTime = createTime;
		this.creater = creater;
	}

	public BaseSatelliteInfo(User auditer, Date auditTime, String auditRemark) {
		super();
		this.auditer = auditer;
		this.auditTime = auditTime;
		this.auditRemark = auditRemark;
	}

	@ManyToOne
	@JoinColumn(name = "AUDITER")
	public User getAuditer() {
		return auditer;
	}

	public void setAuditer(User auditer) {
		this.auditer = auditer;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "AUDITTIME")
	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	@Column(name = "AUDIT_REMARK")
	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CHECK_CONENT")
	public SatelliteCheckContent getCheckContent() {
		return checkContent;
	}

	public void setCheckContent(SatelliteCheckContent checkContent) {
		this.checkContent = checkContent;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne
	@JoinColumn(name = "CREATER")
	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}
}