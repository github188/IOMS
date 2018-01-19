package cn.com.atnc.ioms.enums.basedata;

public enum AtmBureau {
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
	};

	private String value;

	private AtmBureau(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

}
