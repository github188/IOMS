/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-23 下午6:05:38
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.systemmng.param;

import cn.com.atnc.common.model.BaseModel;

/**
 * @author:HuangYijie
 * @date:2014-4-23 下午6:05:38
 * @version:1.0
 */

public class SystemParamsModel extends BaseModel {

	private String kuRxLevelTopLimit;
	private String kuRxLevelLowerLimit;
	private String kuEbNoTopLimit;
	private String kuNetworkStatusStandard;
	private String tesTxPowerStandard;
	private String clientNoticeType;
	private String tempCircuitNotice;
	private String techConsultClose;
	private String busiStatTopLimit  ;
	private String busiStatLowerLimit;
	private String ftpLinkAlarmMin;

	public String getKuRxLevelTopLimit() {
		return kuRxLevelTopLimit;
	}

	public void setKuRxLevelTopLimit(String kuRxLevelTopLimit) {
		this.kuRxLevelTopLimit = kuRxLevelTopLimit;
	}

	public String getKuRxLevelLowerLimit() {
		return kuRxLevelLowerLimit;
	}

	public void setKuRxLevelLowerLimit(String kuRxLevelLowerLimit) {
		this.kuRxLevelLowerLimit = kuRxLevelLowerLimit;
	}

	public String getKuEbNoTopLimit() {
		return kuEbNoTopLimit;
	}

	public void setKuEbNoTopLimit(String kuEbNoTopLimit) {
		this.kuEbNoTopLimit = kuEbNoTopLimit;
	}

	public String getClientNoticeType() {
		return clientNoticeType;
	}

	public void setClientNoticeType(String clientNoticeType) {
		this.clientNoticeType = clientNoticeType;
	}

	public String getTempCircuitNotice() {
		return tempCircuitNotice;
	}

	public void setTempCircuitNotice(String tempCircuitNotice) {
		this.tempCircuitNotice = tempCircuitNotice;
	}

	public String getTechConsultClose() {
		return techConsultClose;
	}

	public void setTechConsultClose(String techConsultClose) {
		this.techConsultClose = techConsultClose;
	}

	public String getKuNetworkStatusStandard() {
		return kuNetworkStatusStandard;
	}

	public void setKuNetworkStatusStandard(String kuNetworkStatusStandard) {
		this.kuNetworkStatusStandard = kuNetworkStatusStandard;
	}

	public String getTesTxPowerStandard() {
		return tesTxPowerStandard;
	}

	public void setTesTxPowerStandard(String tesTxPowerStandard) {
		this.tesTxPowerStandard = tesTxPowerStandard;
	}

	public String getBusiStatTopLimit() {
		return busiStatTopLimit;
	}

	public void setBusiStatTopLimit(String busiStatTopLimit) {
		this.busiStatTopLimit = busiStatTopLimit;
	}

	public String getBusiStatLowerLimit() {
		return busiStatLowerLimit;
	}

	public void setBusiStatLowerLimit(String busiStatLowerLimit) {
		this.busiStatLowerLimit = busiStatLowerLimit;
	}

	public String getFtpLinkAlarmMin() {
		return ftpLinkAlarmMin;
	}

	public void setFtpLinkAlarmMin(String ftpLinkAlarmMin) {
		this.ftpLinkAlarmMin = ftpLinkAlarmMin;
	}
}
