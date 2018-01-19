package cn.com.atnc.ioms.model.basedata.satellite;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

public class AntennaQueryModel extends MyPaginModel {

	private String excludeId;

	private String siteName;
	

	private String siteId;
	private Bureau bureau;
	private String networkType;
	private String siteCodeLike;
	private String siteNameLike;

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

	public String getExcludeId() {
		return excludeId;
	}

	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}

	public String getSiteNameLike() {
		return HqlStringTools.replaceSpecialChar(siteNameLike);
	}

	public void setSiteNameLike(String siteNameLike) {
		this.siteNameLike = siteNameLike;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/*
	 * public String getAntennaCodeLike() { return
	 * HqlStringTools.replaceSpecialChar(antennaCodeLike);
	 * 
	 * }
	 * 
	 * public void setAntennaCodeLike(String antennaCodeLike) {
	 * this.antennaCodeLike = antennaCodeLike; }
	 * 
	 * public String getAntennaCode() { return antennaCode; }
	 * 
	 * public void setAntennaCode(String antennaCode) { this.antennaCode =
	 * antennaCode; }
	 */

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

}
