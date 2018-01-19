/**
 * @ProjectName IOMS
 * @FileName OduPollingDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.odu.hibernate
 * @author KuYonggang
 * @date 2015年4月1日下午2:17:02
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.pollinginfo.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IOduPollingDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * ODU设备轮询Dao实现类
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午2:17:02
 * @since 1.0.0
 */
@Repository
public class OduPollingDaoImpl extends MyBaseDao<OduPolling> implements
		IOduPollingDao {

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from OduPolling where 1=1");
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
	public List<OduPolling> findByMaintainEquip(List<MaintainEquip> modems) {
		// 根据设备ID和时间倒叙查找节点信息
		List<OduPolling> oduPollings = (List<OduPolling>) super.queryList(
				"from OduPolling where equipId in ? order by recordTime desc",
				modems.toArray());
		return oduPollings;
	}

}
