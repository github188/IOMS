/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 节点环境运行信息Dao接口
 * @author：KuYonggang
 * @date：2014-6-23下午1:28:10
 * @version：1.0
 */
public interface IEnvRuninfoDao extends IBaseDao<NodeEnvRunInfo> {

	/**
	 * 查询节点环境运行信息
	 * @author：KuYonggang
	 * @date：2014-6-26上午11:43:51
	 * @param：queryModel
	 * @return：Pagination
	 */
	Pagination queryPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询节点环境运行信息集合
	 * @author：KuYonggang
	 * @date：2014-6-26下午5:50:44
	 * @param：queryModel
	 * @return：List<NodeEnvRunInfo>
	 */
	List<NodeEnvRunInfo> queryListByModel(NetworkStatQueryModel queryModel);
}
