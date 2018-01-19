package cn.com.atnc.ioms.mng.faultmng.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.faultmng.IFaultHandleDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.dao.systemmng.deptinfomng.IDeptInfoMngDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.faultmng.FaultHandle;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.FaultStatus;
import cn.com.atnc.ioms.enums.faultmng.FaultWorkflowType;
import cn.com.atnc.ioms.enums.faultmng.TransferType;
import cn.com.atnc.ioms.mng.faultmng.IFaultMQService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMngWorkflowService;
import cn.com.atnc.ioms.mng.faultmng.message.ISendMessageManager;
import cn.com.atnc.ioms.model.faultmng.FaultSendJsonModel;

/**
 * 
 * @author hantianyu
 *
 */
@Service("IFaultMQService")
public class FaultMQServiceImpl extends BaseService implements
IFaultMQService {
    @Autowired
    private IDeptInfoMngDao deptDao;
    @Autowired
    private IFaultHandleDao faulthandleDao;
    @Autowired
    private IFaultInformationDao faultInfoDao;
    @Autowired
	private IFaultMngWorkflowService faultMngWorkflow;
    @Autowired
    private ISendMessageManager sendMessage;
    
    public void SendMessage(FaultSendJsonModel jsonqm,User user){
    	
    	
	    
	    jsonqm.setDept(user.getDeptinfo().getDeptName().toString());//第一处理人所在部门
	    jsonqm.setName(user.getName().toString());//第一处理人
	    jsonqm.setDeptNum(user.getDeptinfo().getDeptNumberOa().toString());//任务单发起部门编号
	    try {
			sendMessage.sendMessage(jsonqm.toJson());
			System.err.println("sendMessage:"+user.getDeptinfo().getDeptName().toString()+"----发送消息-----");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
     	 
    }
    
	
	 
	 public void receive(String json){
		 
		 JSONObject jsonObject = JSONObject.fromObject(json);
		 FaultInformation faultInformation=faultInfoDao.findById(jsonObject.getString("faultId"));
     	if(faultInformation!=null){
     		//
     		String processInstanceId = faultInformation.getProcessInstanceId();	   
  		    Task task = null;															//新建任务实体
  			if(!StringUtils.isEmpty(processInstanceId)){
  				task = this.faultMngWorkflow.getTaskByProcessInstaceId(processInstanceId);
  			}
  			//
  			Map<String, Object> taskVariables = new HashMap<>();						//工作流赋值变量
     		User user=faultInformation.getFirstHandelUser();
     		FaultHandle faultHandle=new FaultHandle();
         	faultHandle.setFaultId(jsonObject.getString("faultId"));
         	faultHandle.setFaultDesc("");
         	faultHandle.setFaultChildNumber(faultInformation.getFaultChildNumber());
         	faultHandle.setFaultNumber(faultInformation.getFaultNumber());
         	faultHandle.setHandleDesc(jsonObject.getString("handleDesc"));
         	faultHandle.setNextHanleUser(faultInformation.getFirstHandelUser().getName());
         	
         	faultHandle.setOperatTime(new Date());
         	faultHandle.setTransferType(TransferType.DEPT);
         	//
         	if(jsonObject.getString("handleType").equals("删除")||jsonObject.getString("handleType").equals("拒收")||jsonObject.getString("handleType").equals("取消")){
         		
         		faultHandle.setHandleType(FaultHandelType.BACK);
         		faultInformation.setCurrentHandleUser(user.getName());
         		faultInformation.setFaultStatus(FaultStatus.WAIT);
         		taskVariables.put("userId", faultInformation.getFirstHandelUser().getId()); 
     			taskVariables.put(FaultWorkflowType.faultBack.name(), true);

         	}
         	else{
         		//待验收
         		faultHandle.setHandleType(FaultHandelType.HANDLE);
         		faultInformation.setCurrentHandleUser(user.getName());
         		faultInformation.setFaultStatus(FaultStatus.CLASSIFY);
         		taskVariables.put("userId", faultInformation.getFirstHandelUser().getId()); 
     			taskVariables.put(FaultWorkflowType.faultBack.name(), false);
         	}
         	
         	if(task != null){
         		System.err.println("---1--"+task.getName());
     			this.faultMngWorkflow.complete(task.getId(), taskVariables);			//执行工作流
 				Task taskAfter = this.faultMngWorkflow.getTaskByProcessInstaceId(processInstanceId);
 			    System.err.println("---2--"+taskAfter.getName());
 				faultInformation.setTaskName(taskAfter.getName());						//随着工作流的进行，修改故障单中的当前业务名称
     			
     		}
         	faultInfoDao.update(faultInformation);
         	faulthandleDao.save(faultHandle);
     	}
     	
     	
        System.err.println("收到消息" + jsonObject.getString("faultId"));  
	 }
	
}
