/**
 * @Title:AtmdayCheckService.java
 * @author shijiyong
 * @data 2016年9月26日上午10:39:35
 * @version v1.0
 */
package cn.com.atnc.ioms.mng.duty.atm.day;

import java.util.List;

import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;

/**
 * ATM日检路由器子类Service
 * 
 * @author 王凌斌
 * @2017年2月9日 下午3:09:11
 */
public interface AtmDaySonService {

	/**
	 * 新增
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午3:02:12
	 * @param user
	 * @param pageModel
	 */
	void save(ATMDayRoute atmDayRoute, AtmDayQueryModel pageModel, int index);
	 void save(ATMDayMgx atmDayMgx, AtmDayQueryModelMgx pageModelMgx, int index);

	/**
	 * 根据父类ID查找符合条件的子类集合（按照序号升序排列）
	 * 
	 * @author 王凌斌
	 * @2017年2月10日 下午1:11:46
	 * @param ATMDaySon
	 * @return List<ATMDayRoute>
	 */
	List<ATMDaySon> findByRouteOrderBySerial(ATMDayRoute atmDayRoute);
	List<ATMDaySon> findByRouteOrderBySerial(ATMDayMgx atmDayMgx);

	/**
	 * 级联删除
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午10:26:55
	 * @param atmDaySons
	 *            void
	 */
	void deleteAll(List<ATMDaySon> atmDaySons);

	/**
	 * 更新
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午11:37:55
	 * @param atmDayRoute
	 * @param pageModel
	 *            void
	 */
	void update(ATMDayRoute atmDayRoute, AtmDayQueryModel pageModel);
    void update(ATMDayMgx atmDayMgx, AtmDayQueryModelMgx pageModelMgx);
   
}
