package cn.com.atnc.ioms.mng.business.approveinfo;

import java.util.List;

import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;

/**
 * 公共审批信息service接口
 *
 * @author ku
 * @date 2015年5月15日 下午4:29:18
 * @since 1.0.0
 */
public interface IApproveInfoService{

	/**
	 * 保存审批信息实体
	 *
	 * @param approveInfo 
	 * @author ku
	 * @date  2015年5月18日上午9:23:43
	 * @since 1.0.0
	 */
	void save(ApproveInfo approveInfo);

	/**
	 * 通过基础申请信息ID获取审批记录集合
	 *
	 * @param id 基础申请信息ID
	 * @return List<ApproveInfo> 审批记录集合
	 * @author ku
	 * @date  2015年5月25日下午2:52:49
	 * @since 1.0.0
	 */
	List<ApproveInfo> getApproveInfoByBaseInfoId(String id);
	
	/**
	 * 获取已退回的审批个数
	 * @param id	申请信息抽象实体ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月10日下午2:37:40
	 * @since 1.0.0
	 */
	int getReturnedApplyNumber(String id);
	
	
	/**
	 * 根据主键ID查找实体
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月10日下午3:21:03
	 * @since 1.0.0
	 */
	ApproveInfo findById(String id);
}
