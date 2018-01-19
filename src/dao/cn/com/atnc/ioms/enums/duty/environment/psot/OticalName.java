package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 通讯设备与传输线路光端机名称枚举类
 * @author renyujuan
 * @time:2016年8月16日 下午3:18:26
 */
public enum OticalName {

    DXOTICAL("电信光端机"),
    LTOTICALONE("联通622光端机（1）"),
    LTOTICALTWO("联通622光端机（2）"),
    AIRPORTOTICAL("机场155光端机"),
    LT2500OTICAL("联通2500光端机"),
    JHOTICAL("北空军航光端机");
    
    private String value;
    public String getValue() {
        return value;
    }
    
    private OticalName(String value) {
        this.value = value;
    }
    
    public static OticalName getInstance(String value){
        OticalName[] oticalName=OticalName.values();
        for(OticalName result : oticalName ){
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
