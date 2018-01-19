package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 传输设备与通信线路楼内综合布线名称枚举类
 * @author renyujuan
 * @time:2016年8月16日 下午3:36:10
 */
public enum PdsName {
    
    SLHPDS("十里河楼内综合布线"),
    TXJDPDS("通信基地楼内综合布线");
    
    private String value;
    public String getValue() {
        return value;
    }
    
    private PdsName(String value) {
        this.value=value;
    }
    
    public static PdsName getInstance(String value){
        PdsName[] pdsName=PdsName.values();
        for(PdsName result : pdsName ){
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
