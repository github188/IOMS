package cn.com.atnc.ioms.dao.duty.environment.ups.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeProcessDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeProcess;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.model.duty.environment.ups.DischargeProcessQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
/**
 * 放电过程Dao实现
 * @author renyujuan
 * @date 2016年7月11日下午1:19:46
 */
@Repository("DischargeProcessDao")
public class DischargeProcessDaoImpl extends MyBaseDao<DischargeProcess> implements
		DischargeProcessDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DischargeProcess> queryByModel(DischargeProcessQueryModel queryModel) {
		
		StringBuilder hql=new StringBuilder("from DischargeProcess d where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getDischargeTest(), null)){
			hql.append(" and d.dischargeTest = ?");
			params.add(queryModel.getDischargeTest());
		}
		return (List<DischargeProcess>) super.queryList(hql.toString(),params.toArray());
		
	}

}
