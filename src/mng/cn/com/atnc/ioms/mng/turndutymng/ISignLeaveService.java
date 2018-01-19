package cn.com.atnc.ioms.mng.turndutymng;

import java.util.Date;
import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-26下午3:41:31 TODO
 */
public interface ISignLeaveService {
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-19下午2:11:20
	 * @param signLeaveQueryModel
	 * @return Pagination TODO
	 * @throws ServiceException
	 */
	public Pagination queryPage(TurnDutyQueryModel queryModel)
			throws ServiceException;

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-19下午2:11:29
	 * @param signLeave
	 * @return String TODO 记录签到信息
	 */
	public String save(SignLeaveRecord signLeave);

	public SignLeaveRecord findById(String id);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-24下午6:14:19
	 * @param user
	 * @return boolean TODO 判断是否在岗
	 */
	public boolean isOndutyByUser(User user);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-24下午6:15:48
	 * @param user
	 * @return boolean TODO 判断是否已激活坐席
	 */
	public boolean isActiveByUser(User user);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-25下午1:41:12
	 * @param today
	 * @return List<SignLeaveRecord> TODO 当天以及前一天的签到离岗记录
	 */
	public List<SignLeaveRecord> getSignRecordListByDate(Date today, User name);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-25下午3:54:22
	 * @param now
	 * @return Date TODO 获取前一天的日期
	 */
	public Date getNextDay(Date now);

	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26下午2:34:56
	 * @param user
	 * @return SignLeaveRecord TODO 根据当前登录用户查询信息
	 */
	public SignLeaveRecord findViewByUser(User user);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:isMangerByUser
	 * @Description:判断当前用户是否是值班经理
	 * @Param:@param user
	 * @Param:@return
	 * @Return:boolean
	 * @Creatime:2016年5月30日 下午2:37:11
	 */
	public boolean isMangerByUser(User user);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getDutyPlaceByUser
	 * @Description:获取当前用户（在岗）的值班地点，没有在岗返回“”
	 * @Param:@param user
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月2日 上午9:24:02
	 */
	public String getDutyPlaceByUser(User user);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:dutyLeave
	 * @Description:离岗
	 * @Param:@param sign
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月7日 上午9:52:03
	 */
	public String dutyLeave(SignLeaveRecord sign);

	/**
	 * 
	 * @throws ServiceException
	 * @Author:hantianyu
	 * @Title:getCountTimes
	 * @Description:值班时长统计
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年6月3日 下午3:27:56
	 */
	public Pagination getCountTimes(TurnDutyQueryModel qm)
			throws ServiceException;

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getEngineerListByPlace
	 * @Description:根据值班地点获取在岗值班工程师列表
	 * @Param:@param SignLeaveQueryModel qm qm.setDutyPlace()
	 * @Param:@return
	 * @Return:List<SignLeaveRecord>
	 * @Creatime:2016年6月22日 下午2:35:47
	 */
	public List<User> getEngineerListByPlace(SignLeaveQueryModel qm);

	/**
	 * 根据值班地点获取在岗值班工程师列表
	 * 
	 * @author 段衍林
	 * @2017年2月9日 下午2:58:33
	 * @param qm
	 *            查询model
	 * @return List<User> 用户列表
	 */
	public List<User> getEngineerListByPlaceDuty(SignLeaveQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getViewByUser
	 * @Description:查询统计页显示个人信息
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:SignLeaveRecord
	 * @Creatime:2016年8月31日 下午3:26:52
	 */
	public SignLeaveRecord getViewByUser(SignLeaveQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:dutyMngLeave
	 * @Description:代离岗
	 * @Param:@param sign
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年9月27日 上午10:48:48
	 */
	public String dutyMngLeave(SignLeaveRecord sign);

}
