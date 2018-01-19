package cn.com.atnc.ioms.dao.business.formalcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;

 /**
 * 正式电路申请表基础信息Dao接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:38:56
 * @since 1.0.0
 */
public interface IFormalCircuitDao extends IBaseDao<FormalCircuit> {

	public Pagination queryPage(FormalCircuitQueryModel queryModel);

	public List<FormalCircuit> queryList(FormalCircuitQueryModel queryModel);

	public List<FormalCircuit> findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:09:45
	 * @since 1.0.0
	 */
	public List<FormalCircuit> getListSendMessage();

}
