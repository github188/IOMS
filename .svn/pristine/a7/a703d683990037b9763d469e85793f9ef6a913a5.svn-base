/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午9:04:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.TimeTools;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusLogDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuServiceDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerLogDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerStatDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusStat;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午9:04:25
 * @version:1.0
 */
@Service("SatelliteDataParser")
public class SatelliteDataParserImpl extends AbstractService implements
		ISatelliteDataParser {
	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IKuServiceDao kuServiceDao;
	@Autowired
	private IKuNodeStatusDao kuNodeStatusDao;
	@Autowired
	private IKuNodeStatusLogDao kuNodeStatusLogDao;
	@Autowired
	private IKuNodeStatusStatDao kuNodeStatusStatDao;
	@Autowired
	private ITesTxPowerDao tesTxPowerDao;
	@Autowired
	private ITesTxPowerLogDao tesTxPowerLogDao;
	@Autowired
	private ITesTxPowerStatDao tesTxPowerStatDao;

	@Autowired
	@Qualifier(value = "SystemConfigDBManagerImpl")
	private ISystemConfigManager sysConfigManager;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser#parseKuStatus(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseKuStatus(String jsonStr, String fileName)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<KuNodeStatus> kuNodeStatusList = null;
		try {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			kuNodeStatusList = (List<KuNodeStatus>) JacksonTools.jsonToList(
					jsonStr, KuNodeStatus.class);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuNodeStatusList)) {
			return;
		}
		System.out
				.println("kuNodeStatusList.size()：" + kuNodeStatusList.size());
		KuNodeStatusStat stat = new KuNodeStatusStat();
		stat.setInfo(fileName);
		if (sysConfigManager.getParam(SysFinals.kuNetworkStatusStandard) != null) {
			stat.setStatusStandard(sysConfigManager
					.getParam(SysFinals.kuNetworkStatusStandard));
		}
		stat.setEbnoTop(Double.valueOf(sysConfigManager
				.getParam(SysFinals.kuEbNoTopLimit)));
		stat.setRxLevelLow(Double.valueOf(sysConfigManager
				.getParam(SysFinals.kuRxLevelLowerLimit)));
		stat.setRxLevelTop(Double.valueOf(sysConfigManager
				.getParam(SysFinals.kuRxLevelTopLimit)));
		int total = kuNodeStatusList.size();
		Iterator<KuNodeStatus> kuNodeStatusIterator = kuNodeStatusList
				.iterator();

		while (kuNodeStatusIterator.hasNext()) {
			// 设置记录时间，用最后一条的ebno时间作为记录时间
			KuNodeStatus kuNodeStatus = kuNodeStatusIterator.next();

			if (stat.getStatDate() == null) {
				stat.setStatDate(kuNodeStatus.getEbnoTime());
			} else {
				if (kuNodeStatus.getEbnoTime() != null
						&& TimeTools.isForward(stat.getStatDate(),
								kuNodeStatus.getEbnoTime())) {
					stat.setStatDate(kuNodeStatus.getEbnoTime());
				}
			}

			logger.debug(kuNodeStatus.getKuNodeNo() + "----"
					+ TimeTools.toTimeStr(kuNodeStatus.getEbnoTime()));
			kuNodeStatus.setKuNodeStatusStat(stat);
			// 根据ku节点号关联上具体ku设备
			KuNodeQueryModel nodeqm = new KuNodeQueryModel();
			nodeqm.setKuNodeNo(String.valueOf(kuNodeStatus.getKuNodeNo()));
			List<KuNode> kuNodeList = kuNodeDao.queryList(nodeqm);
			if (CollectionUtils.isEmpty(kuNodeList)) {
				logger.error("数据库中不存在该Ku节点，节点号为" + kuNodeStatus.getKuNodeNo());
				kuNodeStatus.setInfo("数据库中不存在该Ku节点，节点号为"
						+ kuNodeStatus.getKuNodeNo());
			} else if (kuNodeList.size() > 1) {
				logger.error("数据库中存在多条记录，节点号为" + kuNodeStatus.getKuNodeNo());
				kuNodeStatus.setInfo("数据库中存在多条记录，节点号为"
						+ kuNodeStatus.getKuNodeNo());
			} else {
				kuNodeStatus.setKuNode(kuNodeList.get(0));
			}
			/*
			 * 如果kuNodeNumber、status为空、status值不为UP或者DOWN ebno为空、reLevel为空，返回
			 */
			if (kuNodeStatus.getKuNodeNo() == null
					|| kuNodeStatus.getStatus() == null
					|| (StringUtils.equals(kuNodeStatus.getStatus(), "UP") && StringUtils
							.equals(kuNodeStatus.getStatus(), "DOWN"))
					|| kuNodeStatus.getEbno() == null
					|| kuNodeStatus.getRxLevel() == null) {
				return;
			}
			// 统计ebno是否超限
			if (kuNodeStatus.getEbno() != null && stat.getEbnoTop() != null
					&& kuNodeStatus.getEbno().doubleValue() > stat.getEbnoTop()) {
				stat.setEbnoOver(stat.getEbnoOver() + 1);
			}
			// 判断rxlevel是否在阈值范围内
			if (kuNodeStatus.getRxLevel() != null
					&& stat.getRxLevelLow() != null
					&& stat.getRxLevelTop() != null
					&& (kuNodeStatus.getRxLevel().doubleValue() < stat
							.getRxLevelLow() || kuNodeStatus.getRxLevel()
							.doubleValue() > stat.getRxLevelTop())) {
				stat.setRxLevelOver(stat.getRxLevelOver() + 1);
			}
			// 判断network status是否上星
			if (StringTools.hasText(kuNodeStatus.getStatus())
					&& StringTools.hasText(sysConfigManager
							.getParam(SysFinals.kuNetworkStatusStandard))
					&& !kuNodeStatus
							.getStatus()
							.toUpperCase()
							.equals(sysConfigManager.getParam(
									SysFinals.kuNetworkStatusStandard)
									.toUpperCase())) {
				stat.setStatusOver(stat.getStatusOver() + 1);
			}

		}
		stat.setEbnoNormal(total - stat.getEbnoOver());
		stat.setRxLevelNormal(total - stat.getRxLevelOver());
		stat.setStatusNormal(total - stat.getStatusOver());
		kuNodeStatusChangeLog(kuNodeStatusList);
		kuNodeStatusStatDao.saveOrUpdate(stat);
		kuNodeStatusDao.saveOrUpdateList(kuNodeStatusList);
	}

	@Transactional
	public void kuNodeStatusChangeLog(List<KuNodeStatus> list) {
		// 查找数据库中最后一次保存的记录
		List<KuNodeStatus> lastestList = kuNodeStatusDao.getLastestList();
		Iterator<KuNodeStatus> newInterator = list.iterator();
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		if (CollectionUtils.isEmpty(lastestList)) {
			while (newInterator.hasNext()) {
				KuNodeStatus newRecord1 = newInterator.next();
				if (newRecord1.getStatus().equals("UP")) {

					newRecord1.setUP(1);
					newRecord1.setDOWN(0);
				} else {
					newRecord1.setUP(0);
					newRecord1.setDOWN(1);
				}
			}
			return;
		}

		List<KuNodeStatusLog> logList = new ArrayList<>();
		// 对比上次记录与新采集记录
		while (newInterator.hasNext()) {
			KuNodeStatus newRecord = newInterator.next();
			Iterator<KuNodeStatus> dbInterator = lastestList.iterator();
			while (dbInterator.hasNext()) {
				KuNodeStatus dbRecord = dbInterator.next();
				if (newRecord == null
						|| newRecord.getKuNode() == null
						|| dbRecord == null
						|| dbRecord.getKuNode() == null
						|| !newRecord.getKuNode().getId()
								.equals(dbRecord.getKuNode().getId())) {
					continue;
				}
				// 记录ebno变化历史
				if (newRecord.getEbno().compareTo(dbRecord.getEbno()) != 0) {
					KuNodeStatusLog log = new KuNodeStatusLog();
					log.setKuNodeNo(newRecord.getKuNodeNo());
					log.setKuStatus(newRecord);
					log.setKuNode(newRecord.getKuNode());
					log.setParam(SysFinals.ebno);
					log.setFrom(dbRecord.getEbno().toString());
					log.setTo(newRecord.getEbno().toString());
					log.setRecordTime(newRecord.getEbnoTime());
					logList.add(log);
				}
				// 记录rxlvl变化历史
				if (newRecord.getRxLevel().compareTo(dbRecord.getRxLevel()) != 0) {
					KuNodeStatusLog log = new KuNodeStatusLog();
					log.setKuNodeNo(newRecord.getKuNodeNo());
					log.setKuStatus(newRecord);
					log.setKuNode(newRecord.getKuNode());
					log.setParam(SysFinals.rxLevel);
					log.setFrom(dbRecord.getRxLevel().toString());
					log.setTo(newRecord.getRxLevel().toString());
					log.setRecordTime(newRecord.getRxLevelTime());
					logList.add(log);
				}
				// 记录UP、DOWN次数
				if (!dbRecord.getUP().equals(null)
						&& !dbRecord.getDOWN().equals(null)) {
					if (newRecord.getStatus().equals("UP")) {
						newRecord.setUP(dbRecord.getUP() + 1);
						newRecord.setDOWN(dbRecord.getDOWN());
					} else {
						newRecord.setUP(dbRecord.getUP());
						newRecord.setDOWN(dbRecord.getDOWN() + 1);
					}
				} else {
					dbRecord.setUP(0);
					dbRecord.setDOWN(0);
				}
				// 记录上星状态变化历史
				if (!newRecord.getStatus().equals(dbRecord.getStatus())) {
					KuNodeStatusLog log = new KuNodeStatusLog();
					log.setKuNodeNo(newRecord.getKuNodeNo());
					log.setKuStatus(newRecord);
					log.setKuNode(newRecord.getKuNode());
					log.setParam(SysFinals.networkStatus);
					log.setFrom(dbRecord.getStatus());
					log.setTo(newRecord.getStatus());
					log.setRecordTime(newRecord.getStatusTime());
					logList.add(log);
				}
				dbInterator.remove();
				break;
			}

		}
		kuNodeStatusLogDao.saveOrUpdateList(logList);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser#parseKuMaplist(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseKuMaplist(String jsonStr, String fileName)
			throws ServiceException {
		// 解析文件名称 -- dyl add
		String[] fileNames = fileName.split("\\_");
		String subnetTypeStr = fileNames[2].trim();
		System.err.println(subnetTypeStr);
		SubnetType subnetType = null;
		// TODO Auto-generated method stub
		List<KuService> kuServiceList = null;
		try {
			if (StringUtils.isNotEmpty(subnetTypeStr)) {
				subnetType = SubnetType.valueOf(subnetTypeStr);
			}
			kuServiceList = (List<KuService>) JacksonTools.jsonToList(jsonStr,
					KuService.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(kuServiceList)) {
			return;
		}
		kuServiceDao.updateServiceChangeType(ServiceChangeType.ADELETE);
		for (KuService kuService : kuServiceList) {
			kuService.setId(null);
			if (StringTools.hasText(kuService.getRxNodeNo())) {
				kuService.setRxNodeNo(kuService.getRxNodeNo().trim()
						.replace("*", ""));
			}
			if (StringTools.hasText(kuService.getTxNodeNo())) {
				kuService.setTxNodeNo(kuService.getTxNodeNo().trim()
						.replace("*", ""));
			}
			KuStatQueryModel qm = new KuStatQueryModel();
			// 子网类型
			qm.setSubnetTypeRx(subnetType);
			qm.setSubnetTypeTx(subnetType);

			qm.setRxNodeNo(kuService.getRxNodeNo());
			qm.setRxChan(kuService.getRxChan());
			qm.setRxGib(kuService.getRxGib());
			qm.setTxNodeNo(kuService.getTxNodeNo());
			qm.setTxChan(kuService.getTxChan());
			qm.setTxGib(kuService.getTxGib());
			List<KuService> list = kuServiceDao.queryList(qm);
			if (CollectionUtils.isEmpty(list)) {
				// 数据库中无记录，则新插入一条记录
				KuNodeQueryModel nodeqm = new KuNodeQueryModel();
				nodeqm.setKuNodeNo(kuService.getTxNodeNo());
				// 添加子网类型查询条件
				nodeqm.setSubnetType(subnetType);
				List<KuNode> kuNodeList = kuNodeDao.queryList(nodeqm);
				if (CollectionUtils.isEmpty(kuNodeList)) {
					logger.error("数据库中不存在该Ku节点，节点号为" + kuService.getTxNodeNo());
					continue;
				} else if (kuNodeList.size() > 1) {
					logger.error("数据库中存在多条记录，节点号为" + kuService.getTxNodeNo());
					continue;
				} else {
					kuService.setTxNode(kuNodeList.get(0));
				}

				nodeqm = new KuNodeQueryModel();
				nodeqm.setKuNodeNo(kuService.getRxNodeNo());
				// 添加子网类型查询条件
				nodeqm.setSubnetType(subnetType);
				kuNodeList = kuNodeDao.queryList(nodeqm);
				if (CollectionUtils.isEmpty(kuNodeList)) {
					logger.error("数据库中不存在该Ku节点，节点号为" + kuService.getRxNodeNo());
					continue;
				} else if (kuNodeList.size() > 1) {
					logger.error("数据库中存在多条记录，节点号为" + kuService.getRxNodeNo());
					continue;
				} else {
					kuService.setRxNode(kuNodeList.get(0));
				}
				// 设定当前业务状态为“新增”
				kuService.setServiceChangeType(ServiceChangeType.BNEW);

				kuServiceDao.save(kuService);
			} else if (list.size() > 2) {
				logger.error("子网类型(" + subnetType.getValue() + ")" + "发端("
						+ kuService.getTxNodeNo() + "-" + kuService.getTxGib()
						+ "-" + kuService.getTxChan() + ")至收端("
						+ kuService.getRxNodeNo() + "-" + kuService.getRxGib()
						+ "-" + kuService.getRxChan() + ")存在多条记录！");
			} else {
				// 数据库中 已有记录，则更新cxr，start，fec三个字段
				KuService serviceInDB = list.get(0);
				if ((serviceInDB.getCxr().intValue() == kuService.getCxr()
						.intValue())
						&& (serviceInDB.getStart().intValue() == kuService
								.getStart().intValue())
						&& (StringUtils.equalsIgnoreCase(serviceInDB.getFec(),
								kuService.getFec()))) {
					// 数据库中记录与采集记录比对，如果cxr，start，fec三个字段均相等，则认为该业务没有变化
					serviceInDB.setServiceChangeType(ServiceChangeType.DNORMAL);
				} else {
					// 数据库中记录与采集记录比对，如果cxr，start，fec三个字段有不相等的字段，则认为该业务有变化，更新该业务
					serviceInDB.setCxr(kuService.getCxr());
					serviceInDB.setStart(kuService.getStart());
					serviceInDB.setFec(kuService.getFec());
					serviceInDB.setServiceChangeType(ServiceChangeType.CCHANGE);
				}
				serviceInDB.setRecordTime(kuService.getRecordTime());
				kuServiceDao.update(serviceInDB);
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser#parseTesTxPower(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void parseTesTxPower(String jsonStr, String fileName)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<TesTxPower> tesTxPowerList = null;
		try {
			tesTxPowerList = (List<TesTxPower>) JacksonTools.jsonToList(
					jsonStr, TesTxPower.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Json转义失败," + e.getMessage());
		}
		if (CollectionUtils.isEmpty(tesTxPowerList)) {
			return;
		}

		TesTxPowerStat stat = new TesTxPowerStat();
		stat.setInfo(fileName);
		stat.setStandard(sysConfigManager
				.getParam(SysFinals.tesTxPowerStandard));
		Iterator<TesTxPower> iterator = tesTxPowerList.iterator();
		int total = tesTxPowerList.size();
		while (iterator.hasNext()) {
			TesTxPower tesTxPower = iterator.next();
			if (stat.getStatDate() == null) {
				stat.setStatDate(tesTxPower.getRecordTime());
			} else {
				if (tesTxPower.getRecordTime() != null
						&& TimeTools.isForward(stat.getStatDate(),
								tesTxPower.getRecordTime())) {
					stat.setStatDate(tesTxPower.getRecordTime());
				}
			}
			logger.debug(tesTxPower.getFreq() + "----"
					+ TimeTools.toTimeStr(tesTxPower.getRecordTime()));
			// 未超限的频点不保存入库。
			if (StringTools.hasText(tesTxPower.getPower())
					&& StringTools.hasText(sysConfigManager
							.getParam(SysFinals.tesTxPowerStandard))
					&& Double.valueOf(tesTxPower.getPower()) < Double
							.valueOf(sysConfigManager
									.getParam(SysFinals.tesTxPowerStandard))) {
				iterator.remove();
			}
			tesTxPower.setValid(true);
			tesTxPower.setTesStat(stat);
		}
		int over = tesTxPowerList.size();
		stat.setNormal(total - over);
		stat.setOver(over);
		tesTxPowerStatDao.save(stat);
		tesTxPowerDao.updateValid(false);
		tesTxPowerDao.saveOrUpdateList(tesTxPowerList);

	}
}
