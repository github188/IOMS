/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.Ports;
import cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM端口统计Dao接口
 * @author：KuYonggang
 * @date：2014-6-17下午3:53:59
 * @version：1.0
 */
public interface IAtmPortDao extends IBaseDao<Ports> {
	
	/**
	 * 根据查询Model查询List集合
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:09:17
	 * @param：queryModel
	 * @return：void
	 */
	public List<AtmPortDBModel> queryListByParam(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午10:20:38
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPageByModel(NetworkStatQueryModel queryModel);

}
