package cn.com.atnc.ioms.model.business.datacomnetwork;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkConfig;
import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.business.evaluate.GradeEnum;
import cn.com.atnc.ioms.model.MyPaginModel;


/**
 * 数据通信网申请表基础信息QueryModel
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:59:12
 * @since 1.0.0
 */
public class DataComNetworkQueryModel extends MyPaginModel {

	private String id; // 申请记录主键
	private GradeEnum grade; // 评价等级
	private String evaluateRemark; // 评价备注
	private List<String> idList; // 上级领导及其下属ID
	private List<String> pIdList; // 上级领导及其下属ID
	private List<String> ppIdList; // 上上级领导及其下属ID
	private Client client;
	private Client pClient; // 上级领导ID
	private List<NetWorkStatEnum> statusList; // 审批状态查询条件

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startRecordTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endRecordTime;
	private String applyUserLike; // 申请人模糊查询
	private String applyComLike; // 申请单位模糊查询
	private String applyLinkmanLike; // 联系人模糊查询
	private NetWorkStatEnum approveStatus; //审批状态

	private String optType;
	private int index;
	private String sort;// 排序：ASC/DESC
	private String order;// 排序：ASC/DESC
	private String column;// 列
	private String applyUserLoginName;// 临时电路申请用户登录名

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar applyDate;

	private String engineer;					  //工程师（移交的工程师）
	private String auditEngineer;				  //审核工程师
	private String csStaff;						  //客服专员（分配客服专员）
	private DataComNetwork dataComNetwork;
	private ApplyEvaluate applyEvaluate;
	private DataComNetworkConfig dataComNetworkConf;
	private Boolean flag;
	private String applyId;
	private String lastUser;						//上一步操作人
	private String nextUser;						//下一步操作人
	private boolean operType = true;			  //操作类别（true：配置/false:移交）
	private boolean approveStat = true;					//审批类别（通过/退回）
	
	private String approveRemark;					//审批备注
	private String pid; // 流程ID
	private String reason;  //退回原因
	private Boolean apply; //同意/不同意
	private String bureau;			//协同阅知的管局

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GradeEnum getGrade() {
		return grade;
	}

	public void setGrade(GradeEnum grade) {
		this.grade = grade;
	}

	public String getEvaluateRemark() {
		return evaluateRemark;
	}

	public void setEvaluateRemark(String evaluateRemark) {
		this.evaluateRemark = evaluateRemark;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

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

	public NetWorkStatEnum getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(NetWorkStatEnum approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApplyUserLoginName() {
		return applyUserLoginName;
	}

	public void setApplyUserLoginName(String applyUserLoginName) {
		this.applyUserLoginName = applyUserLoginName;
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

	public List<NetWorkStatEnum> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<NetWorkStatEnum> statusList) {
		this.statusList = statusList;
	}

	public Client getpClient() {
		return pClient;
	}

	public void setpClient(Client pClient) {
		this.pClient = pClient;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	public String getApplyLinkmanLike() {
		return applyLinkmanLike;
	}

	public void setApplyLinkmanLike(String applyLinkmanLike) {
		this.applyLinkmanLike = applyLinkmanLike;
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

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public DataComNetwork getDataComNetwork() {
		return dataComNetwork;
	}

	public void setDataComNetwork(DataComNetwork dataComNetwork) {
		this.dataComNetwork = dataComNetwork;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
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

	public String getLastUser() {
		return lastUser;
	}

	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}

	public String getNextUser() {
		return nextUser;
	}

	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}

	public boolean isOperType() {
		return operType;
	}

	public void setOperType(boolean operType) {
		this.operType = operType;
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

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getAuditEngineer() {
		return auditEngineer;
	}

	public void setAuditEngineer(String auditEngineer) {
		this.auditEngineer = auditEngineer;
	}

	public String getCsStaff() {
		return csStaff;
	}

	public void setCsStaff(String csStaff) {
		this.csStaff = csStaff;
	}

	public DataComNetworkConfig getDataComNetworkConf() {
		return dataComNetworkConf;
	}

	public void setDataComNetworkConf(DataComNetworkConfig dataComNetworkConf) {
		this.dataComNetworkConf = dataComNetworkConf;
	}

}
