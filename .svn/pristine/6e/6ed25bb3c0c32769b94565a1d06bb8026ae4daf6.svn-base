package cn.com.atnc.ioms.dao.basedata.resource.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.resource.IProxyDao;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * 代理站点Dao接口实现类
 *
 * @author ku
 * @date 2015年6月17日 下午5:33:43
 * @since 1.0.0
 */
@Repository
public class ProxyDaoImpl extends MyBaseDao<Proxy> implements IProxyDao {

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from Proxy where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
