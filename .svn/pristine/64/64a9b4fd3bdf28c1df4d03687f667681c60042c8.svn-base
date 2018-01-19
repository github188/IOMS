/**
 * @ProjectName IOMS_CIRCUIT
 * @FileName IKuSatelliteAttachService.java
 * @PackageName:cn.com.atnc.ioms.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月29日下午2:14:50
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.signoutnet;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNetConfig;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;

/**
 * 退网配置申请service
 *
 * @author 段衍林
 * @2017年1月13日 下午4:03:18
 */
public interface ISignoutNetConfigService {

	/**
	 * 根据父类ID查找实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:05:00
	 * @param id
	 * @return SignoutNetConfig
	 */
	SignoutNetConfig findBySignoutNetId(String id);

	/**
	 * 根据ID查找实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:04:55
	 * @param id
	 * @return SignoutNetConfig
	 */
	SignoutNetConfig findById(String id);

	/**
	 * 保存实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:04:43
	 * @param signoutNetConfig
	 *            void
	 */
	void save(SignoutNetConfig signoutNetConfig);

	/**
	 * 更新实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:04:38
	 * @param signoutNetConfig
	 *            void
	 */
	void update(SignoutNetConfig signoutNetConfig);

	/**
	 * 删除实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:04:33
	 * @param signoutNetConfig
	 *            void
	 */
	void delete(SignoutNetConfig signoutNetConfig);

	/**
	 * 保存配置实体--ku
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午4:04:29
	 * @param queryModel
	 *            退网model
	 * @param user
	 *            当前登录用户
	 * @param node
	 *            节点
	 * @param mediumFrequency
	 *            0号载波中频频点
	 * @param emissionFrequency
	 *            射频发射频率
	 * @param receiveFrequency
	 *            射频接收频率 void
	 */
	void configKU(SignoutNetQueryModel queryModel, User user, String node,
			String mediumFrequency, String emissionFrequency,
			String receiveFrequency);

	/**
	 * 配置ATM信息
	 * 
	 * @author 段衍林
	 * @2017年1月22日 上午9:49:51
	 * @param queryModel
	 *            查询model
	 * @param user
	 *            当前用户
	 * @param placeATM
	 *            ATM地址/广域网地址
	 * @param placeATMO
	 *            ATM0地址/Loopback地址
	 * @param connectivity
	 *            中继连通性
	 * @param nodemng
	 *            节点是否正常管理
	 * @param confRemark
	 *            备注 void
	 */
	void configATM(SignoutNetQueryModel queryModel, User user, String placeATM,
			String placeATMO, String connectivity, String nodemng,
			String confRemark);

}
