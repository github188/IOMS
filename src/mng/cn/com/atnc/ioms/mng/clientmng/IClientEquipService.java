package cn.com.atnc.ioms.mng.clientmng;

import java.util.List;

import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:54:11
 * @version:1.0
 */
public interface IClientEquipService {
	/**
	 * 查询客户定制的设备
	 * 
	 * @author 潘涛
	 * @date：2014年4月11日 14:16:03
	 * @param:id 客户主键
	 * @return:list 集合
	 * */
	public List<Equip> queryEquipByClientID(EquipQueryModel queryModel);

	
	public List<Client> queryClientByEquipID(ClientEquipQueryModel qm);
	
	
	public List<ClientEquip> queryList(ClientEquipQueryModel qm);

	/**
	 * 新增客户
	 * 
	 * @param obj
	 * @return
	 */
	public ClientEquip add(ClientEquip obj);

	/**
	 * 添加客户设备
	 * 
	 * @author 潘涛
	 * 
	 * */
	public void save(String clientID, String[] equipID);

	/**
	 * 删除客户设备
	 * 
	 * @author 潘涛
	 * 
	 * */
	public void delete(String clientID);

	public void deleteEquip(String equipId);
}
