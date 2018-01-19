package cn.com.atnc.ioms.entity.tempcircuit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitKuType;

/**
 * 
 * 类说明：临时电路TES DB
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月23日下午6:10:58
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_CIRCUITTYPE_TES_DB")
public class TempCircuitTesDb extends StringUUIDEntity {
	private static final long serialVersionUID = -4863953347324886311L;
	private TempCircuit tempCircuit;
	private String businessName;
	private String circuitName;
	private String aNodeName;
	private String aBoxNumber;
	private String aSlotNumber;
	private String bNodeName;
	private String bBoxNumber;
	private String bSlotNumber;
	private CircuitKuType circuitType;
	private String rate;
	private String frequencePool;
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

	@Column(name = "CIRCUIT_NAME")
	public String getCircuitName() {
		return circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	@Column(name = "A_BOX_NUMBER")
	public String getaBoxNumber() {
		return aBoxNumber;
	}

	public void setaBoxNumber(String aBoxNumber) {
		this.aBoxNumber = aBoxNumber;
	}

	@Column(name = "A_SLOT_NUMBER")
	public String getaSlotNumber() {
		return aSlotNumber;
	}

	public void setaSlotNumber(String aSlotNumber) {
		this.aSlotNumber = aSlotNumber;
	}

	@Column(name = "B_BOX_NUMBER")
	public String getbBoxNumber() {
		return bBoxNumber;
	}

	public void setbBoxNumber(String bBoxNumber) {
		this.bBoxNumber = bBoxNumber;
	}

	@Column(name = "B_SLOT_NUMBER")
	public String getbSlotNumber() {
		return bSlotNumber;
	}

	public void setbSlotNumber(String bSlotNumber) {
		this.bSlotNumber = bSlotNumber;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_TYPE")
	public CircuitKuType getCircuitType() {
		return circuitType;
	}

	public void setCircuitType(CircuitKuType circuitType) {
		this.circuitType = circuitType;
	}

	@Column(name = "RATE")
	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Column(name = "A_NODE_NAME")
	public String getaNodeName() {
		return aNodeName;
	}

	public void setaNodeName(String aNodeName) {
		this.aNodeName = aNodeName;
	}

	@Column(name = "B_NODE_NAME")
	public String getbNodeName() {
		return bNodeName;
	}

	public void setbNodeName(String bNodeName) {
		this.bNodeName = bNodeName;
	}

	@Column(name = "FREQUENCE_POOL")
	public String getFrequencePool() {
		return frequencePool;
	}

	public void setFrequencePool(String frequencePool) {
		this.frequencePool = frequencePool;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
