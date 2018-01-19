/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:03:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.basedata.ku;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:03:06
 * @version:1.0
 */

public class KuNodeQueryModel extends MyPaginModel {
	private String kuNodeNoLike;
	private String kuNodeCodeLike;
	private String kuNodeNameLike;
	private EquipType equipType;

	private String kuNodeNo;
	private String kuNodeCode;
	private String kuNodeName;

	private String excludeId;

	private String equipId;
	
	//子网
	private SubnetType subnetType;

	private String siteNameLike;
	private String siteCodeLike;
	private Bureau bureau;

	public SubnetType getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(SubnetType subnetType) {
		this.subnetType = subnetType;
	}

	public String getSiteNameLike() {
		return siteNameLike;
	}

	public void setSiteNameLike(String siteNameLike) {
		this.siteNameLike = siteNameLike;
	}

	public String getSiteCodeLike() {
		return siteCodeLike;
	}

	public void setSiteCodeLike(String siteCodeLike) {
		this.siteCodeLike = siteCodeLike;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getExcludeId() {
		return excludeId;
	}

	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}

	public String getKuNodeNo() {
		return kuNodeNo;
	}

	public void setKuNodeNo(String kuNodeNo) {
		this.kuNodeNo = kuNodeNo;
	}

	public String getKuNodeCode() {
		return kuNodeCode;
	}

	public void setKuNodeCode(String kuNodeCode) {
		this.kuNodeCode = kuNodeCode;
	}

	public String getKuNodeName() {
		return kuNodeName;
	}

	public void setKuNodeName(String kuNodeName) {
		this.kuNodeName = kuNodeName;
	}

	public String getKuNodeNoLike() {
		return HqlStringTools.replaceSpecialChar(kuNodeNoLike);
	}

	public void setKuNodeNoLike(String kuNodeNoLike) {
		this.kuNodeNoLike = kuNodeNoLike;
	}

	public String getKuNodeCodeLike() {
		return HqlStringTools.replaceSpecialChar(kuNodeCodeLike);
	}

	public void setKuNodeCodeLike(String kuNodeCodeLike) {
		this.kuNodeCodeLike = kuNodeCodeLike;
	}

	public String getKuNodeNameLike() {
		return kuNodeNameLike;
	}

	public void setKuNodeNameLike(String kuNodeNameLike) {
		this.kuNodeNameLike = kuNodeNameLike;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

}
