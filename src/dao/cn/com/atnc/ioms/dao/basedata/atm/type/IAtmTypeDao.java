package cn.com.atnc.ioms.dao.basedata.atm.type;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;

/**
 *类说明
 *@author 潘涛
 *@date 2014-8-27	上午10:01:55
 *@version:1.0
 */
public interface IAtmTypeDao extends IBaseDao<AtmType>{
	public Pagination queryPage(AtmTypeQueryModel queryModel);
	
	public List<AtmType> queryList(AtmTypeQueryModel queryModel);

	public List<AtmType> serviceTypeList(AtmTypeQueryModel queryModel);
}
