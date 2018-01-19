package cn.com.atnc.ioms.mng.duty.environment.ups;

import java.util.List;

import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;

/**
 * 电池测量service
 * @author renyujuan
 * @date 2016年7月11日下午2:35:44
 */
public interface BatteryMeasureService {
	
	/**
	 * 根据查询model查询记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:42:52
	 * @param queryModel
	 * @return
	 */
	List<BatteryMeasure> queryByModel(MeasureQueryModel queryModel);
	
	/**
	 * 获取所有的记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:51:20
	 * @return
	 */
	
	List<BatteryMeasure> getAll();
	
	/**
	 * 保存记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:44:43
	 * @param batteryMeasure
	 * @return
	 */
	void save(BatteryMeasure batteryMeasure);
	
	/**
	 * 更新记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:52:28
	 * @param batteryMeasure
	 * @return
	 */
	BatteryMeasure update(BatteryMeasure batteryMeasure);
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:53:15
	 * @param batteryMeasure
	 */
	void delete(BatteryMeasure batteryMeasure);
	
	/**
	 * 根据主键获取记录
	 * @author duanyanlin
	 * @date 2016年7月11日下午2:54:03
	 * @param id
	 * @return
	 */
	BatteryMeasure findById(String id);
}
