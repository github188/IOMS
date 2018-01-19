package cn.com.atnc.ioms.enums.publicnotice;

/**
 *  * 类说明：审批过程中的状态
 * @author:lizhisheng
 * @date:2014-4-25 上午10:22:52
 * @version:1.0
 */
public enum PnNoticeStatusEnum {
//	NEW	未处理
//	MODIFIED	已修改
//	SUBMITTED	已提交
//	PASSED	审批通过
//	DENIED	退回
//	PUBLISHED	已发布
	NEW("新增"),MODIFIED("重新修改"),SUBMITTED("待审批"),
	 DELETED("删除通知公告"),ZANCUN("暂存"),
	FIRSTPASSED("部门经理审批通过"),FIRSTDENIED("部门经理退回"),
	SECONDPASSED("事业部领导审批通过"),SECONDDENIED("事业部领导退回"),PUBLISHED("已发布");
	
 private String value;

public String getValue() {
	return value;
}
private PnNoticeStatusEnum(String value){
	this.value = value;
}
}
