/**
 * @ProjectName PCSP
 * @FileName TeleGraphDao.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.telegraph
 * @author WangLingbin
 * @date 2015年6月18日上午9:55:57
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.duty.telegraphduty;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.telegraphduty.TeleGraphSystem;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;

/**
 * 转报系统检查DAO
 * @author WangLingbin
 * @date 2016年1月8日 上午10:48:11
 * @since 1.0.0
 */
public interface TeleGraphSystemDao extends IBaseDao<TeleGraphSystem> {

	/**
	 * 根据查询条件Model查询转报网入网申请记录
	 * @param queryModel
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月18日上午10:26:53
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel);
	
	
}
