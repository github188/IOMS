/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-6 下午3:42:20
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.welcome;

import java.io.IOException;
import java.util.List;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.model.welcome.IndexNoticeModel;
import cn.com.atnc.ioms.model.welcome.ServiceNoticeModel;

/**
 * @author:HuangYijie
 * @date:2014-5-6 下午3:42:20
 * @version:1.0
 */

public interface IWelcomeManager {

	public String getAlarmStat() throws IOException;

	public ServiceNoticeModel getServiceNoticeCount(User user);

	/**
	 * 获取页面待办事项
	 *
	 * @param currentUser
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月4日下午4:26:33
	 * @since 1.0.0
	 */
	public List<IndexNoticeModel> getIndexNotice(User currentUser);

}
