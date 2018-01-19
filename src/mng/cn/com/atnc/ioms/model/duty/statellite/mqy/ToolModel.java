package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class ToolModel extends MyPaginModel {

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

	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	private String name7;
	private String name8;
	private String name9;
	private String name10;
	private String num1;
	private String num2;
	private String num3;
	private String num4;
	private String num5;
	private String num6;
	private String num7;
	private String num8;
	private String num9;
	private String num10;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private String remark5;
	private String remark6;
	private String remark7;
	private String remark8;
	private String remark9;
	private String remark10;
	
	public ToolModel(){}
	public ToolModel(
			String name1,
			String name2,
			String name3,
			String name4,
			String name5,
			String name6,
			String name7,
			String name8,
			String name9,
			String name10,
			String num1,
			String num2,
			String num3,
			String num4,
			String num5,
			String num6,
			String num7,
			String num8,
			String num9,
			String num10,
			String remark1,
			String remark2,
			String remark3,
			String remark4,
			String remark5,
			String remark6,
			String remark7,
			String remark8,
			String remark9,
			String remark10,
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		
		this.name1=name1;
		this.name2=name2;
		this.name3=name3;
		this.name4=name4;
		this.name5=name5;
		this.name6=name6;
		this.name7=name7;
		this.name8=name8;
		this.name9=name9;
		this.name10=name10;
		this.num1=num1;
		this.num2=num2;
		this.num3=num3;
		this.num4=num4;
		this.num5=num5;
		this.num6=num6;
		this.num7=num7;
		this.num8=num8;
		this.num9=num9;
		this.num10=num10;
		this.remark1=remark1;
		this.remark2=remark2;
		this.remark3=remark3;
		this.remark4=remark4;
		this.remark5=remark5;
		this.remark6=remark6;
		this.remark7=remark7;
		this.remark8=remark8;
		this.remark9=remark9;
		this.remark10=remark10;
		this.id=id;
		this.checkid=checkid;
		this.checkDate=checkDate;
		this.checkTime=checkTime;
		this.operator=operator;
	}
	
	
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getName5() {
		return name5;
	}
	public void setName5(String name5) {
		this.name5 = name5;
	}
	public String getName6() {
		return name6;
	}
	public void setName6(String name6) {
		this.name6 = name6;
	}
	public String getName7() {
		return name7;
	}
	public void setName7(String name7) {
		this.name7 = name7;
	}
	public String getName8() {
		return name8;
	}
	public void setName8(String name8) {
		this.name8 = name8;
	}
	public String getName9() {
		return name9;
	}
	public void setName9(String name9) {
		this.name9 = name9;
	}
	public String getName10() {
		return name10;
	}
	public void setName10(String name10) {
		this.name10 = name10;
	}
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getNum3() {
		return num3;
	}
	public void setNum3(String num3) {
		this.num3 = num3;
	}
	public String getNum4() {
		return num4;
	}
	public void setNum4(String num4) {
		this.num4 = num4;
	}
	public String getNum5() {
		return num5;
	}
	public void setNum5(String num5) {
		this.num5 = num5;
	}
	public String getNum6() {
		return num6;
	}
	public void setNum6(String num6) {
		this.num6 = num6;
	}
	public String getNum7() {
		return num7;
	}
	public void setNum7(String num7) {
		this.num7 = num7;
	}
	public String getNum8() {
		return num8;
	}
	public void setNum8(String num8) {
		this.num8 = num8;
	}
	public String getNum9() {
		return num9;
	}
	public void setNum9(String num9) {
		this.num9 = num9;
	}
	public String getNum10() {
		return num10;
	}
	public void setNum10(String num10) {
		this.num10 = num10;
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

	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public String getRemark5() {
		return remark5;
	}
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	public String getRemark6() {
		return remark6;
	}
	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}
	public String getRemark7() {
		return remark7;
	}
	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}
	public String getRemark8() {
		return remark8;
	}
	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}
	public String getRemark9() {
		return remark9;
	}
	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}
	public String getRemark10() {
		return remark10;
	}
	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	private CheckResult datastate;

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

	public CheckResult getDatastate() {
		return datastate;
	}

	public void setDatastate(CheckResult datastate) {
		this.datastate = datastate;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
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
}
