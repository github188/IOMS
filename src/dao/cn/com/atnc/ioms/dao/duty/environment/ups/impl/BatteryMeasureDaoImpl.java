package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.BatteryMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 电池测量Dao
 * @author renyujuan
 * @date 2016年7月11日下午12:43:56
 */
@Repository("BatteryMeasureDao")
public class BatteryMeasureDaoImpl extends MyBaseDao<BatteryMeasure> implements
	BatteryMeasureDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BatteryMeasure> queryByModel(MeasureQueryModel queryModel) {
		StringBuilder hql=new StringBuilder("from BatteryMeasure b where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and b.upsCheck = ? order by b.number asc");
			params.add(queryModel.getUpsCheck());
		}
		return (List<BatteryMeasure>) super.queryList(hql.toString(),params.toArray());
		
	}



	

}
