/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:43:02 PM
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
 * Pnni：线路“连通性”信息实体类
 * @author：KuYonggang
 * @date：2014-6-23下午1:24:48
 * @version：1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PNNI_LINK")
public class PnniLink extends MyStringUUIDEntity {
	/*****
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -560061199932611442L;
	private AtmNode node;
	private String localPnniPortId;
	private String remotePnniPortId;
	private String pnniLocalNodeName;
	private String pnniRemoteNodeName;
	private String pnniHelloState;

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
	 * @return the pnniLocalNodeName
	 */
	@Column(name = "PNNI_LOCAL_NODE_NAME")
	public String getPnniLocalNodeName() {
		return pnniLocalNodeName;
	}

	/**
	 * @param pnniLocalNodeName
	 *            the pnniLocalNodeName to set
	 */
	public void setPnniLocalNodeName(String pnniLocalNodeName) {
		this.pnniLocalNodeName = pnniLocalNodeName;
	}

	/**
	 * @return the pnniRemoteNodeName
	 */
	@Column(name = "PNNI_REMOTE_NODE_NAME")
	public String getPnniRemoteNodeName() {
		return pnniRemoteNodeName;
	}

	/**
	 * @param pnniRemoteNodeName
	 *            the pnniRemoteNodeName to set
	 */
	public void setPnniRemoteNodeName(String pnniRemoteNodeName) {
		this.pnniRemoteNodeName = pnniRemoteNodeName;
	}

	/**
	 * @return the pnniHelloState
	 */
	@Column(name = "PNNI_HELLO_STATE")
	public String getPnniHelloState() {
		return pnniHelloState;
	}

	/**
	 * @param pnniHelloState
	 *            the pnniHelloState to set
	 */
	public void setPnniHelloState(String pnniHelloState) {
		this.pnniHelloState = pnniHelloState;
	}

	@Column(name = "PNNI_LOCAL_PORT_ID")
	public String getLocalPnniPortId() {
		return localPnniPortId;
	}

	/**
	 * @param localPnniPortId
	 *            the localPnniPortId to set
	 */
	public void setLocalPnniPortId(String localPnniPortId) {
		this.localPnniPortId = localPnniPortId;
	}

	@Column(name = "PNNI_REMOTE_PORT_ID")
	public String getRemotePnniPortId() {
		return remotePnniPortId;
	}

	/**
	 * @param remotePnniPortId
	 *            the remotePnniPortId to set
	 */
	public void setRemotePnniPortId(String remotePnniPortId) {
		this.remotePnniPortId = remotePnniPortId;
	}
}
