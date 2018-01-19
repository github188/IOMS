/**
 * @Title:AtmdayCheckDao.java
 * @author shijiyong
 * @data 2016年9月26日上午11:02:03
 * @version v1.0
 */
package cn.com.atnc.ioms.dao.duty.atm.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;
/**
 * ATM日检交换机DAO
 * 
 * @author 王志鹏
 * @time:2017年2月21日 上午11:14:18
 */
public interface AtmDayMgxDao extends IBaseDao<ATMDayMgx>  {

	/**
	 * 
	 * @author wangzhipeng
	 * @time:2017年2月21日 上午11:14:49
	 * @param queryModel1
	 * @return
	 */
	Pagination queryPageByModel(AtmDayQueryModelMgx queryModelMgx);
}
