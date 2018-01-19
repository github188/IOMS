package cn.com.atnc.ioms.enums.business.telegraph;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 附件类型枚举
 * @author WangLingbin
 * @date 2015年10月29日 下午4:27:24
 * @since 1.0.0
 */
public enum TeleAttachTypeEnum {

	one("《民航局关于四字代码的批复》"),
	two("《国际航空运输协会关于三字代码的批复》"),
	three("《转报设备民航入网许可证》"),
	four("《地区网络中心审批表》"),
	five("《用户补充信息》");
	private String value;
	private TeleAttachTypeEnum(String value){
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
