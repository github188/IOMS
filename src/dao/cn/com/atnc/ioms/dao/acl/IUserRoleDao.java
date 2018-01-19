/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:28:34
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.acl.UserRoleQueryModel;

/**
 * 用户角色关系Dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:28:34
 */
public interface IUserRoleDao extends IBaseDao<UserRole> {
	/**
	 * 查找指定用户拥有的角色列表
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:01:51
	 * @param userId
	 *            用户id
	 * @return List<Role> 角色列表
	 */
	public List<Role> listRole(String userId);
	
	/**
	 * 查找指定用户拥有的授权角色
	 * @author WangLingbin
	 * @date  2015年11月2日下午3:55:51
	 * @since 1.0.0
	 */
	public List<Role> listRolesByRoleSource(String userId, RoleSourceEnum roleSource);

	/**
	 * 查找指定用户拥有授权角色的授权人
	 * @author WangLingbin
	 * @date  2015年11月2日下午4:14:32
	 * @since 1.0.0
	 */
	public List<User> findTransferByRoleSource(String userId, RoleSourceEnum roleSource);
	
	/**
	 * 删除指定用户所拥有的所有角色
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:02:11
	 * @param userId
	 *            用户id
	 * @return int
	 */
	public int deleteByUserId(String userId);

	/**
	 * 获取指定角色对应的所有角色-用户关系列表
	 * 
	 * @author:huangyijie
	 * @date:2013-9-4 上午9:02:39
	 * @param roleId
	 *            角色id
	 * @return List<UserRole>角色-用户关系列表
	 */
	public List<UserRole> listUserRole(String roleId);

	/**
	 * 根据角色名查找实体
	 * @param roleName	角色名
	 * @return 
	 * @author WangLingbin
	 * @date  2015年7月30日下午1:52:14
	 * @since 1.0.0
	 */
	public List<UserRole> findByRoleName(String roleName);

	/**
	 * 根据用户，角色来源和授权人查找实体
	 * @param user
	 * @param roleSource
	 * @param transferUser
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日下午1:22:27
	 * @since 1.0.0
	 */
	public List<UserRole> findByMulti(User user, RoleSourceEnum roleSource, User transferUser);
	
	
	/**
	 * 分页查询
	 * @param queryModel
	 * @author WangLingbin
	 * @date  2015年11月4日下午2:31:57
	 * @since 1.0.0
	 */
	public Pagination pageQuery(UserQueryModel queryModel);
	
	/**
	 * 根据用户和角色查找实体
	 * @param user
	 * @param userRoles
	 * @author WangLingbin
	 * @date  2015年11月5日上午11:40:42
	 * @since 1.0.0
	 */
	public List<UserRole> findByMulti(User user, List<Role> userRoles);

	/**
	 * 获取授权人信息
	 * @author WangLingbin
	 * @date  2015年11月5日下午1:12:00
	 * @since 1.0.0
	 */
	public String getTransferInfos(User user);
	
	/**
	 * 用户绑定角色列表查询
	 * @author duanyanlin
	 * @date 2016年7月28日上午10:41:18
	 * @param qm
	 * @return
	 */
	public List<UserRole> queryList(UserRoleQueryModel qm);
}
