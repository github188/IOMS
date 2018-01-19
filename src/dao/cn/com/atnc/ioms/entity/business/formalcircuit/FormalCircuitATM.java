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
import cn.com.atnc.ioms.enums.business.formalcircuit.AtmCircuitTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.SignalTypeEnum;

/**
 * ATM正式电路申请表
 * @author WangLingbin
 * @date 2016年2月1日 下午12:55:41
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_FORMALCIRCUIT_ATM")
public class FormalCircuitATM extends MyStringUUIDEntity {

	private static final long serialVersionUID = 8066082742839358520L;
	
	private FormalCircuit formalCircuit;  //正式电路申请表基础信息
	//--------------------申请表参数-------------------------
	private String identifier;  //编号
	private String businessName;  //业务名称
	private String txNodeName;  //本端节点名称
	private String txSlot;		//本端槽位号
	private String txPort;  //本端端口号
	private String txPortSpeed;  //本端端口速率
	private String txVpiDlci;  //本端VPI/VCI或DLCI
	private String txLine;		//本端线路号
	private String rxNodeName;  //对端节点名称
	private String rxSlot;		//对端槽位号
	private String rxPort;  //对端端口号
	private String rxPortSpeed;  //对端端口速率
	private String rxVpiDlci;  //对端VPI/VCI或DLCI
	private String rxLine;		//对端线路号
	private String circuitSpeed;  //电路速率
	private AtmCircuitTypeEnum serviceType;  //服务类型
	private Calendar openTime;  //要求开通时间
	private String usage;	//电路用途
	private Integer num;	//排序
	
	//--------------------配置表参数-------------------------
	private String confTxNodeName;				//配置表-本端节点名
	private String confTxSlodNum;				//配置表-本端槽位号
	private String confTxPort;					//配置表-本端端口号
	private SignalTypeEnum confTxSignal;		//配置表-本端信令类型
	private String confTxVpiDlci;				//配置表-本端VPI
	private String confTxLine;					//配置表-本端线路号
	private String confRxNodeName;				//配置表-对端节点名
	private String confRxSlodNum;				//配置表-对端槽位号
	private String confRxPort;					//配置表-对端端口号
	private SignalTypeEnum confRxSignal;		//配置表-对端信令类型
	private String confRxVpiDlci;				//配置表-对端VPI
	private String confRxLine;					//配置表-对端线路号
	private String confUsage;					//配置表-电路用途
	private AtmCircuitTypeEnum confServiceType;			//配置表-服务类型
	private String confSpeed;					//配置表-速率
	private String confRemark;					//配置表-备注
	private String confNo;					//配置表-电路编号
	
	@ManyToOne
	@JoinColumn(name="baseinfo")
	public FormalCircuit getFormalCircuit() {
		return formalCircuit;
	}
	public void setFormalCircuit(FormalCircuit formalCircuit) {
		this.formalCircuit = formalCircuit;
	}
	@Column(name="identifier")
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Column(name="business_name")
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	@Column(name="tx_node_name")
	public String getTxNodeName() {
		return txNodeName;
	}
	public void setTxNodeName(String txNodeName) {
		this.txNodeName = txNodeName;
	}
	@Column(name="tx_slot")
	public String getTxSlot() {
		return txSlot;
	}
	public void setTxSlot(String txSlot) {
		this.txSlot = txSlot;
	}
	@Column(name="tx_port")
	public String getTxPort() {
		return txPort;
	}
	public void setTxPort(String txPort) {
		this.txPort = txPort;
	}
	@Column(name="tx_port_speed")
	public String getTxPortSpeed() {
		return txPortSpeed;
	}
	public void setTxPortSpeed(String txPortSpeed) {
		this.txPortSpeed = txPortSpeed;
	}
	@Column(name="tx_vpi_dlci")
	public String getTxVpiDlci() {
		return txVpiDlci;
	}
	public void setTxVpiDlci(String txVpiDlci) {
		this.txVpiDlci = txVpiDlci;
	}
	@Column(name="rx_node_name")
	public String getRxNodeName() {
		return rxNodeName;
	}
	public void setRxNodeName(String rxNodeName) {
		this.rxNodeName = rxNodeName;
	}
	@Column(name="rx_slot")
	public String getRxSlot() {
		return rxSlot;
	}
	public void setRxSlot(String rxSlot) {
		this.rxSlot = rxSlot;
	}
	@Column(name="rx_port")
	public String getRxPort() {
		return rxPort;
	}
	public void setRxPort(String rxPort) {
		this.rxPort = rxPort;
	}
	@Column(name="rx_port_speed")
	public String getRxPortSpeed() {
		return rxPortSpeed;
	}
	public void setRxPortSpeed(String rxPortSpeed) {
		this.rxPortSpeed = rxPortSpeed;
	}
	@Column(name="rx_vpi_dlci")
	public String getRxVpiDlci() {
		return rxVpiDlci;
	}
	public void setRxVpiDlci(String rxVpiDlci) {
		this.rxVpiDlci = rxVpiDlci;
	}
	@Column(name="circuit_speed")
	public String getCircuitSpeed() {
		return circuitSpeed;
	}
	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="service_type")
	public AtmCircuitTypeEnum getServiceType() {
		return serviceType;
	}
	public void setServiceType(AtmCircuitTypeEnum serviceType) {
		this.serviceType = serviceType;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="open_time")
	public Calendar getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Calendar openTime) {
		this.openTime = openTime;
	}
	@Column(name="usage")
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	@Column(name="conf_tx_node_name")
	public String getConfTxNodeName() {
		return confTxNodeName;
	}
	public void setConfTxNodeName(String confTxNodeName) {
		this.confTxNodeName = confTxNodeName;
	}
	@Column(name="conf_tx_slod_num")
	public String getConfTxSlodNum() {
		return confTxSlodNum;
	}
	public void setConfTxSlodNum(String confTxSlodNum) {
		this.confTxSlodNum = confTxSlodNum;
	}
	@Column(name="conf_tx_port")
	public String getConfTxPort() {
		return confTxPort;
	}
	public void setConfTxPort(String confTxPort) {
		this.confTxPort = confTxPort;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_tx_signal")
	public SignalTypeEnum getConfTxSignal() {
		return confTxSignal;
	}
	public void setConfTxSignal(SignalTypeEnum confTxSignal) {
		this.confTxSignal = confTxSignal;
	}
	@Column(name="conf_tx_vpi_dlci")
	public String getConfTxVpiDlci() {
		return confTxVpiDlci;
	}
	public void setConfTxVpiDlci(String confTxVpiDlci) {
		this.confTxVpiDlci = confTxVpiDlci;
	}
	@Column(name="conf_rx_node_name")
	public String getConfRxNodeName() {
		return confRxNodeName;
	}
	public void setConfRxNodeName(String confRxNodeName) {
		this.confRxNodeName = confRxNodeName;
	}
	@Column(name="conf_rx_slod_num")
	public String getConfRxSlodNum() {
		return confRxSlodNum;
	}
	public void setConfRxSlodNum(String confRxSlodNum) {
		this.confRxSlodNum = confRxSlodNum;
	}
	@Column(name="conf_rx_port")
	public String getConfRxPort() {
		return confRxPort;
	}
	public void setConfRxPort(String confRxPort) {
		this.confRxPort = confRxPort;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_rx_signal")
	public SignalTypeEnum getConfRxSignal() {
		return confRxSignal;
	}
	public void setConfRxSignal(SignalTypeEnum confRxSignal) {
		this.confRxSignal = confRxSignal;
	}
	@Column(name="conf_rx_vpi_dlci")
	public String getConfRxVpiDlci() {
		return confRxVpiDlci;
	}
	public void setConfRxVpiDlci(String confRxVpiDlci) {
		this.confRxVpiDlci = confRxVpiDlci;
	}
	@Column(name="conf_usage")
	public String getConfUsage() {
		return confUsage;
	}
	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_service_type")
	public AtmCircuitTypeEnum getConfServiceType() {
		return confServiceType;
	}
	public void setConfServiceType(AtmCircuitTypeEnum confServiceType) {
		this.confServiceType = confServiceType;
	}
	@Column(name="conf_speed")
	public String getConfSpeed() {
		return confSpeed;
	}
	public void setConfSpeed(String confSpeed) {
		this.confSpeed = confSpeed;
	}
	@Column(name="conf_remark")
	public String getConfRemark() {
		return confRemark;
	}
	public void setConfRemark(String confRemark) {
		this.confRemark = confRemark;
	}
	@Column(name="num")
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Column(name="conf_no")
	public String getConfNo() {
		return confNo;
	}
	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}
	@Column(name="tx_line")
	public String getTxLine() {
		return txLine;
	}
	public void setTxLine(String txLine) {
		this.txLine = txLine;
	}
	@Column(name="rx_line")
	public String getRxLine() {
		return rxLine;
	}
	public void setRxLine(String rxLine) {
		this.rxLine = rxLine;
	}
	@Column(name="conf_tx_line")
	public String getConfTxLine() {
		return confTxLine;
	}
	public void setConfTxLine(String confTxLine) {
		this.confTxLine = confTxLine;
	}
	@Column(name="conf_rx_line")
	public String getConfRxLine() {
		return confRxLine;
	}
	public void setConfRxLine(String confRxLine) {
		this.confRxLine = confRxLine;
	}
}
