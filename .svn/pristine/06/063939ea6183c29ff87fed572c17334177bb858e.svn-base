package cn.com.atnc.ioms.mng.systemmng.clientlog;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-8 
 * author:xiongzhikang
 */


import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.systemmng.clientlog.ClientLog;
import cn.com.atnc.ioms.model.systemmng.clientlog.ClientLogQueryModel;

/**
 * 客户日志业务逻辑处理接口
 * 
 * @author:xiongzhikang
 * @date:2014-4-8
 */
public interface IClientLogManager {
	/**
	 * 添加日志
	 *
	 * @author:xiongzhikang
	 * @date:2014-4-8
	 * @param log
	 * @return
	 * String
	 */
	public String add(ClientLog log);
	/**
	 * 多条件查询
	 *
	 * @author:xiongzhikang
	 * @date:2014-4-8
	 * @param qm
	 * @return
	 * Pagination
	 */
	public Pagination queryPage(ClientLogQueryModel qm);
	
	public List<String> queryOptType();
	
	
	
}
