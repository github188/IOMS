package cn.com.atnc.ioms.model.duty.fax.day;

import cn.com.atnc.ioms.enums.duty.ReduncdancyStatus;
import cn.com.atnc.ioms.enums.duty.WorkStatus;
import cn.com.atnc.ioms.enums.duty.fax.FaxStatus;
import cn.com.atnc.ioms.model.MyPaginModel;

public class FaxSystemModel extends MyPaginModel {

	//id
	private String hardwareId;
	private String proId;
	//审核备注
	private String judgeRemark;
	/***** 转报系统硬件检查（自动）日检 *********/
	
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

	/***** 转报系统进程检查（自动）日检 *********/
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

	public ReduncdancyStatus getHostReduncdancyStatusA() {
		return hostReduncdancyStatusA;
	}

	public void setHostReduncdancyStatusA(
			ReduncdancyStatus hostReduncdancyStatusA) {
		this.hostReduncdancyStatusA = hostReduncdancyStatusA;
	}

	public WorkStatus getHostWorkStatusA() {
		return hostWorkStatusA;
	}

	public void setHostWorkStatusA(WorkStatus hostWorkStatusA) {
		this.hostWorkStatusA = hostWorkStatusA;
	}

	public ReduncdancyStatus getHostReduncdancyStatusB() {
		return hostReduncdancyStatusB;
	}

	public void setHostReduncdancyStatusB(
			ReduncdancyStatus hostReduncdancyStatusB) {
		this.hostReduncdancyStatusB = hostReduncdancyStatusB;
	}

	public WorkStatus getHostWorkStatusB() {
		return hostWorkStatusB;
	}

	public void setHostWorkStatusB(WorkStatus hostWorkStatusB) {
		this.hostWorkStatusB = hostWorkStatusB;
	}

	public ReduncdancyStatus getSynReduncdancyStatusA() {
		return synReduncdancyStatusA;
	}

	public void setSynReduncdancyStatusA(ReduncdancyStatus synReduncdancyStatusA) {
		this.synReduncdancyStatusA = synReduncdancyStatusA;
	}

	public WorkStatus getSynWorkStatusA() {
		return synWorkStatusA;
	}

	public void setSynWorkStatusA(WorkStatus synWorkStatusA) {
		this.synWorkStatusA = synWorkStatusA;
	}

	public ReduncdancyStatus getSynReduncdancyStatusB() {
		return synReduncdancyStatusB;
	}

	public void setSynReduncdancyStatusB(ReduncdancyStatus synReduncdancyStatusB) {
		this.synReduncdancyStatusB = synReduncdancyStatusB;
	}

	public WorkStatus getSynWorkStatusB() {
		return synWorkStatusB;
	}

	public void setSynWorkStatusB(WorkStatus synWorkStatusB) {
		this.synWorkStatusB = synWorkStatusB;
	}

	public ReduncdancyStatus getiReduncdancyStatusA() {
		return iReduncdancyStatusA;
	}

	public void setiReduncdancyStatusA(ReduncdancyStatus iReduncdancyStatusA) {
		this.iReduncdancyStatusA = iReduncdancyStatusA;
	}

	public WorkStatus getiWorkStatusA() {
		return iWorkStatusA;
	}

	public void setiWorkStatusA(WorkStatus iWorkStatusA) {
		this.iWorkStatusA = iWorkStatusA;
	}

	public ReduncdancyStatus getiReduncdancyStatusB() {
		return iReduncdancyStatusB;
	}

	public void setiReduncdancyStatusB(ReduncdancyStatus iReduncdancyStatusB) {
		this.iReduncdancyStatusB = iReduncdancyStatusB;
	}

	public WorkStatus getiWorkStatusB() {
		return iWorkStatusB;
	}

	public void setiWorkStatusB(WorkStatus iWorkStatusB) {
		this.iWorkStatusB = iWorkStatusB;
	}

	public ReduncdancyStatus getiReduncdancyStatusC() {
		return iReduncdancyStatusC;
	}

	public void setiReduncdancyStatusC(ReduncdancyStatus iReduncdancyStatusC) {
		this.iReduncdancyStatusC = iReduncdancyStatusC;
	}

	public WorkStatus getiWorkStatusC() {
		return iWorkStatusC;
	}

	public void setiWorkStatusC(WorkStatus iWorkStatusC) {
		this.iWorkStatusC = iWorkStatusC;
	}

	public ReduncdancyStatus getiReduncdancyStatusD() {
		return iReduncdancyStatusD;
	}

	public void setiReduncdancyStatusD(ReduncdancyStatus iReduncdancyStatusD) {
		this.iReduncdancyStatusD = iReduncdancyStatusD;
	}

	public WorkStatus getiWorkStatusD() {
		return iWorkStatusD;
	}

	public void setiWorkStatusD(WorkStatus iWorkStatusD) {
		this.iWorkStatusD = iWorkStatusD;
	}

	public WorkStatus getAsynAccess1() {
		return asynAccess1;
	}

	public void setAsynAccess1(WorkStatus asynAccess1) {
		this.asynAccess1 = asynAccess1;
	}

	public WorkStatus getAsynAccess2() {
		return asynAccess2;
	}

	public void setAsynAccess2(WorkStatus asynAccess2) {
		this.asynAccess2 = asynAccess2;
	}

	public WorkStatus getAsynAccess3() {
		return asynAccess3;
	}

	public void setAsynAccess3(WorkStatus asynAccess3) {
		this.asynAccess3 = asynAccess3;
	}

	public WorkStatus getAsynAccess4() {
		return asynAccess4;
	}

	public void setAsynAccess4(WorkStatus asynAccess4) {
		this.asynAccess4 = asynAccess4;
	}

	public WorkStatus getAsynAccess5() {
		return asynAccess5;
	}

	public void setAsynAccess5(WorkStatus asynAccess5) {
		this.asynAccess5 = asynAccess5;
	}

	public WorkStatus getAsynAccess6() {
		return asynAccess6;
	}

	public void setAsynAccess6(WorkStatus asynAccess6) {
		this.asynAccess6 = asynAccess6;
	}

	public FaxStatus getHostDmhsMonPro() {
		return hostDmhsMonPro;
	}

	public void setHostDmhsMonPro(FaxStatus hostDmhsMonPro) {
		this.hostDmhsMonPro = hostDmhsMonPro;
	}

	public FaxStatus getHostDmhsAfsPro() {
		return hostDmhsAfsPro;
	}

	public void setHostDmhsAfsPro(FaxStatus hostDmhsAfsPro) {
		this.hostDmhsAfsPro = hostDmhsAfsPro;
	}

	public FaxStatus getHostIPPro() {
		return hostIPPro;
	}

	public void setHostIPPro(FaxStatus hostIPPro) {
		this.hostIPPro = hostIPPro;
	}

	public FaxStatus getHostR25Pro() {
		return hostR25Pro;
	}

	public void setHostR25Pro(FaxStatus hostR25Pro) {
		this.hostR25Pro = hostR25Pro;
	}

	public FaxStatus getHostAsynPro() {
		return hostAsynPro;
	}

	public void setHostAsynPro(FaxStatus hostAsynPro) {
		this.hostAsynPro = hostAsynPro;
	}

	public FaxStatus getHostFRPro() {
		return hostFRPro;
	}

	public void setHostFRPro(FaxStatus hostFRPro) {
		this.hostFRPro = hostFRPro;
	}

	public FaxStatus getHostMATIPPro() {
		return hostMATIPPro;
	}

	public void setHostMATIPPro(FaxStatus hostMATIPPro) {
		this.hostMATIPPro = hostMATIPPro;
	}

	public FaxStatus getHostDBPro() {
		return hostDBPro;
	}

	public void setHostDBPro(FaxStatus hostDBPro) {
		this.hostDBPro = hostDBPro;
	}

	public FaxStatus getBackupDmhsMonPro() {
		return backupDmhsMonPro;
	}

	public void setBackupDmhsMonPro(FaxStatus backupDmhsMonPro) {
		this.backupDmhsMonPro = backupDmhsMonPro;
	}

	public FaxStatus getBackupDmhsAfsPro() {
		return backupDmhsAfsPro;
	}

	public void setBackupDmhsAfsPro(FaxStatus backupDmhsAfsPro) {
		this.backupDmhsAfsPro = backupDmhsAfsPro;
	}

	public FaxStatus getBackupDBPro() {
		return backupDBPro;
	}

	public void setBackupDBPro(FaxStatus backupDBPro) {
		this.backupDBPro = backupDBPro;
	}

	public FaxStatus getHostIProIpA() {
		return hostIProIpA;
	}

	public void setHostIProIpA(FaxStatus hostIProIpA) {
		this.hostIProIpA = hostIProIpA;
	}

	public FaxStatus getHostIProSerialPortA() {
		return hostIProSerialPortA;
	}

	public void setHostIProSerialPortA(FaxStatus hostIProSerialPortA) {
		this.hostIProSerialPortA = hostIProSerialPortA;
	}

	public FaxStatus getHostIProIpB() {
		return hostIProIpB;
	}

	public void setHostIProIpB(FaxStatus hostIProIpB) {
		this.hostIProIpB = hostIProIpB;
	}

	public FaxStatus getHostIProSerialPortB() {
		return hostIProSerialPortB;
	}

	public void setHostIProSerialPortB(FaxStatus hostIProSerialPortB) {
		this.hostIProSerialPortB = hostIProSerialPortB;
	}

	public FaxStatus getBackupIProIpA() {
		return backupIProIpA;
	}

	public void setBackupIProIpA(FaxStatus backupIProIpA) {
		this.backupIProIpA = backupIProIpA;
	}

	public FaxStatus getBackupIProSerialPortA() {
		return backupIProSerialPortA;
	}

	public void setBackupIProSerialPortA(FaxStatus backupIProSerialPortA) {
		this.backupIProSerialPortA = backupIProSerialPortA;
	}

	public FaxStatus getBackupIProIpB() {
		return backupIProIpB;
	}

	public void setBackupIProIpB(FaxStatus backupIProIpB) {
		this.backupIProIpB = backupIProIpB;
	}

	public FaxStatus getBackupIProSerialPortB() {
		return backupIProSerialPortB;
	}

	public void setBackupIProSerialPortB(FaxStatus backupIProSerialPortB) {
		this.backupIProSerialPortB = backupIProSerialPortB;
	}

	
	public String getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getJudgeRemark() {
		return judgeRemark;
	}

	public void setJudgeRemark(String judgeRemark) {
		this.judgeRemark = judgeRemark;
	}

	
	
}
