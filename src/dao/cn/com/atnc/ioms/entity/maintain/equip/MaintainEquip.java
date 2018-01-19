/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName MaintainEquip.java
 * @PackageName:cn.com.atnc.ioms.entity.maintain.equip
 * @author ku
 * @date 2015年4月30日上午10:50:08
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.equip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.basedata.NetworkType;

/**
 * 运维相关设备实体
 *
 * @author ku
 * @date 2015年4月30日 上午10:50:08
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_EQUIP_MAINTAIN")
public class MaintainEquip extends MyStringUUIDEntity{

	private static final long serialVersionUID = -2453785010653751350L;
	
	private String name;  //设备名称
	private MaintainEquip pid; 
	private NetworkType type; //设备类型
	private String model; 
	private Equip equip; //所关联的抽象设备
	private String sn;
	private Boolean onlineStat; //在线状态
	private SatelliteSite satelliteSite; //设备对应的卫星站信息
	
	
	public MaintainEquip() {
		super();
	}
	
	public MaintainEquip(String id) {
		super();
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name = "PID")
	public MaintainEquip getPid() {
		return pid;
	}
	public void setPid(MaintainEquip pid) {
		this.pid = pid;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE")
	public NetworkType getType() {
		return type;
	}
	public void setType(NetworkType type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@ManyToOne
	@JoinColumn(name="EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}
	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public Boolean getOnlineStat() {
		return onlineStat;
	}

	public void setOnlineStat(Boolean onlineStat) {
		this.onlineStat = onlineStat;
	}

	@ManyToOne
	@JoinColumn(name="satellitesite_id")
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}
	
}
