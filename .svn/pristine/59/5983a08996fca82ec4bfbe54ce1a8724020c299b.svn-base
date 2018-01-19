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
 * 系统测量
 * @author duanyanlin
 * @date 2016年7月6日下午3:07:52
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_SYS_MEA")
public class SystemMeasure extends MyStringUUIDEntity {

	/**
	 * @date 2016年7月6日 下午3:08:54
	 */
	private static final long serialVersionUID = 1L;
	
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
	//-----其他信息------//
	private EnvironmentEquipCheck upsCheck;
	
	@Column(name="PV_A_N_DIS_OUT_VALUE")
	public String getPvANDisOutValue() {
		return pvANDisOutValue;
	}
	public void setPvANDisOutValue(String pvANDisOutValue) {
		this.pvANDisOutValue = pvANDisOutValue;
	}
	@Column(name="PV_A_N_MEA_IN_VALUE")
	public String getPvANMeaInValue() {
		return pvANMeaInValue;
	}
	public void setPvANMeaInValue(String pvANMeaInValue) {
		this.pvANMeaInValue = pvANMeaInValue;
	}
	@Column(name="PV_A_N_MEA_OUT_VALUE")
	public String getPvANMeaOutValue() {
		return pvANMeaOutValue;
	}
	public void setPvANMeaOutValue(String pvANMeaOutValue) {
		this.pvANMeaOutValue = pvANMeaOutValue;
	}
	@Column(name="PV_A_N_REMARK")
	public String getPvANRemark() {
		return pvANRemark;
	}
	public void setPvANRemark(String pvANRemark) {
		this.pvANRemark = pvANRemark;
	}
	@Column(name="PV_B_N_DIS_OUT_VALUE")
	public String getPvBNDisOutValue() {
		return pvBNDisOutValue;
	}
	public void setPvBNDisOutValue(String pvBNDisOutValue) {
		this.pvBNDisOutValue = pvBNDisOutValue;
	}
	
	@Column(name="PV_B_N_MEA_IN_VALUE")
	public String getPvBNMeaInValue() {
		return pvBNMeaInValue;
	}
	public void setPvBNMeaInValue(String pvBNMeaInValue) {
		this.pvBNMeaInValue = pvBNMeaInValue;
	}
	
	@Column(name="PV_B_N_MEA_OUT_VALUE")
	public String getPvBNMeaOutValue() {
		return pvBNMeaOutValue;
	}
	public void setPvBNMeaOutValue(String pvBNMeaOutValue) {
		this.pvBNMeaOutValue = pvBNMeaOutValue;
	}
	
	@Column(name="PV_B_N_REMARK")
	public String getPvBNRemark() {
		return pvBNRemark;
	}
	public void setPvBNRemark(String pvBNRemark) {
		this.pvBNRemark = pvBNRemark;
	}
	
	@Column(name="PV_C_N_DIS_OUT_VALUE")
	public String getPvCNDisOutValue() {
		return pvCNDisOutValue;
	}
	public void setPvCNDisOutValue(String pvCNDisOutValue) {
		this.pvCNDisOutValue = pvCNDisOutValue;
	}
	
	@Column(name="PV_C_N_MEA_IN_VALUE")
	public String getPvCNMeaInValue() {
		return pvCNMeaInValue;
	}
	public void setPvCNMeaInValue(String pvCNMeaInValue) {
		this.pvCNMeaInValue = pvCNMeaInValue;
	}
	
	@Column(name="PV_C_N_MEA_OUT_VALUE")
	public String getPvCNMeaOutValue() {
		return pvCNMeaOutValue;
	}
	public void setPvCNMeaOutValue(String pvCNMeaOutValue) {
		this.pvCNMeaOutValue = pvCNMeaOutValue;
	}
	
	@Column(name="PV_C_N_REMARK")
	public String getPvCNRemark() {
		return pvCNRemark;
	}
	public void setPvCNRemark(String pvCNRemark) {
		this.pvCNRemark = pvCNRemark;
	}
	@Column(name="LV_A_B_DIS_OUT_VALUE")
	public String getLvABDisOutValue() {
		return lvABDisOutValue;
	}
	public void setLvABDisOutValue(String lvABDisOutValue) {
		this.lvABDisOutValue = lvABDisOutValue;
	}
	
	@Column(name="LV_A_B_MEA_IN_VALUE")
	public String getLvABMeaInValue() {
		return lvABMeaInValue;
	}
	public void setLvABMeaInValue(String lvABMeaInValue) {
		this.lvABMeaInValue = lvABMeaInValue;
	}
	
	@Column(name="LV_A_B_MEA_OUT_VALUE")
	public String getLvABMeaOutValue() {
		return lvABMeaOutValue;
	}
	public void setLvABMeaOutValue(String lvABMeaOutValue) {
		this.lvABMeaOutValue = lvABMeaOutValue;
	}
	
	@Column(name="LV_A_B_REAMRK")
	public String getLvABRemark() {
		return lvABRemark;
	}
	public void setLvABRemark(String lvABRemark) {
		this.lvABRemark = lvABRemark;
	}
	
	@Column(name="LV_A_C_DIS_OUT_VALUE")
	public String getLvACDisOutValue() {
		return lvACDisOutValue;
	}
	public void setLvACDisOutValue(String lvACDisOutValue) {
		this.lvACDisOutValue = lvACDisOutValue;
	}
	
	@Column(name="LV_A_C_MEA_IN_VALUE")
	public String getLvACMeaInValue() {
		return lvACMeaInValue;
	}
	public void setLvACMeaInValue(String lvACMeaInValue) {
		this.lvACMeaInValue = lvACMeaInValue;
	}
	
	@Column(name="LV_A_C_MEA_OUT_VALUE")
	public String getLvACMeaOutValue() {
		return lvACMeaOutValue;
	}
	public void setLvACMeaOutValue(String lvACMeaOutValue) {
		this.lvACMeaOutValue = lvACMeaOutValue;
	}
	
	@Column(name="LV_A_C_REAMRK")
	public String getLvACRemark() {
		return lvACRemark;
	}
	public void setLvACRemark(String lvACRemark) {
		this.lvACRemark = lvACRemark;
	}
	
	@Column(name="LV_B_C_DIS_OUT_VALUE")
	public String getLvBCDisOutValue() {
		return lvBCDisOutValue;
	}
	public void setLvBCDisOutValue(String lvBCDisOutValue) {
		this.lvBCDisOutValue = lvBCDisOutValue;
	}
	
	@Column(name="LV_B_C_MEA_IN_VALUE")
	public String getLvBCMeaInValue() {
		return lvBCMeaInValue;
	}
	public void setLvBCMeaInValue(String lvBCMeaInValue) {
		this.lvBCMeaInValue = lvBCMeaInValue;
	}
	
	@Column(name="LV_B_C_MEA_OUT_VALUE")
	public String getLvBCMeaOutValue() {
		return lvBCMeaOutValue;
	}
	public void setLvBCMeaOutValue(String lvBCMeaOutValue) {
		this.lvBCMeaOutValue = lvBCMeaOutValue;
	}
	
	@Column(name="LV_B_C_REAMRK")
	public String getLvBCRemark() {
		return lvBCRemark;
	}
	public void setLvBCRemark(String lvBCRemark) {
		this.lvBCRemark = lvBCRemark;
	}
	
	@Column(name="PC_A_DIS_OUT_VALUE")
	public String getPcADisOutValue() {
		return pcADisOutValue;
	}
	public void setPcADisOutValue(String pcADisOutValue) {
		this.pcADisOutValue = pcADisOutValue;
	}
	
	@Column(name="PC_A_MEA_IN_VALUE")
	public String getPcAMeaInValue() {
		return pcAMeaInValue;
	}
	public void setPcAMeaInValue(String pcAMeaInValue) {
		this.pcAMeaInValue = pcAMeaInValue;
	}
	
	@Column(name="PC_A_MEA_OUT_VALUE")
	public String getPcAMeaOutValue() {
		return pcAMeaOutValue;
	}
	public void setPcAMeaOutValue(String pcAMeaOutValue) {
		this.pcAMeaOutValue = pcAMeaOutValue;
	}
	
	@Column(name="PC_A_REMARK")
	public String getPcARemark() {
		return pcARemark;
	}
	public void setPcARemark(String pcARemark) {
		this.pcARemark = pcARemark;
	}
	
	@Column(name="PC_B_DIS_OUT_VALUE")
	public String getPcBDisOutValue() {
		return pcBDisOutValue;
	}
	public void setPcBDisOutValue(String pcBDisOutValue) {
		this.pcBDisOutValue = pcBDisOutValue;
	}
	
	@Column(name="PC_B_MEA_IN_VALUE")
	public String getPcBMeaInValue() {
		return pcBMeaInValue;
	}
	public void setPcBMeaInValue(String pcBMeaInValue) {
		this.pcBMeaInValue = pcBMeaInValue;
	}
	
	@Column(name="PC_B_MEA_OUT_VALUE")
	public String getPcBMeaOutValue() {
		return pcBMeaOutValue;
	}
	public void setPcBMeaOutValue(String pcBMeaOutValue) {
		this.pcBMeaOutValue = pcBMeaOutValue;
	}
	
	@Column(name="PC_B_REMARK")
	public String getPcBRemark() {
		return pcBRemark;
	}
	public void setPcBRemark(String pcBRemark) {
		this.pcBRemark = pcBRemark;
	}
	
	@Column(name="PC_C_DIS_OUT_VALUE")
	public String getPcCDisOutValue() {
		return pcCDisOutValue;
	}
	public void setPcCDisOutValue(String pcCDisOutValue) {
		this.pcCDisOutValue = pcCDisOutValue;
	}
	
	@Column(name="PC_C_MEA_IN_VALUE")
	public String getPcCMeaInValue() {
		return pcCMeaInValue;
	}
	public void setPcCMeaInValue(String pcCMeaInValue) {
		this.pcCMeaInValue = pcCMeaInValue;
	}
	
	@Column(name="PC_C_MEA_OUT_VALUE")
	public String getPcCMeaOutValue() {
		return pcCMeaOutValue;
	}
	public void setPcCMeaOutValue(String pcCMeaOutValue) {
		this.pcCMeaOutValue = pcCMeaOutValue;
	}
	
	@Column(name="PC_C_REMARK")
	public String getPcCRemark() {
		return pcCRemark;
	}
	public void setPcCRemark(String pcCRemark) {
		this.pcCRemark = pcCRemark;
	}
	
	@Column(name="PP_A_DIS_OUT_VALUE")
	public String getPpADisOutValue() {
		return ppADisOutValue;
	}
	public void setPpADisOutValue(String ppADisOutValue) {
		this.ppADisOutValue = ppADisOutValue;
	}
	
	@Column(name="PP_A_MEA_CAL_VALUE")
	public String getPpAMeaCalValue() {
		return ppAMeaCalValue;
	}
	public void setPpAMeaCalValue(String ppAMeaCalValue) {
		this.ppAMeaCalValue = ppAMeaCalValue;
	}
	
	@Column(name="PP_A_REMARK")
	public String getPpARemark() {
		return ppARemark;
	}
	public void setPpARemark(String ppARemark) {
		this.ppARemark = ppARemark;
	}
	
	@Column(name="PP_B_DIS_OUT_VALUE")
	public String getPpBDisOutValue() {
		return ppBDisOutValue;
	}
	public void setPpBDisOutValue(String ppBDisOutValue) {
		this.ppBDisOutValue = ppBDisOutValue;
	}
	
	@Column(name="PP_B_MEA_CAL_VALUE")
	public String getPpBMeaCalValue() {
		return ppBMeaCalValue;
	}
	public void setPpBMeaCalValue(String ppBMeaCalValue) {
		this.ppBMeaCalValue = ppBMeaCalValue;
	}
	
	@Column(name="PP_B_REMARK")
	public String getPpBRemark() {
		return ppBRemark;
	}
	public void setPpBRemark(String ppBRemark) {
		this.ppBRemark = ppBRemark;
	}
	
	@Column(name="PP_C_DIS_OUT_VALUE")
	public String getPpCDisOutValue() {
		return ppCDisOutValue;
	}
	public void setPpCDisOutValue(String ppCDisOutValue) {
		this.ppCDisOutValue = ppCDisOutValue;
	}
	
	@Column(name="PP_C_MEA_CAL_VALUE")
	public String getPpCMeaCalValue() {
		return ppCMeaCalValue;
	}
	public void setPpCMeaCalValue(String ppCMeaCalValue) {
		this.ppCMeaCalValue = ppCMeaCalValue;
	}
	
	@Column(name="PP_C_REMARK")
	public String getPpCRemark() {
		return ppCRemark;
	}
	public void setPpCRemark(String ppCRemark) {
		this.ppCRemark = ppCRemark;
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
