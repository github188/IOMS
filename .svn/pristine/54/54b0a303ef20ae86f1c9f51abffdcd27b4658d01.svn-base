package cn.com.atnc.ioms.mng.systemmng.deptinfomng.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.enums.systemmng.deptinfomng.DeptTypeEnum;
import cn.com.atnc.ioms.mng.systemmng.deptinfomng.IDeptInfoMngService;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.faultmng.FaultSendJsonModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;

import javax.jms.Connection;  
import javax.jms.ConnectionFactory;  
import javax.jms.DeliveryMode;  
import javax.jms.Destination;  
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;  
import javax.jms.Session;  
import javax.jms.TextMessage;  

import org.apache.activemq.ActiveMQConnection;  
import org.apache.activemq.ActiveMQConnectionFactory; 

@Service("IDeptInfoMngService")
public class DeptInfoMngServiceImpl extends BaseService implements IDeptInfoMngService{

	@Autowired
	private IDeptInfoMngDao deptInfoMngDao;
	
	private static final int SEND_NUMBER = 5;
	
	@Override
	public Pagination queryPage(DeptInfoQueryModel queryModel) {
		//
		//FaultSendJsonModel qm=new FaultSendJsonModel();
		//User user=new User();
		//SendMessage(qm,user);
		//receive();
		return deptInfoMngDao.queryPage(queryModel);
	}

	@Override
	public String save(DeptInfomationMng deptInfomationMng) {
		if(deptInfomationMng.getDeptType().equals(DeptTypeEnum.BU)){
			//是事业部
			deptInfomationMng.setParentInfo("0");
		}
		else if(deptInfomationMng.getParentInfo()==null||deptInfomationMng.getParentInfo().equals("")){
			deptInfomationMng.setParentInfo("0");
		}
		
		return deptInfoMngDao.save(deptInfomationMng).toString();
	}

	@Override
	public List<DeptInfomationMng> getDeptByType(DeptInfoQueryModel queryModel) {
		
		return deptInfoMngDao.getDeptByType(queryModel);
	}
	
	public List<DeptInfomationMng> getDeptByParentInfo(DeptInfoQueryModel queryModel){
		return deptInfoMngDao.getDeptByParentInfo(queryModel);
	}
	
	public List<User> getUserListByDept(User user){
		UserQueryModel qm=new UserQueryModel();
		qm.setDeptinfo(user.getDeptinfo());
		
		return deptInfoMngDao.getUserListByDept(qm);
	}
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:SendMessage
	 * @Description:TODO
	 * @Param:
	 * @Return:void
	 * @Creatime:2016年6月29日 下午12:52:16
	 */
	
	public void SendMessage(FaultSendJsonModel jsonqm,User user){
		 // ConnectionFactory ：连接工厂，JMS 用它创建连接  
        ConnectionFactory connectionFactory; // Connection ：JMS 客户端到JMS  
        // Provider 的连接  
        Connection connection = null; // Session： 一个发送或接收消息的线程  
        Session session; // Destination ：消息的目的地;消息发送给谁.  
        Destination destination; // MessageProducer：消息发送者  
        MessageProducer producer; // TextMessage message;  
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar  
        connectionFactory = new ActiveMQConnectionFactory(  
                ActiveMQConnection.DEFAULT_USER,  
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");  
        try { // 构造从工厂得到连接对象  
            connection = connectionFactory.createConnection();  
            // 启动  
            connection.start();  
            // 获取操作连接  
            session = connection.createSession(Boolean.TRUE,  
                    Session.AUTO_ACKNOWLEDGE);  
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
            destination = session.createQueue("testQueue");  
            // 得到消息生成者【发送者】  
            producer = session.createProducer(destination);  
            // 设置不持久化，此处学习，实际根据项目决定  
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
            // 构造消息，此处写死，项目就是参数，或者方法获取  
            sendMessage(session, producer,jsonqm,user);  
            session.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (null != connection)  
                    connection.close();  
            } catch (Throwable ignore) {  
            }  
        }  
	}
	 public static void sendMessage(Session session, MessageProducer producer,FaultSendJsonModel jsonqm,User user)  
	            throws Exception {  
		    
		    //传递Json字符串
		    jsonqm.setContactsCompany("Test-Company");
		    jsonqm.setContactsName("testName");
		    jsonqm.setDept("技术工程部");//第一处理人所在部门
		    jsonqm.setFaultArea("华北地区");
		    jsonqm.setFaultDesc("XXXXXXXXXXXXXXXX，故障描述");
		    jsonqm.setFaultId("test_id");
		    jsonqm.setFaultLevel("一级");
		    jsonqm.setFaultTime("2016-06-30 08:22:23");
		    jsonqm.setFaultTypePar("ATM");
		    jsonqm.setFaultTypeSon("设备故障");
		    jsonqm.setHandleDesc("XXXXXXXXXXXXXXXXXXXX，处理记录piupiupiu！");
		    jsonqm.setName("张三");//第一处理人
		    jsonqm.setSuccessTime("2016-07-02");
		    jsonqm.setTelephoneNumber("18601057865");
		    jsonqm.setTransferDept("硬件开发部");//移交人部门
		    jsonqm.setTransferName("王五");//移交人
		    jsonqm.setTransferDeptNum("100010001001");//移交部门编号
		    jsonqm.setDeptNum("100010001002");//任务单发起部门编号

        	TextMessage message = session.createTextMessage(jsonqm.toJson());  
            // 发送消息到目的地方  
     
            producer.send(message);
	          
	    }  
	 
	 public void receive(){
		   // ConnectionFactory ：连接工厂，JMS 用它创建连接  
	        ConnectionFactory connectionFactory;  
	        // Connection ：JMS 客户端到JMS Provider 的连接  
	        Connection connection = null;  
	        // Session： 一个发送或接收消息的线程  
	        Session session;  
	        // Destination ：消息的目的地;消息发送给谁.  
	        Destination destination;  
	        // 消费者，消息接收者  
	        MessageConsumer consumer;  
	        connectionFactory = new ActiveMQConnectionFactory(  
	                ActiveMQConnection.DEFAULT_USER,  
	                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");  
	        try {  
	            // 构造从工厂得到连接对象  
	            connection = connectionFactory.createConnection();  
	            // 启动  
	            connection.start();  
	            // 获取操作连接  
	            session = connection.createSession(Boolean.FALSE,  
	                    Session.AUTO_ACKNOWLEDGE);  
	            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
	            destination = session.createQueue("firstQueue");  
	            consumer = session.createConsumer(destination);  
	            while (true) {  
	                // 设置接收者接收消息的时间，为了便于测试，这里谁定为100s  
	                TextMessage message = (TextMessage) consumer.receive(100000);  
	                if (null != message) {  
	                    System.out.println("收到消息" + message.getText());  
	                } else {  
	                    break;  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                if (null != connection)  
	                    connection.close();  
	            } catch (Throwable ignore) {  
	            }  
	        }  
	 }
	    

}
