/**
 * 
 */
package mng.tests.cn.com.atnc.ioms.mng.operstat.atm.networkstat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.operstat.atm.IAtmPortDao;
import cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;


/**
 * @author：KuYonggang
 * @date：2014-6-11上午10:09:56
 * @version：1.0
 */
public class TestNetworkStatService extends MyBaseTransationalTest {
	
	@Autowired
	private INetworkStatService networkStatService;
	
	@Test
	public void testGetAllAtmAlarm(){
		List<AtmAlarmDBModel> alarmBaseModels = networkStatService.getAllAtmAlarm();
		echoList(alarmBaseModels);
	}
	
	@Test
	public void testAtmPortDao(){
		System.out.println("testAtmPortDao()方法执行了。。。");
		NetworkStatQueryModel networkStatQueryModel = new NetworkStatQueryModel();
		networkStatQueryModel.setBureau("ZBAA");
		System.out.println(networkStatService.queryAtmPortPageByModel(networkStatQueryModel));
		networkStatService.queryAtmPortPageByModel(networkStatQueryModel);
	}
}
