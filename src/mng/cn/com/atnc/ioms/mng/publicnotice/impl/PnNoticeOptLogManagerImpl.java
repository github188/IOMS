package cn.com.atnc.ioms.mng.publicnotice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.publicnotice.IPnNoticeOptLogDao;
import cn.com.atnc.ioms.entity.publicnotice.PnNoticeOptLog;
import cn.com.atnc.ioms.mng.publicnotice.IPnNoticeOptLogManager;
import cn.com.atnc.ioms.model.publicnotice.PnNoticeOptLogQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-5-5 下午7:49:36
 * @version:1.0
 */
@Service("PnNoticeOptLogManager")
public class PnNoticeOptLogManagerImpl extends AbstractService implements IPnNoticeOptLogManager {

	@Autowired
	private IPnNoticeOptLogDao pnNoticeOptLogDao ;
	@Override
	public Pagination queryPageByParam(PnNoticeOptLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PnNoticeOptLog> queryListByParam(
			PnNoticeOptLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PnNoticeOptLog> findByPnNoticeOptLogId(String id) {
		// TODO Auto-generated method stub
		return pnNoticeOptLogDao.findByPnNoticeOptLogId(id);
	}

	@Override
	public void add(PnNoticeOptLog node) throws ServiceException {
		pnNoticeOptLogDao.save(node);
	}

	@Override
	public PnNoticeOptLog findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PnNoticeOptLog node) throws ServiceException {
		// TODO Auto-generated method stub
	}

	@Override
	public PnNoticeOptLog findLatestByPnNoticeOptLogID(String id) {
		// TODO Auto-generated method stub
		return pnNoticeOptLogDao.findLatestByPnNoticeOptLogID(id);
	}

}
