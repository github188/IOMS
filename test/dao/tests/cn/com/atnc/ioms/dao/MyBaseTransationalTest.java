package dao.tests.cn.com.atnc.ioms.dao;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import test.cn.com.atnc.common.BaseTransactionTest;

/**
 * 
 * @author:HuangYijie
 * @date:2011-8-8 下午01:27:40
 * @version:1.0
 */
@ContextConfiguration(locations = { "file:war/WEB-INF/beans/activiti.xml","file:war/WEB-INF/beans/main.xml","file:war/WEB-INF/beans/applicationContext-security.xml","file:war/WEB-INF/beans/applicationContext-mq.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
public abstract class MyBaseTransationalTest extends BaseTransactionTest {
	static {
		System.setProperty("ioms.name", "war");
	}
}
