/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:09:32
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.acl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 角色资源关系表
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:09:32
 */
@Entity
@Table(name = "TB_OM_ACL_ROLE_RESOURCE")
public class RoleResource extends MyStringUUIDEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9165264896908856223L;
	private Role role; //角色
	private Resource resource;//资源项

	public RoleResource() {

	}

	public RoleResource(Role role, Resource resource) {
		this.role = role;
		this.resource = resource;
	}

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "RESOURCE_ID")
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
