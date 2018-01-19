/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite
 * @author ku
 * @date 2015年5月13日下午4:03:05
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph;

import java.util.List;

import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphConfig;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;


/**
 * 转报地址配置Service接口
 *
 * @author WangLingbin
 * @date 2015年6月18日 上午10:41:09
 * @since 1.0.0
 */
public interface TeleGraphConfigService {


	/**
	 * 保存申请记录
	 *
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:06
	 * @since 1.0.0
	 */
	void save(TeleGraphConfig teleGraphConfig);

	/**
	 * 根据主键ID获取申请对象
	 * @param id	主键ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:14
	 * @since 1.0.0
	 */
	TeleGraphConfig getTeleGraphConfigById(String id);

	/**
	 * 更新信息
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:29
	 * @since 1.0.0
	 */
	void update(TeleGraphConfig teleGraphConfig);

	/**
	 * 删除信息
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:39
	 * @since 1.0.0
	 */
	void delete(TeleGraphConfig teleGraphConfig);
	
	
	/**
	 * 配置信息，保存对象
	 * @param atncRountAddrs			天航信路由地址
	 * @param atncConfigTimes			天航信配置时间
	 * @param atncConfigPeoples			天航信配置人
	 * @param atncConnectionConditions  天航信终端连接情况
	 * @author WangLingbin
	 * @date  2015年5月29日上午9:45:40
	 * @since 1.0.0
	 */
	void config(TeleGraphQueryModel queryModel, List<String> identifiers,
			List<String> atncRountAddrs, List<String> atncConfigPeoples,
			List<String> atncConnectionConditions);

	List<TeleGraphConfig> getConfigsByTeleGraphId(String id);

}
