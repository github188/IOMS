/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.operstat.atm.AtmNodeRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBTbModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM全网告警统计Dao接口
 * 
 * @author：KuYonggang
 * @date：2014-5-23上午8:56:44
 * @version：1.0
 */
public interface IAtmAlarmStatDao extends IBaseDao<AtmNodeRunInfo> {

	/**
	 * 根据查询Model查询AtmAlarmDBTbModel list集合
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:09:17
	 * @param：queryModel
	 * @return：List<AtmAlarmDBTbModel>
	 */
	public List<AtmAlarmDBTbModel> queryAtmAlarmDBTbModelsByModel(NetworkStatQueryModel queryModel);
	
	/**
	 * 根据查询Model查询List集合
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:16:20
	 * @param：queryModel
	 * @return：void
	 */
	public List<AtmAlarmDBModel> queryListByParam(NetworkStatQueryModel queryModel);

	/**
	 * 根据ATM节点ID查询分页对象
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:03:35
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<AtmNodeRunInfo> queryAtmAlarmPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:16:36
	 * @param：queryModel
	 * @return：Object
	 */
	public List<NodeEnvRunInfo> queryEnvAlarmPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:16:41
	 * @param：queryModel
	 * @return：Object
	 */
	public List<AtmCardAlarmDBModel> queryCardAlarmPageByModel(NetworkStatQueryModel queryModel);
}
