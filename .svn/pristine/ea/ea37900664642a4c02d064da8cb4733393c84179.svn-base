package cn.com.atnc.ioms.dao.systemmng.clientlog.hibernate;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.systemmng.clientlog.IClientLogDao;
import cn.com.atnc.ioms.entity.systemmng.clientlog.ClientLog;
import cn.com.atnc.ioms.enums.acl.MenuEnum;
import cn.com.atnc.ioms.enums.acl.SubMenuEnum;
import cn.com.atnc.ioms.model.systemmng.clientlog.ClientLogQueryModel;
/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-22 上午10:05:40
 * @version:1.0
 */
@Repository("ClientLogDao")
public class ClientLogDaoImpl extends MyBaseDao<ClientLog> implements IClientLogDao {
	
	@Override
	public Pagination queryPage(ClientLogQueryModel qm) {
		StringBuilder hql = new StringBuilder("from ClientLog a where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (qm.getStartTime() != null) {
			hql.append(" and a.optTime>=:optimes");
			params.put("optimes", qm.getStartTime());
		}
		if (qm.getEndTime() != null) {
			hql.append(" and a.optTime<=:optimee");
			params.put("optimee", qm.getEndTime());
		}
		if(StringUtils.hasText(qm.getParentMenu())){
			hql.append(" and a.menu =:parentmenu");
			params.put("parentmenu", MenuEnum.getMenuEnumByValue(qm.getParentMenu()));
		}
		if(StringUtils.hasText(qm.getSubMenu())){
			hql.append(" and a.subMenu =:subMenu");
			params.put("subMenu", SubMenuEnum.getSubMenuEnumByValue(qm.getSubMenu()));
		}
		if (StringUtils.hasText(qm.getOptType())){
			hql.append(" and a.optType=:optType");
			params.put("optType", qm.getOptType());
		}
		if (StringUtils.hasText(qm.getIp())) {
			hql.append(" and a.ip=:ip");
			params.put("ip", qm.getIp());
		}
		if (StringUtils.hasText(qm.getInfo())) {
			hql.append(" and a.info like:info");
			params.put("info", "%"+qm.getInfo()+"%");
		}
		if (qm.getBureau() != null) {//区域
			hql.append(" and a.client.bureau =:bureau");
			params.put("bureau", qm.getBureau());
		}
		if (StringUtils.hasText(qm.getClientName())) {
			hql.append(" and (a.client.loginName like:loginName or a.client.name like:name)");
			params.put("loginName","%"+qm.getClientName()+"%");
			params.put("name","%"+qm.getClientName()+"%");
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by optTime desc");
		return super.pageQuery(hql.toString(), params, countHql,
				qm.getPageNo(), qm.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryOptType() {
		String hql = "select distinct(optType) from ClientLog";
		return (List<String>) super.queryList(hql);
	}

	
}
