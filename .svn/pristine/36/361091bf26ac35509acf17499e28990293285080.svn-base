/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:44:13
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatModel;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:44:13
 * @version:1.0
 */

public interface IKuNodeStatusDao extends IBaseDao<KuNodeStatus> {

	public List<KuNodeStatus> getLastestList();

	public Pagination queryPage(KuStatusQueryModel qm)throws ServiceException ;

	public List<KuBureauStatModel> getLatestStat(KuBureauStatQueryModel qm);
	
	public List<KuNodeStatus> findByKuNodeId(KuStatusQueryModel qm);
}
