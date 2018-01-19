/**
 * @ProjectName PCSP
 * @FileName KUFormalCircuitEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年6月16日下午3:26:48
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * KU正式电路申请
 * @author WangLingbin
 * @date 2015年6月16日 下午3:26:48
 * @since 1.0.0
 */
public class KUFormalCircuitEntity {

	private String identifier;  //编号
	private String businessName;  //业务名称
	private String txSiteName; //本端站点名
	private String txNodeNum;  //本端节点号
	private String txSlotNum;  //本端槽位号
	private String txPortNum;  //本端端口号
	private String rxSiteName; //对端站点名
	private String rxNodeNum;  //对端节点号
	private String rxSlotNum;  //对端槽位号
	private String rxPortNum;  //对端端口号
	private String circuitSpeed;  //电路速率
	private String communicateWay;  //通信方式
	private Date openTime;  //要求开通时间
	private String usage;	//电路用途
	
	//--------------------配置表参数-------------------------
	private String confTxSiteName;	//配置表-本端站点名称
	private String confTxNode;		//配置表-本端节点
	private String confTxCard;	//配置表-本端卡类型
	private String confTxSlot;		//配置表-本端槽位号
	private String confTxPlot;		//配置表-本端端口号
	private String confTxInterface; //配置表-本端接口类型
	private String confRxSiteName;	//配置表-对端站点名称
	private String confRxNode;		//配置表-对端节点
	private String confRxCard;	//配置表-对端卡类型
	private String confRxSlot;		//配置表-对端槽位号
	private String confRxPlot;		//配置表-对端端口号
	private String confRxInterface;	//配置表-对端接口类型
	private String confCircuitName;	//配置表-电路名称
	private String confSpeed;		//配置表-速率
	private String confCommunicateWay;	//配置表-通信方式
	private String confUsage;		//配置表-用途
	private String confNo;			//配置表-电路编号
	
	public KUFormalCircuitEntity() {
		super();
	}
	
	public KUFormalCircuitEntity(String identifier, String businessName,
			String txSiteName, String txNodeNum, String txSlotNum,
			String txPortNum, String rxSiteName, String rxNodeNum,
			String rxSlotNum, String rxPortNum, String circuitSpeed,
			String communicateWay, String usage,Date openTime) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txSiteName = txSiteName;
		this.txNodeNum = txNodeNum;
		this.txSlotNum = txSlotNum;
		this.txPortNum = txPortNum;
		this.rxSiteName = rxSiteName;
		this.rxNodeNum = rxNodeNum;
		this.rxSlotNum = rxSlotNum;
		this.rxPortNum = rxPortNum;
		this.circuitSpeed = circuitSpeed;
		this.communicateWay = communicateWay;
		this.usage = usage;
		this.openTime = openTime;
	}
	
	
	public KUFormalCircuitEntity(String identifier, String confTxSiteName,
			String confTxNode, String confTxCard, String confTxSlot,
			String confTxPlot, String confTxInterface, String confRxSiteName,
			String confRxNode, String confRxCard, String confRxSlot,
			String confRxPlot, String confRxInterface, String confCircuitName,
			String confSpeed, String confCommunicateWay, String confUsage,
			String confNo) {
		super();
		this.identifier = identifier;
		this.confTxSiteName = confTxSiteName;
		this.confTxNode = confTxNode;
		this.confTxCard = confTxCard;
		this.confTxSlot = confTxSlot;
		this.confTxPlot = confTxPlot;
		this.confTxInterface = confTxInterface;
		this.confRxSiteName = confRxSiteName;
		this.confRxNode = confRxNode;
		this.confRxCard = confRxCard;
		this.confRxSlot = confRxSlot;
		this.confRxPlot = confRxPlot;
		this.confRxInterface = confRxInterface;
		this.confCircuitName = confCircuitName;
		this.confSpeed = confSpeed;
		this.confCommunicateWay = confCommunicateWay;
		this.confUsage = confUsage;
		this.confNo = confNo;
	}

	public KUFormalCircuitEntity(String identifier, String businessName,
			String txSiteName, String txNodeNum, String txSlotNum,
			String txPortNum, String rxSiteName, String rxNodeNum,
			String rxSlotNum, String rxPortNum, String circuitSpeed,
			String communicateWay, String usage, Date openTime, 
			String confTxSiteName, String confTxNode, String confTxCard,
			String confTxSlot, String confTxPlot, String confTxInterface,
			String confRxSiteName, String confRxNode, String confRxCard,
			String confRxSlot, String confRxPlot, String confRxInterface,
			String confCircuitName, String confSpeed,
			String confCommunicateWay, String confUsage, String confNo) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txSiteName = txSiteName;
		this.txNodeNum = txNodeNum;
		this.txSlotNum = txSlotNum;
		this.txPortNum = txPortNum;
		this.rxSiteName = rxSiteName;
		this.rxNodeNum = rxNodeNum;
		this.rxSlotNum = rxSlotNum;
		this.rxPortNum = rxPortNum;
		this.circuitSpeed = circuitSpeed;
		this.communicateWay = communicateWay;
		this.usage = usage;
		this.openTime = openTime;
		this.confTxSiteName = confTxSiteName;
		this.confTxNode = confTxNode;
		this.confTxCard = confTxCard;
		this.confTxSlot = confTxSlot;
		this.confTxPlot = confTxPlot;
		this.confTxInterface = confTxInterface;
		this.confRxSiteName = confRxSiteName;
		this.confRxNode = confRxNode;
		this.confRxCard = confRxCard;
		this.confRxSlot = confRxSlot;
		this.confRxPlot = confRxPlot;
		this.confRxInterface = confRxInterface;
		this.confCircuitName = confCircuitName;
		this.confSpeed = confSpeed;
		this.confCommunicateWay = confCommunicateWay;
		this.confUsage = confUsage;
		this.confNo = confNo;
	}

	public String getTxSiteName() {
		return txSiteName;
	}

	public void setTxSiteName(String txSiteName) {
		this.txSiteName = txSiteName;
	}

	public String getRxSiteName() {
		return rxSiteName;
	}

	public void setRxSiteName(String rxSiteName) {
		this.rxSiteName = rxSiteName;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
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
	public String getTxNodeNum() {
		return txNodeNum;
	}
	public void setTxNodeNum(String txNodeNum) {
		this.txNodeNum = txNodeNum;
	}
	public String getTxSlotNum() {
		return txSlotNum;
	}
	public void setTxSlotNum(String txSlotNum) {
		this.txSlotNum = txSlotNum;
	}
	public String getTxPortNum() {
		return txPortNum;
	}
	public void setTxPortNum(String txPortNum) {
		this.txPortNum = txPortNum;
	}
	public String getRxNodeNum() {
		return rxNodeNum;
	}
	public void setRxNodeNum(String rxNodeNum) {
		this.rxNodeNum = rxNodeNum;
	}
	public String getRxSlotNum() {
		return rxSlotNum;
	}
	public void setRxSlotNum(String rxSlotNum) {
		this.rxSlotNum = rxSlotNum;
	}
	public String getRxPortNum() {
		return rxPortNum;
	}
	public void setRxPortNum(String rxPortNum) {
		this.rxPortNum = rxPortNum;
	}
	public String getCircuitSpeed() {
		return circuitSpeed;
	}
	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}
	public String getCommunicateWay() {
		return communicateWay;
	}
	public void setCommunicateWay(String communicateWay) {
		this.communicateWay = communicateWay;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public String getConfTxSiteName() {
		return confTxSiteName;
	}

	public void setConfTxSiteName(String confTxSiteName) {
		this.confTxSiteName = confTxSiteName;
	}

	public String getConfTxNode() {
		return confTxNode;
	}

	public void setConfTxNode(String confTxNode) {
		this.confTxNode = confTxNode;
	}

	public String getConfTxCard() {
		return confTxCard;
	}

	public void setConfTxCard(String confTxCard) {
		this.confTxCard = confTxCard;
	}

	public String getConfTxSlot() {
		return confTxSlot;
	}

	public void setConfTxSlot(String confTxSlot) {
		this.confTxSlot = confTxSlot;
	}

	public String getConfTxPlot() {
		return confTxPlot;
	}

	public void setConfTxPlot(String confTxPlot) {
		this.confTxPlot = confTxPlot;
	}

	public String getConfTxInterface() {
		return confTxInterface;
	}

	public void setConfTxInterface(String confTxInterface) {
		this.confTxInterface = confTxInterface;
	}

	public String getConfRxSiteName() {
		return confRxSiteName;
	}

	public void setConfRxSiteName(String confRxSiteName) {
		this.confRxSiteName = confRxSiteName;
	}

	public String getConfRxNode() {
		return confRxNode;
	}

	public void setConfRxNode(String confRxNode) {
		this.confRxNode = confRxNode;
	}

	public String getConfRxCard() {
		return confRxCard;
	}

	public void setConfRxCard(String confRxCard) {
		this.confRxCard = confRxCard;
	}

	public String getConfRxSlot() {
		return confRxSlot;
	}

	public void setConfRxSlot(String confRxSlot) {
		this.confRxSlot = confRxSlot;
	}

	public String getConfRxPlot() {
		return confRxPlot;
	}

	public void setConfRxPlot(String confRxPlot) {
		this.confRxPlot = confRxPlot;
	}

	public String getConfRxInterface() {
		return confRxInterface;
	}

	public void setConfRxInterface(String confRxInterface) {
		this.confRxInterface = confRxInterface;
	}

	public String getConfCircuitName() {
		return confCircuitName;
	}

	public void setConfCircuitName(String confCircuitName) {
		this.confCircuitName = confCircuitName;
	}

	public String getConfSpeed() {
		return confSpeed;
	}

	public void setConfSpeed(String confSpeed) {
		this.confSpeed = confSpeed;
	}

	public String getConfCommunicateWay() {
		return confCommunicateWay;
	}

	public void setConfCommunicateWay(String confCommunicateWay) {
		this.confCommunicateWay = confCommunicateWay;
	}

	public String getConfUsage() {
		return confUsage;
	}

	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
	}

	public String getConfNo() {
		return confNo;
	}

	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}
	
}
