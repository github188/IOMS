package cn.com.atnc.ioms.model.acl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.acl.Resource;

/**
 * 栏目菜单
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:17:11
 * @version:1.0
 */
public class ColumnMenu extends BaseModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8343630527935124468L;
	private Resource columnResource;// 栏目资源
	private boolean hasTabMenu;// 是否拥有标签菜单
	private List<Resource> tabResources = new ArrayList<Resource>();// 标签资源

	private boolean hasColumnResource;// 是否拥有本栏目菜单（角色配置时用）

	public Resource getColumnResource()
	{
		return columnResource;
	}

	public void setColumnResource(Resource columnResource)
	{
		this.columnResource = columnResource;
	}

	public boolean isHasTabMenu()
	{
		return hasTabMenu;
	}

	public void setHasTabMenu(boolean hasTabMenu)
	{
		this.hasTabMenu = hasTabMenu;
	}

	public List<Resource> getTabResources()
	{
		return tabResources;
	}

	public void setTabResources(List<Resource> tabResources)
	{
		this.tabResources = tabResources;
	}

	public boolean isHasColumnResource()
	{
		return hasColumnResource;
	}

	public void setHasColumnResource(boolean hasColumnResource)
	{
		this.hasColumnResource = hasColumnResource;
	}
}
