package cn.com.atnc.ioms.dao.turndutymng.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.dao.turndutymng.ITimeControlDao;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.entity.turndutymng.TimeControl;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;

@Repository("ITimeControlDao")
public class TimeControlDaoImpl extends MyBaseDao<TimeControl> implements ITimeControlDao{
	
	public List<TimeControl> getTimeControl() {
	
		StringBuilder hql = new StringBuilder();
		hql.append(" from TimeControl where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		return (List<TimeControl>) super.queryList(hql.toString(),params);
	}
}
