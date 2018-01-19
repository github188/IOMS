package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;

/**
 * 通信基地-KU-网管系统维护
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_KUSYS")
public class KuSys extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CheckResult net1Workstate;//子网1网管工作站状态
	private CheckResult net2Workstate;//子网2网管工作站状态
	private CheckResult net3Workstate;//子网3网管工作站状态
	private CheckResult net4Workstate;//子网4网管工作站状态
	private CheckResult netzWorkstate;//帧中继网管工作站状态
	private CheckResult net1WorkstateBf;//子网1网管工作站数据备份至磁带
	private CheckResult net2WorkstateBf;//子网2网管工作站数据备份至磁带
	private CheckResult net3WorkstateBf;//子网3网管工作站数据备份至磁带
	private CheckResult net4WorkstateBf;//子网4网管工作站数据备份至磁带
	private CheckResult netzWorkstateBf;//帧中继网管工作站数据备份至磁带
	private String tapeLocate;//磁带存放位置
	private String workDust;//网管工作站除尘
	private String forward;//转发器底噪电平
	private String subnetWorkRemark;//子网工作站状态备注
	private String subnetDataRemark;//子网数据备份磁盘备注
	private String tapeLocateRemark;//磁带存放位置备注
	private String workDustRemark;//网管工作站除尘备注
	private String forwardRemark;//转发器底噪电平（切空图查看）备注

	private EnvironmentEquipCheck checkid;// 巡检id
	
	
	@ManyToOne
	@JoinColumn(name = "checkid")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}
	@Column(name = "forward")
	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net1_workstate")
	
	public CheckResult getNet1Workstate() {
		return net1Workstate;
	}

	public void setNet1Workstate(CheckResult net1Workstate) {
		this.net1Workstate = net1Workstate;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net2_workstate")
	public CheckResult getNet2Workstate() {
		return net2Workstate;
	}

	public void setNet2Workstate(CheckResult net2Workstate) {
		this.net2Workstate = net2Workstate;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net3_workstate")
	public CheckResult getNet3Workstate() {
		return net3Workstate;
	}

	public void setNet3Workstate(CheckResult net3Workstate) {
		this.net3Workstate = net3Workstate;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net4_workstate")
	public CheckResult getNet4Workstate() {
		return net4Workstate;
	}

	public void setNet4Workstate(CheckResult net4Workstate) {
		this.net4Workstate = net4Workstate;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "netz_workstate")
	public CheckResult getNetzWorkstate() {
		return netzWorkstate;
	}

	public void setNetzWorkstate(CheckResult netzWorkstate) {
		this.netzWorkstate = netzWorkstate;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net1_workstate_bf")
	public CheckResult getNet1WorkstateBf() {
		return net1WorkstateBf;
	}

	public void setNet1WorkstateBf(CheckResult net1WorkstateBf) {
		this.net1WorkstateBf = net1WorkstateBf;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net2_workstate_bf")
	public CheckResult getNet2WorkstateBf() {
		return net2WorkstateBf;
	}

	public void setNet2WorkstateBf(CheckResult net2WorkstateBf) {
		this.net2WorkstateBf = net2WorkstateBf;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net3_workstate_bf")
	public CheckResult getNet3WorkstateBf() {
		return net3WorkstateBf;
	}

	public void setNet3WorkstateBf(CheckResult net3WorkstateBf) {
		this.net3WorkstateBf = net3WorkstateBf;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "net4_workstate_bf")
	public CheckResult getNet4WorkstateBf() {
		return net4WorkstateBf;
	}

	public void setNet4WorkstateBf(CheckResult net4WorkstateBf) {
		this.net4WorkstateBf = net4WorkstateBf;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "netz_workstate_bf")
	public CheckResult getNetzWorkstateBf() {
		return netzWorkstateBf;
	}

	public void setNetzWorkstateBf(CheckResult netzWorkstateBf) {
		this.netzWorkstateBf = netzWorkstateBf;
	}
	
	@Column(name = "tape_locate")
	public String getTapeLocate() {
		return tapeLocate;
	}
	public void setTapeLocate(String tapeLocate) {
		this.tapeLocate = tapeLocate;
	}
	@Column(name = "work_dust")
	public String getWorkDust() {
		return workDust;
	}

	public void setWorkDust(String workDust) {
		this.workDust = workDust;
	}
	@Column(name = "subnet_work_remark")
	public String getSubnetWorkRemark() {
		return subnetWorkRemark;
	}

	public void setSubnetWorkRemark(String subnetWorkRemark) {
		this.subnetWorkRemark = subnetWorkRemark;
	}
	@Column(name = "subnet_data_remark")
	public String getSubnetDataRemark() {
		return subnetDataRemark;
	}

	public void setSubnetDataRemark(String subnetDataRemark) {
		this.subnetDataRemark = subnetDataRemark;
	}
	@Column(name = "tape_locate_remark")
	public String getTapeLocateRemark() {
		return tapeLocateRemark;
	}

	public void setTapeLocateRemark(String tapeLocateRemark) {
		this.tapeLocateRemark = tapeLocateRemark;
	}
	@Column(name = "work_dust_remark")
	public String getWorkDustRemark() {
		return workDustRemark;
	}

	public void setWorkDustRemark(String workDustRemark) {
		this.workDustRemark = workDustRemark;
	}
	@Column(name = "forward_remark")
	public String getForwardRemark() {
		return forwardRemark;
	}

	public void setForwardRemark(String forwardRemark) {
		this.forwardRemark = forwardRemark;
	}

	

}
