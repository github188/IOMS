/**
 * @ProjectName PCSP
 * @FileName DataComNetworkEntity.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年10月26日上午10:13:09
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * 数据通信网节点入网申请表
 * @author WangLingbin
 * @date 2015年10月26日 上午10:13:09
 * @since 1.0.0
 */
public class DataComNetworkEntity {
	//申请信息
		private String applyCom;      	//申请单位名称
		private String serialNumber;			//申请编号
		private String applyLinkman;  	//联系人
		private String applyPhone;     	//联系电话
		private String applyFax;     	//传真
		private String applyComSign; 	//用户单位签字
		private String applyDate;		//申请日期
		
		private String nodeName;   		//节点名称
		private String installSite; 	//安装地点
		private String manufacturer1;  	//厂家1
		private String manufacturer2;  	//厂家2
		private String manufacturer3;  	//厂家3
		private String version1;		//型号1
		private String version2;		//型号2
		private String version3;		//型号3
		private String number1;			//数量1
		private String number2;			//数量2
		private String number3;			//数量3
		
		private String initApproveCom; 	//初审单位
		private String initApproveSign;//负责人签字
		private String initApproveOpinion; //初审意见
		private String initLinkman;		//初审意见：联系人
		private String initLinkphone;	//初审意见：联系电话
		
		private String finalApproveCom; 	//终审单位
		private String finalApproveSign;	//负责人签字
		private String finalApproveOpinion;	//终审意见
		private String finalLinkman;		//初审意见：联系人
		private String finalLinkphone;		//初审意见：联系电话
		
		//调试信息
		private String atmAddress;				//ATM地址
		private String atm0Address;				//ATMO地址/Loopback地址
		private String connectivity; 			//连通性
		private String nodemng; 				//节点管理
		private String operateUser; 			//网控调试人员
		private Date operateTime; 			//调试日期
		private String remark; 					//入网意见
		private String atncLeader;				//领导
		
		public DataComNetworkEntity() {
			super();
		}
		
		//申请表赋值
		public DataComNetworkEntity(String applyCom,String serialNumber, String applyLinkman,
				String applyPhone, String applyFax, String applyComSign,String applyDate,
				String nodeName, String installSite, String manufacturer1,
				String manufacturer2, String manufacturer3, String version1,
				String version2, String version3, String number1, String number2,
				String number3, String initApproveCom, String initApproveSign,
				String initApproveOpinion, String initLinkman,
				String initLinkphone, String finalApproveCom,
				String finalApproveSign, String finalApproveOpinion,
				String finalLinkman, String finalLinkphone, String atmAddress,
				String atm0Address) {
			super();
			this.applyCom = applyCom;
			this.serialNumber = serialNumber;
			this.applyLinkman = applyLinkman;
			this.applyPhone = applyPhone;
			this.applyFax = applyFax;
			this.applyComSign = applyComSign;
			this.applyDate = applyDate;
			this.nodeName = nodeName;
			this.installSite = installSite;
			this.manufacturer1 = manufacturer1;
			this.manufacturer2 = manufacturer2;
			this.manufacturer3 = manufacturer3;
			this.version1 = version1;
			this.version2 = version2;
			this.version3 = version3;
			this.number1 = number1;
			this.number2 = number2;
			this.number3 = number3;
			this.initApproveCom = initApproveCom;
			this.initApproveSign = initApproveSign;
			this.initApproveOpinion = initApproveOpinion;
			this.initLinkman = initLinkman;
			this.initLinkphone = initLinkphone;
			this.finalApproveCom = finalApproveCom;
			this.finalApproveSign = finalApproveSign;
			this.finalApproveOpinion = finalApproveOpinion;
			this.finalLinkman = finalLinkman;
			this.finalLinkphone = finalLinkphone;
			this.atmAddress = atmAddress;
			this.atm0Address = atm0Address;
		}
		
		//记录表赋值
		public DataComNetworkEntity(String applyLinkman, String serialNumber,String applyPhone,
				String applyFax, String nodeName, String installSite,
				String atmAddress, String atm0Address, String connectivity,
				String nodemng, String operateUser, Date operateTime,
				String remark, String atncLeader) {
			super();
			this.applyLinkman = applyLinkman;
			this.serialNumber = serialNumber;
			this.applyPhone = applyPhone;
			this.applyFax = applyFax;
			this.nodeName = nodeName;
			this.installSite = installSite;
			this.atmAddress = atmAddress;
			this.atm0Address = atm0Address;
			this.connectivity = connectivity;
			this.nodemng = nodemng;
			this.operateUser = operateUser;
			this.operateTime = operateTime;
			this.remark = remark;
			this.atncLeader = atncLeader;
		}

		//报表测试赋值
		public DataComNetworkEntity(String applyCom, String serialNumber,String applyLinkman,
				String applyPhone, String applyFax, String applyComSign, String applyDate,
				String nodeName, String installSite, String manufacturer1,
				String manufacturer2, String manufacturer3, String version1,
				String version2, String version3, String number1, String number2,
				String number3, String initApproveCom, String initApproveSign,
				String initApproveOpinion, String initLinkman,
				String initLinkphone, String finalApproveCom,
				String finalApproveSign, String finalApproveOpinion,
				String finalLinkman, String finalLinkphone, String atmAddress,
				String atm0Address, String connectivity, String nodemng,
				String operateUser, Date operateTime, String remark,
				String atncLeader) {
			super();
			this.applyCom = applyCom;
			this.serialNumber = serialNumber;
			this.applyLinkman = applyLinkman;
			this.applyPhone = applyPhone;
			this.applyFax = applyFax;
			this.applyComSign = applyComSign;
			this.applyDate = applyDate;
			this.nodeName = nodeName;
			this.installSite = installSite;
			this.manufacturer1 = manufacturer1;
			this.manufacturer2 = manufacturer2;
			this.manufacturer3 = manufacturer3;
			this.version1 = version1;
			this.version2 = version2;
			this.version3 = version3;
			this.number1 = number1;
			this.number2 = number2;
			this.number3 = number3;
			this.initApproveCom = initApproveCom;
			this.initApproveSign = initApproveSign;
			this.initApproveOpinion = initApproveOpinion;
			this.initLinkman = initLinkman;
			this.initLinkphone = initLinkphone;
			this.finalApproveCom = finalApproveCom;
			this.finalApproveSign = finalApproveSign;
			this.finalApproveOpinion = finalApproveOpinion;
			this.finalLinkman = finalLinkman;
			this.finalLinkphone = finalLinkphone;
			this.atmAddress = atmAddress;
			this.atm0Address = atm0Address;
			this.connectivity = connectivity;
			this.nodemng = nodemng;
			this.operateUser = operateUser;
			this.operateTime = operateTime;
			this.remark = remark;
			this.atncLeader = atncLeader;
		}

		public String getApplyCom() {
			return applyCom;
		}
		public void setApplyCom(String applyCom) {
			this.applyCom = applyCom;
		}
		public String getApplyLinkman() {
			return applyLinkman;
		}
		public void setApplyLinkman(String applyLinkman) {
			this.applyLinkman = applyLinkman;
		}
		public String getApplyPhone() {
			return applyPhone;
		}
		public void setApplyPhone(String applyPhone) {
			this.applyPhone = applyPhone;
		}
		public String getApplyFax() {
			return applyFax;
		}
		public void setApplyFax(String applyFax) {
			this.applyFax = applyFax;
		}
		public String getApplyComSign() {
			return applyComSign;
		}
		public void setApplyComSign(String applyComSign) {
			this.applyComSign = applyComSign;
		}
		public String getNodeName() {
			return nodeName;
		}
		public void setNodeName(String nodeName) {
			this.nodeName = nodeName;
		}
		public String getInstallSite() {
			return installSite;
		}
		public void setInstallSite(String installSite) {
			this.installSite = installSite;
		}
		public String getManufacturer1() {
			return manufacturer1;
		}
		public void setManufacturer1(String manufacturer1) {
			this.manufacturer1 = manufacturer1;
		}
		public String getManufacturer2() {
			return manufacturer2;
		}
		public void setManufacturer2(String manufacturer2) {
			this.manufacturer2 = manufacturer2;
		}
		public String getManufacturer3() {
			return manufacturer3;
		}
		public void setManufacturer3(String manufacturer3) {
			this.manufacturer3 = manufacturer3;
		}
		public String getVersion1() {
			return version1;
		}
		public void setVersion1(String version1) {
			this.version1 = version1;
		}
		public String getVersion2() {
			return version2;
		}
		public void setVersion2(String version2) {
			this.version2 = version2;
		}
		public String getVersion3() {
			return version3;
		}
		public void setVersion3(String version3) {
			this.version3 = version3;
		}
		public String getNumber1() {
			return number1;
		}
		public void setNumber1(String number1) {
			this.number1 = number1;
		}
		public String getNumber2() {
			return number2;
		}
		public void setNumber2(String number2) {
			this.number2 = number2;
		}
		public String getNumber3() {
			return number3;
		}
		public void setNumber3(String number3) {
			this.number3 = number3;
		}
		public String getInitApproveCom() {
			return initApproveCom;
		}
		public void setInitApproveCom(String initApproveCom) {
			this.initApproveCom = initApproveCom;
		}
		public String getInitApproveSign() {
			return initApproveSign;
		}
		public void setInitApproveSign(String initApproveSign) {
			this.initApproveSign = initApproveSign;
		}
		public String getInitApproveOpinion() {
			return initApproveOpinion;
		}
		public void setInitApproveOpinion(String initApproveOpinion) {
			this.initApproveOpinion = initApproveOpinion;
		}
		public String getInitLinkman() {
			return initLinkman;
		}
		public void setInitLinkman(String initLinkman) {
			this.initLinkman = initLinkman;
		}
		public String getInitLinkphone() {
			return initLinkphone;
		}
		public void setInitLinkphone(String initLinkphone) {
			this.initLinkphone = initLinkphone;
		}
		public String getFinalApproveCom() {
			return finalApproveCom;
		}
		public void setFinalApproveCom(String finalApproveCom) {
			this.finalApproveCom = finalApproveCom;
		}
		public String getFinalApproveSign() {
			return finalApproveSign;
		}
		public void setFinalApproveSign(String finalApproveSign) {
			this.finalApproveSign = finalApproveSign;
		}
		public String getFinalApproveOpinion() {
			return finalApproveOpinion;
		}
		public void setFinalApproveOpinion(String finalApproveOpinion) {
			this.finalApproveOpinion = finalApproveOpinion;
		}
		public String getFinalLinkman() {
			return finalLinkman;
		}
		public void setFinalLinkman(String finalLinkman) {
			this.finalLinkman = finalLinkman;
		}
		public String getFinalLinkphone() {
			return finalLinkphone;
		}
		public void setFinalLinkphone(String finalLinkphone) {
			this.finalLinkphone = finalLinkphone;
		}
		public String getAtmAddress() {
			return atmAddress;
		}
		public void setAtmAddress(String atmAddress) {
			this.atmAddress = atmAddress;
		}
		public String getAtm0Address() {
			return atm0Address;
		}
		public void setAtm0Address(String atm0Address) {
			this.atm0Address = atm0Address;
		}
		public String getConnectivity() {
			return connectivity;
		}
		public void setConnectivity(String connectivity) {
			this.connectivity = connectivity;
		}
		public String getNodemng() {
			return nodemng;
		}
		public void setNodemng(String nodemng) {
			this.nodemng = nodemng;
		}
		public String getOperateUser() {
			return operateUser;
		}
		public void setOperateUser(String operateUser) {
			this.operateUser = operateUser;
		}
		public Date getOperateTime() {
			return operateTime;
		}
		public void setOperateTime(Date operateTime) {
			this.operateTime = operateTime;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getAtncLeader() {
			return atncLeader;
		}
		public void setAtncLeader(String atncLeader) {
			this.atncLeader = atncLeader;
		}

		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		public String getApplyDate() {
			return applyDate;
		}

		public void setApplyDate(String applyDate) {
			this.applyDate = applyDate;
		}
	
}
