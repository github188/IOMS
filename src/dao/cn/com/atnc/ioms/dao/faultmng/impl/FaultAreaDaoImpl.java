package cn.com.atnc.ioms.dao.faultmng.impl;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultAreaDao;
import cn.com.atnc.ioms.entity.faultmng.FaultArea;

/**
 * 区域管理数据库实现类
 * 
 * @author duanyanlin 
 * 2016年6月17日 下午2:47:13
 */
@Repository("faultAreaDao")
public class FaultAreaDaoImpl extends MyBaseDao<FaultArea> implements
		IFaultAreaDao {

}