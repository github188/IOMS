package cn.com.atnc.ioms.dao.business.evaluate;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;

 /**
 * 用户评价Dao接口
 *
 * @author Wang zhicheng
 * @date 2015年5月22日 上午9:44:52
 * @since 1.0.0
 */
public interface IApplyEvaluateDao extends IBaseDao<ApplyEvaluate> {

	public List<ApplyEvaluate> queryList(ApplyBaseInfo applyBaseInfo);

	/**
	 * 根据申请信息抽象表ID物理删除相应的评价信息
	 *
	 * @param id 申请信息抽象表ID 
	 * @author ku
	 * @date  2015年5月25日上午10:19:27
	 * @since 1.0.0
	 */
	public void physicalDelByApplyBaseInfoId(String id);

}
