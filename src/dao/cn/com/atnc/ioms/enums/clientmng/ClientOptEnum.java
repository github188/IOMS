package cn.com.atnc.ioms.enums.clientmng;
/**
 *类说明:客户操作枚举类
 *@author 潘涛
 *@date 2014-3-19	下午3:10:02
 *@version:1.0
 */
public enum ClientOptEnum {
	REGISTER("申请"),AUDIT("审批"),ANNUL("注销"),CONFIGEQUIP("配置设备");
	
	private String name;

	public String getName() {
		return name;
	}

	private ClientOptEnum(String name) {
		this.name = name;
	}
	
}
