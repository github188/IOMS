package mng.tests.cn.com.atnc.ioms.mng.turndutymng;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

public class TestSignLeaveService extends MyBaseTransationalTest{

	@Autowired
	private ISignLeaveService signLeaveService;
	@Autowired
	private IUserManager userService;
	
	@Test
	public void testIsOndutyByUser() {
		
		User user=userService.findById("admin");
		echo(signLeaveService.isOndutyByUser(user));
	}
	
	@Test
	public void testIsActiveByUser() {
		
		User user=userService.findById("admin");
		echo(signLeaveService.isActiveByUser(user));
	}
	
	@Test
	public void testGetSignRecordListByDate() {
		
		User user=userService.findById("admin");
		echo(signLeaveService.getSignRecordListByDate(new Date(), user));
	}
	
	@Test
	public void testFindViewByUser(){
		
		User user=userService.findById("admin");
		echo(signLeaveService.findViewByUser(user));
	}
	
	@Test
	public void testIsMangerByUser(){
		User user=userService.findById("admin");
		echo(signLeaveService.isMangerByUser(user));
	}

}
