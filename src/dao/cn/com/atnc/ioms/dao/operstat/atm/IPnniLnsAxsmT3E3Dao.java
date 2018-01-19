/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;


import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.PnniLnsAxsmT3E3;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM网PortAXSM统计Dao接口
 * @author：KuYonggang
 * @date：2014-6-17下午3:53:59
 * @version：1.0
 */
public interface IPnniLnsAxsmT3E3Dao extends IBaseDao<PnniLnsAxsmT3E3> {
	
	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午10:20:38
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPnniLnsAxsmT3E3PageByModel(NetworkStatQueryModel queryModel);

}
