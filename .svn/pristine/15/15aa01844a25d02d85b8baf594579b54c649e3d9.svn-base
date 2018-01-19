/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite
 * @author ku
 * @date 2015年5月13日下午4:03:05
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;


/**
 * 转报地址申请Service接口
 *
 * @author WangLingbin
 * @date 2015年6月18日 上午10:41:09
 * @since 1.0.0
 */
public interface TeleGraphApplyService {

	/**
	 * 通过查询条件model查询申请记录
	 *
	 * @param queryModel
	 * @author WangLingbin
	 * @date  2015年6月18日上午10:41:22
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);

	/**
	 * 获取所有申请记录
	 * @author WangLingbin
	 * @date  2015年10月20日下午5:19:45
	 * @since 1.0.0
	 */
	List<TeleGraphApply> getAll();
	
	/**
	 * 保存申请记录
	 *
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:06
	 * @since 1.0.0
	 */
	void save(TeleGraphApply teleGraphApply);

	/**
	 * 根据主键ID获取申请对象
	 * @param id	主键ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:14
	 * @since 1.0.0
	 */
	TeleGraphApply getTeleGraphApplyById(String id);

	/**
	 * 更新信息
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:29
	 * @since 1.0.0
	 */
	void update(TeleGraphApply teleGraphApply);

	/**
	 * 删除信息
	 * @param teleGraphApply 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:39
	 * @since 1.0.0
	 */
	void delete(TeleGraphApply teleGraphApply);

	/**
	 * 根据父类TeleGraph的id查找TeleGraphApply集合
	 * @param id	父类TeleGraph的id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年5月20日下午4:26:37
	 * @since 1.0.0
	 */
	List<TeleGraphApply> getApplysByParentId(String id);
	
	/**
	 * 工程师测试通过，补全转报申请信息
	 * @author WangLingbin
	 * @date  2015年5月29日下午4:31:11
	 * @since 1.0.0
	 */
	void engineerTest(TeleGraphQueryModel queryModel,
			List<String> allocatedAddrs, List<String> operPeoples,
			List<String> operTimes);
}
