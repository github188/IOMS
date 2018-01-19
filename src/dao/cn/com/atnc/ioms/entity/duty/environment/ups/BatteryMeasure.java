package cn.com.atnc.ioms.entity.duty.environment.ups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 电池测量
 * @author renyujuan
 * @date 2016年7月6日下午2:33:36
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_BAT_MEA")
public class BatteryMeasure extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	
	private int number;						//电池序号
	private String termialV;				//端电压
	private String interR;					//内阻
	private String remarks;					//备注
	private EnvironmentEquipCheck upsCheck;				//ups巡检实体
	
	@Column(name="num")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Column(name="termial_v")
	public String getTermialV() {
		return termialV;
	}
	public void setTermialV(String termialV) {
		this.termialV = termialV;
	}
	@Column(name="inter_r")
	public String getInterR() {
		return interR;
	}
	public void setInterR(String interR) {
		this.interR = interR;
	}
	@Column(name="remark")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
