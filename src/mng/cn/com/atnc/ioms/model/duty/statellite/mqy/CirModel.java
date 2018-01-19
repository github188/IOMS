package cn.com.atnc.ioms.model.duty.statellite.mqy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class CirModel extends MyPaginModel {

	private String id;
	private EnvironmentEquipCheck checkid;//巡检id
	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;
	private EquipType equipType;
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间

	private String tesBusiness;
	private String tesFault;
	private String pesBusiness;
	private String pesFault;
	private String ku1Business;
	private String ku1Fault;
	private String ku2Business;
	private String ku2Fault;
	private String ku3Business;
	private String ku3Fault;
	private String kuBusiness;
	private String kuFault;
	private String comBusiness;
	private String comFault;
	private String slhKuBusiness;
	private String slhKuFault;
	private String mhjTesBusiness;
	private String mhjTesFault;
	private String mhjKuBusiness;
	private String mhjKuFault;
	private String sumBusiness;
	private String sumFault;
	
	private String kuNet1Remark;
	private String kuNet2Remark;
	private String kuNet3Remark;
	private String pesRemark;
	private String kuRemark;
	private String comRemark;
	private String slhKuRemark;
	private String mhjTesReamrk;
	private String mhjKuRemark;
	private String sumRemark;
	private String tesRemark;
	
	
	
	
	public CirModel(){}
	public CirModel(
			
			 String tesBusiness,
			 String tesFault,
			 String pesBusiness,
			 String pesFault,
			 String ku1Business,
			 String ku1Fault,
			 String ku2Business,
			 String ku2Fault,
			 String ku3Business,
			 String ku3Fault,
			 String kuBusiness,
			 String kuFault,
			 String comBusiness,
			 String comFault,
			 String slhKuBusiness,
			 String slhKuFault,
			 String mhjTesBusiness,
			 String mhjTesFault,
			 String mhjKuBusiness,
			 String mhjKuFault,
			 String sumBusiness,
			 String sumFault,
			
			 String kuNet1Remark,
			 String kuNet2Remark,
			 String kuNet3Remark,
			 String pesRemark,
			 String kuRemark,
			 String comRemark,
			 String slhKuRemark,
			 String mhjTesReamrk,
			 String mhjKuRemark,
			 String sumRemark,
			 String tesRemark,
			 
			String id , 
			EnvironmentEquipCheck checkid , 
			Date checkDate , 
			Date checkTime , 
			User operator
			){
		 this.tesBusiness=tesBusiness;
		 this.tesFault=tesFault;
		 this.pesBusiness=pesBusiness;
		 this.pesFault=pesFault;
		 this.ku1Business=ku1Business;
		 this.ku1Fault=ku1Fault;
		 this.ku2Business=ku2Business;
		 this.ku2Fault=ku2Fault;
		 this.ku3Business=ku3Business;
		 this.ku3Fault=ku3Fault;
		 this.kuBusiness=kuBusiness;
		 this.kuFault=kuFault;
		 this.comBusiness=comBusiness;
		 this.comFault=comFault;
		 this.slhKuBusiness=slhKuBusiness;
		 this.slhKuFault=slhKuFault;
		 this.mhjTesBusiness=mhjTesBusiness;
		 this.mhjTesFault=mhjTesFault;
		 this.mhjKuBusiness=mhjKuBusiness;
		 this.mhjKuFault=mhjKuFault;
		 this.sumBusiness=sumBusiness;
		 this.sumFault=sumFault;
		
		 this.kuNet1Remark=kuNet1Remark;
		 this.kuNet2Remark=kuNet2Remark;
		 this.kuNet3Remark=kuNet3Remark;
		 this.pesRemark=pesRemark;
		 this.kuRemark=kuRemark;
		 this.comRemark=comRemark;
		 this.slhKuRemark=slhKuRemark;
		 this.mhjTesReamrk=mhjTesReamrk;
		 this.mhjKuRemark=mhjKuRemark;
		 this.sumRemark=sumRemark;
		 this.tesRemark=tesRemark;
		
		this.id=id;
		this.checkid=checkid;
		this.checkDate=checkDate;
		this.checkTime=checkTime;
		this.operator=operator;
	}
	
	
	
	
	
	public String getTesBusiness() {
		return tesBusiness;
	}
	public void setTesBusiness(String tesBusiness) {
		this.tesBusiness = tesBusiness;
	}
	public String getTesFault() {
		return tesFault;
	}
	public void setTesFault(String tesFault) {
		this.tesFault = tesFault;
	}
	public String getPesBusiness() {
		return pesBusiness;
	}
	public void setPesBusiness(String pesBusiness) {
		this.pesBusiness = pesBusiness;
	}
	public String getPesFault() {
		return pesFault;
	}
	public void setPesFault(String pesFault) {
		this.pesFault = pesFault;
	}
	public String getKu1Business() {
		return ku1Business;
	}
	public void setKu1Business(String ku1Business) {
		this.ku1Business = ku1Business;
	}
	public String getKu1Fault() {
		return ku1Fault;
	}
	public void setKu1Fault(String ku1Fault) {
		this.ku1Fault = ku1Fault;
	}
	public String getKu2Business() {
		return ku2Business;
	}
	public void setKu2Business(String ku2Business) {
		this.ku2Business = ku2Business;
	}
	public String getKu2Fault() {
		return ku2Fault;
	}
	public void setKu2Fault(String ku2Fault) {
		this.ku2Fault = ku2Fault;
	}
	public String getKu3Business() {
		return ku3Business;
	}
	public void setKu3Business(String ku3Business) {
		this.ku3Business = ku3Business;
	}
	public String getKu3Fault() {
		return ku3Fault;
	}
	public void setKu3Fault(String ku3Fault) {
		this.ku3Fault = ku3Fault;
	}
	public String getKuBusiness() {
		return kuBusiness;
	}
	public void setKuBusiness(String kuBusiness) {
		this.kuBusiness = kuBusiness;
	}
	public String getKuFault() {
		return kuFault;
	}
	public void setKuFault(String kuFault) {
		this.kuFault = kuFault;
	}
	public String getComBusiness() {
		return comBusiness;
	}
	public void setComBusiness(String comBusiness) {
		this.comBusiness = comBusiness;
	}
	public String getComFault() {
		return comFault;
	}
	public void setComFault(String comFault) {
		this.comFault = comFault;
	}
	public String getSlhKuBusiness() {
		return slhKuBusiness;
	}
	public void setSlhKuBusiness(String slhKuBusiness) {
		this.slhKuBusiness = slhKuBusiness;
	}
	public String getSlhKuFault() {
		return slhKuFault;
	}
	public void setSlhKuFault(String slhKuFault) {
		this.slhKuFault = slhKuFault;
	}
	public String getMhjTesBusiness() {
		return mhjTesBusiness;
	}
	public void setMhjTesBusiness(String mhjTesBusiness) {
		this.mhjTesBusiness = mhjTesBusiness;
	}
	public String getMhjTesFault() {
		return mhjTesFault;
	}
	public void setMhjTesFault(String mhjTesFault) {
		this.mhjTesFault = mhjTesFault;
	}
	public String getMhjKuBusiness() {
		return mhjKuBusiness;
	}
	public void setMhjKuBusiness(String mhjKuBusiness) {
		this.mhjKuBusiness = mhjKuBusiness;
	}
	public String getMhjKuFault() {
		return mhjKuFault;
	}
	public void setMhjKuFault(String mhjKuFault) {
		this.mhjKuFault = mhjKuFault;
	}
	public String getSumBusiness() {
		return sumBusiness;
	}
	public void setSumBusiness(String sumBusiness) {
		this.sumBusiness = sumBusiness;
	}
	public String getSumFault() {
		return sumFault;
	}
	public void setSumFault(String sumFault) {
		this.sumFault = sumFault;
	}
	public String getKuNet1Remark() {
		return kuNet1Remark;
	}
	public void setKuNet1Remark(String kuNet1Remark) {
		this.kuNet1Remark = kuNet1Remark;
	}
	public String getKuNet2Remark() {
		return kuNet2Remark;
	}
	public void setKuNet2Remark(String kuNet2Remark) {
		this.kuNet2Remark = kuNet2Remark;
	}
	public String getKuNet3Remark() {
		return kuNet3Remark;
	}
	public void setKuNet3Remark(String kuNet3Remark) {
		this.kuNet3Remark = kuNet3Remark;
	}
	public String getPesRemark() {
		return pesRemark;
	}
	public void setPesRemark(String pesRemark) {
		this.pesRemark = pesRemark;
	}
	public String getKuRemark() {
		return kuRemark;
	}
	public void setKuRemark(String kuRemark) {
		this.kuRemark = kuRemark;
	}
	public String getComRemark() {
		return comRemark;
	}
	public void setComRemark(String comRemark) {
		this.comRemark = comRemark;
	}
	public String getSlhKuRemark() {
		return slhKuRemark;
	}
	public void setSlhKuRemark(String slhKuRemark) {
		this.slhKuRemark = slhKuRemark;
	}
	public String getMhjTesReamrk() {
		return mhjTesReamrk;
	}
	public void setMhjTesReamrk(String mhjTesReamrk) {
		this.mhjTesReamrk = mhjTesReamrk;
	}
	public String getMhjKuRemark() {
		return mhjKuRemark;
	}
	public void setMhjKuRemark(String mhjKuRemark) {
		this.mhjKuRemark = mhjKuRemark;
	}
	public String getSumRemark() {
		return sumRemark;
	}
	public void setSumRemark(String sumRemark) {
		this.sumRemark = sumRemark;
	}
	public String getTesRemark() {
		return tesRemark;
	}
	public void setTesRemark(String tesRemark) {
		this.tesRemark = tesRemark;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	private CheckResult datastate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

	public CheckResult getDatastate() {
		return datastate;
	}

	public void setDatastate(CheckResult datastate) {
		this.datastate = datastate;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}
}
