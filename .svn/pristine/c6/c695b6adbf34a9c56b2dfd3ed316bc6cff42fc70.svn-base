/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipCircuit.java
 * @PackageName:cn.com.atnc.ioms.entity.maintain.circuit
 * @author ku
 * @date 2015年4月30日下午1:48:00
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.circuit;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;

/**
 * 设备电路实体类
 *
 * @author ku
 * @date 2015年4月30日 下午1:48:00
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_EQUIP_CIRCUIT")
public class EquipCircuit extends StringUUIDEntity {

	private static final long serialVersionUID = 7693185652061077088L;
	
	private MaintainEquip equip; //设备信息
	private KuService kuService; //电路信息
	
	@ManyToOne
	@JoinColumn(name="equip_id")
	public MaintainEquip getEquip() {
		return equip;
	}
	public void setEquip(MaintainEquip equip) {
		this.equip = equip;
	}
	@ManyToOne
	@JoinColumn(name="service_id")
	public KuService getKuService() {
		return kuService;
	}
	public void setKuService(KuService kuService) {
		this.kuService = kuService;
	}
	
}
