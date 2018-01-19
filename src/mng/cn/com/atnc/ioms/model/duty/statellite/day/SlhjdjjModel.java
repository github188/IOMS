package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class SlhjdjjModel extends MyPaginModel{
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
	
	private String sic; // SIC
	private String sicb; // 备用SIC
	private String ncc; // NCC(上)
	private String nccb; // 备用NCC(下)
	private String dpc1; // DPC1
	private String dpc2; // DPC2
	private String dpc3; // DPC3
	private String dpcb; // 备用DPC
	private String suplim1; // suplim1
	private String suplim2; // suplim2
	private String suplim3; // suplim3
	private String suplim4; // suplim4
	private String suplim5; // suplim5
	private String suplim6; // suplim6
	private String suplimb; // 备用suplimb
	
	public SlhjdjjModel(){}
	public SlhjdjjModel(
			String sic,
			String sicb,
			String ncc,
			String nccb,
			String dpc1,
			String dpc2,
			String dpc3,
			String dpcb,
			String suplim1,
			String suplim2,
			String suplim3,
			String suplim4	,
			String suplim5	,
			String suplim6	,
			String suplimb	,
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		this.sic=sic;
		this.sicb=sicb;
		this.ncc=ncc;
		this.nccb=nccb;
		this.dpc1=dpc1;
		this.dpc2=dpc2;
		this.dpc3=dpc3;
		this.dpcb=dpcb;
		this.suplim1=suplim1;
		this.suplim2=suplim2;
		this.suplim3=suplim3;
		this.suplim4=suplim4;
		this.suplim5=suplim5;
		this.suplim6=suplim6;
		this.suplimb=suplimb;
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


	public String getSic() {
		return sic;
	}


	public void setSic(String sic) {
		this.sic = sic;
	}


	public String getSicb() {
		return sicb;
	}


	public void setSicb(String sicb) {
		this.sicb = sicb;
	}


	public String getNcc() {
		return ncc;
	}


	public void setNcc(String ncc) {
		this.ncc = ncc;
	}


	public String getNccb() {
		return nccb;
	}


	public void setNccb(String nccb) {
		this.nccb = nccb;
	}


	public String getDpc1() {
		return dpc1;
	}


	public void setDpc1(String dpc1) {
		this.dpc1 = dpc1;
	}


	public String getDpc2() {
		return dpc2;
	}


	public void setDpc2(String dpc2) {
		this.dpc2 = dpc2;
	}


	public String getDpc3() {
		return dpc3;
	}


	public void setDpc3(String dpc3) {
		this.dpc3 = dpc3;
	}


	public String getDpcb() {
		return dpcb;
	}


	public void setDpcb(String dpcb) {
		this.dpcb = dpcb;
	}


	public String getSuplim1() {
		return suplim1;
	}


	public void setSuplim1(String suplim1) {
		this.suplim1 = suplim1;
	}


	public String getSuplim2() {
		return suplim2;
	}


	public void setSuplim2(String suplim2) {
		this.suplim2 = suplim2;
	}


	public String getSuplim3() {
		return suplim3;
	}


	public void setSuplim3(String suplim3) {
		this.suplim3 = suplim3;
	}


	public String getSuplim4() {
		return suplim4;
	}


	public void setSuplim4(String suplim4) {
		this.suplim4 = suplim4;
	}


	public String getSuplim5() {
		return suplim5;
	}


	public void setSuplim5(String suplim5) {
		this.suplim5 = suplim5;
	}


	public String getSuplim6() {
		return suplim6;
	}


	public void setSuplim6(String suplim6) {
		this.suplim6 = suplim6;
	}


	public String getSuplimb() {
		return suplimb;
	}


	public void setSuplimb(String suplimb) {
		this.suplimb = suplimb;
	}
	
	

}
