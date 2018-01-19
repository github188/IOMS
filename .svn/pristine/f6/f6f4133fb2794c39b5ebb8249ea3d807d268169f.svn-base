package mng.tests.cn.com.atnc.ioms.mng.clientmng;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import cn.com.atnc.ioms.entity.clientmng.ClientEquip;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientEquipService;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-4-11 下午3:16:54
 * @version:1.0
 */
public class TestClientEquipService extends MyBaseTransationalTest {
	@Autowired
	private IClientEquipService ceServcie;
	@Autowired
	private IClientManager clientManger;
	@Autowired
	private IEquipService equipService;
	@Test
	public void testQueryEquipByClientID() {
		this.ceServcie.queryEquipByClientID(null);
	}
	@Test
	@Rollback(value=false)
	public void testAdd(){
		ClientEquip obj=new ClientEquip();
		obj.setClient(this.clientManger.findByID("atnc1"));
		obj.setEquip(this.equipService.findById("de46f77f8dea4f89aaab36d94740779b"));
		obj.setRecordTime(Calendar.getInstance());
		this.ceServcie.add(obj);
	}
}
