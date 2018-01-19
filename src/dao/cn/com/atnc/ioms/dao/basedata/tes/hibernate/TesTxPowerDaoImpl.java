/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:58:27
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:58:27
 * @version:1.0
 */
@Repository("tesTxPowerDao")
public class TesTxPowerDaoImpl extends MyBaseDao<TesTxPower> implements
		ITesTxPowerDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerDao#updateValid(java.lang.Boolean)
	 */
	@Override
	public void updateValid(Boolean valid) {
		// TODO Auto-generated method stub
		String hql = "update TesTxPower set valid=?";
		super.executeHql(hql, valid);
	}

}
