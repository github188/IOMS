/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-6 下午3:57:57
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.welcome;

import java.io.IOException;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * @author:HuangYijie
 * @date:2014-5-6 下午3:57:57
 * @version:1.0
 */

public class AlarmTotalStatModel extends BaseModel {
	private String cha;
	private String name;
	private Bureau bureau;
	private Long atmCritical = 0L;
	private Long atmMajor = 0L;
	private Long atmMinor = 0L;
	private Integer tesAlarm = 0;
	private Long kuStatusAlarm = 0L;
	private Long kuEbNoAlarm = 0L;
	private Long kuRxLevelAlarm = 0L;

	private String des;

	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Long getAtmCritical() {
		return atmCritical;
	}

	public void setAtmCritical(Long atmCritical) {
		this.atmCritical = atmCritical;
	}

	public Long getAtmMajor() {
		return atmMajor;
	}

	public void setAtmMajor(Long atmMajor) {
		this.atmMajor = atmMajor;
	}

	public Long getAtmMinor() {
		return atmMinor;
	}

	public void setAtmMinor(Long atmMinor) {
		this.atmMinor = atmMinor;
	}

	public Integer getTesAlarm() {
		return tesAlarm;
	}

	public void setTesAlarm(Integer integer) {
		this.tesAlarm = integer;
	}

	public Long getKuStatusAlarm() {
		return kuStatusAlarm;
	}

	public void setKuStatusAlarm(Long kuStatusAlarm) {
		this.kuStatusAlarm = kuStatusAlarm;
	}

	public Long getKuEbNoAlarm() {
		return kuEbNoAlarm;
	}

	public void setKuEbNoAlarm(Long kuEbNoAlarm) {
		this.kuEbNoAlarm = kuEbNoAlarm;
	}

	public Long getKuRxLevelAlarm() {
		return kuRxLevelAlarm;
	}

	public void setKuRxLevelAlarm(Long kuRxLevelAlarm) {
		this.kuRxLevelAlarm = kuRxLevelAlarm;
	}

	public String toString() {
		try {
			return this.toJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
