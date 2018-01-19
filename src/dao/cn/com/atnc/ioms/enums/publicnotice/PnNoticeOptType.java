package cn.com.atnc.ioms.enums.publicnotice;

public enum PnNoticeOptType {
	NEW("申请"),MODIFIED("重新修改"),SUBMITTED("待审批"),DELETED("删除通知公告"),
	FIRSTPASSED("部门经理审批通过"),FIRSTDENIED("部门经理退回"),
	SECONDPASSED("事业部领导审批通过"),SECONDDENIED("事业部领导退回"),PUBLISHED("已发布");
	private String value;

	public String getValue() {
		return value;
	}
	private PnNoticeOptType(String value){
		this.value = value;
	}
}
