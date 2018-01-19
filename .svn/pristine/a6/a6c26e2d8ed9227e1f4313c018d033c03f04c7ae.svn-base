package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.satellite.LR;
import cn.com.atnc.ioms.enums.duty.satellite.OnOff;
import cn.com.atnc.ioms.model.MyPaginModel;

public class SlhEquStateModel extends MyPaginModel{

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
	
	private String dpc38;	//DPC组1备用(DPC38)
	private String dpc58;	//DPC组1备用(DPC58)
	private OnOff NCC62;	//NCC2(62)
	private OnOff NCC63;	//NCC2(63)
	private LR umodup;		//UMOD(上)
	private LR umoddown;	//UNMD(下)
	
	public SlhEquStateModel(){}
	public SlhEquStateModel(
			String dpc38,
			String dpc58,
			OnOff NCC62,
			OnOff NCC63,
			LR umodup,
			LR umoddown,
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		this.dpc38=dpc38;
		this.dpc58=dpc58;
		this.NCC62=NCC62;
		this.NCC63=NCC63;
		this.umodup=umodup;
		this.umoddown=umoddown;
		this.id=id;
		this.checkid=checkid;
		this.checkDate=checkDate;
		this.checkTime=checkTime;
		this.operator=operator;
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
	public String getDpc38() {
		return dpc38;
	}
	public void setDpc38(String dpc38) {
		this.dpc38 = dpc38;
	}
	public String getDpc58() {
		return dpc58;
	}
	public void setDpc58(String dpc58) {
		this.dpc58 = dpc58;
	}
	public OnOff getNCC62() {
		return NCC62;
	}
	public void setNCC62(OnOff nCC62) {
		NCC62 = nCC62;
	}
	public OnOff getNCC63() {
		return NCC63;
	}
	public void setNCC63(OnOff nCC63) {
		NCC63 = nCC63;
	}
	public LR getUmodup() {
		return umodup;
	}
	public void setUmodup(LR umodup) {
		this.umodup = umodup;
	}
	public LR getUmoddown() {
		return umoddown;
	}
	public void setUmoddown(LR umoddown) {
		this.umoddown = umoddown;
	}
	
	
}
