package cn.com.atnc.ioms.mng.duty.environment.ups;

import java.util.List;

import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;

/**
 * 系统连接检查service
 * @author renyujuan
 * @date 2016年7月11日下午3:46:12
 */
/**
 * @author renyujuan
 * @date 2016年7月11日下午4:00:54
 */
public interface SystemConnMeasureService {
	
	/**
	 * 根据查询model查询记录
	 * @author renyujuan
	 * @date 2016年7月11日下午3:49:01
	 * @param queryModel
	 * @return
	 */
	List<SystemConnMeasure> queryByModel(MeasureQueryModel queryModel);
	
	/**
	 * 查询所有的记录
	 * @author renyujuan
	 * @date 2016年7月11日下午3:54:54
	 * @return
	 */
	List<SystemConnMeasure> getAll();
	
	
	/**
	 * 保存记录
	 * @author renyujuan
	 * @date 2016年7月11日下午4:01:05
	 * @param systemConnMeasure
	 * @return
	 */
	void save(SystemConnMeasure systemConnMeasure);
	
	/**
	 * 更新记录
	 * @author renyujuan
	 * @date 2016年7月11日下午4:03:48
	 * @param systemConnMeasure
	 * @return
	 */
	SystemConnMeasure update(SystemConnMeasure systemConnMeasure);
	
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年7月11日下午4:04:34
	 * @param systemConnMeasure
	 */
	void delete(SystemConnMeasure systemConnMeasure);
	
	/**
	 * 根据主键查找记录
	 * @author renyujuan
	 * @date 2016年7月11日下午4:05:42
	 * @param id
	 * @return
	 */
	SystemConnMeasure findById(String id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
