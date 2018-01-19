package cn.com.atnc.ioms.dao.duty.satellite.day.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhDataStateDao;
import cn.com.atnc.ioms.entity.duty.satellite.SlhDataState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("SlhDataStateDao")
public class SlhDataStateDaoImpl extends MyBaseDao<SlhDataState> implements
		SlhDataStateDao {

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.day.SlhDataStateModel "
						+ "(a.atmb , a.id , a.checkid , e.checkDate , e.checkTime , e.operator ) "
						+ "from SlhDataState a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		List<Object> params = new ArrayList<Object>();
		StringBuilder q = new StringBuilder("");
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
				" select count(a.id) from SlhDataState a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		hql.append(q.toString());
		// 拼接分页查询部分
		String countHql = hql.toString();

		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SlhDataState> queryList(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from SlhDataState a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		if (StringUtils.isNotEmpty(queryModel.getOperator())) {
			hql.append(" and e.operator.name like  " + "'%"
					+ queryModel.getOperator() + "%'");
		}
		// 起始时间
		if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
			hql.append(" and to_char(e.checkTime,'yyyy-MM-dd HH:mm:ss' ) >= "
					+ "'"
					+ DateUtilTools.format(queryModel.getStartTime(),
							DateUtilTools.PATTERN_DATE_3) + "'");
		}
		// 结束时间
		if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
			hql.append(" and to_char(e.checkTime,'yyyy-MM-dd HH:mm:ss' ) >= "
					+ "'"
					+ DateUtilTools.format(queryModel.getEndTime(),
							DateUtilTools.PATTERN_DATE_3) + "'");
		}

		return (List<SlhDataState>) super.queryList(hql.toString());
	}

}
