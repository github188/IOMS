package cn.com.atnc.ioms.model.acl;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:17:32
 * @version:1.0
 */
public class UserQueryModel extends MyPaginModel {
	private String userName;
	private Boolean valid;
	private Boolean excludeSetted;
	private String excludeUserId;
	private String emplno;
	private DeptInfomationMng deptinfo;
	private String dept;// 部门  hty mod
	
	//当前用户
	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getExcludeUserId() {
		return excludeUserId;
	}

	public void setExcludeUserId(String excludeUserId) {
		this.excludeUserId = excludeUserId;
	}

	public Boolean getExcludeSetted() {
		return excludeSetted;
	}

	public void setExcludeSetted(Boolean excludeSetted) {
		this.excludeSetted = excludeSetted;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getUserName() {
		return HqlStringTools.replaceSpecialChar(userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmplno() {
		return emplno;
	}

	public void setEmplno(String emplno) {
		this.emplno = emplno;
	}

	public DeptInfomationMng getDeptinfo() {
		return deptinfo;
	}

	public void setDeptinfo(DeptInfomationMng deptinfo) {
		this.deptinfo = deptinfo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
