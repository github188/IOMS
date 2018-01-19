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
 * 空调设备巡检内容实体
 * @author renyujuan
 *
 */
@Entity
@Table(name="TB_OM_DUTY_ACC_CHECK_CONTENT")
public class AccCheckContent extends MyStringUUIDEntity {

    private static final long serialVersionUID = 1L;

    /*主风机转动*/
    private CheckResult mfrStatus;
    private String mfrRemarks;
    /*过滤网*/
    private CheckResult fsStatus;
    private String fsRemarks;
    /*凝结水盘和凝结水管*/
    private CheckResult cwppStatus;
    private String cwppRemarks;
    /*蒸发器翅片*/
    private CheckResult efStatus;
    private String efRemarks;
    /*设备表面*/
    private CheckResult esStatus;
    private String esRemarks;
    /*设备周围环境*/
    private CheckResult eeStatus;
    private String eeRemarks;
    /*水盘*/
    private CheckResult wpStatus;
    private String wpRemarks;
    /*加湿器水位和水漂*/
    private CheckResult hwlwStatus;
    private String hwlwRemarks;
    /*空调出风口风速*/
    private CheckResult acwsStatus;
    private String acwsRemarks;
    /*空调出风口温度*/
    private CheckResult actStatus;
    private String actRemarks;
    /*空调总接线电压、电流 空调内部压缩机、主风机、室外机电流*/
    private CheckResult acvcStatus;
    private String acvcRemarks;
    /*上下排水管线路、水滤网*/
    private CheckResult dplWfStatus;
    private String dplWfRemarks;
    /*视镜*/
    private CheckResult mirrorStatus;
    private String mirrorRemarks;
    /*吸排气压力*/
    private CheckResult sepStatus;
    private String sepRemarks;
    /*制冷管*/
    private CheckResult rpStatus;
    private String rpRemarks;
    /*压缩机工作电流*/
    private CheckResult cocStatus;
    private String cocRemarks;
    /*室外空调组内制冷剂压力*/
    private CheckResult oacuprStatus;
    private String oacurpRemarks;
    /*电机轴承及风扇*/
    private CheckResult mbfStatus;
    private String mbfRemarks;
    /*冷凝器散热翅片*/
    private CheckResult chrfStatus;
    private String chrfRemarks;
    /*水盘和水漂*/
    private CheckResult wpbStatus;
    private String wpbRemarks;
    /*储水盒、排水管*/
    private CheckResult wsbDpStatus;
    private String wsbDpRemarks;
    /*空调加湿情况*/
    private CheckResult achStatus;
    private String achRemarks;
    /*加湿器工作电流*/
    private CheckResult hwcStatus;
    private String hwcRemarks;
    /*供电电气线路*/
    private CheckResult pslStatus;
    private String pslRemarks;
    /*接线*/
    private CheckResult connStatus;
    private String connRemarks;
    /*电气控制部分*/
    private CheckResult ecpStatus;
    private String ecpRemarks;
    /*所有继电器触点、电气元件*/
    private CheckResult rcEcStatus;
    private String rcEcRemarks;
    /*加湿罐*/
    private CheckResult htStatus;
    private String htRemarks;
    /*凝结水管*/
    private CheckResult cpStatus;
    private String cpRemarks;
    /*环境设备巡检表*/
    private EnvironmentEquipCheck accCheck;
    @Enumerated(EnumType.STRING)
    @Column(name="MFR_STATUS")
    public CheckResult getMfrStatus() {
        return mfrStatus;
    }
    public void setMfrStatus(CheckResult mfrStatus) {
        this.mfrStatus = mfrStatus;
    }
    @Column(name="MFR_REMARKS")
    public String getMfrRemarks() {
        return mfrRemarks;
    }
    public void setMfrRemarks(String mfrRemarks) {
        this.mfrRemarks = mfrRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="FS_STATUS")
    public CheckResult getFsStatus() {
        return fsStatus;
    }
    public void setFsStatus(CheckResult fsStatus) {
        this.fsStatus = fsStatus;
    }
    @Column(name="FS_REMARKS")
    public String getFsRemarks() {
        return fsRemarks;
    }
    public void setFsRemarks(String fsRemarks) {
        this.fsRemarks = fsRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CWPP_STATUS")
    public CheckResult getCwppStatus() {
        return cwppStatus;
    }
    public void setCwppStatus(CheckResult cwppStatus) {
        this.cwppStatus = cwppStatus;
    }
    @Column(name="CWPP_REMARKS")
    public String getCwppRemarks() {
        return cwppRemarks;
    }
    public void setCwppRemarks(String cwppRemarks) {
        this.cwppRemarks = cwppRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="EF_STATUS")
    public CheckResult getEfStatus() {
        return efStatus;
    }
    public void setEfStatus(CheckResult efStatus) {
        this.efStatus = efStatus;
    }
    @Column(name="EF_REMARKS")
    public String getEfRemarks() {
        return efRemarks;
    }
    public void setEfRemarks(String efRemarks) {
        this.efRemarks = efRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ES_STATUS")
    public CheckResult getEsStatus() {
        return esStatus;
    }
    public void setEsStatus(CheckResult esStatus) {
        this.esStatus = esStatus;
    }
    @Column(name="ES_REMARKS")
    public String getEsRemarks() {
        return esRemarks;
    }
    public void setEsRemarks(String esRemarks) {
        this.esRemarks = esRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="EE_STATUS")
    public CheckResult getEeStatus() {
        return eeStatus;
    }
    public void setEeStatus(CheckResult eeStatus) {
        this.eeStatus = eeStatus;
    }
    @Column(name="EE_REMARKS")
    public String getEeRemarks() {
        return eeRemarks;
    }
    public void setEeRemarks(String eeRemarks) {
        this.eeRemarks = eeRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="WP_STATUS")
    public CheckResult getWpStatus() {
        return wpStatus;
    }
    public void setWpStatus(CheckResult wpStatus) {
        this.wpStatus = wpStatus;
    }
    @Column(name="WP_REMARKS")
    public String getWpRemarks() {
        return wpRemarks;
    }
    public void setWpRemarks(String wpRemarks) {
        this.wpRemarks = wpRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HWLW_STATUS")
    public CheckResult getHwlwStatus() {
        return hwlwStatus;
    }
    public void setHwlwStatus(CheckResult hwlwStatus) {
        this.hwlwStatus = hwlwStatus;
    }
    @Column(name="HWLW_REMARKS")
    public String getHwlwRemarks() {
        return hwlwRemarks;
    }
    public void setHwlwRemarks(String hwlwRemarks) {
        this.hwlwRemarks = hwlwRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ACWS_STATUS")
    public CheckResult getAcwsStatus() {
        return acwsStatus;
    }
    public void setAcwsStatus(CheckResult acwsStatus) {
        this.acwsStatus = acwsStatus;
    }
    @Column(name="ACWS_REMARKS")
    public String getAcwsRemarks() {
        return acwsRemarks;
    }
    public void setAcwsRemarks(String acwsRemarks) {
        this.acwsRemarks = acwsRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ACT_STATUS")
    public CheckResult getActStatus() {
        return actStatus;
    }
    public void setActStatus(CheckResult actStatus) {
        this.actStatus = actStatus;
    }
    @Column(name="ACT_REMARKS")
    public String getActRemarks() {
        return actRemarks;
    }
    public void setActRemarks(String actRemarks) {
        this.actRemarks = actRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ACVC_STATUS")
    public CheckResult getAcvcStatus() {
        return acvcStatus;
    }
    public void setAcvcStatus(CheckResult acvcStatus) {
        this.acvcStatus = acvcStatus;
    }
    @Column(name="ACVC_REMARKS")
    public String getAcvcRemarks() {
        return acvcRemarks;
    }
    public void setAcvcRemarks(String acvcRemarks) {
        this.acvcRemarks = acvcRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="DPL_WF_STATUS")
    public CheckResult getDplWfStatus() {
        return dplWfStatus;
    }
    public void setDplWfStatus(CheckResult dplWfStatus) {
        this.dplWfStatus = dplWfStatus;
    }
    @Column(name="DPL_WF_REMARKS")
    public String getDplWfRemarks() {
        return dplWfRemarks;
    }
    public void setDplWfRemarks(String dplWfRemarks) {
        this.dplWfRemarks = dplWfRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="MIRROR_STATUS")
    public CheckResult getMirrorStatus() {
        return mirrorStatus;
    }
    public void setMirrorStatus(CheckResult mirrorStatus) {
        this.mirrorStatus = mirrorStatus;
    }
    @Column(name="MIRROR_REMARKS")
    public String getMirrorRemarks() {
        return mirrorRemarks;
    }
    public void setMirrorRemarks(String mirrorRemarks) {
        this.mirrorRemarks = mirrorRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="SEP_STATUS")
    public CheckResult getSepStatus() {
        return sepStatus;
    }
    public void setSepStatus(CheckResult sepStatus) {
        this.sepStatus = sepStatus;
    }
    @Column(name="SEP_REMARKS")
    public String getSepRemarks() {
        return sepRemarks;
    }
    public void setSepRemarks(String sepRemarks) {
        this.sepRemarks = sepRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="RP_STATUS")
    public CheckResult getRpStatus() {
        return rpStatus;
    }
    public void setRpStatus(CheckResult rpStatus) {
        this.rpStatus = rpStatus;
    }
    @Column(name="RP_REMARKS")
    public String getRpRemarks() {
        return rpRemarks;
    }
    public void setRpRemarks(String rpRemarks) {
        this.rpRemarks = rpRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="COC_STATUS")
    public CheckResult getCocStatus() {
        return cocStatus;
    }
    public void setCocStatus(CheckResult cocStatus) {
        this.cocStatus = cocStatus;
    }
    @Column(name="COC_REMARKS")
    public String getCocRemarks() {
        return cocRemarks;
    }
    public void setCocRemarks(String cocRemarks) {
        this.cocRemarks = cocRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="OACURP_STATUS")
    public CheckResult getOacuprStatus() {
        return oacuprStatus;
    }
    public void setOacuprStatus(CheckResult oacuprStatus) {
        this.oacuprStatus = oacuprStatus;
    }
    @Column(name="OACURP_REMARKS")
    public String getOacurpRemarks() {
        return oacurpRemarks;
    }
    public void setOacurpRemarks(String oacurpRemarks) {
        this.oacurpRemarks = oacurpRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="MB_F_STATUS")
    public CheckResult getMbfStatus() {
        return mbfStatus;
    }
    public void setMbfStatus(CheckResult mbfStatus) {
        this.mbfStatus = mbfStatus;
    }
    @Column(name="MB_F_REMARKS")
    public String getMbfRemarks() {
        return mbfRemarks;
    }
    public void setMbfRemarks(String mbfRemarks) {
        this.mbfRemarks = mbfRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CHRF_STATUS")
    public CheckResult getChrfStatus() {
        return chrfStatus;
    }
    public void setChrfStatus(CheckResult chrfStatus) {
        this.chrfStatus = chrfStatus;
    }
    @Column(name="CHRF_REMARKS")
    public String getChrfRemarks() {
        return chrfRemarks;
    }
    public void setChrfRemarks(String chrfRemarks) {
        this.chrfRemarks = chrfRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="WPB_STATUS")
    public CheckResult getWpbStatus() {
        return wpbStatus;
    }
    public void setWpbStatus(CheckResult wpbStatus) {
        this.wpbStatus = wpbStatus;
    }
    @Column(name="WPB_REMARKS")
    public String getWpbRemarks() {
        return wpbRemarks;
    }
    public void setWpbRemarks(String wpbRemarks) {
        this.wpbRemarks = wpbRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="WSB_DP_STATUS")
    public CheckResult getWsbDpStatus() {
        return wsbDpStatus;
    }
    public void setWsbDpStatus(CheckResult wsbDpStatus) {
        this.wsbDpStatus = wsbDpStatus;
    }
    @Column(name="WSB_DP_REMARKS")
    public String getWsbDpRemarks() {
        return wsbDpRemarks;
    }
    public void setWsbDpRemarks(String wsbDpRemarks) {
        this.wsbDpRemarks = wsbDpRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ACH_STATUS")
    public CheckResult getAchStatus() {
        return achStatus;
    }
    public void setAchStatus(CheckResult achStatus) {
        this.achStatus = achStatus;
    }
    @Column(name="ACH_REMARKS")
    public String getAchRemarks() {
        return achRemarks;
    }
    public void setAchRemarks(String achRemarks) {
        this.achRemarks = achRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HWC_STATUS")
    public CheckResult getHwcStatus() {
        return hwcStatus;
    }
    public void setHwcStatus(CheckResult hwcStatus) {
        this.hwcStatus = hwcStatus;
    }
    @Column(name="HWC_REMARKS")
    public String getHwcRemarks() {
        return hwcRemarks;
    }
    public void setHwcRemarks(String hwcRemarks) {
        this.hwcRemarks = hwcRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="PSL_STATUS")
    public CheckResult getPslStatus() {
        return pslStatus;
    }
    public void setPslStatus(CheckResult pslStatus) {
        this.pslStatus = pslStatus;
    }
    @Column(name="PSL_REMARKS")
    public String getPslRemarks() {
        return pslRemarks;
    }
    public void setPslRemarks(String pslRemarks) {
        this.pslRemarks = pslRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CONN_STATUS")
    public CheckResult getConnStatus() {
        return connStatus;
    }
    public void setConnStatus(CheckResult connStatus) {
        this.connStatus = connStatus;
    }
    @Column(name="CONN_REMARKS")
    public String getConnRemarks() {
        return connRemarks;
    }
    public void setConnRemarks(String connRemarks) {
        this.connRemarks = connRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="ECP_STATUS")
    public CheckResult getEcpStatus() {
        return ecpStatus;
    }
    public void setEcpStatus(CheckResult ecpStatus) {
        this.ecpStatus = ecpStatus;
    }
    @Column(name="ECP_REMARKS")
    public String getEcpRemarks() {
        return ecpRemarks;
    }
    public void setEcpRemarks(String ecpRemarks) {
        this.ecpRemarks = ecpRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="RC_EC_STATUS")
    public CheckResult getRcEcStatus() {
        return rcEcStatus;
    }
    public void setRcEcStatus(CheckResult rcEcStatus) {
        this.rcEcStatus = rcEcStatus;
    }
    @Column(name="RC_EC_REMARKS")
    public String getRcEcRemarks() {
        return rcEcRemarks;
    }
    public void setRcEcRemarks(String rcEcRemarks) {
        this.rcEcRemarks = rcEcRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="HT_STATUS")
    public CheckResult getHtStatus() {
        return htStatus;
    }
    public void setHtStatus(CheckResult htStatus) {
        this.htStatus = htStatus;
    }
    @Column(name="HT_REMARKS")
    public String getHtRemarks() {
        return htRemarks;
    }
    public void setHtRemarks(String htRemarks) {
        this.htRemarks = htRemarks;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="CP_STATUS")
    public CheckResult getCpStatus() {
        return cpStatus;
    }
    public void setCpStatus(CheckResult cpStatus) {
        this.cpStatus = cpStatus;
    }
    @Column(name="CP_REMARKS")
    public String getCpRemarks() {
        return cpRemarks;
    }
    public void setCpRemarks(String cpRemarks) {
        this.cpRemarks = cpRemarks;
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
