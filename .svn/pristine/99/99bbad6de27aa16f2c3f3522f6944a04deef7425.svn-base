/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:37:31
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午7:37:31
 * 
 *                 修改
 * @author:lizhisheng
 * @date:2014-4-8 下午1:02:34
 */
@Entity
@Table(name = "TB_BD_SATELLITE_SITE")
public class SatelliteSite extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1749042121772025856L;
	private Bureau bureau;// 所属区域
	private Proxy proxy;// 节点信息
	private String siteName;// 站点名字
	private String siteCode;// 站点代码
	private String info;// 备注
	private String type;// ku tes

	@Enumerated(EnumType.STRING)
	@Column
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@ManyToOne
	@JoinColumn(name="proxy_id")
	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "SITE_CODE")
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
