package cn.com.atnc.ioms.model.duty.satellitetool;

import cn.com.atnc.ioms.entity.duty.satellite.ToolLib;

/**
 * 卫星备件信息库model
 *
 * @author 段衍林
 * @2016年11月10日 下午1:06:42
 */
@SuppressWarnings("serial")
public class SatelliteToolModel extends ToolLib {
	private String storeTimeWeb; // 入库时间--前台
	private String lendTimeWeb; // 借出时间--前台
	private String backTimeWeb; // 归还时间--前台

	public String getStoreTimeWeb() {
		return storeTimeWeb;
	}

	public void setStoreTimeWeb(String storeTimeWeb) {
		this.storeTimeWeb = storeTimeWeb;
	}

	public String getLendTimeWeb() {
		return lendTimeWeb;
	}

	public void setLendTimeWeb(String lendTimeWeb) {
		this.lendTimeWeb = lendTimeWeb;
	}

	public String getBackTimeWeb() {
		return backTimeWeb;
	}

	public void setBackTimeWeb(String backTimeWeb) {
		this.backTimeWeb = backTimeWeb;
	}
}
