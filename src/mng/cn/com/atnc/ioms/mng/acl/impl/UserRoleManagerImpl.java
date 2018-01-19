package cn.com.atnc.ioms.mng.acl.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.dao.act.IActMembershipDao;
import cn.com.atnc.ioms.dao.act.IActUserDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;

/**
 * 用户-角色
 * @author WangLingbin
 * @date 2015年11月4日 上午10:13:43
 * @since 1.0.0
 */
@Service("userRoleManager")
public class UserRoleManagerImpl extends AbstractService implements IUserRoleManager {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IUserRoleDao userRoleDao;
	@Autowired
	private IActUserDao actUserDao;
	@Autowired
	private IActMembershipDao actMembershipDao;
	@Autowired
	private IDiscuzUserService discuzUserService;
	@Override
	public void save(UserRole userRole) {
		userRoleDao.save(userRole);
	}
	
	@Override
	public void update(UserRole userRole) {
		userRoleDao.update(userRole);
	}

	@Override
	public void saveOrUpdate(UserRole userRole) {
		userRoleDao.saveOrUpdate(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleDao.delete(userRole);
	}

	@Override
	public void saveTransfer(User currentUser, User transferUser) {
		List<Role> roles = currentUser.getBaseRoles();
		for(Role role : roles) {
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setRoleSource(RoleSourceEnum.TRANSFER);
			userRole.setUser(transferUser);
			userRole.setTransfer(currentUser);
			this.save(userRole);
		}
	}

	@Override
	public List<Role> listRole(String userId) {
		return userRoleDao.listRole(userId);
	}

	@Override
	public List<Role> listRolesByRoleSource(String userId, RoleSourceEnum roleSource) {
		return userRoleDao.listRolesByRoleSource(userId, roleSource);
	}

	@Override
	public List<User> findTransferByRoleSource(String userId, RoleSourceEnum roleSource) {
		return userRoleDao.findTransferByRoleSource(userId, roleSource);
	}

	@Override
	public int deleteByUserId(String userId) {
		return userRoleDao.deleteByUserId(userId);
	}

	@Override
	public List<UserRole> listUserRole(String roleId) {
		return userRoleDao.listUserRole(roleId);
	}

	@Override
	public List<UserRole> findByRoleName(String roleName) {
		return userRoleDao.findByRoleName(roleName);
	}

	@Override
	public List<UserRole> findByMulti(User user, RoleSourceEnum roleSource, User transfer) {
		return userRoleDao.findByMulti(user, roleSource, transfer);
	}
	
	@Override
	public void revokeTransfers(User user, User currentUser) {
		List<UserRole> userRoles = null;
		if(currentUser.getId().equalsIgnoreCase("admin")) {
			userRoles = this.findByMulti(user, RoleSourceEnum.TRANSFER, null);
		} else {
			userRoles = this.findByMulti(user, RoleSourceEnum.TRANSFER, currentUser);
		}
		if(CollectionUtils.isEmpty(userRoles)) {
			return;
		}
		//删除记录（撤销授权角色）
		for(UserRole userRole : userRoles) {
			this.delete(userRole);
		}
		reSetRoles(user);
	}

	@Override
	public void reSetRoles(User user) {
		user.setRoles(this.listRole(user.getId()));
		user.setBaseRoles(this.listRolesByRoleSource(user.getId(), RoleSourceEnum.ORDINAL));
		user.setTransferRoles(this.listRolesByRoleSource(user.getId(), RoleSourceEnum.TRANSFER));
		user.setTransfer(this.findTransferByRoleSource(user.getId(), RoleSourceEnum.TRANSFER));
	}

	@Override
	public List<UserRole> findByMulti(User user, List<Role> userRoles) {
		return userRoleDao.findByMulti(user, userRoles);
	}

	@Override
	public String getTransferInfos(User user) {
		return userRoleDao.getTransferInfos(user);
	}

	@Override
	public boolean judgeIsTransfer(User user, String roleName) {
		boolean isTransfer = true;
		List<Role> baseRoles = user.getBaseRoles();
		for(Role baseRole : baseRoles) {
			if(StringUtils.equalsIgnoreCase(baseRole.getName(), roleName)) {
				isTransfer = false;
				break;
			}
		}
		return isTransfer;
	}

	/**
	 * 判断是用户是否拥有某一个角色
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:48:15
	 */
	public boolean hasRoleByUser(User user, String roleName){
		boolean isTransfer = false;
		List<Role> roles = new ArrayList<Role>();
		Role role = this.roleDao.findByParam("name", roleName);
		roles.add(role);
		List<UserRole> userRoles = this.findByMulti(user, roles);
		//用户拥有该角色的列表不为空且是原始角色
		if(CollectionUtils.isNotEmpty(userRoles)){
			isTransfer = true;
		}
		return isTransfer;
	}
	/**
	 * 判断是用户是否拥有某一个角色(原始角色)
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:48:15
	 */
	public boolean hasRoleByUserOrdinal(User user, String roleName){
		boolean isTransfer = false;
		List<Role> roles = new ArrayList<Role>();
		Role role = this.roleDao.findByParam("name", roleName);
		roles.add(role);
		List<UserRole> userRoles = this.findByMulti(user, roles);
		//用户拥有该角色的列表不为空且是原始角色
		if(CollectionUtils.isNotEmpty(userRoles) 
				&& ObjectUtils.equals(userRoles.get(0).getRoleSource(),RoleSourceEnum.ORDINAL)){
			isTransfer = true;
		}
		return isTransfer;
	}
}
