package cn.com.atnc.ioms.dao.turndutymng.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

@Repository("ISignLeaveDao")
public class SignLeaveDaoImpl extends MyBaseDao<SignLeaveRecord> implements
		ISignLeaveDao {
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Pagination queryPage(TurnDutyQueryModel queryModel) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where  1=1");
		List<Object> queryParams = new ArrayList<Object>();

		if (queryModel.getDutyPlace() != null) {
			hql.append(" and dutyPlace = ?");
			queryParams.add(queryModel.getDutyPlace());
		}
		if (queryModel.getDutyRole() != null) {
			hql.append(" and dutyRole = ?");
			queryParams.add(queryModel.getDutyRole());
		}
		if (!StringUtils.isEmpty(queryModel.getCreater())) {
			hql.append(" and userinfo.name like ? escape '/' ");
			queryParams.add("%" + queryModel.getCreater() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getStartOptTime())) {

			hql.append(" and signTime >= ?");
			try {
				queryParams.add(startDate.parse(queryModel.getStartOptTime()
						+ " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(queryModel.getEndOptTime())) {

			hql.append(" and signTime <= ?");
			try {
				queryParams.add(endDate.parse(queryModel.getEndOptTime()
						+ " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by signTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public List<SignLeaveRecord> getDutyStatus(
			SignLeaveQueryModel signLeaveQueryModel) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (signLeaveQueryModel.getDutyStatus() != null) {
			hql.append("and dutyStatus=:dutyStatus");
			params.put("dutyStatus", signLeaveQueryModel.getDutyStatus());
		}

		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);
	}

	@Override
	public List<SignLeaveRecord> getOnDutyStatusByUser(
			SignLeaveQueryModel signLeaveQueryModel) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (signLeaveQueryModel.getUserinfo() != null) {
			hql.append("and userinfo.id=:userid");
			params.put("userid", signLeaveQueryModel.getUserinfo().getId());
		}

		hql.append(" order by signTime desc");

		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);

	}

	@Override
	public List<SignLeaveRecord> getSignRecordListByDate(
			SignLeaveQueryModel signLeaveQueryModel) {
		StringBuilder hql = new StringBuilder();

		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();

		if (signLeaveQueryModel.getSignTime() != null) {
			hql.append(" and signTime >=:starttime");
			params.put("starttime", signLeaveQueryModel.getSignTime());
		}
		if (signLeaveQueryModel.getLeaveTime() != null) {
			hql.append(" and signTime <=:endtime");
			params.put("endtime", signLeaveQueryModel.getLeaveTime());
		}
		if (signLeaveQueryModel.getDutyPlace() != null) {
			hql.append(" and dutyPlace =:dutyplace");
			params.put("dutyplace", signLeaveQueryModel.getDutyPlace());
		}

		hql.append(" and dutyStatus !='LEAVE' order by signTime desc");

		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);

	}

	public List<SignLeaveRecord> getViewByUser(
			SignLeaveQueryModel signLeaveQueryModel) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (signLeaveQueryModel.getUserinfo() != null) {
			hql.append("and userinfo.id=:userid");
			params.put("userid", signLeaveQueryModel.getUserinfo().getId());
		}
		if (signLeaveQueryModel.getSpare1() != null) {
			// 查询统计页用于展示当前人状态
			hql.append(" order by signTime desc");
		} else {
			hql.append(" and dutyStatus !='LEAVE' order by signTime desc");
		}

		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);

	}

	public List<SignLeaveRecord> getOnDutyCountByPlace(
			SignLeaveQueryModel signLeaveQueryModel) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (signLeaveQueryModel.getDutyPlace() != null) {
			hql.append(" and dutyPlace =:dutyplace");
			params.put("dutyplace", signLeaveQueryModel.getDutyPlace());
		}
		if (signLeaveQueryModel.getDutyRole() != null) {

			hql.append(" and dutyRole =:dutyrole");
			params.put("dutyrole", signLeaveQueryModel.getDutyRole());
		}
		hql.append(" and dutyStatus !='LEAVE' order by signTime desc");

		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);
	}

	public Pagination getUserListByIds(TurnDutyQueryModel queryModel)
			throws ServiceException {
		StringBuilder hql = new StringBuilder();
		hql.append(" from User where  1=1");
		List<Object> queryParams = new ArrayList<Object>();

		hql.append(" and id in (select distinct userinfo.id from SignLeaveRecord where 1=1 ");
		if (queryModel.getDutyPlace() != null) {
			hql.append(" and dutyPlace = ?");
			queryParams.add(queryModel.getDutyPlace());
		}
		if (queryModel.getDutyRole() != null) {
			hql.append(" and dutyRole = ?");
			queryParams.add(queryModel.getDutyRole());
		}
		if (!StringUtils.isEmpty(queryModel.getCreater())) {
			hql.append(" and userinfo.name like ? escape '/' ");
			queryParams.add("%" + queryModel.getCreater() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getStartOptTime())) {

			hql.append(" and signTime >= ?");
			try {
				queryParams.add(startDate.parse(queryModel.getStartOptTime()
						+ " 00:00:00"));
			} catch (ParseException e) {
				throw new ServiceException("时间格式错误");
			}

		}
		if (!StringUtils.isEmpty(queryModel.getEndOptTime())) {

			hql.append(" and signTime <= ?");
			try {
				queryParams.add(endDate.parse(queryModel.getEndOptTime()
						+ " 23:59:59"));
			} catch (ParseException e) {
				throw new ServiceException("时间格式错误");
			}

		}
		hql.append(" )");
		// 添加按值班人排序
		hql.append(" order by name asc ");
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();

		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public List<SignLeaveRecord> sumTotalTimes(SignLeaveQueryModel qm)
			throws ServiceException {

		StringBuilder hql = new StringBuilder();
		hql.append(" from SignLeaveRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (qm.getUserinfo() != null) {
			hql.append(" and userinfo.id =:user");
			params.put("user", qm.getUserinfo().getId());
		}
		if (qm.getDutyRole() != null) {

			hql.append(" and dutyRole =:dutyrole");
			params.put("dutyrole", qm.getDutyRole());
		}
		// 添加查询时间
		if (!StringUtils.isEmpty(qm.getStartOptTime())) {
			hql.append(" and signTime >=:startTime");
			try {
				params.put("startTime",
						startDate.parse(qm.getStartOptTime() + " 00:00:00"));
			} catch (ParseException e) {
				throw new ServiceException("时间格式错误");
			}
		}
		// 添加查询时间
		if (!StringUtils.isEmpty(qm.getEndOptTime())) {
			hql.append(" and signTime <=:endTime");
			try {
				params.put("endTime",
						endDate.parse(qm.getEndOptTime() + " 23:59:59"));
			} catch (ParseException e) {
				throw new ServiceException("时间格式错误");
			}
		}

		hql.append(" order by signTime desc");
		return (List<SignLeaveRecord>) super.queryList(hql.toString(), params);
	}

	/**
	 * 查询值班用户列表
	 * 
	 * @author duanyanlin
	 * @date 2016年7月6日下午2:36:49
	 * @param qm
	 *            签到离岗记录查询model
	 * @return list 返回用户列表
	 */
	@SuppressWarnings("unchecked")
	public List<User> getEngineerListByPlace(SignLeaveQueryModel qm) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from User where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		hql.append(" and id in (select distinct userinfo.id from SignLeaveRecord where 1=1 ");
		// 值班地点
		/*
		 * if(qm.getDutyPlace() != null){
		 * hql.append(" and dutyPlace =:dutyPlaces");
		 * params.put("dutyPlaces",qm.getDutyPlace()); } //值班员角色
		 * if(qm.getDutyRole() != null){ hql.append(" and dutyRole =:dutyRole");
		 * params.put("dutyRole",qm.getDutyRole()); }
		 */
		hql.append(" and dutyStatus !='LEAVE' )");
		return (List<User>) super.queryList(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEngineerListByPlaceDuty(SignLeaveQueryModel qm) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from User where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		hql.append(" and id in (select distinct userinfo.id from SignLeaveRecord where 1=1 ");
		// 值班地点
		if (!ObjectUtils.equals(qm.getDutyPlace() ,null)) {
			hql.append(" and dutyPlace =:dutyPlaces");
			params.put("dutyPlaces", qm.getDutyPlace());
		}
		// 值班员角色
		if (!ObjectUtils.equals(qm.getDutyRole() ,null)) {
			hql.append(" and dutyRole =:dutyRole");
			params.put("dutyRole", qm.getDutyRole());
		}
		hql.append(" and dutyStatus !='LEAVE' )");
		return (List<User>) super.queryList(hql.toString(), params);
	}
}
