package cn.com.atnc.ioms.dao.duty.environment.acc;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccDataRecord;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;


/**
 * @author renyujuan
 * @Description:空调设备数据记录Dao
 * @time:2016年8月11日 上午10:58:26
 */
public interface AccDataRecordDao extends IBaseDao<AccDataRecord> {
    
    /**
     * 根据环境设备查询model查询相应的空调设备数据记录集合
     * @param queryModel
     * @return
     */
    List<AccDataRecord> queryByModel(EnvironmentEquipCheckQueryModel queryModel);

}
