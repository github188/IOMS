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

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao;

/**
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:25:23
 * @since 1.0.0
 */
@Repository
public class KuCarrierFreqDaoImpl extends MyBaseDao<KuCarrierFreq> implements IKuCarrierFreqDao {
    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 根据相同设备号查询KU节点载波频率
	 * @see cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao#queryPage(cn.com.atnc.ioms.model.maintain.pollinginfo.KuCarrierFreqQueryModel)
	 */
	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("select new cn.com.atnc.ioms.model.maintain.pollinginfo.KuCarrierFreqModel(a.equipId ,a.recordTime) from KuCarrierFreq a where 1=1 group by a.recordTime,a.equipId");
		StringBuilder count = new StringBuilder("select count(id) from KuCarrierFreq where 1=1 group by equipId,recordTime");
		Map<String, Object> params = new HashMap<String, Object>();
		String countHql = count.toString();
		hql.append(" order by recordTime desc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	/**
	 * 根据相同设备号查询KU节点载波频率
	 * @see cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao#queryPage(cn.com.atnc.ioms.model.maintain.pollinginfo.KuCarrierFreqQueryModel)
	 */
	@Override
	public List<Long> queryEquip() {
		StringBuilder hql = new StringBuilder("select count(equipId) from KuCarrierFreq where 1=1 group by equipId");
		String countHql = hql.toString();
		return (List<Long>) super.queryList(countHql);
	}
	
	/**
	 * 根据相同设备号查询KU节点载波频率
	 * @see cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao#queryPage(cn.com.atnc.ioms.model.maintain.pollinginfo.KuCarrierFreqQueryModel)
	 */
	@Override
	public Pagination queryViewPage(PollingInfoQueryModel queryModel) {
		if(queryModel.getRecordTime() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				String dString = sdf.format(queryModel.getRecordTime());
				Date date = sdf.parse(dString);
				queryModel.setRecordTime(date);
			} catch (Exception e) {
				return null;
			}
        }
		StringBuilder hql = new StringBuilder("from KuCarrierFreq where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getEquipId() != null) { //设备
			hql.append(" and equipId =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		if(queryModel.getRecordTime() != null){
            hql.append(" and recordTime=:recordTime");
            params.put("recordTime",queryModel.getRecordTime());
        }
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
		hql.append(" order by cast(cxr as float) asc, id asc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	
	/**
	 * 查找所有数据，返回List
	 * @see cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao#findAll()
	 */
	public List<KuCarrierFreq> findAll() {
		return super.getAll();
	}

}
