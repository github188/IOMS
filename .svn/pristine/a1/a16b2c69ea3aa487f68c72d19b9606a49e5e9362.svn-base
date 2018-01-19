package cn.com.atnc.ioms.enums.business.datacomnetwork;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 附件类型枚举
 *
 * @author Wang Zhicheng
 * @date 2015年10月29日 下午5:58:37
 * @since 1.0.0
 */
public enum NetWorkAttachTypeEnum {

	one("《民航数据通信网节点设备安装竣工验收报告》或《民航数据通信网节点入网说明》"),
	two("《民航数据通信网节点建设工程设备测试报告》或《民航数据通信网节点设备测试报告》"),
	three("《民航数据通信网节点建设设备清单》"),
	four("《地区网络中心审批表》"),
	five("《用户补充信息》");
	
	private String value;
	private NetWorkAttachTypeEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
	@JsonValue
	public EnumModel toEnumModel(){
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());
		
		return em;
	}
}
