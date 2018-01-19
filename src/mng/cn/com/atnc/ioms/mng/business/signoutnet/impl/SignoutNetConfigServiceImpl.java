/**
 * @ProjectName IOMS_CIRCUIT
 * @FileName KuSatelliteAttachServiceImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月29日下午2:16:56
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.signoutnet.impl;

import java.util.List;

import jodd.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.signoutnet.ISignoutNetConfigDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNetConfig;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetConfigService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetManager;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 退网配置实现类
 *
 * @author 段衍林
 * @2017年1月13日 下午4:06:36
 */
@Service
@Transactional
public class SignoutNetConfigServiceImpl extends BaseService implements
		ISignoutNetConfigService {

	@Autowired
	private ISignoutNetConfigDao signoutNetConfigDao;
	@Autowired
	private ISignoutNetManager signoutNetManager;

	@SuppressWarnings("unchecked")
	@Override
	public SignoutNetConfig findBySignoutNetId(String id) {
		List<SignoutNetConfig> signoutNetConfigs = (List<SignoutNetConfig>) signoutNetConfigDao
				.queryList("from SignoutNetConfig where signoutNet.id = ?", id);
		if (CollectionUtils.isNotEmpty(signoutNetConfigs)) {
			return signoutNetConfigs.get(0);
		} else {
			return null;
		}
	}

	@Override
	public SignoutNetConfig findById(String id) {
		return signoutNetConfigDao.findById(id);
	}

	@Override
	public void save(SignoutNetConfig signoutNetConfig) {
		signoutNetConfigDao.save(signoutNetConfig);
	}

	@Override
	public void update(SignoutNetConfig signoutNetConfig) {
		signoutNetConfigDao.update(signoutNetConfig);
	}

	@Override
	public void delete(SignoutNetConfig signoutNetConfig) {
		signoutNetConfigDao.delete(signoutNetConfig);
	}

	@Override
	public void configKU(SignoutNetQueryModel queryModel, User user,
			String node, String mediumFrequency, String emissionFrequency,
			String receiveFrequency) {
		// 查询实体
		SignoutNet signoutNet = (SignoutNet) signoutNetManager
				.findById(queryModel.getId());
		// 生成配置实体
		SignoutNetConfig signoutNetConfig = new SignoutNetConfig(signoutNet,
				node, mediumFrequency, emissionFrequency, receiveFrequency,
				user.getName(), DateUtilTools.getNowDateTime());
		// 保存
		this.save(signoutNetConfig);
	}

	@Override
	public void configATM(SignoutNetQueryModel queryModel, User user,
			String placeATM, String placeATMO, String connectivity,
			String nodemng, String confRemark) {
		// 操作验证
		if (StringUtil.isNotEmpty(confRemark)) {
			// 连通性处理
			boolean connectivityBool = false;
			if (connectivity.equals("1")) {
				connectivityBool = true;
			}
			// 节点是否正常管理处理
			boolean nodemngBool = false;
			if (nodemng.equals("1")) {
				nodemngBool = true;
			}
			// 查询实体
			SignoutNet signoutNet = (SignoutNet) signoutNetManager
					.findById(queryModel.getId());
			// 生成配置实体
			SignoutNetConfig signoutNetConfig = new SignoutNetConfig(
					signoutNet, placeATM, placeATMO, connectivityBool,
					nodemngBool, confRemark, user.getName(),
					DateUtilTools.getNowDateTime());
			// 保存配置记录
			this.save(signoutNetConfig);
		}
	}
}
