package cn.com.atnc.ioms.dao.turndutymng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-26下午4:37:31
 * TODO
 */
public interface IShiftDutyRecordDao extends IBaseDao<ShiftDutyRecord>{
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26上午10:50:05
	 * @param queryModel
	 * @return Pagination
	 * TODO 分页
	 */
	public Pagination queryPage(TurnDutyQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:queryRecyclePage
	 * @Description:回收站查询
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年10月12日 下午5:07:03
	 */
	public Pagination queryRecyclePage(TurnDutyQueryModel queryModel);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-26下午4:37:42
	 * @param queryModel
	 * @return List<ShiftDutyRecord>
	 * TODO
	 */
	public List<ShiftDutyRecord> getRecordList(ShiftDutyQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getRecordBySignId
	 * @Description:通过签到离岗记录关联交接班日志
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<ShiftDutyRecord>
	 * @Creatime:2016年6月6日 下午1:41:47
	 */
	public List<ShiftDutyRecord> getRecordBySignId(ShiftDutyQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getRecordListBySign
	 * @Description:按照时间查看，上一个班次的交接班日志
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<ShiftDutyRecord>
	 * @Creatime:2016年10月17日 上午9:28:46
	 */
	public List<ShiftDutyRecord> getRecordListBySign(ShiftDutyQueryModel queryModel);
}
