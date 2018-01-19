package cn.com.atnc.ioms.mng.clientmng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.clientmng.IClientEquipDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.clientmng.query.ClientEquipQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午4:19:18
 * @version:1.0
 */
@Service("clientEquipService")
public class ClientEquipServiceImpl extends AbstractService implements
		IClientEquipService {
	@Autowired
	private IClientEquipDao clientEquipDao;
	@Autowired
	private IClientManager clientManger;
	@Autowired
	private IEquipService equipManager;

	@Override
	public List<Equip> queryEquipByClientID(EquipQueryModel queryModel) {
		return this.clientEquipDao.queryEquip(queryModel);
	}

	public List<Client> queryClientByEquipID(ClientEquipQueryModel qm) {
		return clientEquipDao.queryClient(qm);
	}

	public List<ClientEquip> queryList(ClientEquipQueryModel qm) {
		return this.clientEquipDao.queryList(qm);
	}

	@Override
	@Transactional
	public ClientEquip add(ClientEquip obj) {
		return this.clientEquipDao.findById(this.clientEquipDao.save(obj));
	}

	@Override
	@Transactional
	public void save(String clientID, String[] equipID) {
		ClientEquipQueryModel qm = new ClientEquipQueryModel();
		qm.setClientID(clientID);
		this.clientEquipDao.deleteList(this.queryList(qm));
		Client client = this.clientManger.findByID(clientID);
		if (equipID != null && equipID.length > 0)
			for (String o : equipID) {
				ClientEquip obj = new ClientEquip();
				obj.setClient(client);
				obj.setEquip(this.equipManager.findById(o));
				this.clientEquipDao.save(obj);
			}

	}

	@Override
	@Transactional
	public void delete(String clientID) {
		ClientEquipQueryModel qm = new ClientEquipQueryModel();
		qm.setClientID(clientID);
		this.clientEquipDao.deleteList(this.queryList(qm));
	}

	public void deleteEquip(String equipId) {
		clientEquipDao.deleteEquip(equipId);
	}
}
