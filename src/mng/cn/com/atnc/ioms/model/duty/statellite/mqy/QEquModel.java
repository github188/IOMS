package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class QEquModel extends MyPaginModel{

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
	
	private String indoorTesJx;
	private String indoorTesNormal;
	private String indoorTesInnormal;
	private String indoorPesJx;
	private String indoorPesNormal;
	private String indoorPesInnormal;
	private String indoorKu1Jx;
	private String indoorKu1Normal;
	private String indoorKu1Innormal;
	private String indoorKu2Jx;
	private String indoorKu2Normal;
	private String indoorKu2Innormal;
	private String indoorKu3Jx;
	private String indoorKu3Normal;
	private String indoorKu3Innormal;
	private String indoorKu4Jx;
	private String indoorKu4Normal;
	private String indoorKu4Innormal;
	private String indoorKuJx;
	private String indoorKuNormal;
	private String indoorKuInnormal;
	private String indoorComJx;
	private String indoorComNormal;
	private String indoorComInnormal;
	private String slhTesJx;
	private String slhTesNormal;
	private String slhTesInnormal;
	private String mhjTesJx;
	private String mhjTesNormal;
	private String mhjTesInnormal;
	private String slhKuJx;
	private String slhKuNormal;
	private String slhKuInnormal;
	private String mhjKuJx;
	private String mhjKuNormal;
	private String mhjKuInnormal;
	private String kuTestJx;
	private String kuTestNormal;
	private String kuTestInnormal;

	private String outdoorTesJx;
	private String outdoorTesNormal;
	private String outdoorTesInnormal;
	private String outdoorPesJx;
	private String outdoorPesNormal;
	private String outdoorPesInnormal;
	private String outdoorKuJx;
	private String outdoorKuNormal;
	private String outdoorKuInnormal;
	private String outdoorComJx;
	private String outdoorComNormal;
	private String outdoorComInnormal;
	private String outdoorSlhtesJx;
	private String outdoorSlhtesNormal;
	private String outdoorSlhtesInnormal;
	private String outdoorMhjtesJx;
	private String outdoorMhjtesNormal;
	private String outdoorMhjtesInnormal;
	private String outdoorSlhkuJx;
	private String outdoorSlhkuNormal;
	private String outdoorSlhkuInnormal;
	private String outdoorMhjkuJx;
	private String outdoorMhjkuNormal;
	private String outdoorMhjkuInnormal;
	private String outdoorKucsJx;
	private String outdoorKucsNormal;
	private String outdoorKucsInnormal;

	private String wgTesJx;
	private String wgTesNormal;
	private String wgTesInnormal;
	private String wgPesJx;
	private String wgPesNormal;
	private String wgPesInnormal;
	private String wgKu1Jx;
	private String wgKu1Normal;
	private String wgKu1Innormal;
	private String wgKu2Jx;
	private String wgKu2Normal;
	private String wgKu2Innormal;
	private String wgKu3Jx;
	private String wgKu3Normal;
	private String wgKu3Innormal;
	private String wgKu4Jx;
	private String wgKu4Normal;
	private String wgKu4Innormal;
	private String wgKuJx;
	private String wgKuNormal;
	private String wgKuInnormal;

	private String indoorTesRemark;
	private String indoorPesRemark;
	private String indoorKu1Remark;
	private String indoorKu2Remark;
	private String indoorKu3Remark;
	private String indoorKu4Remark;
	private String indoorRelayRemark;
	private String indoorOutRemark;
	private String indoorSlhTes;
	private String indoorMhjTes;
	private String indoorSlhKu;
	private String indoorMhjKu;
	private String indoorKuTest;

	private String outdoorTesRemark;
	private String outdoorPesRemark;
	private String outdoorKuRemark;
	private String outdoorSlhTes;
	private String outdoorMhjTes;
	private String outdoorSlhKu;
	private String outdoorMhjKu;
	private String outdoorKuTest;
	private String outdoorOutRemark;

	private String wgTesRemark;
	private String wgPesRemark;
	private String wgKu1Remark;
	private String wgKu2Remark;
	private String wgKu3Remark;
	private String wgKu4Remark;
	private String wgRelayKu;
	
	public QEquModel(){}
	public QEquModel(
			String indoorTesJx,
			String indoorTesNormal,
			String indoorTesInnormal,
			String indoorPesJx,
			String indoorPesNormal,
			String indoorPesInnormal,
			String indoorKu1Jx,
			String indoorKu1Normal,
			String indoorKu1Innormal,
			String indoorKu2Jx,
			String indoorKu2Normal,
			String indoorKu2Innormal,
			String indoorKu3Jx,
			String indoorKu3Normal,
			String indoorKu3Innormal,
			String indoorKu4Jx,
			String indoorKu4Normal,
			String indoorKu4Innormal,
			String indoorKuJx,
			String indoorKuNormal,
			String indoorKuInnormal,
			String indoorComJx,
			String indoorComNormal,
			String indoorComInnormal,
			String slhTesJx,
			String slhTesNormal,
			String slhTesInnormal,
			String mhjTesJx,
			String mhjTesNormal,
			String mhjTesInnormal,
			String slhKuJx,
			String slhKuNormal,
			String slhKuInnormal,
			String mhjKuJx,
			String mhjKuNormal,
			String mhjKuInnormal,
			String kuTestJx,
			String kuTestNormal,
			String kuTestInnormal,
			
			  String outdoorTesJx,
			  String outdoorTesNormal,
			  String outdoorTesInnormal,
			  String outdoorPesJx,
			  String outdoorPesNormal,
			  String outdoorPesInnormal,
			  String outdoorKuJx,
			  String outdoorKuNormal,
			  String outdoorKuInnormal,
			  String outdoorComJx,
			  String outdoorComNormal,
			  String outdoorComInnormal,
			  String outdoorSlhtesJx,
			  String outdoorSlhtesNormal,
			  String outdoorSlhtesInnormal,
			  String outdoorMhjtesJx,
			  String outdoorMhjtesNormal,
			  String outdoorMhjtesInnormal,
			  String outdoorSlhkuJx,
			  String outdoorSlhkuNormal,
			  String outdoorSlhkuInnormal,
			  String outdoorMhjkuJx,
			  String outdoorMhjkuNormal,
			  String outdoorMhjkuInnormal,
			  String outdoorKucsJx,
			  String outdoorKucsNormal,
			  String outdoorKucsInnormal,

			  String wgTesJx,
			  String wgTesNormal,
			  String wgTesInnormal,
			  String wgPesJx,
			  String wgPesNormal,
			  String wgPesInnormal,
			  String wgKu1Jx,
			  String wgKu1Normal,
			  String wgKu1Innormal,
			  String wgKu2Jx,
			  String wgKu2Normal,
			  String wgKu2Innormal,
			  String wgKu3Jx,
			  String wgKu3Normal,
			  String wgKu3Innormal,
			  String wgKu4Jx,
			  String wgKu4Normal,
			  String wgKu4Innormal,
			  String wgKuJx,
			  String wgKuNormal,
			  String wgKuInnormal,

			  String indoorTesRemark,
			  String indoorPesRemark,
			  String indoorKu1Remark,
			  String indoorKu2Remark,
			  String indoorKu3Remark,
			  String indoorKu4Remark,
			  String indoorRelayRemark,
			  String indoorOutRemark,
			  String indoorSlhTes,
			  String indoorMhjTes,
			  String indoorSlhKu,
			  String indoorMhjKu,
			  String indoorKuTest,

			  String outdoorTesRemark,
			  String outdoorPesRemark,
			  String outdoorKuRemark,
			  String outdoorSlhTes,
			  String outdoorMhjTes,
			  String outdoorSlhKu,
			  String outdoorMhjKu,
			  String outdoorKuTest,
			  String outdoorOutRemark,

			  String wgTesRemark,
			  String wgPesRemark,
			  String wgKu1Remark,
			  String wgKu2Remark,
			  String wgKu3Remark,
			  String wgKu4Remark,
			  String wgRelayKu,
			
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		
		this.indoorTesJx=indoorTesJx;
		this.indoorTesNormal=indoorTesNormal;
		this.indoorTesInnormal=indoorTesInnormal;
		this.indoorPesJx=indoorPesJx;
		this.indoorPesNormal=indoorPesNormal;
		this.indoorPesInnormal=indoorPesInnormal;
		this.indoorKu1Jx=indoorKu1Jx;
		this.indoorKu1Normal=indoorKu1Normal;
		this.indoorKu1Innormal=indoorKu1Innormal;
		this.indoorKu2Jx=indoorKu2Jx;
		this.indoorKu2Normal=indoorKu2Normal;
		this.indoorKu2Innormal=indoorKu2Innormal;
		this.indoorKu3Jx=indoorKu3Jx;
		this.indoorKu3Normal=indoorKu3Normal;
		this.indoorKu3Innormal=indoorKu3Innormal;
		this.indoorKu4Jx=indoorKu4Jx;
		this.indoorKu4Normal=indoorKu4Normal;
		this.indoorKu4Innormal=indoorKu4Innormal;
		this.indoorKuJx=indoorKuJx;
		this.indoorKuNormal=indoorKuNormal;
		this.indoorKuInnormal=indoorKuInnormal;
		this.indoorComJx=indoorComJx;
		this.indoorComNormal=indoorComNormal;
		this.indoorComInnormal=indoorComInnormal;
		this.slhTesJx=slhTesJx;
		this.slhTesNormal=slhTesNormal;
		this.slhTesInnormal=slhTesInnormal;
		this.mhjTesJx=mhjTesJx;
		this.mhjTesNormal=mhjTesNormal;
		this.mhjTesInnormal=mhjTesInnormal;
		this.slhKuJx=slhKuJx;
		this.slhKuNormal=slhKuNormal;
		this.slhKuInnormal=slhKuInnormal;
		this.mhjKuJx=mhjKuJx;
		this.mhjKuNormal=mhjKuNormal;
		this.mhjKuInnormal=mhjKuInnormal;
		this.kuTestJx=kuTestJx;
		this.kuTestNormal=kuTestNormal;
		this.kuTestInnormal=kuTestInnormal;
		
		  this.outdoorTesJx=outdoorTesJx;
		  this.outdoorTesNormal=outdoorTesNormal;
		  this.outdoorTesInnormal=outdoorTesInnormal;
		  this.outdoorPesJx=outdoorPesJx;
		  this.outdoorPesNormal=outdoorPesNormal;
		  this.outdoorPesInnormal=outdoorPesInnormal;
		  this.outdoorKuJx=outdoorKuJx;
		  this.outdoorKuNormal=outdoorKuNormal;
		  this.outdoorKuInnormal=outdoorKuInnormal;
		  this.outdoorComJx=outdoorComJx;
		  this.outdoorComNormal=outdoorComNormal;
		  this.outdoorComInnormal=outdoorComInnormal;
		  this.outdoorSlhtesJx=outdoorSlhtesJx;
		  this.outdoorSlhtesNormal=outdoorSlhtesNormal;
		  this.outdoorSlhtesInnormal=outdoorSlhtesInnormal;
		  this.outdoorMhjtesJx=outdoorMhjtesJx;
		  this.outdoorMhjtesNormal=outdoorMhjtesNormal;
		  this.outdoorMhjtesInnormal=outdoorMhjtesInnormal;
		  this.outdoorSlhkuJx=outdoorSlhkuJx;
		  this.outdoorSlhkuNormal=outdoorSlhkuNormal;
		  this.outdoorSlhkuInnormal=outdoorSlhkuInnormal;
		  this.outdoorMhjkuJx=outdoorMhjkuJx;
		  this.outdoorMhjkuNormal=outdoorMhjkuNormal;
		  this.outdoorMhjkuInnormal=outdoorMhjkuInnormal;
		  this.outdoorKucsJx=outdoorKucsJx;
		  this.outdoorKucsNormal=outdoorKucsNormal;
		  this.outdoorKucsInnormal=outdoorKucsInnormal;

		  this.wgTesJx=wgTesJx;
		  this.wgTesNormal=wgTesNormal;
		  this.wgTesInnormal=wgTesInnormal;
		  this.wgPesJx=wgPesJx;
		  this.wgPesNormal=wgPesNormal;
		  this.wgPesInnormal=wgPesInnormal;
		  this.wgKu1Jx=wgKu1Jx;
		  this.wgKu1Normal=wgKu1Normal;
		  this.wgKu1Innormal=wgKu1Innormal;
		  this.wgKu2Jx=wgKu2Jx;
		  this.wgKu2Normal=wgKu2Normal;
		  this.wgKu2Innormal=wgKu2Innormal;
		  this.wgKu3Jx=wgKu3Jx;
		  this.wgKu3Normal=wgKu3Normal;
		  this.wgKu3Innormal=wgKu3Innormal;
		  this.wgKu4Jx=wgKu4Jx;
		  this.wgKu4Normal=wgKu4Normal;
		  this.wgKu4Innormal=wgKu4Innormal;
		  this.wgKuJx=wgKuJx;
		  this.wgKuNormal=wgKuNormal;
		  this.wgKuInnormal=wgKuInnormal;

		  this.indoorTesRemark=indoorTesRemark;
		  this.indoorPesRemark=indoorPesRemark;
		  this.indoorKu1Remark=indoorKu1Remark;
		  this.indoorKu2Remark=indoorKu2Remark;
		  this.indoorKu3Remark=indoorKu3Remark;
		  this.indoorKu4Remark=indoorKu4Remark;
		  this.indoorRelayRemark=indoorRelayRemark;
		  this.indoorOutRemark=indoorOutRemark;
		  this.indoorSlhTes=indoorSlhTes;
		  this.indoorMhjTes=indoorMhjTes;
		  this.indoorSlhKu=indoorSlhKu;
		  this.indoorMhjKu=indoorMhjKu;
		  this.indoorKuTest=indoorKuTest;

		  this.outdoorTesRemark=outdoorTesRemark;
		  this.outdoorPesRemark=outdoorPesRemark;
		  this.outdoorKuRemark=outdoorKuRemark;
		  this.outdoorSlhTes=outdoorSlhTes;
		  this.outdoorMhjTes=outdoorMhjTes;
		  this.outdoorSlhKu=outdoorSlhKu;
		  this.outdoorMhjKu=outdoorMhjKu;
		  this.outdoorKuTest=outdoorKuTest;
		  this.outdoorOutRemark=outdoorOutRemark;

		  this.wgTesRemark=wgTesRemark;
		  this.wgPesRemark=wgPesRemark;
		  this.wgKu1Remark=wgKu1Remark;
		  this.wgKu2Remark=wgKu2Remark;
		  this.wgKu3Remark=wgKu3Remark;
		  this.wgKu4Remark=wgKu4Remark;
		  this.wgRelayKu=wgRelayKu;
		
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
	public String getIndoorTesJx() {
		return indoorTesJx;
	}
	public void setIndoorTesJx(String indoorTesJx) {
		this.indoorTesJx = indoorTesJx;
	}
	public String getIndoorTesNormal() {
		return indoorTesNormal;
	}
	public void setIndoorTesNormal(String indoorTesNormal) {
		this.indoorTesNormal = indoorTesNormal;
	}
	public String getIndoorTesInnormal() {
		return indoorTesInnormal;
	}
	public void setIndoorTesInnormal(String indoorTesInnormal) {
		this.indoorTesInnormal = indoorTesInnormal;
	}
	public String getIndoorPesJx() {
		return indoorPesJx;
	}
	public void setIndoorPesJx(String indoorPesJx) {
		this.indoorPesJx = indoorPesJx;
	}
	public String getIndoorPesNormal() {
		return indoorPesNormal;
	}
	public void setIndoorPesNormal(String indoorPesNormal) {
		this.indoorPesNormal = indoorPesNormal;
	}
	public String getIndoorPesInnormal() {
		return indoorPesInnormal;
	}
	public void setIndoorPesInnormal(String indoorPesInnormal) {
		this.indoorPesInnormal = indoorPesInnormal;
	}
	public String getIndoorKu1Jx() {
		return indoorKu1Jx;
	}
	public void setIndoorKu1Jx(String indoorKu1Jx) {
		this.indoorKu1Jx = indoorKu1Jx;
	}
	public String getIndoorKu1Normal() {
		return indoorKu1Normal;
	}
	public void setIndoorKu1Normal(String indoorKu1Normal) {
		this.indoorKu1Normal = indoorKu1Normal;
	}
	public String getIndoorKu1Innormal() {
		return indoorKu1Innormal;
	}
	public void setIndoorKu1Innormal(String indoorKu1Innormal) {
		this.indoorKu1Innormal = indoorKu1Innormal;
	}
	public String getIndoorKu2Jx() {
		return indoorKu2Jx;
	}
	public void setIndoorKu2Jx(String indoorKu2Jx) {
		this.indoorKu2Jx = indoorKu2Jx;
	}
	public String getIndoorKu2Normal() {
		return indoorKu2Normal;
	}
	public void setIndoorKu2Normal(String indoorKu2Normal) {
		this.indoorKu2Normal = indoorKu2Normal;
	}
	public String getIndoorKu2Innormal() {
		return indoorKu2Innormal;
	}
	public void setIndoorKu2Innormal(String indoorKu2Innormal) {
		this.indoorKu2Innormal = indoorKu2Innormal;
	}
	public String getIndoorKu3Jx() {
		return indoorKu3Jx;
	}
	public void setIndoorKu3Jx(String indoorKu3Jx) {
		this.indoorKu3Jx = indoorKu3Jx;
	}
	public String getIndoorKu3Normal() {
		return indoorKu3Normal;
	}
	public void setIndoorKu3Normal(String indoorKu3Normal) {
		this.indoorKu3Normal = indoorKu3Normal;
	}
	public String getIndoorKu3Innormal() {
		return indoorKu3Innormal;
	}
	public void setIndoorKu3Innormal(String indoorKu3Innormal) {
		this.indoorKu3Innormal = indoorKu3Innormal;
	}
	public String getIndoorKu4Jx() {
		return indoorKu4Jx;
	}
	public void setIndoorKu4Jx(String indoorKu4Jx) {
		this.indoorKu4Jx = indoorKu4Jx;
	}
	public String getIndoorKu4Normal() {
		return indoorKu4Normal;
	}
	public void setIndoorKu4Normal(String indoorKu4Normal) {
		this.indoorKu4Normal = indoorKu4Normal;
	}
	public String getIndoorKu4Innormal() {
		return indoorKu4Innormal;
	}
	public void setIndoorKu4Innormal(String indoorKu4Innormal) {
		this.indoorKu4Innormal = indoorKu4Innormal;
	}
	public String getIndoorKuJx() {
		return indoorKuJx;
	}
	public void setIndoorKuJx(String indoorKuJx) {
		this.indoorKuJx = indoorKuJx;
	}
	public String getIndoorKuNormal() {
		return indoorKuNormal;
	}
	public void setIndoorKuNormal(String indoorKuNormal) {
		this.indoorKuNormal = indoorKuNormal;
	}
	public String getIndoorKuInnormal() {
		return indoorKuInnormal;
	}
	public void setIndoorKuInnormal(String indoorKuInnormal) {
		this.indoorKuInnormal = indoorKuInnormal;
	}
	public String getIndoorComJx() {
		return indoorComJx;
	}
	public void setIndoorComJx(String indoorComJx) {
		this.indoorComJx = indoorComJx;
	}
	public String getIndoorComNormal() {
		return indoorComNormal;
	}
	public void setIndoorComNormal(String indoorComNormal) {
		this.indoorComNormal = indoorComNormal;
	}
	public String getIndoorComInnormal() {
		return indoorComInnormal;
	}
	public void setIndoorComInnormal(String indoorComInnormal) {
		this.indoorComInnormal = indoorComInnormal;
	}
	public String getSlhTesJx() {
		return slhTesJx;
	}
	public void setSlhTesJx(String slhTesJx) {
		this.slhTesJx = slhTesJx;
	}
	public String getSlhTesNormal() {
		return slhTesNormal;
	}
	public void setSlhTesNormal(String slhTesNormal) {
		this.slhTesNormal = slhTesNormal;
	}
	public String getSlhTesInnormal() {
		return slhTesInnormal;
	}
	public void setSlhTesInnormal(String slhTesInnormal) {
		this.slhTesInnormal = slhTesInnormal;
	}
	public String getMhjTesJx() {
		return mhjTesJx;
	}
	public void setMhjTesJx(String mhjTesJx) {
		this.mhjTesJx = mhjTesJx;
	}
	public String getMhjTesNormal() {
		return mhjTesNormal;
	}
	public void setMhjTesNormal(String mhjTesNormal) {
		this.mhjTesNormal = mhjTesNormal;
	}
	public String getMhjTesInnormal() {
		return mhjTesInnormal;
	}
	public void setMhjTesInnormal(String mhjTesInnormal) {
		this.mhjTesInnormal = mhjTesInnormal;
	}
	public String getSlhKuJx() {
		return slhKuJx;
	}
	public void setSlhKuJx(String slhKuJx) {
		this.slhKuJx = slhKuJx;
	}
	public String getSlhKuNormal() {
		return slhKuNormal;
	}
	public void setSlhKuNormal(String slhKuNormal) {
		this.slhKuNormal = slhKuNormal;
	}
	public String getSlhKuInnormal() {
		return slhKuInnormal;
	}
	public void setSlhKuInnormal(String slhKuInnormal) {
		this.slhKuInnormal = slhKuInnormal;
	}
	public String getMhjKuJx() {
		return mhjKuJx;
	}
	public void setMhjKuJx(String mhjKuJx) {
		this.mhjKuJx = mhjKuJx;
	}
	public String getMhjKuNormal() {
		return mhjKuNormal;
	}
	public void setMhjKuNormal(String mhjKuNormal) {
		this.mhjKuNormal = mhjKuNormal;
	}
	public String getMhjKuInnormal() {
		return mhjKuInnormal;
	}
	public void setMhjKuInnormal(String mhjKuInnormal) {
		this.mhjKuInnormal = mhjKuInnormal;
	}
	public String getKuTestJx() {
		return kuTestJx;
	}
	public void setKuTestJx(String kuTestJx) {
		this.kuTestJx = kuTestJx;
	}
	public String getKuTestNormal() {
		return kuTestNormal;
	}
	public void setKuTestNormal(String kuTestNormal) {
		this.kuTestNormal = kuTestNormal;
	}
	public String getKuTestInnormal() {
		return kuTestInnormal;
	}
	public void setKuTestInnormal(String kuTestInnormal) {
		this.kuTestInnormal = kuTestInnormal;
	}
	public String getOutdoorTesJx() {
		return outdoorTesJx;
	}
	public void setOutdoorTesJx(String outdoorTesJx) {
		this.outdoorTesJx = outdoorTesJx;
	}
	public String getOutdoorTesNormal() {
		return outdoorTesNormal;
	}
	public void setOutdoorTesNormal(String outdoorTesNormal) {
		this.outdoorTesNormal = outdoorTesNormal;
	}
	public String getOutdoorTesInnormal() {
		return outdoorTesInnormal;
	}
	public void setOutdoorTesInnormal(String outdoorTesInnormal) {
		this.outdoorTesInnormal = outdoorTesInnormal;
	}
	public String getOutdoorPesJx() {
		return outdoorPesJx;
	}
	public void setOutdoorPesJx(String outdoorPesJx) {
		this.outdoorPesJx = outdoorPesJx;
	}
	public String getOutdoorPesNormal() {
		return outdoorPesNormal;
	}
	public void setOutdoorPesNormal(String outdoorPesNormal) {
		this.outdoorPesNormal = outdoorPesNormal;
	}
	public String getOutdoorPesInnormal() {
		return outdoorPesInnormal;
	}
	public void setOutdoorPesInnormal(String outdoorPesInnormal) {
		this.outdoorPesInnormal = outdoorPesInnormal;
	}
	public String getOutdoorKuJx() {
		return outdoorKuJx;
	}
	public void setOutdoorKuJx(String outdoorKuJx) {
		this.outdoorKuJx = outdoorKuJx;
	}
	public String getOutdoorKuNormal() {
		return outdoorKuNormal;
	}
	public void setOutdoorKuNormal(String outdoorKuNormal) {
		this.outdoorKuNormal = outdoorKuNormal;
	}
	public String getOutdoorKuInnormal() {
		return outdoorKuInnormal;
	}
	public void setOutdoorKuInnormal(String outdoorKuInnormal) {
		this.outdoorKuInnormal = outdoorKuInnormal;
	}
	public String getOutdoorComJx() {
		return outdoorComJx;
	}
	public void setOutdoorComJx(String outdoorComJx) {
		this.outdoorComJx = outdoorComJx;
	}
	public String getOutdoorComNormal() {
		return outdoorComNormal;
	}
	public void setOutdoorComNormal(String outdoorComNormal) {
		this.outdoorComNormal = outdoorComNormal;
	}
	public String getOutdoorComInnormal() {
		return outdoorComInnormal;
	}
	public void setOutdoorComInnormal(String outdoorComInnormal) {
		this.outdoorComInnormal = outdoorComInnormal;
	}
	public String getOutdoorSlhtesJx() {
		return outdoorSlhtesJx;
	}
	public void setOutdoorSlhtesJx(String outdoorSlhtesJx) {
		this.outdoorSlhtesJx = outdoorSlhtesJx;
	}
	public String getOutdoorSlhtesNormal() {
		return outdoorSlhtesNormal;
	}
	public void setOutdoorSlhtesNormal(String outdoorSlhtesNormal) {
		this.outdoorSlhtesNormal = outdoorSlhtesNormal;
	}
	public String getOutdoorSlhtesInnormal() {
		return outdoorSlhtesInnormal;
	}
	public void setOutdoorSlhtesInnormal(String outdoorSlhtesInnormal) {
		this.outdoorSlhtesInnormal = outdoorSlhtesInnormal;
	}
	public String getOutdoorMhjtesJx() {
		return outdoorMhjtesJx;
	}
	public void setOutdoorMhjtesJx(String outdoorMhjtesJx) {
		this.outdoorMhjtesJx = outdoorMhjtesJx;
	}
	public String getOutdoorMhjtesNormal() {
		return outdoorMhjtesNormal;
	}
	public void setOutdoorMhjtesNormal(String outdoorMhjtesNormal) {
		this.outdoorMhjtesNormal = outdoorMhjtesNormal;
	}
	public String getOutdoorMhjtesInnormal() {
		return outdoorMhjtesInnormal;
	}
	public void setOutdoorMhjtesInnormal(String outdoorMhjtesInnormal) {
		this.outdoorMhjtesInnormal = outdoorMhjtesInnormal;
	}
	public String getOutdoorSlhkuJx() {
		return outdoorSlhkuJx;
	}
	public void setOutdoorSlhkuJx(String outdoorSlhkuJx) {
		this.outdoorSlhkuJx = outdoorSlhkuJx;
	}
	public String getOutdoorSlhkuNormal() {
		return outdoorSlhkuNormal;
	}
	public void setOutdoorSlhkuNormal(String outdoorSlhkuNormal) {
		this.outdoorSlhkuNormal = outdoorSlhkuNormal;
	}
	public String getOutdoorSlhkuInnormal() {
		return outdoorSlhkuInnormal;
	}
	public void setOutdoorSlhkuInnormal(String outdoorSlhkuInnormal) {
		this.outdoorSlhkuInnormal = outdoorSlhkuInnormal;
	}
	public String getOutdoorMhjkuJx() {
		return outdoorMhjkuJx;
	}
	public void setOutdoorMhjkuJx(String outdoorMhjkuJx) {
		this.outdoorMhjkuJx = outdoorMhjkuJx;
	}
	public String getOutdoorMhjkuNormal() {
		return outdoorMhjkuNormal;
	}
	public void setOutdoorMhjkuNormal(String outdoorMhjkuNormal) {
		this.outdoorMhjkuNormal = outdoorMhjkuNormal;
	}
	public String getOutdoorMhjkuInnormal() {
		return outdoorMhjkuInnormal;
	}
	public void setOutdoorMhjkuInnormal(String outdoorMhjkuInnormal) {
		this.outdoorMhjkuInnormal = outdoorMhjkuInnormal;
	}
	public String getOutdoorKucsJx() {
		return outdoorKucsJx;
	}
	public void setOutdoorKucsJx(String outdoorKucsJx) {
		this.outdoorKucsJx = outdoorKucsJx;
	}
	public String getOutdoorKucsNormal() {
		return outdoorKucsNormal;
	}
	public void setOutdoorKucsNormal(String outdoorKucsNormal) {
		this.outdoorKucsNormal = outdoorKucsNormal;
	}
	public String getOutdoorKucsInnormal() {
		return outdoorKucsInnormal;
	}
	public void setOutdoorKucsInnormal(String outdoorKucsInnormal) {
		this.outdoorKucsInnormal = outdoorKucsInnormal;
	}
	public String getWgTesJx() {
		return wgTesJx;
	}
	public void setWgTesJx(String wgTesJx) {
		this.wgTesJx = wgTesJx;
	}
	public String getWgTesNormal() {
		return wgTesNormal;
	}
	public void setWgTesNormal(String wgTesNormal) {
		this.wgTesNormal = wgTesNormal;
	}
	public String getWgTesInnormal() {
		return wgTesInnormal;
	}
	public void setWgTesInnormal(String wgTesInnormal) {
		this.wgTesInnormal = wgTesInnormal;
	}
	public String getWgPesJx() {
		return wgPesJx;
	}
	public void setWgPesJx(String wgPesJx) {
		this.wgPesJx = wgPesJx;
	}
	public String getWgPesNormal() {
		return wgPesNormal;
	}
	public void setWgPesNormal(String wgPesNormal) {
		this.wgPesNormal = wgPesNormal;
	}
	public String getWgPesInnormal() {
		return wgPesInnormal;
	}
	public void setWgPesInnormal(String wgPesInnormal) {
		this.wgPesInnormal = wgPesInnormal;
	}
	public String getWgKu1Jx() {
		return wgKu1Jx;
	}
	public void setWgKu1Jx(String wgKu1Jx) {
		this.wgKu1Jx = wgKu1Jx;
	}
	public String getWgKu1Normal() {
		return wgKu1Normal;
	}
	public void setWgKu1Normal(String wgKu1Normal) {
		this.wgKu1Normal = wgKu1Normal;
	}
	public String getWgKu1Innormal() {
		return wgKu1Innormal;
	}
	public void setWgKu1Innormal(String wgKu1Innormal) {
		this.wgKu1Innormal = wgKu1Innormal;
	}
	public String getWgKu2Jx() {
		return wgKu2Jx;
	}
	public void setWgKu2Jx(String wgKu2Jx) {
		this.wgKu2Jx = wgKu2Jx;
	}
	public String getWgKu2Normal() {
		return wgKu2Normal;
	}
	public void setWgKu2Normal(String wgKu2Normal) {
		this.wgKu2Normal = wgKu2Normal;
	}
	public String getWgKu2Innormal() {
		return wgKu2Innormal;
	}
	public void setWgKu2Innormal(String wgKu2Innormal) {
		this.wgKu2Innormal = wgKu2Innormal;
	}
	public String getWgKu3Jx() {
		return wgKu3Jx;
	}
	public void setWgKu3Jx(String wgKu3Jx) {
		this.wgKu3Jx = wgKu3Jx;
	}
	public String getWgKu3Normal() {
		return wgKu3Normal;
	}
	public void setWgKu3Normal(String wgKu3Normal) {
		this.wgKu3Normal = wgKu3Normal;
	}
	public String getWgKu3Innormal() {
		return wgKu3Innormal;
	}
	public void setWgKu3Innormal(String wgKu3Innormal) {
		this.wgKu3Innormal = wgKu3Innormal;
	}
	public String getWgKu4Jx() {
		return wgKu4Jx;
	}
	public void setWgKu4Jx(String wgKu4Jx) {
		this.wgKu4Jx = wgKu4Jx;
	}
	public String getWgKu4Normal() {
		return wgKu4Normal;
	}
	public void setWgKu4Normal(String wgKu4Normal) {
		this.wgKu4Normal = wgKu4Normal;
	}
	public String getWgKu4Innormal() {
		return wgKu4Innormal;
	}
	public void setWgKu4Innormal(String wgKu4Innormal) {
		this.wgKu4Innormal = wgKu4Innormal;
	}
	public String getWgKuJx() {
		return wgKuJx;
	}
	public void setWgKuJx(String wgKuJx) {
		this.wgKuJx = wgKuJx;
	}
	public String getWgKuNormal() {
		return wgKuNormal;
	}
	public void setWgKuNormal(String wgKuNormal) {
		this.wgKuNormal = wgKuNormal;
	}
	public String getWgKuInnormal() {
		return wgKuInnormal;
	}
	public void setWgKuInnormal(String wgKuInnormal) {
		this.wgKuInnormal = wgKuInnormal;
	}
	public String getIndoorTesRemark() {
		return indoorTesRemark;
	}
	public void setIndoorTesRemark(String indoorTesRemark) {
		this.indoorTesRemark = indoorTesRemark;
	}
	public String getIndoorPesRemark() {
		return indoorPesRemark;
	}
	public void setIndoorPesRemark(String indoorPesRemark) {
		this.indoorPesRemark = indoorPesRemark;
	}
	public String getIndoorKu1Remark() {
		return indoorKu1Remark;
	}
	public void setIndoorKu1Remark(String indoorKu1Remark) {
		this.indoorKu1Remark = indoorKu1Remark;
	}
	public String getIndoorKu2Remark() {
		return indoorKu2Remark;
	}
	public void setIndoorKu2Remark(String indoorKu2Remark) {
		this.indoorKu2Remark = indoorKu2Remark;
	}
	public String getIndoorKu3Remark() {
		return indoorKu3Remark;
	}
	public void setIndoorKu3Remark(String indoorKu3Remark) {
		this.indoorKu3Remark = indoorKu3Remark;
	}
	public String getIndoorKu4Remark() {
		return indoorKu4Remark;
	}
	public void setIndoorKu4Remark(String indoorKu4Remark) {
		this.indoorKu4Remark = indoorKu4Remark;
	}
	public String getIndoorRelayRemark() {
		return indoorRelayRemark;
	}
	public void setIndoorRelayRemark(String indoorRelayRemark) {
		this.indoorRelayRemark = indoorRelayRemark;
	}
	public String getIndoorOutRemark() {
		return indoorOutRemark;
	}
	public void setIndoorOutRemark(String indoorOutRemark) {
		this.indoorOutRemark = indoorOutRemark;
	}
	public String getIndoorSlhTes() {
		return indoorSlhTes;
	}
	public void setIndoorSlhTes(String indoorSlhTes) {
		this.indoorSlhTes = indoorSlhTes;
	}
	public String getIndoorMhjTes() {
		return indoorMhjTes;
	}
	public void setIndoorMhjTes(String indoorMhjTes) {
		this.indoorMhjTes = indoorMhjTes;
	}
	public String getIndoorSlhKu() {
		return indoorSlhKu;
	}
	public void setIndoorSlhKu(String indoorSlhKu) {
		this.indoorSlhKu = indoorSlhKu;
	}
	public String getIndoorMhjKu() {
		return indoorMhjKu;
	}
	public void setIndoorMhjKu(String indoorMhjKu) {
		this.indoorMhjKu = indoorMhjKu;
	}
	public String getIndoorKuTest() {
		return indoorKuTest;
	}
	public void setIndoorKuTest(String indoorKuTest) {
		this.indoorKuTest = indoorKuTest;
	}
	public String getOutdoorTesRemark() {
		return outdoorTesRemark;
	}
	public void setOutdoorTesRemark(String outdoorTesRemark) {
		this.outdoorTesRemark = outdoorTesRemark;
	}
	public String getOutdoorPesRemark() {
		return outdoorPesRemark;
	}
	public void setOutdoorPesRemark(String outdoorPesRemark) {
		this.outdoorPesRemark = outdoorPesRemark;
	}
	public String getOutdoorKuRemark() {
		return outdoorKuRemark;
	}
	public void setOutdoorKuRemark(String outdoorKuRemark) {
		this.outdoorKuRemark = outdoorKuRemark;
	}
	public String getOutdoorSlhTes() {
		return outdoorSlhTes;
	}
	public void setOutdoorSlhTes(String outdoorSlhTes) {
		this.outdoorSlhTes = outdoorSlhTes;
	}
	public String getOutdoorMhjTes() {
		return outdoorMhjTes;
	}
	public void setOutdoorMhjTes(String outdoorMhjTes) {
		this.outdoorMhjTes = outdoorMhjTes;
	}
	public String getOutdoorSlhKu() {
		return outdoorSlhKu;
	}
	public void setOutdoorSlhKu(String outdoorSlhKu) {
		this.outdoorSlhKu = outdoorSlhKu;
	}
	public String getOutdoorMhjKu() {
		return outdoorMhjKu;
	}
	public void setOutdoorMhjKu(String outdoorMhjKu) {
		this.outdoorMhjKu = outdoorMhjKu;
	}
	public String getOutdoorKuTest() {
		return outdoorKuTest;
	}
	public void setOutdoorKuTest(String outdoorKuTest) {
		this.outdoorKuTest = outdoorKuTest;
	}
	public String getOutdoorOutRemark() {
		return outdoorOutRemark;
	}
	public void setOutdoorOutRemark(String outdoorOutRemark) {
		this.outdoorOutRemark = outdoorOutRemark;
	}
	public String getWgTesRemark() {
		return wgTesRemark;
	}
	public void setWgTesRemark(String wgTesRemark) {
		this.wgTesRemark = wgTesRemark;
	}
	public String getWgPesRemark() {
		return wgPesRemark;
	}
	public void setWgPesRemark(String wgPesRemark) {
		this.wgPesRemark = wgPesRemark;
	}
	public String getWgKu1Remark() {
		return wgKu1Remark;
	}
	public void setWgKu1Remark(String wgKu1Remark) {
		this.wgKu1Remark = wgKu1Remark;
	}
	public String getWgKu2Remark() {
		return wgKu2Remark;
	}
	public void setWgKu2Remark(String wgKu2Remark) {
		this.wgKu2Remark = wgKu2Remark;
	}
	public String getWgKu3Remark() {
		return wgKu3Remark;
	}
	public void setWgKu3Remark(String wgKu3Remark) {
		this.wgKu3Remark = wgKu3Remark;
	}
	public String getWgKu4Remark() {
		return wgKu4Remark;
	}
	public void setWgKu4Remark(String wgKu4Remark) {
		this.wgKu4Remark = wgKu4Remark;
	}
	public String getWgRelayKu() {
		return wgRelayKu;
	}
	public void setWgRelayKu(String wgRelayKu) {
		this.wgRelayKu = wgRelayKu;
	}
	
	
	
	
}
