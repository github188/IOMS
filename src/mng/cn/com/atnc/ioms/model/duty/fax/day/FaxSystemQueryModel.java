package cn.com.atnc.ioms.model.duty.fax.day;

import java.util.Date;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.duty.WorkStatus;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 转报系统日检
 *
 * @author 韩天驭
 * @2017年2月8日 下午4:45:45
 */
public class FaxSystemQueryModel extends MyPaginModel {
	private int index;

    private String operator;

    private String startOptTime; //操作时间
    private String endOptTime; //操作时间
    private String optType;
    
    private String username;
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getStartOptTime() {
		return startOptTime;
	}
	public void setStartOptTime(String startOptTime) {
		this.startOptTime = startOptTime;
	}
	public String getEndOptTime() {
		return endOptTime;
	}
	public void setEndOptTime(String endOptTime) {
		this.endOptTime = endOptTime;
	}
	
    
	
}
