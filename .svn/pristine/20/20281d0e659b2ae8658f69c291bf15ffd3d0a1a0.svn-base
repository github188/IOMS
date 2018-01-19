package cn.com.atnc.ioms.mng.duty.statellite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellite.day.SlhNetConDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.SlhNetCon;
import cn.com.atnc.ioms.mng.duty.statellite.SlhNetConService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.day.SlhNetConModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author shijiyong
 * @date 2016年10月18日 上午10:02:09
 * @version 1.0, 2016年10月18日 上午10:02:09
 */
@Transactional
@Service("SlhNetConService")
public class SlhNetConServiceImpl implements SlhNetConService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private SlhNetConDao slhnetcondao;

	@Override
	public SlhNetConModel save(SlhNetConModel slhnetconmodel) {
		// 公共
		EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
		upsCheck.setOperator(slhnetconmodel.getOperator());
		upsCheck.setCheckTime(DateUtilTools.getNowDateTime());
		upsCheck.setCheckDate(DateUtilTools.getNowDate());
		environmentEquipCheckDao.save(upsCheck);

		// 私有
		SlhNetCon netCon = new SlhNetCon();
		netCon.setCon3(slhnetconmodel.getCon3());
		netCon.setCon4(slhnetconmodel.getCon4());
		netCon.setCon5(slhnetconmodel.getCon5());
		netCon.setCon6(slhnetconmodel.getCon6());
		netCon.setCheckid(upsCheck);
		slhnetcondao.save(netCon);
		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(netCon.getId());
		return (SlhNetConModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		// TODO Auto-generated method stub
		return slhnetcondao.queryPageByModel(queryModel);
	}

	@Override
	public SlhNetCon findById(String id) {
		// TODO Auto-generated method stub
		return slhnetcondao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		// TODO Auto-generated method stub
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public SlhNetConModel update(SlhNetCon slhnetcon,
			EnvironmentEquipCheck enviroment, SlhNetConModel slhnetconmodel) {
		// 更新公共类
		enviroment.setUpdater(slhnetconmodel.getOperator());
		enviroment.setUpdateTime(DateUtilTools.getNowDateTime());
		environmentEquipCheckDao.update(enviroment);

		// 更新私有部分
		slhnetcon.setCon3(slhnetconmodel.getCon3());
		slhnetcon.setCon4(slhnetconmodel.getCon4());
		slhnetcon.setCon5(slhnetconmodel.getCon5());
		slhnetcon.setCon6(slhnetconmodel.getCon6());
		slhnetcondao.update(slhnetcon);

		// 重新赋值
		EnvironmentCheckQueryModel qm = new EnvironmentCheckQueryModel();
		qm.setId(slhnetcon.getId());
		return (SlhNetConModel) queryPageByModel(qm).getResult().get(0);
	}

	@Override
	public void delete(SlhNetCon slhnetcon, EnvironmentEquipCheck enviroment) {
		// TODO Auto-generated method stub
		environmentEquipCheckDao.delete(enviroment);
		slhnetcondao.delete(slhnetcon);
	}

}
