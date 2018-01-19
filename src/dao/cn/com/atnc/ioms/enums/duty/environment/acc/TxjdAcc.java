package cn.com.atnc.ioms.enums.duty.environment.acc;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

import cn.com.atnc.ioms.enums.operstat.atm.EnumModel;

/**
 * 通信基地网控中心精密空调设备名称枚举类
 * @author renyujuan
 * @date 2016年8月10日下午4:09:28
 */
public enum TxjdAcc {

	TXJDONE("通信基地网控中心1号精密空调"),
	TXJDTWO("通信基地网控中心2号精密空调"),
	TXJDTHREE("通信基地网控中心3号精密空调"),
	TXJDFOUR("通信基地网控中心4号精密空调"),
	TXJDFIVE("通信基地网控中心5号精密空调"),
	TXJDSIX("通信基地网控中心6号精密空调"),
	TXJDSEVEN("通信基地网控中心7号精密空调"),
	TXJDEIGHT("通信基地网控中心8号精密空调"),
	TXJDNINE("通信基地网控中心9号精密空调"),
	TXJDTEN("通信基地网控中心10号精密空调"),
	TXJDELEVEN("通信基地网控中心11号精密空调"),
	TXJDTWELVEN("通信基地网控中心12号精密空调"),
	TXJDUPSONE("通信基地ups机房1号精密空调"),
	TXJDUPSTWO("通信基地ups机房2号精密空调"),
	TXJDUPSTHREE("通信基地ups机房3号精密空调"),
	TXJDUPSFOUR("通信基地ups机房4号精密空调");
	
	private String value;
	public String getValue(){
		return value;
	}
	
	private TxjdAcc(String value){
		this.value = value;
	}
	
	public static TxjdAcc getInstance(String value){
		TxjdAcc[] txjdAccs = TxjdAcc.values();
		for(TxjdAcc result : txjdAccs){
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
