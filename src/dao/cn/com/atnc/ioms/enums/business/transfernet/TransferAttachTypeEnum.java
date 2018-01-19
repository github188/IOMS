package cn.com.atnc.ioms.enums.business.transfernet;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 附件类型枚举
 *
 * @author Wang Zhicheng
 * @date 2015年10月29日 下午5:54:54
 * @since 1.0.0
 */
public enum TransferAttachTypeEnum {

	one("《节点设备安装竣工验收报告》"),
	two("《节点建设工程设备测试报告》"),
	three("《节点设备清单》"),
	four("《民用航空空中交通通信导航监视设备使用许可证》"),
	five("《地区网络中心审批表》"),
	six("《用户补充信息》");
	private String value;
	private TransferAttachTypeEnum(String value){
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
