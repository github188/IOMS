package cn.com.atnc.ioms.entity.duty.environment.ups;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 放电测试
 * @author renyujuan
 * @date 2016年7月6日下午2:34:13
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_DISC_TEST")
public class DischargeTest extends MyStringUUIDEntity {
	
	/**
	 * @date 2016年7月6日 下午2:26:13
	 */
	private static final long serialVersionUID = 1L;
	private Date startTime;				//放电开始时间
	private Date endTime;				//放电结束时间
	private String durationTime;			//放电持续时间
	private String preTotalV;				//放电前总电压
	private String endTotalV;				//放电终止总电压
	private String batChargingC;			//电池充电电流
	private EnvironmentEquipCheck upsCheck;				//巡检实体
	
	private transient List<DischargeProcess> dischargeProcess;
	@Transient
	public List<DischargeProcess> getDischargeProcess() {
		return dischargeProcess;
	}
	public void setDischargeProcess(List<DischargeProcess> dischargeProcess) {
		this.dischargeProcess = dischargeProcess;
	}
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="start_time")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="end_time")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Column(name="duration_time")
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	@Column(name="pre_total_v")
	public String getPreTotalV() {
		return preTotalV;
	}
	public void setPreTotalV(String preTotalV) {
		this.preTotalV = preTotalV;
	}
	
	@Column(name="end_total_v")
	public String getEndTotalV() {
		return endTotalV;
	}
	public void setEndTotalV(String endTotalV) {
		this.endTotalV = endTotalV;
	}
	
	@Column(name="bat_charging_c")
	public String getBatChargingC() {
		return batChargingC;
	}
	public void setBatChargingC(String batChargingC) {
		this.batChargingC = batChargingC;
	}
	
	@ManyToOne
	@JoinColumn(name="ups_check_id")
	public EnvironmentEquipCheck getUpsCheck() {
		return upsCheck;
	}
	public void setUpsCheck(EnvironmentEquipCheck upsCheck) {
		this.upsCheck = upsCheck;
	}
	
	
	
}
