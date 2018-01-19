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
public class AtmPnniDBModel {
	
	private Bureau bureau;
	private LnsType type;
	private Long totalCount;
	
	/**
	 * @param bureau
	 * @param type
	 * @param totalCount
	 */
	public AtmPnniDBModel(Bureau bureau, LnsType type, Long totalCount) {
		super();
		this.bureau = bureau;
		this.type = type;
		this.totalCount = totalCount;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public LnsType getType() {
		return type;
	}
	public void setType(LnsType type) {
		this.type = type;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}
