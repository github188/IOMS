package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;

/**
 * 十里河-PES-基带机架运行情况
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:30:55
 * @version 1.0, 2016年10月13日 下午2:30:55
 */
@Entity
@Table(name="TB_OM_DUTY_STA_SLH_JDJJ")
public class SlhJdjj extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String sic; // SIC
	private String sicb; // 备用SIC
	private String ncc; // NCC(上)
	private String nccb; // 备用NCC(下)
	private String dpc1; // DPC1
	private String dpc2; // DPC2
	private String dpc3; // DPC3
	private String dpcb; // 备用DPC
	private String suplim1; // suplim1
	private String suplim2; // suplim2
	private String suplim3; // suplim3
	private String suplim4; // suplim4
	private String suplim5; // suplim5
	private String suplim6; // suplim6
	private String suplimb; // 备用suplimb
	private EnvironmentEquipCheck checkid; // 巡检id

	@Column(name = "sic")
	public String getSic() {
		return sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	@Column(name = "sic_b")
	public String getSicb() {
		return sicb;
	}

	public void setSicb(String sicb) {
		this.sicb = sicb;
	}

	@Column(name = "ncc")
	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	@Column(name = "ncc_b")
	public String getNccb() {
		return nccb;
	}

	public void setNccb(String nccb) {
		this.nccb = nccb;
	}

	@Column(name = "dpc1")
	public String getDpc1() {
		return dpc1;
	}

	public void setDpc1(String dpc1) {
		this.dpc1 = dpc1;
	}

	@Column(name = "dpc2")
	public String getDpc2() {
		return dpc2;
	}

	public void setDpc2(String dpc2) {
		this.dpc2 = dpc2;
	}

	@Column(name = "dpc3")
	public String getDpc3() {
		return dpc3;
	}

	public void setDpc3(String dpc3) {
		this.dpc3 = dpc3;
	}

	@ManyToOne
	@JoinColumn(name = "check_id")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

	@Column(name = "dpc_b")
	public String getDpcb() {
		return dpcb;
	}

	public void setDpcb(String dpcb) {
		this.dpcb = dpcb;
	}

	@Column(name = "suplim1")
	public String getSuplim1() {
		return suplim1;
	}

	public void setSuplim1(String suplim1) {
		this.suplim1 = suplim1;
	}

	@Column(name = "suplim2")
	public String getSuplim2() {
		return suplim2;
	}

	public void setSuplim2(String suplim2) {
		this.suplim2 = suplim2;
	}

	@Column(name = "suplim3")
	public String getSuplim3() {
		return suplim3;
	}

	public void setSuplim3(String suplim3) {
		this.suplim3 = suplim3;
	}

	@Column(name = "suplim4")
	public String getSuplim4() {
		return suplim4;
	}

	public void setSuplim4(String suplim4) {
		this.suplim4 = suplim4;
	}

	@Column(name = "suplim5")
	public String getSuplim5() {
		return suplim5;
	}

	public void setSuplim5(String suplim5) {
		this.suplim5 = suplim5;
	}

	@Column(name = "suplim6")
	public String getSuplim6() {
		return suplim6;
	}

	public void setSuplim6(String suplim6) {
		this.suplim6 = suplim6;
	}

	@Column(name = "suplim_b")
	public String getSuplimb() {
		return suplimb;
	}

	public void setSuplimb(String suplimb) {
		this.suplimb = suplimb;
	}

}
