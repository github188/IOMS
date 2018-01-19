package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class SlhNetConModel extends MyPaginModel {
	private String id;
	private EnvironmentEquipCheck checkid;// 巡检id
	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;
	private EquipType equipType;
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间

	private String con3; // 网管连通性10.34.64.3
	private String con4; // 网管连通性10.34.64.4
	private String con5; // 网管连通性10.34.64.5
	private String con6; // 网管连通性10.34.64.6

	public SlhNetConModel() {
	}

	public SlhNetConModel(String con3, String con4, String con5, String con6, String id, EnvironmentEquipCheck checkid,
			Date checkDate, Date checkTime, User operator) {
		this.con3 = con3;
		this.con4 = con4;
		this.con5 = con5;
		this.con6 = con6;
		this.id = id;
		this.checkid = checkid;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.operator = operator;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

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

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCon3() {
		return con3;
	}

	public void setCon3(String con3) {
		this.con3 = con3;
	}

	public String getCon4() {
		return con4;
	}

	public void setCon4(String con4) {
		this.con4 = con4;
	}

	public String getCon5() {
		return con5;
	}

	public void setCon5(String con5) {
		this.con5 = con5;
	}

	public String getCon6() {
		return con6;
	}

	public void setCon6(String con6) {
		this.con6 = con6;
	}

}
