package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class KuSysModel extends MyPaginModel {

	private String id;
	private EnvironmentEquipCheck checkid;// 巡检id
	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;
	private EquipType equipType;
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间

	private CheckResult net1Workstate;
	private CheckResult net2Workstate;
	private CheckResult net3Workstate;
	private CheckResult net4Workstate;
	private CheckResult netzWorkstate;
	private CheckResult net1WorkstateBf;
	private CheckResult net2WorkstateBf;
	private CheckResult net3WorkstateBf;
	private CheckResult net4WorkstateBf;
	private CheckResult netzWorkstateBf;
	private String tapeLocate;
	private String workDust;
	private String forward;
	private String subnetWorkRemark;
	private String subnetDataRemark;
	private String tapeLocateRemark;
	private String workDustRemark;
	private String forwardRemark;

	public KuSysModel() {
	}

	public KuSysModel(CheckResult net1Workstate, CheckResult net2Workstate,
			CheckResult net3Workstate, CheckResult net4Workstate,
			CheckResult netzWorkstate, CheckResult net1WorkstateBf,
			CheckResult net2WorkstateBf, CheckResult net3WorkstateBf,
			CheckResult net4WorkstateBf, CheckResult netzWorkstateBf,
			String tapeLocate, String workDust, String forward,
			String subnetWorkRemark, String subnetDataRemark,
			String tapeLocateRemark, String workDustRemark,
			String forwardRemark, String id, EnvironmentEquipCheck checkid,
			Date checkDate, Date checkTime, User operator) {
		this.net1Workstate = net1Workstate;
		this.net2Workstate = net2Workstate;
		this.net3Workstate = net3Workstate;
		this.net4Workstate = net4Workstate;
		this.netzWorkstate = netzWorkstate;
		this.net1WorkstateBf = net1WorkstateBf;
		this.net2WorkstateBf = net2WorkstateBf;
		this.net3WorkstateBf = net3WorkstateBf;
		this.net4WorkstateBf = net4WorkstateBf;
		this.netzWorkstateBf = netzWorkstateBf;
		this.tapeLocate = tapeLocate;
		this.workDust = workDust;
		this.forward = forward;
		this.subnetWorkRemark = subnetWorkRemark;
		this.subnetDataRemark = subnetDataRemark;
		this.tapeLocateRemark = tapeLocateRemark;
		this.workDustRemark = workDustRemark;
		this.forwardRemark = forwardRemark;
		this.id = id;
		this.checkid = checkid;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.operator = operator;
	}

	public CheckResult getNet1Workstate() {
		return net1Workstate;
	}

	public void setNet1Workstate(CheckResult net1Workstate) {
		this.net1Workstate = net1Workstate;
	}

	public CheckResult getNet2Workstate() {
		return net2Workstate;
	}

	public void setNet2Workstate(CheckResult net2Workstate) {
		this.net2Workstate = net2Workstate;
	}

	public CheckResult getNet3Workstate() {
		return net3Workstate;
	}

	public void setNet3Workstate(CheckResult net3Workstate) {
		this.net3Workstate = net3Workstate;
	}

	public CheckResult getNet4Workstate() {
		return net4Workstate;
	}

	public void setNet4Workstate(CheckResult net4Workstate) {
		this.net4Workstate = net4Workstate;
	}

	public CheckResult getNetzWorkstate() {
		return netzWorkstate;
	}

	public void setNetzWorkstate(CheckResult netzWorkstate) {
		this.netzWorkstate = netzWorkstate;
	}

	public CheckResult getNet1WorkstateBf() {
		return net1WorkstateBf;
	}

	public void setNet1WorkstateBf(CheckResult net1WorkstateBf) {
		this.net1WorkstateBf = net1WorkstateBf;
	}

	public CheckResult getNet2WorkstateBf() {
		return net2WorkstateBf;
	}

	public void setNet2WorkstateBf(CheckResult net2WorkstateBf) {
		this.net2WorkstateBf = net2WorkstateBf;
	}

	public CheckResult getNet3WorkstateBf() {
		return net3WorkstateBf;
	}

	public void setNet3WorkstateBf(CheckResult net3WorkstateBf) {
		this.net3WorkstateBf = net3WorkstateBf;
	}

	public CheckResult getNet4WorkstateBf() {
		return net4WorkstateBf;
	}

	public void setNet4WorkstateBf(CheckResult net4WorkstateBf) {
		this.net4WorkstateBf = net4WorkstateBf;
	}

	public CheckResult getNetzWorkstateBf() {
		return netzWorkstateBf;
	}

	public void setNetzWorkstateBf(CheckResult netzWorkstateBf) {
		this.netzWorkstateBf = netzWorkstateBf;
	}

	public String getTapeLocate() {
		return tapeLocate;
	}

	public void setTapeLocate(String tapeLocate) {
		this.tapeLocate = tapeLocate;
	}

	public String getWorkDust() {
		return workDust;
	}

	public void setWorkDust(String workDust) {
		this.workDust = workDust;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getSubnetWorkRemark() {
		return subnetWorkRemark;
	}

	public void setSubnetWorkRemark(String subnetWorkRemark) {
		this.subnetWorkRemark = subnetWorkRemark;
	}

	public String getSubnetDataRemark() {
		return subnetDataRemark;
	}

	public void setSubnetDataRemark(String subnetDataRemark) {
		this.subnetDataRemark = subnetDataRemark;
	}

	public String getTapeLocateRemark() {
		return tapeLocateRemark;
	}

	public void setTapeLocateRemark(String tapeLocateRemark) {
		this.tapeLocateRemark = tapeLocateRemark;
	}

	public String getWorkDustRemark() {
		return workDustRemark;
	}

	public void setWorkDustRemark(String workDustRemark) {
		this.workDustRemark = workDustRemark;
	}

	public String getForwardRemark() {
		return forwardRemark;
	}

	public void setForwardRemark(String forwardRemark) {
		this.forwardRemark = forwardRemark;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	private CheckResult datastate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

	public CheckResult getDatastate() {
		return datastate;
	}

	public void setDatastate(CheckResult datastate) {
		this.datastate = datastate;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}
}
