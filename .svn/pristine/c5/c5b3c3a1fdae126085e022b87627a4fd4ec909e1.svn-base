/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:41:20
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;


/**
 * @author:HuangYijie
 * @date:2014-3-19 下午7:41:20
 * @version:1.0
 */

public enum Bureau {

	ZWWW("新疆") {
	},
	ZLXY("西北") {
	},
	ZUUU("西南") {
	},
	ZBAA("华北") {
	},
	ZSSS("华东") {
	},
	ZGGG("中南") {
	},
	ZYTX("东北") {
	},
	ZBBB("北京网控中心") {
	},
	ZSPD("上海网控中心") {
	},
	ZBHQ("总局") {
	},
	ZBKG("总局空管局") {
	},
	VHMT("港澳台") {
	},
	OVERSEAS("境外") {
	},
	;

	private String value;

	private Bureau(String value) {
		this.value = value;
	}

	public String getName() {
		return this.name();
	}

	public String getValue() {
		return value;
	}

	public static Bureau getBureauByOrdinal(int value) {
		for (Bureau type : Bureau.values()) {
			if (type.ordinal() == value) {
				return type;
			}
		}
		return null;
	}

	public static Bureau getBureauByValue(String name) {
		for (Bureau bureau : Bureau.values()) {
			if (name.endsWith(bureau.name())) {
				return bureau;
			}
		}
		return null;
	}

	public String toString() {
		return value;
	}

	public Bureau[] toATMBureau() {
		return new Bureau[] { ZWWW, ZLXY, ZUUU, ZBAA, ZSSS, ZGGG, ZYTX };
	}
	
	public static Bureau[] getSevenBureaus() {
		return new Bureau[] { ZWWW, ZLXY, ZUUU, ZBAA, ZSSS, ZGGG, ZYTX };
	}

	public static Bureau string2Enum(String value) {
		switch (value) {
		case "新疆":
			return ZWWW;
		case "西北":
			return ZLXY;
		case "西南":
			return ZUUU;
		case "华北":
			return ZBAA;
		case "华东":
			return ZSSS;

		case "中南":
			return ZGGG;
		case "东北":
			return ZYTX;
		case "北京网控中心":
			return ZBBB;
		case "上海网控中心":
			return ZSPD;
		case "境外":
			return OVERSEAS;
		default:
			return ZBBB;
		}
	}
	
	/**
	 * 判断是否属于7大管局
	 *	如果return null 则不属于
	 * @author ku
	 * @date  2015年5月22日下午4:18:14
	 * @since 1.0.0
	 */
	public static Bureau isBelong7Bureau(String value) {
		switch (value) {
		case "新疆":
			return ZWWW;
		case "西北":
			return ZLXY;
		case "西南":
			return ZUUU;
		case "华北":
			return ZBAA;
		case "华东":
			return ZSSS;
		case "中南":
			return ZGGG;
		case "东北":
			return ZYTX;
		default:
			return null;
		}
	}
}
