/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:35:50
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.NetworkType;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午7:35:50
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_EQUIP")
public class Equip extends MyStringUUIDEntity {

	private static final long serialVersionUID = 2752447325893000910L;

	private String name;
	private String code;
	private NetworkType type;
	private String model;
	private Bureau bureau;
	private String info;
	private SatelliteSite satellite;
	
	private transient List<KuMobile> kuMobiles;

	@Transient
	public List<KuMobile> getKuMobiles() {
		return kuMobiles;
	}

	public void setKuMobiles(List<KuMobile> kuMobiles) {
		this.kuMobiles = kuMobiles;
	}

	public Equip() {
		super();
	}
	
	public Equip(String id) {
		super();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Enumerated(EnumType.STRING)
	@Column
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

	@Enumerated(EnumType.STRING)
	@Column
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToOne
	@JoinColumn(name = "SATELLITE_ID")
	public SatelliteSite getSatellite() {
		return satellite;
	}

	public void setSatellite(SatelliteSite satellite) {
		this.satellite = satellite;
	}

}
