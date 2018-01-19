package dao.tests.cn.com.atnc.ioms.dao.turndutymng;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.turndutymng.IShiftDutyRecordDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

public class TestShiftDutyDao extends MyBaseTransationalTest{

	@Autowired
	private IShiftDutyRecordDao shiftDao;
	@Autowired 
	private IUserDao userDao;
	
	@Test
	public void testQueryPage() {
		
		TurnDutyQueryModel queryModel=new TurnDutyQueryModel();
		queryModel.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
		queryModel.setDutyRole(DutyRoleEnum.DUTYENGINEER);
		queryModel.setCreater("");
		queryModel.setStartOptTime("");
		queryModel.setEndOptTime("");
		echo(shiftDao.queryPage(queryModel));
	}
	
	@Test
	public void testADQU(){
		
		//添加
		ShiftDutyRecord shift=new ShiftDutyRecord();
		User user=userDao.findById("admin");
		
		shift.setDutyPlaces(DutyPlaceEnum.COMMUNICATION);
		shift.setDutyRoles(DutyRoleEnum.DUTYENGINEER);
		shift.setCreater(user);
		shift.setCreatime(new Date());
		shift.setRemark("test-remark");
		
		shiftDao.save(shift);
		
	}

}
