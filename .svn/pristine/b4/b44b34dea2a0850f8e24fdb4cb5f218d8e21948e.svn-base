/**
 * @ProjectName IOMS
 * @FileName Wafr08Port0Stat.java
 * @PackageName:cn.com.atnc.ioms.entity.operstat.wafr08
 * @author KuYonggang
 * @date 2015年4月1日下午2:04:23
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
 * Wafr08Port0统计信息实体类
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午2:04:23
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_POLLING_WAFR08")
public class Wafr08Port0Stat extends MyStringUUIDEntity{
	
	private static final long serialVersionUID = 1L;
	
	private MaintainEquip equipId;// 告警关联设备id
	private String portNumber;
    private String portType;
    private String portStatus;
    private String portSpeed;
    private String lmiType;
    private String charactersIN;
    private String charactersOUT;
    private String charactersSecIN;
    private String charactersSecOUT;
    private String currCharactersSecIN;
    private String currCharactersSecOUT;
    private String framesIN;
    private String framesOUT;
    private String framesecIN;
    private String framesecOUT;
    private String avFrsizeIN;
    private String avFrsizeOUT;
    private String crcErrors;
    private String abortErrors;
    private String unknownDLCIcount;
    private String discardFramecount;
    private String dtr;
    private String rts;
    private String dsr;
    private String cts;
    private String dcd;
    private String charactersRatio; //字节比值
    private String currBitErr;      //实时误码率
    private String totalBitErr;     //统计误码率
    private Date recordTime;
    
	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public String getPortType() {
		return portType;
	}
	public void setPortType(String portType) {
		this.portType = portType;
	}
	public String getPortStatus() {
		return portStatus;
	}
	public void setPortStatus(String portStatus) {
		this.portStatus = portStatus;
	}
	public String getPortSpeed() {
		return portSpeed;
	}
	public void setPortSpeed(String portSpeed) {
		this.portSpeed = portSpeed;
	}
	public String getLmiType() {
		return lmiType;
	}
	public void setLmiType(String lmiType) {
		this.lmiType = lmiType;
	}
	public String getCharactersIN() {
		return charactersIN;
	}
	public void setCharactersIN(String charactersIN) {
		this.charactersIN = charactersIN;
	}
	public String getCharactersOUT() {
		return charactersOUT;
	}
	public void setCharactersOUT(String charactersOUT) {
		this.charactersOUT = charactersOUT;
	}
	public String getCharactersSecIN() {
		return charactersSecIN;
	}
	public void setCharactersSecIN(String charactersSecIN) {
		this.charactersSecIN = charactersSecIN;
	}
	public String getCharactersSecOUT() {
		return charactersSecOUT;
	}
	public void setCharactersSecOUT(String charactersSecOUT) {
		this.charactersSecOUT = charactersSecOUT;
	}
	public String getCurrCharactersSecIN() {
		return currCharactersSecIN;
	}
	public void setCurrCharactersSecIN(String currCharactersSecIN) {
		this.currCharactersSecIN = currCharactersSecIN;
	}
	public String getCurrCharactersSecOUT() {
		return currCharactersSecOUT;
	}
	public void setCurrCharactersSecOUT(String currCharactersSecOUT) {
		this.currCharactersSecOUT = currCharactersSecOUT;
	}
	public String getFramesIN() {
		return framesIN;
	}
	public void setFramesIN(String framesIN) {
		this.framesIN = framesIN;
	}
	public String getFramesOUT() {
		return framesOUT;
	}
	public void setFramesOUT(String framesOUT) {
		this.framesOUT = framesOUT;
	}
	public String getFramesecIN() {
		return framesecIN;
	}
	public void setFramesecIN(String framesecIN) {
		this.framesecIN = framesecIN;
	}
	public String getFramesecOUT() {
		return framesecOUT;
	}
	public void setFramesecOUT(String framesecOUT) {
		this.framesecOUT = framesecOUT;
	}
	public String getAvFrsizeIN() {
		return avFrsizeIN;
	}
	public void setAvFrsizeIN(String avFrsizeIN) {
		this.avFrsizeIN = avFrsizeIN;
	}
	public String getAvFrsizeOUT() {
		return avFrsizeOUT;
	}
	public void setAvFrsizeOUT(String avFrsizeOUT) {
		this.avFrsizeOUT = avFrsizeOUT;
	}
	public String getCrcErrors() {
		return crcErrors;
	}
	public void setCrcErrors(String crcErrors) {
		this.crcErrors = crcErrors;
	}
	public String getAbortErrors() {
		return abortErrors;
	}
	public void setAbortErrors(String abortErrors) {
		this.abortErrors = abortErrors;
	}
	public String getUnknownDLCIcount() {
		return unknownDLCIcount;
	}
	public void setUnknownDLCIcount(String unknownDLCIcount) {
		this.unknownDLCIcount = unknownDLCIcount;
	}
	public String getDiscardFramecount() {
		return discardFramecount;
	}
	public void setDiscardFramecount(String discardFramecount) {
		this.discardFramecount = discardFramecount;
	}
	public String getDtr() {
		return dtr;
	}
	public void setDtr(String dtr) {
		this.dtr = dtr;
	}
	public String getRts() {
		return rts;
	}
	public void setRts(String rts) {
		this.rts = rts;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts = cts;
	}
	public String getDcd() {
		return dcd;
	}
	public void setDcd(String dcd) {
		this.dcd = dcd;
	}
	public String getCharactersRatio() {
		return charactersRatio;
	}
	public void setCharactersRatio(String charactersRatio) {
		this.charactersRatio = charactersRatio;
	}
	public String getCurrBitErr() {
		return currBitErr;
	}
	public void setCurrBitErr(String currBitErr) {
		this.currBitErr = currBitErr;
	}
	public String getTotalBitErr() {
		return totalBitErr;
	}
	public void setTotalBitErr(String totalBitErr) {
		this.totalBitErr = totalBitErr;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

}
