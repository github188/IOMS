package cn.com.atnc.ioms.dao.systemmng.userlog.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.dao.systemmng.userlog.IUserLogDao;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.model.systemmng.userlog.UserLogQueryModel;

/**
 * UserLogDao hibernate 实现
 * 
 * @author:lizhisheng
 * @date:2014-4-3 上午10:39:06
 */
@Repository("userLogDao")
public class UserLogDaoImpl extends MyBaseDao<UserLog> implements IUserLogDao {

	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private IResourceDao resourceDao;
	@Override
	public Pagination pagnQuery(UserLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from UserLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		/*if (StringUtils.hasText(queryModel.getMenuLike())) {
			hql.append(" and menu like:menuLike");
			params.put("menuLike", "%" + queryModel.getMenuLike() + "%");
		}*/
		if (StringUtils.hasText(queryModel.getUserNameLike())) {
			hql.append(" and user.name like:name");
			// hql.append(" and (user.loginName like:loginName or user.name like:name)");
			// params.put("loginName","%"+queryModel.getUserNameLike()+"%");
			params.put("name", "%" + queryModel.getUserNameLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getDptLike())) {
			hql.append(" and user.dept like:dptLike");
			// hql.append(" and (user.loginName like:loginName or user.name like:name)");
			// params.put("loginName","%"+queryModel.getUserNameLike()+"%");
			params.put("dptLike", "%" + queryModel.getDptLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getOptTypeLike())) {
			hql.append(" and optType like:optTypeLike");
			// hql.append(" and (user.loginName like:loginName or user.name like:name)");
			// params.put("loginName","%"+queryModel.getUserNameLike()+"%");
			params.put("optTypeLike", "%" + queryModel.getOptTypeLike() + "%");
		}
		/*if (StringUtils.hasText(queryModel.getSubMenuLike())) {
			hql.append(" and subMenu like:subMenuLike");
			params.put("subMenuLike", "%" + queryModel.getSubMenuLike() + "%");
		}*/
		if (StringUtils.hasText( queryModel.getStartTime() )) {
			hql.append(" and optTime>=:optimes");
			try {
				params.put("optimes",
						startDate.parse(queryModel.getStartTime() + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.hasText(queryModel.getEndTime())) {
			hql.append(" and optTime<=:optimee");
			try {
				params.put("optimee",
						endDate.parse(queryModel.getEndTime() + " 23:59:59"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(StringUtils.hasText(queryModel.getParentMenu())){
			hql.append(" and menu =:parentmenu");
			params.put("parentmenu", resourceDao.findById(queryModel.getParentMenu()).getName());//对应id的中文名
		}
		if(StringUtils.hasText(queryModel.getSubMenu())){
			hql.append(" and subMenu =:subMenu");
			params.put("subMenu", resourceDao.findById(queryModel.getSubMenu()).getName());//对应id的中文名
		}
		/*
		 * if(!StringUtils.isEmpty(queryModel.getStartTime() )){
		 * hql.append(" and optTime>=?"); try {
		 * params.add(startDate.parse(queryModel.getStartTime() +" 00:00:00"));
		 * } catch (ParseException e) { e.printStackTrace(); } }
		 * if(!StringUtils.isEmpty(queryModel.getEndTime())){
		 * hql.append(" and optTime<=?"); try {
		 * params.add(endDate.parse(queryModel.getEndTime()+" 23:59:59")); }
		 * catch (ParseException e) { e.printStackTrace(); } }
		 */

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by optTime desc");
		
		System.out.println("hql:"+hql.toString());
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(UserLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from UserLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		/*if (StringUtils.hasText(queryModel.getMenuLike())) {
			hql.append(" and menu like:menuLike");
			params.put("menuLike", "%" + queryModel.getMenuLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getSubMenuLike())) {
			hql.append(" and subMenu like:subMenuLike");
			params.put("subMenuLike", "%" + queryModel.getSubMenuLike() + "%");
		}*/
/*		if (queryModel.getStartTime() != null) {
			hql.append(" and optTime>=:optimes");
			params.put("optimes", queryModel.getStartTime());
		}
		if (queryModel.getEndTime() != null) {
			hql.append(" and optTime<=:optimee");
			params.put("optimee", queryModel.getEndTime());
		}*/
		if(StringUtils.hasText(queryModel.getParentMenu())){
			hql.append(" and menu =:parentmenu");
			params.put("parentmenu", resourceDao.findById(queryModel.getParentMenu()).getName());//对应id的中文名
		}
		if(StringUtils.hasText(queryModel.getSubMenu())){
			hql.append(" and subMenu =:subMenu");
			params.put("subMenu", resourceDao.findById(queryModel.getSubMenu()).getName());//对应id的中文名
		}
		
		
		if (StringUtils.hasText( queryModel.getStartTime() )) {
			hql.append(" and optTime>=:optimes");
			try {
				params.put("optimes",
						startDate.parse(queryModel.getStartTime() + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.hasText(queryModel.getEndTime())) {
			hql.append(" and optTime<=:optimee");
			try {
				params.put("optimee",
						endDate.parse(queryModel.getEndTime() + " 23:59:59"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// return super.querySize(hql.toString(), params);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLog> queryList(UserLogQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from UserLog where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		/*if (StringUtils.hasText(queryModel.getMenuLike())) {
			hql.append(" and menu like:menuLike");
			params.put("menuLike", "%" + queryModel.getMenuLike() + "%");
		}
		if (StringUtils.hasText(queryModel.getSubMenuLike())) {
			hql.append(" and subMenu like:subMenuLike");
			params.put("subMenuLike", "%" + queryModel.getSubMenuLike() + "%");
		}*/
		/*if (queryModel.getStartTime() != null) {
			hql.append(" and optTime>=:optimes");
			params.put("optimes", queryModel.getStartTime());
		}
		if (queryModel.getEndTime() != null) {
			hql.append(" and optTime<=:optimee");
			params.put("optimee", queryModel.getEndTime());
		}*/
		if(StringUtils.hasText(queryModel.getParentMenu())){
			hql.append(" and menu =:parentmenu");
			params.put("parentmenu", resourceDao.findById(queryModel.getParentMenu()).getName());//对应id的中文名
		}
		if(StringUtils.hasText(queryModel.getSubMenu())){
			hql.append(" and subMenu =:subMenu");
			params.put("subMenu", resourceDao.findById(queryModel.getSubMenu()).getName());//对应id的中文名
		}
		if (StringUtils.hasText( queryModel.getStartTime() )) {
			hql.append(" and optTime>=:optimes");
			try {
				params.put("optimes",
						startDate.parse(queryModel.getStartTime() + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (StringUtils.hasText(queryModel.getEndTime())) {
			hql.append(" and optTime<=:optimee");
			try {
				params.put("optimee",
						endDate.parse(queryModel.getEndTime() + " 23:59:59"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<UserLog>) super.queryList(hql.toString(), params);
	}

}
