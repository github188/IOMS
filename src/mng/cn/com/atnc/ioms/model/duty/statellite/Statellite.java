package cn.com.atnc.ioms.model.duty.statellite;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 卫星巡检查询Model
 * 
 * @author shijiyong
 * @date 2016年10月14日 上午8:33:12
 * @version 1.0, 2016年10月14日 上午8:33:12
 */
public class Statellite extends MyPaginModel {

	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}


	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	
}
