/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:32:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.tempcircuit.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitOptLogDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;

/**
 * 
 * 类说明：临时电路审批日志DAO实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:03:07
 * @version:1.0
 */
@Repository("tempCircuitOptLogDao")
public class TempCircuitOptLogDaoImpl extends MyBaseDao<TempCircuitOptLog>
		implements ITempCircuitOptLogDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCircuitOptLog> findByTempCircuitID(String id) {
		// TODO Auto-generated method stub
		return (List<TempCircuitOptLog>) super
				.queryList(
						"from TempCircuitOptLog where tempCircuit.id=? order by optTime asc",
						id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TempCircuitOptLog findLatestByTempcircuitID(String id) {
		// TODO Auto-generated method stub
		List<TempCircuitOptLog> list = (List<TempCircuitOptLog>) super
				.queryList(
						"from TempCircuitOptLog where tempCircuit.id = ? order by optTime desc",
						id);
		return list.size() > 0 ? list.get(0) : null;
	}
}
