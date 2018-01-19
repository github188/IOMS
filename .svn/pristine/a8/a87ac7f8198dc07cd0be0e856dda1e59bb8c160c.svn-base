/**
 * @Title:AtmdayCheckService.java
 * @author shijiyong
 * @data 2016年9月26日上午10:39:35
 * @version v1.0
 */
package cn.com.atnc.ioms.mng.duty.atm.day;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;

/**
 * ATM日检路由器Service
 * 
 * @author 王凌斌
 * @2017年2月9日 下午2:03:01
 */
public interface AtmDayRouteService {

	/**
	 * 查询
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午1:59:08
	 * @param queryModel
	 * @return Pagination
	 */
	Pagination queryPageByModel(AtmDayQueryModel queryModel);

	/**
	 * 新增
	 * 
	 * @author 王凌斌
	 * @2017年2月9日 下午3:02:12
	 * @param user
	 * @param pageModel
	 * @return ATMDayRoute
	 */
	void save(User user, AtmDayQueryModel pageModel);

	/**
	 * 根据ID查找实体
	 * 
	 * @author 王凌斌
	 * @2017年2月10日 下午4:21:28
	 * @param id
	 * @return ATMDayRoute
	 */
	ATMDayRoute findById(String id);

	/**
	 * 删除实体
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午9:52:29
	 * @param atmDayRoute
	 *            void
	 */
	void delete(ATMDayRoute atmDayRoute);

	/**
	 * 更新实体
	 * 
	 * @author 王凌斌
	 * @2017年2月13日 上午11:34:31
	 * @param user
	 * @param atmDayRoute
	 * @param pageModel
	 * @return ATMDayRoute
	 */
	ATMDayRoute update(User user, ATMDayRoute atmDayRoute,
			AtmDayQueryModel pageModel);

	/**
	 * 审核
	 * 
	 * @author 王凌斌
	 * @2017年2月15日 上午10:55:09
	 * @param user
	 * @param atmDayRoute
	 * @param pageModel
	 * @return ATMDayRoute
	 */
	ATMDayRoute audit(User user, ATMDayRoute atmDayRoute,
			AtmDayQueryModel pageModel);

}
