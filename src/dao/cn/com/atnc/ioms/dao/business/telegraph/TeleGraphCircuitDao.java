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
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 民航转报网转报电路申请信息DAO
 * 
 * @author WangLingbin
 * @date 2015年10月19日 上午8:41:34
 * @since 1.0.0
 */
public interface TeleGraphCircuitDao extends IBaseDao<TeleGraphCircuit> {

	/**
	 * 通过查询条件model查询申请记录
	 * 
	 * @author WangLingbin
	 * @date 2015年10月19日下午4:01:49
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);

	/**
	 * 根据父类TeleGraph的id查找TeleGraphApply集合
	 * 
	 * @param id
	 *            父类TeleGraph的id
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月20日下午4:26:37
	 * @since 1.0.0
	 */
	List<TeleGraphCircuit> getCircuitsByParentId(String id);

	/**
	 * 
	 * 获取需要发送短信的数据
	 *
	 * @return
	 * @date 2015年11月26日下午6:09:44
	 * @since 1.0.0
	 */
	public List<TeleGraphCircuit> getListSendMessage();
}
