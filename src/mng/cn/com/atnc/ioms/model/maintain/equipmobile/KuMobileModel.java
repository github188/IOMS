/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:03:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.maintain.equipmobile;

import cn.com.atnc.common.model.BaseModel;

/**
 * 设备绑定手机号model
 *
 * @author 段衍林
 * @2016年11月22日 上午9:42:55
 */
public class KuMobileModel extends BaseModel {
	
	private String equipId;		//绑定设备id
	private String infos;		//绑定信息

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
}
