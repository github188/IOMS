/**
 * 
 */
package cn.com.atnc.ioms.model.operstat.atm;

import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * atm带宽统计Model
 * @author：KuYonggang
 * @date：2014-6-17下午3:51:07
 * @version：1.0
 */
public class AtmBandDBModel {
	
	private Bureau bureau;
	private float pnniMax;
	private long pnniAvlCps;
	private long pnniAvlKbps;
	
	/**
	 * @param bureau
	 * @param pnniMax
	 * @param pnniAvlCps
	 * @param pnniAvlKbps
	 */
	public AtmBandDBModel(Bureau bureau, float pnniMax, long pnniAvlCps,
			long pnniAvlKbps) {
		super();
		this.bureau = bureau;
		this.pnniMax = pnniMax;
		this.pnniAvlCps = pnniAvlCps;
		this.pnniAvlKbps = pnniAvlKbps;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public float getPnniMax() {
		return pnniMax;
	}
	public void setPnniMax(float pnniMax) {
		this.pnniMax = pnniMax;
	}
	public long getPnniAvlCps() {
		return pnniAvlCps;
	}
	public void setPnniAvlCps(long pnniAvlCps) {
		this.pnniAvlCps = pnniAvlCps;
	}
	public long getPnniAvlKbps() {
		return pnniAvlKbps;
	}
	public void setPnniAvlKbps(long pnniAvlKbps) {
		this.pnniAvlKbps = pnniAvlKbps;
	}
	
}
