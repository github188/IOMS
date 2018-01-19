package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 通信基地-TES-TES OCC状态实体
 *
 * @author 段衍林
 * @2016年11月10日 下午1:18:30
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TESODU")
public class SatTxjdTesODU extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private SatelliteStatus txaState; // TXA_STATE
	private SatelliteStatus rxaState; // RXA_STATE
	private SatelliteStatus txbState; // TXB_STATE
	private SatelliteStatus rxbState; // RXB_STATE
	private SatelliteStatus txfreqAstate; // TXFREQ_A_STATE
	private SatelliteStatus rxfreqAstate; // RXFREQ_A_STATE
	private SatelliteStatus usAstate; // UC_A_STATE
	private SatelliteStatus dcAstate; // DC_A_STATE
	private SatelliteStatus txfreqBstate; // TXFREQ_B_STATE
	private SatelliteStatus rxfreqBstate; // RXFREQ_B_STATE
	private SatelliteStatus usBstate; // UC_B_STATE
	private SatelliteStatus dcBstate; // DC_B_STATE

	private SatelliteStatus txaResult; // TXA_RESULT
	private SatelliteStatus rxaResult; // RXA_RESULT
	private SatelliteStatus txbResult; // TXB_RESULT
	private SatelliteStatus rxbResult; // RXB_RESULT
	private String txfreqAresult; // TXFREQ_B_RESULT
	private String rxfreqAresult; // RXFREQ_B_RESULT
	private String usAresult; // UC_A_RESULT
	private String dcAresult; // DC_A_RESULT
	private String txfreqBresult; // TXFREQ_B_RESULT
	private String rxfreqBresult; // RXFREQ_B_RESULT
	private String usBresult; // UC_B_RESULT
	private String dcBresult; // DC_B_RESULT

	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 冗余字段 dyl 页面展示
	 */
	private transient String txfreqA;
	private transient String rxfreqA;
	private transient String txfreqB;
	private transient String rxfreqB;

	@Transient
	public String getTxfreqA() {
		return txfreqA;
	}

	public void setTxfreqA(String txfreqA) {
		this.txfreqA = txfreqA;
	}

	@Transient
	public String getRxfreqA() {
		return rxfreqA;
	}

	public void setRxfreqA(String rxfreqA) {
		this.rxfreqA = rxfreqA;
	}

	@Transient
	public String getTxfreqB() {
		return txfreqB;
	}

	public void setTxfreqB(String txfreqB) {
		this.txfreqB = txfreqB;
	}

	@Transient
	public String getRxfreqB() {
		return rxfreqB;
	}

	public void setRxfreqB(String rxfreqB) {
		this.rxfreqB = rxfreqB;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EQUIP_NAME")
	public SatelliteDayAutoType getEquipName() {
		return equipName;
	}

	public void setEquipName(SatelliteDayAutoType equipName) {
		this.equipName = equipName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXA_STATE")
	public SatelliteStatus getTxaState() {
		return txaState;
	}

	public void setTxaState(SatelliteStatus txaState) {
		this.txaState = txaState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXA_STATE")
	public SatelliteStatus getRxaState() {
		return rxaState;
	}

	public void setRxaState(SatelliteStatus rxaState) {
		this.rxaState = rxaState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXB_STATE")
	public SatelliteStatus getTxbState() {
		return txbState;
	}

	public void setTxbState(SatelliteStatus txbState) {
		this.txbState = txbState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXB_STATE")
	public SatelliteStatus getRxbState() {
		return rxbState;
	}

	public void setRxbState(SatelliteStatus rxbState) {
		this.rxbState = rxbState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXFREQ_A_STATE")
	public SatelliteStatus getTxfreqAstate() {
		return txfreqAstate;
	}

	public void setTxfreqAstate(SatelliteStatus txfreqAstate) {
		this.txfreqAstate = txfreqAstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXFREQ_A_STATE")
	public SatelliteStatus getRxfreqAstate() {
		return rxfreqAstate;
	}

	public void setRxfreqAstate(SatelliteStatus rxfreqAstate) {
		this.rxfreqAstate = rxfreqAstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "UC_A_STATE")
	public SatelliteStatus getUsAstate() {
		return usAstate;
	}

	public void setUsAstate(SatelliteStatus usAstate) {
		this.usAstate = usAstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DC_A_STATE")
	public SatelliteStatus getDcAstate() {
		return dcAstate;
	}

	public void setDcAstate(SatelliteStatus dcAstate) {
		this.dcAstate = dcAstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXFREQ_B_STATE")
	public SatelliteStatus getTxfreqBstate() {
		return txfreqBstate;
	}

	public void setTxfreqBstate(SatelliteStatus txfreqBstate) {
		this.txfreqBstate = txfreqBstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXFREQ_B_STATE")
	public SatelliteStatus getRxfreqBstate() {
		return rxfreqBstate;
	}

	public void setRxfreqBstate(SatelliteStatus rxfreqBstate) {
		this.rxfreqBstate = rxfreqBstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "UC_B_STATE")
	public SatelliteStatus getUsBstate() {
		return usBstate;
	}

	public void setUsBstate(SatelliteStatus usBstate) {
		this.usBstate = usBstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DC_B_STATE")
	public SatelliteStatus getDcBstate() {
		return dcBstate;
	}

	public void setDcBstate(SatelliteStatus dcBstate) {
		this.dcBstate = dcBstate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXA_RESULT")
	public SatelliteStatus getTxaResult() {
		return txaResult;
	}

	public void setTxaResult(SatelliteStatus txaResult) {
		this.txaResult = txaResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TXB_RESULT")
	public SatelliteStatus getRxaResult() {
		return rxaResult;
	}

	public void setRxaResult(SatelliteStatus rxaResult) {
		this.rxaResult = rxaResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXA_RESULT")
	public SatelliteStatus getTxbResult() {
		return txbResult;
	}

	public void setTxbResult(SatelliteStatus txbResult) {
		this.txbResult = txbResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "RXB_RESULT")
	public SatelliteStatus getRxbResult() {
		return rxbResult;
	}

	public void setRxbResult(SatelliteStatus rxbResult) {
		this.rxbResult = rxbResult;
	}

	@Column(name = "TXFREQ_A_RESULT")
	public String getTxfreqAresult() {
		return txfreqAresult;
	}

	public void setTxfreqAresult(String txfreqAresult) {
		this.txfreqAresult = txfreqAresult;
	}

	@Column(name = "RXFREQ_A_RESULT")
	public String getRxfreqAresult() {
		return rxfreqAresult;
	}

	public void setRxfreqAresult(String rxfreqAresult) {
		this.rxfreqAresult = rxfreqAresult;
	}

	@Column(name = "UC_A_RESULT")
	public String getUsAresult() {
		return usAresult;
	}

	public void setUsAresult(String usAresult) {
		this.usAresult = usAresult;
	}

	@Column(name = "DC_A_RESULT")
	public String getDcAresult() {
		return dcAresult;
	}

	public void setDcAresult(String dcAresult) {
		this.dcAresult = dcAresult;
	}

	@Column(name = "TXFREQ_B_RESULT")
	public String getTxfreqBresult() {
		return txfreqBresult;
	}

	public void setTxfreqBresult(String txfreqBresult) {
		this.txfreqBresult = txfreqBresult;
	}

	@Column(name = "RXFREQ_B_RESULT")
	public String getRxfreqBresult() {
		return rxfreqBresult;
	}

	public void setRxfreqBresult(String rxfreqBresult) {
		this.rxfreqBresult = rxfreqBresult;
	}

	@Column(name = "UC_B_RESULT")
	public String getUsBresult() {
		return usBresult;
	}

	public void setUsBresult(String usBresult) {
		this.usBresult = usBresult;
	}

	@Column(name = "DC_B_RESULT")
	public String getDcBresult() {
		return dcBresult;
	}

	public void setDcBresult(String dcBresult) {
		this.dcBresult = dcBresult;
	}
}
