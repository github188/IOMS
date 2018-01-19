package cn.com.atnc.ioms.mng.duty.fax.day;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxHardwareDay;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;

/**
 * 转报系统硬件检查（自动）日检-Service接口
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:08:55
 */
public interface IFaxHardwareDayService {
	/**
	 * 分页查询
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 上午10:27:42
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPage(FaxSystemQueryModel queryModel);

	/**
	 * 查询单条
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 下午3:43:26
	 * @param id
	 * @return FaxHardwareDay
	 */
	public FaxHardwareDay findById(String id);

	/**
	 * 删除
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 下午3:43:45
	 * @param id
	 *            void
	 */
	public void delete(String id);

	/**
	 * 审核
	 * 
	 * @author 韩天驭
	 * @2017年2月16日 下午3:44:04
	 * @param model
	 * @return FaxHardwareDay
	 */
	public FaxHardwareDay judge(FaxSystemModel model,User user);

	/**
	 * 修改
	 * 
	 * @author 韩天驭
	 * @2017年2月17日 上午10:21:34
	 * @param pageModel
	 * @param user
	 * @return FaxHardwareDay
	 */
	public FaxHardwareDay mod(FaxSystemModel pageModel, User user);
}
