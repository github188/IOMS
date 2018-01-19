package cn.com.atnc.ioms.enums.phonemng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
/**
 * 电话类别-新增
 *
 * @author 韩天驭
 * @2017年1月5日 下午2:56:39
 */
public enum AtncCallTypeEnum {
	FAULT ("故障"),
	CONSULT("咨询"),
	INSIDE("内部"),
	LOOKFOR("找人"),
	OTHER("其他");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private AtncCallTypeEnum(String value) {
        this.value = value;
    }
    
	public static AtncCallTypeEnum getInstance(String value) {
		AtncCallTypeEnum[] atncCallTypeEnum = AtncCallTypeEnum.values();
		for(AtncCallTypeEnum status : atncCallTypeEnum) {
			if(StringUtils.equalsIgnoreCase(status.getValue(), value)) {
				return status;
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
