package cn.com.atnc.ioms.model.basedata.satellite;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

public class OduQueryModel extends MyPaginModel {

	private String oduTypeLike;
	private Float oduPowerLike;
	private Float lanchMidFreqLike;
	private Float lanchPlusMinusLike;
	private Float receivePlusMinusLike;
	private Float receiveMidMinusLike;

	private String excludeId;

	private String oduType;
	// private String oduName;
	// private String oduNameLike;

	private Float oduPower;
	private Float lanchMidFreq;
	private Float lanchPlusMinus;
	private Float receivePlusMinus;
	private Float receiveMidMinus;
	private Bureau bureau;
	private String networkType;
	private String siteCodeLike;
	private String siteNameLike;
	private String siteId;

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getSiteCodeLike() {

		return HqlStringTools.replaceSpecialChar(siteCodeLike);
	}

	public void setSiteCodeLike(String siteCodeLike) {
		this.siteCodeLike = siteCodeLike;
	}

	public String getSiteNameLike() {
		return HqlStringTools.replaceSpecialChar(siteNameLike);

	}

	public void setSiteNameLike(String siteNameLike) {
		this.siteNameLike = siteNameLike;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getOduTypeLike() {
		return HqlStringTools.replaceSpecialChar(oduTypeLike);
	}

	public void setOduTypeLike(String oduTypeLike) {
		this.oduTypeLike = oduTypeLike;
	}

	public Float getOduPowerLike() {
		return oduPowerLike;
	}

	public void setOduPowerLike(Float oduPowerLike) {
		this.oduPowerLike = oduPowerLike;
	}

	public Float getLanchMidFreqLike() {
		return lanchMidFreqLike;
	}

	public void setLanchMidFreqLike(Float lanchMidFreqLike) {
		this.lanchMidFreqLike = lanchMidFreqLike;
	}

	public Float getLanchPlusMinusLike() {
		return lanchPlusMinusLike;
	}

	public void setLanchPlusMinusLike(Float lanchPlusMinusLike) {
		this.lanchPlusMinusLike = lanchPlusMinusLike;
	}

	public Float getReceivePlusMinusLike() {
		return receivePlusMinusLike;
	}

	public void setReceivePlusMinusLike(Float receivePlusMinusLike) {
		this.receivePlusMinusLike = receivePlusMinusLike;
	}

	public Float getReceiveMidMinusLike() {
		return receiveMidMinusLike;
	}

	public void setReceiveMidMinusLike(Float receiveMidMinusLike) {
		this.receiveMidMinusLike = receiveMidMinusLike;
	}

	public String getExcludeId() {
		return excludeId;
	}

	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}

	public String getOduType() {
		return oduType;
	}

	public void setOduType(String oduType) {
		this.oduType = oduType;
	}

	/*
	 * public String getOduName() { return oduName; }
	 * 
	 * public void setOduName(String oduName) { this.oduName = oduName; }
	 * 
	 * public String getOduNameLike() { return
	 * HqlStringTools.replaceSpecialChar(oduNameLike); }
	 * 
	 * public void setOduNameLike(String oduNameLike) { this.oduNameLike =
	 * oduNameLike; }
	 */

	public Float getOduPower() {
		return oduPower;
	}

	public void setOduPower(Float oduPower) {
		this.oduPower = oduPower;
	}

	public Float getLanchMidFreq() {
		return lanchMidFreq;
	}

	public void setLanchMidFreq(Float lanchMidFreq) {
		this.lanchMidFreq = lanchMidFreq;
	}

	public Float getLanchPlusMinus() {
		return lanchPlusMinus;
	}

	public void setLanchPlusMinus(Float lanchPlusMinus) {
		this.lanchPlusMinus = lanchPlusMinus;
	}

	public Float getReceivePlusMinus() {
		return receivePlusMinus;
	}

	public void setReceivePlusMinus(Float receivePlusMinus) {
		this.receivePlusMinus = receivePlusMinus;
	}

	public Float getReceiveMidMinus() {
		return receiveMidMinus;
	}

	public void setReceiveMidMinus(Float receiveMidMinus) {
		this.receiveMidMinus = receiveMidMinus;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/*
	 * public String getAntennaId() { return antennaId; }
	 * 
	 * public void setAntennaId(String antennaId) { this.antennaId = antennaId;
	 * }
	 */

}
