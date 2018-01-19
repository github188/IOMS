package cn.com.atnc.ioms.dao.duty.environment.dg.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.dg.DgCheckContentDao;
import cn.com.atnc.ioms.entity.duty.environment.dg.DgCheckContent;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 柴油发电机巡检内容Dao实现
 * @author renyujuan
 * @date 2016年8月9日上午9:12:57
 */
@Repository("DgCheckContentDao")
public class DgCheckContentDaoImpl extends MyBaseDao<DgCheckContent> implements
		DgCheckContentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DgCheckContent> queryByModel(
			EnvironmentEquipCheckQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from DgCheckContent d where 1=1");
		ArrayList<Object> params = new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getEeCheck(), null)){
			hql.append(" and d.dgCheck = ?");
			params.add(queryModel.getEeCheck());
		}
		
		return (List<DgCheckContent>) super.queryList(hql.toString(), params.toArray());
	}


}
