package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.SystemConnMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 系统连接检查Dao实现
 * @author renyujuan
 * @date 2016年7月11日上午9:39:50
 */
@Repository("SystemConnMeasureDao")
public class SystemConnMeasureDaoImpl extends MyBaseDao<SystemConnMeasure> implements
		SystemConnMeasureDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemConnMeasure> queryByModel(MeasureQueryModel queryModel) {
		StringBuilder hql=new StringBuilder("from SystemConnMeasure s where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and s.upsCheck= ? ");
			params.add(queryModel.getUpsCheck());
		}
		
		return (List<SystemConnMeasure>) super.queryList(hql.toString(),params.toArray()); 
	}

}
