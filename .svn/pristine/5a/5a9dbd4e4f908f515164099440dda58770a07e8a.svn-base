package cn.com.atnc.ioms.dao.clientmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:50:10
 * @version:1.0
 */
public interface IClientEquipDao extends IBaseDao<ClientEquip> {
	/**
	 * 查询客户监控的设备
	 * 
	 * @author 潘涛
	 * @date:2014年4月11日 15:08:43
	 * 
	 * */
	List<Equip> queryEquip(EquipQueryModel queryModel);

	public List<Client> queryClient(ClientEquipQueryModel qm);

	/**
	 * 查询
	 * 
	 * @author 潘涛
	 * @date:2014年4月11日 15:08:43
	 * 
	 * */
	List<ClientEquip> queryList(ClientEquipQueryModel qm);

	/**
	 * 
	 * @author:HuangYijie
	 * @Date:2014-6-24 下午5:32:28
	 * 
	 * @param qm
	 * @return Long
	 */

	Long querySize(ClientEquipQueryModel qm);

	public int deleteEquip(String equipId);

}
