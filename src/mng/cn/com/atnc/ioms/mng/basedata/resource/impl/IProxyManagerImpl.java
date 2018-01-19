package cn.com.atnc.ioms.mng.basedata.resource.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.basedata.resource.IProxyDao;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.mng.basedata.resource.IProxyManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

 /**
 * Proxy的Service方法实现
 *
 * @author wangzhicheng
 * @date 2015-7-14 下午3:33:52
 * @since 1.0.0
 */
@Service("IProxyManager")
public class IProxyManagerImpl extends AbstractService implements
        IProxyManager {

	@Autowired
	private IProxyDao proxyDao;
	
	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		return proxyDao.queryPage(queryModel);
	}

	@Override
	public List<Proxy> getAll(){
		return proxyDao.getAll();
	}
}
