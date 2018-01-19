/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteAttachDao.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.satellite.hibernate
 * @author ku
 * @date 2015年5月13日下午3:54:24
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.signoutnet.impl;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.signoutnet.ISignoutNetConfigDao;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNetConfig;

/**
 * 退网配置申请接口实现类
 *
 * @author 段衍林
 * @2017年1月13日 下午4:01:11
 */
@Repository
public class SignoutNetConfigDao extends MyBaseDao<SignoutNetConfig> implements
		ISignoutNetConfigDao {

}
