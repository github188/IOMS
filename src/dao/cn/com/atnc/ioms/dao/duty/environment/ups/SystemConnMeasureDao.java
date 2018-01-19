package cn.com.atnc.ioms.dao.duty.environment.ups;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 系统连接检查dao
 * @author duanyanlin
 * @date 2016年7月11日上午9:20:26
 */
public interface SystemConnMeasureDao extends IBaseDao<SystemConnMeasure> {
	
	List<SystemConnMeasure> queryByModel(MeasureQueryModel queryModel);
}
