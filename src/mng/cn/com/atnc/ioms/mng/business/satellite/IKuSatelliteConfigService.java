/**
 * @ProjectName IOMS_CIRCUIT
 * @FileName IKuSatelliteAttachService.java
 * @PackageName:cn.com.atnc.ioms.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月29日下午2:14:50
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.satellite;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteConfig;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;

/**
 * 民航卫星网地球站入网配置Service
 * @author WangLingbin
 * @date 2015年10月22日 上午11:44:18
 * @since 1.0.0
 */
public interface IKuSatelliteConfigService {
	
	/**
	 * 根据父类ID查找实体
	 * @param id	父类ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:06:05
	 * @since 1.0.0
	 */
	KuSatelliteConfig findByKuSateId(String id);

	/**
	 * 根据ID查找实体
	 * @param id	配置实体ID
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:06:26
	 * @since 1.0.0
	 */
	KuSatelliteConfig findById(String id);
	
	/**
	 * 保存实体
	 * @param kuSatelliteConfig 
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:06:52
	 * @since 1.0.0
	 */
	void save(KuSatelliteConfig kuSatelliteConfig);
	
	/**
	 * 更新实体
	 * @param kuSatelliteConfig 
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:07:00
	 * @since 1.0.0
	 */
	void update(KuSatelliteConfig kuSatelliteConfig);
	
	/**
	 * 删除实体
	 * @param kuSatelliteConfig 
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:07:12
	 * @since 1.0.0
	 */
	void delete(KuSatelliteConfig kuSatelliteConfig);

	/**
	 * 保存配置实体
	 * @author WangLingbin
	 * @date  2015年10月22日下午1:15:11
	 * @since 1.0.0
	 */
	void config(KuSatelliteQueryModel queryModel, User user, String node,
			String mediumFrequency, String emissionFrequency,
			String receiveFrequency);
	
}
