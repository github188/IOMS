package cn.com.atnc.ioms.model.business.taskrecord;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.business.transfernet.TransferNetStatEnum;
import cn.com.atnc.ioms.model.MyPaginModel;


/**
 * ku卫星网远端站入网申请查询model
 *
 * @author ku
 * @date 2015年5月14日 上午11:35:04
 * @since 1.0.0
 */
public class TaskRecordQueryModel extends MyPaginModel {
	
	private String id;                            //申请记录主键

	private String applyUserLike;				  //申请人模糊查询
	private String applyComLike;				  //申请单位模糊查询
	private String applyLinkmanLike;			  //联系人模糊查询
	private ApproveStatEnum approveStatus;		  //申请审批状态
	private FormalStatEnum formalStatEnum;		  //申请审批状态
	private TeleGraphApproveStatEnum tgasStat;//申请审批状态
	private ApplyTypeEnum applyType;
	private NetWorkStatEnum approveStatNWS;		  //申请审批状态
	private TransferNetStatEnum approveStatTNS;		  //申请审批状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar fromApplyTime;                //申请开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar toApplyTime;				   //申请结束时间
	private List<String> pIdList;				   //上级领导及其下属ID
	private List<String> ppIdList;				   //上上级领导及其下属ID
	private Client client;   
	private List<ApproveStatEnum> statusList;      //审批状态查询条件
	private List<ApplyTypeEnum> applyTypeList;     //申请类别
 	private boolean approveStat = true;					//审批类别（通过/退回）
	private String approveRemark;					//审批备注
	private ApplyBaseInfo applyBaseInfo;

	private String processInstanceId; //流程实例ID
	private String taskName;  //任务名
	
	private String approveUser;					//用户姓名
	private String approveStatusValue;		//审批状态值
	private Bureau bureaus;					//管局所属区域
	
	public String getApplyUserLike() {
		return applyUserLike;
	}

	public void setApplyUserLike(String applyUserLike) {
		this.applyUserLike = applyUserLike;
	}

	public String getApplyComLike() {
		return applyComLike;
	}

	public void setApplyComLike(String applyComLike) {
		this.applyComLike = applyComLike;
	}

	public String getApplyLinkmanLike() {
		return applyLinkmanLike;
	}

	public void setApplyLinkmanLike(String applyLinkmanLike) {
		this.applyLinkmanLike = applyLinkmanLike;
	}

	public ApproveStatEnum getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(ApproveStatEnum approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Calendar getFromApplyTime() {
		return fromApplyTime;
	}

	public void setFromApplyTime(Calendar fromApplyTime) {
		this.fromApplyTime = fromApplyTime;
	}

	public Calendar getToApplyTime() {
		return toApplyTime;
	}

	public void setToApplyTime(Calendar toApplyTime) {
		this.toApplyTime = toApplyTime;
	}

	public List<String> getpIdList() {
		return pIdList;
	}

	public void setpIdList(List<String> pIdList) {
		this.pIdList = pIdList;
	}

	public List<String> getPpIdList() {
		return ppIdList;
	}

	public void setPpIdList(List<String> ppIdList) {
		this.ppIdList = ppIdList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ApproveStatEnum> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<ApproveStatEnum> statusList) {
		this.statusList = statusList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isApproveStat() {
		return approveStat;
	}

	public void setApproveStat(boolean approveStat) {
		this.approveStat = approveStat;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public List<ApplyTypeEnum> getApplyTypeList() {
		return applyTypeList;
	}

	public void setApplyTypeList(List<ApplyTypeEnum> applyTypeList) {
		this.applyTypeList = applyTypeList;
	}

	public ApplyTypeEnum getApplyType() {
		return applyType;
	}

	public void setApplyType(ApplyTypeEnum applyType) {
		this.applyType = applyType;
	}

	public FormalStatEnum getFormalStatEnum() {
		return formalStatEnum;
	}

	public void setFormalStatEnum(FormalStatEnum formalStatEnum) {
		this.formalStatEnum = formalStatEnum;
	}

	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}

	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}

	public TeleGraphApproveStatEnum getTgasStat() {
		return tgasStat;
	}

	public void setTgasStat(TeleGraphApproveStatEnum tgasStat) {
		this.tgasStat = tgasStat;
	}

	public NetWorkStatEnum getApproveStatNWS() {
		return approveStatNWS;
	}

	public void setApproveStatNWS(NetWorkStatEnum approveStatNWS) {
		this.approveStatNWS = approveStatNWS;
	}

	public TransferNetStatEnum getApproveStatTNS() {
		return approveStatTNS;
	}

	public void setApproveStatTNS(TransferNetStatEnum approveStatTNS) {
		this.approveStatTNS = approveStatTNS;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getApproveUser() {
		return approveUser;
	}

	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}

	public String getApproveStatusValue() {
		return approveStatusValue;
	}

	public void setApproveStatusValue(String approveStatusValue) {
		this.approveStatusValue = approveStatusValue;
	}

	public Bureau getBureaus() {
		return bureaus;
	}

	public void setBureaus(Bureau bureaus) {
		this.bureaus = bureaus;
	}
	
}
