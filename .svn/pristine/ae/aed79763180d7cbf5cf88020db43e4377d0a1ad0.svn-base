package cn.com.atnc.ioms.entity.duty.fax.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.duty.WorkStatus;
import cn.com.atnc.ioms.enums.duty.fax.FaxJudgeState;

/**
 * 转报系统硬件检查（自动）日检
 *
 * @author 韩天驭
 * @2017年1月22日 下午4:02:04
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_HARDWARE")
public class FaxHardwareDay extends MyStringUUIDEntity {
	private static final long serialversionUID = 1L;
	// 主机A冗余状态
	private ReduncdancyStatus hostReduncdancyStatusA;
	// 主机A工作状态
	private WorkStatus hostWorkStatusA;

	// 主机B冗余状态
	private ReduncdancyStatus hostReduncdancyStatusB;
	// 主机B工作状态
	private WorkStatus hostWorkStatusB;

	// 同步接入器A冗余状态
	private ReduncdancyStatus synReduncdancyStatusA;
	// 同步接入器A工作状态
	private WorkStatus synWorkStatusA;

	// 同步接入器B冗余状态
	private ReduncdancyStatus synReduncdancyStatusB;
	// 同步接入器B工作状态
	private WorkStatus synWorkStatusB;

	// 智能集中器A冗余状态
	private ReduncdancyStatus iReduncdancyStatusA;
	// 智能集中器A工作状态
	private WorkStatus iWorkStatusA;
	// 智能集中器B冗余状态
	private ReduncdancyStatus iReduncdancyStatusB;
	// 智能集中器B工作状态
	private WorkStatus iWorkStatusB;
	// 智能集中器C冗余状态
	private ReduncdancyStatus iReduncdancyStatusC;
	// 智能集中器C工作状态
	private WorkStatus iWorkStatusC;
	// 智能集中器D冗余状态
	private ReduncdancyStatus iReduncdancyStatusD;
	// 智能集中器D工作状态
	private WorkStatus iWorkStatusD;

	// 异步接入器状态-接入器1
	private WorkStatus asynAccess1;
	// 异步接入器状态-接入器2
	private WorkStatus asynAccess2;
	// 异步接入器状态-接入器3
	private WorkStatus asynAccess3;
	// 异步接入器状态-接入器4
	private WorkStatus asynAccess4;
	// 异步接入器状态-接入器5
	private WorkStatus asynAccess5;
	// 异步接入器状态-接入器6
	private WorkStatus asynAccess6;
	// 巡检时间
	private Date checkTime;
	// 创建日期
	private Date createTime;
	// 创建人
	private User creater;
	// 修改时间
	private Date updateTime;
	// 修改人
	private User updter;
	// 审核人
	private User judgeUser;
	// 审核时间
	private Date judgeTime;
	// 审核状态
	private FaxJudgeState judgeState;
	// 审核备注
	private String judgeRemark;
	

	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_A_REDUNDANCE_STATE")
	public ReduncdancyStatus getHostReduncdancyStatusA() {
		return hostReduncdancyStatusA;
	}

	public void setHostReduncdancyStatusA(
			ReduncdancyStatus hostReduncdancyStatusA) {
		this.hostReduncdancyStatusA = hostReduncdancyStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_A_WORK_STATE")
	public WorkStatus getHostWorkStatusA() {
		return hostWorkStatusA;
	}

	public void setHostWorkStatusA(WorkStatus hostWorkStatusA) {
		this.hostWorkStatusA = hostWorkStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_B_REDUNDANCE_STATE")
	public ReduncdancyStatus getHostReduncdancyStatusB() {
		return hostReduncdancyStatusB;
	}

	public void setHostReduncdancyStatusB(
			ReduncdancyStatus hostReduncdancyStatusB) {
		this.hostReduncdancyStatusB = hostReduncdancyStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_B_WORK_STATE")
	public WorkStatus getHostWorkStatusB() {
		return hostWorkStatusB;
	}

	public void setHostWorkStatusB(WorkStatus hostWorkStatusB) {
		this.hostWorkStatusB = hostWorkStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SYN_A_REDUNDANCE_STATE")
	public ReduncdancyStatus getSynReduncdancyStatusA() {
		return synReduncdancyStatusA;
	}

	public void setSynReduncdancyStatusA(ReduncdancyStatus synReduncdancyStatusA) {
		this.synReduncdancyStatusA = synReduncdancyStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SYN_A_WORK_STATE")
	public WorkStatus getSynWorkStatusA() {
		return synWorkStatusA;
	}

	public void setSynWorkStatusA(WorkStatus synWorkStatusA) {
		this.synWorkStatusA = synWorkStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SYN_B_REDUNDANCE_STATE")
	public ReduncdancyStatus getSynReduncdancyStatusB() {
		return synReduncdancyStatusB;
	}

	public void setSynReduncdancyStatusB(ReduncdancyStatus synReduncdancyStatusB) {
		this.synReduncdancyStatusB = synReduncdancyStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SYN_B_WORK_STATE")
	public WorkStatus getSynWorkStatusB() {
		return synWorkStatusB;
	}

	public void setSynWorkStatusB(WorkStatus synWorkStatusB) {
		this.synWorkStatusB = synWorkStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_A_REDUNDANCE_STATE")
	public ReduncdancyStatus getiReduncdancyStatusA() {
		return iReduncdancyStatusA;
	}

	public void setiReduncdancyStatusA(ReduncdancyStatus iReduncdancyStatusA) {
		this.iReduncdancyStatusA = iReduncdancyStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_A_WORK_STATE")
	public WorkStatus getiWorkStatusA() {
		return iWorkStatusA;
	}

	public void setiWorkStatusA(WorkStatus iWorkStatusA) {
		this.iWorkStatusA = iWorkStatusA;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_B_REDUNDANCE_STATE")
	public ReduncdancyStatus getiReduncdancyStatusB() {
		return iReduncdancyStatusB;
	}

	public void setiReduncdancyStatusB(ReduncdancyStatus iReduncdancyStatusB) {
		this.iReduncdancyStatusB = iReduncdancyStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_B_WORK_STATE")
	public WorkStatus getiWorkStatusB() {
		return iWorkStatusB;
	}

	public void setiWorkStatusB(WorkStatus iWorkStatusB) {
		this.iWorkStatusB = iWorkStatusB;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_C_REDUNDANCE_STATE")
	public ReduncdancyStatus getiReduncdancyStatusC() {
		return iReduncdancyStatusC;
	}

	public void setiReduncdancyStatusC(ReduncdancyStatus iReduncdancyStatusC) {
		this.iReduncdancyStatusC = iReduncdancyStatusC;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_C_WORK_STATE")
	public WorkStatus getiWorkStatusC() {
		return iWorkStatusC;
	}

	public void setiWorkStatusC(WorkStatus iWorkStatusC) {
		this.iWorkStatusC = iWorkStatusC;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_D_REDUNDANCE_STATE")
	public ReduncdancyStatus getiReduncdancyStatusD() {
		return iReduncdancyStatusD;
	}

	public void setiReduncdancyStatusD(ReduncdancyStatus iReduncdancyStatusD) {
		this.iReduncdancyStatusD = iReduncdancyStatusD;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "INTELLIGENT_D_WORK_STATE")
	public WorkStatus getiWorkStatusD() {
		return iWorkStatusD;
	}

	public void setiWorkStatusD(WorkStatus iWorkStatusD) {
		this.iWorkStatusD = iWorkStatusD;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_1")
	public WorkStatus getAsynAccess1() {
		return asynAccess1;
	}

	public void setAsynAccess1(WorkStatus asynAccess1) {
		this.asynAccess1 = asynAccess1;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_2")
	public WorkStatus getAsynAccess2() {
		return asynAccess2;
	}

	public void setAsynAccess2(WorkStatus asynAccess2) {
		this.asynAccess2 = asynAccess2;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_3")
	public WorkStatus getAsynAccess3() {
		return asynAccess3;
	}

	public void setAsynAccess3(WorkStatus asynAccess3) {
		this.asynAccess3 = asynAccess3;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_4")
	public WorkStatus getAsynAccess4() {
		return asynAccess4;
	}

	public void setAsynAccess4(WorkStatus asynAccess4) {
		this.asynAccess4 = asynAccess4;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_5")
	public WorkStatus getAsynAccess5() {
		return asynAccess5;
	}

	public void setAsynAccess5(WorkStatus asynAccess5) {
		this.asynAccess5 = asynAccess5;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ASYN_ACCESS_6")
	public WorkStatus getAsynAccess6() {
		return asynAccess6;
	}

	public void setAsynAccess6(WorkStatus asynAccess6) {
		this.asynAccess6 = asynAccess6;
	}

	@Column(name = "CHECK_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToOne
	@JoinColumn(name = "CREATER")
	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "UPDTER")
	public User getUpdter() {
		return updter;
	}

	public void setUpdter(User updter) {
		this.updter = updter;
	}
	
	@ManyToOne
	@JoinColumn(name="JUDGE_USER")
	public User getJudgeUser() {
		return judgeUser;
	}
	public void setJudgeUser(User judgeUser) {
		this.judgeUser = judgeUser;
	}
	
	@Column(name = "JUDGE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJudgeTime() {
		return judgeTime;
	}
	public void setJudgeTime(Date judgeTime) {
		this.judgeTime = judgeTime;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "JUDGE_STATE")
	public FaxJudgeState getJudgeState() {
		return judgeState;
	}
	public void setJudgeState(FaxJudgeState judgeState) {
		this.judgeState = judgeState;
	}
	
	@Column(name = "JUDGE_REMARK")
	public String getJudgeRemark() {
		return judgeRemark;
	}
	public void setJudgeRemark(String judgeRemark) {
		this.judgeRemark = judgeRemark;
	}

}
