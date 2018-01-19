/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:50:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.operstat.ku;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusLogDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusStatDao;
import cn.com.atnc.ioms.dao.basedata.odu.IOduDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusStat;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatModel;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;
import cn.com.atnc.ioms.model.welcome.AlarmTotalStatModel;

/**
 * @author:HuangYijie
 * @date:2014-3-24 上午10:50:11
 * @version:1.0
 */
@Service("KuStatusStatManager")
public class KuStatusStatManagerImpl extends AbstractService implements
		IKuStatusStatManager {

	@Autowired
	private IKuNodeDao kuNodeDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private IKuNodeStatusStatDao kuStatusStatDao;
	@Autowired
	private IKuNodeStatusDao kuNodeStatusDao;
	@Autowired
	private IKuNodeStatusLogDao kuNodeStatusLogDao;
	@Autowired
	private IOduDao oduDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager#queryStatPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryStatPage(KuStatQueryModel model) {
		// TODO Auto-generated method stub
		return kuStatusStatDao.queryPage(model);
	}

	public Pagination queryDetailPage(KuStatusQueryModel qm) throws ServiceException {
		// TODO Auto-generated method stub
		return kuNodeStatusDao.queryPage(qm);
	}

	@Override
	public Pagination queryLogPage(KuStatusLogQueryModel qm) {
		// TODO Auto-generated method stub
		return kuNodeStatusLogDao.queryPage(qm);
	}
	public List<KuNodeStatus> findByKuNodeId(KuStatusQueryModel qm){
		// TODO Auto-generated method stub
		return kuNodeStatusDao.findByKuNodeId(qm);
	}
	public List<KuNodeStatusLog> findKlogByKuNodeId(KuStatusLogQueryModel qm){
		// TODO Auto-generated method stub
		return kuNodeStatusLogDao.findKlogByKuNodeId(qm);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.pcsp.mng.operstat.ku.IKuStatusStatManager#getLastStatId()
	 */
	@Override
	public String getLastStatId() {
		// TODO Auto-generated method stub
		return kuStatusStatDao.getLastStatId();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager#getLatestStat()
	 */
	@Override
	public List<AlarmTotalStatModel> getLatestStat() {
		List<AlarmTotalStatModel> result = new ArrayList<AlarmTotalStatModel>();
		for (Bureau bureau : Bureau.values()) {
			AlarmTotalStatModel model = new AlarmTotalStatModel();
			model.setBureau(bureau);
			result.add(model);
		}
		String statId = this.getLastStatId();
		if (!StringTools.hasText(statId)) {
			return result;
		}
		// TODO Auto-generated method stub
		KuNodeStatusStat stat = kuStatusStatDao.findById(statId);
		KuBureauStatQueryModel qm = new KuBureauStatQueryModel();
		qm.setKuStatusStatId(statId);
		qm.setKuNetworkStatusStandard(stat.getStatusStandard());
		List<KuBureauStatModel> statusStat = kuNodeStatusDao.getLatestStat(qm);
		for (AlarmTotalStatModel totalModel : result) {
			for (KuBureauStatModel statusModel : statusStat) {
				if (statusModel.getBureau().equals(totalModel.getBureau())) {
					totalModel.setKuStatusAlarm(statusModel.getCount());
					break;
				}
			}
		}
		qm = new KuBureauStatQueryModel();
		qm.setKuStatusStatId(statId);
		qm.setKuEbNoTopLimit(stat.getEbnoTop());
		List<KuBureauStatModel> ebNoStat = kuNodeStatusDao.getLatestStat(qm);
		for (AlarmTotalStatModel totalModel : result) {
			for (KuBureauStatModel ebNoModel : ebNoStat) {
				if (ebNoModel.getBureau().equals(totalModel.getBureau())) {
					totalModel.setKuEbNoAlarm(ebNoModel.getCount());
					break;
				}
			}
		}
		qm = new KuBureauStatQueryModel();
		qm.setKuStatusStatId(statId);
		qm.setKuRxLevelLowerLimit(stat.getRxLevelLow());
		qm.setKuRxLevelTopLimit(stat.getRxLevelTop());
		List<KuBureauStatModel> rxLevelStat = kuNodeStatusDao.getLatestStat(qm);
		for (AlarmTotalStatModel totalModel : result) {
			for (KuBureauStatModel rxLevelModel : rxLevelStat) {
				if (rxLevelModel.getBureau().equals(totalModel.getBureau())) {
					totalModel.setKuRxLevelAlarm(rxLevelModel.getCount());
					break;
				}
			}
		}
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager#findStatById(java.lang.String)
	 */
	@Override
	public KuNodeStatusStat findStatById(String id) {
		// TODO Auto-generated method stub
		return kuStatusStatDao.findById(id);
	}

	@Override
	public List<Odu> findODUBySite(OduQueryModel qm3) {
		return oduDao.findODUBySite(qm3);
	}
}
