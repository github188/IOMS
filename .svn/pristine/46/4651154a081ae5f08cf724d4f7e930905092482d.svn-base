/**
 * @ProjectName IOMS
 * @FileName TeleGraphSystemServiceImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.duty.telegraphduty.impl
 * @author WangLingbin
 * @date 2016年1月8日上午11:04:40
 * @since 1.0.0
 * @Copyright (c) 2016,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.duty.telegraphduty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.telegraphduty.TeleGraphSystemDao;
import cn.com.atnc.ioms.entity.duty.telegraphduty.TeleGraphSystem;
import cn.com.atnc.ioms.mng.duty.telegraphduty.TeleGraphSystemService;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;

/**
 * 转报系统检查Service实现类
 * @author WangLingbin
 * @date 2016年1月8日 上午11:04:40
 * @since 1.0.0
 */
@Transactional
@Service("teleGraphSystemService")
public class TeleGraphSystemServiceImpl extends BaseService implements
		TeleGraphSystemService {

	@Autowired
	private TeleGraphSystemDao teleGraphSystemDao;
	
	@Override
	public Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel) {
		return teleGraphSystemDao.queryPageByModel(queryModel);
	}

	@Override
	public List<TeleGraphSystem> getAll() {
		return teleGraphSystemDao.getAll();
	}

	@Override
	public TeleGraphSystem save(TeleGraphSystem teleGraphSystem) {
		teleGraphSystemDao.save(teleGraphSystem);
		return teleGraphSystemDao.findById(teleGraphSystem.getId());
	}

	@Override
	public TeleGraphSystem update(TeleGraphSystem teleGraphSystem) {
		teleGraphSystemDao.update(teleGraphSystem);
		return teleGraphSystemDao.findById(teleGraphSystem.getId());
	}

	@Override
	public void delete(TeleGraphSystem teleGraphSystem) {
		teleGraphSystemDao.delete(teleGraphSystem);
	}

	@Override
	public TeleGraphSystem findById(String id) {
		return teleGraphSystemDao.findById(id);
	}

}
