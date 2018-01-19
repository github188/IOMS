package cn.com.atnc.ioms.enums.faultmng;

/**
 * 事件处置工作流状态
 * @author duanyanlin
 * 2016年6月22日 上午11:04:41
 */
public enum FaultWorkflowType {
	
	faultHangup("挂起"),

	transferStation("移交其他坐席"),

	transferCTO("移交部门经理"),

	transferDept("移交其他部门"),

	faultBack("退回"),
	
	success("成功");

	private String value;

	private FaultWorkflowType(String value) {
		this.value = value;
	}

	public String getName() {
		return name();
	}

	public String getValue() {
		return this.value;
	}
}