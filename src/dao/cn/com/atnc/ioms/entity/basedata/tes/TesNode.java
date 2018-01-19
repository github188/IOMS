/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:34:46
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.basedata.Bureau;


@Entity
@Table(name = "TB_BD_TES_NODE")
public class TesNode extends MyStringUUIDEntity {
	private static final long serialVersionUID = -4636035371499706701L;
	private Equip equip;// 设备
	private String equipId;// 设备ID
	private User optUser;// 操作用户
	private Calendar optTime;// 操作时间
	private String tesNodeCode;// 机箱号
	private String info;// 备注

	// 非持久化对象
	private transient Bureau bureau;
	private transient String siteCode;
	private transient String siteId;
	private transient SatelliteSite satelliteSite;
	private  transient List<TesSlot> tesSlotList;;
	
	@Transient
	public List<TesSlot> getTesSlotList() {
		return tesSlotList;
	}

	public void setTesSlotList(List<TesSlot> tesSlotList) {
		this.tesSlotList = tesSlotList;
	}

	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		if (optTime == null) {
			return Calendar.getInstance();
		}
		return optTime;
	}

	@Column(name = "NODE_CODE")
	public String getTesNodeCode() {
		return tesNodeCode;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	public void setTesNodeCode(String tesNodeCode) {
		this.tesNodeCode = tesNodeCode;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToOne
	@JoinColumn(name = "OPT_USER")
	public User getOptUser() {
		return optUser;
	}

	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}

	@Transient
	public String getEquipId() {
		return equipId;
	}

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	@Transient
	public Bureau getBureau() {
		return bureau;
	}

	@Transient
	public String getSiteCode() {
		return siteCode;
	}

	@Transient
	public String getSiteId() {
		return siteId;
	}

	@Transient
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}
}
