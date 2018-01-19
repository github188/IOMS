package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.ToolDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.Tool;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ToolService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.ToolModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("ToolService")
public class ToolServiceImpl implements ToolService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private ToolDao tooldao;

	@Override
	public ToolModel save(ToolModel toolmodel) {

		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(toolmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		upsCheck.setCheckType(toolmodel.getCheckType());
		environmentEquipCheckDao.save(upsCheck);

		Tool tool = new Tool();
		tool.setRemark1(toolmodel.getRemark1());
		tool.setRemark2(toolmodel.getRemark2());
		tool.setRemark3(toolmodel.getRemark3());
		tool.setRemark4(toolmodel.getRemark4());
		tool.setRemark5(toolmodel.getRemark5());
		tool.setRemark6(toolmodel.getRemark6());
		tool.setRemark7(toolmodel.getRemark7());
		tool.setRemark8(toolmodel.getRemark8());
		tool.setRemark9(toolmodel.getRemark9());
		tool.setRemark10(toolmodel.getRemark10());
		tool.setName1(toolmodel.getName1());
		tool.setName2(toolmodel.getName2());
		tool.setName3(toolmodel.getName3());
		tool.setName4(toolmodel.getName4());
		tool.setName5(toolmodel.getName5());
		tool.setName6(toolmodel.getName6());
		tool.setName7(toolmodel.getName7());
		tool.setName8(toolmodel.getName8());
		tool.setName9(toolmodel.getName9());
		tool.setName10(toolmodel.getName10());
		tool.setNum1(toolmodel.getNum1());
		tool.setNum2(toolmodel.getNum2());
		tool.setNum3(toolmodel.getNum3());
		tool.setNum4(toolmodel.getNum4());
		tool.setNum5(toolmodel.getNum5());
		tool.setNum6(toolmodel.getNum6());
		tool.setNum7(toolmodel.getNum7());
		tool.setNum8(toolmodel.getNum8());
		tool.setNum9(toolmodel.getNum9());
		tool.setNum10(toolmodel.getNum10());

		tool.setCheckid(upsCheck);
		tooldao.save(tool);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(tool.getId());
		return (ToolModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return tooldao.queryPageByModel(queryModel);
	}

	@Override
	public Tool findById(String id) {
		return tooldao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public ToolModel update(Tool tool, EnvironmentEquipCheck enviroment,
			ToolModel toolmodel) {
		enviroment.setUpdater(toolmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDate());
		environmentEquipCheckDao.update(enviroment);

		tool.setRemark1(toolmodel.getRemark1());
		tool.setRemark2(toolmodel.getRemark2());
		tool.setRemark3(toolmodel.getRemark3());
		tool.setRemark4(toolmodel.getRemark4());
		tool.setRemark5(toolmodel.getRemark5());
		tool.setRemark6(toolmodel.getRemark6());
		tool.setRemark7(toolmodel.getRemark7());
		tool.setRemark8(toolmodel.getRemark8());
		tool.setRemark9(toolmodel.getRemark9());
		tool.setRemark10(toolmodel.getRemark10());
		tool.setName1(toolmodel.getName1());
		tool.setName2(toolmodel.getName2());
		tool.setName3(toolmodel.getName3());
		tool.setName4(toolmodel.getName4());
		tool.setName5(toolmodel.getName5());
		tool.setName6(toolmodel.getName6());
		tool.setName7(toolmodel.getName7());
		tool.setName8(toolmodel.getName8());
		tool.setName9(toolmodel.getName9());
		tool.setName10(toolmodel.getName10());
		tool.setNum1(toolmodel.getNum1());
		tool.setNum2(toolmodel.getNum2());
		tool.setNum3(toolmodel.getNum3());
		tool.setNum4(toolmodel.getNum4());
		tool.setNum5(toolmodel.getNum5());
		tool.setNum6(toolmodel.getNum6());
		tool.setNum7(toolmodel.getNum7());
		tool.setNum8(toolmodel.getNum8());
		tool.setNum9(toolmodel.getNum9());
		tool.setNum10(toolmodel.getNum10());

		tooldao.update(tool);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(tool.getId());
		return (ToolModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(Tool tool, EnvironmentEquipCheck enviroment) {
		tooldao.delete(tool);
		environmentEquipCheckDao.delete(enviroment);
	}

}
