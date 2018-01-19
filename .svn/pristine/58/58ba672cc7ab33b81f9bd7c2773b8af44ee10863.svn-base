package cn.com.atnc.ioms.entity.systemmng.userlog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * 用户日志表
 * 
 * @author lizhisheng
 * @date 2014-4-2 下午1:56:01
 */
@Entity
@Table(name = "TB_OM_ACL_USER_LOG")
public class UserLog extends MyStringUUIDEntity {

	private static final long serialVersionUID = 552317681377149836L;
	private String menu; // 一级菜单
	private String subMenu;// 二级菜单
	private String optType;// 操作类型
	
	private User user;// 用户ID
	private Date optTime;// 操作时间
	private String info;// 信息

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "MENU")
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Column(name = "SUB_MENU")
	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}

	@Column(name = "OPT_TYPE")
	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	// @Column(name = "USER_ID")
	// public String getUserId() {
	// return userId;
	// }
	// public void setUserId(String userId) {
	// this.userId = userId;
	// }
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "OPT_TIME")
	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


}
