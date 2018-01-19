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

import java.util.List;

import cn.com.atnc.ioms.entity.business.satellite.KuSatelliteAttach;

/**
 * ku入网附件信息Service接口
 *
 * @author ku
 * @date 2015年5月29日 下午2:14:50
 * @since 1.0.0
 */
public interface IKuSatelliteAttachService {
	
	/**
	 * 根据KU卫星网入网申请记录ID查询对应的上传附件集合
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月28日下午4:12:51
	 * @since 1.0.0
	 */
	List<KuSatelliteAttach> queryListByKuSateId(String id);

	/**
	 * 根据ID查询附件实体
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月29日下午2:54:25
	 * @since 1.0.0
	 */
	KuSatelliteAttach findById(String id);
}
