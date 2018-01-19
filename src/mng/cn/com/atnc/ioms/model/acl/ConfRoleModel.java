package cn.com.atnc.ioms.model.acl;

import cn.com.atnc.common.model.BaseModel;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:17:15
 * @version:1.0
 */
public class ConfRoleModel extends BaseModel
{
	private String roleId;
	private String[] colResourceIds;// 栏目菜单ID
	private String[] tabResourceIds;// 标签菜单ID
	private String[] menuResourceIds;// 主菜单ID

	public String[] getMenuResourceIds()
	{
		return menuResourceIds;
	}

	public void setMenuResourceIds(String[] menuResourceIds)
	{
		this.menuResourceIds = menuResourceIds;
	}

	public ConfRoleModel()
	{
	}

	public ConfRoleModel(String roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	public String[] getColResourceIds()
	{
		return colResourceIds;
	}

	public void setColResourceIds(String[] colResourceIds)
	{
		this.colResourceIds = colResourceIds;
	}

	public String[] getTabResourceIds()
	{
		return tabResourceIds;
	}

	public void setTabResourceIds(String[] tabResourceIds)
	{
		this.tabResourceIds = tabResourceIds;
	}

}
