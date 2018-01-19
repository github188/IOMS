/**
 * 
 */
package cn.com.atnc.ioms.mng.operstat.atm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.basedata.atm.node.IAtmNodeDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmBandDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao;
import cn.com.atnc.ioms.dao.operstat.atm.ICardDao;
import cn.com.atnc.ioms.dao.operstat.atm.ICardRuninfoDao;
import cn.com.atnc.ioms.dao.operstat.atm.IEnvRuninfoDao;
import cn.com.atnc.ioms.dao.operstat.atm.IPnniLinkDao;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM节点详情服务接口实现类
 * 
 * @author：KuYonggang
 * @date：2014-5-27上午11:02:09
 * @version：1.0
 */
@Service
@Transactional
public class NodeDetailServiceImpl implements INodeDetailService {
	
	@Autowired
	private IAtmNodeDao atmNodeDao;
	@Autowired
	private ICardRuninfoDao ardRuninfoDao;
	@Autowired
	private ICardDao cardDao;
	@Autowired
	private IAtmServiceDao atmServiceDao;
	@Autowired
	private IAtmBandDao atmBandDao;
	@Autowired
	private IPnniLinkDao pnniLinkDao;
	@Autowired
	private IEnvRuninfoDao envRuninfoDao;
	
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#getAtmNodes()
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public List<AtmNode> getAtmNodes() {
	    return atmNodeDao.getAll();
	}
	
	@Override
	public List<AtmNode> queryList(AtmNodeQueryModel queryModel){
		return atmNodeDao.queryList(queryModel);
	}
	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#getAtmNodeById(java.lang.String)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public AtmNode getAtmNodeById(String id) {
		return atmNodeDao.findById(id);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForCard(java.lang.String)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForCard(NetworkStatQueryModel queryModel) {
		return ardRuninfoDao.queryPageForCard(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForBusiness(cn.com.atnc.ioms.model.basedata.atm.node.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForService(NetworkStatQueryModel queryModel) {
		return atmServiceDao.queryPageForService(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForBandWidth(cn.com.atnc.ioms.model.basedata.atm.node.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForBandWidth(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return atmBandDao.queryPageForBandWidth(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForAlarm(cn.com.atnc.ioms.model.basedata.atm.node.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForAlarm(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForRuninfo(cn.com.atnc.ioms.model.basedata.atm.node.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public List<AtmServiceRunInfo> queryPageForRuninfo(NetworkStatQueryModel queryModel) {
		return atmServiceDao.queryRuninfoPageByParam(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForRelay(cn.com.atnc.ioms.model.basedata.atm.node.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForRelay(NetworkStatQueryModel queryModel) {
		// TODO Auto-generated method stub
		return pnniLinkDao.queryPageForRelay(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#getAtmNodeByNodeCode(java.lang.String)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Object getAtmNodeByNodeCode(String nodeCode) {
		return atmNodeDao.getAtmNodeByNodeCode(nodeCode);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#getEnvRuninfoByNodeCode(java.lang.String)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public List<NodeEnvRunInfo> getEnvRuninfoByNodeCode(NetworkStatQueryModel queryModel) {
		return envRuninfoDao.queryListByModel(queryModel);
	}

	/**
	 * @see cn.com.atnc.ioms.mng.operstat.atm.INodeDetailService#queryPageForCardDetail(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * NodeDetailServiceImpl.java
	 */
	@Override
	public Pagination queryPageForCardDetail(NetworkStatQueryModel queryModel) {
		return cardDao.queryPageForCardDetail(queryModel);
	}

}
