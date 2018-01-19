/**
 * 
 */
package cn.com.atnc.ioms.mng.systemmng.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclare;
import cn.com.atnc.ioms.entity.techsupport.fault.FaultDeclareOptLog;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.OptType;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareOptLogService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.model.SysFinals;
import cn.com.atnc.ioms.model.techsupport.fault.FaultDeclareDealQueryModel;

/**
 * 定时任务：关闭超时的技术咨询记录
 * 
 * @author：KuYonggang
 * @date：2014-6-10下午3:17:49
 * @version：1.0
 */
@Component
public class TechConsultCloseSchedule {
	//小时毫秒数
	private static final long SF_HOUR = 1000*60*60;
    @Autowired
	@Qualifier(value="SystemConfigDBManagerImpl")
	private ISystemConfigManager systemConfigManager;
    @Autowired
    private IFaultDeclareService faultDeclareService;
    @Autowired
    private IFaultDeclareOptLogService faultDeclareOptLogService;
    @Autowired
    private IUserLogManager userLogManager;
    
    @Scheduled(cron = "0 0/2 * * * ?")
    public void closeTechConsult() throws ServiceException{
    	System.out.println("closeTechConsult()定时方法执行了。。。。。");
    	//获取系统配置的技术咨询超时时长（小时）
    	String hours = systemConfigManager.getParam(SysFinals.techConsultClose);
    	Long millis = (long) (Float.parseFloat(hours)*SF_HOUR);
    	System.out.println("系统设定时长："+hours+" 对应毫秒millis:"+millis);
    	//获取还未关闭的技术咨询记录集合
    	FaultDeclareDealQueryModel model = new FaultDeclareDealQueryModel();
    	List<AllStatus> statusList = new ArrayList<AllStatus>();
    	statusList.add(AllStatus.REPLIED);
    	model.setStatusList(statusList);
    	model.setDeclareType(DeclareType.TECHCONSULT);
    	List<FaultDeclare> faultDeclares = new ArrayList<FaultDeclare>();
    	faultDeclares = faultDeclareService.queryListByParam(model);
    	System.out.println("已回复记录数量："+faultDeclares.size());
    	//循环遍历所有还未关闭的技术咨询集合
    	for (FaultDeclare faultDeclare : faultDeclares) {
			Date replyDate = faultDeclare.getUpdateTime(); 
			Long replyTimeMillis = replyDate.getTime();
			Long currentMillis = System.currentTimeMillis();
			Long minusValue = currentMillis - replyTimeMillis;
			System.out.println("reply:"+replyTimeMillis+" cur:"+currentMillis+" minusValue："+minusValue);
			//如果该条记录超时
			if(minusValue>=millis){
				System.out.println("更新了该记录，记录摘要为："+faultDeclare.getFaultKey());
				//更新记录
				faultDeclare.setFaultStatus(AllStatus.CLOSED);
				faultDeclare.setUpdateTime(new Date());
				faultDeclare.setUpdateUser("系统");
				faultDeclare.setOperUser("系统");
				faultDeclareService.update(faultDeclare);
				//保存过程日志
				FaultDeclareOptLog faultDeclareOptLog = new FaultDeclareOptLog();
				faultDeclareOptLog.setFaultDeclare(faultDeclare);
				faultDeclareOptLog.setFromStatus(AllStatus.REPLIED);
				faultDeclareOptLog.setToStatus(AllStatus.CLOSED);
				faultDeclareOptLog.setOptTime(new Date());
				faultDeclareOptLog.setOptType(OptType.CLOSE);
				faultDeclareOptLog.setOptUserName("系统");
				faultDeclareOptLog.setDescInfo("该技术咨询记录已超时，被系统自动关闭！");
				faultDeclareOptLogService.save(faultDeclareOptLog);
				
				//添加操作日志
				this.addLog("技术咨询处理超时系统自动关闭(故障摘要:"+faultDeclare.getFaultKey()+")");
			}
		}
    }
    
    /**
     * 添加系统自动处理日志信息
     * @author：KuYonggang
     * @date：2014-7-7下午1:36:38
     * @param：info 日志信息
     * @return：void
     */
    private void addLog(String info){
    	UserLog log = new UserLog();
		log.setUser(null);
		log.setOptTime(new Date() );//Calendar.getInstance()
		log.setMenu("技术支持");
		log.setSubMenu("技术咨询处理");
		log.setInfo(info);
		log.setIp("127.0.0.1");
		log.setOptType("超时关闭");
		userLogManager.saveOrUpdate(log);
    }
    
    public static void main(String[] args) {
    	String s = "2";
    	Float ss = Float.parseFloat(s);
    	System.out.println(ss);
	}
}
