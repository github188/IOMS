/**
 * 
 */
package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.NodeLevel;

/**
 * @author：KuYonggang
 * @date：2014-5-22上午10:03:08
 * @version：1.0
 */
public class AtmNodeBak extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092682285523276844L;
	private Equip equip; //设备ID
	private Bureau nodeBureau; //节点所属区域
	private NodeLevel nodeLevel; //节点等级
	private String nodeSeq; //区内序号
	private String nodeCode; //代码，如ZBBB-MGX8850-01
	private String nodeNameCn; //中文名称，如首都机场西跑道
	private String nodeTimeWork; //投产时间
	private String nodeChassisType;//机箱类别，如8850C1
	private String nodeChassisSerial;//机箱序列号，如SCA07320074
	private String nodeFanSum;//风扇数量
	private String nodeIp; //节点IP地址
	private String userName;
	private String password;
	private boolean isMonitor;
	private Calendar recordTime;//记录时间
	
	@ManyToOne
	@JoinColumn(name="EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}
	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="NODE_BUREAU")
	public Bureau getNodeBureau() {
		return nodeBureau;
	}
	public void setNodeBureau(Bureau nodeBureau) {
		this.nodeBureau = nodeBureau;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="NODE_LEVEL")
	public NodeLevel getNodeLevel() {
		return nodeLevel;
	}
	public void setNodeLevel(NodeLevel nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
	@Column(name="NODE_SEQ")
	public String getNodeSeq() {
		return nodeSeq;
	}
	public void setNodeSeq(String nodeSeq) {
		this.nodeSeq = nodeSeq;
	}
	@Column(name="NODE_CODE")
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	@Column(name="NODE_NAME_CN")
	public String getNodeNameCn() {
		return nodeNameCn;
	}
	public void setNodeNameCn(String nodeNameCn) {
		this.nodeNameCn = nodeNameCn;
	}
	@Column(name="NODE_TIME_WORK")
	public String getNodeTimeWork() {
		return nodeTimeWork;
	}
	public void setNodeTimeWork(String nodeTimeWork) {
		this.nodeTimeWork = nodeTimeWork;
	}
	@Column(name="NODE_CHASSIS_TYPE")
	public String getNodeChassisType() {
		return nodeChassisType;
	}
	public void setNodeChassisType(String nodeChassisType) {
		this.nodeChassisType = nodeChassisType;
	}
	@Column(name="NODE_CHASSIS_SERIAL")
	public String getNodeChassisSerial() {
		return nodeChassisSerial;
	}
	public void setNodeChassisSerial(String nodeChassisSerial) {
		this.nodeChassisSerial = nodeChassisSerial;
	}
	@Column(name="NODE_FAN_SUM")
	public String getNodeFanSum() {
		return nodeFanSum;
	}
	public void setNodeFanSum(String nodeFanSum) {
		this.nodeFanSum = nodeFanSum;
	}
	@Column(name="NODE_IP")
	public String getNodeIp() {
		return nodeIp;
	}
	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}
	@Column(name="USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="ISMONITOR")
	public boolean isMonitor() {
		return isMonitor;
	}
	public void setMonitor(boolean isMonitor) {
		this.isMonitor = isMonitor;
	}
	@Column(name="RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
