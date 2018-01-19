package cn.com.atnc.ioms.mng.duty.fax.day;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemModel;

/**
 * 转报系统日检（系统进程检查、系统硬件检查）Service 接口
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:12:50
 */
public interface IFaxSystemService {

	/**
	 * 转报日检添加
	 * 
	 * @author 韩天驭
	 * @2017年2月14日 下午3:18:00
	 * @param user
	 * @param pageModel
	 * @return FaxSystemModel
	 */
	public FaxSystemModel save(User user, FaxSystemModel pageModel);
}
