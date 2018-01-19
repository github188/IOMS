/**
 * 
 */
package cn.com.atnc.ioms.mng.operstat.atm;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM节点详情服务接口
 * 
 * @author：KuYonggang
 * @date：2014-5-27上午10:49:20
 * @version：1.0
 */
public interface INodeDetailService {

	/**
	 * 查询出所有ATM节点对象
	 * @author：KuYonggang
	 * @date：2014-5-27上午11:01:21
	 * @param：
	 * @return：List<AtmNode>
	 */
	List<AtmNode> getAtmNodes();
	
	/**
	 * 通过ATM节点ID查找ATM节点对象
	 * @author：KuYonggang
	 * @date：2014-5-27下午2:45:51
	 * @param：
	 * @return：AtmNode
	 */
	AtmNode getAtmNodeById(String id);
	
	/**
	 * 通过AtmNode查询Model查询AtmNode集合
	 * @author：KuYonggang
	 * @date：2014-8-8上午9:34:47
	 * @param：
	 * @return：List<AtmNode>
	 */
	List<AtmNode> queryList(AtmNodeQueryModel queryModel);
	
	/**
	 * 通过ATM节点ID查询分页对象
	 * @author：KuYonggang
	 * @date：2014-5-27下午4:48:02
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForCard(NetworkStatQueryModel queryModel);
	/**
	 * 通过板卡ID查询板卡详情
	 * @author：KuYonggang
	 * @date：2014-7-21下午1:36:00
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForCardDetail(NetworkStatQueryModel queryModel);
	/**
	 * 通过ATM节点ID查询分页对象
	 * @author：KuYonggang
	 * @date：2014-5-27下午5:00:06
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForService(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-27下午5:00:25
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForBandWidth(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-27下午5:00:36
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForAlarm(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-27下午5:00:49
	 * @param：
	 * @return：Pagination
	 */
	List<AtmServiceRunInfo> queryPageForRuninfo(NetworkStatQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-27下午5:01:04
	 * @param：
	 * @return：Pagination
	 */
	Pagination queryPageForRelay(NetworkStatQueryModel queryModel);

	/**
	 * 根据atm节点代码查询节点对象
	 * @author：KuYonggang
	 * @date：2014-6-19下午7:10:48
	 * @param：
	 * @return：BaseModel
	 */
	Object getAtmNodeByNodeCode(String nodeCode);

	/**
	 * 根据ATM节点代码查询环境运行信息集合
	 * @author：KuYonggang
	 * @date：2014-6-26上午11:42:18
	 * @param：nodeCode
	 * @return：BaseModel
	 */
	List<NodeEnvRunInfo> getEnvRuninfoByNodeCode(NetworkStatQueryModel queryModel);
}
