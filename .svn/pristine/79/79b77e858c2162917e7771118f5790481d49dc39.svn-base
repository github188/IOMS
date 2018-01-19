package cn.com.atnc.ioms.dao.faultmng.impl;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.model.faultmng.FaultHandleQueryModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 故障处置管理实现类
 * 
 * @author duanyanlin 
 * 2016年6月17日 下午2:54:31
 */
@Repository("faultHandleDao")
public class FaultHandleDaoImpl extends MyBaseDao<FaultHandle> implements
		IFaultHandleDao {

	/**
	 * 查询故障处理记录
	 * @author duanyanlin
	 * @date 2016年6月17日下午2:59:27
	 * @return List 处置记录
	 * @param qm 事件处置查询model
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FaultHandle> queryList(FaultHandleQueryModel qm) {
		StringBuilder hql = new StringBuilder(" from FaultHandle where 1=1 ");
		List<Object> params = new ArrayList<>();
		//故障单编号
		if (!StringUtils.isEmpty(qm.getFaultId())) {
			hql.append(" and faultId = ? ");
			params.add(qm.getFaultId());
		}
		//操作人
		if (!ObjectUtils.equals(qm.getCurrentUser(),null)) {
			hql.append(" and operator = ? ");
			params.add(qm.getCurrentUser());
		}
		//操作类型
		if (!ObjectUtils.equals(qm.getFaultHandelType(),null)) {
			hql.append(" and handleType = ? ");
			params.add(qm.getFaultHandelType());
		}
		//操作时间倒序排列
		hql.append(" order by operatTime desc ");
		return (List<FaultHandle>) super.queryList(hql.toString(),
				params.toArray());
	}
}