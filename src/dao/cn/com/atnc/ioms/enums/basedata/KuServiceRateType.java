/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 下午6:28:45
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * @author:HuangYijie
 * @date:2014-4-17 下午6:28:45
 * @version:1.0
 */
@JsonDeserialize(using = KuServiceRateTypeCustomDeserializer.class)
public enum KuServiceRateType {

	C0("CSC with rate 1/2 FEC", 256), C1("NBC with rate 1/2 FEC", 128), C2(
			"192.0Kbps Data In-band Signal", 1924), C3(
			"2048.0Kbps Frame Relay", 20480), C4("28.8Kbps Frame Relay", 288), C5(
			"64.0Kbps VF+ABCD Bits+FAX", 664), C6("64.0Kbps VF", 640), C7(
			"2.4Kbps Data", 24), C8("19.2Kbps Data", 192), C9("38.4Kbps Data",
			384), C10("16.0Kbps VF", 160), C11("64.0Kbps VF+FAX", 644), C12(
			"4.8Kbps Data In-band Signal", 52), C13("9.6Kbps Data", 96), C14(
			"4.8Kbps Data", 48), C15("32.0Kbps VF+FAX", 324), C16(
			"19.2Kbps Data In-band Signal", 196), C17("64.0Kbps Data", 640), C18(
			"256.0Kbps Data In-band Signal", 2564), C19(
			"9.6Kbps Data In-band Signal", 100), C20("32Kbps VF+ABCD Bits", 344), C21(
			"128.0Kbps Data", 1280), C22("128.0Kbps Data In-band Signal", 1284), C23(
			"192.0Kbps Data", 1920), C24("256.0Kbps Data", 2560), C25(
			"384.0Kbps Data", 3840), C26("64.0Kbps Data In-band Signal", 644), C27(
			"8.0Kbps+FAX", 84), C28("64Kbps Frame Relay", 640), C29(
			"96Kbps Data In-band Signal", 964), C30(
			"1.2Kbps Data In-band Signal", 16), C31(
			"168Kbps Data In-band Signal", 1684), ;

	private String value;
	private int size;

	private KuServiceRateType(String value, int size) {
		this.value = value;
		this.size = size;
	}

	public String getValue() {
		return value;
	}

	public int getSize() {
		return size;
	}

	public String toString() {

		return value;
	}

	public static KuServiceRateType ordinalToEnum(Integer ordinal) {
		switch (ordinal) {
		case 0:
			return C0;
		case 1:
			return C1;
		case 2:
			return C2;
		case 3:
			return C3;
		case 4:
			return C4;
		case 5:
			return C5;
		case 6:
			return C6;
		case 7:
			return C7;
		case 8:
			return C8;
		case 9:
			return C9;
		case 10:
			return C10;
		case 11:
			return C11;
		case 12:
			return C12;
		case 13:
			return C13;
		case 14:
			return C14;
		case 15:
			return C15;
		case 16:
			return C16;
		case 17:
			return C17;
		case 18:
			return C18;
		case 19:
			return C19;
		case 20:
			return C20;
		case 21:
			return C21;
		case 22:
			return C22;
		case 23:
			return C23;
		case 24:
			return C24;
		case 25:
			return C25;
		case 26:
			return C26;
		case 27:
			return C27;
		case 28:
			return C28;
		case 29:
			return C29;
		case 30:
			return C30;
		case 31:
			return C31;
		default:
			return C0;
		}

	}
}
