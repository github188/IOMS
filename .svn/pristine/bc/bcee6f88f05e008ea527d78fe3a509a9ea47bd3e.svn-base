package cn.com.atnc.ioms.dao.publicnotice.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.publicnotice.IPnNoticeOptLogDao;
import cn.com.atnc.ioms.entity.publicnotice.PnNoticeOptLog;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;
import cn.com.atnc.ioms.model.publicnotice.PnNoticeOptLogQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-5-5 下午3:13:40
 * @version:1.0
 */
@Repository("PnNoticeOptLogDao")
public class PnNoticeOptLogDaoImpl extends MyBaseDao<PnNoticeOptLog> implements IPnNoticeOptLogDao {

	@Override
	public Pagination queryPageByParam(PnNoticeOptLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PnNoticeOptLog> queryListByParam(
			PnNoticeOptLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from PnNoticeOptLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (null!=queryModel.getPnNotice()) {
			hql.append(" and pnNotice =:pnNotice");
			params.put("pnNotice", queryModel.getPnNotice());
		}
		return (List<PnNoticeOptLog>) super.queryList(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PnNoticeOptLog> findByPnNoticeOptLogId(String id) {
		// TODO Auto-generated method stub
		return  (List<PnNoticeOptLog>) this.queryList(
				"from PnNoticeOptLog where pnNotice.id=? order by optTime asc",
				id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PnNoticeOptLog findLatestByPnNoticeOptLogID(String id) {
		// TODO Auto-generated method stub
		List<PnNoticeOptLog> list = (List<PnNoticeOptLog>) super
				.queryList(
						"from PnNoticeOptLog where pnNotice.id = ? order by optTime desc",
						id);
		return list.size() > 0 ? list.get(0) : null;
	}

}
