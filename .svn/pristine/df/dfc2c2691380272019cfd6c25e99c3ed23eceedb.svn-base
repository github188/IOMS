/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:35:17
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.clientmng.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.sample.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientmng.IClientQuestionDao;
import cn.com.atnc.ioms.entity.clientmng.ClientQuestion;

/**
 * 用户Dao接口实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:35:17
 */
@Repository("clientQuestionDao")
public class ClientQuestionDaoImpl extends MyBaseDao<ClientQuestion> implements
		IClientQuestionDao {
	
	/**
	 * 根据用户ID查询所有已回答问题
	 * @author duanyanlin
	 * @date 2016年4月15日上午8:58:22
	 * @param clientId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ClientQuestion> searchClientQuestion(String clientId){
		StringBuilder hql = new StringBuilder(" from ClientQuestion ");
		hql.append(" c where 1 = 1 ");
		Map<String, Object> parms = new HashMap<String, Object>();
		hql.append(" and c.clientId=:clientId ");
		parms.put("clientId", clientId);
		return (List<ClientQuestion>) super.queryList(hql.toString(),parms);
	}

}
