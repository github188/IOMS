/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:34:46
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.ku;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午7:34:46
 * @version:1.0
 * 
 * 修改人：段衍林
 * 修改时间：2016-11-24 14：48
 * 修改内容：添加子网
 */
@Entity
@Table(name = "TB_BD_KU_NODE")
public class KuNode extends MyStringUUIDEntity {

	private static final long serialVersionUID = -4636035371499706701L;
	private Equip equip;
	
	private SubnetType subnetType;	// 子网类型----dyl add
	
	private String kuNodeNo;// 编号
	private String kuNodeName;// ×××××没用
	private String kuNodeCode;// id
	private Boolean caac = false;// 是否空管局资产
	private EquipType type;// 机箱类型
	private String cardCount;// 板卡总数
	private String cardConfig;// 板卡配置
	private Boolean instrument;// 频谱仪
	private String status;// 上星状态
	private String statusInfo;// 未上线原因
	private String info;// 备注

	private User optUser;// 操作用户
	private Calendar optTime;// 操作时间

	// 非持久化对象
	private transient Bureau bureau;
	private transient String siteCode;
	private transient String siteId;
	private transient String equipId;
	private transient SatelliteSite satelliteSite;

	@Transient
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}

	@Transient
	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	@Transient
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
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

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}

	@Column(name = "NODE_NO")
	public String getKuNodeNo() {
		return kuNodeNo;
	}

	public void setKuNodeNo(String kuNodeNo) {
		this.kuNodeNo = kuNodeNo;
	}

	@Column(name = "NODE_NAME")
	public String getKuNodeName() {
		return kuNodeName;
	}

	public void setKuNodeName(String kuNodeName) {
		this.kuNodeName = kuNodeName;
	}

	@Column(name = "NODE_CODE")
	public String getKuNodeCode() {
		return kuNodeCode;
	}

	public void setKuNodeCode(String kuNodeCode) {
		this.kuNodeCode = kuNodeCode;
	}

	public Boolean getCaac() {
		return caac;
	}

	public void setCaac(Boolean caac) {
		this.caac = caac;
	}

	@Enumerated(EnumType.STRING)
	@Column
	public EquipType getType() {
		return type;
	}

	public void setType(EquipType type) {
		this.type = type;
	}

	@Column(name = "CARD_COUNT")
	public String getCardCount() {
		return cardCount;
	}

	public void setCardCount(String cardCount) {
		this.cardCount = cardCount;
	}

	@Column(name = "CARD_CONFIG")
	public String getCardConfig() {
		return cardConfig;
	}

	public void setCardConfig(String cardConfig) {
		this.cardConfig = cardConfig;
	}

	public Boolean getInstrument() {
		return instrument;
	}

	public void setInstrument(Boolean instrument) {
		this.instrument = instrument;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS_INFO")
	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public String getInfo() {
		return info;
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

	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		if (optTime == null) {
			return Calendar.getInstance();
		}
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SUBNET_TYPE")
	public SubnetType getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(SubnetType subnetType) {
		this.subnetType = subnetType;
	}
}
