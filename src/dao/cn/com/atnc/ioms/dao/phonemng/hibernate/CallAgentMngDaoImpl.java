package cn.com.atnc.ioms.dao.phonemng.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.phonemng.ICallAgentMngDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallAgentMng;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;
import cn.com.atnc.ioms.model.phonemng.CallAgentMngQueryModel;

@Repository("ICallAgentMngDao")
public class CallAgentMngDaoImpl extends MyBaseDao<CallAgentMng> implements ICallAgentMngDao{

	public List<CallAgentMng> viewAgentInfoByNumber(CallAgentMngQueryModel qm) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallAgentMng where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(!StringUtils.isEmpty(qm.getAgent())){
			hql.append("and agent=:agent");
	    	params.put("agent",qm.getAgent());
		}
		hql.append(" and nowTime is not null order by nowTime desc ");
	    
    	
		return (List<CallAgentMng>) super.queryList(hql.toString(),params);
	}
}
