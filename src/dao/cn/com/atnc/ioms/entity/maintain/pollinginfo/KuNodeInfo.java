/**
 * @ProjectName IOMS
 * @FileName LocalNodeSatelliteLinkParas.java
 * @PackageName:cn.com.atnc.ioms.entity.operstat.odu
 * @author KuYonggang
 * @date 2015年4月1日下午2:00:28
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
 * 节点LINK参数
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午2:00:28
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_POLLING_KU_NODEINFO")
public class KuNodeInfo extends MyStringUUIDEntity {
	
	private static final long serialVersionUID = 6286269217106954998L;
	
	private MaintainEquip equipId;// 告警关联设备id
	private String kuNodeNo;
    private String rxLevel;
    private String ebno;
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
	public String getRxLevel() {
		return rxLevel;
	}
	public void setRxLevel(String rxLevel) {
		this.rxLevel = rxLevel;
	}
	public String getEbno() {
		return ebno;
	}
	public void setEbno(String ebno) {
		this.ebno = ebno;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
