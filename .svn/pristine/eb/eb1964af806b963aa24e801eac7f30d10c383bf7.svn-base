package cn.com.atnc.ioms.dao.business.baseinfo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.enums.business.baseinfo.ApplyTypeEnum;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;


/**
 * 各种申请的基础信息Dao接口实现类
 *
 * @author ku
 * @date 2015年5月14日 下午5:32:50
 * @since 1.0.0
 */
@Repository
public class ApplyBaseInfoDaoImpl extends MyBaseDao<ApplyBaseInfo> implements
IApplyBaseInfoDao {

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao#queryPageByModel(cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel)
	 */
	@Override
	public Pagination queryPageByModel(TaskRecordQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from ApplyBaseInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//记录查询条件-申请人
		if(!StringUtils.isEmpty(queryModel.getApplyUserLike())){
			hql.append(" and applyUser.name like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyUserLike()+"%");
		}
		//记录查询条件-申请单位
		if(!StringUtils.isEmpty(queryModel.getApplyComLike())){
			hql.append(" and applyCom like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyComLike()+"%");
		}
		//记录查询条件-联系人
		if(!StringUtils.isEmpty(queryModel.getApplyLinkmanLike())){
			hql.append(" and applyLinkman like ?  escape '\\' ");
			queryParams.add("%"+queryModel.getApplyLinkmanLike()+"%");
		}
		//查询条件-申请类别
		if(!ObjectUtils.equals(queryModel.getApplyType(), null)){
			hql.append(" and applyType = ? ");
			queryParams.add(queryModel.getApplyType());
		}
		//记录查询条件-申请时间起
		if(!ObjectUtils.equals(queryModel.getFromApplyTime(), null)){
			hql.append(" and applyTime >= ? ");
			queryParams.add(queryModel.getFromApplyTime());
		}
		//记录查询条件-申请时间至
		if(!ObjectUtils.equals(queryModel.getToApplyTime(), null)){
			hql.append(" and applyTime <= ? ");
			queryParams.add(queryModel.getToApplyTime());
		}
		//审批状态查询条件
		if(!CollectionUtils.isEmpty(queryModel.getApplyTypeList())){
			hql.append(" and applyType in (");
			List<ApplyTypeEnum> allStatus = queryModel.getApplyTypeList();
			for (ApplyTypeEnum status : allStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//审批人姓名
		if(StringUtils.isNotEmpty(queryModel.getApproveUser())) {
			hql.append(" and approveUsers like ?  escape '\\' ");
			queryParams.add("%" + queryModel.getApproveUser() + "%");
		}
		//管局所属区域
		if(!ObjectUtils.equals(queryModel.getBureaus(), null)){
			hql.append(" and applyUser.bureau = ? ");
			queryParams.add(queryModel.getBureaus());
		}
		hql.append(" order by applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		queryModel.setPageSize(50);
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.ioms.dao.business.baseinfo.IApplyBaseInfoDao#getListSendMessage()
	 */
	@Override
	public List<ApplyBaseInfo> getListSendMessage() {
		StringBuilder hql = new StringBuilder("from ApplyBaseInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		//未发送的
		hql.append(" and sendmessageFlag != ? ");
		queryParams.add(true);
		hql.append(" order by applyTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return (List<ApplyBaseInfo>) super.queryList(countHql);
	}

}
