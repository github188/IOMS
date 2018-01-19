package cn.com.atnc.ioms.model.business.satellite;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.model.MyPaginModel;


/**
 * ku卫星网远端站入网申请查询model
 *
 * @author ku
 * @date 2015年5月14日 上午11:35:04
 * @since 1.0.0
 */
/**
 * 此处添加类KuSatelliteQueryModel的描述信息
 *
 * @author WangLingbin
 * @date 2015年10月21日 下午5:04:16
 * @since 1.0.0
 */
public class KuSatelliteQueryModel extends MyPaginModel {
	
	private String id;                            //申请记录主键
	
	private boolean operType = true;			  //操作类别（true：配置/false:移交）
	private String applyUserLike;				  //申请人模糊查询
	private String applyComLike;				  //申请单位模糊查询
	private String applyLinkmanLike;			  //联系人模糊查询
	private ApproveStatEnum approveStatus;		  //申请审批状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar fromApplyTime;                //申请开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar toApplyTime;				   //申请结束时间
	private List<String> pIdList;				   //上级领导及其下属ID
	private List<String> ppIdList;				   //上上级领导及其下属ID
	private Client client;   
	private List<ApproveStatEnum> statusList;      //审批状态查询条件
	private boolean approveStat = true;					//审批类别（通过/退回）
	private String approveRemark;					//审批备注
	
	private String csStaff;						  //客服专员（分配客服专员）
	private String engineer;					  //工程师（移交的工程师）
	private String auditEngineer;				  //审核工程师
	private String lastUser;						//上一步操作人
	private String nextUser;						//下一步操作人
	private String pid;								//流程ID
	
	private boolean agreeStat;						//同意与否（同意/不同意）
	private String backUser;			//客服领导审核时，退回的用户
	
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

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public boolean isOperType() {
		return operType;
	}

	public void setOperType(boolean operType) {
		this.operType = operType;
	}

	public String getNextUser() {
		return nextUser;
	}

	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCsStaff() {
		return csStaff;
	}

	public void setCsStaff(String csStaff) {
		this.csStaff = csStaff;
	}
	public String getAuditEngineer() {
		return auditEngineer;
	}
	public void setAuditEngineer(String auditEngineer) {
		this.auditEngineer = auditEngineer;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	public String getBackUser() {
		return backUser;
	}

	public void setBackUser(String backUser) {
		this.backUser = backUser;
	}

	public boolean isAgreeStat() {
		return agreeStat;
	}

	public void setAgreeStat(boolean agreeStat) {
		this.agreeStat = agreeStat;
	}
	
}
