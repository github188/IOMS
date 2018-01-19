/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-8 
 * author:xiongzhikang
 */

package cn.com.atnc.ioms.dao.systemmng.clientlog;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.systemmng.clientlog.ClientLog;
import cn.com.atnc.ioms.model.systemmng.clientlog.ClientLogQueryModel;


public interface IClientLogDao extends IBaseDao<ClientLog> {
	public Pagination queryPage(ClientLogQueryModel qm);
	public List<String> queryOptType();
	
	
}
