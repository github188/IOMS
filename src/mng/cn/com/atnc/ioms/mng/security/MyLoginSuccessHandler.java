/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-8-10 下午02:46:45
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager;
import cn.com.atnc.ioms.web.login.LoginHelper;

/**
 * 成功登录handler 主要作用是添加自定义的系统日志
 * 
 * @author:HuangYijie
 * @date:2011-8-10 下午02:46:45
 * @version:1.0
 */
@Service("myLoginSuccessHandler")
public class MyLoginSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private IUserManager userManager;
	@Autowired
	protected IUserLogManager logManager;

	public MyLoginSuccessHandler() {
		super.setDefaultTargetUrl("/index.do");
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();

		}
		if (username == null) {
			throw new ServletException("用户名不能为空");
		}
		User user = userManager.findByLoginName(username);
		if (user == null) {
			throw new ServletException(username + "找不到对应记录");
		}
		LoginHelper.setSession(request, user);

		userManager.updateLastLoginTime(username);
		addLog(request, username + "登录成功");
		super.onAuthenticationSuccess(request, response, authentication);
	}

	protected void addLog(HttpServletRequest request, String info) {
		User user = (User) WebUtils.getSessionAttribute(request,
				SessionNames.LOGIN_USER);
		UserLog log = new UserLog();
		log.setMenu("登录");
		log.setSubMenu("登录");
		log.setUser(user);
		log.setOptTime(new Date());//
		log.setOptType("登录");
		log.setInfo(info);
		log.setIp(request.getRemoteAddr());
		logManager.saveOrUpdate(log);
	}
}
