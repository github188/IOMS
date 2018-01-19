package cn.com.atnc.ioms.mng.duty.statellite.day.tes;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.AuditDataModel;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;

/**
 * 卫星巡检基础service
 *
 * @author 段衍林
 * @2017年2月16日 下午1:13:32
 */
public interface IDayTesCheckService {

	/**
	 * 实体保存
	 * 
	 * @author 段衍林
	 * @2017年2月16日 下午1:25:19
	 * @param tesBaseDataModel
	 *            基础数据model
	 * @param operator
	 *            操作人 void
	 */
	void save(TesBaseDataModel tesBaseDataModel, User operator);

	/**
	 * 审核
	 * 
	 * @author 段衍林
	 * @2017年2月17日 上午8:57:33
	 * @param auditDataModel
	 *            审核model
	 * @param operator
	 *            操作人 void
	 */
	void audit(AuditDataModel auditDataModel, User operator);
}
