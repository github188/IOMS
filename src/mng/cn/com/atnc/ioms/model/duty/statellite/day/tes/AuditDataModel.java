package cn.com.atnc.ioms.model.duty.statellite.day.tes;

import cn.com.atnc.common.model.BaseModel;

/**
 * 审核model
 *
 * @author 段衍林
 * @2017年2月16日 下午1:04:03
 */
public class AuditDataModel extends BaseModel {

	private String id; // 实体id
	private String optType;// tab页
	private String auditRemark;// 审核备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
}
