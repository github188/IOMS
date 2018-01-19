package cn.com.atnc.ioms.dao.systemmng.userlog;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.model.systemmng.userlog.UserLogQueryModel;

/**
 * userlog dao接口
 * @author lizhisheng
 * @date 2014-4-3 上午10:01:19
 */
public interface IUserLogDao extends IBaseDao<UserLog> {
	/**
	 * 分页多条件查询
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-3 上午10:31:19
	 * @param SUBMENU
	 * @param info
	 */
	public Pagination pagnQuery(UserLogQueryModel queryModel);
	public Long querySize(UserLogQueryModel model);
	
	public List<UserLog> queryList(UserLogQueryModel queryModel);
}
