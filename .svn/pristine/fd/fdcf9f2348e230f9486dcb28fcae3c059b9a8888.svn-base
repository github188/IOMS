/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:46:54
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusLogDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:46:54
 * @version:1.0
 */
@Repository("kuNodeStatusLogDao")
public class KuNodeStatusLogDaoImpl extends MyBaseDao<KuNodeStatusLog>
		implements IKuNodeStatusLogDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.dao.basedata.ku.IKuNodeStatusLogDao#queryPage(cn.com.atnc.pcsp.model.operstat.ku.KuStatusLogQueryModel)
	 */
	@Override
	public Pagination queryPage(KuStatusLogQueryModel qm) {

		// TODO Auto-generated method stub

		StringBuilder hql = new StringBuilder("from KuNodeStatusLog where 1=1");
		List<Object> params = new ArrayList<Object>();

		if (qm.getStartTime() != null) {
			hql.append(" and recordTime >= ?");
			params.add(qm.getStartTime());
		}
		if (qm.getEndTime() != null) {
			hql.append(" and recordTime <= ?");
			params.add(qm.getEndTime());
		}
		if (StringTools.hasText(qm.getKuNodeId())) {
			hql.append(" and kuNode.id = ?");
			params.add(qm.getKuNodeId());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by recordTime desc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());

	}
	@SuppressWarnings("unchecked")
	public List<KuNodeStatusLog> findKlogByKuNodeId(KuStatusLogQueryModel qm) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder hql = new StringBuilder("from KuNodeStatusLog where 1=1");
		hql.append("and kuNode.id = :id");
		params.put("id", qm.getKuNodeId());
		return (List<KuNodeStatusLog>) super.queryList(hql.toString(), params);
	}

}
