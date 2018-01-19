package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class WhModel extends MyPaginModel{

	private String id;
	private EnvironmentEquipCheck checkid;//巡检id
	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;
	private EquipType equipType;
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间
	private String result;
	private String opinion;
	public WhModel(){}
	public WhModel(
			String result,
			String opinion,
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		
		this.result=result;
		this.opinion=opinion;
		this.id=id;
		this.checkid=checkid;
		this.checkDate=checkDate;
		this.checkTime=checkTime;
		this.operator=operator;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
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
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
