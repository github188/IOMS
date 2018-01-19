/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:27:15
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.acl.hibernate;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.entity.acl.Question;
import cn.com.atnc.ioms.dao.acl.IQuestionDao;

/**
 * 问题DAO实现类
 * @author duanyanlin
 * @date 2016年4月19日上午11:21:10
 */
@Repository("QuestionDao")
public class QuestionDaoImpl extends MyBaseDao<Question> implements IQuestionDao {



}
