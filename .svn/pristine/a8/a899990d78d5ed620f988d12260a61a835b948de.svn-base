/* Copyright © 2008 BEIJING ATNC CO,.LTD yanfashengchan department
 * All rights reserved
 *
 * create on 2008-11-12 上午11:51:59
 * author:huangyijie E-mail:aroon2008@gmail.com
 */
package cn.com.atnc.ioms.mng.tempcircuit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitDao;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitOptLogDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitOptLog;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitOptLogMngService;

/**
 * 
 * 类说明：临时电路审批日志服务接口实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月27日上午10:43:36
 * @version:1.0
 */
@Service("tempCircuitOptLogService")
public class TempCircuitOptLogMngServiceImpl extends AbstractService implements
		ITempCircuitOptLogMngService {
	@Autowired
	private ITempCircuitOptLogDao tempCircuitOptLogDao;
	@Autowired
	private ITempCircuitDao tempCircuitDao;

	@Override
	public String add(TempCircuitOptLog obj) {
		// TODO Auto-generated method stub
		return tempCircuitOptLogDao.save(obj).toString();
	}

	@Override
	public List<TempCircuitOptLog> findByTempcircuitID(String tempCircuitID) {
		// TODO Auto-generated method stub
		return tempCircuitOptLogDao.findByTempCircuitID(tempCircuitID);
	}

	@Override
	public TempCircuitOptLog findLatestByTempcircuitID(String tempCircuitID) {
		// TODO Auto-generated method stub
		return tempCircuitOptLogDao.findLatestByTempcircuitID(tempCircuitID);
	}
}
