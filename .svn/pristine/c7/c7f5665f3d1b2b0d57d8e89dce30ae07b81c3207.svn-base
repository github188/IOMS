/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:46:54
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusStat;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:46:54
 * @version:1.0
 */
@Repository("kuNodeStatusStatDao")
public class KuNodeStatusStatDaoImpl extends MyBaseDao<KuNodeStatusStat>
		implements IKuNodeStatusStatDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.dao.basedata.ku.IKuNodeStatusStatDao#queryPage(cn.com.atnc.pcsp.model.operstat.ku.KuStatusStatQueryModel)
	 */
	@Override
	public Pagination queryPage(KuStatQueryModel qm) {
		// TODO Auto-generated method stub

		StringBuilder hql = new StringBuilder("from KuNodeStatusStat where 1=1");
		List<Object> params = new ArrayList<Object>();

		if (qm.getStartTime() != null) {
			hql.append(" and statDate > ?");
			params.add(qm.getStartTime());
		}
		if (qm.getEndTime() != null) {
			hql.append(" and statDate <= ?");
			params.add(qm.getEndTime());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by statDate desc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.dao.basedata.ku.IKuNodeStatusStatDao#getLastStatId()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getLastStatId() {
		// TODO Auto-generated method stub

		String hql = "select id from KuNodeStatusStat"
				+ " where statDate=(select max(statDate) from KuNodeStatusStat)";
		List<String> result = (List<String>) super.queryList(hql);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

}
