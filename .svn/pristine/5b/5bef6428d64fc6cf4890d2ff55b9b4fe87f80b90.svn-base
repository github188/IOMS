package cn.com.atnc.ioms.model.acl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.enums.acl.ResourceType;

/**
 * 角色所拥有的菜单
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:17:24
 * @version:1.0
 */
public class RoleMenu extends BaseModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7966492309134216535L;
	private ResourceType type;// 资源分类
	private List<ColumnMenu> columnMenus = new ArrayList<ColumnMenu>();

	public ResourceType getType()
	{
		return type;
	}

	public void setType(ResourceType type)
	{
		this.type = type;
	}

	public List<ColumnMenu> getColumnMenus()
	{
		return columnMenus;
	}

	public void setColumnMenus(List<ColumnMenu> columnMenus)
	{
		this.columnMenus = columnMenus;
	}

}
