package cn.com.atnc.ioms.enums.tempcircuit;

/**
 * 类说明：临时电路审批过程中的状态
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午6:03:32
 * @version:1.0
 */
public enum CircuitStatus {
	MODIFIED("工程师修改申请"), SUBMITTED("客户提交电路开通申请"), ATNCSUBMITTED("网控工程师提交电路开通申请"), DELETED(
			"工程师申请撤销电路"), FORCEDELETED("网控工程师强制删除"), ACKDELETED("网控工程师确认电路撤销"), LOCALPASSED(
			"地方部门领导审批通过"), LOCALDENIED("地方部门领导审批拒绝"), AREAPASSED("区管领导审批通过"), AREADENIED(
			"区管领导审批拒绝"), ATNCPASSED("网控领导审批通过"), ATNCDENIED("网控领导审批拒绝"), ACCEPTED(
			"网控工程师接单"), TRANSFERRED("网控工程师移交"), DONE("电路开通"), DELAY("已延期"), EXPIRE(
			"电路到期");

	private String name;

	public String getName() {
		return name;
	}

	private CircuitStatus(String name) {
		this.name = name;
	}

}
