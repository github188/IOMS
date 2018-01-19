package cn.com.atnc.ioms.dao.faultmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.faultmng.FaultTypeSon;

/**
 * 故障单种类子级管理
 * @author duanyanlin
 * @date 2016年8月5日下午4:10:07
 */
public interface IFaultTypeSonDao extends IBaseDao<FaultTypeSon> {
	
	/**
	 * 根据父级类型id查询子级类型列表
	 * @author duanyanlin
	 * @date 2016年6月23日下午1:01:55
	 * @param faultTypeParentId 父级类型id
	 * @return List
	 */
	public List<FaultTypeSon> findByParentId(String faultTypeParentId);
}