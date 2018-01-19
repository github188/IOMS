package cn.com.atnc.ioms.dao.business.datacomnetwork;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;

/**
 * 数据通信网DAO接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午1:50:35
 * @since 1.0.0
 */
public interface IDataComNetworkDao extends IBaseDao<DataComNetwork> {

	/**
	 * 页面查询
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月19日下午3:05:57
	 * @since 1.0.0
	 */
	public Pagination queryPage(DataComNetworkQueryModel queryModel);
	
	/**
	 * 列表查询
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:54:40
	 * @since 1.0.0
	 */
	public List<DataComNetwork> queryList(DataComNetworkQueryModel queryModel);

	/**
	 * 根据ApplyBaseInfo查询实体
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:54:44
	 * @since 1.0.0
	 */
	public List<DataComNetwork> findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午1:48:10
	 * @since 1.0.0
	 */
	public List<DataComNetwork> getListSendMessage();

}
