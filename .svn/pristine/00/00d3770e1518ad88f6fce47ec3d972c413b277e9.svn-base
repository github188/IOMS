package cn.com.atnc.ioms.mng.business.approveinfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.approveinfo.IApproveInfoDao;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;
import cn.com.atnc.ioms.mng.business.approveinfo.IApproveInfoService;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;

/**
 * 公共审批信息service接口实现类
 *
 * @author ku
 * @date 2015年5月15日 下午4:30:35
 * @since 1.0.0
 */
@Service
@Transactional
public class ApproveInfoServiceImpl extends BaseService implements
		IApproveInfoService {

	@Autowired
	private IApproveInfoDao approveInfoDao;

	@Override
	public void save(ApproveInfo approveInfo) {
		approveInfoDao.save(approveInfo);
	}
	
	@Override
	public List<ApproveInfo> getApproveInfoByBaseInfoId(String id) {
		return approveInfoDao.getApproveInfoByBaseInfoId(id);
	}

	@Override
	public int getReturnedApplyNumber(String id) {
		return approveInfoDao.getReturnedApplyNumber(id);
	}
	
	@Override
	public ApproveInfo findById(String id) {
		return approveInfoDao.findById(id);
	}

}
