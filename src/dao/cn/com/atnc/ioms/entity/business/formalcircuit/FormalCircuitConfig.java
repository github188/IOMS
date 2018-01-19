/**
 * @ProjectName IOMS
 * @FileName FormalCircuitATMConfig.java
 * @PackageName:cn.com.atnc.ioms.entity.business.formalcircuit
 * @author WangLingbin
 * @date 2015年7月30日上午10:35:38
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.business.formalcircuit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 正式电路ATM配置表
 * 
 * @author WangLingbin
 * @date 2015年7月30日 上午10:35:38
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_FORMALCIRCUIT_CONF")
public class FormalCircuitConfig extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String purpose; 	// 配置目的
	private String atncLeader;		//领导
	private String operateUser; // 操作人员
	private String auditUser; // 验收人员
	private Calendar configTime; // 配置时间
	private String remark;		//备注信息

	public FormalCircuitConfig() {
		super();
	}

	public FormalCircuitConfig(String atncLeader) {
		super();
		this.atncLeader = atncLeader;
	}

	public FormalCircuitConfig(String purpose, String atncLeader,
			String operateUser, String auditUser, Calendar configTime) {
		super();
		this.purpose = purpose;
		this.atncLeader = atncLeader;
		this.operateUser = operateUser;
		this.auditUser = auditUser;
		this.configTime = configTime;
	}

	@Column(name = "config_purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@Column(name = "atnc_leader")
	public String getAtncLeader() {
		return atncLeader;
	}

	public void setAtncLeader(String atncLeader) {
		this.atncLeader = atncLeader;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "config_time")
	public Calendar getConfigTime() {
		return configTime;
	}

	public void setConfigTime(Calendar configTime) {
		this.configTime = configTime;
	}

	@Column(name = "operate_user")
	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	@Column(name = "audit_user")
	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
