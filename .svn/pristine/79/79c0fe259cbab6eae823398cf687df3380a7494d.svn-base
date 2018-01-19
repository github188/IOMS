/**
 * @ProjectName IOMS
 * @FileName KuNodeParameter.java
 * @PackageName:cn.com.atnc.ioms.entity.operstat.ku
 * @author KuYonggang
 * @date 2015年4月1日上午10:58:32
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
 * KuModem板卡数据
 *
 * @author KuYonggang
 * @date 2015年4月1日 上午10:58:32
 * @since 1.0.0
 */
@Entity
@Table(name="TB_BD_POLLING_KU_NODEPARAM")
public class KuNodeParameter extends MyStringUUIDEntity{

	private static final long serialVersionUID = 1L;
	
	private MaintainEquip equipId;// 告警关联设备id
	private String slot;
	private String nodeName;
	private String nodeNumber;
	private String gatewayNodeNumber;
	private String nominalFrameDelay;
	private String nominalPhaseOffset;
	private String manualFrameDelay;
	private String manualPhaseOffset;
	private String romVersion;
	private String flashVersion;
	private String acquisitionMethod;
	private String autoRangeCalculation;
	private String codeVersion;
	private String cscBurstSize;
	private String cscsPerFrame;
	private String localElevation;
	private String localLatitudeDeg;
	private String localLatitudeMin;
	private String localLatitudeNS;
	private String localLatitudeSec;
	private String localLongitudeDeg;
	private String localLongitudeEW;
	private String localLongitudeMin;
	private String localLongitudeSec;
	private String maximunNodesInNetwork;
	private String redundantChassis;
	private String roundTripCalibration;
	private String satelliteLongitudeDeg;
	private String satelliteLongitudeEW;
	private String satelliteLongitudeMin;
	private String satelliteLongitudeSec;
	private String superframeSize;
	private String bitRate;
	private String frameSize;
	private String frameTime;
	private Date recordTime;

	@ManyToOne
	@JoinColumn(name = "equip_id")
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeNumber() {
		return nodeNumber;
	}
	public void setNodeNumber(String nodeNumber) {
		this.nodeNumber = nodeNumber;
	}
	public String getGatewayNodeNumber() {
		return gatewayNodeNumber;
	}
	public void setGatewayNodeNumber(String gatewayNodeNumber) {
		this.gatewayNodeNumber = gatewayNodeNumber;
	}
	public String getNominalFrameDelay() {
		return nominalFrameDelay;
	}
	public void setNominalFrameDelay(String nominalFrameDelay) {
		this.nominalFrameDelay = nominalFrameDelay;
	}
	public String getNominalPhaseOffset() {
		return nominalPhaseOffset;
	}
	public void setNominalPhaseOffset(String nominalPhaseOffset) {
		this.nominalPhaseOffset = nominalPhaseOffset;
	}
	public String getManualFrameDelay() {
		return manualFrameDelay;
	}
	public void setManualFrameDelay(String manualFrameDelay) {
		this.manualFrameDelay = manualFrameDelay;
	}
	public String getManualPhaseOffset() {
		return manualPhaseOffset;
	}
	public void setManualPhaseOffset(String manualPhaseOffset) {
		this.manualPhaseOffset = manualPhaseOffset;
	}
	public String getRomVersion() {
		return romVersion;
	}
	public void setRomVersion(String romVersion) {
		this.romVersion = romVersion;
	}
	public String getFlashVersion() {
		return flashVersion;
	}
	public void setFlashVersion(String flashVersion) {
		this.flashVersion = flashVersion;
	}
	public String getAcquisitionMethod() {
		return acquisitionMethod;
	}
	public void setAcquisitionMethod(String acquisitionMethod) {
		this.acquisitionMethod = acquisitionMethod;
	}
	public String getAutoRangeCalculation() {
		return autoRangeCalculation;
	}
	public void setAutoRangeCalculation(String autoRangeCalculation) {
		this.autoRangeCalculation = autoRangeCalculation;
	}
	public String getCodeVersion() {
		return codeVersion;
	}
	public void setCodeVersion(String codeVersion) {
		this.codeVersion = codeVersion;
	}
	public String getCscBurstSize() {
		return cscBurstSize;
	}
	public void setCscBurstSize(String cscBurstSize) {
		this.cscBurstSize = cscBurstSize;
	}
	public String getCscsPerFrame() {
		return cscsPerFrame;
	}
	public void setCscsPerFrame(String cscsPerFrame) {
		this.cscsPerFrame = cscsPerFrame;
	}
	public String getLocalElevation() {
		return localElevation;
	}
	public void setLocalElevation(String localElevation) {
		this.localElevation = localElevation;
	}
	public String getLocalLatitudeDeg() {
		return localLatitudeDeg;
	}
	public void setLocalLatitudeDeg(String localLatitudeDeg) {
		this.localLatitudeDeg = localLatitudeDeg;
	}
	public String getLocalLatitudeMin() {
		return localLatitudeMin;
	}
	public void setLocalLatitudeMin(String localLatitudeMin) {
		this.localLatitudeMin = localLatitudeMin;
	}
	public String getLocalLatitudeNS() {
		return localLatitudeNS;
	}
	public void setLocalLatitudeNS(String localLatitudeNS) {
		this.localLatitudeNS = localLatitudeNS;
	}
	public String getLocalLatitudeSec() {
		return localLatitudeSec;
	}
	public void setLocalLatitudeSec(String localLatitudeSec) {
		this.localLatitudeSec = localLatitudeSec;
	}
	public String getLocalLongitudeDeg() {
		return localLongitudeDeg;
	}
	public void setLocalLongitudeDeg(String localLongitudeDeg) {
		this.localLongitudeDeg = localLongitudeDeg;
	}
	public String getLocalLongitudeEW() {
		return localLongitudeEW;
	}
	public void setLocalLongitudeEW(String localLongitudeEW) {
		this.localLongitudeEW = localLongitudeEW;
	}
	public String getLocalLongitudeMin() {
		return localLongitudeMin;
	}
	public void setLocalLongitudeMin(String localLongitudeMin) {
		this.localLongitudeMin = localLongitudeMin;
	}
	public String getLocalLongitudeSec() {
		return localLongitudeSec;
	}
	public void setLocalLongitudeSec(String localLongitudeSec) {
		this.localLongitudeSec = localLongitudeSec;
	}
	public String getMaximunNodesInNetwork() {
		return maximunNodesInNetwork;
	}
	public void setMaximunNodesInNetwork(String maximunNodesInNetwork) {
		this.maximunNodesInNetwork = maximunNodesInNetwork;
	}
	public String getRedundantChassis() {
		return redundantChassis;
	}
	public void setRedundantChassis(String redundantChassis) {
		this.redundantChassis = redundantChassis;
	}
	public String getRoundTripCalibration() {
		return roundTripCalibration;
	}
	public void setRoundTripCalibration(String roundTripCalibration) {
		this.roundTripCalibration = roundTripCalibration;
	}
	public String getSatelliteLongitudeDeg() {
		return satelliteLongitudeDeg;
	}
	public void setSatelliteLongitudeDeg(String satelliteLongitudeDeg) {
		this.satelliteLongitudeDeg = satelliteLongitudeDeg;
	}
	public String getSatelliteLongitudeEW() {
		return satelliteLongitudeEW;
	}
	public void setSatelliteLongitudeEW(String satelliteLongitudeEW) {
		this.satelliteLongitudeEW = satelliteLongitudeEW;
	}
	public String getSatelliteLongitudeMin() {
		return satelliteLongitudeMin;
	}
	public void setSatelliteLongitudeMin(String satelliteLongitudeMin) {
		this.satelliteLongitudeMin = satelliteLongitudeMin;
	}
	public String getSatelliteLongitudeSec() {
		return satelliteLongitudeSec;
	}
	public void setSatelliteLongitudeSec(String satelliteLongitudeSec) {
		this.satelliteLongitudeSec = satelliteLongitudeSec;
	}
	public String getSuperframeSize() {
		return superframeSize;
	}
	public void setSuperframeSize(String superframeSize) {
		this.superframeSize = superframeSize;
	}
	public String getBitRate() {
		return bitRate;
	}
	public void setBitRate(String bitRate) {
		this.bitRate = bitRate;
	}
	public String getFrameSize() {
		return frameSize;
	}
	public void setFrameSize(String frameSize) {
		this.frameSize = frameSize;
	}
	public String getFrameTime() {
		return frameTime;
	}
	public void setFrameTime(String frameTime) {
		this.frameTime = frameTime;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
