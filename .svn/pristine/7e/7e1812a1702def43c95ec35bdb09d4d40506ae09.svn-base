package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitConfDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitKUDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitKU;
import cn.com.atnc.ioms.enums.business.formalcircuit.CardEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.CommunicateWayEnum;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitKUManager;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * KU正式电路申请Service接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:57:19
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitKUManagerImpl extends BaseService implements
              IFormalCircuitKUManager {
	
	@Autowired
	private IFormalCircuitKUDao formalCircuitKUDao;
	@Autowired
	private IFormalCircuitDao formalCircuitDao;
	@Autowired
	private IFormalCircuitConfDao formalCircuitConfDao;
	
	@Override
	public void save(FormalCircuitKU formalCircuitKU) {
		formalCircuitKUDao.save(formalCircuitKU);
	}

	@Override
	public List<FormalCircuitKU> findByFC(FormalCircuit formalCircuit) {
		return formalCircuitKUDao.findByFC(formalCircuit);
	}

	@Override
	public void update(FormalCircuitKU formalCircuitKU) {
		formalCircuitKUDao.update(formalCircuitKU);
		
	}

	@Override
	public void delete(FormalCircuitKU formalCircuitKU) {
		formalCircuitKUDao.delete(formalCircuitKU);
		
	}

	@Override
	public void dealKUConf(String id, FormalCircuitQueryModel queryModel,
			List<String> kUConfTxSiteNames, List<String> kUConfTxNodes,
			List<String> kUConfTxSlots, List<String> kUConfTxPlots,
			List<String> kUConfRxSiteNames, List<String> kUConfRxNodes,
			List<String> kUConfRxSlots, List<String> kUConfRxPlots,
			List<String> kUConfSpeeds, List<String> kUConfCommunicateWays,
			List<String> kUConfUsages, List<String> kUConfTxCards,
			List<String> kUConfTxInterfaces, List<String> kUConfRxCards,
			List<String> kUConfRxInterfaces, List<String> kUConfCircuitNames,
			List<String> kUConfNos, String confRemark) {
		//获取正式电路实体
		FormalCircuit formalCircuit = formalCircuitDao.findById(id);
		FormalCircuitConfig circuitConfig = formalCircuit.getFormalCircuitConfig();
		//更新配置表中的备注信息
		if(circuitConfig != null) {
			circuitConfig.setRemark(confRemark);
			formalCircuitConfDao.update(circuitConfig);
			formalCircuitDao.update(formalCircuit);
		}
		List<FormalCircuitKU> formalCircuitKUs = this.findByFC(formalCircuit);
		//更新配置字段
		if(CollectionUtils.isNotEmpty(formalCircuitKUs)) {
			for(int i = 0; i < formalCircuitKUs.size();i++) {
				FormalCircuitKU formalCircuitKU = formalCircuitKUs.get(i);
				formalCircuitKU.setConfTxSiteName(kUConfTxSiteNames.get(i));
				formalCircuitKU.setConfTxNode(kUConfTxNodes.get(i));
				formalCircuitKU.setConfTxSlot(kUConfTxSlots.get(i));
				formalCircuitKU.setConfTxPlot(kUConfTxPlots.get(i));
				formalCircuitKU.setConfRxSiteName(kUConfRxSiteNames.get(i));
				formalCircuitKU.setConfRxNode(kUConfRxNodes.get(i));
				formalCircuitKU.setConfRxSlot(kUConfRxSlots.get(i));
				formalCircuitKU.setConfRxPlot(kUConfRxPlots.get(i));
				formalCircuitKU.setConfSpeed(kUConfSpeeds.get(i));
				formalCircuitKU.setConfCommunicateWay(CommunicateWayEnum.valueOf(kUConfCommunicateWays.get(i)));
				formalCircuitKU.setConfUsage(kUConfUsages.get(i));
				formalCircuitKU.setConfTxCard(CardEnum.valueOf(kUConfTxCards.get(i)));
				formalCircuitKU.setConfTxInterface(kUConfTxInterfaces.get(i));
				formalCircuitKU.setConfRxCard(CardEnum.valueOf(kUConfRxCards.get(i)));
				formalCircuitKU.setConfRxInterface(kUConfRxInterfaces.get(i));
				formalCircuitKU.setConfCircuitName(kUConfCircuitNames.get(i));
				formalCircuitKU.setConfNo(kUConfNos.get(i));
				this.update(formalCircuitKU);
			}
		}
		queryModel.setFormalCircuitKUli(formalCircuitKUs);
	}

}
