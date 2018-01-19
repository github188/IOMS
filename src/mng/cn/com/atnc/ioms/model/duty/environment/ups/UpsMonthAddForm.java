package cn.com.atnc.ioms.model.duty.environment.ups;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.ContentCheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
/**
 * ups巡检添加form
 * @author renyujuan
 * @date 2016年7月15日下午12:28:19
 */
public class UpsMonthAddForm {
	
	//upscheck
	private String name;           //ups设备名称
	private User operator;		   //操作人
	private String problem;        //存在问题
	private String suggestion;     //建议
	private String result;         //检查结果
	private String checkTime;    //检查时间
	private String checkDate;		   //检查日期	 
	private CheckCatagory checkType;
	private EquipType equipType;
	
	//系统测量
	//-----相电压A-N------//
	private String pvANDisOutValue;				//相电压A-N界面显示值输出
	private String pvANMeaInValue;				//相电压A-N实际测量值输入 
	private String pvANMeaOutValue;				//相电压A-N实际测量值输出
	private String pvANRemark;					//相电压A-N备注 
	//-----相电压B-N------//
	private String pvBNDisOutValue;				//相电压B-N界面显示值输出
	private String pvBNMeaInValue;				//相电压B-N实际测量值输入 
	private String pvBNMeaOutValue;				//相电压B-N实际测量值输出
	private String pvBNRemark;					//相电压B-N备注 
	//-----相电压C-N------//
	private String pvCNDisOutValue;				//相电压C-N界面显示值输出
	private String pvCNMeaInValue;				//相电压C-N实际测量值输入 
	private String pvCNMeaOutValue;				//相电压C-N实际测量值输出
	private String pvCNRemark;					//相电压C-N备注 
	//-----线电压A-B------//
	private String lvABDisOutValue;				//线电压A-B界面显示值输出
	private String lvABMeaInValue;				//线电压A-B实际测量值输入
	private String lvABMeaOutValue;				//线电压A-B实际测量值输出
	private String lvABRemark;					//线电压A-B备注
	//-----线电压A-C------//
	private String lvACDisOutValue;				//线电压A-C界面显示值输出
	private String lvACMeaInValue;				//线电压A-C实际测量值输入
	private String lvACMeaOutValue;				//线电压A-C实际测量值输出
	private String lvACRemark;					//线电压A-C备注
	//-----线电压B-C------//
	private String lvBCDisOutValue;				//线电压B-C界面显示值输出
	private String lvBCMeaInValue;				//线电压b-C实际测量值输入
	private String lvBCMeaOutValue;				//线电压b-C实际测量值输出
	private String lvBCRemark;					//线电压b-C备注
	//-----A相电流------//
	private String pcADisOutValue;				//A相电流界面显示值输出
	private String pcAMeaInValue;				//A相电流实际测量值输入
	private String pcAMeaOutValue;				//A相电流实际测量值输出
	private String pcARemark;					//A相电流备注
	//-----B相电流------//
	private String pcBDisOutValue;				//B相电流界面显示值输出
	private String pcBMeaInValue;				//B相电流实际测量值输入
	private String pcBMeaOutValue;				//B相电流实际测量值输出
	private String pcBRemark;					//B相电流备注
	//-----C相电流------//
	private String pcCDisOutValue;				//C相电流界面显示值输出
	private String pcCMeaInValue;				//C相电流实际测量值输入
	private String pcCMeaOutValue;				//C相电流实际测量值输出
	private String pcCRemark;					//C相电流备注
	//-----A相功率------//
	private String ppADisOutValue;				//A相功率界面显示值输出
	private String ppAMeaCalValue;				//A相功率计算值
	private String ppARemark;					//A相功率备注
	//-----B相功率------//
	private String ppBDisOutValue;				//B相功率界面显示值输出
	private String ppBMeaCalValue;				//B相功率计算值
	private String ppBRemark;					//B相功率备注
	//-----C相功率------//
	private String ppCDisOutValue;				//C相功率界面显示值输出
	private String ppCMeaCalValue;				//C相功率计算值
	private String ppCRemark;					//C相功率备注
	
	//巡检内容检查
	//----环境----//
	private CheckResult atIsAdjustable;                 //环境温度是否可调
	private String temperature;						//环境温度
	private String humidity;							//环境湿度
	//----设备及外观-----//
	private CheckResult eaIsIntact;						//设备外观是否完好
	private CheckResult radiateIsNormal;				//ups及电池散热柜是否正常
	private CheckResult esGroundVoltage;				//设备外壳对地是否有电压
	private CheckResult upsRvIsNormal;					//ups运行声音是否正常
	private CheckResult upsUidisIsNormal;				//ups界面显示是否正常
	private CheckResult raIsFlow;						//房间内空气是否流通
	private CheckResult batLeakage;						//电池无漏液现象
	private CheckResult upsOutletIsClean;				//ups出风口是否干净
	private CheckResult batSurfaceIsClean;				//电池表面是否干净
	private CheckResult connCo;							//连接端子无腐蚀氧化
	//-----告警-----//
	private CheckResult upsCurFAlarm;					//ups当前故障告警
	private CheckResult upsHisFAlarm;					//ups历史故障告警
	//-----输入系统-----//
	private String inputVLN;							//输入电压L-N
	private String inputVLD;							//输入电压L-D
	private String inputVND;							//输入电压N-D
	private String inputCurrent;						//输入电流
	private String loadCapacity;						//负载量
	private String inputAirTemperature;					//输入系统空开温度
	private String inputCableTemperature;				//输入系统线缆温度
	//-----输入系统-----//
	private String outputVLN;							//输出电压L-N
	private String outputVLD;							//输出电压L-D
	private String outputVND;							//输出电压N-D
	private String outputCurrent;						//输出电流
	private String outputAirTemperature;				//输出系统空开温度
	
	private ContentCheckResult equipDustRemoval;		//设备除尘
	
	//零地电压及零线电流测量
	private String zgvInputResult;					//输入端零地电压测试结果
	private String zgvInputRemark;					//输入端零地电压备注
	public String getZgvInputMeasure() {
		return zgvInputMeasure;
	}
	public void setZgvInputMeasure(String zgvInputMeasure) {
		this.zgvInputMeasure = zgvInputMeasure;
	}
	public String getZgvOutputMeasure() {
		return zgvOutputMeasure;
	}
	public void setZgvOutputMeasure(String zgvOutputMeasure) {
		this.zgvOutputMeasure = zgvOutputMeasure;
	}
	public String getZlcInputMeasure() {
		return zlcInputMeasure;
	}
	public void setZlcInputMeasure(String zlcInputMeasure) {
		this.zlcInputMeasure = zlcInputMeasure;
	}
	public String getZlcOutputMeasure() {
		return zlcOutputMeasure;
	}
	public void setZlcOutputMeasure(String zlcOutputMeasure) {
		this.zlcOutputMeasure = zlcOutputMeasure;
	}
	private String zgvOutputResult;					//输出端零地电压测试结果
	private String zgvOutputRemark;					//输出端零地电压备注
	private String zlcInputResult;					//输入端零线电流测试结果
	private String zlcInputRemark;					//输入端零线电流备注
	private String zlcOutputResult;					//输出端零线电流测试结果
	private String zlcOutputRemark;					//输出端零线电流备注
	
	//20160802
	private String zgvInputMeasure;					//输入端零地电压测量值
	private String zgvOutputMeasure;				//输出端零地电压测量值
	private String zlcInputMeasure;					//输入端零线电流测量值
	private String zlcOutputMeasure;				//输出端零线电流测量值
	
	//电池测量
	private int number;					//电池序号
	private String termialV;				//端电压
	private String interR;					//内阻
	private String remarks;					//备注
	
	//系统连接检查
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
	
	//放电测试
	private String startTime;				//放电开始时间
	private String endTime;				//放电结束时间
	private String durationTime;			//放电持续时间
	private String preTotalV;				//放电前总电压
	private String endTotalV;				//放电终止总电压
	private String batChargingC;			//电池充电电流
	private String dsTime;				//放电时间
	private String batTotalV;			//电池总电压
	private String dsCurrent;			//放电电流
	private String singleMaxV;			//单节最高电压
	private String singleMinV;			//单节最低电压
	private String remark;				//备注
	
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ContentCheckResult getEquipDustRemoval() {
		return equipDustRemoval;
	}
	public void setEquipDustRemoval(ContentCheckResult equipDustRemoval) {
		this.equipDustRemoval = equipDustRemoval;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	public String getPreTotalV() {
		return preTotalV;
	}
	public void setPreTotalV(String preTotalV) {
		this.preTotalV = preTotalV;
	}
	public String getEndTotalV() {
		return endTotalV;
	}
	public void setEndTotalV(String endTotalV) {
		this.endTotalV = endTotalV;
	}
	public String getBatChargingC() {
		return batChargingC;
	}
	public void setBatChargingC(String batChargingC) {
		this.batChargingC = batChargingC;
	}
	public String getDsTime() {
		return dsTime;
	}
	public void setDsTime(String dsTime) {
		this.dsTime = dsTime;
	}
	public String getBatTotalV() {
		return batTotalV;
	}
	public void setBatTotalV(String batTotalV) {
		this.batTotalV = batTotalV;
	}
	public String getDsCurrent() {
		return dsCurrent;
	}
	public void setDsCurrent(String dsCurrent) {
		this.dsCurrent = dsCurrent;
	}
	public String getSingleMaxV() {
		return singleMaxV;
	}
	public void setSingleMaxV(String singleMaxV) {
		this.singleMaxV = singleMaxV;
	}
	public String getSingleMinV() {
		return singleMinV;
	}
	public void setSingleMinV(String singleMinV) {
		this.singleMinV = singleMinV;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/*public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}*/
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
	public String getPvANDisOutValue() {
		return pvANDisOutValue;
	}
	public void setPvANDisOutValue(String pvANDisOutValue) {
		this.pvANDisOutValue = pvANDisOutValue;
	}
	public String getPvANMeaInValue() {
		return pvANMeaInValue;
	}
	public void setPvANMeaInValue(String pvANMeaInValue) {
		this.pvANMeaInValue = pvANMeaInValue;
	}
	public String getPvANMeaOutValue() {
		return pvANMeaOutValue;
	}
	public void setPvANMeaOutValue(String pvANMeaOutValue) {
		this.pvANMeaOutValue = pvANMeaOutValue;
	}
	public String getPvANRemark() {
		return pvANRemark;
	}
	public void setPvANRemark(String pvANRemark) {
		this.pvANRemark = pvANRemark;
	}
	public String getPvBNDisOutValue() {
		return pvBNDisOutValue;
	}
	public void setPvBNDisOutValue(String pvBNDisOutValue) {
		this.pvBNDisOutValue = pvBNDisOutValue;
	}
	public String getPvBNMeaInValue() {
		return pvBNMeaInValue;
	}
	public void setPvBNMeaInValue(String pvBNMeaInValue) {
		this.pvBNMeaInValue = pvBNMeaInValue;
	}
	public String getPvBNMeaOutValue() {
		return pvBNMeaOutValue;
	}
	public void setPvBNMeaOutValue(String pvBNMeaOutValue) {
		this.pvBNMeaOutValue = pvBNMeaOutValue;
	}
	public String getPvBNRemark() {
		return pvBNRemark;
	}
	public void setPvBNRemark(String pvBNRemark) {
		this.pvBNRemark = pvBNRemark;
	}
	public String getPvCNDisOutValue() {
		return pvCNDisOutValue;
	}
	public void setPvCNDisOutValue(String pvCNDisOutValue) {
		this.pvCNDisOutValue = pvCNDisOutValue;
	}
	public String getPvCNMeaInValue() {
		return pvCNMeaInValue;
	}
	public void setPvCNMeaInValue(String pvCNMeaInValue) {
		this.pvCNMeaInValue = pvCNMeaInValue;
	}
	public String getPvCNMeaOutValue() {
		return pvCNMeaOutValue;
	}
	public void setPvCNMeaOutValue(String pvCNMeaOutValue) {
		this.pvCNMeaOutValue = pvCNMeaOutValue;
	}
	public String getPvCNRemark() {
		return pvCNRemark;
	}
	public void setPvCNRemark(String pvCNRemark) {
		this.pvCNRemark = pvCNRemark;
	}
	public String getLvABDisOutValue() {
		return lvABDisOutValue;
	}
	public void setLvABDisOutValue(String lvABDisOutValue) {
		this.lvABDisOutValue = lvABDisOutValue;
	}
	public String getLvABMeaInValue() {
		return lvABMeaInValue;
	}
	public void setLvABMeaInValue(String lvABMeaInValue) {
		this.lvABMeaInValue = lvABMeaInValue;
	}
	public String getLvABMeaOutValue() {
		return lvABMeaOutValue;
	}
	public void setLvABMeaOutValue(String lvABMeaOutValue) {
		this.lvABMeaOutValue = lvABMeaOutValue;
	}
	public String getLvABRemark() {
		return lvABRemark;
	}
	public void setLvABRemark(String lvABRemark) {
		this.lvABRemark = lvABRemark;
	}
	public String getLvACDisOutValue() {
		return lvACDisOutValue;
	}
	public void setLvACDisOutValue(String lvACDisOutValue) {
		this.lvACDisOutValue = lvACDisOutValue;
	}
	public String getLvACMeaInValue() {
		return lvACMeaInValue;
	}
	public void setLvACMeaInValue(String lvACMeaInValue) {
		this.lvACMeaInValue = lvACMeaInValue;
	}
	public String getLvACMeaOutValue() {
		return lvACMeaOutValue;
	}
	public void setLvACMeaOutValue(String lvACMeaOutValue) {
		this.lvACMeaOutValue = lvACMeaOutValue;
	}
	public String getLvACRemark() {
		return lvACRemark;
	}
	public void setLvACRemark(String lvACRemark) {
		this.lvACRemark = lvACRemark;
	}
	public String getLvBCDisOutValue() {
		return lvBCDisOutValue;
	}
	public void setLvBCDisOutValue(String lvBCDisOutValue) {
		this.lvBCDisOutValue = lvBCDisOutValue;
	}
	public String getLvBCMeaInValue() {
		return lvBCMeaInValue;
	}
	public void setLvBCMeaInValue(String lvBCMeaInValue) {
		this.lvBCMeaInValue = lvBCMeaInValue;
	}
	public String getLvBCMeaOutValue() {
		return lvBCMeaOutValue;
	}
	public void setLvBCMeaOutValue(String lvBCMeaOutValue) {
		this.lvBCMeaOutValue = lvBCMeaOutValue;
	}
	public String getLvBCRemark() {
		return lvBCRemark;
	}
	public void setLvBCRemark(String lvBCRemark) {
		this.lvBCRemark = lvBCRemark;
	}
	public String getPcADisOutValue() {
		return pcADisOutValue;
	}
	public void setPcADisOutValue(String pcADisOutValue) {
		this.pcADisOutValue = pcADisOutValue;
	}
	public String getPcAMeaInValue() {
		return pcAMeaInValue;
	}
	public void setPcAMeaInValue(String pcAMeaInValue) {
		this.pcAMeaInValue = pcAMeaInValue;
	}
	public String getPcAMeaOutValue() {
		return pcAMeaOutValue;
	}
	public void setPcAMeaOutValue(String pcAMeaOutValue) {
		this.pcAMeaOutValue = pcAMeaOutValue;
	}
	public String getPcARemark() {
		return pcARemark;
	}
	public void setPcARemark(String pcARemark) {
		this.pcARemark = pcARemark;
	}
	public String getPcBDisOutValue() {
		return pcBDisOutValue;
	}
	public void setPcBDisOutValue(String pcBDisOutValue) {
		this.pcBDisOutValue = pcBDisOutValue;
	}
	public String getPcBMeaInValue() {
		return pcBMeaInValue;
	}
	public void setPcBMeaInValue(String pcBMeaInValue) {
		this.pcBMeaInValue = pcBMeaInValue;
	}
	public String getPcBMeaOutValue() {
		return pcBMeaOutValue;
	}
	public void setPcBMeaOutValue(String pcBMeaOutValue) {
		this.pcBMeaOutValue = pcBMeaOutValue;
	}
	public String getPcBRemark() {
		return pcBRemark;
	}
	public void setPcBRemark(String pcBRemark) {
		this.pcBRemark = pcBRemark;
	}
	public String getPcCDisOutValue() {
		return pcCDisOutValue;
	}
	public void setPcCDisOutValue(String pcCDisOutValue) {
		this.pcCDisOutValue = pcCDisOutValue;
	}
	public String getPcCMeaInValue() {
		return pcCMeaInValue;
	}
	public void setPcCMeaInValue(String pcCMeaInValue) {
		this.pcCMeaInValue = pcCMeaInValue;
	}
	public String getPcCMeaOutValue() {
		return pcCMeaOutValue;
	}
	public void setPcCMeaOutValue(String pcCMeaOutValue) {
		this.pcCMeaOutValue = pcCMeaOutValue;
	}
	public String getPcCRemark() {
		return pcCRemark;
	}
	public void setPcCRemark(String pcCRemark) {
		this.pcCRemark = pcCRemark;
	}
	public String getPpADisOutValue() {
		return ppADisOutValue;
	}
	public void setPpADisOutValue(String ppADisOutValue) {
		this.ppADisOutValue = ppADisOutValue;
	}
	public String getPpAMeaCalValue() {
		return ppAMeaCalValue;
	}
	public void setPpAMeaCalValue(String ppAMeaCalValue) {
		this.ppAMeaCalValue = ppAMeaCalValue;
	}
	public String getPpARemark() {
		return ppARemark;
	}
	public void setPpARemark(String ppARemark) {
		this.ppARemark = ppARemark;
	}
	public String getPpBDisOutValue() {
		return ppBDisOutValue;
	}
	public void setPpBDisOutValue(String ppBDisOutValue) {
		this.ppBDisOutValue = ppBDisOutValue;
	}
	public String getPpBMeaCalValue() {
		return ppBMeaCalValue;
	}
	public void setPpBMeaCalValue(String ppBMeaCalValue) {
		this.ppBMeaCalValue = ppBMeaCalValue;
	}
	public String getPpBRemark() {
		return ppBRemark;
	}
	public void setPpBRemark(String ppBRemark) {
		this.ppBRemark = ppBRemark;
	}
	public String getPpCDisOutValue() {
		return ppCDisOutValue;
	}
	public void setPpCDisOutValue(String ppCDisOutValue) {
		this.ppCDisOutValue = ppCDisOutValue;
	}
	public String getPpCMeaCalValue() {
		return ppCMeaCalValue;
	}
	public void setPpCMeaCalValue(String ppCMeaCalValue) {
		this.ppCMeaCalValue = ppCMeaCalValue;
	}
	public String getPpCRemark() {
		return ppCRemark;
	}
	public void setPpCRemark(String ppCRemark) {
		this.ppCRemark = ppCRemark;
	}
	public CheckResult getAtIsAdjustable() {
		return atIsAdjustable;
	}
	public void setAtIsAdjustable(CheckResult atIsAdjustable) {
		this.atIsAdjustable = atIsAdjustable;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public CheckResult getEaIsIntact() {
		return eaIsIntact;
	}
	public void setEaIsIntact(CheckResult eaIsIntact) {
		this.eaIsIntact = eaIsIntact;
	}
	public CheckResult getRadiateIsNormal() {
		return radiateIsNormal;
	}
	public void setRadiateIsNormal(CheckResult radiateIsNormal) {
		this.radiateIsNormal = radiateIsNormal;
	}
	public CheckResult getEsGroundVoltage() {
		return esGroundVoltage;
	}
	public void setEsGroundVoltage(CheckResult esGroundVoltage) {
		this.esGroundVoltage = esGroundVoltage;
	}
	public CheckResult getUpsRvIsNormal() {
		return upsRvIsNormal;
	}
	public void setUpsRvIsNormal(CheckResult upsRvIsNormal) {
		this.upsRvIsNormal = upsRvIsNormal;
	}
	public CheckResult getUpsUidisIsNormal() {
		return upsUidisIsNormal;
	}
	public void setUpsUidisIsNormal(CheckResult upsUidisIsNormal) {
		this.upsUidisIsNormal = upsUidisIsNormal;
	}
	public CheckResult getRaIsFlow() {
		return raIsFlow;
	}
	public void setRaIsFlow(CheckResult raIsFlow) {
		this.raIsFlow = raIsFlow;
	}
	public CheckResult getBatLeakage() {
		return batLeakage;
	}
	public void setBatLeakage(CheckResult batLeakage) {
		this.batLeakage = batLeakage;
	}
	public CheckResult getUpsOutletIsClean() {
		return upsOutletIsClean;
	}
	public void setUpsOutletIsClean(CheckResult upsOutletIsClean) {
		this.upsOutletIsClean = upsOutletIsClean;
	}
	public CheckResult getBatSurfaceIsClean() {
		return batSurfaceIsClean;
	}
	public void setBatSurfaceIsClean(CheckResult batSurfaceIsClean) {
		this.batSurfaceIsClean = batSurfaceIsClean;
	}
	public CheckResult getConnCo() {
		return connCo;
	}
	public void setConnCo(CheckResult connCo) {
		this.connCo = connCo;
	}
	public CheckResult getUpsCurFAlarm() {
		return upsCurFAlarm;
	}
	public void setUpsCurFAlarm(CheckResult upsCurFAlarm) {
		this.upsCurFAlarm = upsCurFAlarm;
	}
	public CheckResult getUpsHisFAlarm() {
		return upsHisFAlarm;
	}
	public void setUpsHisFAlarm(CheckResult upsHisFAlarm) {
		this.upsHisFAlarm = upsHisFAlarm;
	}
	public String getInputVLN() {
		return inputVLN;
	}
	public void setInputVLN(String inputVLN) {
		this.inputVLN = inputVLN;
	}
	public String getInputVLD() {
		return inputVLD;
	}
	public void setInputVLD(String inputVLD) {
		this.inputVLD = inputVLD;
	}
	public String getInputVND() {
		return inputVND;
	}
	public void setInputVND(String inputVND) {
		this.inputVND = inputVND;
	}
	public String getInputCurrent() {
		return inputCurrent;
	}
	public void setInputCurrent(String inputCurrent) {
		this.inputCurrent = inputCurrent;
	}
	public String getLoadCapacity() {
		return loadCapacity;
	}
	public void setLoadCapacity(String loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	public String getInputAirTemperature() {
		return inputAirTemperature;
	}
	public void setInputAirTemperature(String inputAirTemperature) {
		this.inputAirTemperature = inputAirTemperature;
	}
	public String getInputCableTemperature() {
		return inputCableTemperature;
	}
	public void setInputCableTemperature(String inputCableTemperature) {
		this.inputCableTemperature = inputCableTemperature;
	}
	public String getOutputVLN() {
		return outputVLN;
	}
	public void setOutputVLN(String outputVLN) {
		this.outputVLN = outputVLN;
	}
	public String getOutputVLD() {
		return outputVLD;
	}
	public void setOutputVLD(String outputVLD) {
		this.outputVLD = outputVLD;
	}
	public String getOutputVND() {
		return outputVND;
	}
	public void setOutputVND(String outputVND) {
		this.outputVND = outputVND;
	}
	public String getOutputCurrent() {
		return outputCurrent;
	}
	public void setOutputCurrent(String outputCurrent) {
		this.outputCurrent = outputCurrent;
	}
	public String getOutputAirTemperature() {
		return outputAirTemperature;
	}
	public void setOutputAirTemperature(String outputAirTemperature) {
		this.outputAirTemperature = outputAirTemperature;
	}
	public String getZgvInputResult() {
		return zgvInputResult;
	}
	public void setZgvInputResult(String zgvInputResult) {
		this.zgvInputResult = zgvInputResult;
	}
	public String getZgvInputRemark() {
		return zgvInputRemark;
	}
	public void setZgvInputRemark(String zgvInputRemark) {
		this.zgvInputRemark = zgvInputRemark;
	}
	public String getZgvOutputResult() {
		return zgvOutputResult;
	}
	public void setZgvOutputResult(String zgvOutputResult) {
		this.zgvOutputResult = zgvOutputResult;
	}
	public String getZgvOutputRemark() {
		return zgvOutputRemark;
	}
	public void setZgvOutputRemark(String zgvOutputRemark) {
		this.zgvOutputRemark = zgvOutputRemark;
	}
	public String getZlcInputResult() {
		return zlcInputResult;
	}
	public void setZlcInputResult(String zlcInputResult) {
		this.zlcInputResult = zlcInputResult;
	}
	public String getZlcInputRemark() {
		return zlcInputRemark;
	}
	public void setZlcInputRemark(String zlcInputRemark) {
		this.zlcInputRemark = zlcInputRemark;
	}
	public String getZlcOutputResult() {
		return zlcOutputResult;
	}
	public void setZlcOutputResult(String zlcOutputResult) {
		this.zlcOutputResult = zlcOutputResult;
	}
	public String getZlcOutputRemark() {
		return zlcOutputRemark;
	}
	public void setZlcOutputRemark(String zlcOutputRemark) {
		this.zlcOutputRemark = zlcOutputRemark;
	}
	public String getTermialV() {
		return termialV;
	}
	public void setTermialV(String termialV) {
		this.termialV = termialV;
	}
	public String getInterR() {
		return interR;
	}
	public void setInterR(String interR) {
		this.interR = interR;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpsIcTr() {
		return upsIcTr;
	}
	public void setUpsIcTr(String upsIcTr) {
		this.upsIcTr = upsIcTr;
	}
	public String getUpsIcRemark() {
		return upsIcRemark;
	}
	public void setUpsIcRemark(String upsIcRemark) {
		this.upsIcRemark = upsIcRemark;
	}
	public String getUpsFRunTr() {
		return upsFRunTr;
	}
	public void setUpsFRunTr(String upsFRunTr) {
		this.upsFRunTr = upsFRunTr;
	}
	public String getUpsFRunRemark() {
		return upsFRunRemark;
	}
	public void setUpsFRunRemark(String upsFRunRemark) {
		this.upsFRunRemark = upsFRunRemark;
	}
	public String getUpsIbFirmTr() {
		return upsIbFirmTr;
	}
	public void setUpsIbFirmTr(String upsIbFirmTr) {
		this.upsIbFirmTr = upsIbFirmTr;
	}
	public String getUpsIbFirmRemark() {
		return upsIbFirmRemark;
	}
	public void setUpsIbFirmRemark(String upsIbFirmRemark) {
		this.upsIbFirmRemark = upsIbFirmRemark;
	}
	public String getUpsCwOhTr() {
		return upsCwOhTr;
	}
	public void setUpsCwOhTr(String upsCwOhTr) {
		this.upsCwOhTr = upsCwOhTr;
	}
	public String getUpsCwOhRemark() {
		return upsCwOhRemark;
	}
	public void setUpsCwOhRemark(String upsCwOhRemark) {
		this.upsCwOhRemark = upsCwOhRemark;
	}
	public String getUpsRvTr() {
		return upsRvTr;
	}
	public void setUpsRvTr(String upsRvTr) {
		this.upsRvTr = upsRvTr;
	}
	public String getUpsRvRemark() {
		return upsRvRemark;
	}
	public void setUpsRvRemark(String upsRvRemark) {
		this.upsRvRemark = upsRvRemark;
	}
	public String getBatCTr() {
		return batCTr;
	}
	public void setBatCTr(String batCTr) {
		this.batCTr = batCTr;
	}
	public String getBatCRemark() {
		return batCRemark;
	}
	public void setBatCRemark(String batCRemark) {
		this.batCRemark = batCRemark;
	}
	public String getUpsPdcIowTr() {
		return upsPdcIowTr;
	}
	public void setUpsPdcIowTr(String upsPdcIowTr) {
		this.upsPdcIowTr = upsPdcIowTr;
	}
	public String getUpsPdcIowRemark() {
		return upsPdcIowRemark;
	}
	public void setUpsPdcIowRemark(String upsPdcIowRemark) {
		this.upsPdcIowRemark = upsPdcIowRemark;
	}
	public String getBpdbTr() {
		return bpdbTr;
	}
	public void setBpdbTr(String bpdbTr) {
		this.bpdbTr = bpdbTr;
	}
	public String getBpdbRemark() {
		return bpdbRemark;
	}
	public void setBpdbRemark(String bpdbRemark) {
		this.bpdbRemark = bpdbRemark;
	}
	public String getPdcCTr() {
		return pdcCTr;
	}
	public void setPdcCTr(String pdcCTr) {
		this.pdcCTr = pdcCTr;
	}
	public String getPdcCRemark() {
		return pdcCRemark;
	}
	public void setPdcCRemark(String pdcCRemark) {
		this.pdcCRemark = pdcCRemark;
	}
	public String getPdcMIlTr() {
		return pdcMIlTr;
	}
	public void setPdcMIlTr(String pdcMIlTr) {
		this.pdcMIlTr = pdcMIlTr;
	}
	public String getPdcMIlRemark() {
		return pdcMIlRemark;
	}
	public void setPdcMIlRemark(String pdcMIlRemark) {
		this.pdcMIlRemark = pdcMIlRemark;
	}
	public String getBfnTr() {
		return bfnTr;
	}
	public void setBfnTr(String bfnTr) {
		this.bfnTr = bfnTr;
	}
	public String getBfnRemark() {
		return bfnRemark;
	}
	public void setBfnRemark(String bfnRemark) {
		this.bfnRemark = bfnRemark;
	}
	public String getLtCwFTr() {
		return ltCwFTr;
	}
	public void setLtCwFTr(String ltCwFTr) {
		this.ltCwFTr = ltCwFTr;
	}
	public String getLtCwFRemark() {
		return ltCwFRemark;
	}
	public void setLtCwFRemark(String ltCwFRemark) {
		this.ltCwFRemark = ltCwFRemark;
	}
	public String getLtLcTr() {
		return ltLcTr;
	}
	public void setLtLcTr(String ltLcTr) {
		this.ltLcTr = ltLcTr;
	}
	public String getLtLcRemark() {
		return ltLcRemark;
	}
	public void setLtLcRemark(String ltLcRemark) {
		this.ltLcRemark = ltLcRemark;
	}
	public String getLtSTr() {
		return ltSTr;
	}
	public void setLtSTr(String ltSTr) {
		this.ltSTr = ltSTr;
	}
	public String getLtSRemark() {
		return ltSRemark;
	}
	public void setLtSRemark(String ltSRemark) {
		this.ltSRemark = ltSRemark;
	}
	
	
}