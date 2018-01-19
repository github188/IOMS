package cn.com.atnc.ioms.entity.techsupport.fault;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.OptType;

/**
 * TODO：故障申报操作日志类
 * @author KuYonggang
 * @date 2014-4-3下午2:00:03
 * @version 1.0
 */
@Entity
@Table(name="TB_OM_FAULT_DECLARE_OPTLOG")
public class FaultDeclareOptLog extends StringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5094541504847849227L;
	
	private OptType optType;//操作类型：添加、修改、审批、移交等
	private AllStatus fromStatus;//变更前状态
	private AllStatus toStatus;//变更后状态
	private Client optClient;//客服平台处理人员
	private User optUser;//运维平台处理人员
	private String optUserName; //处理人姓名
	private String optUserDepartment;//处理人所在部门
	private String assistUser;//协助人
	private String assistUserDepartment;//协助人所在部门
	private FaultDeclare faultDeclare;//故障申报ID
	private Date optTime;//操作时间
	private String descInfo;//描述信息
	
	@Enumerated(EnumType.STRING)
	@Column(name="OPT_TYPE")
	public OptType getOptType() {
		return optType;
	}
	public void setOptType(OptType optType) {
		this.optType = optType;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FROM_STATUS")
	public AllStatus getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(AllStatus fromStatus) {
		this.fromStatus = fromStatus;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="TO_STATUS")
	public AllStatus getToStatus() {
		return toStatus;
	}
	public void setToStatus(AllStatus toStatus) {
		this.toStatus = toStatus;
	}
	@ManyToOne
	@JoinColumn(name="OPT_CLIENT")
	public Client getOptClient() {
		return optClient;
	}
	public void setOptClient(Client optClient) {
		this.optClient = optClient;
	}
	@ManyToOne
	@JoinColumn(name="OPT_USER")
	public User getOptUser() {
		return optUser;
	}
	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}
	@Column(name="ASSIST_USER")
	public String getAssistUser() {
		return assistUser;
	}
	public void setAssistUser(String assistUser) {
		this.assistUser = assistUser;
	}
	
	@ManyToOne
	@JoinColumn(name="FAULT_DECLARE_ID")
	public FaultDeclare getFaultDeclare() {
		return faultDeclare;
	}
	public void setFaultDeclare(FaultDeclare faultDeclare) {
		this.faultDeclare = faultDeclare;
	}
	
	@Column(name="OPT_TIME")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getOptTime() {
		return optTime;
	}
	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	@Column(name="DESC_INFO",columnDefinition="clob")
	public String getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name="OPT_USERNAME")
	public String getOptUserName() {
		return optUserName;
	}
	public void setOptUserName(String optUserName) {
		this.optUserName = optUserName;
	}
	@Column(name="OPT_USERDEPARTMENT")
	public String getOptUserDepartment() {
		return optUserDepartment;
	}
	public void setOptUserDepartment(String optUserDepartment) {
		this.optUserDepartment = optUserDepartment;
	}
	@Column(name="ASSIST_USERDEPARTMENT")
	public String getAssistUserDepartment() {
		return assistUserDepartment;
	}
	public void setAssistUserDepartment(String assistUserDepartment) {
		this.assistUserDepartment = assistUserDepartment;
	}
	
}
