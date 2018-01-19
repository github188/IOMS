/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteReortModel.java
 * @PackageName:cn.com.atnc.pcsp.model.business.satellite
 * @author ku
 * @date 2015年6月4日下午6:05:16
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.model.business.signoutnet;

import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 退网申请报表model
 *
 * @author 段衍林
 * @2017年1月12日 上午11:10:31
 */
public class SignoutNetReortModel {
	/** 基础信息 */
	private String applyCom; // 申请单位
	private String serialNumber; // 申请编号
	private String applyLinkman; // 联系人
	private String applyPhone; // 联系电话
	private String applyFax; // 传真
	private String applyComSign; // 公司签字
	/** 退网内容 */
	private String siteName; // 站点名称
	private String nodeCodes; // 节点号
	private String siteCode; // 站点代码
	private String subnetType;// 子网类型
	private String caseNum;// 机箱号（可能多个）
	private String nodeNum;// 节点号（可能多个）
	private String siteSystemPES; // 站点所属系统PES
	private String siteSystemTES; // 站点所属系统TES
	private String siteSystemKU; // 站点所属系统KU
	private String dealType; // 退网操作类型
	private String reason; // 退网原因
	private String equip; // 退网设备
	private String caseAndNodeNums; // 机箱号和节点号拼接字段
	/** 审批内容 */
	private String initApproveCom; // 初审公司
	private String initApproveSign;// 负责人签字
	private String initApproveOpinion; // 初审意见
	private String initLinkman; // 初审意见：联系人
	private String initLinkphone; // 初审意见：联系电话
	private String finalApproveCom; // 终审单位
	private String finalApproveSign;// 负责人签字
	private String finalApproveOpinion;// 终审意见
	private String finalLinkman; // 初审意见：联系人
	private String finalLinkphone; // 初审意见：联系电话
	private String applyDate; // 申请日期

	public SignoutNetReortModel() {
		super();
	}

	public SignoutNetReortModel(String applyCom, String serialNumber,
			String applyLinkman, String applyPhone, String applyFax,
			String applyComSign, String siteName, String nodeCodes,
			String siteCode, String subnetType, String caseNum, String nodeNum,
			String siteSystemPES, String siteSystemTES, String siteSystemKU,
			String dealType, String reason, String equip,
			String caseAndNodeNums, String initApproveCom,
			String initApproveSign, String initApproveOpinion,
			String initLinkman, String initLinkphone, String finalApproveCom,
			String finalApproveSign, String finalApproveOpinion,
			String finalLinkman, String finalLinkphone, String applyDate) {
		super();
		this.applyCom = applyCom;
		this.serialNumber = serialNumber;
		this.applyLinkman = applyLinkman;
		this.applyPhone = applyPhone;
		this.applyFax = applyFax;
		this.applyComSign = applyComSign;
		this.siteName = siteName;
		this.nodeCodes = nodeCodes;
		this.siteCode = siteCode;
		this.subnetType = subnetType;
		this.caseNum = caseNum;
		this.nodeNum = nodeNum;
		this.siteSystemPES = siteSystemPES;
		this.siteSystemTES = siteSystemTES;
		this.siteSystemKU = siteSystemKU;
		this.dealType = dealType;
		this.reason = reason;
		this.equip = equip;
		this.caseAndNodeNums = caseAndNodeNums;
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
	}

	@Override
	public String toString() {
		return "SignoutNetReortModel [applyCom=" + applyCom + ", serialNumber="
				+ serialNumber + ", applyLinkman=" + applyLinkman
				+ ", applyPhone=" + applyPhone + ", applyFax=" + applyFax
				+ ", applyComSign=" + applyComSign + ", siteName=" + siteName
				+ ", nodeCodes=" + nodeCodes + ", siteCode=" + siteCode
				+ ", subnetType=" + subnetType + ", caseNum=" + caseNum
				+ ", nodeNum=" + nodeNum + ", siteSystemPES=" + siteSystemPES
				+ ", siteSystemTES=" + siteSystemTES + ", siteSystemKU="
				+ siteSystemKU + ", dealType=" + dealType + ", reason="
				+ reason + ", equip=" + equip + ", initApproveCom="
				+ initApproveCom + ", initApproveSign=" + initApproveSign
				+ ", initApproveOpinion=" + initApproveOpinion
				+ ", initLinkman=" + initLinkman + ", initLinkphone="
				+ initLinkphone + ", finalApproveCom=" + finalApproveCom
				+ ", finalApproveSign=" + finalApproveSign
				+ ", finalApproveOpinion=" + finalApproveOpinion
				+ ", finalLinkman=" + finalLinkman + ", finalLinkphone="
				+ finalLinkphone + ", applyDate=" + applyDate + "]";
	}

	public SignoutNetReortModel(SignoutNet signOutNet) {
		super();
		// 基础信息
		this.applyCom = signOutNet.getApplyBaseInfo().getApplyCom() == null ? ""
				: signOutNet.getApplyBaseInfo().getApplyCom();
		this.serialNumber = signOutNet.getApplyBaseInfo().getSerialNumber();
		this.applyLinkman = signOutNet.getApplyBaseInfo().getApplyLinkman() == null ? ""
				: signOutNet.getApplyBaseInfo().getApplyLinkman();
		this.applyPhone = signOutNet.getApplyBaseInfo().getApplyPhone() == null ? ""
				: signOutNet.getApplyBaseInfo().getApplyPhone();
		this.applyFax = signOutNet.getApplyBaseInfo().getApplyFax() == null ? ""
				: signOutNet.getApplyBaseInfo().getApplyFax();
		this.applyComSign = signOutNet.getApplyComSign() == null ? ""
				: signOutNet.getApplyComSign();
		// 退网信息
		this.siteName = signOutNet.getSiteName() == null ? "" : signOutNet
				.getSiteName();
		this.nodeCodes = signOutNet.getNodeCodes() == null ? "" : signOutNet
				.getNodeCodes();
		this.siteCode = signOutNet.getSiteCode() == null ? "" : signOutNet
				.getSiteCode();
		this.subnetType = signOutNet.getSubnetType() == null ? "" : signOutNet
				.getSubnetType().getValue();
		this.caseNum = signOutNet.getCaseNum() == null ? "" : signOutNet
				.getCaseNum();
		this.nodeNum = signOutNet.getNodeNum() == null ? "" : signOutNet
				.getNodeNum();
		this.siteSystemPES = "0";
		this.siteSystemTES = "0";
		this.siteSystemKU = "0";
		this.dealType = signOutNet.getDealType() == null ? "" : signOutNet
				.getDealType().getValue();
		this.reason = signOutNet.getReason() == null ? "" : signOutNet
				.getReason();
		this.equip = signOutNet.getEquip() == null ? "" : signOutNet.getEquip();
		this.caseAndNodeNums = "";
		// 申请记录信息
		this.initApproveCom = signOutNet.getInitApproveCom() == null ? ""
				: signOutNet.getInitApproveCom();
		this.initApproveSign = signOutNet.getInitApproveSign() == null ? ""
				: signOutNet.getInitApproveSign();
		this.initApproveOpinion = signOutNet.getInitApproveOpinion() == null ? ""
				: signOutNet.getInitApproveOpinion();
		this.finalApproveCom = "北京天航信民航通信网络发展有限公司";
		this.finalApproveSign = null;
		this.finalApproveOpinion = signOutNet.getFinalApproveOpinion() == null ? ""
				: signOutNet.getFinalApproveOpinion();
		this.applyDate = DateUtilTools.format(signOutNet.getApplyBaseInfo()
				.getApplyDate().getTime());
		this.initLinkman = signOutNet.getApplyBaseInfo().getInitLinkman();
		this.initLinkphone = signOutNet.getApplyBaseInfo().getInitLinkphone();
		this.finalLinkman = signOutNet.getApplyBaseInfo().getFinalLinkman();
		this.finalLinkphone = signOutNet.getApplyBaseInfo().getFinalLinkphone();
	}

	public String getCaseAndNodeNums() {
		return caseAndNodeNums;
	}

	public void setCaseAndNodeNums(String caseAndNodeNums) {
		this.caseAndNodeNums = caseAndNodeNums;
	}

	public String getApplyCom() {
		return applyCom;
	}

	public void setApplyCom(String applyCom) {
		this.applyCom = applyCom;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getNodeCodes() {
		return nodeCodes;
	}

	public void setNodeCodes(String nodeCodes) {
		this.nodeCodes = nodeCodes;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(String subnetType) {
		this.subnetType = subnetType;
	}

	public String getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	public String getNodeNum() {
		return nodeNum;
	}

	public void setNodeNum(String nodeNum) {
		this.nodeNum = nodeNum;
	}

	public String getSiteSystemPES() {
		return siteSystemPES;
	}

	public void setSiteSystemPES(String siteSystemPES) {
		this.siteSystemPES = siteSystemPES;
	}

	public String getSiteSystemTES() {
		return siteSystemTES;
	}

	public void setSiteSystemTES(String siteSystemTES) {
		this.siteSystemTES = siteSystemTES;
	}

	public String getSiteSystemKU() {
		return siteSystemKU;
	}

	public void setSiteSystemKU(String siteSystemKU) {
		this.siteSystemKU = siteSystemKU;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
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

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
}