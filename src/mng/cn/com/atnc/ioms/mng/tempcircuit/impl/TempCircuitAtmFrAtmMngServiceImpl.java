/* Copyright © 2008 BEIJING ATNC CO,.LTD yanfashengchan department
 * All rights reserved
 *
 * create on 2008-11-12 上午11:51:59
 * author:huangyijie E-mail:aroon2008@gmail.com
 */
package cn.com.atnc.ioms.mng.tempcircuit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitAtmFrAtmDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitAtmFrAtm;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitAtmFrAtmMngService;

/**
 * 
 * 类说明：临时电路服务接口实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午9:38:48
 * @version:1.0
 */
@Service("tempCircuitAtmFrAtmMngService")
public class TempCircuitAtmFrAtmMngServiceImpl extends AbstractService
		implements ITempCircuitAtmFrAtmMngService {
	@Autowired
	private ITempCircuitAtmFrAtmDao tempCircuitAtmFrAtmDao;

	@Override
	public TempCircuitAtmFrAtm add(TempCircuitAtmFrAtm obj)
			throws ServiceException {
		// TODO Auto-generated method stub
		tempCircuitAtmFrAtmDao.save(obj);
		return obj;
	}

	@Override
	public TempCircuitAtmFrAtm getTempCircuitAtmFrAtmByTempcircuitID(String id)
			throws ServiceException {
		// TODO Auto-generated method stub
		return tempCircuitAtmFrAtmDao.getByTempcircuitId(id);
	}

	@Override
	public TempCircuitAtmFrAtm update(TempCircuitAtmFrAtm obj)
			throws ServiceException {
		// TODO Auto-generated method stub
		tempCircuitAtmFrAtmDao.saveOrUpdate(obj);
		return obj;
	}
}
