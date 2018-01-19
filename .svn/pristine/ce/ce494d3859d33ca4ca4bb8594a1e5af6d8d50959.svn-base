package cn.com.atnc.ioms.mng.techsupport.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.techsupport.fault.IFaultDeclareOptLogDao;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareOptLogQueryModel;

/**
 * 类说明：故障申报操作记录服务接口实现
 * 
 * @author：KuYonggang
 * @date：2014-4-15下午5:04:40
 * @version：1.0
 */
@Transactional
@Service
public class FaultDeclareOptLogServiceImpl extends BaseService implements
		IFaultDeclareOptLogService {
	@Autowired
	private IFaultDeclareOptLogDao faultDeclareOptLogDao;
	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareOptLogService#save(cn.com.atnc.ioms.enums.techsupport.fault.pcsp.entity.techsupport.fault.FaultDeclareOptLog)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	public void save(FaultDeclareOptLog faultDeclareOptLog) {
		faultDeclareOptLogDao.save(faultDeclareOptLog);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareOptLogService#findStatById(java.lang.String)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	@Transactional(readOnly=true)
	public FaultDeclareOptLog findById(String id) {
		return faultDeclareOptLogDao.findById(id);
	}
	
	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareOptLogService#queryPageByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareOptLogQueryModel)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	public Pagination queryPageByParam(FaultDeclareOptLogQueryModel model) {
		return faultDeclareOptLogDao.queryPageByParam(model);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareOptLogService#queryListByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareOptLogQueryModel)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	public List<FaultDeclareOptLog> queryListByParam(
			FaultDeclareOptLogQueryModel model) {
		return faultDeclareOptLogDao.queryListByParam(model);
	}

	/**
	 * @see cn.com.atnc.pcsp.mng.techsupport.fault.IFaultDeclareOptLogService#delete(java.lang.String)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	public void delete(String id) throws ServiceException {
		if(!StringUtils.hasText(id)){
			throw new ServiceException("该条记录ID为空！");
		}
		faultDeclareOptLogDao.delete(faultDeclareOptLogDao.findById(id));
	}

	/**
	 * @see cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService#findByFaultDeclareID(java.lang.String)
	 * FaultDeclareOptLogServiceImpl.java
	 */
	@Override
	public List<FaultDeclareOptLog> findByFaultDeclareId(String id) {
		return faultDeclareOptLogDao.findByFaultDeclareId(id);
	}

}
