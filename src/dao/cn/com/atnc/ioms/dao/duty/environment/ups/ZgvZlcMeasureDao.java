package cn.com.atnc.ioms.dao.duty.environment.ups;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 零地电压和零线电流测量Dao
 * @author renyujuan
 * @date 2016年7月11日下午12:49:18
 */
public interface ZgvZlcMeasureDao extends IBaseDao<ZgvZlcMeasure> {
	/**
	 * 根据queryModel查询ZgvZlcMeasure
	 * @author renyujuan
	 * @date 2016年7月11日下午12:54:10
	 * @param queryModel
	 * @return
	 */
	List<ZgvZlcMeasure> queryByModel(MeasureQueryModel queryModel);
}
