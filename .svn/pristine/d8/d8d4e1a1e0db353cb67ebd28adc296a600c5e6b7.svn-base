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

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;

 /**
 * 此处添加类IEquipNodeManager的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-6 上午11:24:40
 * @since 1.0.0
 */
public interface IEquipNodeManager {

	/**
	 * 查询数据返回页面
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015-5-6下午3:21:54
	 * @since 1.0.0
	*/
	public Pagination queryPage(EquipNodeQueryModel queryModel);

	/**
	 * EquipNode添加方法
	 *
	 * @param queryModel
	 * @return
	 * @throws ServiceException 
	 * @date  2015-5-6下午3:22:19
	 * @since 1.0.0
	*/
	public EquipNode add(EquipNodeQueryModel queryModel) throws ServiceException;

	/**
	 * 根据ID查找单个实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-5-6下午3:22:41
	 * @since 1.0.0
	*/
	public EquipNode findById(String id);

	/**
	 * 删除指定实体
	 *
	 * @param equipNode
	 * @throws ServiceException 
	 * @date  2015-5-6下午3:23:00
	 * @since 1.0.0
	*/
	public void delete(EquipNode equipNode) throws ServiceException;

	
	/**
	 * 根据设备查找实体
	 * @param equip
	 * @author WangLingbin
	 * @date  2016年4月27日下午2:22:57
	 * @since 1.0.0
	 */
	public EquipNode findByMaintainEquip(MaintainEquip maintainEquip);

}
