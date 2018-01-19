/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite
 * @author ku
 * @date 2015年5月13日下午4:03:05
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.duty.telegraphduty;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.telegraphduty.TeleGraphSystem;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;


/**
 * 转报系统检查Service
 * @author WangLingbin
 * @date 2016年1月8日 上午10:57:00
 * @since 1.0.0
 */
public interface TeleGraphSystemService {

	/**
	 * 通过查询条件model查询记录
	 * @param queryModel
	 * @author WangLingbin
	 * @date  2016年1月8日上午10:57:47
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel);

	/**
	 * 获取所有记录
	 * @author WangLingbin
	 * @date  2016年1月8日上午10:58:10
	 * @since 1.0.0
	 */
	List<TeleGraphSystem> getAll();
	
	/**
	 * 保存记录
	 * @author WangLingbin
	 * @date  2016年1月8日上午10:58:32
	 * @since 1.0.0
	 */
	TeleGraphSystem save(TeleGraphSystem teleGraphSystem);

	/**
	 * 更新记录
	 * @author WangLingbin
	 * @date  2016年1月8日上午10:58:59
	 * @since 1.0.0
	 */
	TeleGraphSystem update(TeleGraphSystem teleGraphSystem);

	/**
	 * 删除记录
	 * @param teleGraphSystem 
	 * @author WangLingbin
	 * @date  2016年1月8日上午10:59:29
	 * @since 1.0.0
	 */
	void delete(TeleGraphSystem teleGraphSystem);
	
	/**
	 * 根据主键ID查找记录
	 * @author WangLingbin
	 * @date  2016年1月8日上午11:00:12
	 * @since 1.0.0
	 */
	TeleGraphSystem findById(String id);

}
