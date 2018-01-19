package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeTestDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 放电测试Dao
 * @author renyujuan
 * @date 2016年7月11日下午12:45:19
 */
@Repository("DischargeTestDao")
public class DischargeTestDaoImpl extends MyBaseDao<DischargeTest> implements
		DischargeTestDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DischargeTest> queryByModel(MeasureQueryModel queryModel) {
	
		StringBuilder hql=new StringBuilder("from DischargeTest d where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and d.upsCheck= ?");
			params.add(queryModel.getUpsCheck());
		}
		return (List<DischargeTest>) super.queryList(hql.toString(),params.toArray());
	}

}
