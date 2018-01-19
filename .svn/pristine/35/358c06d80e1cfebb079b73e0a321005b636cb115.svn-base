package cn.com.atnc.ioms.entity.clientmng;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.atnc.common.entity.BaseEntity;

/**
 *类说明:客服平台角色
 *@author 潘涛
 *@date 2014-3-18	下午3:16:52
 *@version:1.0
 */
@Entity
@Table(name="TB_CS_ACL_ROLE")
public class CsRole extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String info;
	@Id
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="INFO")
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
