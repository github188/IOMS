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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeParameter;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeParameterDao;

/**
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:25:23
 * @since 1.0.0
 */
@Repository
public class KuNodeParameterDaoImpl extends MyBaseDao<KuNodeParameter> implements IKuNodeParameterDao {
	
	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuNodeParameter where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getBureau() != null) {
			hql.append(" and equipId.satelliteSite.bureau =:bureau");
			params.put("bureau", queryModel.getBureau());
		}
		if (StringUtils.isEmpty(queryModel.getStname()) == false) {
			hql.append(" and equipId.satelliteSite.siteName like:stname  escape '\\' ");
			params.put("stname", "%" + queryModel.getStname() + "%");
		}
		if(queryModel.getStartRecordTime() != null){
            hql.append(" and recordTime>=:startRecordTime");
            params.put("startRecordTime",queryModel.getStartRecordTime());
        }
        if(queryModel.getStartRecordTime() != null){
            hql.append(" and recordTime<=:endRecordTime");
            params.put("endRecordTime",queryModel.getEndRecordTime());
        }
		hql.append(" order by recordTime desc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Pagination queryViewPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from KuNodeParameter where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getKuNodeParameter() != null) { //id
			hql.append(" and id =:id");
			params.put("id", queryModel.getKuNodeParameter().getId());
		}
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

}
