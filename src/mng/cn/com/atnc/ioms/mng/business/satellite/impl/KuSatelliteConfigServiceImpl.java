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

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.satellite.hibernate.KuSatelliteConfigDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteConfig;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteConfigService;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;

/**
 * 民航卫星网地球站入网配置Service实现类
 *
 * @author WangLingbin
 * @date 2015年10月22日 上午11:44:38
 * @since 1.0.0
 */
@Service
@Transactional
public class KuSatelliteConfigServiceImpl extends BaseService implements
		IKuSatelliteConfigService {

	@Autowired
	private KuSatelliteConfigDao kuSatelliteConfigDao;
	@Autowired
	private IKuSatelliteService kuSatelliteService;
	
	@SuppressWarnings("unchecked")
	@Override
	public KuSatelliteConfig findByKuSateId(String id) {
		List<KuSatelliteConfig> kuSatelliteConfigs = 
				(List<KuSatelliteConfig>) kuSatelliteConfigDao.queryList("from KuSatelliteConfig where kuSatellite.id = ?", id);
		if(CollectionUtils.isNotEmpty(kuSatelliteConfigs)) {
			return kuSatelliteConfigs.get(0);
		} else {
			return null;
		}
	}

	@Override
	public KuSatelliteConfig findById(String id) {
		return kuSatelliteConfigDao.findById(id);
	}

	@Override
	public void save(KuSatelliteConfig kuSatelliteConfig) {
		kuSatelliteConfigDao.save(kuSatelliteConfig);		
	}

	@Override
	public void update(KuSatelliteConfig kuSatelliteConfig) {
		kuSatelliteConfigDao.update(kuSatelliteConfig);
	}

	@Override
	public void delete(KuSatelliteConfig kuSatelliteConfig) {
		kuSatelliteConfigDao.delete(kuSatelliteConfig);
	}

	@Override
	public void config(KuSatelliteQueryModel queryModel, User user,
			String node, String mediumFrequency, String emissionFrequency,
			String receiveFrequency) {
		KuSatellite kuSatellite = (KuSatellite) kuSatelliteService.findById(queryModel.getId());
		KuSatelliteConfig kuSatelliteConfig = new KuSatelliteConfig(
				kuSatellite, 
				node, 
				mediumFrequency, 
				emissionFrequency, 
				receiveFrequency, 
				user.getName(), 
				new Date());
		this.save(kuSatelliteConfig);
	}


}
