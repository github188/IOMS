package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.CheckDao;
import cn.com.atnc.ioms.entity.duty.satellite.Check;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 
 * @author shijiyong
 * @date 2016年11月8日 上午10:37:09
 * @version 1.0, 2016年11月8日 上午10:37:09
 */
@Repository("CheckDao")
public class CheckDaoImpl extends MyBaseDao<Check> implements CheckDao {
	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.mqy.CheckModel ("
						+ "a.address1 , a.address2 , a.address3 , a.address4 , a.address5 , "
						+ "a.address6 , a.address7 , a.address8 , a.address9 , a.address10 , "
						+ "a.address11 , a.address12 , a.address13 , a.address14 , a.address15 , "
						+ "a.address16 , a.address17 , a.address18 , a.address19 , a.address20 , "
						+ "a.address21 , a.address22 , a.address23 , a.address24 , a.address25 , a.address26 , "
						+ "a.remark1 , a.remark2 , a.remark3 , a.remark4 , a.remark5 , "
						+ "a.remark6 , a.remark7 , a.remark8 , a.remark9 , a.remark10 ,"
						+ "a.remark11 , a.remark12 , a.remark13 , a.remark14 , a.remark15 , "
						+ "a.remark16 , a.remark17 , a.remark18 , a.remark19 , a.remark20 ,"
						+ "a.remark21 , a.remark22 , a.remark23 , a.remark24 , a.remark25 ,a.remark26 , "
						+ "a.num1 , a.num2 , a.num3 , a.num4 , a.num5 , "
						+ "a.num6 , a.num7 , a.num8 , a.num9 , a.num10 , "
						+ "a.num11 , a.num12 , a.num13 , a.num14 , a.num15 , "
						+ "a.num16 , a.num17 , a.num18 , a.num19 , a.num20 , "
						+ "a.num21 , a.num22 , a.num23 , a.num24 , a.num25 , a.num26 , "
						+ "a.total , a.id , a.checkid , e.checkDate , e.checkTime , e.operator,e.name ) "
						+ "from Check a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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
			q.append(" and e.checkType = '" + queryModel.getCheckType().name() + "' ");
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
		//拼接查询语句
		hq.append(q.toString());
		StringBuilder hql = new StringBuilder(
				" select count(a.id) from Check a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id  ");
		hql.append(q.toString());
		//拼接分页查询部分
		String countHql = hql.toString();

		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> queryList(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from Check a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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

		return (List<Check>) super.queryList(hql.toString());
	}
}
