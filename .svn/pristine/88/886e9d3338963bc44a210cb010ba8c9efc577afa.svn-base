package cn.com.atnc.ioms.mng.duty.vgduty.impl;

import cn.com.atnc.ioms.mng.duty.vgduty.VGSystemService;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.vgduty.VGSystemDao;
import cn.com.atnc.ioms.entity.duty.vgduty.VGSystem;

/**
 * VG系统检查Service实现类
 * @author 
 * @date 
 * @since 
 */
@Transactional
@Service("vgSystemService")
public class VGSystemServiceImpl extends BaseService implements 
		VGSystemService {
	@Autowired
	private VGSystemDao vgSystemDao;
	
	@Override
	public Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel) {
		return vgSystemDao.queryPageByModel(queryModel);
	}

	@Override
	public List<VGSystem> getAll() {
		return vgSystemDao.getAll();
	}

	@Override
	public VGSystem save(VGSystem vgSystem) {
		vgSystemDao.save(vgSystem);
		return vgSystemDao.findById(vgSystem.getId());
	}

	@Override
	public VGSystem update(VGSystem vgSystem) {
		vgSystemDao.update(vgSystem);
		return vgSystemDao.findById(vgSystem.getId());
	}

	@Override
	public void delete(VGSystem vgSystem) {
		vgSystemDao.delete(vgSystem);
	}

	@Override
	public VGSystem findById(String id) {
		return vgSystemDao.findById(id);
	}
}
