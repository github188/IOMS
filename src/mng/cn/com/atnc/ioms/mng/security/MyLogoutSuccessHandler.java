/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-8-10 下午02:46:45
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager;

/**
 * 退出登录成功后执行添加日志
 * 
 * @author:HuangYijie
 * @date:2011-8-10 下午02:46:45
 * @version:1.0
 */
@Service("myLogoutSuccessHandler")
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	@Autowired
	protected IUserLogManager logManager;
	@Autowired
	protected IUserManager userManager;

	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (authentication != null) {
			WebAuthenticationDetails detail = (WebAuthenticationDetails) authentication
					.getDetails();
			String ip = "";
			if (detail != null) {
				ip = detail.getRemoteAddress();
			} else {
				ip = request.getRemoteAddr();
			}
			addLog(authentication.getName(),ip);
			if (authentication.getPrincipal() instanceof UserDetails) {
				request.getSession().setAttribute(
						WebAttributes.LAST_USERNAME,
						((UserDetails) authentication.getPrincipal())
								.getUsername());
			}

		}
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store"); // firefox
		response.setDateHeader("Expires", 0);
		super.handle(request, response, authentication);
	}

	/**
	 * 添加退出日志
	 * 
	 * @author:HuangYijie
	 * @Date:2012-12-3 下午3:31:38
	 * 
	 * @param userName
	 * @param ip
	 *            void
	 */
	private void addLog(String userName,String ip) {
		if (!StringTools.hasText(userName)) {
			return;
		}
		User user = userManager.findByLoginName(userName);
		if (user == null) {
			return;
		}
		UserLog log = new UserLog();
		log.setIp(ip);
		log.setMenu("登出");
		log.setSubMenu("登出");
		log.setUser(user);
		log.setOptTime(new Date());//Calendar.getInstance()
		log.setOptType("登出");
		log.setInfo(user.getLoginName() + "退出系统");
		logManager.saveOrUpdate(log);

	}

}
