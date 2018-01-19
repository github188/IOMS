/**
 * 
 */
package cn.com.atnc.ioms.dao.techsupport.fault.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.techsupport.fault.IFaultDeclareDao;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareRecordQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 类说明：故障申报Dao接口实现
 * 
 * @author：KuYonggang
 * @date：2014-4-3下午7:57:48
 * @version：1.0
 */
@Repository
public class FaultDeclareDaoImpl extends MyBaseDao<FaultDeclare> implements
		IFaultDeclareDao {

	/**
	 * @see cn.com.atnc.pcsp.dao.techsupport.fault.IFaultDeclareDao#queryPageByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareQueryModel)
	 * FaultDeclareDaoImpl.java
	 * 故障申报记录查询时使用
	 */
	@Override
	public Pagination queryPageByParam(FaultDeclareRecordQueryModel queryModel) {
		// 两种写法，一种使用？占位符，适用于查询值单一的情况。
		StringBuilder hql = new StringBuilder();
		hql.append("from FaultDeclare where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		//处理状态集合
		if (!ObjectUtils.equals(queryModel.getStatusList(),null)) {
			hql.append(" and faultStatus in (");
			List<AllStatus> faultStatus = queryModel.getStatusList();
			for (AllStatus status : faultStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
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
		//申报类型
		if (!ObjectUtils.equals(queryModel.getDeclareType(),null)) {
			hql.append(" and declareType = ?");
			queryParams.add(queryModel.getDeclareType());
		}
		//咨询人员
		if (StringTools.hasText(queryModel.getOptClientLike())) {
			hql.append(" and contactPerson like ? escape '\\' ");
			queryParams.add("%" + queryModel.getOptClientLike() + "%");
		}
		//咨询时间起
		if (!ObjectUtils.equals(queryModel.getFromConsultDate(),null)) {
			hql.append(" and faultTime > ? ");
			queryParams.add(queryModel.getFromConsultDate());
		}
		//咨询时间至
		if (!ObjectUtils.equals(queryModel.getToConsultDate(),null)) {
			hql.append(" and faultTime < ? ");
			queryParams.add(queryModel.getToConsultDate());
		}
		//处理人员
		if (StringTools.hasText(queryModel.getOptUserLike())) {
			hql.append(" and updateUser like ? escape '\\' ");
			queryParams.add("%" + queryModel.getOptUserLike() + "%");
		}
		//处理时间起
		if (!ObjectUtils.equals(queryModel.getFromOptDate(),null)) {
			hql.append(" and updateTime > ? ");
			queryParams.add(queryModel.getFromOptDate());
		}
		//处理时间至
		if (!ObjectUtils.equals(queryModel.getToOptDate(),null)) {
			hql.append(" and updateTime < ? ");
			queryParams.add(queryModel.getToOptDate());
		}
		hql.append(" order by faultTime asc ");
		//System.out.println("hql:"+hql.toString());
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	/**
	 * @see cn.com.atnc.pcsp.dao.techsupport.fault.IFaultDeclareDao#queryListByParam(cn.com.atnc.pcsp.model.techsupport.fault.FaultDeclareQueryModel)
	 * FaultDeclareDaoImpl.java
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultDeclare> queryListByParam(FaultDeclareDealQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from FaultDeclare where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		if (!ObjectUtils.equals(queryModel.getStatusList(),null)) {
			hql.append(" and faultStatus in (");
			List<AllStatus> faultStatus = queryModel.getStatusList();
			for (AllStatus status : faultStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//申报类型：用于区分故障申报和技术咨询
		if (!ObjectUtils.equals(queryModel.getDeclareType(),null)) {
			hql.append(" and declareType = ?");
			queryParams.add(queryModel.getDeclareType());
		}
		//处理人员：用于过滤出当前用户可操作的记录
		if (StringTools.hasText(queryModel.getUpdateUser())) {
			hql.append(" and updateUser = ?");
			queryParams.add(queryModel.getUpdateUser());
		}
		//当前时间：用于判断用户确认时间是否已经超出当前时间
		if (!ObjectUtils.equals(queryModel.getNowDate(),null)) {
			hql.append(" and confirmTime < ?");
			queryParams.add(queryModel.getNowDate());
		}
		return (List<FaultDeclare>) super.queryList(hql.toString(),
				queryParams.toArray());
	}

	/**
	 * @see cn.com.atnc.ioms.dao.techsupport.fault.IFaultDeclareDao#queryPageForDeal(cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel)
	 * FaultDeclareDaoImpl.java
	 * 故障申报处理tab分页查询时使用
	 */
	@Override
	public Pagination queryPageForDeal(FaultDeclareDealQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append("from FaultDeclare where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		//处理状态：根据状态查询出tab分页结果
		if (!ObjectUtils.equals(queryModel.getStatusList(),null)) {
			hql.append(" and faultStatus in (");
			List<AllStatus> faultStatus = queryModel.getStatusList();
			for (AllStatus status : faultStatus) {
				hql.append("?,");
				queryParams.add(status);
			}
			hql.deleteCharAt(hql.length()-1);
			hql.append(")");
		}
		//申报类型：用于区分故障申报和技术咨询
		if (!ObjectUtils.equals(queryModel.getDeclareType(),null)) {
			hql.append(" and declareType = ?");
			queryParams.add(queryModel.getDeclareType());
		}
		//处理人员：用于过滤出当前用户可操作的记录
		if (StringTools.hasText(queryModel.getUpdateUser())) {
			hql.append(" and updateUser = ?");
			queryParams.add(queryModel.getUpdateUser());
		}
		//当前时间：用于判断用户确认时间是否已经超出当前时间
		if (!ObjectUtils.equals(queryModel.getNowDate(),null)) {
			hql.append(" and confirmTime < ?");
			queryParams.add(queryModel.getNowDate());
		}
		//值班员或值班经理解决重启的记录所有值班员和值班经理都可以看到
		if(queryModel.getStatusList().contains(AllStatus.SOLVED_OPEN)){
			hql.append(" or faultStatus = ?");
			queryParams.add(AllStatus.SOLVED_OPEN);
		}
		//值班员或值班经理解决重启的记录所有值班员和值班经理都可以看到
		if(queryModel.getStatusList().contains(AllStatus.SOLVED_OPEN)){
			hql.append(" or faultStatus = ?");
			queryParams.add(AllStatus.SOLVED_OPEN);
		}
		hql.append(" order by faultTime desc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
