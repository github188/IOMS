/**
 * 
 */
package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.ATMRunInfoType;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.IsAlarm;

/**
 * ATM节点运行信息Entity
 * 
 * @author：KuYonggang
 * @date：2014-5-22上午9:55:15
 * @version：1.0
 */
@Entity
@Table(name="tb_bd_atm_node_runinfo")
public class AtmNodeRunInfo extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3304350622244891059L;
	
	private AtmNode atmNode;
	private String nodeCode;
	private ATMRunInfoType nodeAlarmType;
	private int nodeCriticalSum;
	private int nodeMajorSum;
	private int nodeMinorSum;
	private IsAlarm isAlarm = IsAlarm.Alarm;
	private Calendar recordTime;
	
	@ManyToOne
	@JoinColumn(name="TB_NODE_ID")
	public AtmNode getAtmNode() {
		return atmNode;
	}
	public void setAtmNode(AtmNode atmNode) {
		this.atmNode = atmNode;
	}
	@Column(name="NODE_CODE")
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="NODE_ALARM_TYPE")
	public ATMRunInfoType getNodeAlarmType() {
		return nodeAlarmType;
	}
	public void setNodeAlarmType(ATMRunInfoType nodeAlarmType) {
		this.nodeAlarmType = nodeAlarmType;
	}
	@Column(name="NODE_CRITICAL_SUM")
	public int getNodeCriticalSum() {
		return nodeCriticalSum;
	}
	public void setNodeCriticalSum(int nodeCriticalSum) {
		this.nodeCriticalSum = nodeCriticalSum;
	}
	@Column(name="NODE_MAJOR_SUM")
	public int getNodeMajorSum() {
		return nodeMajorSum;
	}
	public void setNodeMajorSum(int nodeMajorSum) {
		this.nodeMajorSum = nodeMajorSum;
	}
	@Column(name="NODE_MINOR_SUM")
	public int getNodeMinorSum() {
		return nodeMinorSum;
	}
	public void setNodeMinorSum(int nodeMinorSum) {
		this.nodeMinorSum = nodeMinorSum;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="ISALARM")
	public IsAlarm getIsAlarm() {
		return isAlarm;
	}
	public void setIsAlarm(IsAlarm isAlarm) {
		this.isAlarm = isAlarm;
	}
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
