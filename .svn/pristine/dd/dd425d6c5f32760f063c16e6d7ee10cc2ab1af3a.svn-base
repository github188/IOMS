package cn.com.atnc.ioms.dao.faultmng.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultTypeSonDao;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeSon;

/**
 * 子级管理
 * @author duanyanlin 
 * 2016年6月17日 下午3:13:05
 */
@Repository("faultTypeSonDao")
public class FaultTypeSonDaoImpl extends MyBaseDao<FaultTypeSon> implements
		IFaultTypeSonDao {

	/**
	 * 根据父级类型id查询子级类型列表
	 * @author duanyanlin
	 * @date 2016年6月23日下午1:01:55
	 * @param faultTypeParentId 父級id
	 * @return List 事件子级类型列表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FaultTypeSon> findByParentId(String faultTypeParentId){
		StringBuilder hql = new StringBuilder(" from FaultTypeSon where 1=1 ");
		List<Object> params = new ArrayList<>();
		//事件单id
		if (!StringUtils.isEmpty(faultTypeParentId)) {
			hql.append(" and parentId.id = ? ");
			params.add(faultTypeParentId);
		}
		return (List<FaultTypeSon>) super.queryList(hql.toString(),
				params.toArray());
	}
}