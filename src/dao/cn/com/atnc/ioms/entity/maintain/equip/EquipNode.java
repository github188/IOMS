/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipNode.java
 * @PackageName:cn.com.atnc.ioms.entity.maintain.equip
 * @author ku
 * @date 2015年5月6日上午10:10:51
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.equip;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;

/**
 * 西北维保设备与节点对应关系实体类
 *
 * @author ku
 * @date 2015年5月6日 上午10:10:51
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_EQUIP_NODE")
public class EquipNode extends MyStringUUIDEntity {

	private static final long serialVersionUID = -3243080429869142769L;
	
	private MaintainEquip maintainEquip; //维保设备
	private Equip equip; //抽象设备（节点表）
	private Calendar createTime; //配置时间	
	
	@ManyToOne
	@JoinColumn(name="mnequip_id")
	public MaintainEquip getMaintainEquip() {
		return maintainEquip;
	}
	public void setMaintainEquip(MaintainEquip maintainEquip) {
		this.maintainEquip = maintainEquip;
	}
	
	@ManyToOne
	@JoinColumn(name="equip_id")
	public Equip getEquip() {
		return equip;
	}
	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}
