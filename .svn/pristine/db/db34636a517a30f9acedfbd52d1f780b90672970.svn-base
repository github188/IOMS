/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:02:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.enums.basedata.ServiceChangeType;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:02:18
 * @version:1.0
 */

public interface IKuServiceDao extends IBaseDao<KuService> {

	public Pagination queryPage(KuStatQueryModel queryModel);

	public Long querySize(KuStatQueryModel model);

	public List<KuService> queryList(KuStatQueryModel queryModel);

	public int deleteByNodeId(String nodeId);

	/**
	 * 
	 * 方法说明：将指定时间点之前的记录ServiceChangeType进行变更
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年9月28日上午10:08:55
	 * @param dest
	 *            目标状态
	 * 
	 */
	public int updateServiceChangeType(ServiceChangeType dest);
}
