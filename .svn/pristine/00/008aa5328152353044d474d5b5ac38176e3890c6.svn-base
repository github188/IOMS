/**
 * @ProjectName IOMS
 * @FileName LinkAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.pollinginfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.PollingInfoManager;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeInfoDao;

 /**
 * 此处添加类KuCarrierFreqManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午3:03:24
 * @since 1.0.0
 */
@Service("pollingInfoManager")
public class PollingInfoManagerImpl extends AbstractService implements
        PollingInfoManager {
	
	@Autowired
    private IKuNodeInfoDao kuNodeInfoDao;

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		return kuNodeInfoDao.queryPage(queryModel);
	}

}
