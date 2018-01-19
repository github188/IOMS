package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitATMDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitConfDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitATM;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.enums.business.formalcircuit.AtmCircuitTypeEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.SignalTypeEnum;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitATMManager;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * ATM正式电路申请Service接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:57:19
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitATMManagerImpl extends BaseService implements
              IFormalCircuitATMManager {

	@Autowired
	private IFormalCircuitATMDao formalCircuitATMDao;
	@Autowired
	private IFormalCircuitDao formalCircuitDao;
	@Autowired
	private IFormalCircuitConfDao formalCircuitConfDao;
	
	@Override
	public void save(FormalCircuitATM formalCircuitATM) {
		formalCircuitATMDao.save(formalCircuitATM);
	}

	@Override
	public List<FormalCircuitATM> findByFC(FormalCircuit formalCircuit) {
		return formalCircuitATMDao.findByFC(formalCircuit);
	}

	@Override
	public void update(FormalCircuitATM formalCircuitATM) {
		formalCircuitATMDao.update(formalCircuitATM);
		
	}

	@Override
	public void delete(FormalCircuitATM formalCircuitATM) {
		formalCircuitATMDao.delete(formalCircuitATM);
		
	}

	@Override
	public void dealATMConf(String id, FormalCircuitQueryModel queryModel,
			List<String> aTMConfTxNodeNames, List<String> aTMConfTxSlodNums,
			List<String> aTMConfTxLines, List<String> aTMConfTxPorts,
			List<String> aTMConfTxVpiDlcis, List<String> aTMConfRxNodeNames,
			List<String> aTMConfRxSlodNums, List<String> aTMConfRxLines,
			List<String> aTMConfRxPorts, List<String> aTMConfRxVpiDlcis,
			List<String> aTMConfSpeeds, List<String> aTMConfServiceTypes,
			List<String> aTMConfUsages, List<String> aTMConfTxSignals,
			List<String> aTMConfRxSignals, List<String> aTMConfNos,
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
		List<FormalCircuitATM> formalCircuitATMs = this.findByFC(formalCircuit);
		//更新配置字段
		if(CollectionUtils.isNotEmpty(formalCircuitATMs)) {
			for(int i = 0; i < formalCircuitATMs.size(); i++) {
				FormalCircuitATM formalCircuitATM = formalCircuitATMs.get(i);
				formalCircuitATM.setConfTxNodeName(aTMConfTxNodeNames.get(i));
				formalCircuitATM.setConfTxSlodNum(aTMConfTxSlodNums.get(i));
				//formalCircuitATM.setConfTxLine(aTMConfTxLines.get(i));
				formalCircuitATM.setConfTxPort(aTMConfTxPorts.get(i));
				formalCircuitATM.setConfTxVpiDlci(aTMConfTxVpiDlcis.get(i));
				formalCircuitATM.setConfTxSignal(SignalTypeEnum.valueOf(aTMConfTxSignals.get(i)));
				formalCircuitATM.setConfRxNodeName(aTMConfRxNodeNames.get(i));
				formalCircuitATM.setConfRxSlodNum(aTMConfRxSlodNums.get(i));
				//formalCircuitATM.setConfRxLine(aTMConfRxLines.get(i));
				formalCircuitATM.setConfRxPort(aTMConfRxPorts.get(i));
				formalCircuitATM.setConfRxVpiDlci(aTMConfRxVpiDlcis.get(i));
				formalCircuitATM.setConfRxSignal(SignalTypeEnum.valueOf(aTMConfRxSignals.get(i)));
				formalCircuitATM.setConfServiceType(AtmCircuitTypeEnum.valueOf(aTMConfServiceTypes.get(i)));
				formalCircuitATM.setConfSpeed(aTMConfSpeeds.get(i));
				//formalCircuitATM.setConfServiceType();
				formalCircuitATM.setConfUsage(aTMConfUsages.get(i));
				formalCircuitATM.setConfNo(aTMConfNos.get(i));
				this.update(formalCircuitATM);
			}
		}
		queryModel.setFormalCircuitATMli(formalCircuitATMs);
	}
}
