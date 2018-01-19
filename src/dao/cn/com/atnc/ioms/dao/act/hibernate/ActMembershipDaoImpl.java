/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:35:17
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.act.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.act.IActMembershipDao;
import cn.com.atnc.ioms.entity.act.ActMembership;

/**
 * 用户Dao接口实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:35:17
 */
@Repository("ActMembershipDao")
public class ActMembershipDaoImpl extends MyBaseDao<ActMembership> implements
		IActMembershipDao {

	public int deleteByUserId(String userId) {
		String hql = "delete from ActMembership where user=?";
		return super.executeHql(hql, userId);
	}

}
