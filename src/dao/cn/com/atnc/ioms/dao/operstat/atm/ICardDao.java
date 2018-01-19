/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.Card;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 板卡Dao接口
 * @author：KuYonggang
 * @date：2014-7-21下午1:37:32
 * @version：1.0
 */
public interface ICardDao extends IBaseDao<Card> {

	/**
	 * 通过atm节点ID查询板卡详情
	 * @author：KuYonggang
	 * @date：2014-5-27下午4:51:26
	 * @param：atmNodeId
	 * @return：Pagination
	 */
	public Pagination queryPageForCardDetail(NetworkStatQueryModel queryModel);
}
