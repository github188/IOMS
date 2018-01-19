package cn.com.atnc.ioms.mng.tempcircuit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitTesKuBroadDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesKuBroad;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitTesKuBroadService;

/**
 * @author wangpeng
 * @date 2014-8-29 下午3:22:00
 * @version 1.0
 */
@Service("tempCircuitTesKuBroadService")
public class TempCircuitTesKuBroadServiceImpl extends AbstractService implements
		ITempCircuitTesKuBroadService {

	@Autowired
	private ITempCircuitTesKuBroadDao tempCircuitTesKuBroadDao;

	@Override
	public void add(TempCircuitTesKuBroad obj) {
		// TODO Auto-generated method stub
		tempCircuitTesKuBroadDao.saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCircuitTesKuBroad> findListByTempcircuitID(String id) {
		// TODO Auto-generated method stub
		return (List<TempCircuitTesKuBroad>) tempCircuitTesKuBroadDao
				.queryList(
						"from TempCircuitTesKuBroad where tempCircuit.id = ?",
						id);
	}

	@Override
	public TempCircuitTesKuBroad findById(String id) {
		// TODO Auto-generated method stub
		return tempCircuitTesKuBroadDao.findById(id);
	}

	@Override
	public void CancleTempCircuitTesKuBroadList(List<TempCircuitTesKuBroad> list) {
		// TODO Auto-generated method stub
		tempCircuitTesKuBroadDao.deleteList(list);
	}

}
