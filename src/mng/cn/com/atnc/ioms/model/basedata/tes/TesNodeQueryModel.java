/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:03:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.basedata.tes;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

public class TesNodeQueryModel extends MyPaginModel {

	private String tesNodeCode;
	private String tesNodeCodeLike;
	// private String tesNodeNoLike;
	// private String tesNodeNameLike;
	// private EquipType equipType;

	// private String tesNodeNo;
	// private String tesNodeName;

	private String excludeId;

	private String equipId;

	private String tesNodeInfoLike;// tes节点管理备注信息

	private String siteNameLike;
	private String siteCodeLike;
	private Bureau bureau;

	private String serviceMemoLike;

	public String getServiceMemoLike() {
		return HqlStringTools.replaceSpecialChar(serviceMemoLike);

	}

	public void setServiceMemoLike(String serviceMemoLike) {
		this.serviceMemoLike = serviceMemoLike;
	}

	public String getSiteNameLike() {
		return HqlStringTools.replaceSpecialChar(siteNameLike);
	}

	public void setSiteNameLike(String siteNameLike) {
		this.siteNameLike = siteNameLike;
	}

	public String getSiteCodeLike() {
		return HqlStringTools.replaceSpecialChar(siteCodeLike);
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

	public String getTesNodeCodeLike() {
		return HqlStringTools.replaceSpecialChar(tesNodeCodeLike);
	}

	public String getTesNodeCode() {
		return tesNodeCode;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setTesNodeCodeLike(String tesNodeCodeLike) {
		this.tesNodeCodeLike = tesNodeCodeLike;
	}

	public void setTesNodeCode(String tesNodeCode) {
		this.tesNodeCode = tesNodeCode;
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

	public String getTesNodeInfoLike() {
		return HqlStringTools.replaceSpecialChar(tesNodeInfoLike);
	}

	public void setTesNodeInfoLike(String tesNodeInfoLike) {
		this.tesNodeInfoLike = tesNodeInfoLike;
	}
}
