package cn.com.atnc.ioms.mng.basedata.atm.type;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import antlr.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.basedata.atm.service.IAtmServiceDao;
import cn.com.atnc.ioms.dao.basedata.atm.type.IAtmTypeDao;
import cn.com.atnc.ioms.entity.basedata.atm.type.AtmType;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;

/**
 *类说明
 *@author 潘涛
 *@date 2014-8-27	上午10:14:44
 *@version:1.0
 */
@Service("AtmTypeManager")
public class AtmTypeManagerImpl extends BaseService implements
IAtmTypeManager{
	@Autowired
	private IAtmTypeDao atmTypeDao;
	@Autowired
	private IAtmServiceDao atmServiceDao;
	
	@Override
	public Pagination queryPage(AtmTypeQueryModel model) {
		// TODO Auto-generated method stub
		return atmTypeDao.queryPage(model);
	}
	
	@Override
	public List<AtmType> queryList(AtmTypeQueryModel model) {
		// TODO Auto-generated method stub
		return atmTypeDao.queryList(model);
	}
	@Override
	public List<AtmType> serviceTypeList(AtmTypeQueryModel model) {
		// TODO Auto-generated method stub
		return atmTypeDao.serviceTypeList(model);
	}
	@Override
	@Transactional
	public AtmType add(AtmType type) throws ServiceException {
		if (!StringTools.hasText(type.getServiceType())) {
			throw new ServiceException("类型不能为空！");
		}

		AtmTypeQueryModel queryModel = new AtmTypeQueryModel();
		queryModel.setServiceType(type.getServiceType());

		atmTypeDao.save(type);
		return type;

	}
	@Override
	@Transactional
	public String delete(String id) throws ServiceException {
		// TODO Auto-generated method stub
		String str = "0000" ;//默认类型id
		AtmServiceQueryModel qm = new AtmServiceQueryModel();
		qm.setAtmType(findById(id));
		if(!org.apache.commons.lang.StringUtils.equals(id, str)){
			if (CollectionUtils.isEmpty(atmServiceDao.queryList(qm))) {
				AtmType atmType = findById(id);
				atmTypeDao.delete(atmType);
				return atmType.getServiceType();
			} else {
				throw new ServiceException("有相关服务存在，不能删除");
			}
		}
		else{
			throw new ServiceException("\"未定义\"为默认类型，不能删除");
		}
	}
	@Override
	public AtmType findById(String id) {
		// TODO Auto-generated method stub
		AtmType atmType = atmTypeDao.findById(id);
		return atmType;
	}
	@Override
	@Transactional
	public AtmType update(AtmType atmType) throws ServiceException {
		// TODO Auto-generated method stub
		String str = "0000" ;//默认类型id
		if(!org.apache.commons.lang.StringUtils.equals(atmType.getId(), str)){
			
			atmTypeDao.saveOrUpdate(atmType);
			return atmType;
		}else{
			System.out.println("excetion");
			throw new ServiceException("\"未定义\"为默认类型，不能修改");
		}
		
	}
	@Override
	@Transactional
	public boolean check(String id){
		String str = "0000" ;//默认类型id
		AtmServiceQueryModel qm = new AtmServiceQueryModel();
		qm.setAtmType(findById(id));
		if(!org.apache.commons.lang.StringUtils.equals(id, str)){
			if (CollectionUtils.isEmpty(atmServiceDao.queryList(qm))) {
				return true;
				
			} else {
				return false;
			}
		}
		else{
			return false;
		}
		

	}
}
