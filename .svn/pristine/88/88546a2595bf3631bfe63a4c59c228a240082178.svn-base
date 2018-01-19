package cn.com.atnc.ioms.model.faultmng;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEvaluateStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultEventType;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultLevelType;
import cn.com.atnc.ioms.enums.faultmng.FaultOriginType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.model.MyPaginModel;

import java.util.List;

/**
 * 故障单查询model
 * @author duanyanlin 
 * 2016年6月17日 下午2:16:03
 */
public class FaultHandleQueryModel extends MyPaginModel {
	private String startOptTime;
	private String endOptTime;
	private String optType;							//tab页
	private int index;
	private String contactsName;					//申告联系人
	private List<FaultStatus> faultStatus;			//故障单状态列表
	private FaultStatus status;						//故障单状态
	private DutyPlaceEnum dutyPlace;				//添加故障单的地点
	private User firstHandleUser;					//第一处理人
	private String currentHandleUser;				//当前处理人
	private String faultId;							//故障单ID
	private String faultNumber;						//故障单编号
	
	private User currentUser;						//当前登录用户
	
	private FaultHandelType faultHandelType;		//故障处置操作种类
	private FaultLevelType faultLevel;				//事件级别
	private FaultOriginType source;					//事件单来源
	//绑定故障单时，模糊查询使用
	private String faultArea;						//故障发生地
	private String faultCompany;						//故障发生单位
	private Integer faultChildNumber;				//绑定故障单时使用
	
	private FaultInformation parentId;						//父级故障单编号
	
	/** 查询统计模块使用 */
	private String telephoneNumber; 			// 申告电话
	private FaultEventType eventType; 			// 故障类别
	private String stationPhone; 				// 坐席电话
	//评价状态
	private FaultEvaluateStatus faultEvaluateStatus;
	 //需评价对象
	private String firstUsers; 

	/** 数据库查询时使用 */
	private String hql;							//数据库查询hql语句
	private List<Object> params;				//数据库查询条件集合
	
	/** 是否查询删除事件 */
	private Boolean isDelete = false;			//是否包含删除故障单，默认否--事件处置模块使用，是--数据统计模块使用
	
	public String getFirstUsers() {
		return firstUsers;
	}

	public void setFirstUsers(String firstUsers) {
		this.firstUsers = firstUsers;
	}

	public FaultEvaluateStatus getFaultEvaluateStatus() {
		return faultEvaluateStatus;
	}

	public void setFaultEvaluateStatus(FaultEvaluateStatus faultEvaluateStatus) {
		this.faultEvaluateStatus = faultEvaluateStatus;
	}

	public String getFaultCompany() {
		return faultCompany;
	}

	public void setFaultCompany(String faultCompany) {
		this.faultCompany = faultCompany;
	}

	public String getFaultNumber() {
		return faultNumber;
	}

	public void setFaultNumber(String faultNumber) {
		this.faultNumber = faultNumber;
	}

	public FaultLevelType getFaultLevel() {
		return faultLevel;
	}

	public void setFaultLevel(FaultLevelType faultLevel) {
		this.faultLevel = faultLevel;
	}

	public FaultOriginType getSource() {
		return source;
	}

	public void setSource(FaultOriginType source) {
		this.source = source;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public FaultEventType getEventType() {
		return eventType;
	}

	public void setEventType(FaultEventType eventType) {
		this.eventType = eventType;
	}

	public String getStationPhone() {
		return stationPhone;
	}

	public void setStationPhone(String stationPhone) {
		this.stationPhone = stationPhone;
	}

	public FaultStatus getStatus() {
		return status;
	}

	public void setStatus(FaultStatus status) {
		this.status = status;
	}

	public FaultInformation getParentId() {
		return parentId;
	}

	public void setParentId(FaultInformation parentId) {
		this.parentId = parentId;
	}

	public Integer getFaultChildNumber() {
		return faultChildNumber;
	}

	public void setFaultChildNumber(Integer faultChildNumber) {
		this.faultChildNumber = faultChildNumber;
	}

	public String getFaultArea() {
		return faultArea;
	}

	public void setFaultArea(String faultArea) {
		this.faultArea = faultArea;
	}

	public FaultHandelType getFaultHandelType() {
		return faultHandelType;
	}

	public void setFaultHandelType(FaultHandelType faultHandelType) {
		this.faultHandelType = faultHandelType;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getFaultId() {
		return this.faultId;
	}

	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}

	public String getCurrentHandleUser() {
		return this.currentHandleUser;
	}

	public void setCurrentHandleUser(String currentHandleUser) {
		this.currentHandleUser = currentHandleUser;
	}

	public User getFirstHandleUser() {
		return this.firstHandleUser;
	}

	public void setFirstHandleUser(User firstHandleUser) {
		this.firstHandleUser = firstHandleUser;
	}

	public DutyPlaceEnum getDutyPlace() {
		return this.dutyPlace;
	}

	public void setDutyPlace(DutyPlaceEnum dutyPlace) {
		this.dutyPlace = dutyPlace;
	}

	public List<FaultStatus> getFaultStatus() {
		return this.faultStatus;
	}

	public void setFaultStatus(List<FaultStatus> faultStatus) {
		this.faultStatus = faultStatus;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getStartOptTime() {
		return this.startOptTime;
	}

	public void setStartOptTime(String startOptTime) {
		this.startOptTime = startOptTime;
	}

	public String getEndOptTime() {
		return this.endOptTime;
	}

	public void setEndOptTime(String endOptTime) {
		this.endOptTime = endOptTime;
	}

	public String getOptType() {
		return this.optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}
}