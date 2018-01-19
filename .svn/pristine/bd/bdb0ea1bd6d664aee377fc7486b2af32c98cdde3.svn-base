/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午1:52:59
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.entity.acl;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import cn.com.atnc.ioms.entity.MyBaseEntity;
import cn.com.atnc.ioms.enums.acl.ResourceType;

/**
 * 资源项表，用于存储系统内需要进行访问控制的对象
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午1:52:59
 */
@Entity
@Table(name = "TB_OM_ACL_RESOURCE")
public class Resource extends MyBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -658368251184517786L;
	protected String id;

	private String name;// 资源名称
	private String url;// ex:/info/index.do
	private ResourceType type;// 菜单类型，需要访问控制的对象
	private Integer list = 1;// 菜单排序
	private String pid;// 对应上级菜单的ID

	// 非持久化信息
	private transient boolean hasResource;// 当前角色是否有这个菜单
	private transient boolean hasChild;// 当前栏目菜单是否有子菜单

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JsonIgnore
	@Transient
	public boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}


	@JsonIgnore
	@Transient
	public boolean getHasResource() {
		return hasResource;
	}

	public void setHasResource(boolean hasResource) {
		this.hasResource = hasResource;
	}

	public Resource() {

	}

	public Resource(String id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	@Column
	public Integer getList() {
		return list;
	}

	public void setList(Integer list) {
		this.list = list;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String toString() {
		try {
			return super.toJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return this.toString();
		}
	}

}