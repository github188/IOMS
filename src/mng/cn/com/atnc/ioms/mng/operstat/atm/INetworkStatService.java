/**
 * 
 */
package cn.com.atnc.ioms.mng.operstat.atm;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.operstat.atm.AtmNodeRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.entity.operstat.atm.NodeEnvRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBTbModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmBandDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmEquipDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPnniDetailDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmPortDBModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmServiceDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM网运行统计Service接口
 * @author：KuYonggang
 * @date：2014-5-21下午6:33:33
 * @version：1.0
 */
public interface INetworkStatService {

	/**
	 * 根据封装了查询参数的ATM告警Model对象来查询List<AtmAlarmDBTbModel>
	 * @author：KuYonggang
	 * @date：2014-5-22上午8:58:29
	 * @param：atmAlarmModel
	 * @return：List<AtmAlarmDBTbModel>
	 */
	public List<AtmAlarmDBTbModel> queryAtmAlarmDBTbModelsByModel(NetworkStatQueryModel atmAlarmModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-5-23下午4:42:30
	 * @param：queryModel
	 * @return： List<AtmAlarmDBModel>
	 */
	public List<AtmAlarmDBModel> queryListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 根据ATM节点ID查询
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:01:34
	 * @param：id
	 * @return：void
	 */
	public void queryListById(String id);

	/**
	 * 查询Atm告警分页对象
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:02:44
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<AtmNodeRunInfo> queryAtmAlarmListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询环境告警分页对象
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:14:51
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<NodeEnvRunInfo> queryEnvAlarmListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询板卡告警分页对象
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:15:38
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<AtmCardAlarmDBModel> queryCardAlarmListByModel(NetworkStatQueryModel queryModel);
	
	/**
	 * 查询各个管局下对应的所有ATM节点的不同种类告警的总数量（提供给首页的接口）
	 * @author：KuYonggang
	 * @date：2014-6-11上午9:47:55
	 * @param：
	 * @return：List<AtmAlarmBaseModel>
	 */
	public List<AtmAlarmDBModel> getAllAtmAlarm();
	
	/**
	 * 查询Atm业务统计分页对象
	 * @author：KuYonggang
	 * @date：2014-5-26下午3:02:44
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<AtmServiceDBModel> queryAtmServiceDBListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询Atm业务统计详情分页对象
	 * @author：KuYonggang
	 * @date：2014-6-17下午2:37:56
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryServiceDetailPageByModel(NetworkStatQueryModel queryModel);
	
	/**
	 * 查询Atm业务运行信息分页对象
	 * @author：KuYonggang
	 * @date：2014-6-19下午4:26:18
	 * @param：queryModel
	 * @return：Pagination
	 */
	public List<AtmServiceRunInfo> queryServiceAlarmListByModel(NetworkStatQueryModel queryModel);
	
	/**
	 *  查询Atm设备统计list集合
	 * @author：KuYonggang
	 * @date：2014-6-17下午3:48:54
	 * @param：queryModel
	 * @return：List<AtmEquipDBModel>
	 */
	public List<AtmEquipDBModel> queryAtmEquipListByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询Atm设备统计对象集合
	 * @author：KuYonggang
	 * @date：2014-6-17下午4:15:07
	 * @param：queryModel
	 * @return：List
	 */
	public List<AtmNode> queryAtmNodeListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询Atm设备详情分页集合
	 * @author：KuYonggang
	 * @date：2014-6-17下午4:36:18
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryEquipDetailPageByModel(NetworkStatQueryModel queryModel);

	/**查询Atm端口统计集合对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午9:42:35
	 * @param：queryModel
	 * @return：List<AtmPortDBModel>
	 */
	public List<AtmPortDBModel> queryAtmPortListByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询Atm端口统计分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20上午10:19:29
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryAtmPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询Atm全网带宽统计详情分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午1:42:29
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryBandDetailPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询Atm全网带宽统计Model集合
	 * @author：KuYonggang
	 * @date：2014-6-20下午1:57:38
	 * @param：queryModel
	 * @return：List<AtmBandDBModel>
	 */
	public List<AtmBandDBModel> queryAtmBandListByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询AXSM端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:39:56
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryAXSMPortDetailPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询AXSME端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:06
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryAXSMEPortDetailPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询AXSMXG端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:13
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryAXSMXGPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询CESM端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:21
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryCESMPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询MPSM端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:35
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryMPSMPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询MPSMFR端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:42
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryMPSMFRPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 *  查询PXM端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:51
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryPXMPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询FRSM端口分页对象
	 * @author：KuYonggang
	 * @date：2014-6-20下午3:40:57
	 * @param：queryModel
	 * @return：Pagination
	 */
	public Pagination queryFRSMPortPageByModel(NetworkStatQueryModel queryModel);

	/**
	 * 查询ATM板卡告警详情分页对象
	 * @author：KuYonggang
	 * @date：2014-8-23下午6:43:04
	 * @param：
	 * @return：BaseModel
	 */
	public Pagination queryAtmCardAlarmDetailPage(NetworkStatQueryModel qm);

	//以下为端口统计数据库表变更之后新增的方法
	public List<AtmPnniDBModel> queryAtmPnniPageByModel(NetworkStatQueryModel queryModel);
	public Pagination queryPnniLnsAxsmOC3PageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsAxsmT1E1PageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsAxsmT3E3PageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsAxsmXGPageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsCesmPageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsFrsmPageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsMpsmPageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsMpsmFrmPageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsPxm155PageByModel(NetworkStatQueryModel qm);
	public Pagination queryPnniLnsPxmT1E1PageByModel(NetworkStatQueryModel qm);

	/**
	 * @author：KuYonggang
	 * @date：2014-8-27下午8:21:08
	 * @param：
	 * @return：Object
	 */
	public List<AtmPnniDetailDBModel> queryAtmPnniDetailListByModel(NetworkStatQueryModel queryModel);
}
