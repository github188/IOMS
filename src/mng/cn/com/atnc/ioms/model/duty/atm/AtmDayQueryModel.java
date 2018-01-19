/**
 * @Title:AtmdayCheckQueryModel.java
 * @author shijiyong
 * @data 2016年9月26日上午10:15:33
 * @version v1.0
 */
package cn.com.atnc.ioms.model.duty.atm;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.enums.duty.atm.AtmDayTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTypeEnum;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * ATM日检路由器查询Model
 * 
 * @author shijiyong
 * @date 2016年9月26日 上午10:15:33
 * @version 1.0, 2016年9月26日 上午10:15:33
 */
public class AtmDayQueryModel extends MyPaginModel {

	private String operator; // 操作人名称
	private String auditor;		//审核人名称
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间
	// tab页类型
	private AtmDayTabEnum tabType;
	private CheckCatagory checkType;
	private AtmDayTypeEnum atmtype; // ATM巡检设备

	// --------------------添加页面保存数据----------------------------//
	// 远程访问
	private List<String> telnet;
	// cpu利用率
	private List<String> cpu;
	// 成都
	private List<String> chengdu;
	// 广州
	private List<String> guangzhou;
	// 首都机场
	private List<String> shoudu;
	// 上海
	private List<String> shanghai;
	// 沈阳
	private List<String> shenyang;
	// 西安
	private List<String> xian;
	// 乌鲁木齐
	private List<String> wulumuqi;
	// 三亚
	private List<String> sanya;
	// 备注
	private List<String> wkzxbz;
	
	// 审核备注
	private String auditRemark;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
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

	public AtmDayTabEnum getTabType() {
		return tabType;
	}

	public void setTabType(AtmDayTabEnum tabType) {
		this.tabType = tabType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	public AtmDayTypeEnum getAtmtype() {
		return atmtype;
	}

	public void setAtmtype(AtmDayTypeEnum atmtype) {
		this.atmtype = atmtype;
	}

	public List<String> getTelnet() {
		return telnet;
	}

	public void setTelnet(List<String> telnet) {
		this.telnet = telnet;
	}

	public List<String> getCpu() {
		return cpu;
	}

	public void setCpu(List<String> cpu) {
		this.cpu = cpu;
	}

	public List<String> getChengdu() {
		return chengdu;
	}

	public void setChengdu(List<String> chengdu) {
		this.chengdu = chengdu;
	}

	public List<String> getGuangzhou() {
		return guangzhou;
	}

	public void setGuangzhou(List<String> guangzhou) {
		this.guangzhou = guangzhou;
	}

	public List<String> getShoudu() {
		return shoudu;
	}

	public void setShoudu(List<String> shoudu) {
		this.shoudu = shoudu;
	}

	public List<String> getShanghai() {
		return shanghai;
	}

	public void setShanghai(List<String> shanghai) {
		this.shanghai = shanghai;
	}

	public List<String> getShenyang() {
		return shenyang;
	}

	public void setShenyang(List<String> shenyang) {
		this.shenyang = shenyang;
	}

	public List<String> getXian() {
		return xian;
	}

	public void setXian(List<String> xian) {
		this.xian = xian;
	}

	public List<String> getWulumuqi() {
		return wulumuqi;
	}

	public void setWulumuqi(List<String> wulumuqi) {
		this.wulumuqi = wulumuqi;
	}

	public List<String> getSanya() {
		return sanya;
	}

	public void setSanya(List<String> sanya) {
		this.sanya = sanya;
	}

	public List<String> getWkzxbz() {
		return wkzxbz;
	}

	public void setWkzxbz(List<String> wkzxbz) {
		this.wkzxbz = wkzxbz;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

}
