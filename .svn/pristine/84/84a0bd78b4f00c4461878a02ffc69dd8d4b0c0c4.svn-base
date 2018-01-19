/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-7-31 下午3:46:29
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.login;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.clientnotice.IEmailService;
import cn.com.atnc.ioms.mng.clientnotice.sms.ISMSService;
import cn.com.atnc.ioms.mng.welcome.IWelcomeManager;
import cn.com.atnc.ioms.model.login.LoginModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:HuangYijie
 * @date:2013-7-31 下午3:46:29
 * @version:1.0
 */
@Controller("WelcomController")
public class WelcomController extends MyBaseController {

	@Autowired
	private IUserManager userManager;

	@Autowired
	private IWelcomeManager welcomeManager;

	@Autowired
	private IEmailService emailService;
	@Autowired
	private ISMSService smsService;

	@Autowired
	@Qualifier(value = "myUserDetailsService")
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/index.do")
	public String welcome(HttpServletRequest request, Model model) {
		super.pageInfo(model, request);
		model.addAttribute("serviceNotice", welcomeManager
				.getServiceNoticeCount(super.getCurrentUser(request)));
		model.addAttribute("indexnotice",
				welcomeManager.getIndexNotice(this.getCurrentUser(request)));
		model.addAttribute("emailStatus", emailService.getEMailStatus());
		model.addAttribute("smsStatus", smsService.getServiceStatus());
		return "index";
	}

	@RequestMapping(value = "/alarmStat.dox")
	public String alarmStat(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("returnStr", welcomeManager.getAlarmStat());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}

	@RequestMapping(value = "/welcome.do")
	public String getLogin(HttpServletRequest request, HttpSession session,
			Model model, @ModelAttribute("pageModel") LoginModel loginModel) {

		Object exception = session
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (exception != null) {
			String message = "";
			if (exception instanceof BadCredentialsException) {
				message = "账号或密码错误";
			}
			if (exception instanceof SessionAuthenticationException) {
				message = "session验证失败,用户已登录"
						+ (logger.isDebugEnabled() ? ((SessionAuthenticationException) exception)
								.getMessage() : "");
			}
			if (exception instanceof AuthenticationServiceException) {
				message = ((AuthenticationServiceException) exception)
						.getMessage();
			}
			model.addAttribute(MySessionNames.ERROR_MSG, message);
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		return "login";
	}

	@RequestMapping(value = "/session-expired.do")
	public String sessionExpired(HttpServletRequest request,
			HttpSession session, Model model) {
		String message = "账号已在其他地方登录，强制退出！";
		model.addAttribute(MySessionNames.ERROR_MSG, message);
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		return "login";
	}

	@RequestMapping("/noright.do")
	public String noRight(HttpServletRequest request, Model model) {
		String reason = (String) WebUtils.getSessionAttribute(request,
				SessionNames.NORIGHT_ERROR);
		if (!StringUtils.hasText(reason))
			reason = "原因未知";
		model.addAttribute("reason", reason);
		logger.debug("没有权限");
		return "acl/noright";
	}

	@RequestMapping(value = "/modPasswd.dox", method = { RequestMethod.GET })
	public String modPasswdView(@ModelAttribute("passwdModel") User passwdModel) {
		return "modPasswd";
	}

	@RequestMapping(value = "/modPasswd.dox", method = { RequestMethod.POST })
	public String modPasswdSubmit(
			@ModelAttribute("passwdModel") User passwdModel,
			HttpServletRequest request, Model model) {
		User user = (User) WebUtils.getSessionAttribute(request,
				SessionNames.LOGIN_USER);
		if (user == null) {
			model.addAttribute("modTag", "N");
			model.addAttribute("reason", passwdModel.getName() + "不存在");
			return "modPasswd";
		}
		String oldPasswd = passwdModel.getOldPasswd();
		if (!LoginHelper.isPassValid(oldPasswd, user)) {
			model.addAttribute("modTag", "N");
			model.addAttribute("reason", "原密码错误.");
			return "modPasswd";
		}
		if (!StringUtils.hasText(passwdModel.getPassword())) {
			model.addAttribute("modTag", "N");
			model.addAttribute("reason", "新密码不能为空.");
			return "modPasswd";
		}
		try {
			WebUtils.setSessionAttribute(
					request,
					SessionNames.LOGIN_USER,
					userManager.modPasswd(passwdModel.getPassword(),
							user.getId()));
			model.addAttribute("modTag", "Y");
		} catch (ServiceException e) {
			model.addAttribute("modTag", "N");
			model.addAttribute("reason", e.getMessage());
			logger.error("", e);
		}
		// super.addLog(request, LogType.MODIFYPSW, "修改个人密码");
		return "modPasswd";
	}

	@RequestMapping("/validatePasswd.do")
	public void validatePasswd(@RequestParam("oldPasswd") String oldPasswd,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		User user = (User) WebUtils.getSessionAttribute(request,
				SessionNames.LOGIN_USER);
		response.getWriter().print(LoginHelper.isPassValid(oldPasswd, user));
	}

	/**
	 * 用户手册下载
	 * 
	 * @author 王凌斌
	 * @2017年2月24日 下午3:12:38
	 * @param request
	 * @param response
	 * @param passwdModel
	 *            void
	 */
	@RequestMapping(value = "/userManual.dox", method = { RequestMethod.GET })
	public void downloadUserManual(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("passwdModel") User passwdModel) {
		// 获取用户手册资源
		InputStream in = request.getServletContext().getResourceAsStream(
				"/WEB-INF/doc/userManual.doc");
		try {
			// 对文件名进行重编码
			String filename = "运维平台用户手册";
			filename = new String(filename.getBytes(GBK), ISO8859);
			// 以下载方式打开文件
			response.setContentType("application/octet-stream");
			response.setHeader("content-disposition", "attachment;filename="
					+ filename + ".doc");
			// 将文件数据读取到字节数组中
			byte[] buf = new byte[1024];
			int len = 0;
			// 得到输出流
			ServletOutputStream outputStream = response.getOutputStream();
			while ((len = in.read(buf)) != -1) {
				outputStream.write(buf, 0, len);
			}
			int length = in.available();
			response.setContentLength(length);
			outputStream.flush();
			// 关闭流
			in.close();
			outputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
