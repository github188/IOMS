package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * DDN节点机设备名称
 * @author renyujuan
 * @time:2016年8月16日 下午3:04:50
 */
public enum DdnName {

    DDN("DDN节点机");
    
    private String value;
    public String getValue(){
        return value;
    }
    
    private DdnName(String value) {
        this.value = value;
    }
    
    public static DdnName getInstance(String value){
        DdnName[] ddnName=DdnName.values();
        for(DdnName result : ddnName ){
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
