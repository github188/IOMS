package cn.com.atnc.ioms.enums.business.telegraph;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;


/**
 * 转报地址申请类型枚举
 * @author WangLingbin
 * @date 2015年6月18日 上午9:09:58
 * @since 1.0.0
 */
public enum TeleApplyTypeEnum {

	create("新增"),
	cancel("取消"),
	modify("变更");
	
	private String value;
	private TeleApplyTypeEnum(String value){
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
