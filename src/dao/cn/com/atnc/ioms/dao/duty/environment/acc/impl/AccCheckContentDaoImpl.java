package cn.com.atnc.ioms.dao.duty.environment.acc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.acc.AccCheckContentDao;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccCheckContent;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
@Repository("AccCheckContentDao")
public class AccCheckContentDaoImpl extends MyBaseDao<AccCheckContent> implements
	AccCheckContentDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<AccCheckContent> queryByModel(
	    EnvironmentEquipCheckQueryModel queryModel) {
	StringBuilder hql = new StringBuilder("from AccCheckContent a where 1=1");
	List<Object> params = new ArrayList<Object>();
	if(!ObjectUtils.equals(queryModel.getEeCheck(), null)) {
	    hql.append(" and a.accCheck = ? ");
	    params.add(queryModel.getEeCheck());
	}
	return   (List<AccCheckContent>) super.queryList(hql.toString(), params.toArray());
    }

}
