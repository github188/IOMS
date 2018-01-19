package cn.com.atnc.ioms.dao.phonemng.hibernate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.phonemng.IContactsMngDao;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
/**
 * 
 * @author hantianyu
 *
 */
@Repository("IContactsMngDao")
public class ContactsMngDaoImpl extends MyBaseDao<ContactsMng> implements IContactsMngDao{
	
	@Override
	public Pagination queryPage(ContactsMngQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from ContactsMng where  1=1");
		List<Object> queryParams = new ArrayList<Object>();
		if(!StringUtils.isEmpty(queryModel.getContactName())){
			hql.append(" and contactName like % ? %");
			queryParams.add(queryModel.getContactName());
		}
		if(!StringUtils.isEmpty(queryModel.getContactPlace())){
			hql.append(" and contactPlace = ?");
			queryParams.add(queryModel.getContactPlace());
		}
		if(queryModel.getContactStatus()!=null){
			hql.append(" and contactStatus = ?");
			queryParams.add(queryModel.getContactStatus());
		}
		
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by createTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	public List<ContactsMng> getContactsInfoTel(ContactsMngQueryModel qm) {
	
		StringBuilder hql = new StringBuilder();
		hql.append(" from ContactsMng where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(qm.getTelNumber()!=null)
	    {
	    	hql.append("and telNumber=:telNumber");
	    	params.put("telNumber",qm.getTelNumber());
	    }
	    
		return (List<ContactsMng>) super.queryList(hql.toString(),params);
	}
	public List<ContactsMng> getContactsInfoByNumberAndName(ContactsMngQueryModel qm) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from ContactsMng where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(qm.getTelNumber()!=null)
	    {
	    	hql.append("and telNumber=:telNumber");
	    	params.put("telNumber",qm.getTelNumber());
	    }
	    if(qm.getContactName()!=null)
	    {
	    	hql.append("and contactName=:contactName");
	    	params.put("contactName",qm.getContactName());
	    }
	    
		return (List<ContactsMng>) super.queryList(hql.toString(),params);
	}

}
