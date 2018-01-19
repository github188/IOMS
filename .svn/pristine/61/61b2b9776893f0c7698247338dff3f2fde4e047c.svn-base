package cn.com.atnc.ioms.dao.business.transfernet;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNet;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;
/**
 * 数据通信网DAO接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午1:50:35
 * @since 1.0.0
 */
public interface ITransferNetDao extends IBaseDao<TransferNet> {

	/**
	 * 页面查询
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月19日下午3:05:57
	 * @since 1.0.0
	 */
	public Pagination queryPage(TransferNetQueryModel queryModel);

	/**
	 * 此处添加queryList方法的描述信息
	 *
	 * @param queryModel
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日下午1:52:35
	 * @since 1.0.0
	 */
	public List<TransferNet> queryList(TransferNetQueryModel queryModel);

	/**
	 * 此处添加findByApplyBaseInfo方法的描述信息
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日下午1:54:05
	 * @since 1.0.0
	 */
	public List<TransferNet> findByApplyBaseInfo(ApplyBaseInfo applyBaseInfo);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:48:33
	 * @since 1.0.0
	 */
	public List<TransferNet> getListSendMessage();

}
