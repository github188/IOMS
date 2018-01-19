package cn.com.atnc.ioms.model.systemmng.userlog;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;
/**
 * userlog vo类
 * @author lizhisheng
 * @date 2014-4-3 上午10:06:19
 */
public class UserLogQueryModel extends MyPaginModel {
	private String menuLike;//一级菜单
	private String subMenuLike;//二级菜单
	//private String info;//操作信息
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String startTime;//操作信息
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String endTime;
	private String userNameLike;
	private String dptLike;
	private String optTypeLike;
	
	private String parentMenu;
	public String getParentMenu() {
		return parentMenu;
	}
	public String getSubMenu() {
		return subMenu;
	}
	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}
	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	private String subMenu;
	
	public String getOptTypeLike() {
		return optTypeLike;
	}
	public void setOptTypeLike(String optTypeLike) {
		this.optTypeLike = optTypeLike;
	}
	public String getDptLike() {
		return dptLike;
	}
	public void setDptLike(String dptLike) {
		this.dptLike = dptLike;
	}
	public String getUserNameLike() {
		return HqlStringTools.replaceSpecialChar(userNameLike);
	}
	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}
	public String getMenuLike() {
		return HqlStringTools.replaceSpecialChar(menuLike);
	}
	public void setMenuLike(String menuLike) {
		this.menuLike = menuLike;
	}
	public String getSubMenuLike() {
		return HqlStringTools.replaceSpecialChar(subMenuLike);
	}
	public void setSubMenuLike(String subMenuLike) {
		this.subMenuLike = subMenuLike;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
//	public String getInfo() {
//		return info;
//	}
//	public void setInfo(String info) {
//		this.info = info;
//	}
	
}
