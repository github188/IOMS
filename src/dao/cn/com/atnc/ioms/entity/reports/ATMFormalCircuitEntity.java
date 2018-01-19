/**
 * @ProjectName PCSP
 * @FileName ATMFormalCircuitEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年6月16日下午3:20:33
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * ATM正式电路申请
 * @author WangLingbin
 * @date 2015年6月16日 下午3:20:33
 * @since 1.0.0
 */
public class ATMFormalCircuitEntity {

	private String identifier;  //编号
	private String businessName;  //业务名称
	private String txNodeName;  //本端节点名称
	private String txSlot;		//本端槽位号
	private String txLine;		//本端线路号
	private String txPort;  //本端端口号
	private String txPortSpeed;  //本端端口速率
	private String txVpiDlci;  //本端VPI/VCI或DLCI
	private String rxNodeName;  //对端节点名称
	private String rxSlot;		//对端槽位号
	private String rxLine;		//对端线路号
	private String rxPort;  //对端端口号
	private String rxPortSpeed;  //对端端口速率
	private String rxVpiDlci;  //对端VPI/VCI或DLCI
	private String circuitSpeed;  //电路速率
	private String serviceType;  //服务类型
	private Date openTime;  //要求开通时间
	
	//--------------------配置表参数-------------------------
	private String confTxNodeName;				//配置表-本端节点名
	private String confTxSlodNum;				//配置表-本端槽位号
	private String confTxLine;					//配置表-本端线路号
	private String confTxPort;					//配置表-本端端口号
	private String confTxSignal;		//配置表-本端信令类型
	private String confTxVpiDlci;				//配置表-本端VPI
	
	private String confRxNodeName;				//配置表-对端节点名
	private String confRxSlodNum;				//配置表-对端槽位号
	private String confRxLine;					//配置表-对端线路号
	private String confRxPort;					//配置表-对端端口号
	private String confRxSignal;		//配置表-对端信令类型
	private String confRxVpiDlci;				//配置表-对端VPI
	private String confUsage;					//配置表-电路用途
	private String confServiceType;			//配置表-服务类型
	private String confSpeed;					//配置表-速率
	private String confRemark;					//配置表-备注
	private String confNo;					//配置表-电路编号
	
	public ATMFormalCircuitEntity() {
		super();
	}

	public ATMFormalCircuitEntity(String identifier, String businessName,
			String txNodeName, String txSlot, String txLine, String txPort,
			String txPortSpeed, String txVpiDlci, String rxNodeName,
			String rxSlot, String rxLine, String rxPort, String rxPortSpeed,
			String rxVpiDlci, String circuitSpeed, String serviceType,
			Date openTime) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txNodeName = txNodeName;
		this.txSlot = txSlot;
		this.txLine = txLine;
		this.txPort = txPort;
		this.txPortSpeed = txPortSpeed;
		this.txVpiDlci = txVpiDlci;
		this.rxNodeName = rxNodeName;
		this.rxSlot = rxSlot;
		this.rxLine = rxLine;
		this.rxPort = rxPort;
		this.rxPortSpeed = rxPortSpeed;
		this.rxVpiDlci = rxVpiDlci;
		this.circuitSpeed = circuitSpeed;
		this.serviceType = serviceType;
		this.openTime = openTime;
	}

	public ATMFormalCircuitEntity(String identifier, String confTxNodeName,
			String confTxSlodNum, String confTxLine, String confTxPort,
			String confTxSignal, String confTxVpiDlci, String confRxNodeName,
			String confRxSlodNum, String confRxLine, String confRxPort,
			String confRxSignal, String confRxVpiDlci, String confUsage,
			String confServiceType, String confSpeed, String confRemark,
			String confNo) {
		super();
		this.identifier = identifier;
		this.confTxNodeName = confTxNodeName;
		this.confTxSlodNum = confTxSlodNum;
		this.confTxLine = confTxLine;
		this.confTxPort = confTxPort;
		this.confTxSignal = confTxSignal;
		this.confTxVpiDlci = confTxVpiDlci;
		this.confRxNodeName = confRxNodeName;
		this.confRxSlodNum = confRxSlodNum;
		this.confRxLine = confRxLine;
		this.confRxPort = confRxPort;
		this.confRxSignal = confRxSignal;
		this.confRxVpiDlci = confRxVpiDlci;
		this.confUsage = confUsage;
		this.confServiceType = confServiceType;
		this.confSpeed = confSpeed;
		this.confRemark = confRemark;
		this.confNo = confNo;
	}
	
	public ATMFormalCircuitEntity(String identifier, String businessName,
			String txNodeName, String txSlot, String txLine, String txPort,
			String txPortSpeed, String txVpiDlci, String rxNodeName,
			String rxSlot, String rxLine, String rxPort, String rxPortSpeed,
			String rxVpiDlci, String circuitSpeed, String serviceType,
			Date openTime, String confTxNodeName, String confTxSlodNum,
			String confTxLine, String confTxPort, String confTxSignal,
			String confTxVpiDlci, String confRxNodeName, String confRxSlodNum,
			String confRxLine, String confRxPort, String confRxSignal,
			String confRxVpiDlci, String confUsage, String confServiceType,
			String confSpeed, String confRemark, String confNo) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txNodeName = txNodeName;
		this.txSlot = txSlot;
		this.txLine = txLine;
		this.txPort = txPort;
		this.txPortSpeed = txPortSpeed;
		this.txVpiDlci = txVpiDlci;
		this.rxNodeName = rxNodeName;
		this.rxSlot = rxSlot;
		this.rxLine = rxLine;
		this.rxPort = rxPort;
		this.rxPortSpeed = rxPortSpeed;
		this.rxVpiDlci = rxVpiDlci;
		this.circuitSpeed = circuitSpeed;
		this.serviceType = serviceType;
		this.openTime = openTime;
		this.confTxNodeName = confTxNodeName;
		this.confTxSlodNum = confTxSlodNum;
		this.confTxLine = confTxLine;
		this.confTxPort = confTxPort;
		this.confTxSignal = confTxSignal;
		this.confTxVpiDlci = confTxVpiDlci;
		this.confRxNodeName = confRxNodeName;
		this.confRxSlodNum = confRxSlodNum;
		this.confRxLine = confRxLine;
		this.confRxPort = confRxPort;
		this.confRxSignal = confRxSignal;
		this.confRxVpiDlci = confRxVpiDlci;
		this.confUsage = confUsage;
		this.confServiceType = confServiceType;
		this.confSpeed = confSpeed;
		this.confRemark = confRemark;
		this.confNo = confNo;
	}

	public String getTxSlot() {
		return txSlot;
	}
	public void setTxSlot(String txSlot) {
		this.txSlot = txSlot;
	}
	public String getRxSlot() {
		return rxSlot;
	}
	public void setRxSlot(String rxSlot) {
		this.rxSlot = rxSlot;
	}
	public String getConfTxSignal() {
		return confTxSignal;
	}
	public void setConfTxSignal(String confTxSignal) {
		this.confTxSignal = confTxSignal;
	}
	public String getConfRxSignal() {
		return confRxSignal;
	}
	public void setConfRxSignal(String confRxSignal) {
		this.confRxSignal = confRxSignal;
	}
	public String getConfServiceType() {
		return confServiceType;
	}
	public void setConfServiceType(String confServiceType) {
		this.confServiceType = confServiceType;
	}
	public String getConfTxNodeName() {
		return confTxNodeName;
	}
	public void setConfTxNodeName(String confTxNodeName) {
		this.confTxNodeName = confTxNodeName;
	}
	public String getConfTxSlodNum() {
		return confTxSlodNum;
	}
	public void setConfTxSlodNum(String confTxSlodNum) {
		this.confTxSlodNum = confTxSlodNum;
	}
	public String getConfTxPort() {
		return confTxPort;
	}
	public void setConfTxPort(String confTxPort) {
		this.confTxPort = confTxPort;
	}
	public String getConfTxVpiDlci() {
		return confTxVpiDlci;
	}
	public void setConfTxVpiDlci(String confTxVpiDlci) {
		this.confTxVpiDlci = confTxVpiDlci;
	}
	public String getConfRxNodeName() {
		return confRxNodeName;
	}
	public void setConfRxNodeName(String confRxNodeName) {
		this.confRxNodeName = confRxNodeName;
	}
	public String getConfRxSlodNum() {
		return confRxSlodNum;
	}
	public void setConfRxSlodNum(String confRxSlodNum) {
		this.confRxSlodNum = confRxSlodNum;
	}
	public String getConfRxPort() {
		return confRxPort;
	}
	public void setConfRxPort(String confRxPort) {
		this.confRxPort = confRxPort;
	}
	public String getConfRxVpiDlci() {
		return confRxVpiDlci;
	}
	public void setConfRxVpiDlci(String confRxVpiDlci) {
		this.confRxVpiDlci = confRxVpiDlci;
	}
	public String getConfUsage() {
		return confUsage;
	}
	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
	}
	public String getConfSpeed() {
		return confSpeed;
	}
	public void setConfSpeed(String confSpeed) {
		this.confSpeed = confSpeed;
	}
	public String getConfRemark() {
		return confRemark;
	}
	public void setConfRemark(String confRemark) {
		this.confRemark = confRemark;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTxNodeName() {
		return txNodeName;
	}
	public void setTxNodeName(String txNodeName) {
		this.txNodeName = txNodeName;
	}
	public String getTxPort() {
		return txPort;
	}
	public void setTxPort(String txPort) {
		this.txPort = txPort;
	}
	public String getTxPortSpeed() {
		return txPortSpeed;
	}
	public void setTxPortSpeed(String txPortSpeed) {
		this.txPortSpeed = txPortSpeed;
	}
	public String getTxVpiDlci() {
		return txVpiDlci;
	}
	public void setTxVpiDlci(String txVpiDlci) {
		this.txVpiDlci = txVpiDlci;
	}
	public String getRxNodeName() {
		return rxNodeName;
	}
	public void setRxNodeName(String rxNodeName) {
		this.rxNodeName = rxNodeName;
	}
	public String getRxPort() {
		return rxPort;
	}
	public void setRxPort(String rxPort) {
		this.rxPort = rxPort;
	}
	public String getRxPortSpeed() {
		return rxPortSpeed;
	}
	public void setRxPortSpeed(String rxPortSpeed) {
		this.rxPortSpeed = rxPortSpeed;
	}
	public String getRxVpiDlci() {
		return rxVpiDlci;
	}
	public void setRxVpiDlci(String rxVpiDlci) {
		this.rxVpiDlci = rxVpiDlci;
	}
	public String getCircuitSpeed() {
		return circuitSpeed;
	}
	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public String getConfNo() {
		return confNo;
	}
	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}
	public String getTxLine() {
		return txLine;
	}
	public void setTxLine(String txLine) {
		this.txLine = txLine;
	}
	public String getRxLine() {
		return rxLine;
	}
	public void setRxLine(String rxLine) {
		this.rxLine = rxLine;
	}
	public String getConfTxLine() {
		return confTxLine;
	}
	public void setConfTxLine(String confTxLine) {
		this.confTxLine = confTxLine;
	}
	public String getConfRxLine() {
		return confRxLine;
	}
	public void setConfRxLine(String confRxLine) {
		this.confRxLine = confRxLine;
	}
	
}
