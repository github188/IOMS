/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao;
import cn.com.atnc.ioms.entity.operstat.atm.AtmNodeRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBTbModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * Atm全网告警统计Dao接口实现
 * 
 * @author：KuYonggang
 * @date：2014-5-23上午9:11:14
 * @version：1.0
 */
@Repository
public class AtmAlarmStatDaoImpl extends MyBaseDao<AtmNodeRunInfo> implements
		IAtmAlarmStatDao {

	/**
	 * @return 
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao#queryPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmAlarmStatDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmAlarmDBTbModel> queryAtmAlarmDBTbModelsByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBTbModel(a.atmNode.bureau,a.nodeCode,sum(a.nodeCriticalSum),sum(a.nodeMajorSum),sum(a.nodeMinorSum)) from AtmNodeRunInfo a where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and atmNode.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		hql.append("group by a.atmNode.bureau,a.nodeCode");
		return (List<AtmAlarmDBTbModel>) this.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao#queryListByParam(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmAlarmStatDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmAlarmDBModel> queryListByParam(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel(a.atmNode.bureau,sum(a.nodeCriticalSum) as critical,sum(a.nodeMajorSum) as major,sum(a.nodeMinorSum) as minor) from AtmNodeRunInfo a where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and atmNode.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		hql.append("group by a.atmNode.bureau");
		List<AtmAlarmDBModel> list = new ArrayList<AtmAlarmDBModel>();
		//System.out.println(hql.toString());
		list = (List<AtmAlarmDBModel>) this.queryList(hql.toString());
		return list;
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao#queryPageById(java.lang.String)
	 * AtmAlarmStatDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmNodeRunInfo> queryAtmAlarmPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from AtmNodeRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//管局查询条件
		if(!StringUtils.isEmpty(queryModel.getBureau())){
			hql.append("and atmNode.bureau = ? ");
			queryParams.add(queryModel.getBureau());
		}
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append("and nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		return  (List<AtmNodeRunInfo>) super.queryList(hql.toString(), queryParams.toArray());
		
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao#queryEnvAlarmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmAlarmStatDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NodeEnvRunInfo> queryEnvAlarmPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("from NodeEnvRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//节点代码查询条件
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append("and nodeCode = ? ");
			queryParams.add(queryModel.getNodeCode());
		}
		return  (List<NodeEnvRunInfo>) super.queryList(hql.toString(), queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao#queryCardAlarmPageByModel(cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel)
	 * AtmAlarmStatDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AtmCardAlarmDBModel> queryCardAlarmPageByModel(NetworkStatQueryModel queryModel) {
		StringBuffer hql = new StringBuffer();
		hql.append("select new cn.com.atnc.ioms.model.operstat.atm.AtmCardAlarmDBModel(s.card,s.cardSlot,c.cardType,s.cardCriticalSum,s.cardMajorSum,s.cardMinorSum,c.recordTime,s.isAlarm) " +
				"from CardRunInfoSummary s, CardRunInfo c " +
				"where s.card.id=c.card.id ");
		List<Object> queryParams = new ArrayList<Object>();
		if(!StringUtils.isEmpty(queryModel.getNodeCode())){
			hql.append(" and s.node.atmNodeCode = ?");
			queryParams.add(queryModel.getNodeCode());
		}
		if(BooleanUtils.isTrue(queryModel.getAlarmFlag())){
			hql.append(" and s.isAlarm = ?");
			queryParams.add(queryModel.getAlarmFlag());
		}
		return  (List<AtmCardAlarmDBModel>) super.queryList(hql.toString(), queryParams.toArray());
	}

}
