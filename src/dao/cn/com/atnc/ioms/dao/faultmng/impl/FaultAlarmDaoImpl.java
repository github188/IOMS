package cn.com.atnc.ioms.dao.faultmng.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAlarmDao;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;

/**
 * 事件单与告警绑定管理Dao接口实现类
 *
 * @author 段衍林
 * @2017年1月19日 下午1:30:28
 */
@Repository("faultAlarmDao")
public class FaultAlarmDaoImpl extends MyBaseDao<FaultAlarm> implements
		IFaultAlarmDao {

	/**
	 * 分页查询
	 */
	@Override
	public Pagination queryPage(FaultAlarmQueryModel queryModel) {

		// 查询告警事件单数据库
		StringBuilder hql = new StringBuilder(" from FaultAlarm where 1=1 ");
		// 封装查询变量
		List<Object> params = new ArrayList<Object>();
		// 告警事件单处置状态
		if (!ObjectUtils.equals(queryModel.getStatus(), null)) {
			hql.append(" and status = ?");
			params.add(queryModel.getStatus());
		}
		// 按完成后的更新时间倒序
		hql.append(" order by createTime desc ");
		// 分页查询
		String countHql = "select count(id) " + hql.toString();
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * 列表查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultAlarm> queryList(FaultAlarmQueryModel queryModel) {
		// 查询告警事件单数据库
		StringBuilder hql = new StringBuilder(" from FaultAlarm where 1=1 ");
		// 封装查询变量
		List<Object> params = new ArrayList<Object>();
		// 告警设备
		if (!ObjectUtils.equals(queryModel.getEquip(), null)) {
			hql.append(" and equip = ?");
			params.add(queryModel.getEquip());
		}
		// 告警站点
		if (!ObjectUtils.equals(queryModel.getProxy(), null)) {
			hql.append(" and proxy = ?");
			params.add(queryModel.getProxy());
		}
		// 状态列表
		if (CollectionUtils.isNotEmpty(queryModel.getStatuses())) {
			// 状态in列表
			hql.append(" and status in (");
			for (int i = 0; i < queryModel.getStatuses().size(); i++) {
				if (i == queryModel.getStatuses().size() - 1) {
					hql.append("?");
				} else {
					hql.append("?,");
				}
				params.add(queryModel.getStatuses().get(i));
			}
			hql.append(") ");
		}
		// 按完成后的更新时间倒序
		hql.append(" order by createTime desc ");
		return (List<FaultAlarm>) super.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaultAlarm> findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate) {
		// hql语句
		StringBuilder hql = new StringBuilder(" from FaultAlarm where 1=1 ");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 维保设备
		hql.append(" and equip = ?");
		params.add(maintainEquip);
		// 日期
		hql.append(" and createTime between ? and ?");
		params.add(currentDate);
		params.add(DateUtils.addDays(currentDate, 1));
		return (List<FaultAlarm>) super.queryList(hql.toString(),
				params.toArray());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultAlarm> findByEquipAndDate(
			List<MaintainEquip> maintainEquips, Date currentDate) {
		// hql语句
		StringBuilder hql = new StringBuilder(" from FaultAlarm where 1=1 ");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 维保设备
		hql.append(" and equip in (");
		for (int i = 0; i < maintainEquips.size(); i++) {
			if (i == maintainEquips.size() - 1) {
				hql.append("?");
			} else {
				hql.append("?,");
			}
			params.add(maintainEquips.get(i));
		}
		hql.append(") ");
		// 日期
		hql.append(" and createTime between ? and ?");
		params.add(currentDate);
		params.add(DateUtils.addDays(currentDate, 1));
		return (List<FaultAlarm>) super.queryList(hql.toString(),
				params.toArray());
	}
	
	/**
	 * 阈值告警 查询list
	 */
	public List<FaultAlarm> findByStatus(FaultAlarmQueryModel queryModel) {

		// 查询告警事件单数据库
		StringBuilder hql = new StringBuilder(" from FaultAlarm where 1=1 ");
		// 封装查询变量
		List<Object> params = new ArrayList<Object>();
		// 告警事件单处置状态
		if (!ObjectUtils.equals(queryModel.getStatus(), null)) {
			hql.append(" and status = ?");
			params.add(queryModel.getStatus());
		}
		// 按完成后的更新时间倒序
		hql.append(" order by createTime desc ");
	
		return (List<FaultAlarm>) super.queryList(hql.toString(), params.toArray());
	}

}