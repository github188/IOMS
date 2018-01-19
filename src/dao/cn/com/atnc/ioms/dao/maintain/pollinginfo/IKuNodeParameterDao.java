/**
 * @ProjectName IOMS
 * @FileName IKuNodeParameterDao.java
 * @PackageName:cn.com.atnc.ioms.dao.operstat.ku
 * @author KuYonggang
 * @date 2015年4月1日下午1:23:34
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.pollinginfo;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeParameter;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * ku节点参数Dao接口
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:23:34
 * @since 1.0.0
 */
public interface IKuNodeParameterDao extends IBaseDao<KuNodeParameter> {
	
	public Pagination queryPage(PollingInfoQueryModel queryModel);

	public Pagination queryViewPage(PollingInfoQueryModel queryModel);

}
