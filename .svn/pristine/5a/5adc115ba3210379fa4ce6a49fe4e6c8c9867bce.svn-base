package cn.com.atnc.ioms.entity.duty.environment.ups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 系统连接检查
 * @author renyujuan
 * @date 2016年7月6日下午3:44:23
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_SYSCONN_MEA")
public class SystemConnMeasure extends MyStringUUIDEntity {

	/**
	 * @date 2016年7月6日 下午3:44:46
	 */
	private static final long serialVersionUID = 1L;
	
	private String upsIcTr;						//Ups内部连接端子是否牢固测试结果
	private String upsIcRemark;					//Ups内部连接端子是否牢固备注
	private String upsFRunTr;					//UPS风扇运转是否正常测试结果
	private String upsFRunRemark;				//UPS风扇运转是否正常备注
	private String upsIbFirmTr;					//UPS内部板卡是否牢固测试结果
	private String upsIbFirmRemark;				//UPS内部板卡是否牢固备注
	private String upsCwOhTr;					//UPS连接导线是否无过热现象测试结果
	private String upsCwOhRemark;				//UPS连接导线是否无过热现象备注
	private String upsRvTr;						//UPS运行声音是否正常测试结果
	private String upsRvRemark;					//UPS运行声音是否正常备注
	private String batCTr;						//电池连接端子是否牢固测试结果
	private String batCRemark;					//电池连接端子是否牢固备注
	private String upsPdcIowTr;					//UPS至配电柜的输入和输出导线是否完好测试结果
	private String upsPdcIowRemark;				//UPS至配电柜的输入和输出导线是否完好备注
	private String bpdbTr;						//电池组直流母线是否完好测试结果
	private String bpdbRemark;					//电池组直流母线是否完好备注
	private String pdcCTr;						//配电柜内连接端子是否牢固测试结果
	private String pdcCRemark;					//配电柜内连接端子是否牢固备注
	private String pdcMIlTr;					//配电柜仪表及指示灯是否正常测试结果
	private String pdcMIlRemark;				//配电柜仪表及指示灯是否正常备注
	private String bfnTr;						//各断路器是否无发热及杂声现象测试结果
	private String bfnRemark;					//各断路器是否无发热及杂声现象备注
	private String ltCwFTr;						//到负载端的连接导线是否无发热测试结果
	private String ltCwFRemark;					//到负载端的连接导线是否无发热备注
	private String ltLcTr;						//到负载端的各回路电流是否在安全运行范围之内测试
	private String ltLcRemark;					//到负载端的各回路电流是否在安全运行范围之内备注
	private String ltSTr;						//到负载端的各插座是否运行正常测试结果
	private String ltSRemark;					//到负载端的各插座是否运行正常备注
	private EnvironmentEquipCheck upsCheck;
	
	@Column(name="UPS_IC_TR")
	public String getUpsIcTr() {
		return upsIcTr;
	}
	public void setUpsIcTr(String upsIcTr) {
		this.upsIcTr = upsIcTr;
	}
	@Column(name="UPS_IC_REMARK")
	public String getUpsIcRemark() {
		return upsIcRemark;
	}
	public void setUpsIcRemark(String upsIcRemark) {
		this.upsIcRemark = upsIcRemark;
	}
	@Column(name="UPS_F_RUN_TR")
	public String getUpsFRunTr() {
		return upsFRunTr;
	}
	public void setUpsFRunTr(String upsFRunTr) {
		this.upsFRunTr = upsFRunTr;
	}
	@Column(name="UPS_F_RUN_REMARK")
	public String getUpsFRunRemark() {
		return upsFRunRemark;
	}
	public void setUpsFRunRemark(String upsFRunRemark) {
		this.upsFRunRemark = upsFRunRemark;
	}
	@Column(name="UPS_IB_FIRM_TR")
	public String getUpsIbFirmTr() {
		return upsIbFirmTr;
	}
	public void setUpsIbFirmTr(String upsIbFirmTr) {
		this.upsIbFirmTr = upsIbFirmTr;
	}
	@Column(name="UPS_TB_FIRM_REMARK")
	public String getUpsIbFirmRemark() {
		return upsIbFirmRemark;
	}
	public void setUpsIbFirmRemark(String upsIbFirmRemark) {
		this.upsIbFirmRemark = upsIbFirmRemark;
	}
	@Column(name="UPS_CW_OH_TR")
	public String getUpsCwOhTr() {
		return upsCwOhTr;
	}
	public void setUpsCwOhTr(String upsCwOhTr) {
		this.upsCwOhTr = upsCwOhTr;
	}
	@Column(name="UPS_CW_OH_REMARK")
	public String getUpsCwOhRemark() {
		return upsCwOhRemark;
	}
	public void setUpsCwOhRemark(String upsCwOhRemark) {
		this.upsCwOhRemark = upsCwOhRemark;
	}
	@Column(name="UPS_RV_TR")
	public String getUpsRvTr() {
		return upsRvTr;
	}
	public void setUpsRvTr(String upsRvTr) {
		this.upsRvTr = upsRvTr;
	}
	@Column(name="UPS_RV_REMARK")
	public String getUpsRvRemark() {
		return upsRvRemark;
	}
	public void setUpsRvRemark(String upsRvRemark) {
		this.upsRvRemark = upsRvRemark;
	}
	@Column(name="BAT_C_TR")
	public String getBatCTr() {
		return batCTr;
	}
	public void setBatCTr(String batCTr) {
		this.batCTr = batCTr;
	}
	@Column(name="BAT_C_REMARK")
	public String getBatCRemark() {
		return batCRemark;
	}
	public void setBatCRemark(String batCRemark) {
		this.batCRemark = batCRemark;
	}
	@Column(name="UPS_PDC_IOW_TR")
	public String getUpsPdcIowTr() {
		return upsPdcIowTr;
	}
	public void setUpsPdcIowTr(String upsPdcIowTr) {
		this.upsPdcIowTr = upsPdcIowTr;
	}
	@Column(name="UPS_PDC_IOW_REMARK")
	public String getUpsPdcIowRemark() {
		return upsPdcIowRemark;
	}
	public void setUpsPdcIowRemark(String upsPdcIowRemark) {
		this.upsPdcIowRemark = upsPdcIowRemark;
	}
	@Column(name="BPDB_TR")
	public String getBpdbTr() {
		return bpdbTr;
	}
	public void setBpdbTr(String bpdbTr) {
		this.bpdbTr = bpdbTr;
	}
	@Column(name="BPDB_REMARK")
	public String getBpdbRemark() {
		return bpdbRemark;
	}
	public void setBpdbRemark(String bpdbRemark) {
		this.bpdbRemark = bpdbRemark;
	}
	@Column(name="PDC_C_TR")
	public String getPdcCTr() {
		return pdcCTr;
	}
	public void setPdcCTr(String pdcCTr) {
		this.pdcCTr = pdcCTr;
	}
	@Column(name="PDC_C_REMARK")
	public String getPdcCRemark() {
		return pdcCRemark;
	}
	public void setPdcCRemark(String pdcCRemark) {
		this.pdcCRemark = pdcCRemark;
	}
	@Column(name="PDC_M_IL_TR")
	public String getPdcMIlTr() {
		return pdcMIlTr;
	}
	public void setPdcMIlTr(String pdcMIlTr) {
		this.pdcMIlTr = pdcMIlTr;
	}
	@Column(name="PDC_M_IL_REMARK")
	public String getPdcMIlRemark() {
		return pdcMIlRemark;
	}
	public void setPdcMIlRemark(String pdcMIlRemark) {
		this.pdcMIlRemark = pdcMIlRemark;
	}
	@Column(name="BFN_TR")
	public String getBfnTr() {
		return bfnTr;
	}
	public void setBfnTr(String bfnTr) {
		this.bfnTr = bfnTr;
	}
	@Column(name="BFN_REMARK")
	public String getBfnRemark() {
		return bfnRemark;
	}
	public void setBfnRemark(String bfnRemark) {
		this.bfnRemark = bfnRemark;
	}
	@Column(name="LT_CW_F_TR")
	public String getLtCwFTr() {
		return ltCwFTr;
	}
	public void setLtCwFTr(String ltCwFTr) {
		this.ltCwFTr = ltCwFTr;
	}
	@Column(name="LT_CW_F_REMARK")
	public String getLtCwFRemark() {
		return ltCwFRemark;
	}
	public void setLtCwFRemark(String ltCwFRemark) {
		this.ltCwFRemark = ltCwFRemark;
	}
	@Column(name="LT_LC_TR")
	public String getLtLcTr() {
		return ltLcTr;
	}
	public void setLtLcTr(String ltLcTr) {
		this.ltLcTr = ltLcTr;
	}
	@Column(name="LT_LC_REMARK")
	public String getLtLcRemark() {
		return ltLcRemark;
	}
	public void setLtLcRemark(String ltLcRemark) {
		this.ltLcRemark = ltLcRemark;
	}
	@Column(name="LT_S_TR")
	public String getLtSTr() {
		return ltSTr;
	}
	public void setLtSTr(String ltSTr) {
		this.ltSTr = ltSTr;
	}
	@Column(name="LT_S_REMARK")
	public String getLtSRemark() {
		return ltSRemark;
	}
	public void setLtSRemark(String ltSRemark) {
		this.ltSRemark = ltSRemark;
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
