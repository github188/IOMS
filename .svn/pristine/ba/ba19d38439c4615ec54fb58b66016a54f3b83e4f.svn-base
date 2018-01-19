/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteReortModel.java
 * @PackageName:cn.com.atnc.pcsp.model.business.satellite
 * @author ku
 * @date 2015年6月4日下午6:05:16
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.model.business.satellite;

import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * ku入网申请报表数据模型
 *
 * @author ku
 * @date 2015年6月4日 下午6:05:16
 * @since 1.0.0
 */
public class KuSatelliteReortModel {

	private String applyCom;      //申请单位
	private String serialNumber;			//申请编号
	private String applyLinkman;  //联系人
	private String applyPhone;     //联系电话
	private String applyFax;     //传真
	private String applyComSign; //公司签字
	private String rxSiteName;   //远端站点名称
	private String rxSiteAddress; //远端站点地址
	private String od;  //维度-度
	private String om;  //维度-分
	private String os;  //维度-秒
	private String ad;   //经度-度
	private String am;   //经度-分
	private String as;   //经度-秒
	private String height;        //海拔高度
	private String position;      //方位角
	private String pitching;      //俯仰角
	private String polarization;  //极化角
	private String antennaModel;  //天线厂家及型号
	private String antennaDiameter; //口径
	private String outdoorModel; //室外单元厂家及型号
	private String launchPower;  //放射功率
	private String vsatPlusllNum;  //室内单元信息
	private String vsatPluslleNum; //室内单元信息
	private String length;         //电缆长度
	private String initApproveCom; //初审公司
	private String initApproveSign;//负责人签字
	private String initApproveOpinion; //初审意见
	private String initLinkman;		//初审意见：联系人
	private String initLinkphone;	//初审意见：联系电话
	private String finalApproveCom; //终审单位
	private String finalApproveSign;//负责人签字
	private String finalApproveOpinion;//终审意见
	private String finalLinkman;		//初审意见：联系人
	private String finalLinkphone;	//初审意见：联系电话
	private String applyDate;	  //申请日期
	//配置信息
	private String node;					//节点号
	private String mediumFrequency;			//0号载波中频频点
	private String emissionFrequency;		//射频发射频率
	private String receiveFrequency;		//射频接收频率
	
	public KuSatelliteReortModel() {
	}
	
	public KuSatelliteReortModel(String applyCom, String serialNumber, String applyLinkman,
			String applyPhone, String applyFax, String applyComSign,
			String rxSiteName, String rxSiteAddress, String od, String om,
			String os, String ad, String am, String as, String height,
			String position, String pitching, String polarization,
			String antennaModel, String antennaDiameter, String outdoorModel,
			String launchPower, String vsatPlusllNum, String vsatPluslleNum,
			String length, String initApproveCom, String initApproveSign,
			String initApproveOpinion, String initLinkman,
			String initLinkphone, String finalApproveCom,
			String finalApproveSign, String finalApproveOpinion,
			String finalLinkman, String finalLinkphone, String applyDate,
			String node, String mediumFrequency, String emissionFrequency,
			String receiveFrequency) {
		super();
		this.applyCom = applyCom;
		this.serialNumber = serialNumber;
		this.applyLinkman = applyLinkman;
		this.applyPhone = applyPhone;
		this.applyFax = applyFax;
		this.applyComSign = applyComSign;
		this.rxSiteName = rxSiteName;
		this.rxSiteAddress = rxSiteAddress;
		this.od = od;
		this.om = om;
		this.os = os;
		this.ad = ad;
		this.am = am;
		this.as = as;
		this.height = height;
		this.position = position;
		this.pitching = pitching;
		this.polarization = polarization;
		this.antennaModel = antennaModel;
		this.antennaDiameter = antennaDiameter;
		this.outdoorModel = outdoorModel;
		this.launchPower = launchPower;
		this.vsatPlusllNum = vsatPlusllNum;
		this.vsatPluslleNum = vsatPluslleNum;
		this.length = length;
		this.initApproveCom = initApproveCom;
		this.initApproveSign = initApproveSign;
		this.initApproveOpinion = initApproveOpinion;
		this.initLinkman = initLinkman;
		this.initLinkphone = initLinkphone;
		this.finalApproveCom = finalApproveCom;
		this.finalApproveSign = finalApproveSign;
		this.finalApproveOpinion = finalApproveOpinion;
		this.finalLinkman = finalLinkman;
		this.finalLinkphone = finalLinkphone;
		this.applyDate = applyDate;
		this.node = node;
		this.mediumFrequency = mediumFrequency;
		this.emissionFrequency = emissionFrequency;
		this.receiveFrequency = receiveFrequency;
	}

	/**
	 *
	 */
	public KuSatelliteReortModel(KuSatellite kuSatellite) {
		super();
		this.applyCom = kuSatellite.getApplyBaseInfo().getApplyCom()==null?"":kuSatellite.getApplyBaseInfo().getApplyCom();
		this.serialNumber = kuSatellite.getApplyBaseInfo().getSerialNumber();
		this.applyLinkman = kuSatellite.getApplyBaseInfo().getApplyLinkman()==null?"":kuSatellite.getApplyBaseInfo().getApplyLinkman();
		this.applyPhone = kuSatellite.getApplyBaseInfo().getApplyPhone()==null?"":kuSatellite.getApplyBaseInfo().getApplyPhone();
		this.applyFax = kuSatellite.getApplyBaseInfo().getApplyFax()==null?"":kuSatellite.getApplyBaseInfo().getApplyFax();
		this.applyComSign = kuSatellite.getApplyComSign()==null?"":kuSatellite.getApplyComSign();
		this.rxSiteName = kuSatellite.getTxSiteName()==null?"":kuSatellite.getTxSiteName();
		this.rxSiteAddress = kuSatellite.getRxSiteAddress()==null?"":kuSatellite.getRxSiteAddress();
		this.od = kuSatellite.getLongitudeDeg()==null?"":kuSatellite.getLongitudeDeg();
		this.om = kuSatellite.getLongitudeMin()==null?"":kuSatellite.getLongitudeMin();
		this.os = kuSatellite.getLongitudeSec()==null?"":kuSatellite.getLongitudeSec();
		this.ad = kuSatellite.getLatitudeDeg()==null?"":kuSatellite.getLatitudeDeg();
		this.am = kuSatellite.getLatitudeMin()==null?"":kuSatellite.getLatitudeMin();
		this.as = kuSatellite.getLatitudeSec()==null?"":kuSatellite.getLatitudeSec();
		this.height = kuSatellite.getHeight()==null?"":kuSatellite.getHeight();
		this.position = kuSatellite.getPosition()==null?"":kuSatellite.getPosition();
		this.pitching = kuSatellite.getPitching()==null?"":kuSatellite.getPitching();
		this.polarization = kuSatellite.getPolarization()==null?"":kuSatellite.getPolarization();
		this.antennaModel = kuSatellite.getAntennaModel()==null?"":kuSatellite.getAntennaModel();
		this.antennaDiameter = kuSatellite.getAntennaDiameter()==null?"":kuSatellite.getAntennaDiameter();
		this.outdoorModel = kuSatellite.getOutdoorModel()==null?"":kuSatellite.getOutdoorModel();
		this.launchPower = kuSatellite.getLaunchPower()==null?"":kuSatellite.getLaunchPower();
		this.vsatPlusllNum = kuSatellite.getVsatPlusllNum()==null?"":kuSatellite.getVsatPlusllNum();
		this.vsatPluslleNum = kuSatellite.getVsatPluslleNum()==null?"":kuSatellite.getVsatPluslleNum();
		this.length = kuSatellite.getLength()==null?"":kuSatellite.getLength();
		this.initApproveCom = kuSatellite.getInitApproveCom()==null?"":kuSatellite.getInitApproveCom();
		this.initApproveSign = kuSatellite.getInitApproveSign()==null?"":kuSatellite.getInitApproveSign();
		this.initApproveOpinion = kuSatellite.getInitApproveOpinion()==null?"":kuSatellite.getInitApproveOpinion();
		//this.finalApproveCom = kuSatellite.getFinalApproveCom()==null?"":kuSatellite.getFinalApproveCom();
		this.finalApproveCom = "北京天航信民航通信网络发展有限公司";
		//this.finalApproveSign = kuSatellite.getFinalApproveSign()==null?"":kuSatellite.getFinalApproveSign();
		this.finalApproveSign = null;
		this.finalApproveOpinion = kuSatellite.getFinalApproveOpinion()==null?"":kuSatellite.getFinalApproveOpinion();
		this.applyDate = DateUtilTools.format(kuSatellite.getApplyBaseInfo().getApplyDate().getTime());
		//赋值联系人和联系电话
		this.initLinkman = kuSatellite.getApplyBaseInfo().getInitLinkman();
		this.initLinkphone = kuSatellite.getApplyBaseInfo().getInitLinkphone();
		this.finalLinkman = kuSatellite.getApplyBaseInfo().getFinalLinkman();
		this.finalLinkphone = kuSatellite.getApplyBaseInfo().getFinalLinkphone();
	}
	public String getApplyCom() {
		return applyCom;
	}
	public void setApplyCom(String applyCom) {
		this.applyCom = applyCom;
	}
	public String getApplyLinkman() {
		return applyLinkman;
	}
	public void setApplyLinkman(String applyLinkman) {
		this.applyLinkman = applyLinkman;
	}
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	public String getApplyFax() {
		return applyFax;
	}
	public void setApplyFax(String applyFax) {
		this.applyFax = applyFax;
	}
	public String getApplyComSign() {
		return applyComSign;
	}
	public void setApplyComSign(String applyComSign) {
		this.applyComSign = applyComSign;
	}
	public String getRxSiteName() {
		return rxSiteName;
	}
	public void setRxSiteName(String rxSiteName) {
		this.rxSiteName = rxSiteName;
	}
	public String getRxSiteAddress() {
		return rxSiteAddress;
	}
	public void setRxSiteAddress(String rxSiteAddress) {
		this.rxSiteAddress = rxSiteAddress;
	}
	public String getOd() {
		return od;
	}
	public void setOd(String od) {
		this.od = od;
	}
	public String getOm() {
		return om;
	}
	public void setOm(String om) {
		this.om = om;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public String getAs() {
		return as;
	}
	public void setAs(String as) {
		this.as = as;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPitching() {
		return pitching;
	}
	public void setPitching(String pitching) {
		this.pitching = pitching;
	}
	public String getPolarization() {
		return polarization;
	}
	public void setPolarization(String polarization) {
		this.polarization = polarization;
	}
	public String getAntennaModel() {
		return antennaModel;
	}
	public void setAntennaModel(String antennaModel) {
		this.antennaModel = antennaModel;
	}
	public String getAntennaDiameter() {
		return antennaDiameter;
	}
	public void setAntennaDiameter(String antennaDiameter) {
		this.antennaDiameter = antennaDiameter;
	}
	public String getOutdoorModel() {
		return outdoorModel;
	}
	public void setOutdoorModel(String outdoorModel) {
		this.outdoorModel = outdoorModel;
	}
	public String getLaunchPower() {
		return launchPower;
	}
	public void setLaunchPower(String launchPower) {
		this.launchPower = launchPower;
	}
	public String getVsatPlusllNum() {
		return vsatPlusllNum;
	}
	public void setVsatPlusllNum(String vsatPlusllNum) {
		this.vsatPlusllNum = vsatPlusllNum;
	}
	public String getVsatPluslleNum() {
		return vsatPluslleNum;
	}
	public void setVsatPluslleNum(String vsatPluslleNum) {
		this.vsatPluslleNum = vsatPluslleNum;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getInitApproveCom() {
		return initApproveCom;
	}
	public void setInitApproveCom(String initApproveCom) {
		this.initApproveCom = initApproveCom;
	}
	public String getInitApproveSign() {
		return initApproveSign;
	}
	public void setInitApproveSign(String initApproveSign) {
		this.initApproveSign = initApproveSign;
	}
	public String getInitApproveOpinion() {
		return initApproveOpinion;
	}
	public void setInitApproveOpinion(String initApproveOpinion) {
		this.initApproveOpinion = initApproveOpinion;
	}
	public String getFinalApproveCom() {
		return finalApproveCom;
	}
	public void setFinalApproveCom(String finalApproveCom) {
		this.finalApproveCom = finalApproveCom;
	}
	public String getFinalApproveSign() {
		return finalApproveSign;
	}
	public void setFinalApproveSign(String finalApproveSign) {
		this.finalApproveSign = finalApproveSign;
	}
	public String getFinalApproveOpinion() {
		return finalApproveOpinion;
	}
	public void setFinalApproveOpinion(String finalApproveOpinion) {
		this.finalApproveOpinion = finalApproveOpinion;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getInitLinkman() {
		return initLinkman;
	}

	public void setInitLinkman(String initLinkman) {
		this.initLinkman = initLinkman;
	}

	public String getInitLinkphone() {
		return initLinkphone;
	}

	public void setInitLinkphone(String initLinkphone) {
		this.initLinkphone = initLinkphone;
	}

	public String getFinalLinkman() {
		return finalLinkman;
	}

	public void setFinalLinkman(String finalLinkman) {
		this.finalLinkman = finalLinkman;
	}

	public String getFinalLinkphone() {
		return finalLinkphone;
	}

	public void setFinalLinkphone(String finalLinkphone) {
		this.finalLinkphone = finalLinkphone;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getMediumFrequency() {
		return mediumFrequency;
	}

	public void setMediumFrequency(String mediumFrequency) {
		this.mediumFrequency = mediumFrequency;
	}

	public String getEmissionFrequency() {
		return emissionFrequency;
	}

	public void setEmissionFrequency(String emissionFrequency) {
		this.emissionFrequency = emissionFrequency;
	}

	public String getReceiveFrequency() {
		return receiveFrequency;
	}

	public void setReceiveFrequency(String receiveFrequency) {
		this.receiveFrequency = receiveFrequency;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}
