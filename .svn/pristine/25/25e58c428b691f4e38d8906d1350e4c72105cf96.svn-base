package cn.com.atnc.ioms.mng.business.evaluete.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.evaluate.IApplyEvaluateDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;
import cn.com.atnc.ioms.mng.business.evaluete.IEvalueteManager;

 /**
 * 用户评价Service接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:57:19
 * @since 1.0.0
 */
@Service
@Transactional
public class EvaluateManagerImpl extends BaseService implements
               IEvalueteManager {

	@Autowired
	private IApplyEvaluateDao applyEvaluateDao;
	
	@Override
	public void save(ApplyEvaluate applyEvaluate) {
		applyEvaluateDao.save(applyEvaluate);
	}

	@Override
	public ApplyEvaluate findByABI(ApplyBaseInfo applyBaseInfo) {
		List<ApplyEvaluate> aeli = applyEvaluateDao.queryList(applyBaseInfo);
		if(aeli.size()>0){
			return aeli.get(0);
		}else{
			return new ApplyEvaluate();
		}
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.evaluete.IEvalueteManager#findByApplyBaseInfoId(java.lang.String)
	 */
	@Override
	public Object findByApplyBaseInfoId(String id) {
		return applyEvaluateDao.findByParam("applyBaseInfo.id", id);
	}

}
