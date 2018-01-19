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
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitTesDbDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesDb;

/**
 * 
 * 类说明：TempCircuitTesDb DAO实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:03:07
 * @version:1.0
 */
@Repository("tempCircuitTesDbDao")
public class TempCircuitTesDbDaoImpl extends MyBaseDao<TempCircuitTesDb>
		implements ITempCircuitTesDbDao {

	@SuppressWarnings("unchecked")
	@Override
	public TempCircuitTesDb getByTempcircuitId(String id) {
		// TODO Auto-generated method stub
		List<TempCircuitTesDb> list = (List<TempCircuitTesDb>) queryList(
				"from TempCircuitTesDb where tempCircuit.id = ?", id);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
