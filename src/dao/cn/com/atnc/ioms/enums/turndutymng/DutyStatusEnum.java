package cn.com.atnc.ioms.enums.turndutymng;

public enum DutyStatusEnum {
	
	
	SIGNINACTIVE("已签到已激活坐席"),
	SIGNIN("已签到未激活坐席"),
	LEAVE("已离岗");

	private String value;
    public String getValue(){
        return this.value;
    }
    private DutyStatusEnum(String value) {
        this.value = value;
    }
}
