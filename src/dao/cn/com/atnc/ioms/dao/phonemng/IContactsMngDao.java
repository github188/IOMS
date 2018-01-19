package cn.com.atnc.ioms.dao.phonemng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
/**
 * 
 * @author hantianyu
 *
 */
public interface IContactsMngDao extends IBaseDao<ContactsMng>{
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:queryPage
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年7月25日 下午4:51:04
	 */
	public Pagination queryPage(ContactsMngQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getContactsInfoTel
	 * @Description:根据电话查询联系人信息
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<ContactsMng>
	 * @Creatime:2016年8月4日 下午5:22:31
	 */
	public List<ContactsMng> getContactsInfoTel(ContactsMngQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getContactsInfoByNumberAndName
	 * @Description:根据 电话、联系人姓名判断是否插入
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<ContactsMng>
	 * @Creatime:2016年8月8日 下午1:27:09
	 */
	public List<ContactsMng> getContactsInfoByNumberAndName(ContactsMngQueryModel qm);
}
