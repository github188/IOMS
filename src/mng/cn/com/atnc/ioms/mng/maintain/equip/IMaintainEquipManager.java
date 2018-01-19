/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName IMaintainManager.java
 * @PackageName:cn.com.atnc.ioms.mng.maintain.equip
 * @author ku
 * @date 2015年4月30日上午11:08:21
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.equip;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.model.maintain.satellite.SatelliteQueryModel;

/**
 * 运维设备Service接口
 *
 * @author ku
 * @date 2015年4月30日 上午11:08:21
 * @since 1.0.0
 */
public interface IMaintainEquipManager {

	/**
	 * 根据id查询运维设备实体信息
	 *
	 * @param id
	 * @return
	 * @author ku
	 * @date 2015年4月30日上午11:12:15
	 * @since 1.0.0
	 */
	public MaintainEquip findById(String id);

	/**
	 * 初始化告警监控数据
	 * 
	 * @author ku
	 * @date 2015年4月27日下午3:42:06
	 * @since 1.0.0
	 */
	public void initAlarmMonitor();

	/**
	 * 查询所有wafro8类型的MaintainEquip返回List
	 *
	 * @return
	 * @date 2015-5-4下午3:40:17
	 * @since 1.0.0
	 */
	public List<MaintainEquip> queryWAFList();

	/**
	 * 查出所有设备信息
	 *
	 * @return
	 * @date 2015-5-6下午1:36:21
	 * @since 1.0.0
	 */
	public List<MaintainEquip> findAll();

	public void update(MaintainEquip maintainEquip) throws ServiceException;

	/**
	 * 按照节点分组显示信息
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午2:10:27
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination findBySatellite(SatelliteQueryModel queryModel);

	/**
	 * 根据站点和设备类型查找维保设备集合
	 * 
	 * @author 王凌斌
	 * @2017年1月22日 下午4:15:04
	 * @param type
	 * @param satelliteSite
	 * @return List<MaintainEquip>
	 */
	public List<MaintainEquip> findBySiteAndType(NetworkType type,
			SatelliteSite satelliteSite);

	/**
	 * 根据站点和节点ID进行排序查找信息
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 下午2:57:47
	 * @return List<MaintainEquip>
	 */
	public List<MaintainEquip> findAllOrderBy();
}
