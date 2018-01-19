package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitConfDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitConfManager;


/**
 * 正式电路配置Service实现
 *
 * @author WangLingbin
 * @date 2015年7月30日 下午1:20:32
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitConfManagerImpl extends BaseService implements
              IFormalCircuitConfManager {
	
	@Autowired
	private IFormalCircuitConfDao formalCircuitConfDao;

	@Override
	public void save(FormalCircuitConfig formalCircuitConfig) {
		formalCircuitConfDao.save(formalCircuitConfig);
	}

	@Override
	public void update(FormalCircuitConfig formalCircuitConfig) {
		formalCircuitConfDao.update(formalCircuitConfig);
	}

	@Override
	public void delete(FormalCircuitConfig formalCircuitConfig) {
		formalCircuitConfDao.delete(formalCircuitConfig);
	}

}
