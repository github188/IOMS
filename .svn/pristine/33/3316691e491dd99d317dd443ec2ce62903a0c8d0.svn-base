

package cn.com.atnc.ioms.entity.basedata.atm.node;

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
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * @author:xinongzhikang
 * @date:2014-4-11 
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_ATM_NODE")
public class AtmNode extends MyStringUUIDEntity {

	private static final long serialVersionUID = 2752447325893110910L;

	private Bureau bureau;//区域
	private String atmNodeSeq;//区内序号
	private String atmNodeCode;//节点名称，如ZBBB-MGX8850-01
	private String atmNodeNameCn;//节点地点
	private String atmNodeIp;//ATM0地址
	private Integer atmNodeLevel;
	private String atmNodeTimeWork;
	private String atmNodeChassisType;
	private String atmNodeChassisSerial;
	private String atmNodeFanSum;
	private Boolean isMonitor = false;
	private Calendar atmNodeRecordTime;
	private Equip equip;
	private Boolean onlineStatus = false;
	private transient String equipId;

	public AtmNode() {
	}

	public AtmNode(String id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "NODE_BUREAU")
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	

	@Column(name = "NODE_SEQ")
	public String getAtmNodeSeq() {
		return atmNodeSeq;
	}

	public void setAtmNodeSeq(String atmNodeSeq) {
		this.atmNodeSeq = atmNodeSeq;
	}

	@Column(name = "NODE_CODE")
	public String getAtmNodeCode() {
		return atmNodeCode;
	}

	public void setAtmNodeCode(String atmNodeCode) {
		this.atmNodeCode = atmNodeCode;
	}

	@Column(name = "NODE_NAME_CN")
	public String getAtmNodeNameCn() {
		return atmNodeNameCn;
	}

	public void setAtmNodeNameCn(String atmNodeNameCn) {
		this.atmNodeNameCn = atmNodeNameCn;
	}
	
	@Column(name = "NODE_IP")
	public String getAtmNodeIp() {
		return atmNodeIp;
	}

	public void setAtmNodeIp(String atmNodeIp) {
		this.atmNodeIp = atmNodeIp;
	}
	
	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	
	@Transient
	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	
	@Column(name = "NODE_LEVEL")
	public Integer getAtmNodeLevel() {
		return atmNodeLevel;
	}

	public void setAtmNodeLevel(Integer atmNodeLevel) {
		this.atmNodeLevel = atmNodeLevel;
	}

	@Column(name = "NODE_TIME_WORK")
	public String getAtmNodeTimeWork() {
		return atmNodeTimeWork;
	}

	public void setAtmNodeTimeWork(String atmNodeTimeWork) {
		this.atmNodeTimeWork = atmNodeTimeWork;
	}

	@Column(name = "NODE_CHASSIS_TYPE")
	public String getAtmNodeChassisType() {
		return atmNodeChassisType;
	}

	public void setAtmNodeChassisType(String atmNodeChassisType) {
		this.atmNodeChassisType = atmNodeChassisType;
	}

	@Column(name = "NODE_CHASSIS_SERIAL")
	public String getAtmNodeChassisSerial() {
		return atmNodeChassisSerial;
	}

	public void setAtmNodeChassisSerial(String atmNodeChassisSerial) {
		this.atmNodeChassisSerial = atmNodeChassisSerial;
	}

	@Column(name = "NODE_FAN_SUM")
	public String getAtmNodeFanSum() {
		return atmNodeFanSum;
	}

	public void setAtmNodeFanSum(String atmNodeFanSum) {
		this.atmNodeFanSum = atmNodeFanSum;
	}

	
	@Column(name = "ISMONITOR")
	public Boolean getIsMonitor() {
		return isMonitor;
	}

	public void setIsMonitor(Boolean isMonitor) {
		this.isMonitor = isMonitor;
	}

	@Column(name = "RECORDTIME")
	public Calendar getAtmNodeRecordTime() {
		return atmNodeRecordTime;
	}

	public void setAtmNodeRecordTime(Calendar atmNodeRecordTime) {
		this.atmNodeRecordTime = atmNodeRecordTime;
	}

	@Column(name="ONLINE_STATUS")
	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
}
