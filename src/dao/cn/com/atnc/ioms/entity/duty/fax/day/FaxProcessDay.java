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
import cn.com.atnc.ioms.enums.duty.fax.FaxJudgeState;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;

/**
 * 转报系统进程检查（自动）日检
 *
 * @author 韩天驭
 * @2017年1月22日 下午4:26:25
 */
@Entity
@Table(name = "TB_OM_DUTY_FAX_DAY_PROCESS")
public class FaxProcessDay extends MyStringUUIDEntity {

	private static final long serialversionUID = 1L;
	
	// 库操作进程是否正常
	private FaxStatus hostDmhsMonPro;
	// 双机进程是否正常（主）
	private FaxStatus hostDmhsAfsPro;
	// 查看IP进程（主）
	private FaxStatus hostIPPro;
	// 查看R25进程（主）
	private FaxStatus hostR25Pro;
	// 查看异步进程（主）
	private FaxStatus hostAsynPro;
	// 查看帧中继进程（主）
	private FaxStatus hostFRPro;
	// 查看matip进程是否正常（主）
	private FaxStatus hostMATIPPro;
	// 查看数据库进程（主）
	private FaxStatus hostDBPro;

	// 库操作进程是否正常（备）
	private FaxStatus backupDmhsMonPro;
	// 双机进程是否正常（备）
	private FaxStatus backupDmhsAfsPro;
	// 查看数据库进程（备）
	private FaxStatus backupDBPro;

	
	// 查看IP连接进程（主用-智能集中器A）
	private FaxStatus hostIProIpA;
	// 查看串口通信进程（主用-智能集中器A）SERIALPORT
	private FaxStatus hostIProSerialPortA;
	// 查看IP连接进程（主用-智能集中器B）
	private FaxStatus hostIProIpB;
	// 查看串口通信进程（主用-智能集中器B）SERIALPORT
	private FaxStatus hostIProSerialPortB;
	
	// 查看IP连接进程（备用-智能集中器A）
	private FaxStatus backupIProIpA;
	// 查看串口通信进程（备用-智能集中器A）SERIALPORT
	private FaxStatus backupIProSerialPortA;
	// 查看IP连接进程（备用-智能集中器B）
	private FaxStatus backupIProIpB;
	// 查看串口通信进程（备用-智能集中器B）SERIALPORT
	private FaxStatus backupIProSerialPortB;
	
	
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
	
	//审核人
	private User judgeUser;
	//审核时间
	private Date judgeTime;
	//审核状态
	private FaxJudgeState judgeState;
	//审核备注
	private String judgeRemark;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_DMHS_MON_PRO")
	public FaxStatus getHostDmhsMonPro() {
		return hostDmhsMonPro;
	}
	public void setHostDmhsMonPro(FaxStatus hostDmhsMonPro) {
		this.hostDmhsMonPro = hostDmhsMonPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_DMHS_AFS_PRO")
	public FaxStatus getHostDmhsAfsPro() {
		return hostDmhsAfsPro;
	}
	public void setHostDmhsAfsPro(FaxStatus hostDmhsAfsPro) {
		this.hostDmhsAfsPro = hostDmhsAfsPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_IP_PRO")
	public FaxStatus getHostIPPro() {
		return hostIPPro;
	}
	public void setHostIPPro(FaxStatus hostIPPro) {
		this.hostIPPro = hostIPPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_R25_PRO")
	public FaxStatus getHostR25Pro() {
		return hostR25Pro;
	}
	public void setHostR25Pro(FaxStatus hostR25Pro) {
		this.hostR25Pro = hostR25Pro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_ASYNCHRONOUS_PRO")
	public FaxStatus getHostAsynPro() {
		return hostAsynPro;
	}
	public void setHostAsynPro(FaxStatus hostAsynPro) {
		this.hostAsynPro = hostAsynPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_FRAME_RELAY_PRO")
	public FaxStatus getHostFRPro() {
		return hostFRPro;
	}
	public void setHostFRPro(FaxStatus hostFRPro) {
		this.hostFRPro = hostFRPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_MATIP_PRO")
	public FaxStatus getHostMATIPPro() {
		return hostMATIPPro;
	}
	public void setHostMATIPPro(FaxStatus hostMATIPPro) {
		this.hostMATIPPro = hostMATIPPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_DB_PRO")
	public FaxStatus getHostDBPro() {
		return hostDBPro;
	}
	public void setHostDBPro(FaxStatus hostDBPro) {
		this.hostDBPro = hostDBPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_DMHS_MON_PRO")
	public FaxStatus getBackupDmhsMonPro() {
		return backupDmhsMonPro;
	}
	public void setBackupDmhsMonPro(FaxStatus backupDmhsMonPro) {
		this.backupDmhsMonPro = backupDmhsMonPro;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_DMHS_AFS_PRO")
	public FaxStatus getBackupDmhsAfsPro() {
		return backupDmhsAfsPro;
	}
	public void setBackupDmhsAfsPro(FaxStatus backupDmhsAfsPro) {
		this.backupDmhsAfsPro = backupDmhsAfsPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_DB_PRO")
	public FaxStatus getBackupDBPro() {
		return backupDBPro;
	}
	public void setBackupDBPro(FaxStatus backupDBPro) {
		this.backupDBPro = backupDBPro;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_I_A_IP_PRO")
	public FaxStatus getHostIProIpA() {
		return hostIProIpA;
	}
	public void setHostIProIpA(FaxStatus hostIProIpA) {
		this.hostIProIpA = hostIProIpA;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_I_A_SERIALPORT_PRO")
	public FaxStatus getHostIProSerialPortA() {
		return hostIProSerialPortA;
	}
	public void setHostIProSerialPortA(FaxStatus hostIProSerialPortA) {
		this.hostIProSerialPortA = hostIProSerialPortA;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_I_B_IP_PRO")
	public FaxStatus getHostIProIpB() {
		return hostIProIpB;
	}
	public void setHostIProIpB(FaxStatus hostIProIpB) {
		this.hostIProIpB = hostIProIpB;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "HOST_I_B_SERIALPORT_PRO")
	public FaxStatus getHostIProSerialPortB() {
		return hostIProSerialPortB;
	}
	public void setHostIProSerialPortB(FaxStatus hostIProSerialPortB) {
		this.hostIProSerialPortB = hostIProSerialPortB;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_I_A_IP_PRO")
	public FaxStatus getBackupIProIpA() {
		return backupIProIpA;
	}
	public void setBackupIProIpA(FaxStatus backupIProIpA) {
		this.backupIProIpA = backupIProIpA;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_I_A_SERIALPORT_PRO")
	public FaxStatus getBackupIProSerialPortA() {
		return backupIProSerialPortA;
	}
	public void setBackupIProSerialPortA(FaxStatus backupIProSerialPortA) {
		this.backupIProSerialPortA = backupIProSerialPortA;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_I_B_IP_PRO")
	public FaxStatus getBackupIProIpB() {
		return backupIProIpB;
	}
	public void setBackupIProIpB(FaxStatus backupIProIpB) {
		this.backupIProIpB = backupIProIpB;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BACKUP_I_B_SERIALPORT_PRO")
	public FaxStatus getBackupIProSerialPortB() {
		return backupIProSerialPortB;
	}
	public void setBackupIProSerialPortB(FaxStatus backupIProSerialPortB) {
		this.backupIProSerialPortB = backupIProSerialPortB;
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
	@JoinColumn(name="CREATER")
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
	@JoinColumn(name="UPDTER")
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
