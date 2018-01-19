package cn.com.atnc.ioms.dao.business.satellite;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;

/**
 * KU卫星网远端站入网申请Dao接口
 *
 * @author ku
 * @date 2015年5月13日 下午3:50:20
 * @since 1.0.0
 */
public interface IKuSatelliteDao extends IBaseDao<KuSatellite> {

	/**
	 * 根据查询条件Model查询KU卫星网远端站入网申请记录
	 *
	 * @param queryModel 
	 * @author ku
	 * @date  2015年5月14日上午11:41:32
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(KuSatelliteQueryModel queryModel);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:53:24
	 * @since 1.0.0
	 */
	List<KuSatellite> getListSendMessage();

}
