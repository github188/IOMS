package cn.com.atnc.ioms.dao.business.formalcircuit.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * 正式电路申请表基础信息Dao接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:49:27
 * @since 1.0.0
 */
@Repository
public class FormalCircuitDaoImpl extends MyBaseDao<FormalCircuit> implements IFormalCircuitDao {

	@Override
	public Pagination queryPage(FormalCircuitQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from FormalCircuit f where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		// 申请人员
		if (!ObjectUtils.equals(queryModel.getClient(),null)) {
			hql.append(" and f.applyBaseInfo.applyUser.id = ?");
			queryParams.add(queryModel.getClient().getId());
		}
		// 上一步移交的操作人员
		if (!StringUtils.isEmpty(queryModel.getNextUser())) {
			hql.append(" and applyBaseInfo.nextUser = ?");
			queryParams.add(queryModel.getNextUser());
		}
		//上级领导及其下属人员ID查询条件
		if (!CollectionUtils.isEmpty(queryModel.getpIdList())) {
			hql.append(" and f.applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//上上级领导及其下属所有人员ID集合查询条件
		if (!CollectionUtils.isEmpty(queryModel.getPpIdList())) {
			hql.append(" and f.applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getPpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//审批状态查询条件
		if(!CollectionUtils.isEmpty(queryModel.getStatusList())){
			hql.append(" and f.approveStat in (");
			List<FormalStatEnum> allStatus = queryModel.getStatusList();
			for (FormalStatEnum status : allStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		hql.append(" order by applyBaseInfo.applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public List<FormalCircuit> queryList(FormalCircuitQueryModel queryModel) {
		StringBuffer hql = new StringBuffer(" from FormalCircuit where 1=1 ");
		hql.append(" and applyBaseInfo.applyType == 'formalcircuit_ku'");
		hql.append(" and applyBaseInfo.applyType == 'formalcircuit_atm'");
		hql.append(" and applyBaseInfo.applyType == 'formalcircuit_tes'");
		List<Object> params = new ArrayList<Object>();
//		if (!StringUtils.isEmpty(qm.getaEquipID())) {
//			hql.append(" and aEquip.id = ?");
//			params.add(qm.getaEquipID());
//		}
		return (List<FormalCircuit>) super.queryList(hql.toString(),
				params.toArray());
	}

	@Override
	public List<FormalCircuit> findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		
		StringBuffer hql = new StringBuffer(" from FormalCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		
		if (!ObjectUtils.equals(applyBaseInfo,null)) {
			hql.append(" and applyBaseInfo.id = ?");
			params.add(applyBaseInfo.getId());
		}
		return (List<FormalCircuit>) super.queryList(hql.toString(),
				params.toArray());
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitDao#getListSendMessage()
	 */
	@Override
	public List<FormalCircuit> getListSendMessage() {
		
		StringBuffer hql = new StringBuffer(" from FormalCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		
		hql.append(" and approveStat = ?");
		params.add(FormalStatEnum.atncleader_firstdeal);
		hql.append(" and (applyBaseInfo.sendmessageFlag is null or applyBaseInfo.sendmessageFlag = false)");
		
		return (List<FormalCircuit>) super.queryList(hql.toString(),
				params.toArray());
	}

}
