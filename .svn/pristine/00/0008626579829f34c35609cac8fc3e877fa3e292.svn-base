package cn.com.atnc.ioms.dao.business.baseinfo;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;

/**
 * 各种申请的基础信息Dao接口
 *
 * @author ku
 * @date 2015年5月14日 下午5:31:50
 * @since 1.0.0
 */
public interface IApplyBaseInfoDao extends IBaseDao<ApplyBaseInfo> {

	/**
	 * 根据查询条件model查询申请信息分页对象
	 *
	 * @param queryModel
	 * @return 
	 * @author ku
	 * @date  2015年5月26日下午1:49:37
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TaskRecordQueryModel queryModel);

	/**
	 * 查找需要发送短信的数据返回List
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午1:35:07
	 * @since 1.0.0
	 */
	List<ApplyBaseInfo> getListSendMessage();

}
