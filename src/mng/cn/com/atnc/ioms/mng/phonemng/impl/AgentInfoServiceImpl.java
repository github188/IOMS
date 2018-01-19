package cn.com.atnc.ioms.mng.phonemng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.phonemng.IAgentInfoDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.enums.phonemng.AgentStateEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;
/**
 * 
 * @author hantianyu
 *
 */
@Service("IAgentInfoService")
public class AgentInfoServiceImpl extends BaseService implements IAgentInfoService{
   @Autowired
   private IAgentInfoDao agentInfoDao;
   
   public String modSign(String name){
	   String agentNum="";
	   AgentQueryModel qm=new AgentQueryModel();
	   AgentInformation agentInfo=new AgentInformation();
	   
	   qm.setAgentState(AgentStateEnum.NOTLOGIN);
	   List<AgentInformation> agentInfoList=agentInfoDao.getAgentState(qm);
	   if(agentInfoList.size()>0){
		   //未登录的坐席大于零
		   //获取坐席信息
		   agentInfo=agentInfoList.get(0);
		   
		   agentInfo.setAgentState(AgentStateEnum.LOGIN);
		   agentInfo.setUsername(name);
		   //获取坐席编号
		   agentNum=agentInfo.getAgentinfo();
		   
		   agentInfoDao.saveOrUpdate(agentInfo);
	   }
	   
	   return agentNum;
   }
   
   public AgentInformation viewAgentInfoByNumber(String agentNum){
	   
	   AgentQueryModel qm=new AgentQueryModel();
	   qm.setAgentinfo(agentNum);
	   
	   AgentInformation agentInfo=new AgentInformation();
	   List<AgentInformation> agentList=agentInfoDao.viewAgentInfoByNumber(qm);
	   agentInfo=agentList.get(0);
	   return agentInfo;
   }
   
   public void modLeave(String agentNum){
       System.err.println(agentNum+"---modLeave");
	   //获取坐席信息
	   AgentInformation agentInfo=this.viewAgentInfoByNumber(agentNum);
	   agentInfo.setAgentState(AgentStateEnum.NOTLOGIN);
	   agentInfo.setUsername("");
	   agentInfoDao.saveOrUpdate(agentInfo);
	   
   }
   
   public AgentInformation viewAgentInfoByName(String name){
	   AgentInformation agentInfo=new AgentInformation();
	   AgentQueryModel qm=new AgentQueryModel();
	   qm.setUsername(name);
	   qm.setAgentState(AgentStateEnum.LOGIN);
	   List<AgentInformation> agentInfoList=agentInfoDao.getAgentInfoByUser(qm);
	   if(agentInfoList.size()>0){
		   agentInfo=agentInfoList.get(0);
	   }
	   else{
		   agentInfo=null;
	   }
	   return agentInfo;
   }
   
   public List<AgentInformation> getAgentListByAgent(String agent){
	   AgentQueryModel qm=new AgentQueryModel();
	   qm.setAgentinfo(agent);
	   
	   return agentInfoDao.getAgentListByAgent(qm);
   }
}
