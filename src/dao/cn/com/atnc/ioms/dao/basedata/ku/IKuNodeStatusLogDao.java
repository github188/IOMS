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
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusLog;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusLogQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:44:13
 * @version:1.0
 */

public interface IKuNodeStatusLogDao extends
		IBaseDao<KuNodeStatusLog> {
	public Pagination queryPage(KuStatusLogQueryModel queryModel);

	public List<KuNodeStatusLog> findKlogByKuNodeId(KuStatusLogQueryModel qm);
	
}
