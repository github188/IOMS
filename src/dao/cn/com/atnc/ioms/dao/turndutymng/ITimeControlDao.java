package cn.com.atnc.ioms.dao.turndutymng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.turndutymng.TimeControl;

public interface ITimeControlDao extends IBaseDao<TimeControl>{
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getTimeControl
	 * @Description:获取时间信息
	 * @Param:@return
	 * @Return:List<TimeControl>
	 * @Creatime:2016年10月12日 下午1:32:43
	 */
	public List<TimeControl> getTimeControl();
}
