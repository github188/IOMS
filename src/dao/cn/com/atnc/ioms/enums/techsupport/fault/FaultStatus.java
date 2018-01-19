/**
 * 
 */
package cn.com.atnc.ioms.enums.techsupport.fault;

/**
 * @author：KuYonggang
 * @date：2014-4-29上午10:08:01
 * @version：1.0
 */
public enum FaultStatus {
	
	OPEN("已接单"), 
	TRANSFERRED("已移交"), 
	ASSIGNED("已分配"),
	SOLVED("值班已解决"), 
	RESOLVED("工程师已解决"),
	SOLVED_OPEN("值班解决重启"),
	RESOLVED_OPEN("工程师解决重启"),
	FINISHED("已结单");
	
	private String name;
	/**
	 * @param name
	 */
	private FaultStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
