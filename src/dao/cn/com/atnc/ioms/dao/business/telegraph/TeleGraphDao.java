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
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 民航转报网转报地址及路由基础信息DAO
 * 
 * @author WangLingbin
 * @date 2015年6月18日 上午9:55:57
 * @since 1.0.0
 */
public interface TeleGraphDao extends IBaseDao<TeleGraph> {

	/**
	 * 根据查询条件Model查询转报网入网申请记录
	 * 
	 * @param queryModel
	 * @return
	 * @author WangLingbin
	 * @date 2015年6月18日上午10:26:53
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);

	/**
	 * 根据基础信息查找
	 * 
	 * @param id
	 *            申请信息父类ID
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月30日下午3:42:46
	 * @since 1.0.0
	 */
	TeleGraph getTeleGraphByBaseInfo(String id);

	/**
	 * 获取需要发送短信的数据(转报电路)
	 *
	 * @return
	 * @author Wang Zhicheng
	 * @param type
	 * @date 2015年11月16日下午3:00:33
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessage();

	/**
	 * 获取需要发送给工程师短信的数据
	 *
	 * @return
	 * @author Wang Zhicheng
	 * @date 2015年11月16日下午3:20:45
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessageEng();

	/**
	 * 
	 * 所有提交至网控的转报地址消息均发送至客服专员处
	 *
	 * @return
	 * @author WangPeng
	 * @date 2015年11月26日下午5:53:35
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessageFirstCommit();
}
