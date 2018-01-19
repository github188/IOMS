package cn.com.atnc.ioms.dao.techsupport.fault.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.techsupport.fault.IFaultDeclareOptLogDao;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareOptLogQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 类说明：故障申报操作记录dao接口实现
 * 
 * @author：KuYonggang
 * @date：2014-4-15下午5:09:17
 * @version：1.0
 */
@Repository
public class FaultDeclareOptLogDaoImpl extends MyBaseDao<FaultDeclareOptLog> implements
		IFaultDeclareOptLogDao {

	/**
	 * @see cn.com.atnc.pcsp.dao.techsupport.fault.IFaultDeclareOptLogDao#queryPageByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareOptLogQueryModel)
	 * FaultDeclareOptLogDaoImpl.java
	 */
	@Override
	public Pagination queryPageByParam(FaultDeclareOptLogQueryModel queryModel) {
		// 两种写法，一种使用？占位符，适用于查询值单一的情况。
		StringBuilder hql = new StringBuilder();
		hql.append("from FaultDeclareOptLog where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		//咨询类型
		if (!ObjectUtils.equals(queryModel.getFaultType(),null)) {
			hql.append(" and faultType = ?");
			queryParams.add(queryModel.getFaultType());
		}
		//处理状态
		if (!ObjectUtils.equals(queryModel.getStatus(),null)) {
			hql.append(" and faultStatus = ?");
			queryParams.add(queryModel.getStatus());
		}
		//咨询人员
		if (StringTools.hasText(queryModel.getOptClientLike())) {
			hql.append(" and contactPerson like ?");
			queryParams.add("%" + queryModel.getOptClientLike() + "%");
		}
		//咨询时间
		if (!ObjectUtils.equals(queryModel.getFromConsultDate(),null) || !ObjectUtils.equals(queryModel.getToConsultDate(),null)) {
			hql.append(" and faultTime between ? and ? ");
			queryParams.add(queryModel.getFromConsultDate());
			queryParams.add(queryModel.getToConsultDate());
		}
		//处理人员
		if (StringTools.hasText(queryModel.getOptUserLike())) {
			hql.append(" and optUserName like ?");
			queryParams.add("%" + queryModel.getOptUserLike() + "%");
		}
		//处理时间
		if (!ObjectUtils.equals(queryModel.getFromOptDate(),null) || !ObjectUtils.equals(queryModel.getToOptDate(),null)) {
			hql.append(" and faultTime between ? and ? ");
			queryParams.add(queryModel.getFromOptDate());
			queryParams.add(queryModel.getToOptDate());
		}
		
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return  super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.pcsp.dao.techsupport.fault.IFaultDeclareOptLogDao#queryListByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareOptLogQueryModel)
	 * FaultDeclareOptLogDaoImpl.java
	 */
	@Override
	public List<FaultDeclareOptLog> queryListByParam(
			FaultDeclareOptLogQueryModel queryModel) {
		return null;
	}

	/**
	 * @see cn.com.atnc.pcsp.dao.techsupport.fault.IFaultDeclareOptLogDao#findByFaultDeclareId(java.lang.String)
	 * FaultDeclareOptLogDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultDeclareOptLog> findByFaultDeclareId(String id) {
		// TODO Auto-generated method stub
		return (List<FaultDeclareOptLog>) this.queryList(
						"from FaultDeclareOptLog where faultDeclare.id=? order by optTime asc",
						id);
	}

}
