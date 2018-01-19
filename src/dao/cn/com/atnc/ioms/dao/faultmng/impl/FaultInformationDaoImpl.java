package cn.com.atnc.ioms.dao.faultmng.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;

/**
 * 故障信息管理实现类
 * 
 * @author duanyanlin 
 * @date 2016年6月17日 下午3:08:54
 */
@Repository("faultInformationDao")
public class FaultInformationDaoImpl extends MyBaseDao<FaultInformation>
		implements IFaultInformationDao {

	/**
	 * 数据库查询公用部分
	 * @author duanyanlin
	 * @date 2016年7月8日下午2:36:44
	 * @param qm 事件处置查询model
	 * @return FaultHandleQueryModel 拼写查询语句
	 */
	public FaultHandleQueryModel queryHqlParams(FaultHandleQueryModel qm){
		
		StringBuilder hql = new StringBuilder(" from FaultInformation where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		//事件单来源
		if(!ObjectUtils.equals(qm.getSource(), null)){
			hql.append(" and source = ?");
			params.add(qm.getSource());
		}
		//事件单级别
		if(!ObjectUtils.equals(qm.getFaultLevel(), null)){
			hql.append(" and faultLevel = ?");
			params.add(qm.getFaultLevel());
		}
		// 故障单Id
		if (!StringUtils.isEmpty(qm.getFaultId())) {
			hql.append(" and id = ?");
			params.add(qm.getFaultId());
		}
		// 故障单编号
		if (!StringUtils.isEmpty(qm.getFaultNumber())) {
			hql.append(" and faultNumber = ?");
			params.add(qm.getFaultNumber());
		}
		// 申告人
		if (!StringUtils.isEmpty(qm.getContactsName())) {
			hql.append(" and contactsName like ? escape '/' ");
			params.add("%" + qm.getContactsName() + "%");
		}
		// 时间
		if (!StringUtils.isEmpty(qm.getStartOptTime())) {
			hql.append(" and to_char(pickUpPhoneTime,'YYYY-MM-DD') >= ?");
			params.add(qm.getStartOptTime());
		}
		if (!StringUtils.isEmpty(qm.getEndOptTime())) {
			hql.append(" and to_char(pickUpPhoneTime,'YYYY-MM-DD') <= ?");
			params.add(qm.getEndOptTime());
		}
		//地区
		if(!StringUtils.isEmpty(qm.getFaultArea())){
			hql.append(" and faultArea like ?");
			params.add("%" + qm.getFaultArea() + "%");
		}
		//单位
		if(!StringUtils.isEmpty(qm.getFaultArea())){
			hql.append(" and faultCompany like ?");
			params.add("%" + qm.getFaultCompany() + "%");
		}
		//子故障单编号
		if(qm.getFaultChildNumber() != null){
			hql.append(" and faultChildNumber = ?");
			params.add(qm.getFaultChildNumber());
		}
		//父级故障单id
		if(qm.getParentId() != null){
			hql.append(" and faultParentId = ?");
			params.add(qm.getParentId());
		}
		// 当前处理人
		if (!StringUtils.isEmpty(qm.getCurrentHandleUser())) {
			hql.append(" and currentHandleUser like ? escape '/' ");
			params.add("%" + qm.getCurrentHandleUser() + "%");
		}
		// 申告电话
		if (!StringUtils.isEmpty(qm.getTelephoneNumber())) {
			hql.append(" and telephoneNumber like ?");
			params.add("%" + qm.getTelephoneNumber() + "%");
		}
		//坐席电话
		if(!StringUtils.isEmpty(qm.getStationPhone())){
			hql.append(" and stationPhone like ?");
			params.add("%" + qm.getStationPhone() + "%");
		}
		//事件类别
		if(qm.getEventType() != null){
			hql.append(" and eventType = ?");
			params.add(qm.getEventType());
		}
		//故障单状态（去除已删除的故障单）
		if(!qm.getIsDelete()){
			hql.append(" and faultStatus != ? ");
			params.add(FaultStatus.DELETE);
		}
		
		if (CollectionUtils.isNotEmpty(qm.getFaultStatus())) {
			hql.append(" and ( ");
			for (int i = 0; i < qm.getFaultStatus().size(); i++) {
				if (i == 0) {
						hql.append(" faultStatus = ? ");
				} else {
						hql.append(" or faultStatus = ? ");
				}
				params.add(qm.getFaultStatus().get(i));
			}
			hql.append(" ) ");
		}
		hql.append(" order by pickUpPhoneTime desc , faultChildNumber asc ");
		qm.setHql(hql.toString());
		qm.setParams(params);
		return qm;
	}
	
	/**
	 * 查询待评价事件单
	 */
	@Override
	public Pagination queryEvaluatePage(FaultHandleQueryModel qm) {
		//查询事件单数据库
		StringBuilder hql = new StringBuilder(" from FaultInformation where 1=1 ");
		//封装查询变量
		List<Object> params = new ArrayList<Object>();
		//事件评价状态
		if(!ObjectUtils.equals(qm.getFaultEvaluateStatus(), null)){
			hql.append(" and faultEvaluateStatus = ?");
			params.add(qm.getFaultEvaluateStatus());
		}
		//拼写查询事件第一处理人范围
		if (!StringUtils.isEmpty(qm.getFirstUsers())) {
			//第一处理人id in ('','')
			hql.append(" and firstHandelUser.id in ( ");
			//用户拼接字符串
			hql.append(qm.getFirstUsers());
			hql.append(" ) ");
		}
		//查询状态
		if (CollectionUtils.isNotEmpty(qm.getFaultStatus())) {
			hql.append(" and ( ");
			//拼接状态字符串
			for (int i = 0; i < qm.getFaultStatus().size(); i++) {
				//or链接
				if (i == 0) {
						hql.append(" faultStatus = ? ");
				} else {
						hql.append(" or faultStatus = ? ");
				}
				//添加条件
				params.add(qm.getFaultStatus().get(i));
			}
			hql.append(" ) ");
		}
		//按完成后的更新时间倒序
		hql.append(" order by updateTime desc ");
		//分页查询
		String countHql = "select count(id) " + hql.toString();
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());
	}
	/**
	 * 查询故障单（分页）
	 * 
	 * @author duanyanlin
	 * @date 2016年6月17日下午3:11:26
	 * @param qm 事件处置查询model
	 * @return Pagination 分页
	 */
	@Override
	public Pagination queryPage(FaultHandleQueryModel qm) {
		FaultHandleQueryModel fqm = this.queryHqlParams(qm);
		String countHql = "select count(id) " + fqm.getHql();
		return super.pageQuery(fqm.getHql(), fqm.getParams().toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());
	}
	
	/**
	 * 根据条件查询故障单列表
	 * @author duanyanlin
	 * @date 2016年6月27日下午2:01:46
	 * @param qm 事件处置查询model
	 * @return List 事件单列表查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FaultInformation> queryList(FaultHandleQueryModel qm){
		FaultHandleQueryModel fqm = this.queryHqlParams(qm);
		return (List<FaultInformation>) super.queryList(fqm.getHql(), fqm.getParams().toArray());
	}
	
	/**
	 * 根据故障单编号faultNumber降序查询事件单
	 * @author duanyanlin
	 * @date 2016年7月7日下午4:25:08
	 * @param qm 事件处置查询model
	 * @return List 事件单列表查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FaultInformation> queryListOrderByFaultNum(){
		StringBuilder hql = new StringBuilder(" from FaultInformation where 1=1 order by createTime desc ");
		return (List<FaultInformation>) super.queryList(hql.toString());
	}
}