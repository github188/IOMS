package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.KuSysDao;
import cn.com.atnc.ioms.entity.duty.satellite.KuSys;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("KuSysDao")
public class KuSysDaoImpl extends MyBaseDao<KuSys> implements KuSysDao {

	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.mqy.KuSysModel "
						+ "(a.net1Workstate , a.net2Workstate , a.net3Workstate , a.net4Workstate , a.netzWorkstate , "
						+ "a.net1WorkstateBf , a.net2WorkstateBf , a.net3WorkstateBf , a.net4WorkstateBf , a.netzWorkstateBf , "
						+ "a.tapeLocate , a.workDust , a.forward , "
						+ "a.subnetWorkRemark , a.subnetDataRemark , a.tapeLocateRemark , a.workDustRemark , a.forwardRemark"
						+ " , a.id , a.checkid , e.checkDate , e.checkTime , e.operator ) "
						+ "from KuSys a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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
		// 巡檢類型
		if (!ObjectUtils.equals(queryModel.getCheckType(), null)) {
			q.append(" and e.checkType = '" + queryModel.getCheckType().name()
					+ "' ");
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
				" select count(a.id) from KuSys a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id  ");
		hql.append(q.toString());
		String countHql = hql.toString();

		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KuSys> queryList(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from KuSys a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
		// 查询操作人
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

		return (List<KuSys>) super.queryList(hql.toString());
	}
}
