package cn.com.atnc.ioms.dao.phonemng.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.phonemng.IAgentInfoDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;


@Repository("IAgentInfoDao")
public class AgentInfoDaoImpl extends MyBaseDao<AgentInformation> implements IAgentInfoDao{
	
	public List<AgentInformation> getAgentState(AgentQueryModel qm) {
	
		StringBuilder hql = new StringBuilder();
		hql.append(" from AgentInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	   
    	hql.append("and agentState=:agentState");
    	params.put("agentState",qm.getAgentState());
	    
    	
		return (List<AgentInformation>) super.queryList(hql.toString(),params);
	}
	
	public List<AgentInformation> viewAgentInfoByNumber(AgentQueryModel qm) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from AgentInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    
    	hql.append("and agentinfo=:agentinfo");
    	params.put("agentinfo",qm.getAgentinfo());
	    
    	
		return (List<AgentInformation>) super.queryList(hql.toString(),params);
	}
	public List<AgentInformation> getAgentInfoByUser(AgentQueryModel qm){
		StringBuilder hql = new StringBuilder();
		hql.append(" from AgentInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(!StringUtils.isEmpty(qm.getUsername())){
			hql.append("and username=:username");
	    	params.put("username",qm.getUsername());
		}
		
    	hql.append(" and agentState=:agentState");
    	params.put("agentState",qm.getAgentState());
	    
    	
		return (List<AgentInformation>) super.queryList(hql.toString(),params);
	}
	public List<AgentInformation> getAgentListByAgent(AgentQueryModel qm){
		StringBuilder hql = new StringBuilder();
		hql.append(" from AgentInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(!StringUtils.isEmpty(qm.getAgentinfo())){
			hql.append("and agentinfo !=:agentinfo");
	    	params.put("agentinfo",qm.getAgentinfo());
		}
		
    	hql.append(" order by agentinfo asc ");
    	
		return (List<AgentInformation>) super.queryList(hql.toString(),params);
	}
}
