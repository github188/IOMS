package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.QEquDao;
import cn.com.atnc.ioms.entity.duty.satellite.QEqu;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("QEquDao")
public class QEquDaoImpl extends MyBaseDao<QEqu> implements QEquDao {
	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.mqy.QEquModel "
						+ "(a.indoorTesJx , a.indoorTesNormal , a.indoorTesInnormal , "
						+ "a.indoorPesJx , a.indoorPesNormal , a.indoorPesInnormal , "
						+ "a.indoorKu1Jx , a.indoorKu1Normal , a.indoorKu1Innormal , "
						+ "a.indoorKu2Jx , a.indoorKu2Normal , a.indoorKu2Innormal , "
						+ "a.indoorKu3Jx , a.indoorKu3Normal , a.indoorKu3Innormal , "
						+ "a.indoorKu4Jx , a.indoorKu4Normal , a.indoorKu4Innormal , "
						+ "a.indoorKuJx , a.indoorKuNormal , a.indoorKuInnormal , "
						+ "a.indoorComJx , a.indoorComNormal , a.indoorComInnormal , "
						+ "a.slhTesJx , a.slhTesNormal , a.slhTesInnormal , "
						+ "a.mhjTesJx , a.mhjTesNormal , a.mhjTesInnormal , "
						+ "a.slhKuJx , a.slhKuNormal , a.slhKuInnormal , "
						+ "a.mhjKuJx , a.mhjKuNormal , a.mhjKuInnormal , "
						+ "a.kuTestJx , a.kuTestNormal , a.kuTestInnormal , "
						+ "a.outdoorTesJx , a.outdoorTesNormal , a.outdoorTesInnormal , "
						+ "a.outdoorPesJx , a.outdoorPesNormal , a.outdoorPesInnormal , "
						+ "a.outdoorKuJx , a.outdoorKuNormal , a.outdoorKuInnormal , "
						+ "a.outdoorComJx , a.outdoorComNormal , a.outdoorComInnormal , "
						+ "a.outdoorSlhtesJx , a.outdoorSlhtesNormal , a.outdoorSlhtesInnormal , "
						+ "a.outdoorMhjtesJx , a.outdoorMhjtesNormal , a.outdoorMhjtesInnormal , "
						+ "a.outdoorSlhkuJx , a.outdoorSlhkuNormal , a.outdoorSlhkuInnormal , "
						+ "a.outdoorMhjkuJx , a.outdoorMhjkuNormal , a.outdoorMhjkuInnormal , "
						+ "a.outdoorKucsJx , a.outdoorKucsNormal , a.outdoorKucsInnormal , "
						+ "a.wgTesJx , a.wgTesNormal , a.wgTesInnormal , "
						+ "a.wgPesJx , a.wgPesNormal , a.wgPesInnormal , "
						+ "a.wgKu1Jx , a.wgKu1Normal , a.wgKu1Innormal , "
						+ "a.wgKu2Jx , a.wgKu2Normal , a.wgKu2Innormal , "
						+ "a.wgKu3Jx , a.wgKu3Normal , a.wgKu3Innormal , "
						+ "a.wgKu4Jx , a.wgKu4Normal , a.wgKu4Innormal , "
						+ "a.wgKuJx , a.wgKuNormal , a.wgKuInnormal , "
						+ "a.indoorTesRemark , a.indoorPesRemark , a.indoorKu1Remark , a.indoorKu2Remark , a.indoorKu3Remark , "
						+ "a.indoorKu4Remark , a.indoorRelayRemark , a.indoorOutRemark , a.indoorSlhTes , a.indoorMhjTes , "
						+ "a.indoorSlhKu , a.indoorMhjKu , a.indoorKuTest , "
						+ "a.outdoorTesRemark , a.outdoorPesRemark , a.outdoorKuRemark , a.outdoorSlhTes , a.outdoorMhjTes , "
						+ "a.outdoorSlhKu , a.outdoorMhjKu , a.outdoorKuTest , a.outdoorOutRemark , "
						+ "a.wgTesRemark , a.wgPesRemark , a.wgKu1Remark , a.wgKu2Remark , a.wgKu3Remark , a.wgKu4Remark , a.wgRelayKu"
						+ " , a.id , a.checkid , e.checkDate , e.checkTime , e.operator ) "
						+ "from QEqu a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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
				" select count(a.id) from QEqu a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id  ");
		hql.append(q.toString());
		// 拼接分页查询部分
		String countHql = hql.toString();

		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QEqu> queryList(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from QEqu a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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

		return (List<QEqu>) super.queryList(hql.toString());
	}
}
