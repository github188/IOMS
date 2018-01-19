package cn.com.atnc.ioms.model.duty.environment.psot;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.ContentCheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.psot.CheckStatus;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 传输设备与通信线路添加model
 * @author renyujuan
 * @time:2016年8月17日 上午10:45:07
 */
public class PsOtAddForm extends MyPaginModel {

    /*<-----------环境巡检表---------------->*/
    private String name;                //环境设备名称
    private User operator;              //操作人
    private String problem;             //存在问题
    private String suggestion;          //建议
    private String result;              //检查结果
    private String checkTime;               //检查时间
    private String checkDate;               //检查日期
    private CheckCatagory checkType;    //检查类别
    private EquipType equipType;        //设备类型
    /*<-----------传输设备与通信线路内容巡检表---------------->*/
    /*风扇*/
    private CheckResult eoeFanCheckResult;  
    private String eoeFanRemarks;
    /*温度*/
    private String eoeTemCheckResult;
    private String eoeTemRemarks;
    /*湿度*/
    private String eoeHumCheckResult;
    private String eoeHumRemarks;
    /*显示屏*/
    private CheckResult screenCheckResult;
    private String screenRemarks;
    /*设备指示灯状态*/
    private CheckResult disCheckResult;
    private String disRemarks;
    /*板卡运行状态*/
    private CheckResult crsCheckResult;
    private String crsRemarks;
    /*设备线缆连接*/
    private CheckStatus dlccCheckResult;
    private String dlccRemarks;
    /*电源供电连接*/
    private CheckStatus pscCheckResult;
    private String pscRemarks;
    /*交流电输入电压*/
    private String acivCheckResult;
    private String acivRemarks;
    /*直流电输出电压*/
    private String dcovCheckResult;
    private String dcovRemarks;
    /*蓄电池电压*/
    private String bvCheckResult;
    private String bvRemarks;
    /*蓄电池内阻*/
    private CheckResult birCheckResult;
    private String birRemarks;
    /*电池连接*/
    private CheckStatus batteryConnResult;
    private String batteryConnRemarks;
    /*逆变器*/
    private CheckResult inverterCheckResult;
    private String inverterRemarks;
    /*保险*/
    private CheckResult insuranceCheckResult;
    private String insuranceRemarks;
    /*设备清洁*/
    private ContentCheckResult ecCheckResult;
    private String ecRemarks;
    /*接地保护*/
    private CheckResult gpCheckResult;
    private String gpRemarks;
    /*DDF，ODF架接头*/
    private CheckStatus ddfOdfCheckResult;
    private String ddfOdfRemarks;
    /*光缆使用情况 Optical cable usage*/
    private CheckStatus ocuCheckResult;
    private String ocuRemarks;
    /*光纤标识 optical fiber coding*/
    private CheckStatus ofcCheckResult;
    private String ofcRemarks;
    /*当前主用  Current main use*/
    private CheckStatus cmuCheckResult;
    private String cmuRemarks;
    /*A机主控板卡 Main control board*/
    private CheckResult mcbaCheckResult;
    private String mcbaRemarks;
    /*A机1号v.35板卡*/
    private CheckResult cba1CheckResult;
    private String cba1Remarks;
    /*A机2号v.35板卡*/
    private CheckResult cba2CheckResult;
    private String cba2Remarks;
    /*A机3号v.35板卡*/
    private CheckResult cba3CheckResult;
    private String cba3Remarks;
    /*A机E1板卡*/
    private CheckResult cbae1CheckResult;
    private String cbae1Remarks;
    /*B机主控板卡*/
    private CheckResult mcbbCheckResult;
    private String mcbbRemarks;
    /*B机1号v.35板卡*/
    private CheckResult cbb1v35CheckResult;
    private String cbb1v35Remarks;
    /*B机2号v.35板卡*/
    private CheckResult cbb2v35CheckResult;
    private String cbb2v35Remarks;
    /*B机3号v.35板卡*/
    private CheckResult cbb3v35CheckResult;
    private String cbb3v35Remarks;
    /*B机1号v.24板卡*/
    private CheckResult cbb1v24CheckResult;
    private String cbb1v24Remarks;
    /*B机2号v.24板卡*/
    private CheckResult cbb2v24CheckResult;
    private String cbb2v24Remarks;
    /*B机3号v.24板卡*/
    private CheckResult cbb3v24CheckResult;
    private String cbb3v24Remarks;
    /*    B机E1板卡*/
    private CheckResult cbbe1CheckResult;
    private String cbbe1Remarks;
    /*V.35接口连接 Interface connection*/
    private CheckStatus v35icCheckResult;
    private String v35icRemarks;
    /*V.24接口连接*/
    private CheckStatus v24icCheckResult;
    private String v24icRemarks;
    /*本月线路运行情况 Line running situation month*/
    private String monthLrs;
    /*本月新增线路情况 line add situation month*/
    private String monthLas;
    /*本月删减线路情况 Line cut situation month*/
    private String monthLcs;
    /*本月线路故障情况 Line fault conditions month*/
    private String monthLfs;
    /*本月线路割接情况 Line cutover situation month*/
    private String monthLcsc;
    /*地下一层至六层电话线路、数据线路配线线架*/
    private CheckResult underTlDlwrCheckResult;
    private String underTlDlwrRemarks;
    private CheckResult ffTlDlwrCheckResult;
    private String ffTlDlwrRemarks;
    private CheckResult fsTlDlwrCheckResult;
    private String fsTlDlwrRemarks;
    private CheckResult ftTlDlwrCheckResult;
    private String ftTlDlwrRemarks;
    private CheckResult ffoTlDlwrCheckResult;
    private String ffoTlDlwrRemarks;
    private CheckResult ffiTlDlwrCheckResult;
    private String ffiTlDlwrRemarks;
    private CheckResult fsiTlDlwrCheckResult;
    private String fsiTlDlwrRemarks;
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
    public CheckResult getEoeFanCheckResult() {
        return eoeFanCheckResult;
    }
    public void setEoeFanCheckResult(CheckResult eoeFanCheckResult) {
        this.eoeFanCheckResult = eoeFanCheckResult;
    }
    public String getEoeFanRemarks() {
        return eoeFanRemarks;
    }
    public void setEoeFanRemarks(String eoeFanRemarks) {
        this.eoeFanRemarks = eoeFanRemarks;
    }
    public String getEoeTemCheckResult() {
        return eoeTemCheckResult;
    }
    public void setEoeTemCheckResult(String eoeTemCheckResult) {
        this.eoeTemCheckResult = eoeTemCheckResult;
    }
    public String getEoeTemRemarks() {
        return eoeTemRemarks;
    }
    public void setEoeTemRemarks(String eoeTemRemarks) {
        this.eoeTemRemarks = eoeTemRemarks;
    }
    public String getEoeHumCheckResult() {
        return eoeHumCheckResult;
    }
    public void setEoeHumCheckResult(String eoeHumCheckResult) {
        this.eoeHumCheckResult = eoeHumCheckResult;
    }
    public String getEoeHumRemarks() {
        return eoeHumRemarks;
    }
    public void setEoeHumRemarks(String eoeHumRemarks) {
        this.eoeHumRemarks = eoeHumRemarks;
    }
    public CheckResult getScreenCheckResult() {
        return screenCheckResult;
    }
    public void setScreenCheckResult(CheckResult screenCheckResult) {
        this.screenCheckResult = screenCheckResult;
    }
    public String getScreenRemarks() {
        return screenRemarks;
    }
    public void setScreenRemarks(String screenRemarks) {
        this.screenRemarks = screenRemarks;
    }
    public CheckResult getDisCheckResult() {
        return disCheckResult;
    }
    public void setDisCheckResult(CheckResult disCheckResult) {
        this.disCheckResult = disCheckResult;
    }
    public String getDisRemarks() {
        return disRemarks;
    }
    public void setDisRemarks(String disRemarks) {
        this.disRemarks = disRemarks;
    }
    public CheckResult getCrsCheckResult() {
        return crsCheckResult;
    }
    public void setCrsCheckResult(CheckResult crsCheckResult) {
        this.crsCheckResult = crsCheckResult;
    }
    public String getCrsRemarks() {
        return crsRemarks;
    }
    public void setCrsRemarks(String crsRemarks) {
        this.crsRemarks = crsRemarks;
    }
    public CheckStatus getDlccCheckResult() {
        return dlccCheckResult;
    }
    public void setDlccCheckResult(CheckStatus dlccCheckResult) {
        this.dlccCheckResult = dlccCheckResult;
    }
    public String getDlccRemarks() {
        return dlccRemarks;
    }
    public void setDlccRemarks(String dlccRemarks) {
        this.dlccRemarks = dlccRemarks;
    }
    public CheckStatus getPscCheckResult() {
        return pscCheckResult;
    }
    public void setPscCheckResult(CheckStatus pscCheckResult) {
        this.pscCheckResult = pscCheckResult;
    }
    public String getPscRemarks() {
        return pscRemarks;
    }
    public void setPscRemarks(String pscRemarks) {
        this.pscRemarks = pscRemarks;
    }
    public String getAcivCheckResult() {
        return acivCheckResult;
    }
    public void setAcivCheckResult(String acivCheckResult) {
        this.acivCheckResult = acivCheckResult;
    }
    public String getAcivRemarks() {
        return acivRemarks;
    }
    public void setAcivRemarks(String acivRemarks) {
        this.acivRemarks = acivRemarks;
    }
    public String getDcovCheckResult() {
        return dcovCheckResult;
    }
    public void setDcovCheckResult(String dcovCheckResult) {
        this.dcovCheckResult = dcovCheckResult;
    }
    public String getDcovRemarks() {
        return dcovRemarks;
    }
    public void setDcovRemarks(String dcovRemarks) {
        this.dcovRemarks = dcovRemarks;
    }
    public String getBvCheckResult() {
        return bvCheckResult;
    }
    public void setBvCheckResult(String bvCheckResult) {
        this.bvCheckResult = bvCheckResult;
    }
    public String getBvRemarks() {
        return bvRemarks;
    }
    public void setBvRemarks(String bvRemarks) {
        this.bvRemarks = bvRemarks;
    }
    public CheckResult getBirCheckResult() {
        return birCheckResult;
    }
    public void setBirCheckResult(CheckResult birCheckResult) {
        this.birCheckResult = birCheckResult;
    }
    public String getBirRemarks() {
        return birRemarks;
    }
    public void setBirRemarks(String birRemarks) {
        this.birRemarks = birRemarks;
    }
    public CheckStatus getBatteryConnResult() {
        return batteryConnResult;
    }
    public void setBatteryConnResult(CheckStatus batteryConnResult) {
        this.batteryConnResult = batteryConnResult;
    }
    public String getBatteryConnRemarks() {
        return batteryConnRemarks;
    }
    public void setBatteryConnRemarks(String batteryConnRemarks) {
        this.batteryConnRemarks = batteryConnRemarks;
    }
    public CheckResult getInverterCheckResult() {
        return inverterCheckResult;
    }
    public void setInverterCheckResult(CheckResult inverterCheckResult) {
        this.inverterCheckResult = inverterCheckResult;
    }
    public String getInverterRemarks() {
        return inverterRemarks;
    }
    public void setInverterRemarks(String inverterRemarks) {
        this.inverterRemarks = inverterRemarks;
    }
    public CheckResult getInsuranceCheckResult() {
        return insuranceCheckResult;
    }
    public void setInsuranceCheckResult(CheckResult insuranceCheckResult) {
        this.insuranceCheckResult = insuranceCheckResult;
    }
    public String getInsuranceRemarks() {
        return insuranceRemarks;
    }
    public void setInsuranceRemarks(String insuranceRemarks) {
        this.insuranceRemarks = insuranceRemarks;
    }
    public ContentCheckResult getEcCheckResult() {
        return ecCheckResult;
    }
    public void setEcCheckResult(ContentCheckResult ecCheckResult) {
        this.ecCheckResult = ecCheckResult;
    }
    public String getEcRemarks() {
        return ecRemarks;
    }
    public void setEcRemarks(String ecRemarks) {
        this.ecRemarks = ecRemarks;
    }
    public CheckResult getGpCheckResult() {
        return gpCheckResult;
    }
    public void setGpCheckResult(CheckResult gpCheckResult) {
        this.gpCheckResult = gpCheckResult;
    }
    public String getGpRemarks() {
        return gpRemarks;
    }
    public void setGpRemarks(String gpRemarks) {
        this.gpRemarks = gpRemarks;
    }
    public CheckStatus getDdfOdfCheckResult() {
        return ddfOdfCheckResult;
    }
    public void setDdfOdfCheckResult(CheckStatus ddfOdfCheckResult) {
        this.ddfOdfCheckResult = ddfOdfCheckResult;
    }
    public String getDdfOdfRemarks() {
        return ddfOdfRemarks;
    }
    public void setDdfOdfRemarks(String ddfOdfRemarks) {
        this.ddfOdfRemarks = ddfOdfRemarks;
    }
    public CheckStatus getOcuCheckResult() {
        return ocuCheckResult;
    }
    public void setOcuCheckResult(CheckStatus ocuCheckResult) {
        this.ocuCheckResult = ocuCheckResult;
    }
    public String getOcuRemarks() {
        return ocuRemarks;
    }
    public void setOcuRemarks(String ocuRemarks) {
        this.ocuRemarks = ocuRemarks;
    }
    public CheckStatus getOfcCheckResult() {
        return ofcCheckResult;
    }
    public void setOfcCheckResult(CheckStatus ofcCheckResult) {
        this.ofcCheckResult = ofcCheckResult;
    }
    public String getOfcRemarks() {
        return ofcRemarks;
    }
    public void setOfcRemarks(String ofcRemarks) {
        this.ofcRemarks = ofcRemarks;
    }
    public CheckStatus getCmuCheckResult() {
        return cmuCheckResult;
    }
    public void setCmuCheckResult(CheckStatus cmuCheckResult) {
        this.cmuCheckResult = cmuCheckResult;
    }
    public String getCmuRemarks() {
        return cmuRemarks;
    }
    public void setCmuRemarks(String cmuRemarks) {
        this.cmuRemarks = cmuRemarks;
    }
    public CheckResult getMcbaCheckResult() {
        return mcbaCheckResult;
    }
    public void setMcbaCheckResult(CheckResult mcbaCheckResult) {
        this.mcbaCheckResult = mcbaCheckResult;
    }
    public String getMcbaRemarks() {
        return mcbaRemarks;
    }
    public void setMcbaRemarks(String mcbaRemarks) {
        this.mcbaRemarks = mcbaRemarks;
    }
    public CheckResult getCba1CheckResult() {
        return cba1CheckResult;
    }
    public void setCba1CheckResult(CheckResult cba1CheckResult) {
        this.cba1CheckResult = cba1CheckResult;
    }
    public String getCba1Remarks() {
        return cba1Remarks;
    }
    public void setCba1Remarks(String cba1Remarks) {
        this.cba1Remarks = cba1Remarks;
    }
    public CheckResult getCba2CheckResult() {
        return cba2CheckResult;
    }
    public void setCba2CheckResult(CheckResult cba2CheckResult) {
        this.cba2CheckResult = cba2CheckResult;
    }
    public String getCba2Remarks() {
        return cba2Remarks;
    }
    public void setCba2Remarks(String cba2Remarks) {
        this.cba2Remarks = cba2Remarks;
    }
    public CheckResult getCba3CheckResult() {
        return cba3CheckResult;
    }
    public void setCba3CheckResult(CheckResult cba3CheckResult) {
        this.cba3CheckResult = cba3CheckResult;
    }
    public String getCba3Remarks() {
        return cba3Remarks;
    }
    public void setCba3Remarks(String cba3Remarks) {
        this.cba3Remarks = cba3Remarks;
    }
    public CheckResult getCbae1CheckResult() {
        return cbae1CheckResult;
    }
    public void setCbae1CheckResult(CheckResult cbae1CheckResult) {
        this.cbae1CheckResult = cbae1CheckResult;
    }
    public String getCbae1Remarks() {
        return cbae1Remarks;
    }
    public void setCbae1Remarks(String cbae1Remarks) {
        this.cbae1Remarks = cbae1Remarks;
    }
    public CheckResult getMcbbCheckResult() {
        return mcbbCheckResult;
    }
    public void setMcbbCheckResult(CheckResult mcbbCheckResult) {
        this.mcbbCheckResult = mcbbCheckResult;
    }
    public String getMcbbRemarks() {
        return mcbbRemarks;
    }
    public void setMcbbRemarks(String mcbbRemarks) {
        this.mcbbRemarks = mcbbRemarks;
    }
    public CheckResult getCbb1v35CheckResult() {
        return cbb1v35CheckResult;
    }
    public void setCbb1v35CheckResult(CheckResult cbb1v35CheckResult) {
        this.cbb1v35CheckResult = cbb1v35CheckResult;
    }
    public String getCbb1v35Remarks() {
        return cbb1v35Remarks;
    }
    public void setCbb1v35Remarks(String cbb1v35Remarks) {
        this.cbb1v35Remarks = cbb1v35Remarks;
    }
    public CheckResult getCbb2v35CheckResult() {
        return cbb2v35CheckResult;
    }
    public void setCbb2v35CheckResult(CheckResult cbb2v35CheckResult) {
        this.cbb2v35CheckResult = cbb2v35CheckResult;
    }
    public String getCbb2v35Remarks() {
        return cbb2v35Remarks;
    }
    public void setCbb2v35Remarks(String cbb2v35Remarks) {
        this.cbb2v35Remarks = cbb2v35Remarks;
    }
    public CheckResult getCbb3v35CheckResult() {
        return cbb3v35CheckResult;
    }
    public void setCbb3v35CheckResult(CheckResult cbb3v35CheckResult) {
        this.cbb3v35CheckResult = cbb3v35CheckResult;
    }
    public String getCbb3v35Remarks() {
        return cbb3v35Remarks;
    }
    public void setCbb3v35Remarks(String cbb3v35Remarks) {
        this.cbb3v35Remarks = cbb3v35Remarks;
    }
    public CheckResult getCbb1v24CheckResult() {
        return cbb1v24CheckResult;
    }
    public void setCbb1v24CheckResult(CheckResult cbb1v24CheckResult) {
        this.cbb1v24CheckResult = cbb1v24CheckResult;
    }
    public String getCbb1v24Remarks() {
        return cbb1v24Remarks;
    }
    public void setCbb1v24Remarks(String cbb1v24Remarks) {
        this.cbb1v24Remarks = cbb1v24Remarks;
    }
    public CheckResult getCbb2v24CheckResult() {
        return cbb2v24CheckResult;
    }
    public void setCbb2v24CheckResult(CheckResult cbb2v24CheckResult) {
        this.cbb2v24CheckResult = cbb2v24CheckResult;
    }
    public String getCbb2v24Remarks() {
        return cbb2v24Remarks;
    }
    public void setCbb2v24Remarks(String cbb2v24Remarks) {
        this.cbb2v24Remarks = cbb2v24Remarks;
    }
    public CheckResult getCbb3v24CheckResult() {
        return cbb3v24CheckResult;
    }
    public void setCbb3v24CheckResult(CheckResult cbb3v24CheckResult) {
        this.cbb3v24CheckResult = cbb3v24CheckResult;
    }
    public String getCbb3v24Remarks() {
        return cbb3v24Remarks;
    }
    public void setCbb3v24Remarks(String cbb3v24Remarks) {
        this.cbb3v24Remarks = cbb3v24Remarks;
    }
    public CheckResult getCbbe1CheckResult() {
        return cbbe1CheckResult;
    }
    public void setCbbe1CheckResult(CheckResult cbbe1CheckResult) {
        this.cbbe1CheckResult = cbbe1CheckResult;
    }
    public String getCbbe1Remarks() {
        return cbbe1Remarks;
    }
    public void setCbbe1Remarks(String cbbe1Remarks) {
        this.cbbe1Remarks = cbbe1Remarks;
    }
    public CheckStatus getV35icCheckResult() {
        return v35icCheckResult;
    }
    public void setV35icCheckResult(CheckStatus v35icCheckResult) {
        this.v35icCheckResult = v35icCheckResult;
    }
    public String getV35icRemarks() {
        return v35icRemarks;
    }
    public void setV35icRemarks(String v35icRemarks) {
        this.v35icRemarks = v35icRemarks;
    }
    public CheckStatus getV24icCheckResult() {
        return v24icCheckResult;
    }
    public void setV24icCheckResult(CheckStatus v24icCheckResult) {
        this.v24icCheckResult = v24icCheckResult;
    }
    public String getV24icRemarks() {
        return v24icRemarks;
    }
    public void setV24icRemarks(String v24icRemarks) {
        this.v24icRemarks = v24icRemarks;
    }
    public String getMonthLrs() {
        return monthLrs;
    }
    public void setMonthLrs(String monthLrs) {
        this.monthLrs = monthLrs;
    }
    public String getMonthLas() {
        return monthLas;
    }
    public void setMonthLas(String monthLas) {
        this.monthLas = monthLas;
    }
    public String getMonthLcs() {
        return monthLcs;
    }
    public void setMonthLcs(String monthLcs) {
        this.monthLcs = monthLcs;
    }
    public String getMonthLfs() {
        return monthLfs;
    }
    public void setMonthLfs(String monthLfs) {
        this.monthLfs = monthLfs;
    }
    public String getMonthLcsc() {
        return monthLcsc;
    }
    public void setMonthLcsc(String monthLcsc) {
        this.monthLcsc = monthLcsc;
    }
    public CheckResult getUnderTlDlwrCheckResult() {
        return underTlDlwrCheckResult;
    }
    public void setUnderTlDlwrCheckResult(CheckResult underTlDlwrCheckResult) {
        this.underTlDlwrCheckResult = underTlDlwrCheckResult;
    }
    public String getUnderTlDlwrRemarks() {
        return underTlDlwrRemarks;
    }
    public void setUnderTlDlwrRemarks(String underTlDlwrRemarks) {
        this.underTlDlwrRemarks = underTlDlwrRemarks;
    }
    public CheckResult getFfTlDlwrCheckResult() {
        return ffTlDlwrCheckResult;
    }
    public void setFfTlDlwrCheckResult(CheckResult ffTlDlwrCheckResult) {
        this.ffTlDlwrCheckResult = ffTlDlwrCheckResult;
    }
    public String getFfTlDlwrRemarks() {
        return ffTlDlwrRemarks;
    }
    public void setFfTlDlwrRemarks(String ffTlDlwrRemarks) {
        this.ffTlDlwrRemarks = ffTlDlwrRemarks;
    }
    public CheckResult getFsTlDlwrCheckResult() {
        return fsTlDlwrCheckResult;
    }
    public void setFsTlDlwrCheckResult(CheckResult fsTlDlwrCheckResult) {
        this.fsTlDlwrCheckResult = fsTlDlwrCheckResult;
    }
    public String getFsTlDlwrRemarks() {
        return fsTlDlwrRemarks;
    }
    public void setFsTlDlwrRemarks(String fsTlDlwrRemarks) {
        this.fsTlDlwrRemarks = fsTlDlwrRemarks;
    }
    public CheckResult getFtTlDlwrCheckResult() {
        return ftTlDlwrCheckResult;
    }
    public void setFtTlDlwrCheckResult(CheckResult ftTlDlwrCheckResult) {
        this.ftTlDlwrCheckResult = ftTlDlwrCheckResult;
    }
    public String getFtTlDlwrRemarks() {
        return ftTlDlwrRemarks;
    }
    public void setFtTlDlwrRemarks(String ftTlDlwrRemarks) {
        this.ftTlDlwrRemarks = ftTlDlwrRemarks;
    }
    public CheckResult getFfoTlDlwrCheckResult() {
        return ffoTlDlwrCheckResult;
    }
    public void setFfoTlDlwrCheckResult(CheckResult ffoTlDlwrCheckResult) {
        this.ffoTlDlwrCheckResult = ffoTlDlwrCheckResult;
    }
    public String getFfoTlDlwrRemarks() {
        return ffoTlDlwrRemarks;
    }
    public void setFfoTlDlwrRemarks(String ffoTlDlwrRemarks) {
        this.ffoTlDlwrRemarks = ffoTlDlwrRemarks;
    }
    public CheckResult getFfiTlDlwrCheckResult() {
        return ffiTlDlwrCheckResult;
    }
    public void setFfiTlDlwrCheckResult(CheckResult ffiTlDlwrCheckResult) {
        this.ffiTlDlwrCheckResult = ffiTlDlwrCheckResult;
    }
    public String getFfiTlDlwrRemarks() {
        return ffiTlDlwrRemarks;
    }
    public void setFfiTlDlwrRemarks(String ffiTlDlwrRemarks) {
        this.ffiTlDlwrRemarks = ffiTlDlwrRemarks;
    }
    public CheckResult getFsiTlDlwrCheckResult() {
        return fsiTlDlwrCheckResult;
    }
    public void setFsiTlDlwrCheckResult(CheckResult fsiTlDlwrCheckResult) {
        this.fsiTlDlwrCheckResult = fsiTlDlwrCheckResult;
    }
    public String getFsiTlDlwrRemarks() {
        return fsiTlDlwrRemarks;
    }
    public void setFsiTlDlwrRemarks(String fsiTlDlwrRemarks) {
        this.fsiTlDlwrRemarks = fsiTlDlwrRemarks;
    }
    
    
}
