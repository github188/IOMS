/**
 * 
 */
package cn.com.atnc.ioms.dao.operstat.atm;


import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.AtmServiceDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * ATM全网业务统计Dao接口
 * 
 * @author：KuYonggang
 * @date：2014-5-23上午8:56:44
 * @version：1.0
 */
public interface IAtmServiceDao extends IBaseDao<AtmService> {

	/**
	 * 根据查询Model查询AtmServiceDBModel集合
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:09:17
	 * @param：queryModel
	 * @return：void
	 */
	public List<AtmServiceDBModel> queryListByParam(NetworkStatQueryModel queryModel);
	
	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-5-23上午9:09:17
	 * @param：queryModel
	 * @return：void
	 */
	public List<AtmServiceRunInfo> queryRuninfoPageByParam(NetworkStatQueryModel queryModel);

	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-17下午2:39:07
	 * @param：queryModel
	 * @return：BaseModel
	 */
	public Pagination queryServiceDetailPageByModel(NetworkStatQueryModel queryModel);
	
	/**
	 * 根据查询Model查询分页对象
	 * @author：KuYonggang
	 * @date：2014-6-17下午2:39:07
	 * @param：queryModel
	 * @return：BaseModel
	 */
	public Pagination queryPageForService(NetworkStatQueryModel queryModel);
	
}
