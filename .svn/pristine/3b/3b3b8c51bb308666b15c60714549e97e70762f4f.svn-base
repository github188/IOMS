/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName FtpLink.java
 * @PackageName:cn.com.atnc.ioms.entity.maintain.alarminfo
 * @author ku
 * @date 2015年6月17日下午5:18:26
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.alarminfo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;

/**
 * ftp心跳检查
 *
 * @author ku
 * @date 2015年6月17日 下午5:18:26
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_BD_ALARM_FTPLINK")
public class FtpLink extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private Proxy proxyId;// 代理站id
	private Date recordTime;// 文件发送时间
	private AlarmStatusEnum status;// 告警状态

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	public AlarmStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AlarmStatusEnum status) {
		this.status = status;
	}

	@OneToOne
	@JoinColumn(name = "proxy_id")
	public Proxy getProxyId() {
		return proxyId;
	}

	public void setProxyId(Proxy proxyId) {
		this.proxyId = proxyId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
