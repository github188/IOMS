package cn.com.atnc.ioms.enums.duty.environment.acc;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

public enum SlhLbote {
    
    SLHLBTWEST("十里河网控中心西侧力博特精密空调"),
    SLHLBTEAST("十里河网控中心东侧力博特精密空调"),
    SLHLBTNORTH("十里河网控中心北侧力博特精密空调");
    
    private String value;
    public String getValue(){
        return value;
    }
    
    private SlhLbote(String value){
        this.value = value;
    }
    
    public static SlhLbote getInstance(String value){
        SlhLbote[] slhLbotes = SlhLbote.values();
        for(SlhLbote result : slhLbotes){
            if(StringUtils.equalsIgnoreCase(result.getValue(), value)){
                return result;
            }
        }
        throw new IllegalArgumentException("value值非法，没有符合工作状态的枚举对象");
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
