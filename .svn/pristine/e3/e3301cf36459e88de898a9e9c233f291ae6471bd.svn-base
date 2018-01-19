package cn.com.atnc.ioms.entity.clientmng;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;

/**
 *类说明:客户监控设备表
 *@author 潘涛
 *@date 2014-3-19	下午2:42:44
 *@version:1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="TB_CS_CLIENT_EQUIP")
public class ClientEquip extends StringUUIDEntity {
	private Client client;//客户
	private Equip equip;//设备
	private Calendar recordTime;//配置时间
	
	
	@ManyToOne
	@JoinColumn(name="EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}
	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Column(name="RECORD_TIME")
	public Calendar getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
