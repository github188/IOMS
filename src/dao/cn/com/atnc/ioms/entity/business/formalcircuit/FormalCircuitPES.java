package cn.com.atnc.ioms.entity.business.formalcircuit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.business.formalcircuit.CommunicateWayEnum;

/**
 * PES正式电路申请表
 *
 * @author 段衍林
 * @2017年1月5日 上午10:27:43
 */
@Entity
@Table(name = "TB_OM_APPLY_FORMALCIRCUIT_PES")
public class FormalCircuitPES extends MyStringUUIDEntity {

	private static final long serialVersionUID = 7791099137226499473L;

	private FormalCircuit formalCircuit; // 正式电路申请表基础信息
	// --------------------申请表参数-------------------------
	private String identifier; // 编号
	private String businessName; // 业务名称
	private String txSiteName; // 本端站点名
	private String txCaseNum; // 本端机箱号
	private String txSlotNum; // 本端槽位号
	private String txPortNum; // 本端端口号
	private String rxSiteName; // 对端站点名
	private String rxCaseNum; // 对端机箱号
	private String rxSlotNum; // 对端槽位号
	private String rxPortNum; // 对端端口号
	private String circuitSpeed; // 电路速率
	private CommunicateWayEnum communicateWay; // 通信方式
	private Calendar openTime; // 要求开通时间
	private String usage; // 电路用途
	private Integer num; // 排序

	// --------------------配置表参数-------------------------
	private String confTxSiteName; // 配置表-本端站点名
	private String confTxCaseNum; // 配置表-本端机箱号
	private String confTxSlotNum; // 配置表-本端槽位号
	private String confTxInterface; // 配置表-本端接口类型
	private String confTxPortNum; // 配置表-本端端口号

	private String confRxSiteName; // 配置表-对端站点名
	private String confRxCaseNum; // 配置表-对端机箱号
	private String confRxSlotNum; // 配置表-对端槽位号
	private String confRxInterface; // 配置表-对端接口类型
	private String confRxPortNum; // 配置表-对端端口号
	private String confCircuitName; // 配置表-电路名称
	private String confSpeed; // 配置表-电路速率
	private CommunicateWayEnum confCommunicateWay; // 配置表-通信方式
	private String confNo; // 配置表-电路编号
	private String confUsage; // 配置表-电路用途

	@Column(name = "TX_PORT_NUM")
	public String getTxPortNum() {
		return txPortNum;
	}

	public void setTxPortNum(String txPortNum) {
		this.txPortNum = txPortNum;
	}

	@Column(name = "RX_PORT_NUM")
	public String getRxPortNum() {
		return rxPortNum;
	}

	public void setRxPortNum(String rxPortNum) {
		this.rxPortNum = rxPortNum;
	}

	@Column(name = "CONF_TX_PORT_NUM")
	public String getConfTxPortNum() {
		return confTxPortNum;
	}

	public void setConfTxPortNum(String confTxPortNum) {
		this.confTxPortNum = confTxPortNum;
	}

	@Column(name = "CONF_RX_PORT_NUM")
	public String getConfRxPortNum() {
		return confRxPortNum;
	}

	public void setConfRxPortNum(String confRxPortNum) {
		this.confRxPortNum = confRxPortNum;
	}

	@ManyToOne
	@JoinColumn(name = "baseinfo")
	public FormalCircuit getFormalCircuit() {
		return formalCircuit;
	}

	public void setFormalCircuit(FormalCircuit formalCircuit) {
		this.formalCircuit = formalCircuit;
	}

	// @Enumerated(EnumType.STRING)
	// @Column(name="")

	@Column(name = "identifier")
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Column(name = "business_name")
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "tx_site_name")
	public String getTxSiteName() {
		return txSiteName;
	}

	public void setTxSiteName(String txSiteName) {
		this.txSiteName = txSiteName;
	}

	@Column(name = "tx_case_num")
	public String getTxCaseNum() {
		return txCaseNum;
	}

	public void setTxCaseNum(String txCaseNum) {
		this.txCaseNum = txCaseNum;
	}

	@Column(name = "tx_slot_num")
	public String getTxSlotNum() {
		return txSlotNum;
	}

	public void setTxSlotNum(String txSlotNum) {
		this.txSlotNum = txSlotNum;
	}

	@Column(name = "rx_site_name")
	public String getRxSiteName() {
		return rxSiteName;
	}

	public void setRxSiteName(String rxSiteName) {
		this.rxSiteName = rxSiteName;
	}

	@Column(name = "rx_case_num")
	public String getRxCaseNum() {
		return rxCaseNum;
	}

	public void setRxCaseNum(String rxCaseNum) {
		this.rxCaseNum = rxCaseNum;
	}

	@Column(name = "rx_slot_num")
	public String getRxSlotNum() {
		return rxSlotNum;
	}

	public void setRxSlotNum(String rxSlotNum) {
		this.rxSlotNum = rxSlotNum;
	}

	@Column(name = "circuit_speed")
	public String getCircuitSpeed() {
		return circuitSpeed;
	}

	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "communicate_way")
	public CommunicateWayEnum getCommunicateWay() {
		return communicateWay;
	}

	public void setCommunicateWay(CommunicateWayEnum communicateWay) {
		this.communicateWay = communicateWay;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "open_time")
	public Calendar getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Calendar openTime) {
		this.openTime = openTime;
	}

	@Column(name = "usage")
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Column(name = "conf_tx_sitename")
	public String getConfTxSiteName() {
		return confTxSiteName;
	}

	public void setConfTxSiteName(String confTxSiteName) {
		this.confTxSiteName = confTxSiteName;
	}

	@Column(name = "conf_tx_case_num")
	public String getConfTxCaseNum() {
		return confTxCaseNum;
	}

	public void setConfTxCaseNum(String confTxCaseNum) {
		this.confTxCaseNum = confTxCaseNum;
	}

	@Column(name = "conf_tx_slot_num")
	public String getConfTxSlotNum() {
		return confTxSlotNum;
	}

	public void setConfTxSlotNum(String confTxSlotNum) {
		this.confTxSlotNum = confTxSlotNum;
	}

	@Column(name = "conf_tx_interface")
	public String getConfTxInterface() {
		return confTxInterface;
	}

	public void setConfTxInterface(String confTxInterface) {
		this.confTxInterface = confTxInterface;
	}

	@Column(name = "conf_rx_sitename")
	public String getConfRxSiteName() {
		return confRxSiteName;
	}

	public void setConfRxSiteName(String confRxSiteName) {
		this.confRxSiteName = confRxSiteName;
	}

	@Column(name = "conf_rx_case_num")
	public String getConfRxCaseNum() {
		return confRxCaseNum;
	}

	public void setConfRxCaseNum(String confRxCaseNum) {
		this.confRxCaseNum = confRxCaseNum;
	}

	@Column(name = "conf_rx_slot_num")
	public String getConfRxSlotNum() {
		return confRxSlotNum;
	}

	public void setConfRxSlotNum(String confRxSlotNum) {
		this.confRxSlotNum = confRxSlotNum;
	}

	@Column(name = "conf_rx_interface")
	public String getConfRxInterface() {
		return confRxInterface;
	}

	public void setConfRxInterface(String confRxInterface) {
		this.confRxInterface = confRxInterface;
	}

	@Column(name = "conf_circuit_name")
	public String getConfCircuitName() {
		return confCircuitName;
	}

	public void setConfCircuitName(String confCircuitName) {
		this.confCircuitName = confCircuitName;
	}

	@Column(name = "conf_speed")
	public String getConfSpeed() {
		return confSpeed;
	}

	public void setConfSpeed(String confSpeed) {
		this.confSpeed = confSpeed;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "conf_communicate")
	public CommunicateWayEnum getConfCommunicateWay() {
		return confCommunicateWay;
	}

	public void setConfCommunicateWay(CommunicateWayEnum confCommunicateWay) {
		this.confCommunicateWay = confCommunicateWay;
	}

	@Column(name = "conf_no")
	public String getConfNo() {
		return confNo;
	}

	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}

	@Column(name = "conf_usage")
	public String getConfUsage() {
		return confUsage;
	}

	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
	}

	@Column(name = "num")
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
