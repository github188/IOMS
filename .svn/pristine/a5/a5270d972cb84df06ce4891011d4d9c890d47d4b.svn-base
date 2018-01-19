package cn.com.atnc.ioms.mng.business.datacomnetwork;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetwork;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;

/**
 * 数据通信网Service方法
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:04:16
 * @since 1.0.0
 */
public interface IDataComNetworkManager {

	/**
	 * 页面查询
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午8:45:58
	 * @since 1.0.0
	 */
	public Pagination queryPage(DataComNetworkQueryModel queryModel);

	/**
	 * 查找实体返回List
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:47:08
	 * @since 1.0.0
	 */
	public List<DataComNetwork> queryList(DataComNetworkQueryModel queryModel);

	/**
	 * 保存申请记录
	 *
	 * @param dataComNetwork 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:45:30
	 * @since 1.0.0
	 */
	void save(DataComNetwork dataComNetwork);

	/**
	 * 更新申请信息
	 *
	 * @param dataComNetwork 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:45:43
	 * @since 1.0.0
	 */
	void update(DataComNetwork dataComNetwork);
	
	/**
	 * 通过ID查询实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:45:56
	 * @since 1.0.0
	 */
	public DataComNetwork findById(String id);

	/**
	 * 通过DataComNetwork的ID得到弹出框实体Model
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:10
	 * @since 1.0.0
	 */
	public DataComNetworkQueryModel getCheckModel(String id);

	/**
	 * 审核，评价方法
	 *
	 * @param id
	 * @param queryModel
	 * @param user
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:20
	 * @since 1.0.0
	 */
	public DataComNetwork doCheck(HttpServletRequest request,String id, DataComNetworkQueryModel queryModel, User user);

	/**
	 * 修改操作方法体
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:31
	 * @since 1.0.0
	 */
	public DataComNetworkQueryModel setModel(DataComNetworkQueryModel queryModel);


	/**
	 * 得到查询实体，用于页面查看
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:44
	 * @since 1.0.0
	 */
	public DataComNetworkQueryModel getViewModel(ApplyBaseInfo applyBaseInfo);

	/**
	 * 通过ApplyBaseInfo查询实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:54
	 * @since 1.0.0
	 */
	public DataComNetwork findByApplyBaseInfo(String id);

	/**
	 * 更新配置信息
	 *
	 * @param placeATM
	 * @param placeATMO
	 * @param connectivity
	 * @param nodemng
	 * @param confRemark
	 * @return 
	 * @author Wang Zhicheng
	 * @param queryModel 
	 * @date  2015年10月26日下午2:00:14
	 * @since 1.0.0
	 */
	public void getDCNConfig(String id, String placeATM, String placeATMO,
			String connectivity, String nodemng, String confRemark);
	
	/**
	 * 获取报表填充参数
	 * @author WangLingbin
	 * @date  2015年11月10日下午5:30:22
	 * @since 1.0.0
	 */
	public Map<String, Object> getReportParams(HttpServletRequest request,String id, String reportName);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午1:47:09
	 * @since 1.0.0
	 */
	public List<DataComNetwork> getListSendMessage();
}
