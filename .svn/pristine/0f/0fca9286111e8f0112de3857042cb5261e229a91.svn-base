/**
 * @ProjectName IOMS
 * @FileName CarrierFreqData.java
 * @PackageName:cn.com.atnc.ioms.entity.operstat.ku
 * @author KuYonggang
 * @date 2015年4月1日下午1:01:06
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.pollinginfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;

/**
 * KU载波频率
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:01:06
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_POLLING_KU_CARRIERFREQ")
public class KuCarrierFreq extends MyStringUUIDEntity{
	
	private static final long serialVersionUID = 1L;
	
	private MaintainEquip equipId;// 告警关联设备id
	private String kuNodeNo; //节点号
	private String cxr ;
	private String freq;
	private Date recordTime;
	
	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public String getKuNodeNo() {
		return kuNodeNo;
	}
	public void setKuNodeNo(String kuNodeNo) {
		this.kuNodeNo = kuNodeNo;
	}
	public String getCxr() {
		return cxr;
	}
	public void setCxr(String cxr) {
		this.cxr = cxr;
	}
	public String getFreq() {
		return freq;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
