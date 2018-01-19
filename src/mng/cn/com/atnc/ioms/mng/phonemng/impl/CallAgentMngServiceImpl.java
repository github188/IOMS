package cn.com.atnc.ioms.mng.phonemng.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.phonemng.ICallAgentMngDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallAgentMng;
import cn.com.atnc.ioms.enums.phonemng.AgentStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallAgentStateEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.phonemng.ICallAgentMngService;
import cn.com.atnc.ioms.model.phonemng.CallAgentMngQueryModel;

/**
 * 
 * @author hantianyu
 * @creatime 2016-8-21上午11:19:20 TODO
 */
@Service("ICallAgentMngService")
public class CallAgentMngServiceImpl extends BaseService implements
		ICallAgentMngService {

	@Autowired
	private ICallAgentMngDao callAgentMngDao;
	@Autowired
	private IAgentInfoService agentInfoService;


	public Map<AgentInformation, List<String>> getStatueByAgent(String agentNo) {
		// 声明map
		Map<AgentInformation, List<String>> callAgentMap = new LinkedHashMap();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		// 获取坐席信息
		List<AgentInformation> agentList = agentInfoService
				.getAgentListByAgent(agentNo);
		if (agentList.size() > 0) {
			for (AgentInformation agent : agentList) {
				// 用于储存状态值
				List<String> strList = new ArrayList<String>();
				CallAgentMngQueryModel qm = new CallAgentMngQueryModel();
				qm.setAgent(agent.getAgentinfo());
				// 获取坐席信息
				List<CallAgentMng> callAgentList = callAgentMngDao
						.viewAgentInfoByNumber(qm);
				
				if(agent.getUsername()==null){
					// 不在线
					strList.add(CallAgentStateEnum.NOTLINE.getValue());
					
					// 发生时间
					strList.add("");
				}
				else{
					if (callAgentList.size() > 0) {
						// 比较状态位
						CallAgentMng callAgentMng = callAgentList.get(0);
						String state="";
						String type="";
						String busy_type="";
						
						if(callAgentMng.getEventType()!=null){
							state = callAgentMng.getEventType();
						}
						if(callAgentMng.getEventState()!=null){
							type = callAgentMng.getEventState();
						}
						if(callAgentMng.getBusyType()!=null){
							busy_type = callAgentMng.getBusyType();
						}
						
						//System.err.println("state-"+state+"-type-"+type+"-busy_type-"+busy_type);
						
						if (state.equals("1") && type.equals("login")
								&& busy_type.equals("null")) {
							//上线
							strList.add(CallAgentStateEnum.ONLINE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("发生时间："+format.format(date));
						}
						////////////////////////////忙碌
						if(busy_type.equals("1") && state.equals("1")){
							//忙碌
							strList.add(CallAgentStateEnum.SETBUSY.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("发生时间："+format.format(date));
						}
						if(busy_type.equals("1") && state.equals("0")){
							//置闲
							strList.add(CallAgentStateEnum.FREE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("");
						}
						////////////////////小休
						if(busy_type.equals("2") && state.equals("1")){
							//小休
							strList.add(CallAgentStateEnum.SETREST.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("发生时间："+format.format(date));
						}
						if(busy_type.equals("2") && state.equals("0")){
							//置闲
							strList.add(CallAgentStateEnum.FREE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("");
						}
						/////////////////////通话
						if(busy_type.equals("99") && state.equals("1")){
							//通话中
							strList.add(CallAgentStateEnum.PHONE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("发生时间："+format.format(date));
						}
						if(busy_type.equals("99") && state.equals("0")){
							//通话结束
							strList.add(CallAgentStateEnum.FREE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("");
						}
						if (state.equals("0") && type.equals("login")
								&& busy_type.equals("null")) {
							//登出?
							strList.add(CallAgentStateEnum.FREE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("");
						}
						if (type.equals("signout")) {
							//签出
							strList.add(CallAgentStateEnum.NOTLINE.getValue());
							
							Date date=callAgentMng.getNowTime();
							strList.add("发生时间："+format.format(date));
						}
					} else {
						// 不在线
						strList.add(CallAgentStateEnum.NOTLINE.getValue());
						
						// 发生时间
						strList.add("");
					}
				}
				//插入
				callAgentMap.put(agent, strList);
				
			}//AgentInformation end
		}//if agentList end

		return callAgentMap;
	}

    public void signOut(String agentNo){
    	
    	//AgentInformation agentInfo=agentInfoService.viewAgentInfoByNumber(agentNo);
    	//agentInfo.setAgentState(AgentStateEnum.SIGNOUT);
    	
    	CallAgentMng callAgentMng=new CallAgentMng();
		callAgentMng.setAgent(agentNo);
		callAgentMng.setNowTime(new Date());
		callAgentMng.setEventState("signout");
		
		callAgentMngDao.save(callAgentMng);
    }
}
