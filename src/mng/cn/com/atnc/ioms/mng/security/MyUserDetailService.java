/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-7-27 下午01:24:43
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.acl.IUserRoleDao;
import cn.com.atnc.ioms.entity.acl.Role;

/**
 * 从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期 项目实现的用户查询服务,将用户信息查询出来
 * 
 * @author:HuangYijie
 * @date:2011-7-27 下午01:26:30
 * @version:1.0
 */

@Service("myUserDetailsService")
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private IUserDao usersDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		cn.com.atnc.ioms.entity.acl.User userInDb = usersDao
				.findByLoginName(username);
		if (userInDb == null) {
			throw new UsernameNotFoundException("User " + username
					+ " has no GrantedAuthority");
		}
		if (!userInDb.getValid()) {
			throw new AuthenticationServiceException(username + "已被禁用，当前不可使用");
		}
		// 取得用户的角色

		List<Role> roles = userRoleDao.listRole(userInDb.getId());
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			grantedAuthorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		// 取得用户的密码
		String password = usersDao.findByLoginName(username).getPassword();
		User user = new User(username, password, true, true, true, true,
				grantedAuthorities);
		return user;
	}

}
