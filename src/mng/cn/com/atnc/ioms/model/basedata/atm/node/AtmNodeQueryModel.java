package cn.com.atnc.ioms.model.basedata.atm.node;


import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * @author:xoingzhikang
 * @date:2014-4-11 下午8:03:06
 * @version:1.0
 */

public class AtmNodeQueryModel extends MyPaginModel {

	private String atmNodeCodeLike;
	private String atmNodeNameCnLike;
	private String atmNodeSeqLike;
	
	
	private EquipType equipType;
	private String atmNodeCode;
	private String atmNodeNameCn;
	private String excludeId;
	private String excludeAtmNodeCode;
	private String excludeAtmNodeNameCn;
	private String excludeAtmNodeIp;
	private String equipId;
	private String atmNodeSeq;
	private String atmNodeIp;
	private String atmNodeId;
	private String optType;
	private Bureau bureau;
	
	
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

	public String getAtmNodeCode() {
		return atmNodeCode;
	}

	public void setAtmNodeCode(String atmNodeCode) {
		this.atmNodeCode = atmNodeCode;
	}

	public String getAtmNodeNameCn() {
		return atmNodeNameCn;
	}

	public void setAtmNodeNameCn(String atmNodeNameCn) {
		this.atmNodeNameCn = atmNodeNameCn;
	}

	public String getAtmNodeCodeLike() {
		return HqlStringTools.replaceSpecialChar(atmNodeCodeLike);
	}

	public void setAtmNodeCodeLike(String atmNodeCodeLike) {
		this.atmNodeCodeLike = atmNodeCodeLike;
	}

	public String getAtmNodeNameCnLike() {
		return HqlStringTools.replaceSpecialChar(atmNodeNameCnLike);
	}

	public void setAtmNodeNameCnLike(String atmNodeNameCnLike) {
		this.atmNodeNameCnLike = atmNodeNameCnLike;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	public String getAtmNodeSeqLike() {
		return HqlStringTools.replaceSpecialChar(atmNodeSeqLike);
	}

	public void setAtmNodeSeqLike(String atmNodeSeqLike) {
		this.atmNodeSeqLike = atmNodeSeqLike;
	}

	public String getAtmNodeSeq() {
		return atmNodeSeq;
	}

	public void setAtmNodeSeq(String atmNodeSeq) {
		this.atmNodeSeq = atmNodeSeq;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getExcludeAtmNodeCode() {
		return excludeAtmNodeCode;
	}

	public void setExcludeAtmNodeCode(String excludeAtmNodeCode) {
		this.excludeAtmNodeCode = excludeAtmNodeCode;
	}

	public String getExcludeAtmNodeNameCn() {
		return excludeAtmNodeNameCn;
	}

	public void setExcludeAtmNodeNameCn(String excludeAtmNodeNameCn) {
		this.excludeAtmNodeNameCn = excludeAtmNodeNameCn;
	}

	public String getExcludeAtmNodeIp() {
		return excludeAtmNodeIp;
	}

	public void setExcludeAtmNodeIp(String excludeAtmNodeIp) {
		this.excludeAtmNodeIp = excludeAtmNodeIp;
	}

	public String getAtmNodeIp() {
		return atmNodeIp;
	}

	public void setAtmNodeIp(String atmNodeIp) {
		this.atmNodeIp = atmNodeIp;
	}

	public String getAtmNodeId() {
		return atmNodeId;
	}

	public void setAtmNodeId(String atmNodeId) {
		this.atmNodeId = atmNodeId;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}
	
}
