package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum ZjOticalName {

    DSZJOTICAL("东四总局155光端机");
    
    private String value;
    public String getValue() {
        return value;
    }
    
    private ZjOticalName(String value) {
        this.value = value;
    }
    
    public static ZjOticalName getInstance(String value){
        ZjOticalName[] oticalName=ZjOticalName.values();
        for(ZjOticalName result : oticalName ){
            if(StringUtils.equalsIgnoreCase(result.getValue(), value)) {
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
