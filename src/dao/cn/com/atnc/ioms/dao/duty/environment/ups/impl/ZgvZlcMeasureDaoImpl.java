package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.ZgvZlcMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 零地电压和零地电流测量Dao实现
 * @author renyujuan
 * @date 2016年7月11日下午12:55:26
 */
@Repository("ZgvZlcMeasureDao")
public class ZgvZlcMeasureDaoImpl extends MyBaseDao<ZgvZlcMeasure> implements
		ZgvZlcMeasureDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ZgvZlcMeasure> queryByModel(MeasureQueryModel queryModel) {
		StringBuilder hql=new StringBuilder("from ZgvZlcMeasure z where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getUpsCheck(), null)){
			hql.append(" and z.upsCheck = ? ");
			params.add(queryModel.getUpsCheck());
		}
		return (List<ZgvZlcMeasure>) super.queryList(hql.toString(), params.toArray());
	}

}
