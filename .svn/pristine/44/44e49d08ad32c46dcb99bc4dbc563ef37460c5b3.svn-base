/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:04:13
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.act;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyBaseEntity;

/**
 * 系统用户
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:04:13
 */
@Entity
@Table(name = "ACT_ID_USER")
public class ActUser extends MyBaseEntity implements Serializable {
	/**
	 * 
	 */
	public ActUser() {

	}

	public ActUser(String id) {
		this.id = id;
	}

	private static final long serialVersionUID = -4389399512060857480L;

	private String id;

	private String firstName; // 登录名

	private String lastName; // 姓名

	@Id
	@Column(name = "ID_",columnDefinition="nvarchar2(64)")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "FIRST_",columnDefinition="nvarchar2(255)")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_",columnDefinition="nvarchar2(255)")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
