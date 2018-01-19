package cn.com.atnc.ioms.dao.duty.fax.day;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;

/**
 * 转报系统进程检查（自动）日检-dao接口
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:04:58
 */
public interface IFaxProcessDayDao extends IBaseDao<FaxProcessDay> {

	/**
	 * 分页查询
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 上午9:56:04
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPage(FaxSystemQueryModel queryModel);
}
