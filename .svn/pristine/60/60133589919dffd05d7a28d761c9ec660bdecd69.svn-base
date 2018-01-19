/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-3-1 下午03:56:47
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * User信息抽象基类
 * 
 * @author:HuangYijie
 * @date:2011-3-1 下午03:56:47
 * @version:1.0
 */
@MappedSuperclass
public class BaseUserInfo extends StringUUIDEntity {

	private static final long serialVersionUID = 5465759334532049283L;

	private String name; // 姓名
	private String loginName;// 登陆名
	private String password;// 登陆密码，加密形式保存
	private String email;// 邮箱
	private String mobilephone;// 手机
	private String phone;//座机

	private transient String pswOrigin;

	@Transient
	public String getPswOrigin() {
		return pswOrigin;
	}

	public void setPswOrigin(String pswOrigin) {
		this.pswOrigin = pswOrigin;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MOBILEPHONE")
	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}