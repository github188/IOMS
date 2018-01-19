package cn.com.atnc.ioms.dao.tempcircuit.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitTesKuBroadDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesKuBroad;

/**
 * @author wangpeng
 * @date 2014-8-29 下午3:14:46
 * @version 1.0
 */
@Repository("tempCircuitTesKuBroadDao")
public class TempCircuitTesKuBroadDaoImpl extends
		MyBaseDao<TempCircuitTesKuBroad> implements ITempCircuitTesKuBroadDao {

}
