package cn.com.atnc.ioms.mng.clientmng;

import java.io.Serializable;
import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;

/**
 * 类说明:客户服务接口
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:53:22
 * @version:1.0
 */
public interface IClientCompanyManager {

	public Pagination queryPage(ClientCompanyQueryModel queryModel);

	public List<ClientCompany> queryList(ClientCompanyQueryModel queryModel);

	public ClientCompany findByID(Serializable id);

	public ClientCompany add(ClientCompany clientCompany) throws ServiceException;
	
	public ClientCompany update(ClientCompany obj) throws ServiceException ;

	public void delete(ClientCompany clientCompany) throws ServiceException;

	public ClientCompany updatem(ClientCompany obj) throws ServiceException ;

}
