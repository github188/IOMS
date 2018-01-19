package cn.com.atnc.ioms.mng.acl.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.acl.IRoleDao;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.dao.act.IActMembershipDao;
import cn.com.atnc.ioms.dao.act.IActUserDao;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.acl.UserRole;
import cn.com.atnc.ioms.entity.act.ActMembership;
import cn.com.atnc.ioms.entity.act.ActUser;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.enums.acl.RoleSourceEnum;
import cn.com.atnc.ioms.enums.acl.RoleType;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.acl.IUserRoleManager;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.acl.UserRoleQueryModel;

/**
 * 用户业务逻辑实现
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:15:43
 * @version:1.0
 */
@Service("userManager")
public class UserManagerImpl extends AbstractService implements IUserManager {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IUserRoleManager userRoleManager;
	@Autowired
	private IActUserDao actUserDao;
	@Autowired
	private IActMembershipDao actMembershipDao;
	@Autowired
	private IDiscuzUserService discuzUserService;
	@Autowired
	private IDeptInfoMngDao deptDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public String add(User user) throws ServiceException {
		Assert.notNull(user);
		User tmp = userDao.findByLoginName(user.getLoginName());
		if (!StringUtils.hasText(user.getLoginName())) {
			throw new ServiceException("登录名不能为空");
		}
		if (!StringUtils.hasText(user.getPassword())) {
			throw new ServiceException("密码不能为空");
		}
		if (tmp != null) {
			throw new ServiceException("用户已经存在:" + user.getLoginName());
		}
		user.setPswOrigin(user.getPassword());
		System.out.println("****************"+user.getPassword());
		//hty 增加部门
		//System.out.println("********Deptinfo********"+user.getDeptinfoStr()+"----dept:"+user.getDeptinfoParStr());
		if(user.getDeptinfoStr().equals(""))//判断二级部门是否为空
			user.setDeptinfoStr(user.getDeptinfoParStr());
		DeptInfomationMng dept1=deptDao.findById(user.getDeptinfoParStr());
		DeptInfomationMng dept2=deptDao.findById(user.getDeptinfoStr());
		user.setDeptinfoPar(dept1);
		user.setDeptinfo(dept2);
		user.setDeptinfoParStr(null);
		user.setDeptinfoStr(null);
		//end
		
		
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
				null));
		String userId = userDao.save(user).toString();
		ActUser actUser = new ActUser();
		actUser.setId(userId);
		actUser.setFirstName(user.getLoginName());
		actUser.setLastName(user.getName());
		
		actUserDao.save(actUser);

		userRoleManager.deleteByUserId(userId);
		actMembershipDao.deleteByUserId(userId);
		if (!StringTools.hasText(user.getRoleIds())) {
			throw new ServiceException("用户未配置角色");
		}
		for (String id : user.getRoleIds().split(SysFinals.COMMA)) {
			Role role = roleDao.findById(id);
			if (role == null) {
				logger.error("所选的角色不存在.");
				continue;
			}
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			userRoleManager.saveOrUpdate(userRole);
			if (role.getSystem().equals(RoleType.SYSTEM)) {
				ActMembership actMembership = new ActMembership();
				actMembership.setGroup(role.getName());
				actMembership.setUser(userId);
				actMembershipDao.saveOrUpdate(actMembership);
			}

		}
		//discuzUserService.registerDiscuzMember(user); hantianyu
		return userId;
	}

	@Override
	public User findById(String id) {
		User user = userDao.findById(id);
		if (user == null)
			return null;
		StringBuilder roleIds = new StringBuilder();
		StringBuilder roleNames = new StringBuilder();
		StringBuilder baseRoleNames = new StringBuilder();
		//原始角色
		List<Role> roleList = userRoleManager.listRole(id);
		for (Role role : roleList) {
			if (roleIds.length() > 0) {
				roleIds.append(SysFinals.COMMA);
			}
			roleIds.append(role.getId());
			if (roleNames.length() > 0) {
				roleNames.append(SysFinals.COMMA);
			}
			roleNames.append(role.getName());
		}
		user.setRoleIds(roleIds.toString());
		user.setRoleNames(roleNames.toString());
		user.setRoles(roleList);
		//原有角色
		List<Role> baseRoles = userRoleManager.listRolesByRoleSource(id, RoleSourceEnum.ORDINAL);
		for(Role baseRole : baseRoles) {
			if(baseRoleNames.length() > 0) {
				baseRoleNames.append(SysFinals.COMMA);
			}
			baseRoleNames.append(baseRole.getName());
		}
		user.setBaseRoleNames(baseRoleNames.toString());
		user.setBaseRoles(baseRoles);
		//授权角色
		user.setTransferRoles(userRoleManager.listRolesByRoleSource(user.getId(), RoleSourceEnum.TRANSFER));
		user.setTransfer(userRoleManager.findTransferByRoleSource(user.getId(), RoleSourceEnum.TRANSFER));
		return user;
	}

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public String deleteById(String id) throws ServiceException {
		User user = userDao.findById(id);
		if (user == null)
			throw new ServiceException("删除的用户不存在，id" + id);
		if (user.getSystem())
			throw new ServiceException("不能删除系统内置用户:" + user.getLoginName());
		String loginName = user.getLoginName();
		userDao.delete(user);
		userRoleManager.deleteByUserId(id);
		actMembershipDao.deleteByUserId(id);
		discuzUserService.deleteDiscuzMember(user);
		return loginName;
	}

	@Override
	public User findByLoginName(String loginName) {
		User user = userDao.findByLoginName(loginName);
		if (user == null) {
			return null;
		}
		user.setRoles(userRoleManager.listRole(user.getId()));
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination queryPage(UserQueryModel qm) {
		qm.setValid(true);
		Pagination page = userDao.pagnQuery(qm);
		List<User> userList = (List<User>) page.getResult();
		for (User user : userList) {
			user.setRoles(userRoleManager.listRole(user.getId()));
		}
		return page;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination queryIncludeTransfer(UserQueryModel qm) {
		qm.setValid(true);
		Pagination page = userDao.pagnQuery(qm);
		List<User> userList = (List<User>) page.getResult();
		for (User user : userList) {
			userRoleManager.reSetRoles(user);
		}
		return page;
	}
	
	
	@Override
	public List<User> queryUsersWithTransfer(User transfer) {
		//查找指定授权人下的所有用户
		List<UserRole> userRoles = userRoleManager.findByMulti(null, RoleSourceEnum.TRANSFER, transfer);
		if(CollectionUtils.isEmpty(userRoles)) {
			return null;
		}
		//筛选用户，剔除相同的用户
		List<User> users = new ArrayList<User>();
		User oriUser = userRoles.get(0).getUser();
		users.add(oriUser);
		if(userRoles.size() == 1) {
			for(User user : users) {
				userRoleManager.reSetRoles(user);
			}
			return users;
		} else {
			for(int i = 1; i < userRoles.size(); i++) {
				User tarUser = userRoles.get(i).getUser();
				if(i+1 == userRoles.size()) {
					if(!ObjectUtils.equals(oriUser, tarUser)) {
						users.add(tarUser);
					}
					break;
				}
				if(ObjectUtils.equals(oriUser, tarUser)) {
					continue;
				}
				users.add(tarUser);
				oriUser = tarUser;
			}
			for(User user : users) {
				userRoleManager.reSetRoles(user);
			}
			return users;
		}
	}

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public User update(User user) throws ServiceException {
		User po = userDao.findById(user.getId());
		if (po == null)
			throw new ServiceException("用户不存在,id:" + user.getId());
		if (StringUtils.hasText(po.getLoginName())) {
			if (user.getSystem()) {
				throw new ServiceException("不能修改内置用户的角色:" + po.getLoginName());
			}
		}
		BeanUtils.copyProperties(user, po, new String[] { "id", "loginName",
				"password", "status" });
		
		  //hty 增加部门
		//System.out.println("********Deptinfo********"+user.getDeptinfoStr()+"----dept:"+user.getDeptinfoParStr());
		if(user.getDeptinfoStr().equals(""))//判断二级部门是否为空
			user.setDeptinfoStr(user.getDeptinfoParStr());

		DeptInfomationMng dept1=deptDao.findById(user.getDeptinfoParStr());
		DeptInfomationMng dept2=deptDao.findById(user.getDeptinfoStr());
		po.setDeptinfoPar(dept1);
		po.setDeptinfo(dept2);
		po.setDeptinfoParStr(null);
		po.setDeptinfoStr(null);
		//end
		
		userDao.update(po);
		ActUser actUser = new ActUser();
		actUser.setId(user.getId());
		actUser.setFirstName(user.getLoginName());
		actUser.setLastName(user.getName());
		actUserDao.saveOrUpdate(actUser);
		userRoleManager.deleteByUserId(user.getId());
		actMembershipDao.deleteByUserId(user.getId());
		if (!StringTools.hasText(user.getRoleIds())) {
			throw new ServiceException("用户未配置角色");
		}
		List<Role> roles = new ArrayList<>();
		for (String id : user.getRoleIds().split(",")) {
			Role role = roleDao.findById(id);
			if (role == null) {
				logger.error("所选的角色不存在.");
				continue;
			}
			roles.add(role);
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			userRoleManager.saveOrUpdate(userRole);
			if (role.getSystem().equals(RoleType.SYSTEM)) {
				ActMembership actMembership = new ActMembership();
				actMembership.setGroup(role.getName());
				actMembership.setUser(user.getId());
				actMembershipDao.saveOrUpdate(actMembership);
			}
		}
		po.setRoles(roles);
		return po;
	}

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public User updateStatus(String id, Boolean status) throws ServiceException {
		Assert.notNull(status);
		User user = userDao.findById(id);
		if (user == null)
			throw new ServiceException("用户不存在,id:" + id);
		if (user.getSystem()) {
			throw new ServiceException("不能修改内置用户的状态:" + user.getLoginName());
		}
		user.setRoles(userRoleManager.listRole(user.getId()));
		user.setValid(status);
		actMembershipDao.deleteByUserId(user.getId());
		userDao.update(user);
		ActUser actUser = new ActUser();
		actUser.setId(user.getId());
		actUser.setFirstName(user.getLoginName());
		actUser.setLastName(user.getName());
		actUserDao.saveOrUpdate(actUser);
		if (status) {
			for (Role role : userRoleManager.listRole(id)) {
				if (role.getSystem().equals(RoleType.SYSTEM)) {
					ActMembership actMembership = new ActMembership();
					actMembership.setGroup(role.getName());
					actMembership.setUser(user.getId());
					actMembershipDao.saveOrUpdate(actMembership);
				}
			}
		}
		return user;
	}

	@Override
	@Transactional(rollbackFor = { ServiceException.class })
	public User modPasswd(String passwd, String uid) throws ServiceException {
		User user = userDao.findById(uid);
		if (user == null)
			throw new ServiceException("用户不存在");
		user.setPswOrigin(passwd);
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String secPasswd = passwordEncoder.encodePassword(passwd, null);
		user.setPassword(secPasswd);
		// user.setPasswd(passwd);
		
		userDao.update(user);
		discuzUserService.updateDiscuzMember(user);
		return user;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.acl.ptms.manager.acl.IUserManager#getAll()
	 */
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void updateLastLoginTime(String loginName) {
		userDao.updateLastLoginTime(loginName);
	}

	@Override
	public List<User> getUserByRole(String roleName) {
		return userDao.listUserByRoleName(roleName);
	}
	
	@Override
	public List<User> getSomeUsersByRole(String roleName, User user){
		//根据角色获取用户列表
		List<User> users = this.getUserByRole(roleName);
		//查询角色（网控领导）的实体
		Role role = this.roleDao.findByParam("name", RoleEnum.atncLeader.name());
		//验证列表非空
		if(CollectionUtils.isNotEmpty(users) && role != null){
			UserRoleQueryModel urqm = new UserRoleQueryModel();
			//此处为部门经理的角色id
			urqm.setRoleId(role.getId());
			//角色授权人为授权角色
			urqm.setRoleSource(RoleSourceEnum.TRANSFER);
			//被授权人（代理人）
			urqm.setUserId(user.getId());
			//根据角色和角色来源查询用户绑定角色列表
			List<UserRole> userRoles = this.userRoleDao.queryList(urqm);
			//非空验证
			if(CollectionUtils.isNotEmpty(userRoles)){
				//遍历绑定列表
				for(UserRole userRole : userRoles){
					//绑定角色用户字段非空验证
					if(userRole.getUser() != null && users.contains(userRole.getTransfer())){
						//移除授权人实体
						users.remove(userRole.getTransfer());
					}
				}
			}
		}
		return users;
	}

	@Override
	public List<User> getUserByRoleDelSpeci(String roleName, String speciUserID) {
		List<User> users = new ArrayList<User>();
		for (User user : userDao.listUserByRoleName(roleName)) {
			if (!org.apache.commons.lang.StringUtils.equals(user.getId(),
					speciUserID)) {
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public List<User> getUsersOrderbyDep(User currentUser) {
		return userDao.getUsersOrderbyDep(currentUser);
	}

	@Override
	public List<User> getAllOrderByDep() {
		return userDao.getAllOrderByDep();
	}
	
	/**
	 * 根据部门名称获取用户列表
	 * @author duanyanlin
	 * @date 2016年6月24日下午1:11:45
	 */
	public List<User> getAllByDept(DeptInfomationMng dept) {
		return userDao.getAllByDept(dept);
	}
	
	public List<User> getFirstLeaderByDept(DeptInfomationMng dept){
		//部门所有员工
		List<User> users = this.getAllByDept(dept);
		List<User> resultUsers = new ArrayList<User>();
		for(User user : users){
			List<Role> roles = this.userRoleDao.listRole(user.getId());
			//包含角色
			if(CollectionUtils.isNotEmpty(roles)){
				String roleStr = "";
				for(Role role : roles){
					roleStr += role.getName() + ",";
				}
				if(roleStr.contains(RoleEnum.firstLeader.name())){
					resultUsers.add(user);
				}
			}
		}
		return resultUsers;
	}
	/**
	 * 根据部门名称和角色名称获取用户列表
	 * @author duanyanlin
	 * @date 2016年6月27日上午9:40:14
	 */
	public List<User> getAllEngineers(User user, String roleName){
		List<User> users = new ArrayList<User>();
		List<UserRole> userRoles = this.userRoleManager.findByRoleName(roleName);
		if(userRoles.size() != 0){
			for(UserRole userRole : userRoles){
				if(org.apache.commons.lang.StringUtils.equalsIgnoreCase(userRole.getUser().getDept(),user.getDept())){
					users.add(userRole.getUser());
				}
			}
		}
		return users;
	}
}
