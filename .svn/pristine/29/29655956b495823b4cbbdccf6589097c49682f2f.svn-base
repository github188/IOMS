/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IApplyBaseInfoService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business
 * @author ku
 * @date 2015年5月14日下午5:24:38
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.baseinfo;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.model.business.taskrecord.TaskRecordQueryModel;

/**
 * 申请基础信息service接口
 *
 * @author ku
 * @date 2015年5月14日 下午5:24:38
 * @since 1.0.0
 */
public interface IApplyBaseInfoService {

	/**
	 * 根据查询Model查询申请记录分页对象
	 *
	 * @param queryModel
	 * @return  Pagination
	 * @author ku
	 * @date  2015年5月26日下午1:45:22
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TaskRecordQueryModel queryModel);

	/**
	 * 通过主键ID查询申请信息实体
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月26日下午2:33:58
	 * @since 1.0.0
	 */
	ApplyBaseInfo findById(String id);

	/**
	 * 根据查询Model查询申请记录分页对象
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015年7月15日下午1:41:41
	 * @since 1.0.0
	*/
	Pagination getPageByModel(TaskRecordQueryModel queryModel);

	/**
	 * 更新实体
	 * @param applyBaseInfo 
	 * @author WangLingbin
	 * @date  2015年10月20日下午2:36:15
	 * @since 1.0.0
	 */
	void update(ApplyBaseInfo applyBaseInfo);
	
	
	/**
	 * 获取所有记录
	 * @author WangLingbin
	 * @date  2015年11月16日下午1:40:13
	 * @since 1.0.0
	 */
	List<ApplyBaseInfo> getAll();

	/**
	 * 得到需要发短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午1:33:51
	 * @since 1.0.0
	 */
	List<ApplyBaseInfo> getListSendMessage();

}
