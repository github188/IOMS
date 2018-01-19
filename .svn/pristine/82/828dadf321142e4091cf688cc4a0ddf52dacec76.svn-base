package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class SlhZpjjStateModel extends MyPaginModel {
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

	private String inr1; // INR1
	private String inr2; // INR2
	private String inr3; // INR3
	private String inr4; // INR4
	private String inr5; // INR5
	private String inr6; // INR6
	private String inr7; // INR7
	private String inrb; // 备用INR
	private String ebi; // EBI/No(dB)
	private String ebt; // EBT/No(dB)

	public SlhZpjjStateModel() {
	}

	public SlhZpjjStateModel(String inr1, String inr2, String inr3,
			String inr4, String inr5, String inr6, String inr7, String inrb,
			String ebi, String ent, String id, EnvironmentEquipCheck checkid,
			Date checkDate, Date checkTime, User operator) {

		this.inr1 = inr1;
		this.inr2 = inr2;
		this.inr3 = inr3;
		this.inr4 = inr4;
		this.inr5 = inr5;
		this.inr6 = inr6;
		this.inr7 = inr7;
		this.inrb = inrb;
		this.ebi = ebi;
		this.ebt = ent;
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

	public String getInr1() {
		return inr1;
	}

	public void setInr1(String inr1) {
		this.inr1 = inr1;
	}

	public String getInr2() {
		return inr2;
	}

	public void setInr2(String inr2) {
		this.inr2 = inr2;
	}

	public String getInr3() {
		return inr3;
	}

	public void setInr3(String inr3) {
		this.inr3 = inr3;
	}

	public String getInr4() {
		return inr4;
	}

	public void setInr4(String inr4) {
		this.inr4 = inr4;
	}

	public String getInr5() {
		return inr5;
	}

	public void setInr5(String inr5) {
		this.inr5 = inr5;
	}

	public String getInr6() {
		return inr6;
	}

	public void setInr6(String inr6) {
		this.inr6 = inr6;
	}

	public String getInr7() {
		return inr7;
	}

	public void setInr7(String inr7) {
		this.inr7 = inr7;
	}

	public String getInrb() {
		return inrb;
	}

	public void setInrb(String inrb) {
		this.inrb = inrb;
	}

	public String getEbi() {
		return ebi;
	}

	public void setEbi(String ebi) {
		this.ebi = ebi;
	}

	public String getEbt() {
		return ebt;
	}

	public void setEbt(String ebt) {
		this.ebt = ebt;
	}

}
