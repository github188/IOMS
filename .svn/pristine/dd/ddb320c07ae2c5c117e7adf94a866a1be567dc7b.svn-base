/**
 * 
 */
package dao.tests.cn.com.atnc.ioms.dao.operstat.atm;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmAlarmStatDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmServiceDao;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;


/**
 * @author：KuYonggang
 * @date：2014-6-16下午3:18:37
 * @version：1.0
 */
public class TestAtmServiceQueryModel extends MyBaseTransationalTest {

	@Autowired
	private IAtmServiceDao atmServiceDao;
	
	@Test
	public void testAtmModel() throws IOException{
		NetworkStatQueryModel queyModel = new NetworkStatQueryModel();
		queyModel.setBureau("ZBAA");
	}
}
