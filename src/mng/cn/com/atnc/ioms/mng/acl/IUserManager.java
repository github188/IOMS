package cn.com.atnc.ioms.mng.acl;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:15:58
 * @version:1.0
 */
public interface IUserManager {
	/**
	 * 添加用户
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:29:35
	 * 
	 * @param user
	 *            新增的用户信息
	 * @return
	 * @throws ServiceException
	 *             String
	 */
	public String add(User user) throws ServiceException;

	/**
	 * 根据指定id查找用户记录
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:29:42
	 * 
	 * @param id
	 *            用户id
	 * @return User
	 */
	public User findById(String id);

	/**
	 * 删除指定id的用户
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:29:54
	 * 
	 * @param id
	 *            用户id
	 * @return
	 * @throws ServiceException
	 *             String
	 */
	public String deleteById(String id) throws ServiceException;

	/**
	 * 根据登录名查找用户记录
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:30:03
	 * 
	 * @param loginName
	 *            登录名
	 * @return User
	 */
	public User findByLoginName(String loginName);

	/**
	 * 分页查询
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:30:15
	 * 
	 * @param qm
	 *            查询条件
	 * @return Pagination
	 */
	public Pagination queryPage(UserQueryModel qm);

	/**
	 * 修改用户
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:30:26
	 * 
	 * @param user
	 *            修改的用户信息
	 * @return
	 * @throws ServiceException
	 *             User
	 */
	public User update(User user) throws ServiceException;

	/**
	 * 修改用户状态
	 * 
	 * @param id
	 *            用户id
	 * @param status
	 *            变更的状态 0-无效，1-有效
	 * @throws ServiceException
	 */
	public User updateStatus(String id, Boolean status) throws ServiceException;

	/**
	 * 修改密码
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:30:38
	 * 
	 * @param passwd
	 *            修改后的密码
	 * @param uid
	 *            用户id
	 * @return
	 * @throws ServiceException
	 *             User
	 */
	public User modPasswd(String passwd, String uid) throws ServiceException;

	/**
	 * 获取所有用户记录
	 * 
	 * @author:HuangYijie
	 * @Date:2013-8-21 下午3:30:56
	 * 
	 * @return List<User>
	 */
	public List<User> getAll();

	public void updateLastLoginTime(String loginName);

	/**
	 * 
	 * 方法说明：根据角色获取用户
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年4月28日上午9:44:25
	 * @param ruoleId
	 *            void
	 * 
	 */
	public List<User> getUserByRole(String roleName);
	
	/**
	 * 方法说明：根据角色和当前用户获取用户列表
	 * @author duanyanlin
	 * @date 2016年8月15日上午10:06:10
	 * @param roleName 角色
	 * @param user 当前用户
	 * @return List 用户列表
	 */
	public List<User> getSomeUsersByRole(String roleName, User user);

	/**
	 * 
	 * 方法说明：根据角色获取用户,但是排除指定ID用户
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年7月24日下午4:26:34
	 * @param roleName
	 * @param speciUserID
	 * @return List<User>
	 * 
	 */
	public List<User> getUserByRoleDelSpeci(String roleName, String speciUserID);

	
	/**
	 * 查询用户的原始角色和授权绝色
	 * @author WangLingbin
	 * @date  2015年11月2日下午3:54:00
	 * @since 1.0.0
	 */
	public Pagination queryIncludeTransfer(UserQueryModel qm);
	
	
	/**
	 * 获取除当前用户以外的所有用户，按照部门排序（未封禁的）
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日上午9:40:30
	 * @since 1.0.0
	 */
	public List<User> getUsersOrderbyDep(User currentUser);
	
	/**
	 * 查找指定授权人下的所有用户
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日下午4:50:40
	 * @since 1.0.0
	 */
	public List<User> queryUsersWithTransfer(User transfer);
	
	
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
	 * @date 2016年6月24日下午1:11:04
	 * @param deptName
	 * @return
	 */
	public List<User> getAllByDept(DeptInfomationMng dept);
	
	/**
	 * 根据部门名称获取部门经理列表
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:11:04
	 * @param deptName
	 * @return
	 */
	public List<User> getFirstLeaderByDept(DeptInfomationMng dept);
	
	/**
	 * 根据用户和特定角色，查询用户所在部分的工程师
	 * @author duanyanlin
	 * @date 2016年6月27日上午10:01:46
	 * @param user
	 * @return
	 */
	public List<User> getAllEngineers(User user, String roleName);
}
