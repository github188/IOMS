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
 * 通信基地-TES-网管系统检查
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TESCHECK")
public class TesCheck extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CheckResult recordGz;
	private CheckResult recordManual;
	private CheckResult recordBj;
	private String recordBf;
	private String recordGzBz;
	private String recordManualBz;
	private String recordBjBz;
	private String recordBfBz;
	private EnvironmentEquipCheck checkid;// 巡检id

	@ManyToOne
	@JoinColumn(name = "checkid")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "record_gz")
	public CheckResult getRecordGz() {
		return recordGz;
	}

	public void setRecordGz(CheckResult recordGz) {
		this.recordGz = recordGz;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "record_manual")
	public CheckResult getRecordManual() {
		return recordManual;
	}

	public void setRecordManual(CheckResult recordManual) {
		this.recordManual = recordManual;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "record_bj")
	public CheckResult getRecordBj() {
		return recordBj;
	}

	public void setRecordBj(CheckResult recordBj) {
		this.recordBj = recordBj;
	}

	@Column(name = "record_bf")
	public String getRecordBf() {
		return recordBf;
	}

	public void setRecordBf(String recordBf) {
		this.recordBf = recordBf;
	}

	@Column(name = "record_gz_bz")
	public String getRecordGzBz() {
		return recordGzBz;
	}

	public void setRecordGzBz(String recordGzBz) {
		this.recordGzBz = recordGzBz;
	}

	@Column(name = "record_manual_bz")
	public String getRecordManualBz() {
		return recordManualBz;
	}

	public void setRecordManualBz(String recordManualBz) {
		this.recordManualBz = recordManualBz;
	}

	@Column(name = "record_bj_bz")
	public String getRecordBjBz() {
		return recordBjBz;
	}

	public void setRecordBjBz(String recordBjBz) {
		this.recordBjBz = recordBjBz;
	}

	@Column(name = "record_bf_bz")
	public String getRecordBfBz() {
		return recordBfBz;
	}

	public void setRecordBfBz(String recordBfBz) {
		this.recordBfBz = recordBfBz;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

}
