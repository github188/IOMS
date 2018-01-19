/* Copyright ? 2011 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-7-27 下午02:02:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.BaseService;

/*
 * 资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色访问
 * 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
 * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入， 如果一个类要进行实例化的时候，不能注入对象和操作对象，
 * 所以在构造函数里不能进行操作注入的数据。
 */
@Service("mySecurityMetadataSource")
public class MyInvocationSecurityMetadataSourceService extends BaseService
		implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private IRoleResourceLoader roleResourceLoader;

	public static Map<String, Collection<ConfigAttribute>> urlMap;

	/*
	 * private void loadResourceDefine() { resourceMap = new HashMap<String,
	 * Collection<ConfigAttribute>>(); Collection<ConfigAttribute> atts = new
	 * ArrayList<ConfigAttribute>(); ConfigAttribute ca = new
	 * SecurityConfig("ROLE_ADMIN"); atts.add(ca); resourceMap.put("/index.jsp",
	 * atts); resourceMap.put("/i.jsp", atts); }
	 */
	@PostConstruct
	public void loadResourceDefine() {
		urlMap = roleResourceLoader.loadResourceDefine();
	}

	// According to a URL, Find out permission configuration of this URL.
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// guess object is a URL.
		String url = ((FilterInvocation) object).getRequestUrl();
		if (urlMap == null || CollectionUtils.isEmpty(urlMap)) {
			logger.error("resourcemap is null");
			return new ArrayList<ConfigAttribute>();
		}
		Iterator<String> ite = urlMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (!resURL.endsWith(".do")) {
				continue;
			}
			logger.debug("请求URL：" + url + "；资源项：" + resURL + ";check"
					+ url.indexOf(resURL));
			if (url.indexOf(resURL) >= 0) {
				return urlMap.get(resURL);
			}
		}
		logger.debug(url + "找不到匹配请求");
		return new ArrayList<ConfigAttribute>();
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

}
