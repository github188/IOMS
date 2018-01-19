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
public class AtmPnniDetailDBModel {
	
	private Bureau bureau;
	private String type;
	private Long totalCount;
	private Long count;
	private String showCount;
	
	/**
	 * @param bureau
	 * @param type
	 * @param totalCount
	 * @param count
	 */
	public AtmPnniDetailDBModel(Bureau bureau, String type, Long totalCount,
			Long count) {
		super();
		this.bureau = bureau;
		this.type = type;
		this.totalCount = totalCount;
		this.count = count;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getShowCount() {
		return (this.count==null?"0":this.count)+"/"+this.totalCount;
	}
	public void setShowCount(String showCount) {
		this.showCount = showCount;
	}

}
