/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:09:32
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.acl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 用户角色关系表
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:14:01
 */
@Entity
@Table(name = "TB_OM_ACL_USER_ROLE")
public class UserRole extends MyStringUUIDEntity {

	private static final long serialVersionUID = 6061100061111018081L;
	private User user; //用户
	private Role role; //角色
	//角色授权用
	private RoleSourceEnum roleSource = RoleSourceEnum.ORDINAL;		//角色来源
	private User transfer;					//授权人
	private Date recordTime = DateUtilTools.getNowDateTime();				//记录时间
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE_SOURCE")
	public RoleSourceEnum getRoleSource() {
		return roleSource;
	}

	public void setRoleSource(RoleSourceEnum roleSource) {
		this.roleSource = roleSource;
	}

	@ManyToOne
	@JoinColumn(name = "TRANSFER")
	public User getTransfer() {
		return transfer;
	}

	public void setTransfer(User transfer) {
		this.transfer = transfer;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	
}
