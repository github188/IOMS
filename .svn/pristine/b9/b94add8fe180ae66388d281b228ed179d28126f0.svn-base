package cn.com.atnc.ioms.enums.duty.environment;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 内容巡检结果枚举类
 * @author renyujuan
 * @date 2016年8月3日上午10:58:00
 */
public enum ContentCheckResult {

	YES("是"),
	No("否");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private ContentCheckResult(String value){
		this.value=value;
	}
	
	public static ContentCheckResult getInstance(String value){
		ContentCheckResult[] ccrs=ContentCheckResult.values();
		for(ContentCheckResult result : ccrs){
			if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
				return result;
			}
		}
		throw new IllegalArgumentException("value值非法，没有符合冗余状态的枚举对象");
	}
	
	@Override
	public String toString() {
		return value;	
	}
	@JsonValue
	public EnumModel toEnumModel() {
		EnumModel em = new EnumModel();
		em.setName(this.name());
		em.setOrdinal(this.ordinal());
		em.setValue(this.getValue());

		return em;
	}
}
