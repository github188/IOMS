package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.UpsContentCheckDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * ups巡检内容Dao实现
 * @author renyujuan
 * @date 2016年7月11日下午12:25:06
 */
@Repository("UpsContentCheckDao")
public class UpsContentCheckDaoImpl extends MyBaseDao<UpsContentCheck> implements
		UpsContentCheckDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UpsContentCheck> queryByModel(MeasureQueryModel queryModel) {
		StringBuilder hql=new StringBuilder("from UpsContentCheck u where 1=1");
		List<Object> params=new ArrayList<Object>(); 
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and u.upsCheck = ?");
			params.add(queryModel.getUpsCheck());
		}
		
		return (List<UpsContentCheck>) super.queryList(hql.toString(), params.toArray());
	}

}
