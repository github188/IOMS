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

public class KuBureauStatModel extends BaseModel {
	private Bureau bureau;
	private Long count;

	public KuBureauStatModel() {

	}

	public KuBureauStatModel(Bureau bureau, Long count) {
		this.bureau = bureau;
		this.count = count;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
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
