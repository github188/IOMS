/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:18:49 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;

/**
 * 交换机运行环境信息实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:18:49 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_NODE_ENV_RUNINFO")
public class NodeEnvRunInfo extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 2075953266296227997L;
	private AtmNode node;
	private String nodeCode;
	private String nodeEnvAlarmType;
	private String nodeEnvUnit;
	private String nodeEnvThreshold;
	private String nodeEnvDataType;
	private String nodeEnvValue;
	private String nodeEnvState;
	private Boolean isAlarm;

	/**
	 * @return the node
	 */
	@ManyToOne
	@JoinColumn(name = "TB_NODE_ID")
	public AtmNode getNode() {
		return node;
	}

	public void setNode(AtmNode node) {
		this.node = node;
	}
	
	/**
	 * @return the nodeCode
	 */
	@Column(name = "NODE_CODE")
	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	/**
	 * @return the nodeEnvAlarmType
	 */
	@Column(name = "NODE_ENV_ALARM_TYPE")
	public String getNodeEnvAlarmType() {
		return nodeEnvAlarmType;
	}

	/**
	 * @param nodeEnvAlarmType
	 *            the nodeEnvAlarmType to set
	 */
	public void setNodeEnvAlarmType(String nodeEnvAlarmType) {
		this.nodeEnvAlarmType = nodeEnvAlarmType;
	}

	/**
	 * @return the nodeEnvUnit
	 */
	@Column(name = "NODE_ENV_UNIT")
	public String getNodeEnvUnit() {
		return nodeEnvUnit;
	}

	/**
	 * @param nodeEnvUnit
	 *            the nodeEnvUnit to set
	 */
	public void setNodeEnvUnit(String nodeEnvUnit) {
		this.nodeEnvUnit = nodeEnvUnit;
	}

	/**
	 * @return the nodeEnvThreshold
	 */
	@Column(name = "NODE_ENV_THRESHOLD")
	public String getNodeEnvThreshold() {
		return nodeEnvThreshold;
	}

	/**
	 * @param nodeEnvThreshold
	 *            the nodeEnvThreshold to set
	 */
	public void setNodeEnvThreshold(String nodeEnvThreshold) {
		this.nodeEnvThreshold = nodeEnvThreshold;
	}

	/**
	 * @return the nodeEnvDataType
	 */
	@Column(name = "NODE_ENV_DATA_TYPE")
	public String getNodeEnvDataType() {
		return nodeEnvDataType;
	}

	/**
	 * @param nodeEnvDataType
	 *            the nodeEnvDataType to set
	 */
	public void setNodeEnvDataType(String nodeEnvDataType) {
		this.nodeEnvDataType = nodeEnvDataType;
	}

	/**
	 * @return the nodeEnvValue
	 */
	@Column(name = "NODE_ENV_VALUE")
	public String getNodeEnvValue() {
		return nodeEnvValue;
	}

	/**
	 * @param nodeEnvValue
	 *            the nodeEnvValue to set
	 */
	public void setNodeEnvValue(String nodeEnvValue) {
		this.nodeEnvValue = nodeEnvValue;
	}

	/**
	 * @return the nodeEnvState
	 */
	@Column(name = "NODE_ENV_STATE")
	public String getNodeEnvState() {
		return nodeEnvState;
	}

	/**
	 * @param nodeEnvState
	 *            the nodeEnvState to set
	 */
	public void setNodeEnvState(String nodeEnvState) {
		this.nodeEnvState = nodeEnvState;
	}

	public Boolean getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	
	
}
