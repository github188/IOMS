package cn.com.atnc.ioms.mng.systemmng.clientlog;

/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午4:15:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.systemmng.clientlog.IClientLogDao;
import cn.com.atnc.ioms.entity.systemmng.clientlog.ClientLog;
import cn.com.atnc.ioms.model.systemmng.clientlog.ClientLogQueryModel;

/**
 * 客户日志业务逻辑处理实现
 * 
 * @author:xiongzhikang
 * @date:2014-4-8
 */
@Service("ClientLogManager")
public class ClientLogManagerImpl extends AbstractService implements
		IClientLogManager {
	@Autowired
	private IClientLogDao logDao;

	@Override
	@Transactional
	public String add(ClientLog log) {
		return logDao.save(log).toString();
	}

	@Override
	public Pagination queryPage(ClientLogQueryModel qm) {
		return logDao.queryPage(qm);
	}

	@Override
	public List<String> queryOptType() {
		return logDao.queryOptType();
	}

	
	

}
