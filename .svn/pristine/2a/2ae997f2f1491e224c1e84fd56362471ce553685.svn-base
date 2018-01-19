/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;


import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.PnniLns;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDetailDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM网PortAXSM统计Dao接口
 * @author：KuYonggang
 * @date：2014-6-17下午3:53:59
 * @version：1.0
 */
public interface IPnniLnsDao extends IBaseDao<PnniLns> {
	
	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午10:20:38
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPnniLnsPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询集合对象
	 * @author：KuYonggang
	 * @date：2014-8-27上午11:54:12
	 * @param：queryModel
	 * @return：BaseModel
	 */
	public List<AtmPnniDBModel> queryPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-8-27下午8:22:05
	 * @param：
	 * @return：Object
	 */
	public List<AtmPnniDetailDBModel> queryAtmPnniDetailListByModel(NetworkStatQueryModel queryModel);

}
