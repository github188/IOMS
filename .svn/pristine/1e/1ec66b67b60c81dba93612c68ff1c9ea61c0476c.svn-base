/**
 * @Title:AtmdayCheckDao.java
 * @author shijiyong
 * @data 2016年9月26日上午11:02:03
 * @version v1.0
 */
package cn.com.atnc.ioms.dao.duty.atm.day;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;

/**
 * ATM日检路由器子类DAO
 * 
 * @author 王凌斌
 * @2017年2月9日 下午3:08:35
 */
public interface AtmDaySonDao extends IBaseDao<ATMDaySon> {

	/**
	 * 根据父类ID查找符合条件的子类集合（按照序号升序排列）
	 * 
	 * @author 王凌斌
	 * @2017年2月10日 下午1:13:46
	 * @param atmDayRoute
	 * @return List<ATMDayRoute>
	 */
	List<ATMDaySon> findByRouteOrderBySerial(ATMDayRoute atmDayRoute);
	List<ATMDaySon> findByRouteOrderBySerial(ATMDayMgx atmDayMgx);

}
