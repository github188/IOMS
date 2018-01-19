package cn.com.atnc.ioms.mng.business.transfernet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;

/**
 * 自动转报网Service方法
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:04:16
 * @since 1.0.0
 */
public interface ITransferNetManager {

	/**
	 * 根据ID查找实体
	 *
	 * @param string
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日下午1:42:24
	 * @since 1.0.0
	 */
	public TransferNet findById(String id);

	/**
	 * 保存实体
	 *
	 * @param entity 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日下午1:42:53
	 * @since 1.0.0
	 */
	public void save(TransferNet transferNet);

	/**
	 * 页面查询
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午8:45:58
	 * @since 1.0.0
	 */
	public Pagination queryPage(TransferNetQueryModel queryModel);

	/**
	 * 查找实体返回List
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:47:08
	 * @since 1.0.0
	 */
	public List<TransferNet> queryList(TransferNetQueryModel queryModel);

	/**
	 * 更新申请信息
	 *
	 * @param transferNet 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:45:43
	 * @since 1.0.0
	 */
	void update(TransferNet transferNet);
	
	/**
	 * 通过TransferNet的ID得到弹出框实体Model
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:10
	 * @since 1.0.0
	 */
	public TransferNetQueryModel getCheckModel(String id);

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
	public TransferNet doCheck(HttpServletRequest request,String id, TransferNetQueryModel queryModel, User user);

	/**
	 * 修改操作方法体
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:31
	 * @since 1.0.0
	 */
	public TransferNetQueryModel setModel(TransferNetQueryModel queryModel);


	/**
	 * 得到查询实体，用于页面查看
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:44
	 * @since 1.0.0
	 */
	public TransferNetQueryModel getViewModel(ApplyBaseInfo applyBaseInfo);

	/**
	 * 通过ApplyBaseInfo查询实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午10:46:54
	 * @since 1.0.0
	 */
	public TransferNet findByApplyBaseInfo(String id);

	/**
	 * 获取报表填充参数
	 * @author WangLingbin
	 * @date  2015年11月10日下午5:36:33
	 * @since 1.0.0
	 */
	public Map<String, Object> getReportParams(HttpServletRequest request,String id, String reportName);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:47:39
	 * @since 1.0.0
	 */
	public List<TransferNet> getListSendMessage();
}
