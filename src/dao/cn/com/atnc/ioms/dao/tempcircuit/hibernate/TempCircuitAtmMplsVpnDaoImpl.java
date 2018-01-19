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
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitAtmMplsVpnDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitAtmMplsVpn;

/**
 * 
 * 类说明：TempCircuitAtmMplsVpn DAO实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:03:07
 * @version:1.0
 */
@Repository("tempCircuitAtmMplsVpnDao")
public class TempCircuitAtmMplsVpnDaoImpl extends
		MyBaseDao<TempCircuitAtmMplsVpn> implements ITempCircuitAtmMplsVpnDao {

	@SuppressWarnings("unchecked")
	@Override
	public TempCircuitAtmMplsVpn getByTempcircuitId(String id) {
		// TODO Auto-generated method stub
		List<TempCircuitAtmMplsVpn> list = (List<TempCircuitAtmMplsVpn>) queryList(
				"from TempCircuitAtmMplsVpn where tempCircuit.id = ?", id);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
