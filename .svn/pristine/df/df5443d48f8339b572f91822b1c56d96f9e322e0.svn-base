package cn.com.atnc.ioms.dao.phonemng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;
/**
 * 
 * @author hantianyu
 *
 */
public interface IAgentInfoDao extends IBaseDao<AgentInformation>{
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getAgentState
	 * @Description:根据状态获取信息
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<AgentInformation>
	 * @Creatime:2016年8月8日 下午4:38:17
	 */
	public List<AgentInformation> getAgentState(AgentQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:viewAgentInfoByNumber
	 * @Description:根据坐席号 获取坐席信息（账号、密码、登录方式）
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<AgentInformation>
	 * @Creatime:2016年8月8日 下午5:02:34
	 */
	public List<AgentInformation> viewAgentInfoByNumber(AgentQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getAgentInfoByUser
	 * @Description:根据用户名称查询坐席信息-获取坐席密码 账户 
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<AgentInformation>
	 * @Creatime:2016年8月9日 下午4:05:21
	 */
	public List<AgentInformation> getAgentInfoByUser(AgentQueryModel qm);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getAgentListByAgent
	 * @Description:除去自己的坐席
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<AgentInformation>
	 * @Creatime:2016年8月10日 下午4:05:30
	 */
	public List<AgentInformation> getAgentListByAgent(AgentQueryModel qm);
}
