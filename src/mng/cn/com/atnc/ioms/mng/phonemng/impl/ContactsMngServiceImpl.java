package cn.com.atnc.ioms.mng.phonemng.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.phonemng.IContactsMngDao;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.enums.phonemng.ContactStatusEnum;
import cn.com.atnc.ioms.enums.phonemng.ContactsIsDelEnum;
import cn.com.atnc.ioms.mng.phonemng.IContactsMngService;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;

/**
 * 
 * @author hantianyu
 *
 */
@Service("IContactsMngService")
public class ContactsMngServiceImpl extends BaseService implements IContactsMngService{
   @Autowired
   IContactsMngDao contactsMngDao;
   
   public String save(ContactsMng contactsMng){
	   contactsMng.setContactStatus(ContactStatusEnum.WHITE);
	   contactsMng.setIsDel(ContactsIsDelEnum.NOTDEL);
	   contactsMng.setCreateTime(new Date());
	   return contactsMngDao.save(contactsMng).toString();
   }

	@Override
	public Pagination queryPage(ContactsMngQueryModel queryModel) {
		// TODO Auto-generated method stub
		return contactsMngDao.queryPage(queryModel);
	}
	
	public ContactsMng findViewById(String id){
		return contactsMngDao.findById(id);
	}
	
    public ContactsMng Update(String id,ContactsMng contactsMng){
		
    	ContactsMng contacts=this.findViewById(id);
		contacts.setOperatTime(new Date());
		contacts.setOperator(contactsMng.getOperator());
		contacts.setCompanyInfo(contactsMng.getCompanyInfo());
		contacts.setContactPlace(contactsMng.getContactPlace());
		contacts.setRemark(contactsMng.getRemark());
    	
		contactsMngDao.saveOrUpdate(contacts);
		return contactsMngDao.findById(id);
	}
    
    public String contactsUpdateStatus(String[] ids,String type){
		ContactsMng contactsMng=null;
		for (String sid : ids) {
			contactsMng = contactsMngDao.findById(sid);
			if(type.equals("黑名单")){
				contactsMng.setContactStatus(ContactStatusEnum.BLACK);
			}
			else{
				contactsMng.setContactStatus(ContactStatusEnum.WHITE);
			}
			contactsMngDao.update(contactsMng);
			
		}
		return null;
	}
    public List<String> getTelNumberList(String[] ids){
    	List<String> listNumber=new ArrayList<String>();
    	ContactsMng contactsMng=null;
		for (String sid : ids) {
			contactsMng = contactsMngDao.findById(sid);
			listNumber.add(contactsMng.getTelNumber());
		}
    	return listNumber;
    }
    public ContactsMng contactsWhite(ContactsMng contactsMng){
    	contactsMng.setContactStatus(ContactStatusEnum.WHITE);
    	contactsMngDao.update(contactsMng);
    	return contactsMng;
    }
    
    public ContactsMng getContactsInfoByTel(ContactsMngQueryModel qm){
    	ContactsMng contactsMng=null;
    	List<ContactsMng> contactsList=contactsMngDao.getContactsInfoTel(qm);
    	if(contactsList.size()>0){
    		contactsMng=contactsList.get(0);
    	}
    	return contactsMng;
    }
    
    public List<ContactsMng> getContactsInfoByNumberAndName(ContactsMngQueryModel qm){
    	return contactsMngDao.getContactsInfoByNumberAndName(qm);
    }
    
    public ContactsMng Del(ContactsMng contactsMng){
    	contactsMng.setIsDel(ContactsIsDelEnum.DEL);
    	contactsMngDao.update(contactsMng);
    	return contactsMng;
    }
    
    public ContactsMng notDel(ContactsMng contactsMng){
    	contactsMng.setIsDel(ContactsIsDelEnum.NOTDEL);
    	contactsMngDao.update(contactsMng);
    	return contactsMng;
    }
}
