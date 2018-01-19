/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmServiceDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;
/**
 * Atm全网业务统计dao接口实现
 * @author：KuYonggang
 * @date：2014-6-16上午10:18:52
 * @version：1.0
 */
@Service
public class AtmServiceDaoImpl extends MyBaseDao<AtmService> implements IAtmServiceDao {

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao#queryPageByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmServiceDao.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmServiceDBModel> queryListByParam(NetworkStatQueryModel queryModel) {
		
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmServiceDBModel(localNode.bureau,atmType.serviceType,count(*)) from AtmService where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
            hql.append("and localNode.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		hql.append("and atmType is not null ");
		hql.append("group by localNode.bureau,atmType.serviceType order by localNode.bureau");
		return  (List<AtmServiceDBModel>) super.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao#queryServiceDetailPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmServiceDaoImpl.java
	 */
	@Override
	public Pagination queryServiceDetailPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmServiceRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and service.localNode.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		//服务类别
		if(!StringUtils.isEmpty(queryModel.getServiceType())){
			hql.append("and service.atmType.serviceType = ? ");
			queryParams.add(queryModel.getServiceType());
		}
		//本段节点名称
		if(!StringUtils.isEmpty(queryModel.getLocalNodeName())){
			hql.append("and service.localNodeNameCn like ? escape '\\' ");
			queryParams.add("%" + queryModel.getLocalNodeName() + "%");
		}
		//远端节点名称
		if(!StringUtils.isEmpty(queryModel.getRemoteNodeName())){
			hql.append("and service.remoteNodeNameCn like ? escape '\\' ");
			queryParams.add("%" + queryModel.getRemoteNodeName() + "%");
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append("order by service.serviceName asc,cast(service.localPort as float) asc,cast(service.localPortDLCIVPIVCI as float) asc,cast(service.remotePort as float) asc,cast(service.remotePortDLCIVPIVCI as float) asc,id asc");
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao#queryRuninfoPageByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmServiceDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmServiceRunInfo> queryRuninfoPageByParam(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmServiceRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
            hql.append("and node.atmNodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		if(BooleanUtils.isTrue(queryModel.getAlarmFlag())){
			hql.append("and isAlarm = ? ");
			queryParams.add(queryModel.getAlarmFlag());
		}
		hql.append("order by isAlarm desc,cast(service.localCardSlot as float) asc,cast(service.localPortSlot as float) asc,cast(service.localPortDLCIVPIVCI as float) asc,cast(service.remoteCardSlot as float) asc,cast(service.remotePortSlot as float) asc,cast(service.remotePortDLCIVPIVCI as float) asc,id asc");
		return  (List<AtmServiceRunInfo>) super.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao#queryPageForService(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmServiceDaoImpl.java
	 */
	@Override
	public Pagination queryPageForService(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmServiceRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append("and service.localNode.atmNodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		hql.append("order by isAlarm desc,cast(service.localCardSlot as float) asc,cast(service.localPortSlot as float) asc,cast(service.localPortDLCIVPIVCI as float) asc,cast(service.remoteCardSlot as float) asc,cast(service.remotePortSlot as float) asc,cast(service.remotePortDLCIVPIVCI as float) asc,id asc");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	

}
