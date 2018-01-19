package cn.com.atnc.ioms.entity.basedata.attenuator;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;

@Entity
@Table(name = "TB_BD_ATTENUATOR")
public class Attenuator extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String solidLanch;
	private String solidReceive;
	private Calendar recordTime;

	private transient String siteCode;
	private transient String siteId;

	private transient Bureau bureau;
	private SatelliteSite site;
	private String info;// 设备备注
	private transient EquipType equipType;// 设备类型
	private Client client;
	private Calendar clientOptTime;

	@Column(name = "CLIENT_OPT_TIME")
	public Calendar getClientOptTime() {
		if (clientOptTime == null) {
			return Calendar.getInstance();
		}
		return clientOptTime;
	}

	public void setClientOptTime(Calendar clientOptTime) {
		this.clientOptTime = clientOptTime;
	}

	@Transient
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@ManyToOne
	@JoinColumn(name = "SITE_ID")
	public SatelliteSite getSite() {
		return site;
	}

	public void setSite(SatelliteSite site) {
		this.site = site;
	}

	@Transient
	public String getSiteCode() {
		return siteCode;
	}

	@Transient
	public String getSiteId() {
		return siteId;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "SOLID_LAUNCH")
	public String getSolidLanch() {
		return solidLanch;
	}

	@Column(name = "SOLID_RECEIVE")
	public String getSolidReceive() {
		return solidReceive;
	}

	@Column(name = "REMARK")
	public String getInfo() {
		return info;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		if (recordTime == null) {
			return Calendar.getInstance();
		}
		return recordTime;
	}

	public void setSolidLanch(String solidLanch) {
		this.solidLanch = solidLanch;
	}

	public void setSolidReceive(String solidReceive) {
		this.solidReceive = solidReceive;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Transient
	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

}
