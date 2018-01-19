package cn.com.atnc.ioms.mng.business.datacomnetwork.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.datacomnetwork.IDataComNetworkConfDao;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkConfig;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkConfManager;

/**
 * 数据通信网配置Service方法实现
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:04:47
 * @since 1.0.0
 */
@Service
@Transactional
public class DataComNetworkConfManagerImpl extends BaseService implements
              IDataComNetworkConfManager {
	
	@Autowired
	private IDataComNetworkConfDao dataComNetworkConfDao;

	@Override
	public void save(DataComNetworkConfig dataComNetworkConfig) {
		dataComNetworkConfDao.save(dataComNetworkConfig);
	}

	@Override
	public void update(DataComNetworkConfig dataComNetworkConfig) {
		dataComNetworkConfDao.update(dataComNetworkConfig);;
	}

	@Override
	public void delete(DataComNetworkConfig dataComNetworkConfig) {
		dataComNetworkConfDao.delete(dataComNetworkConfig);
	}

}
