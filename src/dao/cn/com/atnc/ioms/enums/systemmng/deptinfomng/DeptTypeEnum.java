package cn.com.atnc.ioms.enums.systemmng.deptinfomng;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;

public enum DeptTypeEnum {
	
	BU("事业部"),
	DEPT("部门");
    
	private String value;
    public String getValue(){
        return this.value;
    }
    private DeptTypeEnum(String value) {
        this.value = value;
    }
    
	public static DeptTypeEnum getInstance(String value) {
		DeptTypeEnum[] depttype = DeptTypeEnum.values();
		for(DeptTypeEnum status : depttype) {
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
