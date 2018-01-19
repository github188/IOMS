package cn.com.atnc.ioms.model.business.formalcircuit;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitTES;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.model.MyPaginModel;


/**
 * 正式电路申请表基础信息QueryModel
 *
 * @author WangLingbin
 * @date 2015年7月28日 上午11:36:50
 * @since 1.0.0
 */
public class FormalCircuitQueryModel extends MyPaginModel {
	
	private String id;                            //申请记录主键
	private List<String> pIdList;				   //上级领导及其下属ID
	private List<String> ppIdList;				   //上上级领导及其下属ID
	private Client client;   
	private List<FormalStatEnum> statusList;      //审批状态查询条件
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startRecordTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endRecordTime;
	
    private String optType;
    private int index;
	
	private String identifier;  //编号
	private String businessName;  //业务名称
	private String circuitSpeed;  //电路速率
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar applyDate;
	
	private FormalCircuit formalCircuit;
	private List<FormalCircuitATM> formalCircuitATMli;
	private List<FormalCircuitKU> formalCircuitKUli;
	private List<FormalCircuitTES> formalCircuitTESli;
	private List<FormalCircuitPES> formalCircuitPESli;
	private ApplyEvaluate applyEvaluate;
    
	private Boolean flag;
	
	private String approveRemark;
	private boolean operType = true;			  //操作类别（true：配置/false:移交）
	private String engineer;					  //工程师（移交的工程师）
	private String auditEngineer;				  //审核工程师
	private String csStaff;						  //客服专员（分配客服专员）
	private boolean approveStat = true;					//审批类别（通过/退回）
	private String lastUser;						//上一步操作人
	private String nextUser;						//下一步操作人
	private String pid;								//流程ID
	
	private String reason;  //退回原因
	private Boolean apply; //同意/不同意
	private String bureau;			//协同阅知的管局
	
	public List<FormalCircuitPES> getFormalCircuitPESli() {
		return formalCircuitPESli;
	}
	public void setFormalCircuitPESli(List<FormalCircuitPES> formalCircuitPESli) {
		this.formalCircuitPESli = formalCircuitPESli;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStartRecordTime() {
		return startRecordTime;
	}
	public void setStartRecordTime(Date startRecordTime) {
		this.startRecordTime = startRecordTime;
	}
	public Date getEndRecordTime() {
		return endRecordTime;
	}
	public void setEndRecordTime(Date endRecordTime) {
		this.endRecordTime = endRecordTime;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public FormalCircuit getFormalCircuit() {
		return formalCircuit;
	}
	public void setFormalCircuit(FormalCircuit formalCircuit) {
		this.formalCircuit = formalCircuit;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getCircuitSpeed() {
		return circuitSpeed;
	}
	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}
	public Calendar getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Calendar applyDate) {
		this.applyDate = applyDate;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public ApplyEvaluate getApplyEvaluate() {
		return applyEvaluate;
	}
	public void setApplyEvaluate(ApplyEvaluate applyEvaluate) {
		this.applyEvaluate = applyEvaluate;
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
	public List<FormalStatEnum> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<FormalStatEnum> statusList) {
		this.statusList = statusList;
	}
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	public List<FormalCircuitATM> getFormalCircuitATMli() {
		return formalCircuitATMli;
	}
	public void setFormalCircuitATMli(List<FormalCircuitATM> formalCircuitATMli) {
		this.formalCircuitATMli = formalCircuitATMli;
	}
	public List<FormalCircuitKU> getFormalCircuitKUli() {
		return formalCircuitKUli;
	}
	public void setFormalCircuitKUli(List<FormalCircuitKU> formalCircuitKUli) {
		this.formalCircuitKUli = formalCircuitKUli;
	}
	public List<FormalCircuitTES> getFormalCircuitTESli() {
		return formalCircuitTESli;
	}
	public void setFormalCircuitTESli(List<FormalCircuitTES> formalCircuitTESli) {
		this.formalCircuitTESli = formalCircuitTESli;
	}
	public boolean isOperType() {
		return operType;
	}
	public void setOperType(boolean operType) {
		this.operType = operType;
	}
	public String getEngineer() {
		return engineer;
	}
	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}
	public String getCsStaff() {
		return csStaff;
	}
	public void setCsStaff(String csStaff) {
		this.csStaff = csStaff;
	}
	public boolean isApproveStat() {
		return approveStat;
	}
	public void setApproveStat(boolean approveStat) {
		this.approveStat = approveStat;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getApply() {
		return apply;
	}
	public void setApply(Boolean apply) {
		this.apply = apply;
	}
	public String getBureau() {
		return bureau;
	}
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

}
