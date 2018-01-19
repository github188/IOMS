/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-15 上午11:34:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.act;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author:HuangYijie
 * @date:2014-5-15 上午11:34:05
 * @version:1.0
 */
@Embeddable
public class ActMemCompressId implements Serializable {
	private String user; //
	private String group;//

	@Column(name = "USER_ID_",columnDefinition="nvarchar2(64)")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "GROUP_ID_",columnDefinition="nvarchar2(64)")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
