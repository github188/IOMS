package cn.com.atnc.ioms.entity.tempcircuit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;

/**
 * @author wangpeng
 * @date 2014-8-29 上午10:48:23
 * @version 1.0
 */
@Entity
@Table(name = "TB_OM_TEMP_CIRCUIT_TESKU_BROAD")
public class TempCircuitTesKuBroad extends StringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7031967434904972565L;

	private TempCircuit tempCircuit;
	private CircuitType circuitType;// 枚举字段
	private String node;
	private String slot;
	private String port;

	// -- 附加属性 --//
	private transient String tempCircuitId;

	@ManyToOne
	@JoinColumn(name = "TB_OM_TEMP_CIRCUIT_ID")
	public TempCircuit getTempCircuit() {
		return tempCircuit;
	}

	public void setTempCircuit(TempCircuit tempCircuit) {
		this.tempCircuit = tempCircuit;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CIRCUIT_TYPE")
	public CircuitType getCircuitType() {
		return circuitType;
	}

	public void setCircuitType(CircuitType circuitType) {
		this.circuitType = circuitType;
	}

	@Column(name = "NODE")
	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	@Column(name = "SLOT")
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@Column(name = "PORT")
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Transient
	public String getTempCircuitId() {
		return tempCircuitId;
	}

	public void setTempCircuitId(String tempCircuitId) {
		this.tempCircuitId = tempCircuitId;
	}

}
