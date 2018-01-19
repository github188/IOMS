package cn.com.atnc.ioms.entity.systemmng.clientlog;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-8 
 * author:xiongzhikang
 */

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.acl.MenuEnum;
import cn.com.atnc.ioms.enums.acl.SubMenuEnum;

/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-8
 */
@Entity
@Table(name = "TB_CS_CLIENT_LOG")
public class ClientLog extends MyStringUUIDEntity
{
	private static final long serialVersionUID = -2034821244011679058L;
	private Client client;
	private MenuEnum menu;
	private SubMenuEnum subMenu;
	private String optType;
	private Calendar optTime;
	private String info;
	private String ip;
	
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="MENU")
	public MenuEnum getMenu() {
		return menu;
	}

	public void setMenu(MenuEnum menu) {
		this.menu = menu;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="SUB_MENU")
	public SubMenuEnum getSubMenu() {
		return subMenu;
	}
	
	public void setSubMenu(SubMenuEnum subMenu) {
		this.subMenu = subMenu;
	}
	
	@Column(name = "OPT_TYPE")
	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	@Column(name="OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}
}
