/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-7-5 下午1:58:58
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.acl;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * @author:HuangYijie
 * @date:2014-7-5 下午1:58:58
 * @version:1.0
 */

public interface IDiscuzUserService {
	/**
	 * 注册论坛用户
	 * 
	 * @author:HuangYijie
	 * @Date:2014-7-5 下午2:01:28
	 * 
	 * @param client
	 *            用户基本信息
	 * @throws ServiceException
	 *             void
	 */
	public void registerDiscuzMember(BaseUserInfo user) throws ServiceException;

	/**
	 * 删除论坛用户
	 * 
	 * @author:HuangYijie
	 * @Date:2014-7-5 下午2:01:46
	 * 
	 * @param client
	 * @throws ServiceException
	 *             void
	 */
	public void deleteDiscuzMember(BaseUserInfo user) throws ServiceException;
	
	/**
	 * 更新论坛用户（用户用户修改密码）
	 * 
	 * @author:HuangYijie
	 * @Date:2014-7-5 下午2:01:46
	 * 
	 * @param client
	 * @throws ServiceException
	 *             void
	 */
	public void updateDiscuzMember(BaseUserInfo user) throws ServiceException;
}
