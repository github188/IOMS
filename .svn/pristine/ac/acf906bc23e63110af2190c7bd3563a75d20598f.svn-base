package cn.com.atnc.ioms.entity.duty.environment.dg;

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
 * 柴油发电机巡检内容实体类
 * @author renyujuan
 * @date 2016年8月8日下午3:32:42
 */
@Entity
@Table(name="TB_OM_DUTY_DG_CHECK_CONTENT")
public class DgCheckContent extends MyStringUUIDEntity {
	private static final long serialVersionUID = 1L;
	
	private CheckResult enCheckResult;				//环境检查结果
	private String enRemarks;							//环境备注
	private CheckResult bhCheckResult;				//机体加热检查结果
	private String bhRemarks;							//机体加热备注
	private CheckResult ecpiCheckResult;				//发动机控制板指示灯检查结果
	private String ecpiRemarks;						//发动机控制板指示灯备注
	private CheckResult rmhCheckResult;				//机房温湿度检查结果
	private String rmhRemarks;							//机房温湿度备注
	private CheckResult ercCheckResult;				//发动机运转检查结果
	private String ercRemarks;							//发动机运转检查备注
	/*1号ATS检查结果与备注*/
	private CheckResult atsNumoneCheckResult;
	private String atsNumoneRemarks;
	/*2号ATS检查结果与备注*/
	private CheckResult atsNumtwoCheckResult;
	private String atsNumtwoRemarks;
	/*各单位切换护头*/
	private CheckResult ushCheckResult;
	private String ushRemarks;
	/*电缆检测*/
	private CheckResult cableTestResult;
	private String cableTestRemarks;
	/*润滑压力*/
	private CheckResult lpCheckResult;
	private String lpRemarks;
	/*燃油压力*/
	private CheckResult fpCheckResult;
	private String fpRemarks;
	/*机油系统*/
	private CheckResult osCheckResult;
	private String osRemarks;
	/*冷却系统*/
	private CheckResult csCheckResult;
	private String csRemarks;
	/*燃料系统*/
	private CheckResult fsCheckResult;
	private String fsRemarks;
	/*蓄电池液*/
	private CheckResult blCheckResult;
	private String blRemarks;
	/*各个皮带*/
	private CheckResult ebCheckResult;
	private String ebRemarks;
	/*空气系统*/
	private CheckResult asCheckResult;
	private String asRemarks;
	/*散热器百叶窗*/
	private CheckResult rsCheckResult;
	private String rsRemarks;
	/*自动开关*/ 
	private CheckResult autosCheckResult;
	private String autosRemarks;
	/*启动电池电压*/
	private String sbvCheckResult;
	private String sbvRemarks;
	/*柴油压力*/
	private String dopCheckResult;
	private String dopRemarks;
	/*机油压力*/
	private String opCheckResult;
	private String opRemarks;
	/*功率因素*/
	private String pfCheckResult;
	private String pfRemarks;
	/*	发动机转速*/
	private String epCheckResult;
	private String epRemarks;
	/*发动机水温*/
	private String ewtCheckResult;
	private String ewtRemarks;
	/*相电压A-N B-N C-N*/
	private String pvANCheckResult;
	private String pvANRemarks;
	private String pvBNCheckResult;
	private String pvBNRemarks;
	private String pvCNCheckResult;
	private String pvCNRemarks;
	/*线电压A-B A-C B-C*/
	private String lvABCheckResult;
	private String lvABRemarks;
	private String lvACCheckResult;
	private String lvACRemarks;
	private String lvBCCheckResult;
	private String lvBCRemarks;
	/*电流A相，B相，C相*/
	private String caCheckResult;
	private String caRemarks;
	private String cbCheckResult;
	private String cbRemarks;
	private String ccCheckResult;
	private String ccRemarks;
	/*功率A相，B相，C相*/
	private String paCheckResult;
	private String paRemarks;
	private String pbCheckResult;
	private String pbRemarks;
	private String pcCheckResult;
	private String pcRemarks;
	
	private EnvironmentEquipCheck dgCheck;
	
	@Enumerated(EnumType.STRING)
	@Column(name="EN_CHECK_RESULT")
	public CheckResult getEnCheckResult() {
		return enCheckResult;
	}
	public void setEnCheckResult(CheckResult enCheckResult) {
		this.enCheckResult = enCheckResult;
	}
	@Column(name="EN_REMARKS")
	public String getEnRemarks() {
		return enRemarks;
	}
	public void setEnRemarks(String enRemarks) {
		this.enRemarks = enRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="BH_CHECK_RESULT")
	public CheckResult getBhCheckResult() {
		return bhCheckResult;
	}
	public void setBhCheckResult(CheckResult bhCheckResult) {
		this.bhCheckResult = bhCheckResult;
	}
	@Column(name="BH_REMARKS")
	public String getBhRemarks() {
		return bhRemarks;
	}
	public void setBhRemarks(String bhRemarks) {
		this.bhRemarks = bhRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ECPI_CHECK_RESULT")
	public CheckResult getEcpiCheckResult() {
		return ecpiCheckResult;
	}
	public void setEcpiCheckResult(CheckResult ecpiCheckResult) {
		this.ecpiCheckResult = ecpiCheckResult;
	}
	@Column(name="ECPI_REMARKS")
	public String getEcpiRemarks() {
		return ecpiRemarks;
	}
	public void setEcpiRemarks(String ecpiRemarks) {
		this.ecpiRemarks = ecpiRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="RMH_CHECK_RESULT")
	public CheckResult getRmhCheckResult() {
		return rmhCheckResult;
	}
	public void setRmhCheckResult(CheckResult rmhCheckResult) {
		this.rmhCheckResult = rmhCheckResult;
	}
	@Column(name="RMH_REMARKS")
	public String getRmhRemarks() {
		return rmhRemarks;
	}
	public void setRmhRemarks(String rmhRemarks) {
		this.rmhRemarks = rmhRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ERC_CHECK_RESULT")
	public CheckResult getErcCheckResult() {
		return ercCheckResult;
	}
	public void setErcCheckResult(CheckResult ercCheckResult) {
		this.ercCheckResult = ercCheckResult;
	}
	@Column(name="ERC_REMARKS")
	public String getErcRemarks() {
		return ercRemarks;
	}
	public void setErcRemarks(String ercRemarks) {
		this.ercRemarks = ercRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ATS_NUMONE_CHECK_RESULT")
	public CheckResult getAtsNumoneCheckResult() {
		return atsNumoneCheckResult;
	}
	public void setAtsNumoneCheckResult(CheckResult atsNumoneCheckResult) {
		this.atsNumoneCheckResult = atsNumoneCheckResult;
	}
	@Column(name="ATS_NUMONE_REMARKS")
	public String getAtsNumoneRemarks() {
		return atsNumoneRemarks;
	}
	public void setAtsNumoneRemarks(String atsNumoneRemarks) {
		this.atsNumoneRemarks = atsNumoneRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="ATS_NUMTWO_CHECK_RESULT")
	public CheckResult getAtsNumtwoCheckResult() {
		return atsNumtwoCheckResult;
	}
	public void setAtsNumtwoCheckResult(CheckResult atsNumtwoCheckResult) {
		this.atsNumtwoCheckResult = atsNumtwoCheckResult;
	}
	@Column(name="ATS_NUMTWO_REMARKS")
	public String getAtsNumtwoRemarks() {
		return atsNumtwoRemarks;
	}
	public void setAtsNumtwoRemarks(String atsNumtwoRemarks) {
		this.atsNumtwoRemarks = atsNumtwoRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="USH_CHECK_RESULT")
	public CheckResult getUshCheckResult() {
		return ushCheckResult;
	}
	public void setUshCheckResult(CheckResult ushCheckResult) {
		this.ushCheckResult = ushCheckResult;
	}
	@Column(name="USH_REMARKS")
	public String getUshRemarks() {
		return ushRemarks;
	}
	public void setUshRemarks(String ushRemarks) {
		this.ushRemarks = ushRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="CABLE_TEST_RESULT")
	public CheckResult getCableTestResult() {
		return cableTestResult;
	}
	public void setCableTestResult(CheckResult cableTestResult) {
		this.cableTestResult = cableTestResult;
	}
	@Column(name="CABLE_TEST_REMARKS")
	public String getCableTestRemarks() {
		return cableTestRemarks;
	}
	public void setCableTestRemarks(String cableTestRemarks) {
		this.cableTestRemarks = cableTestRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="LP_CHECK_RESULT")
	public CheckResult getLpCheckResult() {
		return lpCheckResult;
	}
	public void setLpCheckResult(CheckResult lpCheckResult) {
		this.lpCheckResult = lpCheckResult;
	}
	@Column(name="LP_REMARKS")
	public String getLpRemarks() {
		return lpRemarks;
	}
	public void setLpRemarks(String lpRemarks) {
		this.lpRemarks = lpRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FP_CHECK_RESULT")
	public CheckResult getFpCheckResult() {
		return fpCheckResult;
	}
	public void setFpCheckResult(CheckResult fpCheckResult) {
		this.fpCheckResult = fpCheckResult;
	}
	@Column(name="FP_REMARKS")
	public String getFpRemarks() {
		return fpRemarks;
	}
	public void setFpRemarks(String fpRemarks) {
		this.fpRemarks = fpRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="OS_CHECK_RESULT")
	public CheckResult getOsCheckResult() {
		return osCheckResult;
	}
	public void setOsCheckResult(CheckResult osCheckResult) {
		this.osCheckResult = osCheckResult;
	}
	@Column(name="OS_REMARKS")
	public String getOsRemarks() {
		return osRemarks;
	}
	public void setOsRemarks(String osRemarks) {
		this.osRemarks = osRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="CS_CHECK_RESULT")
	public CheckResult getCsCheckResult() {
		return csCheckResult;
	}
	public void setCsCheckResult(CheckResult csCheckResult) {
		this.csCheckResult = csCheckResult;
	}
	@Column(name="CS_REMARKS")
	public String getCsRemarks() {
		return csRemarks;
	}
	public void setCsRemarks(String csRemarks) {
		this.csRemarks = csRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FS_CHECK_RESULT")
	public CheckResult getFsCheckResult() {
		return fsCheckResult;
	}
	public void setFsCheckResult(CheckResult fsCheckResult) {
		this.fsCheckResult = fsCheckResult;
	}
	@Column(name="FS_REMARKS")
	public String getFsRemarks() {
		return fsRemarks;
	}
	public void setFsRemarks(String fsRemarks) {
		this.fsRemarks = fsRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="BL_CHECK_RESULT")
	public CheckResult getBlCheckResult() {
		return blCheckResult;
	}
	public void setBlCheckResult(CheckResult blCheckResult) {
		this.blCheckResult = blCheckResult;
	}
	@Column(name="BL_REMARKS")
	public String getBlRemarks() {
		return blRemarks;
	}
	public void setBlRemarks(String blRemarks) {
		this.blRemarks = blRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="EB_CHECK_RESULT")
	public CheckResult getEbCheckResult() {
		return ebCheckResult;
	}
	public void setEbCheckResult(CheckResult ebCheckResult) {
		this.ebCheckResult = ebCheckResult;
	}
	@Column(name="EB_REMARKS")
	public String getEbRemarks() {
		return ebRemarks;
	}
	public void setEbRemarks(String ebRemarks) {
		this.ebRemarks = ebRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="AS_CHECK_RESULT")
	public CheckResult getAsCheckResult() {
		return asCheckResult;
	}
	public void setAsCheckResult(CheckResult asCheckResult) {
		this.asCheckResult = asCheckResult;
	}
	@Column(name="AS_REMARKS")
	public String getAsRemarks() {
		return asRemarks;
	}
	public void setAsRemarks(String asRemarks) {
		this.asRemarks = asRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="RS_CHECK_RESULT")
	public CheckResult getRsCheckResult() {
		return rsCheckResult;
	}
	public void setRsCheckResult(CheckResult rsCheckResult) {
		this.rsCheckResult = rsCheckResult;
	}
	@Column(name="RS_REMARKS")
	public String getRsRemarks() {
		return rsRemarks;
	}
	public void setRsRemarks(String rsRemarks) {
		this.rsRemarks = rsRemarks;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="AUTOS_CHECK_RESULT")
	public CheckResult getAutosCheckResult() {
		return autosCheckResult;
	}
	public void setAutosCheckResult(CheckResult autosCheckResult) {
		this.autosCheckResult = autosCheckResult;
	}
	@Column(name="AUTOS_REMARKS")
	public String getAutosRemarks() {
		return autosRemarks;
	}
	public void setAutosRemarks(String autosRemarks) {
		this.autosRemarks = autosRemarks;
	}
	@Column(name="SBV_CHECK_RESULT")
	public String getSbvCheckResult() {
		return sbvCheckResult;
	}
	public void setSbvCheckResult(String sbvCheckResult) {
		this.sbvCheckResult = sbvCheckResult;
	}
	@Column(name="SBV_REMARKS")
	public String getSbvRemarks() {
		return sbvRemarks;
	}
	public void setSbvRemarks(String sbvRemarks) {
		this.sbvRemarks = sbvRemarks;
	}
	@Column(name="DOP_CHECK_RESULT")
	public String getDopCheckResult() {
		return dopCheckResult;
	}
	public void setDopCheckResult(String dopCheckResult) {
		this.dopCheckResult = dopCheckResult;
	}
	@Column(name="DOP_REMARKS")
	public String getDopRemarks() {
		return dopRemarks;
	}
	public void setDopRemarks(String dopRemarks) {
		this.dopRemarks = dopRemarks;
	}
	@Column(name="OP_CHECK_RESULT")
	public String getOpCheckResult() {
		return opCheckResult;
	}
	public void setOpCheckResult(String opCheckResult) {
		this.opCheckResult = opCheckResult;
	}
	@Column(name="OP_REMARKS")
	public String getOpRemarks() {
		return opRemarks;
	}
	public void setOpRemarks(String opRemarks) {
		this.opRemarks = opRemarks;
	}
	@Column(name="PF_CHECK_RESULT")
	public String getPfCheckResult() {
		return pfCheckResult;
	}
	public void setPfCheckResult(String pfCheckResult) {
		this.pfCheckResult = pfCheckResult;
	}
	@Column(name="PF_REMARKS")
	public String getPfRemarks() {
		return pfRemarks;
	}
	public void setPfRemarks(String pfRemarks) {
		this.pfRemarks = pfRemarks;
	}
	@Column(name="EP_CHECK_RESULT")
	public String getEpCheckResult() {
		return epCheckResult;
	}
	public void setEpCheckResult(String epCheckResult) {
		this.epCheckResult = epCheckResult;
	}
	@Column(name="EP_REMARKS")
	public String getEpRemarks() {
		return epRemarks;
	}
	public void setEpRemarks(String epRemarks) {
		this.epRemarks = epRemarks;
	}
	@Column(name="EWT_CHECK_RESULT")
	public String getEwtCheckResult() {
		return ewtCheckResult;
	}
	public void setEwtCheckResult(String ewtCheckResult) {
		this.ewtCheckResult = ewtCheckResult;
	}
	@Column(name="EWT_REMARKS")
	public String getEwtRemarks() {
		return ewtRemarks;
	}
	public void setEwtRemarks(String ewtRemarks) {
		this.ewtRemarks = ewtRemarks;
	}
	@Column(name="PVA_N_CHECK_RESULT")
	public String getPvANCheckResult() {
		return pvANCheckResult;
	}
	public void setPvANCheckResult(String pvANCheckResult) {
		this.pvANCheckResult = pvANCheckResult;
	}
	@Column(name="PVA_N_REMARKS")
	public String getPvANRemarks() {
		return pvANRemarks;
	}
	public void setPvANRemarks(String pvANRemarks) {
		this.pvANRemarks = pvANRemarks;
	}
	@Column(name="PVB_N_CHECK_RESULT")
	public String getPvBNCheckResult() {
		return pvBNCheckResult;
	}
	public void setPvBNCheckResult(String pvBNCheckResult) {
		this.pvBNCheckResult = pvBNCheckResult;
	}
	@Column(name="PVB_N_REMARKS")
	public String getPvBNRemarks() {
		return pvBNRemarks;
	}
	public void setPvBNRemarks(String pvBNRemarks) {
		this.pvBNRemarks = pvBNRemarks;
	}
	@Column(name="PVC_N_CHECK_RESULT")
	public String getPvCNCheckResult() {
		return pvCNCheckResult;
	}
	public void setPvCNCheckResult(String pvCNCheckResult) {
		this.pvCNCheckResult = pvCNCheckResult;
	}
	@Column(name="PVC_N_REMARKS")
	public String getPvCNRemarks() {
		return pvCNRemarks;
	}
	public void setPvCNRemarks(String pvCNRemarks) {
		this.pvCNRemarks = pvCNRemarks;
	}
	@Column(name="LVA_B_CHECK_RESULT")
	public String getLvABCheckResult() {
		return lvABCheckResult;
	}
	public void setLvABCheckResult(String lvABCheckResult) {
		this.lvABCheckResult = lvABCheckResult;
	}
	@Column(name="LVA_B_REMARKS")
	public String getLvABRemarks() {
		return lvABRemarks;
	}
	public void setLvABRemarks(String lvABRemarks) {
		this.lvABRemarks = lvABRemarks;
	}
	@Column(name="LVA_C_CHECK_RESULT")
	public String getLvACCheckResult() {
		return lvACCheckResult;
	}
	public void setLvACCheckResult(String lvACCheckResult) {
		this.lvACCheckResult = lvACCheckResult;
	}
	@Column(name="LVA_C_REMARKS")
	public String getLvACRemarks() {
		return lvACRemarks;
	}
	public void setLvACRemarks(String lvACRemarks) {
		this.lvACRemarks = lvACRemarks;
	}
	@Column(name="LVB_C_CHECK_RESULT")
	public String getLvBCCheckResult() {
		return lvBCCheckResult;
	}
	public void setLvBCCheckResult(String lvBCCheckResult) {
		this.lvBCCheckResult = lvBCCheckResult;
	}
	@Column(name="LVB_C_REMARKS")
	public String getLvBCRemarks() {
		return lvBCRemarks;
	}
	public void setLvBCRemarks(String lvBCRemarks) {
		this.lvBCRemarks = lvBCRemarks;
	}	
	@Column(name="CA_CHECK_RESULT")
	public String getCaCheckResult() {
		return caCheckResult;
	}
	public void setCaCheckResult(String caCheckResult) {
		this.caCheckResult = caCheckResult;
	}
	@Column(name="CA_REMARKS")
	public String getCaRemarks() {
		return caRemarks;
	}
	public void setCaRemarks(String caRemarks) {
		this.caRemarks = caRemarks;
	}
	@Column(name="CB_CHECK_RESULT")
	public String getCbCheckResult() {
		return cbCheckResult;
	}
	public void setCbCheckResult(String cbCheckResult) {
		this.cbCheckResult = cbCheckResult;
	}
	@Column(name="CB_REMARKS")
	public String getCbRemarks() {
		return cbRemarks;
	}
	public void setCbRemarks(String cbRemarks) {
		this.cbRemarks = cbRemarks;
	}
	@Column(name="CC_CHECK_RESULT")
	public String getCcCheckResult() {
		return ccCheckResult;
	}
	public void setCcCheckResult(String ccCheckResult) {
		this.ccCheckResult = ccCheckResult;
	}
	@Column(name="CC_REMARKS")
	public String getCcRemarks() {
		return ccRemarks;
	}
	public void setCcRemarks(String ccRemarks) {
		this.ccRemarks = ccRemarks;
	}
	@Column(name="PA_CHECK_RESULT")
	public String getPaCheckResult() {
		return paCheckResult;
	}
	public void setPaCheckResult(String paCheckResult) {
		this.paCheckResult = paCheckResult;
	}
	@Column(name="PA_REMARKS")
	public String getPaRemarks() {
		return paRemarks;
	}
	public void setPaRemarks(String paRemarks) {
		this.paRemarks = paRemarks;
	}
	@Column(name="PB_CHECK_RESULT")
	public String getPbCheckResult() {
		return pbCheckResult;
	}
	public void setPbCheckResult(String pbCheckResult) {
		this.pbCheckResult = pbCheckResult;
	}
	@Column(name="PB_REMARKS")
	public String getPbRemarks() {
		return pbRemarks;
	}
	public void setPbRemarks(String pbRemarks) {
		this.pbRemarks = pbRemarks;
	}
	@Column(name="PC_CHECK_RESULT")
	public String getPcCheckResult() {
		return pcCheckResult;
	}
	public void setPcCheckResult(String pcCheckResult) {
		this.pcCheckResult = pcCheckResult;
	}
	@Column(name="PC_REMARKS")
	public String getPcRemarks() {
		return pcRemarks;
	}
	public void setPcRemarks(String pcRemarks) {
		this.pcRemarks = pcRemarks;
	}
	@ManyToOne
	@JoinColumn(name="DG_CHECK_ID")
	public EnvironmentEquipCheck getDgCheck() {
		return dgCheck;
	}
	public void setDgCheck(EnvironmentEquipCheck dgCheck) {
		this.dgCheck = dgCheck;
	}

}
