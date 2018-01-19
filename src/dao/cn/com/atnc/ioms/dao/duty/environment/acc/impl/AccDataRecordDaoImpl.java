package cn.com.atnc.ioms.dao.duty.environment.acc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.acc.AccDataRecordDao;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccDataRecord;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * @author renyujuan
 * @Description:空调设备数据记录Dao实现
 * @time:2016年8月11日 上午11:05:14
 */
@Repository("AccDataRecordDao")
public class AccDataRecordDaoImpl extends MyBaseDao<AccDataRecord> implements
	AccDataRecordDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<AccDataRecord> queryByModel(
	    EnvironmentEquipCheckQueryModel queryModel) {
	StringBuilder hql = new StringBuilder("from AccDataRecord a where 1=1");
	List<Object> params = new ArrayList<Object>();
	if(!ObjectUtils.equals(queryModel.getEeCheck(), null)) {
	    hql.append(" and a.accCheck = ? ");
	    params.add(queryModel.getEeCheck());
	}
	return (List<AccDataRecord>) super.queryList(hql.toString(), params.toArray());
    }

}
