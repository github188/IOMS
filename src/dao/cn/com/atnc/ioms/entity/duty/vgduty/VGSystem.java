package cn.com.atnc.ioms.entity.duty.vgduty;

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
 * VG系统检查
 * @author 
 * @date 
 * @since 
 */
@Entity
@Table(name = "TB_OM_DUTY_TGDT_VG_CHECK")
public class VGSystem extends MyStringUUIDEntity {

	private static final long serialVersionUID = 2032608064094828132L;
	
	//----转报同步状态----//
	private WorkStatus synapAp1;					//转报同步1
	private WorkStatus synapAp2;					//转报同步2
	//----基地总局异步----//
	private WorkStatus jdzjAsyapAp1;				//基地总局异步1
	private WorkStatus jdzjAsyapAp2;				//基地总局异步2
	//----基地双井----//
	private WorkStatus jdsj;						//基地双井
	//----十里河----//
	private WorkStatus slh1;						//十里河1
	private WorkStatus slh2;						//十里河2
	private WorkStatus slh3;						//十里河3
	private WorkStatus slh4;						//十里河4
	//----十里河同步----//
	private WorkStatus slhSynapAp1;					//十里河同步1
	private WorkStatus slhSynapAp2;					//十里河同步2
	//----总局异步----//
	private WorkStatus zjAsyapAp2;					//总局异步2（11201）
	private WorkStatus zjAsyapAp3;					//总局异步3（11202）
	//----双井----//
	private WorkStatus sj1;							//双井1
	private WorkStatus sj2;							//双井2
	//----其它信息：创建、审核情况----//
	private User creater;							//创建人
	private Calendar createTime;					//创建时间
	private User auditer;							//审核人
	private Calendar auditTime;						//审核时间
	private String remark;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "synap_ap1")
	public WorkStatus getSynapAp1() {
		return synapAp1;
	}
	public void setSynapAp1(WorkStatus synapAp1) {
		this.synapAp1 = synapAp1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "synap_ap2")
	public WorkStatus getSynapAp2() {
		return synapAp2;
	}
	public void setSynapAp2(WorkStatus synapAp2) {
		this.synapAp2 = synapAp2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "jdzj_asyap_ap1")
	public WorkStatus getJdzjAsyapAp1() {
		return jdzjAsyapAp1;
	}
	public void setJdzjAsyapAp1(WorkStatus jdzjAsyapAp1) {
		this.jdzjAsyapAp1 = jdzjAsyapAp1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "jdzj_asyap_ap2")
	public WorkStatus getJdzjAsyapAp2() {
		return jdzjAsyapAp2;
	}
	public void setJdzjAsyapAp2(WorkStatus jdzjAsyapAp2) {
		this.jdzjAsyapAp2 = jdzjAsyapAp2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "jdsj")
	public WorkStatus getJdsj() {
		return jdsj;
	}
	public void setJdsj(WorkStatus jdsj) {
		this.jdsj = jdsj;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh1")
	public WorkStatus getSlh1() {
		return slh1;
	}
	public void setSlh1(WorkStatus slh1) {
		this.slh1 = slh1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh2")
	public WorkStatus getSlh2() {
		return slh2;
	}
	public void setSlh2(WorkStatus slh2) {
		this.slh2 = slh2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh3")
	public WorkStatus getSlh3() {
		return slh3;
	}
	public void setSlh3(WorkStatus slh3) {
		this.slh3 = slh3;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh4")
	public WorkStatus getSlh4() {
		return slh4;
	}
	public void setSlh4(WorkStatus slh4) {
		this.slh4 = slh4;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh_synap_ap1")
	public WorkStatus getSlhSynapAp1() {
		return slhSynapAp1;
	}
	public void setSlhSynapAp1(WorkStatus slhSynapAp1) {
		this.slhSynapAp1 = slhSynapAp1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "slh_synap_ap2")
	public WorkStatus getSlhSynapAp2() {
		return slhSynapAp2;
	}
	public void setSlhSynapAp2(WorkStatus slhSynapAp2) {
		this.slhSynapAp2 = slhSynapAp2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "zj_asyap_ap2")
	public WorkStatus getZjAsyapAp2() {
		return zjAsyapAp2;
	}
	public void setZjAsyapAp2(WorkStatus zjAsyapAp2) {
		this.zjAsyapAp2 = zjAsyapAp2;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "zj_asyap_ap3")
	public WorkStatus getZjAsyapAp3() {
		return zjAsyapAp3;
	}
	public void setZjAsyapAp3(WorkStatus zjAsyapAp3) {
		this.zjAsyapAp3 = zjAsyapAp3;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "sj1")
	public WorkStatus getSj1() {
		return sj1;
	}
	public void setSj1(WorkStatus sj1) {
		this.sj1 = sj1;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "sj2")
	public WorkStatus getSj2() {
		return sj2;
	}
	public void setSj2(WorkStatus sj2) {
		this.sj2 = sj2;
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
