package cn.com.atnc.ioms.mng.basedata.atm.type;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;

/**
 *类说明
 *@author 徐彤阳
 *@date 2014-8-27	上午9:56:48
 *@version:1.0
 */
public interface IAtmTypeManager {
	public List<AtmType> queryList(AtmTypeQueryModel model);

	public Pagination queryPage(AtmTypeQueryModel model);
	/**
	 * 添加一个atm业务类型
	 * 
	 * @author:XuTongYang
	 * @param AtmType
	 * @return
	 */
	public AtmType add(AtmType type) throws ServiceException;
	/**
	 * 删除卫星站点信息
	 * 
	 * @author:XuTongYang
	 */
	public String delete(String id) throws ServiceException;
	/**
	 * 根据id查找对应的记录
	 * 
	 * @author:XuTongYang
	 */
	public AtmType findById(String id);
	/**
	 * 更新卫星站点信息
	 * 
	 * @author:lizhisheng
	 */
	public AtmType update(AtmType atmType) throws ServiceException;

	public List<AtmType> serviceTypeList(AtmTypeQueryModel model);

	public boolean check(String id);

}
