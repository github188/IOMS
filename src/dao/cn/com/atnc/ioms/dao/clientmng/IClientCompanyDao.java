package cn.com.atnc.ioms.dao.clientmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;

/**
 *类说明
 *@author 潘涛
 *@date 2014-3-19	下午3:47:37
 *@version:1.0
 */
public interface IClientCompanyDao extends IBaseDao<ClientCompany> {

	public Pagination queryPage(ClientCompanyQueryModel qm);
	
	public List<ClientCompany> queryList(ClientCompanyQueryModel qm);
}
