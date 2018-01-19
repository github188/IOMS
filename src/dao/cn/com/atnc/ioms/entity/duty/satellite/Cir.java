package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 业务电路检查
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_CIR")
public class Cir extends MyStringUUIDEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tesBusiness;		//tes站业务电路
	private String tesFault;		//tes站故障电路
	private String pesBusiness;		//pes站业务电路
	private String pesFault;		//pes站故障电路
	private String ku1Business;		//ku子网1业务故障
	private String ku1Fault;		//ku子网1故障电路
	private String ku2Business;		//ku子网2业务电路
	private String ku2Fault;		//ku子网2故障电路
	private String ku3Business;		//ku子网3业务电路
	private String ku3Fault;		//ku子网3故障电路
	private String kuBusiness;		//中继网ku站业务电路
	private String kuFault;			//中继网ku站故障电路
	private String comBusiness;		//境外站业务电路
	private String comFault;		//境外站故障电路
	private String slhKuBusiness;	//十里河ku站业务电路
	private String slhKuFault;		//十里河ku站故障电路
	private String mhjTesBusiness;	//民航局tes业务电路
	private String mhjTesFault;		//民航局tes故障电路
	private String mhjKuBusiness;	//民航局ku站业务电路
	private String mhjKuFault;		//民航局ku站故障电路
	private String sumBusiness;		//汇总电路合计
	private String sumFault;		//汇总电路故障电路条数
	
	private String tesRemark;
	private String pesRemark;
	private String kuNet1Remark;	
	private String kuNet2Remark;	
	private String kuNet3Remark;	
	private String kuRemark;		
	private String comRemark;		
	private String slhKuRemark;		
	private String mhjTesReamrk;	
	private String mhjKuRemark;		
	private String sumRemark;		
	
	private EnvironmentEquipCheck checkid;// 巡检id
	
	
	@ManyToOne
	@JoinColumn(name = "checkid")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}
	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	
	@Column(name = "tes_Business")
	public String getTesBusiness() {
		return tesBusiness;
	}

	public void setTesBusiness(String tesBusiness) {
		this.tesBusiness = tesBusiness;
	}
	@Column(name = "tes_Fault")
	public String getTesFault() {
		return tesFault;
	}

	public void setTesFault(String tesFault) {
		this.tesFault = tesFault;
	}
	@Column(name = "pes_Business")
	public String getPesBusiness() {
		return pesBusiness;
	}

	public void setPesBusiness(String pesBusiness) {
		this.pesBusiness = pesBusiness;
	}
	@Column(name = "pes_Fault")
	public String getPesFault() {
		return pesFault;
	}

	public void setPesFault(String pesFault) {
		this.pesFault = pesFault;
	}
	@Column(name = "ku1_Business")
	public String getKu1Business() {
		return ku1Business;
	}

	public void setKu1Business(String ku1Business) {
		this.ku1Business = ku1Business;
	}
	@Column(name = "ku1_Fault")
	public String getKu1Fault() {
		return ku1Fault;
	}

	public void setKu1Fault(String ku1Fault) {
		this.ku1Fault = ku1Fault;
	}
	@Column(name = "ku2_Business")

	public String getKu2Business() {
		return ku2Business;
	}

	public void setKu2Business(String ku2Business) {
		this.ku2Business = ku2Business;
	}
	@Column(name = "ku2_Fault")
	public String getKu2Fault() {
		return ku2Fault;
	}

	public void setKu2Fault(String ku2Fault) {
		this.ku2Fault = ku2Fault;
	}
	@Column(name = "ku3_Business")
	public String getKu3Business() {
		return ku3Business;
	}

	public void setKu3Business(String ku3Business) {
		this.ku3Business = ku3Business;
	}
	@Column(name = "ku3_Fault")
	public String getKu3Fault() {
		return ku3Fault;
	}

	public void setKu3Fault(String ku3Fault) {
		this.ku3Fault = ku3Fault;
	}
	@Column(name = "ku_Business")
	public String getKuBusiness() {
		return kuBusiness;
	}

	public void setKuBusiness(String kuBusiness) {
		this.kuBusiness = kuBusiness;
	}
	@Column(name = "ku_Fault")
	public String getKuFault() {
		return kuFault;
	}

	public void setKuFault(String kuFault) {
		this.kuFault = kuFault;
	}
	@Column(name = "com_Business")
	public String getComBusiness() {
		return comBusiness;
	}
	public void setComBusiness(String comBusiness) {
		this.comBusiness = comBusiness;
	}
	@Column(name = "com_Fault")
	public String getComFault() {
		return comFault;
	}
	public void setComFault(String comFault) {
		this.comFault = comFault;
	}
	@Column(name = "slh_ku_Business")
	public String getSlhKuBusiness() {
		return slhKuBusiness;
	}
	public void setSlhKuBusiness(String slhKuBusiness) {
		this.slhKuBusiness = slhKuBusiness;
	}
	@Column(name = "slh_ku_Fault")
	public String getSlhKuFault() {
		return slhKuFault;
	}
	public void setSlhKuFault(String slhKuFault) {
		this.slhKuFault = slhKuFault;
	}
	@Column(name = "mhj_tes_Business")
	public String getMhjTesBusiness() {
		return mhjTesBusiness;
	}

	public void setMhjTesBusiness(String mhjTesBusiness) {
		this.mhjTesBusiness = mhjTesBusiness;
	}
	@Column(name = "mhj_tes_Fault")
	public String getMhjTesFault() {
		return mhjTesFault;
	}

	public void setMhjTesFault(String mhjTesFault) {
		this.mhjTesFault = mhjTesFault;
	}
	@Column(name = "mhj_ku_Business")
	public String getMhjKuBusiness() {
		return mhjKuBusiness;
	}

	public void setMhjKuBusiness(String mhjKuBusiness) {
		this.mhjKuBusiness = mhjKuBusiness;
	}
	@Column(name = "mhj_ku_Fault")
	public String getMhjKuFault() {
		return mhjKuFault;
	}

	public void setMhjKuFault(String mhjKuFault) {
		this.mhjKuFault = mhjKuFault;
	}
	@Column(name = "sum_Business")
	public String getSumBusiness() {
		return sumBusiness;
	}

	public void setSumBusiness(String sumBusiness) {
		this.sumBusiness = sumBusiness;
	}
	@Column(name = "sum_Fault")
	public String getSumFault() {
		return sumFault;
	}

	public void setSumFault(String sumFault) {
		this.sumFault = sumFault;
	}
	@Column(name = "ku_Net1_Remark")
	public String getKuNet1Remark() {
		return kuNet1Remark;
	}

	public void setKuNet1Remark(String kuNet1Remark) {
		this.kuNet1Remark = kuNet1Remark;
	}
	@Column(name = "ku_Net2_Remark")
	public String getKuNet2Remark() {
		return kuNet2Remark;
	}

	public void setKuNet2Remark(String kuNet2Remark) {
		this.kuNet2Remark = kuNet2Remark;
	}
	@Column(name = "ku_Net3_Remark")
	public String getKuNet3Remark() {
		return kuNet3Remark;
	}

	public void setKuNet3Remark(String kuNet3Remark) {
		this.kuNet3Remark = kuNet3Remark;
	}
	@Column(name = "pes_Remark")
	public String getPesRemark() {
		return pesRemark;
	}

	public void setPesRemark(String pesRemark) {
		this.pesRemark = pesRemark;
	}
	@Column(name = "ku_Remark")
	public String getKuRemark() {
		return kuRemark;
	}

	public void setKuRemark(String kuRemark) {
		this.kuRemark = kuRemark;
	}
	@Column(name = "com_Remark")
	public String getComRemark() {
		return comRemark;
	}

	public void setComRemark(String comRemark) {
		this.comRemark = comRemark;
	}
	@Column(name = "slh_Ku_Remark")
	public String getSlhKuRemark() {
		return slhKuRemark;
	}

	public void setSlhKuRemark(String slhKuRemark) {
		this.slhKuRemark = slhKuRemark;
	}
	@Column(name = "mhj_Tes_Remark")
	public String getMhjTesReamrk() {
		return mhjTesReamrk;
	}

	public void setMhjTesReamrk(String mhjTesReamrk) {
		this.mhjTesReamrk = mhjTesReamrk;
	}
	@Column(name = "mhj_Ku_Remark")
	public String getMhjKuRemark() {
		return mhjKuRemark;
	}

	public void setMhjKuRemark(String mhjKuRemark) {
		this.mhjKuRemark = mhjKuRemark;
	}
	@Column(name = "sum_Remark")
	public String getSumRemark() {
		return sumRemark;
	}

	public void setSumRemark(String sumRemark) {
		this.sumRemark = sumRemark;
	}
	@Column(name = "tes_Remark")
	public String getTesRemark() {
		return tesRemark;
	}

	public void setTesRemark(String tesRemark) {
		this.tesRemark = tesRemark;
	}

	
	
	
	
}
