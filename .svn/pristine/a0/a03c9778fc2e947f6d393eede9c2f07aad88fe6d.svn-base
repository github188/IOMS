package cn.com.atnc.ioms.mng.clientmng.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.clientmng.IClientOptLogDao;
import cn.com.atnc.ioms.entity.clientmng.ClientOptLog;
import cn.com.atnc.ioms.mng.clientmng.IClientOptLogService;

/**
 *类说明
 *@author 潘涛
 *@date 2014-6-10	下午1:18:21
 *@version:1.0
 */
@Service
public class ClientOptLogServiceImpl extends BaseService implements
		IClientOptLogService {
	@Autowired
	private IClientOptLogDao clientOptLogDao;
	@Override
	@Transactional
	public ClientOptLog add(ClientOptLog log) {
		return this.findById(clientOptLogDao.save(log));
	}
	@Override
	public ClientOptLog findById(Serializable id) {
		return this.clientOptLogDao.findById(id);
	}

}
