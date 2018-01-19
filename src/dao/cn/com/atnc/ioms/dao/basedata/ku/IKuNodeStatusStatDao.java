/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:44:13
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatusStat;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:44:13
 * @version:1.0
 */

public interface IKuNodeStatusStatDao extends
		IBaseDao<KuNodeStatusStat> {

	
	public Pagination queryPage(KuStatQueryModel queryModel);
	
	public String getLastStatId();
}
