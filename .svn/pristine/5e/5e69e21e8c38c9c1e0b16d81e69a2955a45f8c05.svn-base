/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-4 下午1:55:41
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.operstat.ku;

import java.io.IOException;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.enums.basedata.Bureau;

/**
 * @author:HuangYijie
 * @date:2014-6-4 下午1:55:41
 * @version:1.0
 */

public class KuBureauStatQueryModel extends BaseModel {
	private String kuStatusStatId;
	private Bureau bureau;
	private Double kuRxLevelTopLimit;
	private Double kuRxLevelLowerLimit;
	private Double kuEbNoTopLimit;
	private String kuNetworkStatusStandard;

	public String getKuStatusStatId() {
		return kuStatusStatId;
	}

	public void setKuStatusStatId(String kuStatusStatId) {
		this.kuStatusStatId = kuStatusStatId;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public Double getKuRxLevelTopLimit() {
		return kuRxLevelTopLimit;
	}

	public void setKuRxLevelTopLimit(Double kuRxLevelTopLimit) {
		this.kuRxLevelTopLimit = kuRxLevelTopLimit;
	}

	public Double getKuRxLevelLowerLimit() {
		return kuRxLevelLowerLimit;
	}

	public void setKuRxLevelLowerLimit(Double kuRxLevelLowerLimit) {
		this.kuRxLevelLowerLimit = kuRxLevelLowerLimit;
	}

	public Double getKuEbNoTopLimit() {
		return kuEbNoTopLimit;
	}

	public void setKuEbNoTopLimit(Double kuEbNoTopLimit) {
		this.kuEbNoTopLimit = kuEbNoTopLimit;
	}

	public String getKuNetworkStatusStandard() {
		return kuNetworkStatusStandard;
	}

	public void setKuNetworkStatusStandard(String kuNetworkStatusStandard) {
		this.kuNetworkStatusStandard = kuNetworkStatusStandard;
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
