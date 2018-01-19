package cn.com.atnc.ioms.mng.systemmng.userlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.systemmng.userlog.IUserLogDao;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.model.systemmng.userlog.UserLogQueryModel;

/**
 * UserLog管理业务逻辑实现
 * 
 * @author:lizhisheng
 * @date:2014-4-3上午10:28:31
 */
@Service("userLogManager")
public class UserLogManagerImpl extends AbstractService implements
		IUserLogManager {
	@Autowired
	private IUserLogDao userLogDao;

	@Override
	public Pagination queryPage(UserLogQueryModel qm) {
		// TODO Auto-generated method stub
		return userLogDao.pagnQuery(qm);
	}

	@Override
	public Long querySize(UserLogQueryModel model) {
		// TODO Auto-generated method stub
		return userLogDao.querySize(model);
	}

	@Override
	public List<UserLog> queryList(UserLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		return userLogDao.queryList(queryModel);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager#saveOrUpdate(cn.com.atnc.ioms.entity.systemmng.userlog.UserLog)
	 */
	@Override
	public void saveOrUpdate(UserLog log) {
		// TODO Auto-generated method stub
		userLogDao.saveOrUpdate(log);
	}

}
