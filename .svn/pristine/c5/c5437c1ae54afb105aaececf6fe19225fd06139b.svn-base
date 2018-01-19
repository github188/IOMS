package cn.com.atnc.ioms.enums.business.formalcircuit;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 附件类型枚举
 *
 * @author Wang Zhicheng
 * @date 2015年10月29日 下午5:58:37
 * @since 1.0.0
 */
public enum FormalCircuitAttachTypeEnum {

	one("《入网申请批复》"),
	two("《地区网络中心审批表》"),
	three("《用户补充信息》");
	
	private String value;
	private FormalCircuitAttachTypeEnum(String value){
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
