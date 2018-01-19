package cn.com.atnc.ioms.dao.duty.satellite.day.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.TxjdConWorkDao;
import cn.com.atnc.ioms.entity.duty.satellite.TxjdConWork;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月28日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("TxjdConWorkDao")
public class TxjdConWorkDaoImpl extends MyBaseDao<TxjdConWork> implements
		TxjdConWorkDao {

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.day.TxjdConWorkModel "
						+ "( a.control100101 , a.control100102 , a.control100103 , a.control100104 , "
						+ "a.control100201 , a.control100202 , a.control100203 , a.control100204 , "
						+ "a.control100301 , a.control100302 , a.control100303 , a.control100304 , "
						+ "a.control100401 , a.control100402 , a.control100403 , a.control100404 , "
						+ "a.id , a.checkid , e.checkDate , e.checkTime , e.operator) "
						+ "from TxjdConWork a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		List<Object> params = new ArrayList<Object>();
		StringBuilder q = new StringBuilder("");
		// 操作人
		if (StringUtils.isNotEmpty(queryModel.getOperator())) {
			q.append(" and e.operator.name like  " + "'%"
					+ queryModel.getOperator() + "%'");
		}
		// id
		if (StringUtils.isNotEmpty(queryModel.getId())) {
			q.append(" and a.id = '" + queryModel.getId() + "'");
		}
		// 起始时间
		if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
			q.append(" and to_char(e.checkTime,'yyyy-MM-dd HH:mm:ss' ) >= "
					+ "'"
					+ DateUtilTools.format(queryModel.getStartTime(),
							DateUtilTools.PATTERN_DATE_3) + "'");
		}
		// 结束时间
		if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
			q.append(" and to_char(e.checkTime,'yyyy-MM-dd HH:mm:ss' ) >= "
					+ "'"
					+ DateUtilTools.format(queryModel.getEndTime(),
							DateUtilTools.PATTERN_DATE_3) + "'");
		}
		// 按时间倒序排序
		q.append(" order by e.checkTime desc ");
		// 拼接查询语句
		hq.append(q.toString());
		StringBuilder hql = new StringBuilder(
				" select count(a.id) from TxjdConWork a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		hql.append(q.toString());
		// 拼接分页查询部分
		String countHql = hql.toString();

		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
