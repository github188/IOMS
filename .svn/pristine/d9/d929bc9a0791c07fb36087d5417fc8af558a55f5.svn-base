package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class TesCheckModel extends MyPaginModel {

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

	private CheckResult recordGz;
	private CheckResult recordManual;
	private CheckResult recordBj;
	private String recordBf;
	private String recordGzBz;
	private String recordManualBz;
	private String recordBjBz;
	private String recordBfBz;

	public TesCheckModel() {
	}

	public TesCheckModel(CheckResult recordGz, CheckResult recordManual,
			CheckResult recordBj, String recordBf, String recordGzBz,
			String recordManualBz, String recordBjBz, String recordBfBz,
			String id, EnvironmentEquipCheck checkid, Date checkDate,
			Date checkTime, User operator) {
		this.recordGz = recordGz;
		this.recordManual = recordManual;
		this.recordBj = recordBj;
		this.recordBf = recordBf;
		this.recordGzBz = recordGzBz;
		this.recordManualBz = recordManualBz;
		this.recordBjBz = recordBjBz;
		this.recordBfBz = recordBfBz;
		this.id = id;
		this.checkid = checkid;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.operator = operator;

	}

	public CheckResult getRecordGz() {
		return recordGz;
	}

	public void setRecordGz(CheckResult recordGz) {
		this.recordGz = recordGz;
	}

	public CheckResult getRecordManual() {
		return recordManual;
	}

	public void setRecordManual(CheckResult recordManual) {
		this.recordManual = recordManual;
	}

	public CheckResult getRecordBj() {
		return recordBj;
	}

	public void setRecordBj(CheckResult recordBj) {
		this.recordBj = recordBj;
	}

	public String getRecordBf() {
		return recordBf;
	}

	public void setRecordBf(String recordBf) {
		this.recordBf = recordBf;
	}

	public String getRecordGzBz() {
		return recordGzBz;
	}

	public void setRecordGzBz(String recordGzBz) {
		this.recordGzBz = recordGzBz;
	}

	public String getRecordManualBz() {
		return recordManualBz;
	}

	public void setRecordManualBz(String recordManualBz) {
		this.recordManualBz = recordManualBz;
	}

	public String getRecordBjBz() {
		return recordBjBz;
	}

	public void setRecordBjBz(String recordBjBz) {
		this.recordBjBz = recordBjBz;
	}

	public String getRecordBfBz() {
		return recordBfBz;
	}

	public void setRecordBfBz(String recordBfBz) {
		this.recordBfBz = recordBfBz;
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
