package cn.com.atnc.ioms.enums.reports;

import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 报表图片名字枚举类
 * @author WangLingbin
 * @date 2015年10月16日 下午2:12:20
 * @since 1.0.0
 */
public enum ImageNameEnum {

	atncCachet("atncCachet.png");
	
	private String value;
	private ImageNameEnum(String value){
		this.value = value;
	}
	public String getValue() {
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
