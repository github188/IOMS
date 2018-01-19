package cn.com.atnc.ioms.mng.duty.statellite.day.tes.impl;

import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.ioms.dao.duty.satellite.day.tes.IDataStateDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdDecConDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdMainStateDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdProStateDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdSynResultDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdSynStateDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.tes.ITxjdWorkConDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.day.BaseSatelliteInfo;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdDecCon;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdMainState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdProState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynResult;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdSynState;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.TxjdWorkCon;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.mng.duty.statellite.day.tes.IDayTesCheckService;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.AuditDataModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 卫星巡检基础巡检
 *
 * @author 段衍林
 * @2017年2月16日 下午1:14:17
 */
@Transactional
@Service("DayTesCheckService")
public class DayTesCheckServiceImpl implements IDayTesCheckService {

	@Autowired
	private IDataStateDao dataStateDao;
	@Autowired
	private ITxjdProStateDao txjdProStateDao;
	@Autowired
	private ITxjdWorkConDao txjdWorkConDao;
	@Autowired
	private ITxjdDecConDao txjdDecConDao;
	@Autowired
	private ITxjdSynStateDao txjdSynStateDao;
	@Autowired
	private ITxjdSynResultDao txjdSynResultDao;
	@Autowired
	private ITxjdMainStateDao txjdMainStateDao;

	/**
	 * 保存数据
	 */
	@Override
	public void save(TesBaseDataModel tesBaseDataModel, User operator) {
		// 基础数据
		BaseSatelliteInfo baseSatelliteInfo = new BaseSatelliteInfo(
				DateUtilTools.getNowDate(), DateUtilTools.getNowDateTime(),
				operator);
		// 通信基地TES网管数据库
		DataState dataState = new DataState(tesBaseDataModel,
				baseSatelliteInfo, SatelliteCheckContent.TxjdDataState);
		// 通讯基地-TES-TES 网管进程状态
		TxjdProState txjdProState = new TxjdProState(tesBaseDataModel,
				baseSatelliteInfo, SatelliteCheckContent.TxjdProState);
		// 通讯基地-TES-TES网管工作站连通性
		TxjdWorkCon txjdWorkCon = new TxjdWorkCon(tesBaseDataModel,
				baseSatelliteInfo, SatelliteCheckContent.TxjdWorkCon);
		// 通讯基地-TES-TES网管工作站连通性
		TxjdDecCon txjdDecCon = new TxjdDecCon(tesBaseDataModel,
				baseSatelliteInfo, SatelliteCheckContent.TxjdTesDec);
		// 通讯基地-TES-查看网管同步状态父级数据
		TxjdSynState txjdSynState = new TxjdSynState(baseSatelliteInfo,
				SatelliteCheckContent.TxjdSynState);
		// 通信基地-TES-TES网管工作站主备状态
		TxjdMainState txjdMainState = new TxjdMainState(tesBaseDataModel,
				baseSatelliteInfo, SatelliteCheckContent.TxjdMainState);
		// 保存数据
		dataStateDao.save(dataState);
		txjdProStateDao.save(txjdProState);
		txjdWorkConDao.save(txjdWorkCon);
		txjdDecConDao.save(txjdDecCon);
		txjdSynStateDao.save(txjdSynState);
		txjdMainStateDao.save(txjdMainState);
		// 保存子数据
		this.saveTxjdSynResults(txjdSynState, tesBaseDataModel);
	}

	/**
	 * 子数据保存
	 * 
	 * @author 段衍林
	 * @2017年2月16日 下午1:58:14
	 * @param txjdSynState
	 *            父级实体
	 * @param tesBaseDataModel
	 *            基础数据 void
	 */
	public void saveTxjdSynResults(TxjdSynState txjdSynState,
			TesBaseDataModel tesBaseDataModel) {
		// 非空验证
		if (CollectionUtils.isNotEmpty(tesBaseDataModel.getSerial())) {
			for (int i = 0; i < tesBaseDataModel.getSerial().size(); i++) {
				TxjdSynResult txjdSynResult = new TxjdSynResult(txjdSynState,
						tesBaseDataModel.getSerial().get(i), tesBaseDataModel
								.getEquipName().get(i), tesBaseDataModel
								.getCu().get(i), tesBaseDataModel.getCkt().get(
								i), tesBaseDataModel.getHg().get(i),
						tesBaseDataModel.getDd().get(i), tesBaseDataModel
								.getRoute().get(i));
				txjdSynResultDao.save(txjdSynResult);
			}
		}
	}

	/**
	 * 审核
	 */
	@Override
	public void audit(AuditDataModel auditDataModel, User operator) {
		// tab页
		String optType = auditDataModel.getOptType();
		// id
		String id = auditDataModel.getId();
		// auditRemark
		String auditRemark = auditDataModel.getAuditRemark();
		// 审核时间
		Date auditTime = DateUtilTools.getNowDateTime();
		switch (optType == null ? "" : optType) {
		case "txjddatastate":
			/**
			 * 通信基地TES网管数据库
			 */
			DataState dataState = dataStateDao.findById(id);
			// 审核操作人
			dataState.setAuditer(operator);
			// 审核备注
			dataState.setAuditRemark(auditRemark);
			// 审核时间
			dataState.setAuditTime(auditTime);
			// 更新数据
			dataStateDao.update(dataState);
			break;
		case "txjdprostate":
			/**
			 * 通信基地TES网管数据库
			 */
			TxjdProState txjdProState = txjdProStateDao.findById(id);
			// 审核操作人
			txjdProState.setAuditer(operator);
			// 审核备注
			txjdProState.setAuditRemark(auditRemark);
			// 审核时间
			txjdProState.setAuditTime(auditTime);
			txjdProStateDao.update(txjdProState);
			break;
		case "txjdworkcon":
			/**
			 * 通讯基地-TES-TES网管工作站连通性
			 */
			TxjdWorkCon txjdWorkCon = txjdWorkConDao.findById(id);
			// 审核操作人
			txjdWorkCon.setAuditer(operator);
			// 审核备注
			txjdWorkCon.setAuditRemark(auditRemark);
			// 审核时间
			txjdWorkCon.setAuditTime(auditTime);
			txjdWorkConDao.update(txjdWorkCon);
			break;
		case "txjddeccon":
			/**
			 * 通讯基地-TES-TES网管工作站连通性
			 */
			TxjdDecCon txjdDecCon = txjdDecConDao.findById(id);
			// 审核操作人
			txjdDecCon.setAuditer(operator);
			// 审核备注
			txjdDecCon.setAuditRemark(auditRemark);
			// 审核时间
			txjdDecCon.setAuditTime(auditTime);
			txjdDecConDao.update(txjdDecCon);
			break;
		case "txjdsynstate":
			/**
			 * 通讯基地-TES-查看网管同步状态父级数据
			 */
			TxjdSynState txjdSynState = txjdSynStateDao.findById(id);
			// 审核操作人
			txjdSynState.setAuditer(operator);
			// 审核备注
			txjdSynState.setAuditRemark(auditRemark);
			// 审核时间
			txjdSynState.setAuditTime(auditTime);
			txjdSynStateDao.update(txjdSynState);
			break;
		case "txjdmainstate":
			/**
			 * 通信基地-TES-TES网管工作站主备状态
			 */
			TxjdMainState txjdMainState = txjdMainStateDao.findById(id);
			// 审核操作人
			txjdMainState.setAuditer(operator);
			// 审核备注
			txjdMainState.setAuditRemark(auditRemark);
			// 审核时间
			txjdMainState.setAuditTime(auditTime);
			txjdMainStateDao.update(txjdMainState);
			break;
		default:
			/**
			 * 通信基地TES网管数据库
			 */
			DataState dataState1 = dataStateDao.findById(id);
			// 审核操作人
			dataState1.setAuditer(operator);
			// 审核备注
			dataState1.setAuditRemark(auditRemark);
			// 审核时间
			dataState1.setAuditTime(auditTime);
			// 更新数据
			dataStateDao.update(dataState1);
		}
	}
}
