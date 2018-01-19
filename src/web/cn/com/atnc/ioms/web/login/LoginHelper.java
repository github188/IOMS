package cn.com.atnc.ioms.web.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.TimeTools;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:14:39
 * @version:1.0
 */
public class LoginHelper {
	protected static Logger logger = LoggerFactory.getLogger(LoginHelper.class);

	public static boolean hasLogin(HttpServletRequest request) {
		User user = (User) WebUtils.getSessionAttribute(request,
				SessionNames.LOGIN_USER);
		return (user != null && StringUtils.hasText(user.getId()));
	}

	public static void setSession(HttpServletRequest request, User loginUser) {
		Assert.notNull(loginUser);
		String ip = request.getRemoteHost();
		if ("0:0:0:0:0:0:0:1".equals(ip))
			ip = "127.0.0.1";
		WebUtils.setSessionAttribute(request, SessionNames.LOGIN_IP, ip);
		WebUtils.setSessionAttribute(request, SessionNames.LOGIN_TIME,
				TimeTools.toTimeStr());
		WebUtils.setSessionAttribute(request, SessionNames.LOGIN_USER,
				loginUser);
		logger.debug("Set session attributes after login:{}", loginUser);
	}

	public static boolean isPassValid(String pass, User user) {
		if (user == null)
			return false;
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String secPasswd = passwordEncoder.encodePassword(pass, null);
		return secPasswd.equals(user.getPassword());
	}
}
