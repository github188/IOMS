/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-12 下午3:01:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.session;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * @author:HuangYijie
 * @date:2014-3-12 下午3:01:11
 * @version:1.0
 */

public class MyAclFilter extends OncePerRequestFilter {
	public static final String ERROR_INFO = "errorInfo";
	private static String contextPath;
	private static final String ROOT_CONTEXT = "/";

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String uri = getUri(request);
		if (logger.isDebugEnabled()){
			logger.info("myfilter for test--uri:" + uri);
		}
		//取出登录时保存在session中的user
		User user = (User)WebUtils.getSessionAttribute(request, SessionNames.LOGIN_USER);
		if(user==null){
			//System.out.println("user为 null");
			// Ajax请求超时处理(后台部分)
			if (request.getHeader("x-requested-with") != null
					&& request.getHeader("x-requested-with").equalsIgnoreCase(
							"XMLHttpRequest")) {
				response.setHeader("sessionstatus", "sessionTimeOut");
				response.getWriter().print("timeout"); //打印一个返回值，没这一行，在tabs页中无法跳出（导航栏能跳出），具体原因不明
				return;
			} 
		}
		filterChain.doFilter(request, response);
	}

	private String getUri(HttpServletRequest request) {
		if (contextPath == null)
			contextPath = new String(request.getContextPath());
		String uri = request.getRequestURI();
		if (!(contextPath.equals(ROOT_CONTEXT)))
			uri = uri.replaceFirst(contextPath, "");
		return uri;
	}
}
