package cn.com.atnc.ioms.dao.publicnotice.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.publicnotice.IPublicNoticeDao;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.model.publicnotice.PublicNoticeQueryModel;
@Repository("PublicNoticeDao")
public class PublicNoticeDaoImpl extends MyBaseDao<PnNotice>implements IPublicNoticeDao {
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
    

	@Override
	public Pagination queryPage(PublicNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from PnNotice where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (StringUtils.hasText(queryModel.getTitleLike())) {
			hql.append(" and title  like:titleLike");
			params.put("titleLike", "%" + queryModel.getTitleLike() + "%");
		}
		if (null!=queryModel.getUser()) {
			hql.append(" and createUser.id  =:user");
			params.put("user", queryModel.getUser().getId());
		}
		if(null!=queryModel.getPnNoticeColumnEnum()){
			hql.append(" and columns = :columns");
			params.put("columns",queryModel.getPnNoticeColumnEnum());
		}
		if (StringUtils.hasText(queryModel.getUserNameLike())) {
			hql.append(" and createUser.loginName like:name");
		//	hql.append(" and (user.loginName like:loginName or user.name like:name)");
			//params.put("loginName","%"+queryModel.getUserNameLike()+"%");
			params.put("name","%"+queryModel.getUserNameLike()+"%");
		}
		if (StringUtils.hasText(queryModel.getStartCreateTime())) {
			hql.append(" and createTime>=:optimes");
			try {
				params.put("optimes", startDate.parse(queryModel.getStartCreateTime()+" 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.hasText(queryModel.getEndCreateTime())) {
			hql.append(" and createTime<=:optimee");
			try {
				params.put("optimee", endDate.parse(queryModel.getEndCreateTime()+" 23:59:59"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 hql.append(" order by createTime desc");
		String countHql = COUNT_ID + hql.toString();
		System.out.println(hql);
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PnNotice> queryList(PublicNoticeQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from PnNotice where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getTitleLike())) {
			hql.append(" and title like:titleLike");
			params.put("titleLike", "%" + queryModel.getTitleLike() + "%");
		}
		return (List<PnNotice>) super.queryList(hql.toString(), params);
	}

}
