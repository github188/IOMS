/**
 * 
 */
package cn.com.atnc.ioms.model.operstat.atm;

import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * atm设备统计Model
 * @author：KuYonggang
 * @date：2014-6-17下午3:51:07
 * @version：1.0
 */
public class AtmEquipDBModel {
	private Bureau bureau;
	private long count;
	/**
	 * @param bureau
	 * @param count
	 */
	public AtmEquipDBModel(Bureau bureau, long count) {
		super();
		this.bureau = bureau;
		this.count = count;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
}
