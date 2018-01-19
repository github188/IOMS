/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:18:58
 * author:HuangYijie 2013-9-2 下午2:24:21
 */
package cn.com.atnc.ioms.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.BaseEntity;

/**
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:24:21
 * @param <E> 泛型抽象entity
 */
public abstract class MyBaseDao<E extends BaseEntity> extends
		BaseDaoHibernateImpl<E> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected MyBaseDao() {

	}

	protected MyBaseDao(boolean cacheable) {
		super(cacheable);
	}

	@Autowired
	public void setSessionFac(SessionFactory sessionFac) {
		super.setSessionFactory(sessionFac);
	}

}
