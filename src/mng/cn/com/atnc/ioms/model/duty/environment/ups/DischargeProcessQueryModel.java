package cn.com.atnc.ioms.model.duty.environment.ups;

import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.model.MyPaginModel;
/**
 * 放电过程查询model
 * @author renyujuan
 * @date 2016年7月7日上午10:33:21
 */
public class DischargeProcessQueryModel extends MyPaginModel {

	private DischargeTest dischargeTest;

	public DischargeTest getDischargeTest() {
		return dischargeTest;
	}

	public void setDischargeTest(DischargeTest dischargeTest) {
		this.dischargeTest = dischargeTest;
	}

	
	
}
