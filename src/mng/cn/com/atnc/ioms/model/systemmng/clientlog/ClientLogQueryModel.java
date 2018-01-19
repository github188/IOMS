package cn.com.atnc.ioms.model.systemmng.clientlog;


import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.model.TimePaginModel;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.log.LogType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-8 
 * @version:1.0
 */
public class ClientLogQueryModel extends MyPaginModel
{
	private String optType;
	private String clientName;
	private String ip;
	private String info;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar endTime;
	
	private String parentMenu;
	private String subMenu;
	
	private Bureau bureau;
	
	public String getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}

	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
	
	
}
