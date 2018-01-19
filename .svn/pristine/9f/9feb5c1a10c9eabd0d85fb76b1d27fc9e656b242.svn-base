package cn.com.atnc.ioms.entity.basedata.resource;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 *  节点信息实体类
 *
 * @author KuYonggang
 * @date 2015年3月27日 下午3:05:43
 * @since 1.0.0
 */
@Entity
@Table(name = "tb_bd_proxy")
public class Proxy extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6390608090264156181L;
	
	
	private String proxyName; //节点名称
	
	private String proxyIp;// 节点ip地址

	private String satelliteId;// 站点ID 
	
	public Proxy() {
		super();
	}

	public Proxy(String id) {
		super();
		this.id = id;
	}

	@Column(name="PROXY_NAME")
	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}
	@Column(name="PROXY_IP")
	public String getProxyIp() {
		return proxyIp;
	}

	public void setProxyIp(String proxyIp) {
		this.proxyIp = proxyIp;
	}
	@Column(name="SATELLITESITE_ID")
	public String getSatelliteId() {
		return satelliteId;
	}

	public void setSatelliteId(String satelliteId) {
		this.satelliteId = satelliteId;
	}
}