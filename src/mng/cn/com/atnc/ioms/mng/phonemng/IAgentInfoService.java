package cn.com.atnc.ioms.mng.phonemng;

import java.util.List;

import cn.com.atnc.ioms.entity.phonemng.AgentInformation;

/**
 * 
 * @author hantianyu
 *
 */
public interface IAgentInfoService {
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:modSign
	 * @Description:有坐席可以签到的状态
	 * @Param:@param name
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月8日 下午4:59:56
	 */
	public String modSign(String name);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:viewAgentInfoByNumber
	 * @Description:根据坐席号获取  坐席信息
	 * @Param:@param agentNum
	 * @Param:@return
	 * @Return:AgentInformation
	 * @Creatime:2016年8月8日 下午5:07:02
	 */
	public AgentInformation viewAgentInfoByNumber(String agentNum);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:modLeave
	 * @Description:离岗时调整信息
	 * @Param:@param agentNum
	 * @Return:void
	 * @Creatime:2016年8月9日 上午9:19:04
	 */
	public void modLeave(String agentNum);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:viewAgentInfoByName
	 * @Description:根据姓名获取坐席信息
	 * @Param:@param name
	 * @Param:@return
	 * @Return:AgentInformation
	 * @Creatime:2016年8月9日 下午4:18:41
	 */
	public AgentInformation viewAgentInfoByName(String name);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getAgentListByAgent
	 * @Description:获取坐席列表 
	 * @Param:@param agent
	 * @Param:@return
	 * @Return:List<AgentInformation>
	 * @Creatime:2016年8月10日 下午4:07:35
	 */
	public List<AgentInformation> getAgentListByAgent(String agent);
}
