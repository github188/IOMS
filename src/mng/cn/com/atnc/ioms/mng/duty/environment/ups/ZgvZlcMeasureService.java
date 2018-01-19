package cn.com.atnc.ioms.mng.duty.environment.ups;

import java.util.List;

import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;

/**
 * 零地电压和零线电流测量service
 * @author renyujuan
 * @date 2016年7月12日上午9:10:20
 */
public interface ZgvZlcMeasureService {
	
	/**
	 * 根据查询Model查找记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:16:36
	 * @param queryModel
	 * @return
	 */
	List<ZgvZlcMeasure> queryByModel(MeasureQueryModel queryModel);
	
	/**
	 * 保存记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:16:25
	 * @return
	 */
	List<ZgvZlcMeasure> getAll();
	
	/**
	 * 保存记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:16:11
	 * @param zgvZlcMeasure
	 * @return
	 */
	void save(ZgvZlcMeasure zgvZlcMeasure);
	
	/**
	 * 更新记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:16:02
	 * @param zgvZlcMeasure
	 * @return
	 */
	ZgvZlcMeasure update(ZgvZlcMeasure zgvZlcMeasure);
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:15:48
	 * @param zgvZlcMeasure
	 */
	void delete(ZgvZlcMeasure zgvZlcMeasure);
	
	/**
	 * 根据主键查找记录
	 * @author renyujuan
	 * @date 2016年7月12日上午9:15:22
	 * @param id
	 * @return
	 */
	ZgvZlcMeasure findById(String id);
}
