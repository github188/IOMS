/**
 * @ProjectName IOMS
 * @FileName TeleGraphConfigImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.business.telegraph.impl
 * @author WangLingbin
 * @date 2015年5月29日上午9:37:35
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphConfigDao;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig;
import cn.com.atnc.ioms.enums.business.telegraph.ConnectionConditionEnum;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 转报地址配置Service实现类
 *
 * @author WangLingbin
 * @date 2015年5月29日 上午9:37:35
 * @since 1.0.0
 */
@Service
@Transactional
public class TeleGraphConfigImpl extends BaseService implements TeleGraphConfigService{

	@Autowired
	private TeleGraphConfigDao teleGraphConfigDao;
	@Autowired
	private TeleGraphDao teleGraphDao;
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService#save(cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig)
	 */
	@Override
	public void save(TeleGraphConfig teleGraphConfig) {
		teleGraphConfigDao.save(teleGraphConfig);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService#getTeleGraphConfigById(java.lang.String)
	 */
	@Override
	public TeleGraphConfig getTeleGraphConfigById(String id) {
		return teleGraphConfigDao.findById(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService#update(cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig)
	 */
	@Override
	public void update(TeleGraphConfig teleGraphConfig) {
		teleGraphConfigDao.update(teleGraphConfig);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService#delete(cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig)
	 */
	@Override
	public void delete(TeleGraphConfig teleGraphConfig) {
		teleGraphConfigDao.delete(teleGraphConfig);
	}

	@Override
	public void config(TeleGraphQueryModel queryModel,
			List<String> identifiers, List<String> atncRountAddrs,
			List<String> atncConfigPeoples,
			List<String> atncConnectionConditions) {
		//根据ID获取转报地址对象
		TeleGraph teleGraph = teleGraphDao.findById(queryModel.getId());
		//String atncConnectionCondition = null;
		for(int i = 0; i < atncRountAddrs.size();i++) {
			TeleGraphConfig teleGraphConfig = new TeleGraphConfig();
			teleGraphConfig.setTeleGraph(teleGraph);
			teleGraphConfig.setIdentifier(identifiers.get(i));
			teleGraphConfig.setAtncRountAddr(atncRountAddrs.get(i));
			teleGraphConfig.setAtncConfigTime(DateUtilTools.getNowDateTime());
			teleGraphConfig.setAtncConfigPeople(atncConfigPeoples.get(i));
/*			if(StringUtils.equalsIgnoreCase(atncConnectionConditions.get(i), "8X")) {
				atncConnectionCondition = "E8X";
			} else{
				atncConnectionCondition = atncConnectionConditions.get(i);
			}*/
			teleGraphConfig.setAtncConnectionCondition(ConnectionConditionEnum.getConnectionConditionEnumByValue(atncConnectionConditions.get(i)));
			teleGraphConfigDao.save(teleGraphConfig);
		}
	}
	
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.business.telegraph.TeleGraphConfigService#getConfigsByTeleGraphId(java.lang.String)
	 */
	@Override
	public List<TeleGraphConfig> getConfigsByTeleGraphId(String id) {
		return teleGraphConfigDao.getConfigsByTeleGraphId(id);
	}
	
}
