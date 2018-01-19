/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 下午1:09:58
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.systemmng.param;

import java.io.IOException;
import java.util.Properties;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.model.systemmng.param.SystemParamsModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 下午1:09:58
 * @version:1.0
 */

public interface ISystemConfigManager {
	/**
	 * 更新
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 下午1:24:54
	 * 
	 * @param key
	 * @param value
	 *            void
	 */
	public String update(SystemParamsModel model) throws IOException,
			ServiceException;

	/**
	 * 重新初始化
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 下午1:25:00
	 * 
	 *                 void
	 */
	public void reInit() throws ServiceException;

	public String getParam(String key) throws ServiceException;

	public SystemParamsModel getModel() throws ServiceException;
}
