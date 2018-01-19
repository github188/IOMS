/**
 * 
 */
package cn.com.atnc.ioms.enums.techsupport.fault;

/**
 * 类说明:故障申报状态枚举类
 * 
 * @author KuYonggang
 * @date 2014-4-2下午8:16:55
 * @version 1.0
 */
public enum AllStatus {
	
	ADD("已新增"), 
	MODIFIED("已修改"),
	SUBMITTED("已提交"), 
	OPEN("已接单"), 
	TRANSFERRED("已移交"), 
	ASSIGNED("已分配"),
	SOLVED("值班已解决"), 
	RESOLVED("工程师已解决"),
	SOLVED_OPEN("值班解决重启"),
	RESOLVED_OPEN("工程师解决重启"),
	FINISHED("已结单"),
	CLOSED("已关闭"),
	REPLIED("已回复"),
	CHANGED("已转咨询"),
	ADDED("已追加");
	private String name;
	/**
	 * @param name
	 */
	private AllStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		System.err.println(AllStatus.ADD.name());
	}
}
