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

import java.io.Serializable;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * ku节点参数Dao接口
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:23:34
 * @since 1.0.0
 */
public interface IKuCarrierFreqDao extends IBaseDao<KuCarrierFreq> {
	
	public Pagination queryPage(PollingInfoQueryModel queryModel);
	
	public Pagination queryViewPage(PollingInfoQueryModel queryModel);
	
	public List<KuCarrierFreq> findAll();

	public List<Long> queryEquip();

}
