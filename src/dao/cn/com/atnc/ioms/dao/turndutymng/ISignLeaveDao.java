package cn.com.atnc.ioms.dao.turndutymng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

public interface ISignLeaveDao extends IBaseDao<SignLeaveRecord> {
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-19下午2:01:22
	 * @param signLeaveQueryModel
	 * @return Pagination TODO
	 */
	public Pagination queryPage(TurnDutyQueryModel queryModel);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-24上午10:22:01
	 * @param signLeaveQueryModel
	 * @return List<SignLeaveRecord> TODO 根据值班状态获取当前内容
	 */
	public List<SignLeaveRecord> getDutyStatus(
			SignLeaveQueryModel signLeaveQueryModel);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-24下午5:19:50
	 * @param signLeaveQueryModel
	 * @return SignLeaveRecord TODO 判断登录人的值班状态
	 */
	public List<SignLeaveRecord> getOnDutyStatusByUser(
			SignLeaveQueryModel signLeaveQueryModel);

	public List<SignLeaveRecord> getSignRecordListByDate(
			SignLeaveQueryModel signLeaveQueryModel);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26下午2:29:17
	 * @param signLeaveQueryModel
	 * @return List<SignLeaveRecord> TODO 根据用户名获取
	 */
	public List<SignLeaveRecord> getViewByUser(
			SignLeaveQueryModel signLeaveQueryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getOnDutyCountByPlace
	 * @Description:根据值班地点获取值班记录
	 * @Param:@param signLeaveQueryModel
	 * @Param:@return
	 * @Return:List<SignLeaveRecord>
	 * @Creatime:2016年6月2日 下午2:14:51
	 */
	public List<SignLeaveRecord> getOnDutyCountByPlace(
			SignLeaveQueryModel signLeaveQueryModel);

	/**
	 * 
	 * @throws ServiceException
	 * @Author:hantianyu
	 * @Title:getUserListByIds
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@param ids
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年6月3日 上午11:23:32
	 */
	public Pagination getUserListByIds(TurnDutyQueryModel queryModel)
			throws ServiceException;

	/**
	 * 
	 * @throws ServiceException
	 * @Author:hantianyu
	 * @Title:sumTotalTimes
	 * @Description:根据用户id/角色查询时间
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<SignLeaveRecord>
	 * @Creatime:2016年6月3日 下午12:54:00
	 */
	public List<SignLeaveRecord> sumTotalTimes(SignLeaveQueryModel qm)
			throws ServiceException;

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getEngineerListByPlace
	 * @Description:根据值班地点获取当前在岗（非值班经理）值班工程列表
	 * @Param qm 签到离岗记录model
	 * @Return List 返回用户列表
	 * @Creatime 2016年6月22日 下午2:31:18
	 */
	public List<User> getEngineerListByPlace(SignLeaveQueryModel qm);

	/**
	 * 根据值班地点获取当前在岗值班工程师列表
	 * 
	 * @author 段衍林
	 * @2017年2月9日 下午2:59:28
	 * @param qm
	 *            查询model
	 * @return List<User> 用户列表
	 */
	public List<User> getEngineerListByPlaceDuty(SignLeaveQueryModel qm);

}
