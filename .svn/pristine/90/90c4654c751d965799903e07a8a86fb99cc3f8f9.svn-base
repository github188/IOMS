package cn.com.atnc.ioms.enums.faultmng;

/**
 * 故障处理种类
 * @author duanyanlin 
 * 2016年6月17日 下午2:04:23
 */
public enum FaultHandelType {
	
	HANDLE("一般处理"), TRANSFER("移交"), ASSIGN("分配"), HANGUP("挂起"), BACK("退回"),
	CLASSIFY("归类"), ENGINEER("技术工程师处理"), CACHE("暂存"), EDIT("修改事件单"), DELETE("删除事件单"),
	FAULTTEMPRARY("第一处理人暂存"), BACKENGINEER("部门经理退回处置记录"), BACKEDENGINEER("被部门经理退回的处置记录");

	private String value;

	private FaultHandelType(String value) {
		this.value = value;
	}

	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}