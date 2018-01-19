/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName IMaintainEquip.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.equip
 * @author ku
 * @date 2015年4月30日上午11:05:16
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.equip;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * 运维设备Dao接口
 *
 * @author ku
 * @date 2015年4月30日 上午11:05:16
 * @since 1.0.0
 */
public interface IMaintainEquipDao extends IBaseDao<MaintainEquip> {

	/**
	 * 查找告警监控实体集合
	 *
	 * @return
	 * @author ku
	 * @date 2015年4月27日下午4:08:30
	 * @since 1.0.0
	 */
	public List<MaintainEquip> findAlarmMonitorByEquip();

	public List<MaintainEquip> queryWAFList();

	/**
	 * 按照节点分组显示信息
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午2:13:36
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination findBySatellite(SatelliteQueryModel queryModel);

	/**
	 * 根据站点和类型查找维保设备集合
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午4:16:08
	 * @param type
	 * @param satelliteSite
	 * @return List<MaintainEquip>
	 */
	public List<MaintainEquip> findBySiteAndType(NetworkType type,
			SatelliteSite satelliteSite);

	/**
	 * 根据站点和节点排序查找信息
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午2:58:27
	 * @return List<MaintainEquip>
	 */
	public List<MaintainEquip> findAllOrderBy();
}
