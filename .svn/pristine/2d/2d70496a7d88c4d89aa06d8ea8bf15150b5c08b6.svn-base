/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:27:15
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;

/**
 * 资源项Dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:27:15
 */
public interface IResourceDao extends IBaseDao<Resource> {

	/**
	 * 取得指定主菜单下的所有栏目菜单资源
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:34:22
	 * @param type
	 *            主菜单类型
	 * @return List<Resource> 主菜单下的栏目菜单资源
	 */
	public List<Resource> listColMenuResource(ResourceType type);

	/**
	 * 取得指定菜单下的指定菜单类型的资源
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:30:39
	 * @param id
	 *            菜单ID
	 * @param types
	 *            菜单类型
	 * @return List<Resource> 指定菜单类型的资源
	 */
	public List<Resource> listResource(String id, ResourceType[] types);

	/**
	 * 删除指定资源下的所有非菜单资源
	 * 
	 * @param id
	 *            资源id
	 * @return
	 */
	public int deleteNotMenu(String id, ResourceType type);

	/**
	 * 取得指定菜单下的指定菜单类型的资源的数量
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:28:18
	 * 
	 * 
	 * @param id
	 *            资源id
	 * @param type
	 *            资源类型
	 * @return long
	 */
	long querySize(String id, ResourceType[] types);

	/**
	 * 根据条件查询返回页面对象
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:28:02
	 * @param queryModel
	 *            查询条件
	 * @return Pagination
	 */
	Pagination queryPage(ResourceQueryModel queryModel);
	
	
	public List<Resource> queryMenu(ResourceQueryModel queryModel);
	public List<Resource> querySubMenu(ResourceQueryModel queryModel);

}
