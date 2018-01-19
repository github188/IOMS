/**
 * @ProjectName PCSP
 * @FileName TeleGraphDao.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.telegraph
 * @author WangLingbin
 * @date 2015年6月18日上午9:55:57
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.telegraph;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 民航转报网转报地址及路由申请信息DAO
 * @author WangLingbin
 * @date 2015年6月18日 上午9:55:57
 * @since 1.0.0
 */
public interface TeleGraphApplyDao extends IBaseDao<TeleGraphApply> {

	/**
	 * 根据查询条件Model查询转报网入网申请记录
	 * @param queryModel
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月18日上午10:26:53
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);
	
	
	/**
	 * 根据父类TeleGraph的id查找TeleGraphApply集合
	 * @param id	父类TeleGraph的id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年5月20日下午4:26:37
	 * @since 1.0.0
	 */
	List<TeleGraphApply> getApplysByParentId(String id);
}
