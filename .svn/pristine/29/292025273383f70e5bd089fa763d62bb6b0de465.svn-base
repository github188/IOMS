/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-7-27 下午03:35:27
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;

/**
 * 访问决策器，决定某个用户具有的角色，是否有足够的权限去访问某个资源
 * 
 * @author:HuangYijie
 * @date:2011-7-27 下午03:35:27
 * @version:1.0
 */
@Service("myAccessDecisionManagerBean")
public class MyAccessDecisionManager extends AbstractService implements
		AccessDecisionManager {

	// In this method, need to compare authentication with configAttributes.
	// 1, A object is a URL, a filter was find permission configuration by this
	// URL, and pass to here.
	// 2, Check authentication has attribute in permission configuration
	// (configAttributes)
	// 3, If not match corresponding authentication, throw a
	// AccessDeniedException.
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null
				|| CollectionUtils.isEmpty(configAttributes)) {
			logger.debug("---------------" + authentication.getName());
			throw new AccessDeniedException("该权限未赋给任何角色！");
		}
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needRole.equals(ga.getAuthority())) { // ga is user's role
															// list.
					return;
				}
			}
		}

		throw new AccessDeniedException("no right");
	}

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
