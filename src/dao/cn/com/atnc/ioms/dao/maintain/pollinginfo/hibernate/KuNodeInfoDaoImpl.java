/**
 * @ProjectName IOMS
 * @FileName KuNodeParameterDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.ku.hibernate
 * @author KuYonggang
 * @date 2015年4月1日下午1:25:23
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.pollinginfo.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeInfoDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:25:23
 * @since 1.0.0
 */
@Repository
public class KuNodeInfoDaoImpl extends MyBaseDao<KuNodeInfo> implements
		IKuNodeInfoDao {

	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuNodeInfo where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getBureau() != null) {
			hql.append(" and equipId.satelliteSite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.isEmpty(queryModel.getStname()) == false) {
			hql.append(" and equipId.satelliteSite.siteName like:stname  escape '\\' ");
			params.put("stname", "%" + queryModel.getStname() + "%");
		}
		if (queryModel.getStartRecordTime() != null) {
			hql.append(" and recordTime>=:startRecordTime");
			params.put("startRecordTime", queryModel.getStartRecordTime());
		}
		if (queryModel.getStartRecordTime() != null) {
			hql.append(" and recordTime<=:endRecordTime");
			params.put("endRecordTime", queryModel.getEndRecordTime());
		}
		hql.append(" order by recordTime desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KuNodeInfo> findByMaintainEquip(
			List<MaintainEquip> maintainEquips) {
		// 根据设备ID和时间倒叙查找节点信息
		List<KuNodeInfo> kuNodeInfos = (List<KuNodeInfo>) super
				.queryList(
						"from KuNodeInfo where equipId in ? order by recordTime desc",
						maintainEquips.toArray());
		return kuNodeInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KuNodeInfo> findByMaintainEquip(MaintainEquip maintainEquip,
			Date date) {
		// hql语句
		StringBuilder hql = new StringBuilder("from KuNodeInfo where 1=1");
		// 参数
		List<Object> params = new ArrayList<Object>();
		// 维保设备ID
		hql.append(" and equipId = ?");
		params.add(maintainEquip);
		// 日期
		hql.append(" and recordTime between ? and ?");
		params.add(date);
		params.add(DateUtils.addDays(date, 1));
		return (List<KuNodeInfo>) super.queryList(hql.toString(), params.toArray());
	}

}
