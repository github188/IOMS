package dao.tests.cn.com.atnc.ioms.dao.turndutymng;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.envers.Audited;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

public class SignLeaveDaoTest extends MyBaseTransationalTest{

	@Autowired
	private ISignLeaveDao signLeaveDao;
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
		echo(signLeaveDao.queryPage(queryModel));
	}
	
	@Test
	public void testADQU(){
		//签到
		SignLeaveRecord sign=new SignLeaveRecord();
		sign.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
		sign.setDutyRole(DutyRoleEnum.DUTYENGINEER);
		sign.setDutyStatus(DutyStatusEnum.SIGNIN);
		sign.setUserinfo(userDao.findById("admin"));
		sign.setSignTime(new Date());
		signLeaveDao.save(sign);
		
		//离岗
		sign.setLeaveTime(new Date());
		sign.setDutyStatus(DutyStatusEnum.LEAVE);
		signLeaveDao.saveOrUpdate(sign);
		
	}

}
