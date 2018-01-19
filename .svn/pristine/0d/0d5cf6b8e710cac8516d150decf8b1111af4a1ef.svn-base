/**
 * 
 */
package cn.com.atnc.ioms.model.operstat.atm;

import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.LnsType;

/**
 * atm端口统计Model
 * @author：KuYonggang
 * @date：2014-6-17下午3:51:07
 * @version：1.0
 */
public class AtmPortDBModel {
	
	private Bureau bureau;
	private LnsType portType;
	private int count;
	private int totalCount;
	private String showCount;
	
	/**
	 * @param bureau
	 * @param portType
	 * @param totalCount
	 */
	public AtmPortDBModel(Bureau bureau, LnsType portType, int totalCount) {
		super();
		this.bureau = bureau;
		this.portType = portType;
		this.totalCount = totalCount;
	}
	
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public LnsType getPortType() {
		return portType;
	}
	public void setPortType(LnsType portType) {
		this.portType = portType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getShowCount() {
		return showCount;
	}
	public void setShowCount() {
		this.showCount = this.count+"/"+this.totalCount;
	}
	
}
