/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:26:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.Role;

/**
 * 系统角色Dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:26:26
 */
public interface IRoleDao extends IBaseDao<Role> {

	/**
	 * 根据条件查询获取页面对象
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:39:19
	 * @param name
	 *            名称
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示条数
	 * @return Pagination
	 */
	public Pagination queryPage(String name, int pageNo, int pageSize);

	/**
	 * 
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:39:43
	 * @param id
	 * @param name
	 * @return List<Role>
	 */
	public List<Role> listByNameExcludeId(String id, String name);

	/**
	 * 根据用户id获取对应的角色
	 * 
	 * @author:huangyijie
	 * @date:2013-9-3 上午8:39:03
	 * @param userId
	 * @return List<Role>
	 */
	public List<Role> listRoleByUserId(String userId);

}
