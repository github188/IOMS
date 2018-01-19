/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:25:42
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;

/**
 * 系统用户Dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:25:42
 */
public interface IUserDao extends IBaseDao<User> {
	/**
	 * 根据用户登陆查找对应的记录
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:00:27
	 * @param loginName
	 *            登陆名称
	 * @return User
	 */
	public User findByLoginName(String loginName);

	/**
	 * 分页多条件查询
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:00:47
	 * @param name
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return Pagination
	 */
	public Pagination pagnQuery(UserQueryModel queryModel);

	/**
	 * 查询指定角色下有多少用户
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:00:56
	 * @param roleId
	 *            角色id
	 * @return long
	 */
	public long listCount(String roleId);

	/**
	 * 
	 * 
	 * @author:HuangYijie
	 * @Date:2014-3-19 下午7:26:54
	 * 
	 * @param loginName
	 *            void
	 */
	public void updateLastLoginTime(String loginName);

	/**
	 * 
	 * 方法说明：根据角色获取用户列表
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月28日上午9:46:39
	 * @param roleId
	 * @return List<User>
	 * 
	 */
	public List<User> listUserByRoleName(String roleName);
	
	/**
	 * 获取除当前用户以外的所有用户，按照部门排序（未封禁的）
	 * @author WangLingbin
	 * @date  2015年11月4日上午9:40:30
	 * @since 1.0.0
	 */
	public List<User> getUsersOrderbyDep(User currentUser);
	
	/**
	 * 根据部门排序，获得所有用户
	 * @author WangLingbin
	 * @date  2016年2月2日下午1:56:49
	 * @since 1.0.0
	 */
	public List<User> getAllOrderByDep();
	
	/**
	 * 根据部门名称获取人员列表
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:12:35
	 * @param deptName
	 * @return
	 */
	public List<User> getAllByDept(DeptInfomationMng dept); 
}
