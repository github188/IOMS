package cn.com.atnc.ioms.mng.faultmng;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class FaultMQListener implements ServletContextListener{
	
	private IFaultMQService faultMQService;
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		servletContextEvent.getServletContext().removeAttribute(
				"faultMQService");
		
		org.springframework.scheduling.quartz.SchedulerFactoryBean scheduleBean = (SchedulerFactoryBean) WebApplicationContextUtils
				.getWebApplicationContext(
						servletContextEvent.getServletContext()).getBean(
						"dbScheduler");
		if (null != scheduleBean) {

			scheduleBean.stop();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		ServletContext servletContext = servletContextEvent.getServletContext();

		//faultMQService = (IFaultMQService) WebApplicationContextUtils
				//.getWebApplicationContext(servletContext).getBean(
						//"dbScheduler");

		//faultMQService.receive();
		System.err.println("Listener---------"+new Date());
	}

}
