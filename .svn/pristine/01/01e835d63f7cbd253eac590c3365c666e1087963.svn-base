package cn.com.atnc.ioms.dao.business.approveinfo;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;

/**
 * 公共审批信息DAO接口
 *
 * @author ku
 * @date 2015年5月15日 下午4:33:06
 * @since 1.0.0
 */
public interface IApproveInfoDao extends IBaseDao<ApproveInfo> {

	/**
	 * 根据申请信息抽象实体ID查找审批信息集合
	 *
	 * @param id 申请信息抽象实体ID
	 * @return List<ApproveInfo> 审批信息集合
	 * @author ku
	 * @date  2015年5月25日下午2:54:16
	 * @since 1.0.0
	 */
	List<ApproveInfo> getApproveInfoByBaseInfoId(String id);

	
	/**
	 * 根据用户查找审批信息集合
	 * @param id 申请信息抽象实体ID
	 * @param userId	用户Id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年7月23日下午4:30:06
	 * @since 1.0.0
	 */
	List<ApproveInfo> getApproveInfoByUser(String id, String userId);
	
	/**
	 * 获取已退回的审批个数
	 * @param id	申请信息抽象实体ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月10日下午2:37:40
	 * @since 1.0.0
	 */
	int getReturnedApplyNumber(String id);
}
