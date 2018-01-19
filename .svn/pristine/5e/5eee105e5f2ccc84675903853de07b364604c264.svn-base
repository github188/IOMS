/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月13日下午4:04:00
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphApplyDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphApplyService;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 转报地址申请Service实现类
 *
 * @author WangLingbin
 * @date 2015年5月20日 下午3:18:08
 * @since 1.0.0
 */
@Service
@Transactional
public class TeleGraphApplyServiceImpl extends BaseService implements
		TeleGraphApplyService {

	@Autowired
	private TeleGraphApplyDao teleGraphApplyDao;
	@Autowired
	private TeleGraphDao teleGraphDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#queryPageByModel(cn.com.atnc.pcsp.model.business.satellite.KuSatelliteQueryModel)
	 */
	@Override
	public Pagination queryPageByModel(TeleGraphQueryModel queryModel) {
		return teleGraphApplyDao.queryPageByModel(queryModel);
	}

	@Override
	public List<TeleGraphApply> getAll() {
		return teleGraphApplyDao.getAll();
	}
	
	/**
	 * (non-Javadoc)
	 * @return 
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#save(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void save(TeleGraphApply teleGraphApply) {
		teleGraphApplyDao.save(teleGraphApply);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#getKuSatelliteById(java.lang.String)
	 */
	@Override
	public TeleGraphApply getTeleGraphApplyById(String id) {
		return teleGraphApplyDao.findById(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#update(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void update(TeleGraphApply teleGraphApply) {
		teleGraphApplyDao.update(teleGraphApply);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IKuSatelliteService#delete(cn.com.atnc.pcsp.entity.business.satellite.KuSatellite)
	 */
	@Override
	public void delete(TeleGraphApply teleGraphApply) {
		teleGraphApplyDao.delete(teleGraphApply);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.TeleGraphSystemService.mng.business.telegraph.TeleGraphApplyService#getApplysByParentId(java.lang.String)
	 */
	@Override
	public List<TeleGraphApply> getApplysByParentId(String id) {
		return teleGraphApplyDao.getApplysByParentId(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphApplyService#engineerTest(cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel, java.util.List, java.util.List, java.util.List)
	 */
	@Override
	public void engineerTest(TeleGraphQueryModel queryModel,
			List<String> allocatedAddrs, List<String> operPeoples,
			List<String> operTimes) {
		//根据ID获取转报地址申请对象
		List<TeleGraphApply> teleGraphApplys = teleGraphApplyDao.getApplysByParentId(queryModel.getId());
		for(int i = 0; i < allocatedAddrs.size();i++) {
			TeleGraphApply teleGraphApply = teleGraphApplys.get(i);
			teleGraphApply.setAllocatedAddr(allocatedAddrs.get(i));
			teleGraphApply.setOperPeople(operPeoples.get(i));
			teleGraphApply.setOperTime(DateUtilTools.getNowDateTime());
			teleGraphApplyDao.update(teleGraphApply);
		}
	}

}
