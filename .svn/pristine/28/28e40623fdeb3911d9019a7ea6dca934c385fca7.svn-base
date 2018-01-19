/**
 * @ProjectName IOMS_CIRCUIT
 * @FileName KuSatelliteAttachServiceImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月29日下午2:16:56
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.satellite.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.ioms.dao.business.satellite.IKuSatelliteAttachDao;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteAttach;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService;
import cn.com.atnc.common.service.BaseService;

/**
 * ku入网附件信息Service接口实现类
 *
 * @author ku
 * @date 2015年5月29日 下午2:16:56
 * @since 1.0.0
 */
@Service
@Transactional
public class KuSatelliteAttachServiceImpl extends BaseService implements
		IKuSatelliteAttachService {

	@Autowired
	private IKuSatelliteAttachDao kuSatelliteAttachDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService#queryListByKuSateId(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true,timeout=3)
	public List<KuSatelliteAttach> queryListByKuSateId(String id) {
		return (List<KuSatelliteAttach>) kuSatelliteAttachDao.queryList("from KuSatelliteAttach where kuSatellite.id = ?", id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteAttachService#findById(java.lang.String)
	 */
	@Override
	public KuSatelliteAttach findById(String id) {
		return kuSatelliteAttachDao.findById(id);
	}

}
