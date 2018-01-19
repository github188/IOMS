package cn.com.atnc.ioms.dao.clientnotice.impl;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.clientnotice.IClientNoticeDao;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.model.clientnotice.ClientNoticeQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-4-22 上午9:19:57
 * @version:1.0
 */
@Repository("clientNoticeDao")
public class ClientNoticeDaoImpl extends MyBaseDao<SendLog> implements IClientNoticeDao{

	@Override
	public Pagination queryPage(ClientNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from SendLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getEmailLike())){
			hql.append(" and email like:emailLike");
			params.put("emailLike", "%"
					+ queryModel.getEmailLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getPhoneNoLike())) {
			hql.append(" and phoneNo like:phoneNoLike");
			params.put("phoneNoLike", "%" + queryModel.getPhoneNoLike() + "%");
		}
		if (null!=queryModel.getNoticeState()) {
			hql.append(" and noticeState =:noticeState");
			params.put("noticeState",queryModel.getNoticeState());
		}
		if (null!=queryModel.getNoticeType()) {
			hql.append(" and noticeType =:noticeType");
			params.put("noticeType", queryModel.getNoticeType());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by sendTime desc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SendLog> findByNoticeState(NoticeState noticeState) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from SendLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (noticeState!=null){
			hql.append(" and noticeState =:noticeState");
			params.put("noticeState", noticeState);
		}
		hql.append(" order by sendTime desc");
		return (List<SendLog>) super.queryList(hql.toString(), params);
	}
	
	@SuppressWarnings("unchecked")
	public List<SendLog> findByExcludeNoticeState(NoticeState noticeState) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from SendLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (noticeState!=null){
			hql.append(" and noticeState <>:noticeState");
			params.put("noticeState", noticeState);
		}
		hql.append(" order by sendTime desc");
		return (List<SendLog>) super.queryList(hql.toString(), params);
	}


	@Override
	public List<SendLog> queryList(ClientNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
