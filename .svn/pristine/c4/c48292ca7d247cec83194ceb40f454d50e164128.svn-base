package cn.com.atnc.ioms.entity.tempcircuit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitOptType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitStatus;

/**
 * 
 * 类说明：临时电路开通过程中各个环节的日志记录
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午10:17:29
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_TEMPCIRCUIT_OPTLOG")
public class TempCircuitOptLog extends StringUUIDEntity {
	private static final long serialVersionUID = -7856453135004835538L;
	/**
	 * 临时电路申请表
	 */
	private TempCircuit tmepCircuit;
	/**
	 * 此步临时电路开通过程的操作类型
	 */
	private CircuitOptType circuitOptType;
	/**
	 * 此步临时电路开通过程的起始状态
	 */
	private CircuitStatus fromStatus;
	/**
	 * 此步临时电路开通过程的结束状态
	 */
	private CircuitStatus toStatus;
	/**
	 * 此步临时电路开通过程的操作用户
	 */
	private String optUser;
	/**
	 * 此步临时电路开通过程的发生时间
	 */
	private Calendar optTime;
	/**
	 * 此步临时电路开通过程的备注信息
	 */
	private String circuitInfo;

	@ManyToOne
	@JoinColumn(name = "TEMP_CIRCUIT_ID")
	public TempCircuit getTempCircuit() {
		return tmepCircuit;
	}

	public void setTempCircuit(TempCircuit tempCircuit) {
		this.tmepCircuit = tempCircuit;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "OPT_TYPE")
	public CircuitOptType getcircuitOptType() {
		return circuitOptType;
	}

	public void setcircuitOptType(CircuitOptType circuitOptType) {
		this.circuitOptType = circuitOptType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FROM_STATUS")
	public CircuitStatus getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(CircuitStatus fromStatus) {
		this.fromStatus = fromStatus;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TO_STATUS")
	public CircuitStatus getToStatus() {
		return toStatus;
	}

	public void setToStatus(CircuitStatus toStatus) {
		this.toStatus = toStatus;
	}

	@Column(name = "OPT_USER")
	public String getOptUser() {
		return optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	@Column(name = "DESC_INFO")
	public String getCircuitInfo() {
		return circuitInfo;
	}

	public void setCircuitInfo(String circuitInfo) {
		this.circuitInfo = circuitInfo;
	}
}
