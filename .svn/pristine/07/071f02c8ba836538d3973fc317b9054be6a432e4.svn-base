package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 传输设备与通信线路设备检查状态枚举类
 * @author renyujuan
 * @time:2016年8月16日 下午2:30:36
 */
public enum CheckStatus {
    SOLID("牢固"),
    LOOSE("松动"),
    AMACHINE("A机"),
    BMACHINE("B机"),
    UNFREE("无空余"),
    FREE("有空余"),
    COMPLETE("齐全"),
    UNPASTE("未粘贴");
    
    private String value;
    public String getValue() {
        return value;
    }
    
    private CheckStatus(String value) {
        this.value = value ;
    }
    
    public static CheckStatus getInstance(String value) {
        CheckStatus[] checkStatus = CheckStatus.values();
        for(CheckStatus result : checkStatus) {
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
