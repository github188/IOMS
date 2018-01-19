/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:02:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.satellite;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:02:18
 * @version:1.0
 */

public interface ISatelliteSiteDao extends IBaseDao<SatelliteSite> {

	public Pagination queryPage(SiteQueryModel queryModel);

	public Long querySize(SiteQueryModel model);
	/**
	 * 
	 * 查询卫星站点代码是否唯一
	 * @return
	 */
	public Long querySizeCodeCheck(SiteQueryModel model);

	public List<SatelliteSite> queryList(SiteQueryModel queryModel);
}
