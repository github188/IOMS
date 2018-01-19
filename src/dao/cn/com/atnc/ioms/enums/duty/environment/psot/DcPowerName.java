package cn.com.atnc.ioms.enums.duty.environment.psot;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;
import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 直流电源设备名称枚举类
 * @author renyujuan
 * @time:2016年8月16日 下午2:56:51
 */
public enum DcPowerName {

   COMPANYDCP("公司直流电源设备"),
   LTDCP("联通直流电源设备"),
   DXDCP("电信直流电源设备"),
   DXSQAREDCP("电信直流电源设备(备用)");
   
   private String value;
   public String getValue(){
       return value;
   }
   
   private DcPowerName(String value) {
       this.value = value;
   }
   
   public static DcPowerName getInstance(String value){
       DcPowerName[] dcPowerName=DcPowerName.values();
       for(DcPowerName result : dcPowerName ){
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
