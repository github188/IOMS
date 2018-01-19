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
import cn.com.atnc.ioms.enums.business.formalcircuit.CardEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.CommunicateWayEnum;


 /**
 * KU正式电路申请表
 *
 * @author Wang zhicheng
 * @date 2015年5月15日 下午4:22:49
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_FORMALCIRCUIT_KU")
public class FormalCircuitKU extends MyStringUUIDEntity {
	
	private static final long serialVersionUID = 2463786834791724344L;
	
	private FormalCircuit formalCircuit;  //正式电路申请表基础信息
	//--------------------申请表参数-------------------------
	private String identifier;  //编号
	private String businessName;  //业务名称
	private String txSiteName;	//本端站点名称
	private String txNodeNum;  //本端节点号
	private String txSlotNum;  //本端槽位号
	private String txPortNum;  //本端端口号
	private String rxSiteName;	//对端站点名称
	private String rxNodeNum;  //对端节点号
	private String rxSlotNum;  //对端槽位号
	private String rxPortNum;  //对端端口号
	private String circuitSpeed;  //电路速率
	private String usage;	//电路用途
	private CommunicateWayEnum communicateWay;  //通信方式
	private Calendar openTime;  //期望开通时间
	private Integer num;	//排序
	
	//--------------------配置表参数-------------------------
	private String confTxSiteName;	//配置表-本端站点名称
	private String confTxNode;		//配置表-本端节点
	private CardEnum confTxCard;	//配置表-本端卡类型
	private String confTxSlot;		//配置表-本端槽位号
	private String confTxPlot;		//配置表-本端端口号
	private String confTxInterface; //配置表-本端接口类型
	
	private String confRxSiteName;	//配置表-对端站点名称
	private String confRxNode;		//配置表-对端节点
	private CardEnum confRxCard;	//配置表-对端卡类型
	private String confRxSlot;		//配置表-对端槽位号
	private String confRxPlot;		//配置表-对端端口号
	private String confRxInterface;	//配置表-对端接口类型
	private String confCircuitName;	//配置表-电路名称
	private String confSpeed;		//配置表-速率
	private CommunicateWayEnum confCommunicateWay;	//配置表-通信方式
	private String confUsage;		//配置表-用途
	private String confNo;			//配置表-电路编号
	
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
	@Column(name="tx_site_name")
	public String getTxSiteName() {
		return txSiteName;
	}
	public void setTxSiteName(String txSiteName) {
		this.txSiteName = txSiteName;
	}
	@Column(name="tx_slot_num")
	public String getTxSlotNum() {
		return txSlotNum;
	}
	public void setTxSlotNum(String txSlotNum) {
		this.txSlotNum = txSlotNum;
	}
	@Column(name="tx_port_num")
	public String getTxPortNum() {
		return txPortNum;
	}
	public void setTxPortNum(String txPortNum) {
		this.txPortNum = txPortNum;
	}
	@Column(name="rx_site_name")
	public String getRxSiteName() {
		return rxSiteName;
	}
	public void setRxSiteName(String rxSiteName) {
		this.rxSiteName = rxSiteName;
	}
	@Column(name="rx_slot_num")
	public String getRxSlotNum() {
		return rxSlotNum;
	}
	public void setRxSlotNum(String rxSlotNum) {
		this.rxSlotNum = rxSlotNum;
	}
	@Column(name="rx_port_num")
	public String getRxPortNum() {
		return rxPortNum;
	}
	public void setRxPortNum(String rxPortNum) {
		this.rxPortNum = rxPortNum;
	}
	@Column(name="circuit_speed")
	public String getCircuitSpeed() {
		return circuitSpeed;
	}
	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="communicate_way")
	public CommunicateWayEnum getCommunicateWay() {
		return communicateWay;
	}
	public void setCommunicateWay(CommunicateWayEnum communicateWay) {
		this.communicateWay = communicateWay;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="open_time")
	public Calendar getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Calendar openTime) {
		this.openTime = openTime;
	}
	@Column(name="tx_node_num")
	public String getTxNodeNum() {
		return txNodeNum;
	}
	public void setTxNodeNum(String txNodeNum) {
		this.txNodeNum = txNodeNum;
	}
	@Column(name="rx_node_num")
	public String getRxNodeNum() {
		return rxNodeNum;
	}
	public void setRxNodeNum(String rxNodeNum) {
		this.rxNodeNum = rxNodeNum;
	}
	@Column(name="usage")
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	@Column(name="conf_t_sitename")
	public String getConfTxSiteName() {
		return confTxSiteName;
	}
	public void setConfTxSiteName(String confTxSiteName) {
		this.confTxSiteName = confTxSiteName;
	}
	@Column(name="conf_t_node")
	public String getConfTxNode() {
		return confTxNode;
	}
	public void setConfTxNode(String confTxNode) {
		this.confTxNode = confTxNode;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_t_card")
	public CardEnum getConfTxCard() {
		return confTxCard;
	}
	public void setConfTxCard(CardEnum confTxCard) {
		this.confTxCard = confTxCard;
	}
	@Column(name="conf_t_slot")
	public String getConfTxSlot() {
		return confTxSlot;
	}
	public void setConfTxSlot(String confTxSlot) {
		this.confTxSlot = confTxSlot;
	}
	@Column(name="conf_t_port")
	public String getConfTxPlot() {
		return confTxPlot;
	}
	public void setConfTxPlot(String confTxPlot) {
		this.confTxPlot = confTxPlot;
	}
	@Column(name="conf_t_interface")
	public String getConfTxInterface() {
		return confTxInterface;
	}
	public void setConfTxInterface(String confTxInterface) {
		this.confTxInterface = confTxInterface;
	}
	@Column(name="conf_r_sitename")
	public String getConfRxSiteName() {
		return confRxSiteName;
	}
	public void setConfRxSiteName(String confRxSiteName) {
		this.confRxSiteName = confRxSiteName;
	}
	@Column(name="conf_r_node")
	public String getConfRxNode() {
		return confRxNode;
	}
	public void setConfRxNode(String confRxNode) {
		this.confRxNode = confRxNode;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_r_card")
	public CardEnum getConfRxCard() {
		return confRxCard;
	}
	public void setConfRxCard(CardEnum confRxCard) {
		this.confRxCard = confRxCard;
	}
	@Column(name="conf_r_slot")
	public String getConfRxSlot() {
		return confRxSlot;
	}
	public void setConfRxSlot(String confRxSlot) {
		this.confRxSlot = confRxSlot;
	}
	@Column(name="conf_r_port")
	public String getConfRxPlot() {
		return confRxPlot;
	}
	public void setConfRxPlot(String confRxPlot) {
		this.confRxPlot = confRxPlot;
	}
	@Column(name="conf_r_interface")
	public String getConfRxInterface() {
		return confRxInterface;
	}
	public void setConfRxInterface(String confRxInterface) {
		this.confRxInterface = confRxInterface;
	}
	@Column(name="conf_circuit_name")
	public String getConfCircuitName() {
		return confCircuitName;
	}
	public void setConfCircuitName(String confCircuitName) {
		this.confCircuitName = confCircuitName;
	}
	@Column(name="conf_speed")
	public String getConfSpeed() {
		return confSpeed;
	}
	public void setConfSpeed(String confSpeed) {
		this.confSpeed = confSpeed;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="conf_communication")
	public CommunicateWayEnum getConfCommunicateWay() {
		return confCommunicateWay;
	}
	public void setConfCommunicateWay(CommunicateWayEnum confCommunicateWay) {
		this.confCommunicateWay = confCommunicateWay;
	}
	@Column(name="conf_useage")
	public String getConfUsage() {
		return confUsage;
	}
	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
	}
	@Column(name="conf_no")
	public String getConfNo() {
		return confNo;
	}
	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}
	@Column(name="num")
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
