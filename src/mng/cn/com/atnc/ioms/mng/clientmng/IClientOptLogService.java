package cn.com.atnc.ioms.mng.clientmng;

import java.io.Serializable;

import cn.com.atnc.ioms.entity.clientmng.ClientOptLog;

/**
 *类说明
 *@author 潘涛
 *@date 2014-6-10	下午1:17:28
 *@version:1.0
 */
public interface IClientOptLogService {
	/**
	 * 添加操作日志
	 * @author 潘涛
	 * @date:2014年6月10日 13:19:49
	 * */
	ClientOptLog add(ClientOptLog log);
	/**
	 * 按主键查找
	 * @author 潘涛
	 * @date:2014年6月10日 13:21:35
	 * */
	ClientOptLog findById(Serializable id);
}
