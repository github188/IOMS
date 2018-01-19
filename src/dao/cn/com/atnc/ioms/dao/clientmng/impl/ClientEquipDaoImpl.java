package cn.com.atnc.ioms.dao.clientmng.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientmng.IClientEquipDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:50:44
 * @version:1.0
 */
@Repository("clientEquipDao")
public class ClientEquipDaoImpl extends MyBaseDao<ClientEquip> implements
		IClientEquipDao {

	@Override
	public List<Equip> queryEquip(EquipQueryModel queryModel) {
		String hql="select o.equip from ClientEquip o where 1=1 ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(null != queryModel.getId()){
			hql=hql+" and o.client.id=:id";
			params.put("id", queryModel.getId());
		}
		hql=hql+" order by o.equip.code asc,o.equip.name asc,o.equip.info asc,o.equip.bureau asc,o.equip.type asc";
		return (List<Equip>) super.queryList(hql, params);
		
	}
	
	public List<Client> queryClient(ClientEquipQueryModel qm) {
		String hql="select o.client from ClientEquip o where 1=1 ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(null != qm.getEquipID()){
			hql=hql+" and o.equip.id=:id";
			params.put("id", qm.getEquipID());
		}
		return (List<Client>) super.queryList(hql, params);
		
	}

	@Override
	public List<ClientEquip> queryList(ClientEquipQueryModel qm) {
		String hql=" from "+super.clazz.getName() +" o where 1=1 ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(!StringUtils.isEmpty(qm.getClientID())){
			hql=hql+" and o.client.id=:clientID";
			params.put("clientID", qm.getClientID());
		}if(!StringUtils.isEmpty(qm.getEquipID())){
			hql=hql+" and o.equip.id=:equipID";
			params.put("equipID", qm.getEquipID());
		}
		return (List<ClientEquip>) super.queryList(hql, params);
		
	}
	
	@Override
	public Long querySize(ClientEquipQueryModel qm) {
		String hql=" from "+super.clazz.getName() +" o where 1=1 ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(!StringUtils.isEmpty(qm.getClientID())){
			hql=hql+" and o.client.id=:clientID";
			params.put("clientID", qm.getClientID());
		}if(!StringUtils.isEmpty(qm.getEquipID())){
			hql=hql+" and o.equip.id=:equipID";
			params.put("equipID", qm.getEquipID());
		}
		return super.querySize(hql, params);
		
	}
	
	public int deleteEquip(String equipId){
		String hql="delete from ClientEquip where equip.id=?";
		return super.executeHql(hql, equipId);
	}
}
