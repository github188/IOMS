package cn.com.atnc.ioms.model.faultmng;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;

/**
 * 故障单处置model
 * @author duanyanlin 
 * 2016年6月17日 下午2:15:13
 */
public class FaultHandleModel extends BaseModel {
	private String faultDesc;							//故障描述
	private String handleDesc;							//处理过程记录
	private String remark;								//备注
	private String faultId;								//故障单ID
	private FaultHandelType faultHandelType;			//处理类别
	private User operator;								//处理人
	private String nextHanleUser;						//移交或分配人ID
	
	//事件归类所需信息
	private String faultTypeParent;						//父级事件类型id
	private String faultTypeSon;						//子级事件类型id
	private Integer faultDeviceNumber;					//故障的设备数量
	private Integer effectProfessionNumber;				//受影响的业务
	
	//第一处理人处理
	private String transferType;						//移交类别
	private String oaDeptId;							//移交部门ID
	private String oaDeptSecondId;						//移交部门二级ID
	private String oaEndTime;							//要求完成时间
	
	//部门经理分配
	private String[] nextHandleUserIds;					//工程师ID集合
	private FaultStatus faultStatus;					//故障单当前状态
	
	//技术工程师操作控制---暂存和提交
	private String submitType;							
	
	//部门经理退回技术工程师处置记录
	private String handlesIds;							//事件处置记录Ids
	
	public String getHandlesIds() {
		return handlesIds;
	}

	public void setHandlesIds(String handlesIds) {
		this.handlesIds = handlesIds;
	}

	public String getOaDeptSecondId() {
		return oaDeptSecondId;
	}

	public void setOaDeptSecondId(String oaDeptSecondId) {
		this.oaDeptSecondId = oaDeptSecondId;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public FaultStatus getFaultStatus() {
		return faultStatus;
	}

	public void setFaultStatus(FaultStatus faultStatus) {
		this.faultStatus = faultStatus;
	}

	public String[] getNextHandleUserIds() {
		return nextHandleUserIds;
	}

	public void setNextHandleUserIds(String[] nextHandleUserIds) {
		this.nextHandleUserIds = nextHandleUserIds;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getOaDeptId() {
		return oaDeptId;
	}

	public void setOaDeptId(String oaDeptId) {
		this.oaDeptId = oaDeptId;
	}

	public String getOaEndTime() {
		return oaEndTime;
	}

	public void setOaEndTime(String oaEndTime) {
		this.oaEndTime = oaEndTime;
	}

	public String getFaultTypeParent() {
		return faultTypeParent;
	}

	public void setFaultTypeParent(String faultTypeParent) {
		this.faultTypeParent = faultTypeParent;
	}

	public String getFaultTypeSon() {
		return faultTypeSon;
	}

	public void setFaultTypeSon(String faultTypeSon) {
		this.faultTypeSon = faultTypeSon;
	}

	public Integer getFaultDeviceNumber() {
		return faultDeviceNumber;
	}

	public void setFaultDeviceNumber(Integer faultDeviceNumber) {
		this.faultDeviceNumber = faultDeviceNumber;
	}

	public Integer getEffectProfessionNumber() {
		return effectProfessionNumber;
	}

	public void setEffectProfessionNumber(Integer effectProfessionNumber) {
		this.effectProfessionNumber = effectProfessionNumber;
	}

	public String getNextHanleUser() {
		return nextHanleUser;
	}

	public void setNextHanleUser(String nextHanleUser) {
		this.nextHanleUser = nextHanleUser;
	}

	public FaultHandelType getFaultHandelType() {
		return this.faultHandelType;
	}

	public void setFaultHandelType(FaultHandelType faultHandelType) {
		this.faultHandelType = faultHandelType;
	}

	public User getOperator() {
		return this.operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public String getFaultDesc() {
		return this.faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getHandleDesc() {
		return this.handleDesc;
	}

	public void setHandleDesc(String handleDesc) {
		this.handleDesc = handleDesc;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFaultId() {
		return this.faultId;
	}

	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}
}