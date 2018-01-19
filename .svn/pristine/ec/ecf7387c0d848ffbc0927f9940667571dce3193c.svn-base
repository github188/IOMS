package cn.com.atnc.ioms.entity.operstat.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;

/**
 * 中继带宽信息实体类
 * @author：KuYonggang
 * @date：2014-6-20下午1:23:04
 * @version：1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PNNI_BANDWIDTH")
public class PnniBandwidth extends MyStringUUIDEntity {

	/*
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -1875006389295662596L;
	private AtmNode node;
	private String pnniLocalNodeName;
	private String pnniLocalPortid;
	private String pnniRemoteNodeName;
	private float pnniMax;
	private long pnniAvlCps;
	private long pnniAvlKbps;

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
	 * @return the pnniLocalPortid
	 */
	@Column(name = "PNNI_LOCAL_PORTID")
	public String getPnniLocalPortid() {
		return pnniLocalPortid;
	}

	/**
	 * @param pnniLocalPortid
	 *            the pnniLocalPortid to set
	 */
	public void setPnniLocalPortid(String pnniLocalPortid) {
		this.pnniLocalPortid = pnniLocalPortid;
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
	 * @return the pnniMax
	 */
	@Column(name = "PNNI_MAX")
	public float getPnniMax() {
		return pnniMax;
	}

	/**
	 * @param pnniMax
	 *            the pnniMax to set
	 */
	public void setPnniMax(float pnniMax) {
		this.pnniMax = pnniMax;
	}

	/**
	 * @return the pnniAvlCps
	 */
	@Column(name = "PNNI_AVL_CPS")
	public long getPnniAvlCps() {
		return pnniAvlCps;
	}

	/**
	 * @param pnniAvlCps
	 *            the pnniAvlCps to set
	 */
	public void setPnniAvlCps(long pnniAvlCps) {
		this.pnniAvlCps = pnniAvlCps;
	}

	/**
	 * @return the pnniAvlKbps
	 */
	@Column(name = "PNNI_AVL_KBPS")
	public long getPnniAvlKbps() {
		return pnniAvlKbps;
	}

	/**
	 * @param pnniAvlKbps
	 *            the pnniAvlKbps to set
	 */
	public void setPnniAvlKbps(long pnniAvlKbps) {
		this.pnniAvlKbps = pnniAvlKbps;
	}
}
