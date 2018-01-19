package cn.com.atnc.ioms.mng.turndutymng;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-26下午3:41:22
 * TODO
 */
public interface IShiftDutyRecordService {
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26上午11:01:30
	 * @param queryModel
	 * @return Pagination
	 * TODO
	 */
	public Pagination queryPage(TurnDutyQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:queryRecyclePage
	 * @Description:查看回收站
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年10月12日 下午5:08:03
	 */
	public Pagination queryRecyclePage(TurnDutyQueryModel queryModel);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26上午11:09:59
	 * @param shiftDuty
	 * @return String
	 * TODO 添加交接班日志
	 */
	public String save(ShiftDutyRecord shiftDuty);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26下午4:38:09
	 * @param queryModel
	 * @return List<ShiftDutyRecord>
	 * TODO
	 */
	public List<ShiftDutyRecord> getRecordList(ShiftDutyQueryModel queryModel,User name);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-30上午9:08:40
	 * @param id
	 * @return ShiftDutyRecord
	 * TODO
	 */
	public ShiftDutyRecord findViewById(String id);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-30上午9:14:30
	 * @param shiftDuty void
	 * TODO 修改
	 */
	public ShiftDutyRecord Update(ShiftDutyRecord shiftDuty);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-30上午11:26:02
	 * @param shiftDuty void
	 * TODO
	 */
	public void Del(ShiftDutyRecord shiftDuty);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getDutyPlaceByUser
	 * @Description:当登录用户当前的角色为值班经理时，获取值班地点
	 * @Param:@param user
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月1日 下午2:25:13
	 */
	public String getDutyPlaceByUser(User user);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getRecordBySignId
	 * @Description:根据签到离岗记录获取交接班日志
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<ShiftDutyRecord>
	 * @Creatime:2016年6月6日 下午1:43:14
	 */
	public List<ShiftDutyRecord> getRecordBySignId(ShiftDutyQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getRecordListBySign
	 * @Description:签到时查看上一班次的 交接本日志
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<ShiftDutyRecord>
	 * @Creatime:2016年10月17日 上午9:54:20
	 */
	public List<ShiftDutyRecord> getRecordListBySign(ShiftDutyQueryModel queryModel);
}
