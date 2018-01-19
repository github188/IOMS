package cn.com.atnc.ioms.mng.systemmng.userlog;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.model.systemmng.userlog.UserLogQueryModel;

/**
 * @author lizhisheng
 * @date 2014-4-4 上午10:16:39
 */
public interface IUserLogManager {
	/**
	 * 分页查询
	 * 
	 * @author lizhisheng
     * @date 2014-4-4 上午10:16:39
	 * 
	 * @param qm
	 *            查询条件
	 * @return Pagination
	 */
	public Pagination queryPage(UserLogQueryModel qm);
	public Long querySize(UserLogQueryModel model);
	
	public List<UserLog> queryList(UserLogQueryModel queryModel);
	
	
	public void saveOrUpdate(UserLog log);
}
