/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.model.operstat.atm.AtmEquipDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM设备统计Dao接口
 * @author：KuYonggang
 * @date：2014-6-17下午3:53:59
 * @version：1.0
 */
public interface IAtmEquipDao extends IBaseDao<AtmNode> {
	
	/**
	 * 根据查询Model查询List集合
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:09:17
	 * @param：queryModel
	 * @return：void
	 */
	public List<AtmEquipDBModel> queryListByParam(NetworkStatQueryModel queryModel);

	/**
	 *  根据查询Model查询AtmNode集合
	 * @author：KuYonggang
	 * @date：2014-6-17下午4:15:59
	 * @param：queryModel
	 * @return：list
	 */
	public List<AtmNode> querylistByModel(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询设备详情分页对象
	 * @author：KuYonggang
	 * @date：2014-6-17下午4:37:32
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryDetailPageByParam(NetworkStatQueryModel queryModel);
}
