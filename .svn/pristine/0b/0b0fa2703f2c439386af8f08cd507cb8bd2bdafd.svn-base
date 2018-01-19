/**
 * @ProjectName IOMS
 * @FileName OduPolling.java
 * @PackageName:cn.com.atnc.ioms.entity.operstat.odu
 * @author KuYonggang
 * @date 2015年4月1日下午2:06:16
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.maintain.pollinginfo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;

/**
 * odu轮询数据实体类
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午2:06:16
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_POLLING_ODU")
public class OduPolling extends MyStringUUIDEntity{

	private static final long serialVersionUID = 1L;
	
	private MaintainEquip equipId;// 告警关联设备id
	private String model;
	private String v12;
	private String fan;
	private String neg5vSupply;
	private String pos5vSupply;
	private String ftllock;
	private String ftlpll;
	private String pa1;
	private String pa2;
	private String pa3;
	private String pa4;
	private String pa5;
	private String pa6;
	private String txRequest;
	private String status;
	private String txChannel;
	private String txChannelMhz;
	private String txGain;
	private String txInput;
	private String txOutput;
	private String txPeakOutput;
	private String txPaTemp;
	private String txMute;
	private String synTxLock;
	private String synTxpll;
	private String synTxopll;
	private String rxChannel;
	private String rxChannelMhz;
	private String rxGain;
	private String rxIfPowerOut;
	private String rxLnb;
	private String synRx;
	private String synRxpll;
	private String alarmInfo;  
	private Date recordTime;
	
	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getV12() {
		return v12;
	}
	public void setV12(String v12) {
		this.v12 = v12;
	}
	public String getFan() {
		return fan;
	}
	public void setFan(String fan) {
		this.fan = fan;
	}
	public String getNeg5vSupply() {
		return neg5vSupply;
	}
	public void setNeg5vSupply(String neg5vSupply) {
		this.neg5vSupply = neg5vSupply;
	}
	public String getPos5vSupply() {
		return pos5vSupply;
	}
	public void setPos5vSupply(String pos5vSupply) {
		this.pos5vSupply = pos5vSupply;
	}
	public String getFtllock() {
		return ftllock;
	}
	public void setFtllock(String ftllock) {
		this.ftllock = ftllock;
	}
	public String getFtlpll() {
		return ftlpll;
	}
	public void setFtlpll(String ftlpll) {
		this.ftlpll = ftlpll;
	}
	public String getPa1() {
		return pa1;
	}
	public void setPa1(String pa1) {
		this.pa1 = pa1;
	}
	public String getPa2() {
		return pa2;
	}
	public void setPa2(String pa2) {
		this.pa2 = pa2;
	}
	public String getPa3() {
		return pa3;
	}
	public void setPa3(String pa3) {
		this.pa3 = pa3;
	}
	public String getPa4() {
		return pa4;
	}
	public void setPa4(String pa4) {
		this.pa4 = pa4;
	}
	public String getPa5() {
		return pa5;
	}
	public void setPa5(String pa5) {
		this.pa5 = pa5;
	}
	public String getPa6() {
		return pa6;
	}
	public void setPa6(String pa6) {
		this.pa6 = pa6;
	}
	public String getTxRequest() {
		return txRequest;
	}
	public void setTxRequest(String txRequest) {
		this.txRequest = txRequest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTxChannel() {
		return txChannel;
	}
	public void setTxChannel(String txChannel) {
		this.txChannel = txChannel;
	}
	public String getTxChannelMhz() {
		return txChannelMhz;
	}
	public void setTxChannelMhz(String txChannelMhz) {
		this.txChannelMhz = txChannelMhz;
	}
	public String getTxGain() {
		return txGain;
	}
	public void setTxGain(String txGain) {
		this.txGain = txGain;
	}
	public String getTxInput() {
		return txInput;
	}
	public void setTxInput(String txInput) {
		this.txInput = txInput;
	}
	public String getTxOutput() {
		return txOutput;
	}
	public void setTxOutput(String txOutput) {
		this.txOutput = txOutput;
	}
	public String getTxPeakOutput() {
		return txPeakOutput;
	}
	public void setTxPeakOutput(String txPeakOutput) {
		this.txPeakOutput = txPeakOutput;
	}
	public String getTxPaTemp() {
		return txPaTemp;
	}
	public void setTxPaTemp(String txPaTemp) {
		this.txPaTemp = txPaTemp;
	}
	public String getTxMute() {
		return txMute;
	}
	public void setTxMute(String txMute) {
		this.txMute = txMute;
	}
	public String getSynTxLock() {
		return synTxLock;
	}
	public void setSynTxLock(String synTxLock) {
		this.synTxLock = synTxLock;
	}
	public String getSynTxpll() {
		return synTxpll;
	}
	public void setSynTxpll(String synTxpll) {
		this.synTxpll = synTxpll;
	}
	public String getSynTxopll() {
		return synTxopll;
	}
	public void setSynTxopll(String synTxopll) {
		this.synTxopll = synTxopll;
	}
	public String getRxChannel() {
		return rxChannel;
	}
	public void setRxChannel(String rxChannel) {
		this.rxChannel = rxChannel;
	}
	public String getRxChannelMhz() {
		return rxChannelMhz;
	}
	public void setRxChannelMhz(String rxChannelMhz) {
		this.rxChannelMhz = rxChannelMhz;
	}
	public String getRxGain() {
		return rxGain;
	}
	public void setRxGain(String rxGain) {
		this.rxGain = rxGain;
	}
	public String getRxIfPowerOut() {
		return rxIfPowerOut;
	}
	public void setRxIfPowerOut(String rxIfPowerOut) {
		this.rxIfPowerOut = rxIfPowerOut;
	}
	public String getRxLnb() {
		return rxLnb;
	}
	public void setRxLnb(String rxLnb) {
		this.rxLnb = rxLnb;
	}
	public String getSynRx() {
		return synRx;
	}
	public void setSynRx(String synRx) {
		this.synRx = synRx;
	}
	public String getSynRxpll() {
		return synRxpll;
	}
	public void setSynRxpll(String synRxpll) {
		this.synRxpll = synRxpll;
	}
	public String getAlarmInfo() {
		return alarmInfo;
	}
	public void setAlarmInfo(String alarmInfo) {
		this.alarmInfo = alarmInfo;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}  

}
