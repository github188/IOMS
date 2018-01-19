package cn.com.atnc.ioms.model.duty.satelliteauto.ParseDataModel;

import cn.com.atnc.common.model.BaseModel;

/**
 * occ状态
 *
 * @author 段衍林
 * @2016年11月16日 下午2:59:40
 */
public class TesOccModel extends BaseModel {

	private String desc; // 描述
	private String centerFreq;
	private String span;
	private String rbw;
	private String refLevel;
	private String div;
	private String power;
	private String noiseFloor; // 底噪
	private String peak; // 峰值

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCenterFreq() {
		return centerFreq;
	}

	public void setCenterFreq(String centerFreq) {
		this.centerFreq = centerFreq;
	}

	public String getSpan() {
		return span;
	}

	public void setSpan(String span) {
		this.span = span;
	}

	public String getRbw() {
		return rbw;
	}

	public void setRbw(String rbw) {
		this.rbw = rbw;
	}

	public String getRefLevel() {
		return refLevel;
	}

	public void setRefLevel(String refLevel) {
		this.refLevel = refLevel;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getNoiseFloor() {
		return noiseFloor;
	}

	public void setNoiseFloor(String noiseFloor) {
		this.noiseFloor = noiseFloor;
	}

	public String getPeak() {
		return peak;
	}

	public void setPeak(String peak) {
		this.peak = peak;
	}
}
