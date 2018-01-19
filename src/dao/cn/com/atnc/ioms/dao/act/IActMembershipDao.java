/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:25:42
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.act;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.act.ActMembership;

/**
 * Act用户Dao接口
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:25:42
 */
public interface IActMembershipDao extends IBaseDao<ActMembership> {
	
	
	public int deleteByUserId(String userId);
}
