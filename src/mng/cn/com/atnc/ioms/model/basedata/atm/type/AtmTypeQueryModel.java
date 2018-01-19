package cn.com.atnc.ioms.model.basedata.atm.type;

import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 *类说明
 *@author 潘涛
 *@date 2014-8-27	上午9:26:23
 *@version:1.0
 */
public class AtmTypeQueryModel extends MyPaginModel{
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String serviceType;
	private String serviceTypeLike;
	
	public String getServiceTypeLike() {
		return HqlStringTools.replaceSpecialChar(serviceTypeLike);
	}

	public void setServiceTypeLike(String serviceTypeLike) {
		this.serviceTypeLike = serviceTypeLike;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}
