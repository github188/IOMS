package cn.com.atnc.ioms.mng.maintain.circuit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.maintain.circuit.IEquipCircuitDao;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.mng.maintain.circuit.IMaintainCircuitManager;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

@Service
@Repository
public class IMaintainCircuitManagerImpl implements IMaintainCircuitManager {

	@Autowired
	private IEquipCircuitDao equipCircuitDao;
	
	@Override
	public void add(EquipCircuit equipCircuit) {
		equipCircuitDao.save(equipCircuit);
	}

	@Override
	public Pagination queryPage(KuStatQueryModel queryModel) {
		return equipCircuitDao.queryPage(queryModel);
	}

	@Override
	public EquipCircuit findById(String id) {
		return equipCircuitDao.findById(id);
	}

	@Override
	public void update(EquipCircuit equipCircuit) {
		equipCircuitDao.update(equipCircuit);
	}

	@Override
	public void delete(EquipCircuit equipCircuit) {
		equipCircuitDao.delete(equipCircuit);
		
	}

	@Override
	public List<EquipCircuit> findAll() {
		return equipCircuitDao.getAll();
	}

}
