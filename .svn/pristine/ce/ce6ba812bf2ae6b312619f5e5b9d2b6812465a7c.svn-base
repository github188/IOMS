/**
 * @ProjectName PCSP
 * @FileName TeleGraphDaoImpl.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.telegraph.impl
 * @author WangLingbin
 * @date 2015年6月18日上午10:01:53
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.telegraph.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphConfigDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig;

/**
 * 配置信息DAO实现类
 * @author WangLingbin
 * @date 2015年6月18日 上午10:01:53
 * @since 1.0.0
 */
@Repository
public class TeleGraphConfigDaoImpl extends MyBaseDao<TeleGraphConfig> implements
	TeleGraphConfigDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TeleGraphConfig> getConfigsByTeleGraphId(String id) {
		List<TeleGraphConfig> teleGraphConfigs = (List<TeleGraphConfig>) queryList(
				"from TeleGraphConfig where teleGraph.id = ?", id);
		return teleGraphConfigs;
	}

}
