/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-10-13 上午09:39:55
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.mng.acl;

import java.util.List;
import java.util.Set;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;

/**
 * 资源管理业务处理接口
 * 
 * @author:HuangYijie
 * @date:2011-10-25 上午9:24:23
 * @version:1.0
 */
public interface IResourceManager {
	/**
	 * 根据URL地址查找对应的资源
	 * 
	 * @author:HuangYijie
	 * @Date:2011-10-25 上午9:23:48
	 * 
	 * @param url
	 *            请求的url链接
	 * @return Resource 对应的资源记录
	 */
	public Resource getResourceByUrl(String url);

	/**
	 * 根据请求中的uri地址查找对应的资源记录，查找包含在请求uri地址中的url链接对应的资源记录。
	 * 
	 * @author:HuangYijie
	 * @Date:2011-10-25 上午9:23:48
	 * 
	 * @param url
	 * @return Resource
	 */
	public Resource getColumnResourceByUrl(String url);
	
	/**
	 * 根据url查询所属一级菜单
	 * @author:HuangYijie
	 * @Date:2014-4-16 下午3:04:05  
	 *  
	 * @param url
	 * @return
	 * Resource
	 */
	public Resource getGrandpaByUrl(String url);
	
	
	/**
	 * 根据url查询所属二级菜单。
	 * @author:HuangYijie
	 * @Date:2014-4-16 下午3:04:34  
	 *  
	 * @param url
	 * @return
	 * Resource
	 */
	public Resource getParentByUrl(String url);

	/**
	 * 添加资源，需要进行必要的判断
	 * 
	 * @param resource
	 *            添加的资源
	 * @return 添加后的ID
	 * @throws ServiceException
	 */
	public String add(Resource resource) throws ServiceException;

	/**
	 * 修改资源信息，只允许修改名字，排序等简单信息
	 * 
	 * @param resource
	 *            要修改的资源
	 * @throws ServiceException
	 */
	public void update(Resource resource) throws ServiceException;

	/**
	 * 删除指定ID的资源，需要判断资源是否有子资源及是否被角色引用
	 * 
	 * @param id
	 *            指定删除的资源id
	 * @throws ServiceException
	 */
	public void delete(String id) throws ServiceException;

	/**
	 * 根据父节点id分页查询资源列表
	 * 
	 * @param queryModel
	 *            查询条件
	 * @return 查询分页结果
	 */
	public Pagination queryPage(ResourceQueryModel queryModel);

	/**
	 * 根据父节点id查询子节点
	 * 
	 * @param queryModel
	 *            查询条件
	 * @return 子节点列表
	 */
	public List<Resource> listByParent(ResourceQueryModel queryModel);

	/**
	 * 查询指定id的资源信息
	 * 
	 * @author:HuangYijie
	 * @Date:2011-10-25 上午9:34:53
	 * 
	 * @param id
	 *            资源id
	 * @return Resource 资源记录
	 */
	public Resource findById(String id);

	/**
	 * 根据用户查找用户拥有权限的资源id
	 * 
	 * @param user
	 * @return
	 * @author 付韶兴
	 * @update 2012-12-17 下午3:39:20
	 * @version 1.0
	 */
	public Set<Resource> getResourceByUser(User user);
	
	public List<Resource> queryMenu(ResourceQueryModel queryModel);
	
	public List<Resource> querySubMenu(ResourceQueryModel queryModel);
}
