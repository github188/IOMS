/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.operstat.ku;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusStat;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;
import cn.com.atnc.ioms.model.welcome.AlarmTotalStatModel;

/**
 * 数据管理--Ku节点管理
 * 
 * @author:HuangYijie
 * @date:2014-3-24 上午10:46:39
 * @version:1.0
 */

public interface IKuStatusStatManager {

	/**
	 * 分页查询统计结果
	 * 
	 * @author:HuangYijie
	 * 
	 * @param model
	 * @return Pagination
	 */
	public Pagination queryStatPage(KuStatQueryModel model);

	/**
	 * G
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-4 下午1:31:44
	 * 
	 * @param qm
	 * @return Pagination
	 */
	public Pagination queryDetailPage(KuStatusQueryModel qm)
			throws ServiceException;

	public Pagination queryLogPage(KuStatusLogQueryModel qm);

	public String getLastStatId();

	public KuNodeStatusStat findStatById(String id);

	public List<AlarmTotalStatModel> getLatestStat();

	public List<KuNodeStatus> findByKuNodeId(KuStatusQueryModel qm);

	public List<KuNodeStatusLog> findKlogByKuNodeId(KuStatusLogQueryModel qm2);

	public List<Odu> findODUBySite(OduQueryModel qm3);


}
