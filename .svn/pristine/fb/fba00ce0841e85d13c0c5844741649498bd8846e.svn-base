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

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * ODU设备轮询Dao接口
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:23:34
 * @since 1.0.0
 */
public interface IOduPollingDao extends IBaseDao<OduPolling> {
	
	public Pagination queryPage(PollingInfoQueryModel queryModel);

	/**
	 * 根据维保设备查找实体集合
	 * 
	 * @author 王凌斌
	 * @2017年1月23日 上午10:29:32
	 * @param modems
	 * @return List<OduPolling>
	 */
	public List<OduPolling> findByMaintainEquip(List<MaintainEquip> modems);

}
