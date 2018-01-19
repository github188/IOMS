package cn.com.atnc.ioms.model.basedata.tes;

import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

public class TesTeleQueryModel extends MyPaginModel {
	
	private String excludeId;
	private String tesNodeIdLike;
//	private String tesNodeId; 
	private String phoneNum;
	private String phoneNumLike;	
	private String cu;
	private String tesNodeCodeLike;
	public void setTesNodeIdLike(String tesNodeIdLike) {
		this.tesNodeIdLike = tesNodeIdLike;
	}
	/*public void setTesNodeId(String tesNodeId) {
		this.tesNodeId = tesNodeId;
	}*/
	private String tesNodeCode;  
	
	
	public String getTesNodeCodeLike() {
		return HqlStringTools.replaceSpecialChar(tesNodeCodeLike);		
	}
	
	public String getTesNodeCode() {
		return tesNodeCode;
	}
	public void setTesNodeCodeLike(String tesNodeCodeLike) {
		this.tesNodeCodeLike = tesNodeCodeLike;
	}
	public void setTesNodeCode(String tesNodeCode) {
		this.tesNodeCode = tesNodeCode;
	}
	public String getExcludeId() {
		return excludeId;
	}
	public String getTesNodeIdLike() {
		return tesNodeIdLike;
	}
	/*public String getTesNodeId() {
		return tesNodeId;
	}*/
	public String getCu() {
		return cu;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getPhoneNumLike() {
		return HqlStringTools.replaceSpecialChar(phoneNumLike);
	}
	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}
/*	public void setTesNodeIdLike(String tesNodeIdLike) {
		this.tesNodeIdLike = tesNodeIdLike;
	}
	public void setTesNodeId(String tesNodeId) {
		this.tesNodeId = tesNodeId;
	}*/
	public void setCu(String cu) {
		this.cu = cu;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setPhoneNumLike(String phoneNumLike) {
		this.phoneNumLike = phoneNumLike;
	}

}
