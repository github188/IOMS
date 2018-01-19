package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.SystemMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 系统检查Dao实现
 * @author renyujuan
 * @date 2016年7月11日上午10:58:30
 */
@Repository("SystemMeasure")
public class SystemMeasureDaoImpl extends MyBaseDao<SystemMeasure> implements
		SystemMeasureDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemMeasure> queryByModel(MeasureQueryModel queryModel) {
		StringBuilder hql=new StringBuilder("from SystemMeasure s where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and s.upsCheck = ?");
			params.add(queryModel.getUpsCheck());
		}
		return  (List<SystemMeasure>) super.queryList(hql.toString(), params.toArray());
	}

}
