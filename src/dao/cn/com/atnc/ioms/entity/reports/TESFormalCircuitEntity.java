/**
 * @ProjectName PCSP
 * @FileName TESFormalCircuitEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年6月16日下午3:28:57
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * TES正式电路申请
 * @author WangLingbin
 * @date 2015年6月16日 下午3:28:57
 * @since 1.0.0
 */
public class TESFormalCircuitEntity {

	private String identifier;  //编号
	private String businessName;  //业务名称
	private String txSiteName;  //本端站点名
	private String txCaseNum;  //本端机箱号
	private String txSlotNum;  //本端槽位号
	private String rxSiteName;  //对端站点名
	private String rxCaseNum;  //对端机箱号
	private String rxSlotNum;  //对端槽位号
	private String circuitSpeed;  //电路速率
	private String communicateWay;  //通信方式
	private Date openTime;  //要求开通时间
	
	//--------------------配置表参数-------------------------
	private String confTxSiteName;			//配置表-本端站点名
	private String confTxCaseNum;			//配置表-本端机箱号
	private String confTxSlotNum;			//配置表-本端槽位号
	private String confTxInterface;			//配置表-本端接口类型
	
	private String confRxSiteName;			//配置表-对端站点名
	private String confRxCaseNum;			//配置表-对端机箱号
	private String confRxSlotNum;			//配置表-对端槽位号
	private String confRxInterface;			//配置表-对端接口类型
	private String confCircuitName;			//配置表-电路名称
	private String confSpeed;				//配置表-电路速率
	private String confCommunicateWay;  //配置表-通信方式
	private String confClock;				//配置表-时钟方式
	private String confNo;					//配置表-电路编号
	private String confUsage;				//配置表-电路用途
	
	
	public TESFormalCircuitEntity() {
		super();
	}
	public TESFormalCircuitEntity(String identifier, String businessName,
			String txSiteName, String txCaseNum, String txSlotNum,
			String rxSiteName, String rxCaseNum, String rxSlotNum,
			String circuitSpeed, String communicateWay, Date openTime) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txSiteName = txSiteName;
		this.txCaseNum = txCaseNum;
		this.txSlotNum = txSlotNum;
		this.rxSiteName = rxSiteName;
		this.rxCaseNum = rxCaseNum;
		this.rxSlotNum = rxSlotNum;
		this.circuitSpeed = circuitSpeed;
		this.communicateWay = communicateWay;
		this.openTime = openTime;
	}

	
	public TESFormalCircuitEntity(String identifier, String confTxSiteName,
			String confTxCaseNum, String confTxSlotNum, String confTxInterface,
			String confRxSiteName, String confRxCaseNum, String confRxSlotNum,
			String confRxInterface, String confCircuitName, String confSpeed,
			String confCommunicateWay, String confClock, String confNo,
			String confUsage) {
		super();
		this.identifier = identifier;
		this.confTxSiteName = confTxSiteName;
		this.confTxCaseNum = confTxCaseNum;
		this.confTxSlotNum = confTxSlotNum;
		this.confTxInterface = confTxInterface;
		this.confRxSiteName = confRxSiteName;
		this.confRxCaseNum = confRxCaseNum;
		this.confRxSlotNum = confRxSlotNum;
		this.confRxInterface = confRxInterface;
		this.confCircuitName = confCircuitName;
		this.confSpeed = confSpeed;
		this.confCommunicateWay = confCommunicateWay;
		this.confClock = confClock;
		this.confNo = confNo;
		this.confUsage = confUsage;
	}
	public TESFormalCircuitEntity(String identifier, String businessName,
			String txSiteName, String txCaseNum, String txSlotNum,
			String rxSiteName, String rxCaseNum, String rxSlotNum,
			String circuitSpeed, String communicateWay, Date openTime,
			String confTxSiteName, String confTxCaseNum, String confTxSlotNum,
			String confTxInterface, String confRxSiteName,
			String confRxCaseNum, String confRxSlotNum, String confRxInterface,
			String confCircuitName, String confSpeed,
			String confCommunicateWay, String confClock, String confNo,
			String confUsage) {
		super();
		this.identifier = identifier;
		this.businessName = businessName;
		this.txSiteName = txSiteName;
		this.txCaseNum = txCaseNum;
		this.txSlotNum = txSlotNum;
		this.rxSiteName = rxSiteName;
		this.rxCaseNum = rxCaseNum;
		this.rxSlotNum = rxSlotNum;
		this.circuitSpeed = circuitSpeed;
		this.communicateWay = communicateWay;
		this.openTime = openTime;
		this.confTxSiteName = confTxSiteName;
		this.confTxCaseNum = confTxCaseNum;
		this.confTxSlotNum = confTxSlotNum;
		this.confTxInterface = confTxInterface;
		this.confRxSiteName = confRxSiteName;
		this.confRxCaseNum = confRxCaseNum;
		this.confRxSlotNum = confRxSlotNum;
		this.confRxInterface = confRxInterface;
		this.confCircuitName = confCircuitName;
		this.confSpeed = confSpeed;
		this.confCommunicateWay = confCommunicateWay;
		this.confClock = confClock;
		this.confNo = confNo;
		this.confUsage = confUsage;
	}
	public String getConfTxSiteName() {
		return confTxSiteName;
	}
	public void setConfTxSiteName(String confTxSiteName) {
		this.confTxSiteName = confTxSiteName;
	}
	public String getConfTxCaseNum() {
		return confTxCaseNum;
	}
	public void setConfTxCaseNum(String confTxCaseNum) {
		this.confTxCaseNum = confTxCaseNum;
	}
	public String getConfTxSlotNum() {
		return confTxSlotNum;
	}
	public void setConfTxSlotNum(String confTxSlotNum) {
		this.confTxSlotNum = confTxSlotNum;
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
	public String getConfRxCaseNum() {
		return confRxCaseNum;
	}
	public void setConfRxCaseNum(String confRxCaseNum) {
		this.confRxCaseNum = confRxCaseNum;
	}
	public String getConfRxSlotNum() {
		return confRxSlotNum;
	}
	public void setConfRxSlotNum(String confRxSlotNum) {
		this.confRxSlotNum = confRxSlotNum;
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
	public String getConfClock() {
		return confClock;
	}
	public void setConfClock(String confClock) {
		this.confClock = confClock;
	}
	public String getConfNo() {
		return confNo;
	}
	public void setConfNo(String confNo) {
		this.confNo = confNo;
	}
	public String getConfUsage() {
		return confUsage;
	}
	public void setConfUsage(String confUsage) {
		this.confUsage = confUsage;
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
	public String getTxSiteName() {
		return txSiteName;
	}
	public void setTxSiteName(String txSiteName) {
		this.txSiteName = txSiteName;
	}
	public String getTxCaseNum() {
		return txCaseNum;
	}
	public void setTxCaseNum(String txCaseNum) {
		this.txCaseNum = txCaseNum;
	}
	public String getTxSlotNum() {
		return txSlotNum;
	}
	public void setTxSlotNum(String txSlotNum) {
		this.txSlotNum = txSlotNum;
	}
	public String getRxSiteName() {
		return rxSiteName;
	}
	public void setRxSiteName(String rxSiteName) {
		this.rxSiteName = rxSiteName;
	}
	public String getRxCaseNum() {
		return rxCaseNum;
	}
	public void setRxCaseNum(String rxCaseNum) {
		this.rxCaseNum = rxCaseNum;
	}
	public String getRxSlotNum() {
		return rxSlotNum;
	}
	public void setRxSlotNum(String rxSlotNum) {
		this.rxSlotNum = rxSlotNum;
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
	
}
