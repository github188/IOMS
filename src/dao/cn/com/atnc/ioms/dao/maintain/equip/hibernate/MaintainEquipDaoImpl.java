/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName MaintainEquipDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.equip.hibernate
 * @author ku
 * @date 2015年4月30日上午11:06:29
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.equip.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.equip.IMaintainEquipDao;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * 运维设备Dao实现类
 *
 * @author ku
 * @date 2015年4月30日 上午11:06:29
 * @since 1.0.0
 */
@Repository
public class MaintainEquipDaoImpl extends MyBaseDao<MaintainEquip> implements
		IMaintainEquipDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.equip.IEquipDao#findAlarmMonitorByEquip()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainEquip> findAlarmMonitorByEquip() {
		StringBuilder hql = new StringBuilder(
				" from MaintainEquip e where e.type in (?,?,?)");
		List<Object> params = new ArrayList<Object>();
		params.add(NetworkType.wafr08);
		params.add(NetworkType.kuanacomodu);
		params.add(NetworkType.kumodemcard);
		return (List<MaintainEquip>) this.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainEquip> queryWAFList() {
		StringBuilder hql = new StringBuilder(
				" from MaintainEquip e where e.type in (?)");
		List<Object> params = new ArrayList<Object>();
		params.add(NetworkType.wafr08);
		return (List<MaintainEquip>) this.queryList(hql.toString(),
				params.toArray());
	}

	@Override
	public Pagination findBySatellite(SatelliteQueryModel queryModel) {
		// hql语句
		StringBuilder hql = new StringBuilder(
				"select new cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel(e.satelliteSite) from MaintainEquip e where 1=1");
		// 查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		// 站点名称
		if (StringUtils.isNotEmpty(queryModel.getSiteNameLike())) {
			hql.append(" and e.satelliteSite.siteName like '%"
					+ queryModel.getSiteNameLike() + "%'  escape '\\' ");
		}
		hql.append(" group by e.satelliteSite");
		// 总记录条数
		StringBuilder count = new StringBuilder(
				"select count(distinct satelliteSite) from MaintainEquip where 1=1 group by satelliteSite");
		String countHql = count.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainEquip> findBySiteAndType(NetworkType type,
			SatelliteSite satelliteSite) {
		// hql语句
		StringBuilder hql = new StringBuilder("from MaintainEquip where 1=1");
		// 查询参数
		List<Object> params = new ArrayList<Object>();
		// 维保设备名称
		hql.append(" and type = ?");
		params.add(type);
		// 站点
		hql.append(" and satelliteSite = ?");
		params.add(satelliteSite);
		return (List<MaintainEquip>) this.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainEquip> findAllOrderBy() {
		return (List<MaintainEquip>) super
				.queryList("from MaintainEquip where 1=1 order by satelliteSite asc,equip asc");
	}

}
