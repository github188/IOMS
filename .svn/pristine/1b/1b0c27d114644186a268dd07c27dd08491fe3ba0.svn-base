/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:09:32
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.act;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyBaseEntity;

/**
 * 角色资源关系表
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:09:32
 */
@Entity
@Table(name = "ACT_ID_MEMBERSHIP")
@IdClass(ActMemCompressId.class)
public class ActMembership extends MyBaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9165264896908856223L;
	private String user; //
	private String group;//

	@Id
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Id
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
