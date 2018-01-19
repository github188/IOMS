package cn.com.atnc.ioms.mng.phonemng;

import java.util.List;
import java.util.Map;

import cn.com.atnc.ioms.entity.phonemng.AgentInformation;

/**
 * 
 * @author hantianyu
 * @creatime 2016-8-21上午11:14:51
 * TODO
 */
public interface ICallAgentMngService {
	/**
	 * 
	 * @Auther Administrator
	 * @creatime 2016-8-21下午2:12:51
	 * @param agentNo
	 * @return Map<AgentInformation,List<String>>
	 * TODO 根据坐席获取其他坐席信息
	 */
	public Map<AgentInformation, List<String>> getStatueByAgent(String agentNo);
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-8-23下午1:21:17
	 * @param agentNo void
	 * TODO
	 */
	public void signOut(String agentNo);
}
