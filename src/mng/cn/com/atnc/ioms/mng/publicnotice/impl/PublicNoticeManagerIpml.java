package cn.com.atnc.ioms.mng.publicnotice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.publicnotice.IPublicNoticeDao;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;
import cn.com.atnc.ioms.mng.publicnotice.IPublicNoticeManager;
import cn.com.atnc.ioms.model.publicnotice.PublicNoticeQueryModel;
@Service("PublicNoticeManager")
public class PublicNoticeManagerIpml extends AbstractService implements IPublicNoticeManager {

	@Autowired
	private IPublicNoticeDao publicNoticeDao;
	@Override
	@Transactional
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		PnNotice pnNotice = findById(id);
		publicNoticeDao.delete(pnNotice);
		return pnNotice.getTitle();
	}

	@Override
	@Transactional
	public PnNotice add(PnNotice node) throws ServiceException {
		// TODO Auto-generated method stub
		publicNoticeDao.save(node);
		return node;
	}

	@Override
	@Transactional
	public PnNotice update(PnNotice node) throws ServiceException {
		// TODO Auto-generated method stub
		publicNoticeDao.saveOrUpdate(node);
		return node;
	}

	@Override
	public Pagination queryPage(PublicNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		return publicNoticeDao.queryPage(queryModel);
	}

	@Override
	public List<PnNotice> queryList(PublicNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		return publicNoticeDao.queryList(queryModel);
	}

	@Override
	public PnNotice findById(String id) {
		// TODO Auto-generated method stub
		PnNotice pnNotice = publicNoticeDao.findById(id);
		
		return pnNotice;
	}

	@Override
	public void canclePnnoticeByID(String id) {
		// TODO Auto-generated method stub
		PnNotice pnNotice = publicNoticeDao.findById(id);
		pnNotice.setStatus(PnNoticeStatusEnum.DELETED);
		publicNoticeDao.saveOrUpdate(pnNotice);
	}

}
