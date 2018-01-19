package cn.com.atnc.ioms.dao.clientmng.impl;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientmng.IClientOptLogDao;
import cn.com.atnc.ioms.entity.clientmng.ClientOptLog;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-6-10 下午1:12:07
 * @version:1.0
 */
@Repository
public class ClientOptLogDaoImpl extends MyBaseDao<ClientOptLog> implements
		IClientOptLogDao {
}
