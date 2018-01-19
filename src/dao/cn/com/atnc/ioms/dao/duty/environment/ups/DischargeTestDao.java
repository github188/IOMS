package cn.com.atnc.ioms.dao.duty.environment.ups;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
/**
 * 放电测试Dao接口
 * @author duanyanlin
 * @date 2016年7月11日上午8:59:54
 */
public interface DischargeTestDao extends IBaseDao<DischargeTest> {
	
	List<DischargeTest> queryByModel(MeasureQueryModel queryModel);

}
