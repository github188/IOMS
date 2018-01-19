/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:18:22 PM
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
 * 交换机运行时长信息实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:18:22 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_NODE_RUNTIME")
public class NodeRunTime extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3634028343346656408L;
	private AtmNode node;
	private String nodeCode;
	private Integer nodeSystemUptime;

	/**
	 * @return the node
	 */
	@ManyToOne
	@JoinColumn(name = "TB_NODE_ID")
	public AtmNode getNode() {
		return node;
	}

	/**
	 * @param node
	 *            the node to set
	 */
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

	/**
	 * @param nodeCode
	 *            the nodeCode to set
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}


	/**
	 * @return the nodeSystemUptime
	 */
	@Column(name = "NODE_SYSTEM_UPTIME")
	public Integer getNodeSystemUptime() {
		return nodeSystemUptime;
	}

	public void setNodeSystemUptime(Integer nodeSystemUptime) {
		this.nodeSystemUptime = nodeSystemUptime;
	}
}
