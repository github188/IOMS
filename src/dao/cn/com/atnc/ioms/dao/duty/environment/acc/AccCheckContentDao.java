package cn.com.atnc.ioms.dao.duty.environment.acc;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccCheckContent;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;

/**
 * @author renyujuan
 * @Description:空调设备巡检内容dao
 * @time:2016年8月11日 上午11:18:35
 */
public interface AccCheckContentDao extends IBaseDao<AccCheckContent> {

    /**
     * @author renyujuan
     * @Description:根据查询model查询相应的空调设备内容巡检集合
     * @time:2016年8月11日 上午11:23:01
     */
    List<AccCheckContent> queryByModel(EnvironmentEquipCheckQueryModel queryModel);
}
