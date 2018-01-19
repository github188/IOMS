package cn.com.atnc.ioms.model.clientmng;

import cn.com.atnc.ioms.entity.clientmng.Client;

/**
 *类说明
 *@author 潘涛
 *@date 2014-6-4	下午4:31:54
 *@version:1.0
 */
public class ClientForm extends Client {
	private String cfm_password;

	public String getCfm_password() {
		return cfm_password;
	}

	public void setCfm_password(String cfm_password) {
		this.cfm_password = cfm_password;
	}
	
}
