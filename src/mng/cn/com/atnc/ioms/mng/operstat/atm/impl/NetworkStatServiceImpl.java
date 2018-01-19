/**
 * 
 */
package cn.com.atnc.ioms.mng.operstat.atm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.hpl.sparta.xpath.ThisNodeTest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmCardRunInfoDetailDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmEquipDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmPortDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsAxsmOC3Dao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsAxsmT1E1Dao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsAxsmT3E3Dao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsAxsmXGDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsCesmDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsFrsmDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsMpsmDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsMpsmFrmDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsPxm155Dao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLnsPxmT1E1Dao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortAXSMDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortAXSMEDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortAXSMXGDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortCESMDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortFRSMDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortMPSMATMDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortMPSMFRDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPortPXMDao;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.operstat.atm.AtmNodeRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBTbModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmBandDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmEquipDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDetailDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmServiceDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM网运行统计Service接口实现
 * 
 * @author：KuYonggang
 * @date：2014-5-22上午9:01:01
 * @version：1.0
 */
@Service
public class NetworkStatServiceImpl implements INetworkStatService{
	
	@Autowired
	private IAtmAlarmStatDao alarmStatDao;
	@Autowired
	private IAtmServiceDao atmServiceDao;
	@Autowired
	private IAtmEquipDao atmEquipDao;
	@Autowired
	private IAtmPortDao atmPortDao;
	@Autowired
	private IAtmBandDao atmBandDao;
	@Autowired
	private IPortAXSMDao portAXSMDao;
	@Autowired
	private IPortAXSMEDao portAXSMEDao;
	@Autowired
	private IPortAXSMXGDao portAXSMXGDao;
	@Autowired
	private IPortMPSMFRDao portMPSMFRDao;
	@Autowired
	private IPortPXMDao portPXMDao;
	@Autowired
	private IPortCESMDao portCESMDao;
	@Autowired
	private IPortFRSMDao portFRSMDao;
	@Autowired
	private IPortMPSMATMDao portMPSMATMDao;
	@Autowired
	private IAtmCardRunInfoDetailDao atmCardRunInfoDetailDao;
	@Autowired
	private IPnniLnsDao pnniLnsDao;
	@Autowired
	private IPnniLnsMpsmFrmDao pnniLnsMpsmFrmDao;
	@Autowired
	private IPnniLnsPxm155Dao pnniLnsPxm155Dao;
	@Autowired
	private IPnniLnsPxmT1E1Dao pnniLnsPxmT1E1Dao;
	@Autowired
	private IPnniLnsAxsmT1E1Dao pnniLnsAxsmT1E1Dao;
	@Autowired
	private IPnniLnsAxsmT3E3Dao pnniLnsAxsmT3E3Dao;
	@Autowired
	private IPnniLnsAxsmXGDao pnniLnsAxsmXGDao;
	@Autowired
	private IPnniLnsCesmDao pnniLnsCesmDao;
	@Autowired
	private IPnniLnsFrsmDao pnniLnsFrsmDao;
	@Autowired
	private IPnniLnsAxsmOC3Dao pnniLnsAxsmOC3Dao;
	@Autowired
	private IPnniLnsMpsmDao pnniLnsMpsmDao;
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmAlarmDBTbModel> queryAtmAlarmDBTbModelsByModel(NetworkStatQueryModel queryModel) {
		return alarmStatDao.queryAtmAlarmDBTbModelsByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmAlarmDBModel> queryListByModel(NetworkStatQueryModel queryModel) {
		return alarmStatDao.queryListByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryListById(java.lang.String)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public void queryListById(String id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPageById(java.lang.String)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmNodeRunInfo> queryAtmAlarmListByModel(NetworkStatQueryModel queryModel) {
		return alarmStatDao.queryAtmAlarmPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryEnvAlarmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<NodeEnvRunInfo> queryEnvAlarmListByModel(NetworkStatQueryModel queryModel) {
		return alarmStatDao.queryEnvAlarmPageByModel(queryModel);
		
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryCardAlarmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmCardAlarmDBModel> queryCardAlarmListByModel(NetworkStatQueryModel queryModel) {
		queryModel.setAlarmFlag(true);
		return alarmStatDao.queryCardAlarmPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#getAllAtmAlarm()
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmAlarmDBModel> getAllAtmAlarm() {
		NetworkStatQueryModel queryModel = new NetworkStatQueryModel();
		List<AtmAlarmDBModel> list = this.queryListByModel(queryModel);
		return list;
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmServicePageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmServiceDBModel> queryAtmServiceDBListByModel(NetworkStatQueryModel queryModel) {
		return atmServiceDao.queryListByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryServiceDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryServiceDetailPageByModel(NetworkStatQueryModel queryModel) {
		return atmServiceDao.queryServiceDetailPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmEquipListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmEquipDBModel> queryAtmEquipListByModel(
			NetworkStatQueryModel queryModel) {
		return atmEquipDao.queryListByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmEquipPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmNode> queryAtmNodeListByModel(NetworkStatQueryModel queryModel) {
		return atmEquipDao.querylistByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryEquipDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryEquipDetailPageByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return atmEquipDao.queryDetailPageByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryServiceAlarmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmServiceRunInfo> queryServiceAlarmListByModel(NetworkStatQueryModel queryModel) {
		queryModel.setAlarmFlag(true);
		return atmServiceDao.queryRuninfoPageByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmPortListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmPortDBModel> queryAtmPortListByModel(NetworkStatQueryModel queryModel) {
		return atmPortDao.queryListByParam(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryAtmPortPageByModel(NetworkStatQueryModel queryModel) {
		return atmPortDao.queryPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryBandDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryBandDetailPageByModel(NetworkStatQueryModel queryModel) {
		return atmBandDao.queryPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmBandListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmBandDBModel> queryAtmBandListByModel(NetworkStatQueryModel queryModel) {
		return atmBandDao.queryListByModel(queryModel);
	}
	
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAXSMPortDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryAXSMPortDetailPageByModel(NetworkStatQueryModel queryModel) {
		return portAXSMDao.queryAXSMPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAXSMEPortDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryAXSMEPortDetailPageByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return portAXSMEDao.queryAXSMEPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAXSMXGPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryAXSMXGPortPageByModel(
			NetworkStatQueryModel queryModel) {
		return portAXSMXGDao.queryAXSMEPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryCESMPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryCESMPortPageByModel(NetworkStatQueryModel queryModel) {
		return portCESMDao.queryCESMPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryMPSMPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryMPSMPortPageByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return portMPSMATMDao.queryMPSMATMPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryMPSMFRPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryMPSMFRPortPageByModel(
			NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return portMPSMFRDao.queryMPSMFRPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPXMPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPXMPortPageByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return portPXMDao.queryPXMPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryFRSMPortPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryFRSMPortPageByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return portFRSMDao.queryFRSMPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmCardAlarmDetailPage(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryAtmCardAlarmDetailPage(NetworkStatQueryModel qm) {
		return atmCardRunInfoDetailDao.queryPage(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsAxsmOC3PageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsAxsmOC3PageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsAxsmOC3Dao.queryPnniLnsAxsmOC3PageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsAxsmT1E1PageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsAxsmT1E1PageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsAxsmT1E1Dao.queryPnniLnsAxsmT1E1PageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsAxsmT3E3PageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsAxsmT3E3PageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsAxsmT3E3Dao.queryPnniLnsAxsmT3E3PageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsAxsmXGPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsAxsmXGPageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsAxsmXGDao.queryPnniLnsAxsmXGPageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsCesmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsCesmPageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsCesmDao.queryPnniLnsCesmPageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsFrsmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsFrsmPageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsFrsmDao.queryPnniLnsFrsmPageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsMpsmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsMpsmPageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsMpsmDao.queryPnniLnsMpsmPageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsMpsmFrmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsMpsmFrmPageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsMpsmFrmDao.queryPnniLnsMpsmFrmPageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsPxm155PageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsPxm155PageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsPxm155Dao.queryPnniLnsPxm155PageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryPnniLnsPxmT1E1PageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public Pagination queryPnniLnsPxmT1E1PageByModel(NetworkStatQueryModel qm) {
		// TODO Auto-generated method stub
		return this.pnniLnsPxmT1E1Dao.queryPnniLnsPxmT1E1PageByModel(qm);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmPnniPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmPnniDBModel> queryAtmPnniPageByModel(NetworkStatQueryModel queryModel) {
		return this.pnniLnsDao.queryPageByModel(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService#queryAtmPnniDetailListByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NetworkStatServiceImpl.java
	 */
	@Override
	public List<AtmPnniDetailDBModel> queryAtmPnniDetailListByModel(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return this.pnniLnsDao.queryAtmPnniDetailListByModel(queryModel);
	}

}
