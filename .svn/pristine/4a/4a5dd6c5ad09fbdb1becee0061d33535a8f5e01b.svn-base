package cn.com.atnc.ioms.model.acl;

import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:17:19
 * @version:1.0
 */
public class ResourceQueryModel extends MyPaginModel {
	private String id; // 当前选中节点的id
	private ResourceType type;
	private String pid;
	private String name;
	private ResourceType pType;
	private ResourceType[] types;

	public ResourceType getpType() {
		return pType;
	}

	public void setpType(ResourceType pType) {
		this.pType = pType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return HqlStringTools.replaceSpecialChar(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceType[] getTypes() {
		return types;
	}

	public void setTypes(ResourceType[] types) {
		this.types = types;
	}

}
