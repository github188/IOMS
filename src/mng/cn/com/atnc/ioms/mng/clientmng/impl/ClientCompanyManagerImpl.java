package cn.com.atnc.ioms.mng.clientmng.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivestars.interfaces.bbs.util.XMLHelper;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.SecurityUtil;
import cn.com.atnc.ioms.dao.clientmng.IClientCompanyDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.enums.clientmng.CsRoleType;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import cn.com.atnc.ioms.mng.clientmng.IClientCompanyManager;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.model.systemmng.clientcompany.ClientCompanyQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午4:18:35
 * @version:1.0
 */
@Service("clientCompanyManager")
public class ClientCompanyManagerImpl extends AbstractService implements
		IClientCompanyManager {
	
	@Autowired
	private IClientCompanyDao csClientCompanyDao;
	@Autowired
	private IClientDao csClientDao;
	
	@Override
	public Pagination queryPage(ClientCompanyQueryModel qm) {
		return this.csClientCompanyDao.queryPage(qm);
	}

	@Override
	public List<ClientCompany> queryList(ClientCompanyQueryModel qm) {
		return this.csClientCompanyDao.queryList(qm);
	}

	@Override
	public ClientCompany add(ClientCompany obj) throws ServiceException{
		 String str= "";
		 ClientCompanyQueryModel qm = new ClientCompanyQueryModel();
		 qm.setCompany(obj.getCompany());
			if (CollectionUtils.isEmpty(csClientCompanyDao.queryList(qm))) {
				this.csClientCompanyDao.save(obj);
			} else {
				for(ClientCompany clientCompany:csClientCompanyDao.queryList(qm)){
					str += clientCompany.getCompany()+",";
				}
				throw new ServiceException("单位 : "+ str +"已存在，不能添加");
			}
		
		return obj;
	}

	@Override
	public ClientCompany findByID(Serializable id) {
		return this.csClientCompanyDao.findById(id);
	}

	@Override
	public ClientCompany update(ClientCompany obj) throws ServiceException {
		String str= "";
		 ClientCompanyQueryModel qm = new ClientCompanyQueryModel();
		 qm.setCompany(obj.getCompany());
			
			if (CollectionUtils.isEmpty(csClientCompanyDao.queryList(qm))) {
				this.csClientCompanyDao.update(obj);
			} else {
				for(ClientCompany clientCompany:csClientCompanyDao.queryList(qm)){
					str += clientCompany.getCompany()+",";
				}
				throw new ServiceException("单位 : "+ str +"已存在，不能修改");
			}
		
		return obj;
	}
	
	@Override
	public ClientCompany updatem(ClientCompany obj) throws ServiceException {
		this.csClientCompanyDao.update(obj);
		return obj;
	}

	@Override
	public void delete(ClientCompany clientCompany) throws ServiceException {
        String str= "";
		ClientQueryModel qm = new ClientQueryModel();
		qm.setNewCompany(clientCompany);
		System.out.println("test");
		if (CollectionUtils.isEmpty(csClientDao.queryList(qm))) {
			this.csClientCompanyDao.delete(clientCompany);
		} else {
			for(Client client:csClientDao.queryList(qm)){
				str += client.getName()+",";
			}
			throw new ServiceException("有下属员工 : "+ str +"存在，不能删除");
		}
	}
	
}
