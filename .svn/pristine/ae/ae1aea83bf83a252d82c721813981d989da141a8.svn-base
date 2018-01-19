package cn.com.atnc.ioms.dao.duty.satellitemqy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ToolDao;
import cn.com.atnc.ioms.entity.duty.satellite.Tool;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 工具借用
 * 
 * @author shijiyong
 * @date 2016年10月31日 上午10:37:09
 * @version 1.0, 2016年10月18日 上午10:37:09
 */
@Repository("ToolDao")
public class ToolDaoImpl extends MyBaseDao<Tool> implements ToolDao {
	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hq = new StringBuilder(
				"select new cn.com.atnc.ioms.model.duty.statellite.mqy.ToolModel "
						+ "(a.name1 , a.name2 , a.name3 , a.name4 , a.name5 , "
						+ "a.name6 , a.name7 , a.name8 , a.name9 , a.name10 , "
						+ "a.num1 , a.num2 , a.num3 , a.num4 , a.num5 , "
						+ "a.num6 , a.num7 , a.num8 , a.num9 , a.num10 , "
						+ "a.remark1 , a.remark2 , a.remark3 , a.remark4 , a.remark5 , "
						+ "a.remark6 , a.remark7 , a.remark8 , a.remark9 , a.remark10"
						+ " , a.id , a.checkid , e.checkDate , e.checkTime , e.operator ) "
						+ "from Tool a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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
				" select count(a.id) from Tool a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id  ");
		hql.append(q.toString());
		// 拼接分页查询部分
		String countHql = hql.toString();
		return super.pageQuery(hq.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tool> queryList(EnvironmentCheckQueryModel queryModel) {

		StringBuilder hql = new StringBuilder(
				"from Tool a , EnvironmentEquipCheck e where 1=1 and a.checkid=e.id ");
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

		return (List<Tool>) super.queryList(hql.toString());
	}
}
