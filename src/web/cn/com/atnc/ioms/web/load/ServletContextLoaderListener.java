package cn.com.atnc.ioms.web.load;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.atnc.ioms.mng.security.IRoleResourceLoader;
import cn.com.atnc.ioms.mng.security.RoleResourceLoaderImpl;

/**
 * 在系统启动的时候，把所有的资源load到内存作为缓存
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午03:02:20
 * @version:1.0
 */
public class ServletContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		// TODO Auto-generated method stub
		servletContextEvent.getServletContext().removeAttribute(
				"jspAuthorities");
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		// TODO Auto-generated method stub
		ServletContext servletContext = servletContextEvent.getServletContext();
		IRoleResourceLoader ss = this.getResourceDao(servletContext);
		Map<String, String> map = ss.loadJSPElementIDAuthorities();
		servletContext.setAttribute("jspAuthorities", map);

	}

	protected RoleResourceLoaderImpl getResourceDao(
			ServletContext servletContext) {
		return (RoleResourceLoaderImpl) WebApplicationContextUtils
				.getWebApplicationContext(servletContext).getBean(
						"roleResourceLoader");
	}
}
