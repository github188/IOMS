package cn.com.atnc.ioms.entity.tempcircuit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * 
 * 类说明：临时电路明细ATM-FR-ATM
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月23日下午5:54:23
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_CIRCUITTYPE_ATM_FR_ATM")
public class TempCircuitAtmFrAtm extends StringUUIDEntity {
	private static final long serialVersionUID = -4863953347324886311L;
	private TempCircuit tempCircuit;
	private String businessName;
	private String businessRate;
	private String localNodeName;
	private String localNodeSlot;
	private String localNodePort;
	private String localNodePortRate;
	private String localDlciVpiVci;
	private String oppositeNodeName;
	private String oppositeNodeSlot;
	private String oppositeNodePort;
	private String oppositeNodePortRate;
	private String oppositeDlciVpiVci;
	private String qosType;
	private String remark;

	@ManyToOne
	@JoinColumn(name = "TEMP_CIRCUIT_ID")
	public TempCircuit getTempCircuit() {
		return tempCircuit;
	}

	public void setTempCircuit(TempCircuit tempCircuit) {
		this.tempCircuit = tempCircuit;
	}

	@Column(name = "BUSINESS_NAME")
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "BUSINESS_RATE")
	public String getBusinessRate() {
		return businessRate;
	}

	public void setBusinessRate(String businessRate) {
		this.businessRate = businessRate;
	}

	@Column(name = "LOCAL_NODE_NAME")
	public String getLocalNodeName() {
		return localNodeName;
	}

	public void setLocalNodeName(String localNodeName) {
		this.localNodeName = localNodeName;
	}

	@Column(name = "LOCAL_NODE_SLOT")
	public String getLocalNodeSlot() {
		return localNodeSlot;
	}

	public void setLocalNodeSlot(String localNodeSlot) {
		this.localNodeSlot = localNodeSlot;
	}

	@Column(name = "LOCAL_NODE_PORT")
	public String getLocalNodePort() {
		return localNodePort;
	}

	public void setLocalNodePort(String localNodePort) {
		this.localNodePort = localNodePort;
	}

	@Column(name = "LOCAL_NODE_PORT_RATE")
	public String getLocalNodePortRate() {
		return localNodePortRate;
	}

	public void setLocalNodePortRate(String localNodePortRate) {
		this.localNodePortRate = localNodePortRate;
	}

	@Column(name = "OPPOSITE_NODE_NAME")
	public String getOppositeNodeName() {
		return oppositeNodeName;
	}

	public void setOppositeNodeName(String oppositeNodeName) {
		this.oppositeNodeName = oppositeNodeName;
	}

	@Column(name = "OPPOSITE_NODE_SLOT")
	public String getOppositeNodeSlot() {
		return oppositeNodeSlot;
	}

	public void setOppositeNodeSlot(String oppositeNodeSlot) {
		this.oppositeNodeSlot = oppositeNodeSlot;
	}

	@Column(name = "OPPOSITE_NODE_PORT")
	public String getOppositeNodePort() {
		return oppositeNodePort;
	}

	public void setOppositeNodePort(String oppositeNodePort) {
		this.oppositeNodePort = oppositeNodePort;
	}

	@Column(name = "OPPOSITE_NODE_PORT_RATE")
	public String getOppositeNodePortRate() {
		return oppositeNodePortRate;
	}

	public void setOppositeNodePortRate(String oppositeNodePortRate) {
		this.oppositeNodePortRate = oppositeNodePortRate;
	}

	@Column(name = "QOS_TYPE")
	public String getQosType() {
		return qosType;
	}

	public void setQosType(String qosType) {
		this.qosType = qosType;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "LOCAL_DLCI_VPIVCI")
	public String getLocalDlciVpiVci() {
		return localDlciVpiVci;
	}

	public void setLocalDlciVpiVci(String localDlciVpiVci) {
		this.localDlciVpiVci = localDlciVpiVci;
	}

	@Column(name = "OPPOSITEL_DLCI_VPIVCI")
	public String getOppositeDlciVpiVci() {
		return oppositeDlciVpiVci;
	}

	public void setOppositeDlciVpiVci(String oppositeDlciVpiVci) {
		this.oppositeDlciVpiVci = oppositeDlciVpiVci;
	}

}
