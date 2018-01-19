package cn.com.atnc.ioms.mng.duty.fax.day;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;

/**
 * 转报系统进程检查（自动）日检-Service接口
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:09:16
 */
public interface IFaxProcessDayService {
	/**
	 * 分页查询
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 上午10:27:15
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPage(FaxSystemQueryModel queryModel);

	/**
	 * 查看
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午11:41:15
	 * @param id
	 * @return FaxProcessDay
	 */
	public FaxProcessDay findById(String id);

	/**
	 * 删除
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午11:41:24
	 * @param id
	 *            void
	 */
	public void delete(String id);

	/**
	 * 审核
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午11:41:33
	 * @param model
	 * @param user
	 * @return FaxProcessDay
	 */
	public FaxProcessDay judge(FaxSystemModel model, User user);

	/**
	 * 修改
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 下午12:55:19
	 * @param pageModel
	 * @param user
	 * @return FaxProcessDay
	 */
	public FaxProcessDay mod(FaxSystemModel pageModel, User user);
}
