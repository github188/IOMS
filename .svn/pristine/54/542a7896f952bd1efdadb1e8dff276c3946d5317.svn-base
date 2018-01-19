package cn.com.atnc.ioms.entity.duty.telegraphduty;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.duty.WorkStatus;

/**
 * 转报系统检查
 * @author WangLingbin
 * @date 2016年1月8日 上午10:16:22
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_DUTY_TGDT_TG_CHECK")
public class TeleGraphSystem extends MyStringUUIDEntity{

	private static final long serialVersionUID = -6739376065386900888L;

	//----转报主机状态----//
	private ReduncdancyStatus hostAReduncdancy;		//转报主机A冗余状态
	private WorkStatus hostAWork;					//转报主机A工作状态
	private ReduncdancyStatus hostBReduncdancy;		//转报主机B冗余状态
	private WorkStatus hostBWork;					//转报主机B工作状态
	//----同步接入器状态----//
	private ReduncdancyStatus synapAReduncdancy;	//同步接入器A冗余状态
	private WorkStatus synapAWork;					//同步接入器A工作状态
	private ReduncdancyStatus synapBReduncdancy;	//同步接入器B冗余状态
	private WorkStatus synapBWork;					//同步接入器B工作状态
	private WorkStatus synProcess;					//同步接入器同步进程
	//----智能集中器状态----//
	private ReduncdancyStatus collAReduncdancy;		//智能集中器A冗余状态
	private WorkStatus collAWork;					//智能集中器A工作状态
	private ReduncdancyStatus collBReduncdancy;		//智能集中器B冗余状态
	private WorkStatus collBWork;					//智能集中器B工作状态
	private ReduncdancyStatus collCReduncdancy;		//智能集中器C冗余状态
	private WorkStatus collCWork;					//智能集中器C工作状态
	private ReduncdancyStatus collDReduncdancy;		//智能集中器D冗余状态
	private WorkStatus collDWork;					//智能集中器D工作状态
	//----异步接入器状态----//
	private WorkStatus asyapAp1;					//异步接入器1
	private WorkStatus asyapAp2;					//异步接入器2
	private WorkStatus asyapAp3;					//异步接入器3
	private WorkStatus asyapAp4;					//异步接入器4
	private WorkStatus asyapAp5;					//异步接入器5
	private WorkStatus asyapAp6;					//异步接入器6
	private WorkStatus asyapSpProcess;				//异步接入器串口通信进程
	private WorkStatus asyapIpProcess;				//异步接入器IP联接进程
	//----其它信息----//
	private User creater;							//创建人
	private Calendar createTime;					//创建时间
	private User auditer;							//创建人
	private Calendar auditTime;						//创建时间
	private String remark;							//备注
	
	@Enumerated(EnumType.STRING)
	@Column(name = "host_a_redundancy")
	public ReduncdancyStatus getHostAReduncdancy() {
		return hostAReduncdancy;
	}
	public void setHostAReduncdancy(ReduncdancyStatus hostAReduncdancy) {
		this.hostAReduncdancy = hostAReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "host_a_work")
	public WorkStatus getHostAWork() {
		return hostAWork;
	}
	public void setHostAWork(WorkStatus hostAWork) {
		this.hostAWork = hostAWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "host_b_redundancy")
	public ReduncdancyStatus getHostBReduncdancy() {
		return hostBReduncdancy;
	}
	public void setHostBReduncdancy(ReduncdancyStatus hostBReduncdancy) {
		this.hostBReduncdancy = hostBReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "host_b_work")
	public WorkStatus getHostBWork() {
		return hostBWork;
	}
	public void setHostBWork(WorkStatus hostBWork) {
		this.hostBWork = hostBWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "synap_a_redundancy")
	public ReduncdancyStatus getSynapAReduncdancy() {
		return synapAReduncdancy;
	}
	public void setSynapAReduncdancy(ReduncdancyStatus synapAReduncdancy) {
		this.synapAReduncdancy = synapAReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "synap_a_work")
	public WorkStatus getSynapAWork() {
		return synapAWork;
	}
	public void setSynapAWork(WorkStatus synapAWork) {
		this.synapAWork = synapAWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "symap_b_redundancy")
	public ReduncdancyStatus getSynapBReduncdancy() {
		return synapBReduncdancy;
	}
	public void setSynapBReduncdancy(ReduncdancyStatus synapBReduncdancy) {
		this.synapBReduncdancy = synapBReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "synap_b_work")
	public WorkStatus getSynapBWork() {
		return synapBWork;
	}
	public void setSynapBWork(WorkStatus synapBWork) {
		this.synapBWork = synapBWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "syn_process")
	public WorkStatus getSynProcess() {
		return synProcess;
	}
	public void setSynProcess(WorkStatus synProcess) {
		this.synProcess = synProcess;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_a_redundancy")
	public ReduncdancyStatus getCollAReduncdancy() {
		return collAReduncdancy;
	}
	public void setCollAReduncdancy(ReduncdancyStatus collAReduncdancy) {
		this.collAReduncdancy = collAReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_a_work")
	public WorkStatus getCollAWork() {
		return collAWork;
	}
	public void setCollAWork(WorkStatus collAWork) {
		this.collAWork = collAWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_b_redundancy")
	public ReduncdancyStatus getCollBReduncdancy() {
		return collBReduncdancy;
	}
	public void setCollBReduncdancy(ReduncdancyStatus collBReduncdancy) {
		this.collBReduncdancy = collBReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_b_work")
	public WorkStatus getCollBWork() {
		return collBWork;
	}
	public void setCollBWork(WorkStatus collBWork) {
		this.collBWork = collBWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_c_redundancy")
	public ReduncdancyStatus getCollCReduncdancy() {
		return collCReduncdancy;
	}
	public void setCollCReduncdancy(ReduncdancyStatus collCReduncdancy) {
		this.collCReduncdancy = collCReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_c_work")
	public WorkStatus getCollCWork() {
		return collCWork;
	}
	public void setCollCWork(WorkStatus collCWork) {
		this.collCWork = collCWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_d_redundancy")
	public ReduncdancyStatus getCollDReduncdancy() {
		return collDReduncdancy;
	}
	public void setCollDReduncdancy(ReduncdancyStatus collDReduncdancy) {
		this.collDReduncdancy = collDReduncdancy;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "coll_d_work")
	public WorkStatus getCollDWork() {
		return collDWork;
	}
	public void setCollDWork(WorkStatus collDWork) {
		this.collDWork = collDWork;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap1")
	public WorkStatus getAsyapAp1() {
		return asyapAp1;
	}
	public void setAsyapAp1(WorkStatus asyapAp1) {
		this.asyapAp1 = asyapAp1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap2")
	public WorkStatus getAsyapAp2() {
		return asyapAp2;
	}
	public void setAsyapAp2(WorkStatus asyapAp2) {
		this.asyapAp2 = asyapAp2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap3")
	public WorkStatus getAsyapAp3() {
		return asyapAp3;
	}
	public void setAsyapAp3(WorkStatus asyapAp3) {
		this.asyapAp3 = asyapAp3;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap4")
	public WorkStatus getAsyapAp4() {
		return asyapAp4;
	}
	public void setAsyapAp4(WorkStatus asyapAp4) {
		this.asyapAp4 = asyapAp4;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap5")
	public WorkStatus getAsyapAp5() {
		return asyapAp5;
	}
	public void setAsyapAp5(WorkStatus asyapAp5) {
		this.asyapAp5 = asyapAp5;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ap6")
	public WorkStatus getAsyapAp6() {
		return asyapAp6;
	}
	public void setAsyapAp6(WorkStatus asyapAp6) {
		this.asyapAp6 = asyapAp6;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_sp_process")
	public WorkStatus getAsyapSpProcess() {
		return asyapSpProcess;
	}
	public void setAsyapSpProcess(WorkStatus asyapSpProcess) {
		this.asyapSpProcess = asyapSpProcess;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "asyap_ip_process")
	public WorkStatus getAsyapIpProcess() {
		return asyapIpProcess;
	}
	public void setAsyapIpProcess(WorkStatus asyapIpProcess) {
		this.asyapIpProcess = asyapIpProcess;
	}
	@ManyToOne
	@JoinColumn(name="creater")
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	@Column(name="create_time")
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@ManyToOne
	@JoinColumn(name="autider")
	public User getAuditer() {
		return auditer;
	}
	public void setAuditer(User auditer) {
		this.auditer = auditer;
	}
	@Column(name="audit_time")
	public Calendar getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Calendar auditTime) {
		this.auditTime = auditTime;
	}
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
