package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitConfDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitPESDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitConfig;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitPES;
import cn.com.atnc.ioms.enums.business.formalcircuit.CommunicateWayEnum;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitPESManager;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

/**
 * PES正式电路申请Service接口实现类
 *
 * @author 段衍林
 * @2017年1月5日 上午10:39:09
 */
@Service
@Transactional
public class FormalCircuitPESManagerImpl extends BaseService implements
		IFormalCircuitPESManager {

	@Autowired
	private IFormalCircuitPESDao formalCircuitPESDao;
	@Autowired
	private IFormalCircuitDao formalCircuitDao;
	@Autowired
	private IFormalCircuitConfDao formalCircuitConfDao;

	@Override
	public void save(FormalCircuitPES formalCircuitPES) {
		formalCircuitPESDao.save(formalCircuitPES);
	}

	@Override
	public List<FormalCircuitPES> findByFC(FormalCircuit formalCircuit) {
		return formalCircuitPESDao.findByFC(formalCircuit);
	}

	@Override
	public void update(FormalCircuitPES formalCircuitPES) {
		formalCircuitPESDao.update(formalCircuitPES);

	}

	@Override
	public void delete(FormalCircuitPES formalCircuitPES) {
		formalCircuitPESDao.delete(formalCircuitPES);

	}

	@Override
	public List<FormalCircuitPES> findBySiteAndCaseNum(
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums) {
		return formalCircuitPESDao.findBySiteAndCaseNum(PEStxSiteNames,
				PEStxCaseNums, PESrxSiteNames, PESrxCaseNums);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.business.formalcircuit.IFormalCircuitPESManager#checkPES(java.util.List,
	 *      java.util.List, java.util.List, java.util.List, java.util.List,
	 *      java.util.List, java.util.List)
	 */
	@Override
	public String checkPES(List<String> PESBusinessNames,
			List<String> PESrxSlotNums, List<String> PEStxSlotNums,
			List<String> PEStxSiteNames, List<String> PEStxCaseNums,
			List<String> PESrxSiteNames, List<String> PESrxCaseNums) {

		StringBuilder sb = new StringBuilder("");
		int len = PESBusinessNames.size();
		for (int i = 1; i < len; i = i + 2) {
			if (PESBusinessNames.get(i).equals(PESBusinessNames.get(i - 1)) == false) {
				sb.append("变更前后的业务名称需保持相同！");
			}
			if (PEStxSlotNums.get(i).equals(PEStxSlotNums.get(i - 1)) == false) {
				sb.append("变更前后的本端槽位号需保持相同！");
			}
			if (PESrxSlotNums.get(i).equals(PESrxSlotNums.get(i - 1)) == false) {
				sb.append("变更前后的对端槽位号需保持相同！");
			}
			if (PEStxSiteNames.get(i).equals(PEStxSiteNames.get(i - 1)) == false) {
				sb.append("变更前后的本端节点名称需保持相同！");
			}
			if (PESrxSiteNames.get(i).equals(PESrxSiteNames.get(i - 1)) == false) {
				sb.append("变更前后的对端节点名称需保持相同！");
			}
			if (PEStxCaseNums.get(i).equals(PEStxCaseNums.get(i - 1)) == false) {
				sb.append("变更前后的本端机箱号需保持相同！");
			}
			if (PESrxCaseNums.get(i).equals(PESrxCaseNums.get(i - 1)) == false) {
				sb.append("变更前后的本端机箱号需保持相同！");
			}
		}
		return sb.toString();
	}

	@Override
	public void dealPESConf(String id, FormalCircuitQueryModel queryModel,
			List<String> PESConfTxSiteNames, List<String> PESConfTxCaseNums,
			List<String> PESConfTxSlotNums, List<String> PESConfTxPortNums,
			List<String> PESConfRxSiteNames, List<String> PESConfRxCaseNums,
			List<String> PESConfRxSlotNums, List<String> PESConfRxPortNums,
			List<String> PESConfSpeeds, List<String> PESConfCommunicateWays,
			List<String> PESConfUsages, List<String> PESConfTxInterfaces,
			List<String> PESConfRxInterfaces, List<String> PESConfCircuitNames,
			List<String> PESConfNos, String confRemark) {
		// 获取正式电路实体
		FormalCircuit formalCircuit = formalCircuitDao.findById(id);
		FormalCircuitConfig circuitConfig = formalCircuit
				.getFormalCircuitConfig();
		// 更新配置表中的备注信息
		if (circuitConfig != null) {
			circuitConfig.setRemark(confRemark);
			formalCircuitConfDao.update(circuitConfig);
			formalCircuitDao.update(formalCircuit);
		}
		List<FormalCircuitPES> formalCircuitPESs = this.findByFC(formalCircuit);
		// 更新配置字段
		if (CollectionUtils.isNotEmpty(formalCircuitPESs)) {
			for (int i = 0; i < formalCircuitPESs.size(); i++) {
				FormalCircuitPES formalCircuitPES = formalCircuitPESs.get(i);
				formalCircuitPES.setConfTxSiteName(PESConfTxSiteNames.get(i));
				formalCircuitPES.setConfTxCaseNum(PESConfTxCaseNums.get(i));
				formalCircuitPES.setConfTxSlotNum(PESConfTxSlotNums.get(i));
				formalCircuitPES.setConfTxPortNum(PESConfTxPortNums.get(i));
				formalCircuitPES.setConfRxSiteName(PESConfRxSiteNames.get(i));
				formalCircuitPES.setConfRxCaseNum(PESConfRxCaseNums.get(i));
				formalCircuitPES.setConfRxSlotNum(PESConfRxSlotNums.get(i));
				formalCircuitPES.setConfRxPortNum(PESConfRxPortNums.get(i));
				formalCircuitPES.setConfSpeed(PESConfSpeeds.get(i));
				formalCircuitPES.setConfCommunicateWay(CommunicateWayEnum.valueOf(PESConfCommunicateWays.get(i)));
				formalCircuitPES.setConfUsage(PESConfUsages.get(i));
				if (CollectionUtils.isNotEmpty(PESConfTxInterfaces)) {
					formalCircuitPES.setConfTxInterface(PESConfTxInterfaces
							.get(i));
				}
				if (CollectionUtils.isNotEmpty(PESConfRxInterfaces)) {
					formalCircuitPES.setConfRxInterface(PESConfRxInterfaces
							.get(i));
				}
				formalCircuitPES.setConfCircuitName(PESConfCircuitNames.get(i));
				formalCircuitPES.setConfNo(PESConfNos.get(i));
				this.save(formalCircuitPES);
			}
		}
		queryModel.setFormalCircuitPESli(formalCircuitPESs);
	}
}
