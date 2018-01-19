package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitConfDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitTESDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitTES;
import cn.com.atnc.ioms.enums.business.formalcircuit.CommunicateWayEnum;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitTESManager;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * TES正式电路申请Service接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:57:19
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitTESManagerImpl extends BaseService implements
              IFormalCircuitTESManager {

	@Autowired
	private IFormalCircuitTESDao formalCircuitTESDao;
	@Autowired
	private IFormalCircuitDao formalCircuitDao;
	@Autowired
	private IFormalCircuitConfDao formalCircuitConfDao;
	
	@Override
	public void save(FormalCircuitTES formalCircuitTES) {
		formalCircuitTESDao.save(formalCircuitTES);
	}

	@Override
	public List<FormalCircuitTES> findByFC(FormalCircuit formalCircuit) {
		return formalCircuitTESDao.findByFC(formalCircuit);
	}

	@Override
	public void update(FormalCircuitTES formalCircuitTES) {
		formalCircuitTESDao.update(formalCircuitTES);
		
	}

	@Override
	public void delete(FormalCircuitTES formalCircuitTES) {
		formalCircuitTESDao.delete(formalCircuitTES);
		
	}

	@Override
	public void dealTESConf(String id, FormalCircuitQueryModel queryModel,
			List<String> tESConfTxSiteNames, List<String> tESConfTxCaseNums,
			List<String> tESConfTxSlotNums, List<String> tESConfRxSiteNames,
			List<String> tESConfRxCaseNums, List<String> tESConfRxSlotNums,
			List<String> tESConfSpeeds, List<String> tESConfCommunicateWays,
			List<String> tESConfUsages, List<String> tESConfTxInterfaces,
			List<String> tESConfRxInterfaces, List<String> tESConfClocks,
			List<String> tESConfCircuitNames, List<String> tESConfNos,
			String confRemark) {
		//获取正式电路实体
		FormalCircuit formalCircuit = formalCircuitDao.findById(id);
		FormalCircuitConfig circuitConfig = formalCircuit.getFormalCircuitConfig();
		//更新配置表中的备注信息
		if(circuitConfig != null) {
			circuitConfig.setRemark(confRemark);
			formalCircuitConfDao.update(circuitConfig);
			formalCircuitDao.update(formalCircuit);
		}
		List<FormalCircuitTES> formalCircuitTESs = this.findByFC(formalCircuit);
		//更新配置字段
		if(CollectionUtils.isNotEmpty(formalCircuitTESs)) {
			for(int i = 0; i < formalCircuitTESs.size(); i++) {
				FormalCircuitTES formalCircuitTES = formalCircuitTESs.get(i);
				formalCircuitTES.setConfTxSiteName(tESConfTxSiteNames.get(i));
				formalCircuitTES.setConfTxCaseNum(tESConfTxCaseNums.get(i));
				formalCircuitTES.setConfTxSlotNum(tESConfTxSlotNums.get(i));
				formalCircuitTES.setConfRxSiteName(tESConfRxSiteNames.get(i));
				formalCircuitTES.setConfRxCaseNum(tESConfRxCaseNums.get(i));
				formalCircuitTES.setConfRxSlotNum(tESConfRxSlotNums.get(i));
				formalCircuitTES.setConfSpeed(tESConfSpeeds.get(i));
				formalCircuitTES.setConfCommunicateWay(CommunicateWayEnum.valueOf(tESConfCommunicateWays.get(i)));
				formalCircuitTES.setConfUsage(tESConfUsages.get(i));
				if(CollectionUtils.isNotEmpty(tESConfTxInterfaces)){
					formalCircuitTES.setConfTxInterface(tESConfTxInterfaces.get(i));
				}
				if(CollectionUtils.isNotEmpty(tESConfRxInterfaces)){
					formalCircuitTES.setConfRxInterface(tESConfRxInterfaces.get(i));
				}
				formalCircuitTES.setConfClock(tESConfClocks.get(i));
				formalCircuitTES.setConfCircuitName(tESConfCircuitNames.get(i));
				formalCircuitTES.setConfNo(tESConfNos.get(i));
				this.save(formalCircuitTES);
			}
		}
		queryModel.setFormalCircuitTESli(formalCircuitTESs);
	}


}
