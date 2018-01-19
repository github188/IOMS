package cn.com.atnc.ioms.dao.business.transfernet.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.transfernet.ITransferNetDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.enums.business.transfernet.TransferNetStatEnum;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;

/**
 * 自动转报网DAO实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午1:54:00
 * @since 1.0.0
 */
@Repository
public class TransferNetDaoImpl extends MyBaseDao<TransferNet> implements ITransferNetDao {

	@Override
	public Pagination queryPage(TransferNetQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from TransferNet where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		//记录查询条件-申请人
		if(!StringUtils.isEmpty(queryModel.getApplyUserLike())){
			hql.append(" and applyBaseInfo.applyUser.realName like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyUserLike()+"%");
		}
		//记录查询条件-申请单位
		if(!StringUtils.isEmpty(queryModel.getApplyComLike())){
			hql.append(" and applyBaseInfo.applyCom like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyComLike()+"%");
		}
		//记录查询条件-联系人
		if(!StringUtils.isEmpty(queryModel.getApplyLinkmanLike())){
			hql.append(" and applyBaseInfo.applyLinkman like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyLinkmanLike()+"%");
		}
		//记录查询条件-审批状态
		if(!ObjectUtils.equals(queryModel.getApproveStatus(),null)){
			hql.append(" and approveStat = ? ");
			queryParams.add(queryModel.getApproveStatus());
		}
		//记录查询条件-申请时间起
		if(!ObjectUtils.equals(queryModel.getFromApplyTime(), null)){
			hql.append(" and applyBaseInfo.applyTime >= ? ");
			queryParams.add(queryModel.getFromApplyTime());
		}
		//记录查询条件-申请时间至
		if(!ObjectUtils.equals(queryModel.getToApplyTime(), null)){
			hql.append(" and applyBaseInfo.applyTime <= ? ");
			queryParams.add(queryModel.getToApplyTime());
		}
		//上级领导(单位领导)
		if (!ObjectUtils.equals(queryModel.getpClient(),null)) {
			hql.append(" and ((applyBaseInfo.applyUser.id = ? and approveStat in (?,?,?)) ");
			queryParams.add(queryModel.getpClient().getId());
			queryParams.add(TransferNetStatEnum.unsubmitted);
			queryParams.add(TransferNetStatEnum.returned);
			queryParams.add(TransferNetStatEnum.unevaluate);
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//上上级领导及其下属所有人员ID集合查询条件
		if (!CollectionUtils.isEmpty(queryModel.getPpIdList())) {
			hql.append(" and applyBaseInfo.applyUser.id in ( ");
			List<String> idList = queryModel.getPpIdList();
			for (String id : idList) {
				hql.append("?,");
				queryParams.add(id);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(") ");
		}
		//审批状态查询条件
		if(!CollectionUtils.isEmpty(queryModel.getStatusList())){
			hql.append(" and approveStat in (");
			List<TransferNetStatEnum> allStatus = queryModel.getStatusList();
			for (TransferNetStatEnum status : allStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//用户所属管局
		if(StringUtils.isNotEmpty(queryModel.getBureau())) {
			hql.append(" and applyBaseInfo.candidate like ?");
			queryParams.add("%"+queryModel.getBureau()+"%");
		}
		// 上一步移交的操作人员
		if (!StringUtils.isEmpty(queryModel.getNextUser())) {
			hql.append(" and applyBaseInfo.nextUser = ?");
			queryParams.add(queryModel.getNextUser());
		}
		hql.append(" order by applyBaseInfo.applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	@Override
	public List<TransferNet> queryList(TransferNetQueryModel queryModel) {
		StringBuffer hql = new StringBuffer(" from TransferNet where 1=1 ");
		hql.append(" and applyBaseInfo.applyType == 'transfernet'");
		List<Object> params = new ArrayList<Object>();
		return (List<TransferNet>) super.queryList(hql.toString(),
				params.toArray());
	}

	@Override
	public List<TransferNet> findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		
		StringBuffer hql = new StringBuffer(" from TransferNet where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		
		if (!ObjectUtils.equals(applyBaseInfo,null)) {
			hql.append(" and applyBaseInfo.id = ?");
			params.add(applyBaseInfo.getId());
		}
		return (List<TransferNet>) super.queryList(hql.toString(),
				params.toArray());
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.business.transfernet.ITransferNetDao#getListSendMessage()
	 */
	@Override
	public List<TransferNet> getListSendMessage() {
		
		StringBuffer hql = new StringBuffer(" from TransferNet where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		
		hql.append(" and approveStat = ?");
		params.add(TransferNetStatEnum.atncleader_firstdeal);
		hql.append(" and (applyBaseInfo.sendmessageFlag is null or applyBaseInfo.sendmessageFlag = false)");
		
		return (List<TransferNet>) super.queryList(hql.toString(),
				params.toArray());
	}
}
