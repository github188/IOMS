/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfoDetail;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM板卡运行信息详情Dao接口
 * @author：KuYonggang
 * @date：2014-8-23下午5:12:21
 * @version：1.0
 */
public abstract interface IAtmCardRunInfoDetailDao extends IBaseDao<CardRunInfoDetail> {
	
	/**
	 * 查询ATM板卡运行信息分页对象
	 * @author：KuYonggang
	 * @date：2014-8-23下午5:13:53
	 * @param：qm 查询条件Model
	 * @return：Pagination
	 */
	Pagination queryPage(NetworkStatQueryModel qm);
}
