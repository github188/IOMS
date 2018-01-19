package cn.com.atnc.ioms.entity.duty.environment.acc;

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
 * 空调设备数据记录实体类
 * @author renyujuan
 * @date 2016年8月11日上午8:23:28
 */
@Entity
@Table(name="TB_OM_DUTY_ACC_DATA_RECORD")
public class AccDataRecord extends MyStringUUIDEntity {

    private static final long serialVersionUID = 1L;
    
    /*总电压*/
    private String tvValue;
    private CheckResult tvStatus;
    private String tvRemarks;
    /*总电流*/
    private String tcValue;
    private CheckResult tcStatus;
    private String tcRemarks;
    /*压缩机电流*/
    private String ccValue;
    private CheckResult ccStatus;
    private String ccRemarks;
    /*一号压缩机电流*/
    private String cconeValue;
    private CheckResult cconeStatus;
    private String cconeRemarks;
    /*二号压缩机电流*/
    private String cctwoValue;
    private CheckResult cctwoStatus;
    private String cctwoRemarks;
    /*主风机电流*/
    private String mfcValue;
    private CheckResult mfcStatus;
    private String mfcRemarks;
    /*室外机电流*/
    private String omcValue;
    private CheckResult omcStatus;
    private String omcRemarks;
    /*出风口温湿度*/
    private String aothValue;
    private CheckResult aothStatus;
    private String aothRemarks;
    /*出风口风速*/
    private String aowsValue;
    private CheckResult aowsStatus;
    private String aowsRemarks;
    /*加湿器电流*/
    private String hcValue;
    private CheckResult hcStatus;
    private String hcRemarks;
    /*加湿器电流A*/
    private String hcaValue;
    private CheckResult hcaStatus;
    private String hcaRemarks;
    /*加湿器电流B*/
    private String hcbValue;
    private CheckResult hcbStatus;
    private String hcbRemarks;
    /*加湿器电流C*/
    private String hccValue;
    private CheckResult hccStatus;
    private String hccRemarks;
    /*环境设备巡检表*/
    private EnvironmentEquipCheck accCheck;
    
    @Column(name="TV_VALUE")
    public String getTvValue() {
        return tvValue;
    }
    public void setTvValue(String tvValue) {
        this.tvValue = tvValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="TV_STATUS")
    public CheckResult getTvStatus() {
        return tvStatus;
    }
    public void setTvStatus(CheckResult tvStatus) {
        this.tvStatus = tvStatus;
    }
    @Column(name="TV_REMARKS")
    public String getTvRemarks() {
        return tvRemarks;
    }
    public void setTvRemarks(String tvRemarks) {
        this.tvRemarks = tvRemarks;
    }
    @Column(name="TC_VALUE")
    public String getTcValue() {
        return tcValue;
    }
    public void setTcValue(String tcValue) {
        this.tcValue = tcValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="TC_STATUS")
    public CheckResult getTcStatus() {
        return tcStatus;
    }
    public void setTcStatus(CheckResult tcStatus) {
        this.tcStatus = tcStatus;
    }
    @Column(name="TC_REMARKS")
    public String getTcRemarks() {
        return tcRemarks;
    }
    public void setTcRemarks(String tcRemarks) {
        this.tcRemarks = tcRemarks;
    }
    @Column(name="CC_VALUE")
    public String getCcValue() {
        return ccValue;
    }
    public void setCcValue(String ccValue) {
        this.ccValue = ccValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CC_STATUS")
    public CheckResult getCcStatus() {
        return ccStatus;
    }
    public void setCcStatus(CheckResult ccStatus) {
        this.ccStatus = ccStatus;
    }
    @Column(name="CC_REMARKS")
    public String getCcRemarks() {
        return ccRemarks;
    }
    public void setCcRemarks(String ccRemarks) {
        this.ccRemarks = ccRemarks;
    }
    @Column(name="CCONE_VALUE")
    public String getCconeValue() {
        return cconeValue;
    }
    public void setCconeValue(String cconeValue) {
        this.cconeValue = cconeValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CCONE_STATUS")
    public CheckResult getCconeStatus() {
        return cconeStatus;
    }
    public void setCconeStatus(CheckResult cconeStatus) {
        this.cconeStatus = cconeStatus;
    }
    @Column(name="CCONE_REMARKS")
    public String getCconeRemarks() {
        return cconeRemarks;
    }
    public void setCconeRemarks(String cconeRemarks) {
        this.cconeRemarks = cconeRemarks;
    }
    @Column(name="CCTWO_VALUE")
    public String getCctwoValue() {
        return cctwoValue;
    }
    public void setCctwoValue(String cctwoValue) {
        this.cctwoValue = cctwoValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CCTWO_STATUS")
    public CheckResult getCctwoStatus() {
        return cctwoStatus;
    }
    public void setCctwoStatus(CheckResult cctwoStatus) {
        this.cctwoStatus = cctwoStatus;
    }
    @Column(name="CCTWO_REMARKS")
    public String getCctwoRemarks() {
        return cctwoRemarks;
    }
    public void setCctwoRemarks(String cctwoRemarks) {
        this.cctwoRemarks = cctwoRemarks;
    }
    @Column(name="MFC_VALUE")
    public String getMfcValue() {
        return mfcValue;
    }
    public void setMfcValue(String mfcValue) {
        this.mfcValue = mfcValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="MFC_STATUS")
    public CheckResult getMfcStatus() {
        return mfcStatus;
    }
    public void setMfcStatus(CheckResult mfcStatus) {
        this.mfcStatus = mfcStatus;
    }
    @Column(name="MFC_REMARKS")
    public String getMfcRemarks() {
        return mfcRemarks;
    }
    public void setMfcRemarks(String mfcRemarks) {
        this.mfcRemarks = mfcRemarks;
    }
    @Column(name="OMC_VALUE")
    public String getOmcValue() {
        return omcValue;
    }
    public void setOmcValue(String omcValue) {
        this.omcValue = omcValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="OMC_STATUS")
    public CheckResult getOmcStatus() {
        return omcStatus;
    }
    public void setOmcStatus(CheckResult omcStatus) {
        this.omcStatus = omcStatus;
    }
    @Column(name="OMC_REMARKS")
    public String getOmcRemarks() {
        return omcRemarks;
    }
    public void setOmcRemarks(String omcRemarks) {
        this.omcRemarks = omcRemarks;
    }
    @Column(name="AOTH_VALUE")
    public String getAothValue() {
        return aothValue;
    }
    public void setAothValue(String aothValue) {
        this.aothValue = aothValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="AOTH_STATUS")
    public CheckResult getAothStatus() {
        return aothStatus;
    }
    public void setAothStatus(CheckResult aothStatus) {
        this.aothStatus = aothStatus;
    }
    @Column(name="AOTH_REMARKS")
    public String getAothRemarks() {
        return aothRemarks;
    }
    public void setAothRemarks(String aothRemarks) {
        this.aothRemarks = aothRemarks;
    }
    @Column(name="AOWS_VALUE")
    public String getAowsValue() {
        return aowsValue;
    }
    public void setAowsValue(String aowsValue) {
        this.aowsValue = aowsValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="AOWS_STATUS")
    public CheckResult getAowsStatus() {
        return aowsStatus;
    }
    public void setAowsStatus(CheckResult aowsStatus) {
        this.aowsStatus = aowsStatus;
    }
    @Column(name="AOWS_REMARKS")
    public String getAowsRemarks() {
        return aowsRemarks;
    }
    public void setAowsRemarks(String aowsRemarks) {
        this.aowsRemarks = aowsRemarks;
    }
    @Column(name="HC_VALUE")
    public String getHcValue() {
        return hcValue;
    }
    public void setHcValue(String hcValue) {
        this.hcValue = hcValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HC_STATUS")
    public CheckResult getHcStatus() {
        return hcStatus;
    }
    public void setHcStatus(CheckResult hcStatus) {
        this.hcStatus = hcStatus;
    }
    @Column(name="HC_REMARKS")
    public String getHcRemarks() {
        return hcRemarks;
    }
    public void setHcRemarks(String hcRemarks) {
        this.hcRemarks = hcRemarks;
    }
    @Column(name="HCA_VALUE")
    public String getHcaValue() {
        return hcaValue;
    }
    public void setHcaValue(String hcaValue) {
        this.hcaValue = hcaValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HCA_STATUS")
    public CheckResult getHcaStatus() {
        return hcaStatus;
    }
    public void setHcaStatus(CheckResult hcaStatus) {
        this.hcaStatus = hcaStatus;
    }
    @Column(name="HCA_REMARKS")
    public String getHcaRemarks() {
        return hcaRemarks;
    }
    public void setHcaRemarks(String hcaRemarks) {
        this.hcaRemarks = hcaRemarks;
    }
    @Column(name="HCB_VALUE")
    public String getHcbValue() {
        return hcbValue;
    }
    public void setHcbValue(String hcbValue) {
        this.hcbValue = hcbValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HCB_STATUS")
    public CheckResult getHcbStatus() {
        return hcbStatus;
    }
    public void setHcbStatus(CheckResult hcbStatus) {
        this.hcbStatus = hcbStatus;
    }
    @Column(name="HCB_REMARKS")
    public String getHcbRemarks() {
        return hcbRemarks;
    }
    public void setHcbRemarks(String hcbRemarks) {
        this.hcbRemarks = hcbRemarks;
    }
    @Column(name="HCC_VALUE")
    public String getHccValue() {
        return hccValue;
    }
    public void setHccValue(String hccValue) {
        this.hccValue = hccValue;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HCC_STATUS")
    public CheckResult getHccStatus() {
        return hccStatus;
    }
    public void setHccStatus(CheckResult hccStatus) {
        this.hccStatus = hccStatus;
    }
    @Column(name="HCC_REMARKS")
    public String getHccRemarks() {
        return hccRemarks;
    }
    public void setHccRemarks(String hccRemarks) {
        this.hccRemarks = hccRemarks;
    }
    @ManyToOne
    @JoinColumn(name="ACC_CHECK_ID")
    public EnvironmentEquipCheck getAccCheck() {
        return accCheck;
    }
    public void setAccCheck(EnvironmentEquipCheck accCheck) {
        this.accCheck = accCheck;
    }
	
	
}
