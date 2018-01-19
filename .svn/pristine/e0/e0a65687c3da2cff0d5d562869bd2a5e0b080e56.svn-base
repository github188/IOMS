/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:37:31
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.odu;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.clientmng.Client;

@Entity
@Table(name = "TB_BD_ODU")
public class Odu extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1749042121772025856L;
	private String oduType;
	private Float oduPower;
	private String lanchMidFreq;
	private Float lanchPlusMinus;
	private Float receivePlusMinus;
	private String receiveMidMinus;
	private String info;

	private Client client;
	private SatelliteSite site;

	private Calendar recordTime;
	private Calendar clientOptTime;
	
	private transient String siteCode;
	private transient String siteId;
	private transient String clientId;

	@ManyToOne
	@JoinColumn(name = "SITE_ID")
	public SatelliteSite getSite() {
		return site;
	}

	public void setSite(SatelliteSite site) {
		this.site = site;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		if (recordTime == null) {
			return Calendar.getInstance();
		}
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "OPT_TIME")
	public Calendar getClientOptTime() {
		if (clientOptTime == null) {
			return Calendar.getInstance();
		}
		return clientOptTime;
	}

	public void setClientOptTime(Calendar clientOptTime) {
		this.clientOptTime = clientOptTime;
	}

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Transient
	public String getClientId() {
		return clientId;
	}

	@Column(name = "ODU_TYPE")
	public String getOduType() {
		return oduType;
	}

	@Column(name = "ODU_POWER")
	public Float getOduPower() {
		return oduPower;
	}

	@Column(name = "LAUNCH_MID_FREQ")
	public String getLanchMidFreq() {
		return lanchMidFreq;
	}

	@Column(name = "LAUNCH_PLUS_MINUS")
	public Float getLanchPlusMinus() {
		return lanchPlusMinus;
	}

	@Column(name = "RECEIVE_PLUS_MINUS")
	public Float getReceivePlusMinus() {
		return receivePlusMinus;
	}

	@Column(name = "RECEIVE_MID_FREQ")
	public String getReceiveMidMinus() {
		return receiveMidMinus;
	}

	@Column(name = "REMARK")
	public String getInfo() {
		return info;
	}

	public void setOduType(String oduType) {
		this.oduType = oduType;
	}

	public void setOduPower(Float oduPower) {
		this.oduPower = oduPower;
	}

	public void setLanchMidFreq(String lanchMidFreq) {
		this.lanchMidFreq = lanchMidFreq;
	}

	public void setLanchPlusMinus(Float lanchPlusMinus) {
		this.lanchPlusMinus = lanchPlusMinus;
	}

	public void setReceivePlusMinus(Float receivePlusMinus) {
		this.receivePlusMinus = receivePlusMinus;
	}

	public void setReceiveMidMinus(String receiveMidMinus) {
		this.receiveMidMinus = receiveMidMinus;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Transient
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Transient
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}
