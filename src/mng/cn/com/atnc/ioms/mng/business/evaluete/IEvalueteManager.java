package cn.com.atnc.ioms.mng.business.evaluete;

import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;

 /**
 * 用户评价Service接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:52:08
 * @since 1.0.0
 */
public interface IEvalueteManager {

	/**
	 * 保存
	 *
	 * @param applyEvaluate 
	 * @date  2015年5月22日下午2:26:06
	 * @since 1.0.0
	*/
	public void save(ApplyEvaluate applyEvaluate);

	/**
	 * 根据ApplyBaseInfo查询ApplyEvaluate实体
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @date  2015年5月22日下午2:26:15
	 * @since 1.0.0
	*/
	public ApplyEvaluate findByABI(ApplyBaseInfo applyBaseInfo);

	/**
	 * 根据基础申请信息ID查询评价信息实体
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月26日下午3:57:42
	 * @since 1.0.0
	 */
	public Object findByApplyBaseInfoId(String id);

}
