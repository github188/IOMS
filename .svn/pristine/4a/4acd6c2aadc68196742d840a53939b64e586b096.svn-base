package cn.com.atnc.ioms.entity.duty.environment.ups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
/**
 * 放电过程
 * @author renyujuan
 * @date 2016年7月6日下午2:34:39
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_DISC_PROCESS")
public class DischargeProcess extends MyStringUUIDEntity {

	/**
	 * @date 2016年7月6日 下午2:27:19
	 */
	private static final long serialVersionUID = 1L;
	
	private String dsTime;				//放电时间
	private String batTotalV;			//电池总电压
	private String dsCurrent;			//放电电流
	private String singleMaxV;			//单节最高电压
	private String singleMinV;			//单节最低电压
	private String remark;				//备注
	private DischargeTest dischargeTest;
	
	@Column(name="ds_time")
	public String getDsTime() {
		return dsTime;
	}
	public void setDsTime(String dsTime) {
		this.dsTime = dsTime;
	}
	
	@Column(name="bat_total_v")
	public String getBatTotalV() {
		return batTotalV;
	}
	public void setBatTotalV(String batTotalV) {
		this.batTotalV = batTotalV;
	}
	@Column(name="ds_current")
	public String getDsCurrent() {
		return dsCurrent;
	}
	public void setDsCurrent(String dsCurrent) {
		this.dsCurrent = dsCurrent;
	}
	
	@Column(name="single_max_v")
	public String getSingleMaxV() {
		return singleMaxV;
	}
	public void setSingleMaxV(String singleMaxV) {
		this.singleMaxV = singleMaxV;
	}
	
	@Column(name="single_min_v")
	public String getSingleMinV() {
		return singleMinV;
	}
	public void setSingleMinV(String singleMinV) {
		this.singleMinV = singleMinV;
	}
	
	@Column(name="remarks")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ManyToOne
	@JoinColumn(name="disc_test_id")
	public DischargeTest getDischargeTest() {
		return dischargeTest;
	}
	public void setDischargeTest(DischargeTest dischargeTest) {
		this.dischargeTest = dischargeTest;
	}
	
	

}
