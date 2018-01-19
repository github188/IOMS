/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午1:58:50
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.acl;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.acl.RoleType;

/**
 * 系统角色
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午1:58:50
 */
@Entity
@Table(name = "TB_OM_ACL_ROLE")
public class Role extends MyStringUUIDEntity implements Serializable {

	private static final long serialVersionUID = 1023822810280531307L;
	private String name;// 名称
	private String info;// 备注
	private RoleType system;// 系统保留 ，true-系统保留角色，false-用户自定义。默认为false

	public Role() {

	}

	public Role(String id) {
		this.id = id;
	}

	@Column
	@Enumerated(EnumType.ORDINAL)
	public RoleType getSystem() {
		return system;
	}

	public void setSystem(RoleType system) {
		this.system = system;
	}

	@Column
	public String getName() {
		return StringUtils.hasText(name) ? name.trim() : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		try {
			return this.toJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "";
	}
}
