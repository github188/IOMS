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

import java.util.Date;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

/**
 * ku节点参数Dao接口
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:23:34
 * @since 1.0.0
 */
public interface IKuNodeInfoDao extends IBaseDao<KuNodeInfo> {

	public Pagination queryPage(PollingInfoQueryModel queryModel);

	/**
	 * 根据维保设备获取最新一条的节点信息集合
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午1:09:24
	 * @param maintainEquips
	 * @return List<KuNodeInfo>
	 */
	public List<KuNodeInfo> findByMaintainEquip(
			List<MaintainEquip> maintainEquips);

	/**
	 * 根据维保设备和时间查找节点信息集合
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午3:04:19
	 * @param maintainEquip
	 * @param date
	 * @return List<KuNodeInfo>
	 */
	public List<KuNodeInfo> findByMaintainEquip(MaintainEquip maintainEquip,
			Date date);

}
