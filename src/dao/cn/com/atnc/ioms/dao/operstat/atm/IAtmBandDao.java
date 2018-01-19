/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.PnniBandwidth;
import cn.com.atnc.ioms.model.operstat.atm.AtmBandDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM网带宽统计Dao接口
 * @author：KuYonggang
 * @date：2014-6-17下午3:53:59
 * @version：1.0
 */
public interface IAtmBandDao extends IBaseDao<PnniBandwidth> {
	
	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午10:20:38
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询对象集合
	 * @author：KuYonggang
	 * @date：2014-6-20下午2:02:29
	 * @param：queryModel
	 * @return：List<AtmBandDBModel>
	 */
	public List<AtmBandDBModel> queryListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-23下午1:17:12
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPageForBandWidth(NetworkStatQueryModel queryModel);

}
