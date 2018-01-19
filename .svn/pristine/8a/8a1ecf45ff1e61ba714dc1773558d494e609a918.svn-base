package mng.tests.cn.com.atnc.ioms.mng.turndutymng;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.turndutymng.IShiftDutyRecordService;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

public class TestShiftDutyService extends MyBaseTransationalTest{

	@Autowired
	private IShiftDutyRecordService shiftService;
	@Autowired
	private IUserManager userService;
	
	@Test
	public void testADD() throws ServiceException{
		
		ShiftDutyRecord shift=new ShiftDutyRecord();
		User user=userService.findById("admin");
		
		shift.setDutyPlaces(DutyPlaceEnum.COMMUNICATION);
		shift.setDutyRoles(DutyRoleEnum.DUTYENGINEER);
		shift.setCreater(user);
		shift.setCreatime(new Date());
		shift.setRemark("test-remark");
		
		shiftService.save(shift);
		
	}
	
	@Test
	public void testMOD() throws ServiceException{
		
		ShiftDutyRecord shift=new ShiftDutyRecord();
		User user=userService.findById("admin");
		
		shift.setDutyPlaces(DutyPlaceEnum.COMMUNICATION);
		shift.setDutyRoles(DutyRoleEnum.DUTYENGINEER);
		shift.setCreater(user);
		shift.setCreatime(new Date());
		shift.setRemark("test-remark");
		shift.setOperatime(new Date());
		shift.setOperator(user);

		shiftService.Update(shift);
	}
	
	@Test
	public void testList(){
		ShiftDutyQueryModel shiftDutyQueryModel=new ShiftDutyQueryModel();
		User user=userService.findById("admin");
		echo(shiftService.getRecordList(shiftDutyQueryModel,user));
	}
	
	@Test
	public void testPlaceByUser(){
		User user=userService.findById("admin");
		echo(shiftService.getDutyPlaceByUser(user));
	}

}
