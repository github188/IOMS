/**
 * 
 */
package cn.com.atnc.ioms.model.operstat.atm;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * ATM告警基础Model 用于select查询时直接封装为对象
 * @author：KuYonggang
 * @date：2014-6-11上午9:37:13
 * @version：1.0
 */
public class AtmAlarmDBTbModel extends BaseModel{
	
	private Bureau bureau;
	private String nodeCode;
	private Long critical;
	private Long major;
	private Long minor;
	/**
	 * @param bureau
	 * @param nodeCode
	 * @param critical
	 * @param major
	 * @param minor
	 */
	public AtmAlarmDBTbModel(Bureau bureau, String nodeCode, Long critical,
			Long major, Long minor) {
		super();
		this.bureau = bureau;
		this.nodeCode = nodeCode;
		this.critical = critical;
		this.major = major;
		this.minor = minor;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	public Long getCritical() {
		return critical;
	}
	public void setCritical(Long critical) {
		this.critical = critical;
	}
	public Long getMajor() {
		return major;
	}
	public void setMajor(Long major) {
		this.major = major;
	}
	public Long getMinor() {
		return minor;
	}
	public void setMinor(Long minor) {
		this.minor = minor;
	}
	
}
