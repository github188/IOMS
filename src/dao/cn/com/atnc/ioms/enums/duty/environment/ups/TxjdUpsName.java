package cn.com.atnc.ioms.enums.duty.environment.ups;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 通信基地设备名称枚举类
 * @author renyujuan
 * @date 2016年8月2日上午11:33:20
 */
public enum TxjdUpsName {

	TXJDONE("通信基地200KVA UPS 1号机"),
	TXJDTWO("通信基地200KVA UPS 2号机"),
	TXJDTHR("通信基地400KVA UPS 3号机"),
	TXJDFOUR("通信基地200KVA UPS 4号机");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private TxjdUpsName(String value){
		this.value=value;
	}
	
	public static TxjdUpsName getInstance(String value){
		TxjdUpsName[] txjdUpsNames=TxjdUpsName.values();
		for(TxjdUpsName result :txjdUpsNames){
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
