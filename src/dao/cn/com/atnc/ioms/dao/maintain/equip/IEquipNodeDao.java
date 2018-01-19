/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName IEquipNodeDao.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.equip
 * @author ku
 * @date 2015年5月6日上午10:19:53
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.equip;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;

/**
 *  设备节点Dao接口
 *
 * @author ku
 * @date 2015年5月6日 上午10:19:53
 * @since 1.0.0
 */
public interface IEquipNodeDao extends IBaseDao<EquipNode> {

	public Pagination queryPage(EquipNodeQueryModel queryModel);

	/**
	 * 根据设备查找实体
	 * @param equip
	 * @author WangLingbin
	 * @date  2016年4月27日下午2:23:42
	 * @since 1.0.0
	 */
	public EquipNode findByMaintainEquip(MaintainEquip maintainEquip);

}
