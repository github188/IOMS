package cn.com.atnc.ioms.mng.turndutymng;

import java.util.List;

import cn.com.atnc.ioms.entity.turndutymng.TimeControl;

public interface ITimeControlService {
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getTimeControl
	 * @Description:当前激活状态的 时间控制信息
	 * @Param:@return
	 * @Return:List<String>
	 * @Creatime:2016年10月12日 下午2:32:10
	 */
	public List<String> getTimeControl();
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:save
	 * @Description:更新
	 * @Param:@param timeControl
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年10月12日 下午2:33:00
	 */
	public String mod(TimeControl timeControl);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getView
	 * @Description:获取当前值
	 * @Param:@return
	 * @Return:TimeControl
	 * @Creatime:2016年10月13日 下午2:48:59
	 */
	public TimeControl getView();
}
