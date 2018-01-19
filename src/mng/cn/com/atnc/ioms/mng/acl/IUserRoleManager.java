package cn.com.atnc.ioms.mng.acl;

import java.util.List;

import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;


/**
 * 用户-角色
 * @author WangLingbin
 * @date 2015年11月4日 上午10:13:43
 * @since 1.0.0
 */
public interface IUserRoleManager {
	
	/**
	 * 新增
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:15:41
	 * @since 1.0.0
	 */
	public void save(UserRole userRole);
	
	/**
	 * 修改
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:16:54
	 * @since 1.0.0
	 */
	public void update(UserRole userRole);
	
	/**
	 * 新增或修改
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:16:57
	 * @since 1.0.0
	 */
	public void saveOrUpdate(UserRole userRole);
	
	/**
	 * 删除
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:19:42
	 * @since 1.0.0
	 */
	public void delete(UserRole userRole);
	
	/**
	 * 授权角色给用户
	 * @param currentUser		授权人
	 * @param transferUser 		受理人
	 * @author WangLingbin
	 * @date  2015年11月4日上午10:24:59
	 * @since 1.0.0
	 */
	public void saveTransfer(User currentUser, User transferUser);
	
	/**
	 * 查找指定用户拥有的角色列表
	 * @param userId
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日下午1:09:31
	 * @since 1.0.0
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
	 * @param userId
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日下午1:11:02
	 * @since 1.0.0
	 */
	public int deleteByUserId(String userId);

	/**
	 * 获取指定角色对应的所有角色-用户关系列表
	 *
	 * @param roleId
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月4日下午1:11:16
	 * @since 1.0.0
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
	public List<UserRole> findByMulti(User user, RoleSourceEnum roleSource, User transfer);
	
	/**
	 * 撤销用户的授权角色
	 * @param user				被撤销用户
	 * @param currentUser 		系统当前用户
	 * @author WangLingbin
	 * @date  2015年11月4日下午1:18:53
	 * @since 1.0.0
	 */
	public void revokeTransfers(User user, User currentUser);
	
	/**
	 * 重新设置roles
	 * @param user 
	 * @author WangLingbin
	 * @date  2015年11月4日下午7:31:47
	 * @since 1.0.0
	 */
	public void reSetRoles(User user);
	
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
	 * @date  2015年11月5日下午1:11:09
	 * @since 1.0.0
	 */
	public String getTransferInfos(User user);
	
	/**
	 * 判断当前用户是否是代替别人操作
	 * @return true：是     false : 不是
	 * @author WangLingbin
	 * @date  2015年11月5日下午1:56:20
	 * @since 1.0.0
	 */
	public boolean judgeIsTransfer(User user, String roleName);
	
	/**
	 * 判断用户是否是某一角色
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:44:57
	 * @param user
	 * @return
	 */
	public boolean hasRoleByUser(User user, String roleName);
	/**
	 * 判断用户是否是某一角色（原始角色）
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:44:57
	 * @param user
	 * @return
	 */
	public boolean hasRoleByUserOrdinal(User user, String roleName);
}
