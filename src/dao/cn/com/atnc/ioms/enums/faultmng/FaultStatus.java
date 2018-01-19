package cn.com.atnc.ioms.enums.faultmng;

/**
 * 故障单状态
 * 
 * @author duanyanlin 2016年6月17日 下午2:04:54
 */
public enum FaultStatus {
	WAIT("待第一处理人处理"),

	HANGUP("待值班经理分配"),

	ASSIGN("待部门经理分配"),
	
	ASSIGNOK("待部门经理确认"),

	HANDLE("待处理"),

	CLASSIFY("待归类"),

	SUCCESS("完成"),
	
	DELETE("已删除事件单"),
	HANDLEOA("OA处理"),;

	private String value;

	private FaultStatus(String value) {
		this.value = value;
	}

	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}