package cn.com.atnc.ioms.entity.tempcircuit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * 
 * 类说明：临时电路TES AUDIO
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月23日下午6:10:58
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_CIRCUITTYPE_TES_AUDIO")
public class TempCircuitTesAudio extends StringUUIDEntity {
	private static final long serialVersionUID = -4863953347324886311L;
	private TempCircuit tempCircuit;
	private String name;
	private String boxNumber;
	private String slotNumber;
	private String teleNumber;
	private String freqPool;
	private String remark;

	@ManyToOne
	@JoinColumn(name = "TEMP_CIRCUIT_ID")
	public TempCircuit getTempCircuit() {
		return tempCircuit;
	}

	public void setTempCircuit(TempCircuit tempCircuit) {
		this.tempCircuit = tempCircuit;
	}

	@Column(name = "NODE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "BOX_NUMBER")
	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	@Column(name = "SLOT_NUMBER")
	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	@Column(name = "TELE_NUMBER")
	public String getTeleNumber() {
		return teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	@Column(name = "FREQ_POOL")
	public String getFreqPool() {
		return freqPool;
	}

	public void setFreqPool(String freqPool) {
		this.freqPool = freqPool;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
