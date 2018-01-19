package cn.com.atnc.ioms.mng.phonemng;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;

public interface IContactsMngService {
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:save
	 * @Description:联系人保存
	 * @Param:@param contactsMng
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年7月26日 上午8:59:02
	 */
	public String save(ContactsMng contactsMng);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:queryPage
	 * @Description:查询
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年7月26日 上午8:59:47
	 */
	public Pagination queryPage(ContactsMngQueryModel queryModel);
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:findViewById
	 * @Description:根据id查询
	 * @Param:@param id
	 * @Param:@return
	 * @Return:ContactsMng
	 * @Creatime:2016年7月27日 上午8:44:40
	 */
	public ContactsMng findViewById(String id);

	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:Update
	 * @Description:修改
	 * @Param:@param id
	 * @Param:@param contactsMng
	 * @Param:@return
	 * @Return:ContactsMng
	 * @Creatime:2016年7月27日 上午9:34:38
	 */
	public ContactsMng Update(String id,ContactsMng contactsMng);
    
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:contactsUpdateStatus
	 * @Description:修改状态
	 * @Param:@param ids
	 * @Param:@param type
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年7月28日 下午4:25:12
	 */
	public String contactsUpdateStatus(String[] ids,String type);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getContactsInfoByTel
	 * @Description:根据电话获取联系人号码
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:ContactsMng
	 * @Creatime:2016年8月4日 下午5:26:39
	 */
	public ContactsMng getContactsInfoByTel(ContactsMngQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getContactsInfoByNumberAndName
	 * @Description:TODO 根据 电话、联系人姓名判断是否插入
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<ContactsMng>
	 * @Creatime:2016年8月8日 下午1:30:02
	 */
	public List<ContactsMng> getContactsInfoByNumberAndName(ContactsMngQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:Del
	 * @Description:删除(冻结)
	 * @Param:@param contactsMng
	 * @Return:void
	 * @Creatime:2016年8月15日 上午10:47:37
	 */
	public ContactsMng Del(ContactsMng contactsMng);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-8-21下午4:52:04
	 * @param contactsMng
	 * @return ContactsMng
	 * TODO 解冻
	 */
	public ContactsMng notDel(ContactsMng contactsMng);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:contactsWhite
	 * @Description:撤销黑名单
	 * @Param:@param contactsMng
	 * @Param:@return 
	 * @Return:ContactsMng
	 * @Creatime:2016年8月15日 下午1:01:12
	 */
	public ContactsMng contactsWhite(ContactsMng contactsMng);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getTelNumberList
	 * @Description:获取电话号码
	 * @Param:@param ids
	 * @Param:@return
	 * @Return:List<String>
	 * @Creatime:2016年8月29日 下午3:41:39
	 */
	public List<String> getTelNumberList(String[] ids);
}
