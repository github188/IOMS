/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 下午1:29:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.basedata.satellite.site;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * @author:HuangYijie
 * @date:2014-3-24 下午1:29:18
 * @version:1.0
 */

public class SiteQueryModel extends MyPaginModel {

	private String nameLike;
	private String codeLike;
	private Bureau bureau;
	private String code;
	private String name;
	private String equipId;
	private String siteId;
	private String siteCode;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	private String siteLike;

	public String getSiteLike() {
		return siteLike;
	}

	public void setSiteLike(String siteLike) {
		this.siteLike = siteLike;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/*
	 * public String getEquipId() { return equipId; }
	 * 
	 * public void setEquipId(String equipId) { this.equipId = equipId; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeLike() {
		return HqlStringTools.replaceSpecialChar(codeLike);
	}

	public void setCodeLike(String codeLike) {
		this.codeLike = codeLike;
	}

	public String getNameLike() {
		return HqlStringTools.replaceSpecialChar(nameLike);
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

}
