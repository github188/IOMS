package cn.com.atnc.ioms.model.duty.environment.dg;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 柴油发电机设备巡检添加，更新model
 * @author renyujuan
 * @date 2016年8月9日上午10:45:28
 */
public class DgAddForm extends MyPaginModel {

	/*<-----------环境巡检表---------------->*/
	private String name;           		//环境设备名称
	private User operator;		   		//操作人
	private String problem;        		//存在问题
	private String suggestion;     		//建议
	private String result;        		//检查结果
	private String checkTime;    			//检查时间
	private String checkDate;				//检查日期
	private CheckCatagory checkType;	//检查类别
	private EquipType equipType;		//设备类型
	/*<-----------柴油发电机内容巡检表---------------->*/
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
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public CheckCatagory getCheckType() {
		return checkType;
	}
	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}
	public EquipType getEquipType() {
		return equipType;
	}
	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}
	public CheckResult getEnCheckResult() {
		return enCheckResult;
	}
	public void setEnCheckResult(CheckResult enCheckResult) {
		this.enCheckResult = enCheckResult;
	}
	public String getEnRemarks() {
		return enRemarks;
	}
	public void setEnRemarks(String enRemarks) {
		this.enRemarks = enRemarks;
	}
	public CheckResult getBhCheckResult() {
		return bhCheckResult;
	}
	public void setBhCheckResult(CheckResult bhCheckResult) {
		this.bhCheckResult = bhCheckResult;
	}
	public String getBhRemarks() {
		return bhRemarks;
	}
	public void setBhRemarks(String bhRemarks) {
		this.bhRemarks = bhRemarks;
	}
	public CheckResult getEcpiCheckResult() {
		return ecpiCheckResult;
	}
	public void setEcpiCheckResult(CheckResult ecpiCheckResult) {
		this.ecpiCheckResult = ecpiCheckResult;
	}
	public String getEcpiRemarks() {
		return ecpiRemarks;
	}
	public void setEcpiRemarks(String ecpiRemarks) {
		this.ecpiRemarks = ecpiRemarks;
	}
	public CheckResult getRmhCheckResult() {
		return rmhCheckResult;
	}
	public void setRmhCheckResult(CheckResult rmhCheckResult) {
		this.rmhCheckResult = rmhCheckResult;
	}
	public String getRmhRemarks() {
		return rmhRemarks;
	}
	public void setRmhRemarks(String rmhRemarks) {
		this.rmhRemarks = rmhRemarks;
	}
	public CheckResult getErcCheckResult() {
		return ercCheckResult;
	}
	public void setErcCheckResult(CheckResult ercCheckResult) {
		this.ercCheckResult = ercCheckResult;
	}
	public String getErcRemarks() {
		return ercRemarks;
	}
	public void setErcRemarks(String ercRemarks) {
		this.ercRemarks = ercRemarks;
	}
	public CheckResult getAtsNumoneCheckResult() {
		return atsNumoneCheckResult;
	}
	public void setAtsNumoneCheckResult(CheckResult atsNumoneCheckResult) {
		this.atsNumoneCheckResult = atsNumoneCheckResult;
	}
	public String getAtsNumoneRemarks() {
		return atsNumoneRemarks;
	}
	public void setAtsNumoneRemarks(String atsNumoneRemarks) {
		this.atsNumoneRemarks = atsNumoneRemarks;
	}
	public CheckResult getAtsNumtwoCheckResult() {
		return atsNumtwoCheckResult;
	}
	public void setAtsNumtwoCheckResult(CheckResult atsNumtwoCheckResult) {
		this.atsNumtwoCheckResult = atsNumtwoCheckResult;
	}
	public String getAtsNumtwoRemarks() {
		return atsNumtwoRemarks;
	}
	public void setAtsNumtwoRemarks(String atsNumtwoRemarks) {
		this.atsNumtwoRemarks = atsNumtwoRemarks;
	}
	public CheckResult getUshCheckResult() {
		return ushCheckResult;
	}
	public void setUshCheckResult(CheckResult ushCheckResult) {
		this.ushCheckResult = ushCheckResult;
	}
	public String getUshRemarks() {
		return ushRemarks;
	}
	public void setUshRemarks(String ushRemarks) {
		this.ushRemarks = ushRemarks;
	}
	public CheckResult getCableTestResult() {
		return cableTestResult;
	}
	public void setCableTestResult(CheckResult cableTestResult) {
		this.cableTestResult = cableTestResult;
	}
	public String getCableTestRemarks() {
		return cableTestRemarks;
	}
	public void setCableTestRemarks(String cableTestRemarks) {
		this.cableTestRemarks = cableTestRemarks;
	}
	public CheckResult getLpCheckResult() {
		return lpCheckResult;
	}
	public void setLpCheckResult(CheckResult lpCheckResult) {
		this.lpCheckResult = lpCheckResult;
	}
	public String getLpRemarks() {
		return lpRemarks;
	}
	public void setLpRemarks(String lpRemarks) {
		this.lpRemarks = lpRemarks;
	}
	public CheckResult getFpCheckResult() {
		return fpCheckResult;
	}
	public void setFpCheckResult(CheckResult fpCheckResult) {
		this.fpCheckResult = fpCheckResult;
	}
	public String getFpRemarks() {
		return fpRemarks;
	}
	public void setFpRemarks(String fpRemarks) {
		this.fpRemarks = fpRemarks;
	}
	public CheckResult getOsCheckResult() {
		return osCheckResult;
	}
	public void setOsCheckResult(CheckResult osCheckResult) {
		this.osCheckResult = osCheckResult;
	}
	public String getOsRemarks() {
		return osRemarks;
	}
	public void setOsRemarks(String osRemarks) {
		this.osRemarks = osRemarks;
	}
	public CheckResult getCsCheckResult() {
		return csCheckResult;
	}
	public void setCsCheckResult(CheckResult csCheckResult) {
		this.csCheckResult = csCheckResult;
	}
	public String getCsRemarks() {
		return csRemarks;
	}
	public void setCsRemarks(String csRemarks) {
		this.csRemarks = csRemarks;
	}
	public CheckResult getFsCheckResult() {
		return fsCheckResult;
	}
	public void setFsCheckResult(CheckResult fsCheckResult) {
		this.fsCheckResult = fsCheckResult;
	}
	public String getFsRemarks() {
		return fsRemarks;
	}
	public void setFsRemarks(String fsRemarks) {
		this.fsRemarks = fsRemarks;
	}
	public CheckResult getBlCheckResult() {
		return blCheckResult;
	}
	public void setBlCheckResult(CheckResult blCheckResult) {
		this.blCheckResult = blCheckResult;
	}
	public String getBlRemarks() {
		return blRemarks;
	}
	public void setBlRemarks(String blRemarks) {
		this.blRemarks = blRemarks;
	}
	public CheckResult getEbCheckResult() {
		return ebCheckResult;
	}
	public void setEbCheckResult(CheckResult ebCheckResult) {
		this.ebCheckResult = ebCheckResult;
	}
	public String getEbRemarks() {
		return ebRemarks;
	}
	public void setEbRemarks(String ebRemarks) {
		this.ebRemarks = ebRemarks;
	}
	public CheckResult getAsCheckResult() {
		return asCheckResult;
	}
	public void setAsCheckResult(CheckResult asCheckResult) {
		this.asCheckResult = asCheckResult;
	}
	public String getAsRemarks() {
		return asRemarks;
	}
	public void setAsRemarks(String asRemarks) {
		this.asRemarks = asRemarks;
	}
	public CheckResult getRsCheckResult() {
		return rsCheckResult;
	}
	public void setRsCheckResult(CheckResult rsCheckResult) {
		this.rsCheckResult = rsCheckResult;
	}
	public String getRsRemarks() {
		return rsRemarks;
	}
	public void setRsRemarks(String rsRemarks) {
		this.rsRemarks = rsRemarks;
	}
	public CheckResult getAutosCheckResult() {
		return autosCheckResult;
	}
	public void setAutosCheckResult(CheckResult autosCheckResult) {
		this.autosCheckResult = autosCheckResult;
	}
	public String getAutosRemarks() {
		return autosRemarks;
	}
	public void setAutosRemarks(String autosRemarks) {
		this.autosRemarks = autosRemarks;
	}
	public String getSbvCheckResult() {
		return sbvCheckResult;
	}
	public void setSbvCheckResult(String sbvCheckResult) {
		this.sbvCheckResult = sbvCheckResult;
	}
	public String getSbvRemarks() {
		return sbvRemarks;
	}
	public void setSbvRemarks(String sbvRemarks) {
		this.sbvRemarks = sbvRemarks;
	}
	public String getDopCheckResult() {
		return dopCheckResult;
	}
	public void setDopCheckResult(String dopCheckResult) {
		this.dopCheckResult = dopCheckResult;
	}
	public String getDopRemarks() {
		return dopRemarks;
	}
	public void setDopRemarks(String dopRemarks) {
		this.dopRemarks = dopRemarks;
	}
	public String getOpCheckResult() {
		return opCheckResult;
	}
	public void setOpCheckResult(String opCheckResult) {
		this.opCheckResult = opCheckResult;
	}
	public String getOpRemarks() {
		return opRemarks;
	}
	public void setOpRemarks(String opRemarks) {
		this.opRemarks = opRemarks;
	}
	public String getPfCheckResult() {
		return pfCheckResult;
	}
	public void setPfCheckResult(String pfCheckResult) {
		this.pfCheckResult = pfCheckResult;
	}
	public String getPfRemarks() {
		return pfRemarks;
	}
	public void setPfRemarks(String pfRemarks) {
		this.pfRemarks = pfRemarks;
	}
	public String getEpCheckResult() {
		return epCheckResult;
	}
	public void setEpCheckResult(String epCheckResult) {
		this.epCheckResult = epCheckResult;
	}
	public String getEpRemarks() {
		return epRemarks;
	}
	public void setEpRemarks(String epRemarks) {
		this.epRemarks = epRemarks;
	}
	public String getEwtCheckResult() {
		return ewtCheckResult;
	}
	public void setEwtCheckResult(String ewtCheckResult) {
		this.ewtCheckResult = ewtCheckResult;
	}
	public String getEwtRemarks() {
		return ewtRemarks;
	}
	public void setEwtRemarks(String ewtRemarks) {
		this.ewtRemarks = ewtRemarks;
	}
	public String getPvANCheckResult() {
		return pvANCheckResult;
	}
	public void setPvANCheckResult(String pvANCheckResult) {
		this.pvANCheckResult = pvANCheckResult;
	}
	public String getPvANRemarks() {
		return pvANRemarks;
	}
	public void setPvANRemarks(String pvANRemarks) {
		this.pvANRemarks = pvANRemarks;
	}
	public String getPvBNCheckResult() {
		return pvBNCheckResult;
	}
	public void setPvBNCheckResult(String pvBNCheckResult) {
		this.pvBNCheckResult = pvBNCheckResult;
	}
	public String getPvBNRemarks() {
		return pvBNRemarks;
	}
	public void setPvBNRemarks(String pvBNRemarks) {
		this.pvBNRemarks = pvBNRemarks;
	}
	public String getPvCNCheckResult() {
		return pvCNCheckResult;
	}
	public void setPvCNCheckResult(String pvCNCheckResult) {
		this.pvCNCheckResult = pvCNCheckResult;
	}
	public String getPvCNRemarks() {
		return pvCNRemarks;
	}
	public void setPvCNRemarks(String pvCNRemarks) {
		this.pvCNRemarks = pvCNRemarks;
	}
	public String getLvABCheckResult() {
		return lvABCheckResult;
	}
	public void setLvABCheckResult(String lvABCheckResult) {
		this.lvABCheckResult = lvABCheckResult;
	}
	public String getLvABRemarks() {
		return lvABRemarks;
	}
	public void setLvABRemarks(String lvABRemarks) {
		this.lvABRemarks = lvABRemarks;
	}
	public String getLvACCheckResult() {
		return lvACCheckResult;
	}
	public void setLvACCheckResult(String lvACCheckResult) {
		this.lvACCheckResult = lvACCheckResult;
	}
	public String getLvACRemarks() {
		return lvACRemarks;
	}
	public void setLvACRemarks(String lvACRemarks) {
		this.lvACRemarks = lvACRemarks;
	}
	public String getLvBCCheckResult() {
		return lvBCCheckResult;
	}
	public void setLvBCCheckResult(String lvBCCheckResult) {
		this.lvBCCheckResult = lvBCCheckResult;
	}
	public String getLvBCRemarks() {
		return lvBCRemarks;
	}
	public void setLvBCRemarks(String lvBCRemarks) {
		this.lvBCRemarks = lvBCRemarks;
	}
	public String getCaCheckResult() {
		return caCheckResult;
	}
	public void setCaCheckResult(String caCheckResult) {
		this.caCheckResult = caCheckResult;
	}
	public String getCaRemarks() {
		return caRemarks;
	}
	public void setCaRemarks(String caRemarks) {
		this.caRemarks = caRemarks;
	}
	public String getCbCheckResult() {
		return cbCheckResult;
	}
	public void setCbCheckResult(String cbCheckResult) {
		this.cbCheckResult = cbCheckResult;
	}
	public String getCbRemarks() {
		return cbRemarks;
	}
	public void setCbRemarks(String cbRemarks) {
		this.cbRemarks = cbRemarks;
	}
	public String getCcCheckResult() {
		return ccCheckResult;
	}
	public void setCcCheckResult(String ccCheckResult) {
		this.ccCheckResult = ccCheckResult;
	}
	public String getCcRemarks() {
		return ccRemarks;
	}
	public void setCcRemarks(String ccRemarks) {
		this.ccRemarks = ccRemarks;
	}
	public String getPaCheckResult() {
		return paCheckResult;
	}
	public void setPaCheckResult(String paCheckResult) {
		this.paCheckResult = paCheckResult;
	}
	public String getPaRemarks() {
		return paRemarks;
	}
	public void setPaRemarks(String paRemarks) {
		this.paRemarks = paRemarks;
	}
	public String getPbCheckResult() {
		return pbCheckResult;
	}
	public void setPbCheckResult(String pbCheckResult) {
		this.pbCheckResult = pbCheckResult;
	}
	public String getPbRemarks() {
		return pbRemarks;
	}
	public void setPbRemarks(String pbRemarks) {
		this.pbRemarks = pbRemarks;
	}
	public String getPcCheckResult() {
		return pcCheckResult;
	}
	public void setPcCheckResult(String pcCheckResult) {
		this.pcCheckResult = pcCheckResult;
	}
	public String getPcRemarks() {
		return pcRemarks;
	}
	public void setPcRemarks(String pcRemarks) {
		this.pcRemarks = pcRemarks;
	}
	
	
	
}
