/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:32:43
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */
package cn.com.atnc.ioms.dao.acl.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.acl.IResourceDao;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.enums.acl.ResourceType;
import cn.com.atnc.ioms.model.acl.ResourceQueryModel;

/**
 * 资源项Dao 实现
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:32:43
 */
@Repository("ResourceDao")
public class ResourceDaoImpl extends MyBaseDao<Resource> implements
		IResourceDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> listColMenuResource(ResourceType type) {
		Assert.notNull(type);
		String hql = "from Resource where type=? order by list asc";
		return (List<Resource>) super.queryList(hql, new Object[] { type });
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> listResource(String pid, ResourceType[] type) {

		StringBuilder hql = new StringBuilder("from Resource where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(pid)) {
			hql.append(" and pid =:pid");
			params.put("pid", pid);
		}
		if (!ObjectUtils.isEmpty(type)) {
			hql.append(" and type in :type");
			params.put("type", type);
		}
		hql.append(" order by list asc");
		return (List<Resource>) super.queryList(hql.toString(), params);

	}

	@Override
	public int deleteNotMenu(String id, ResourceType type) {
		Assert.hasText(id);
		String hql = "delete from Resource where pid=? and type=?";
		return super.executeHql(hql, new Object[] { id, type });
	}

	@Override
	public long querySize(String pid, ResourceType[] type) {

		StringBuilder hql = new StringBuilder("from Resource where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(pid)) {
			hql.append(" and pid =:pid");
			params.put("pid", pid);
		}
		if (!ObjectUtils.isEmpty(type)) {
			hql.append(" and type in :type");
			params.put("type", type);
		}
		hql.append(" order by list asc");
		return super.querySize(hql.toString(), params);
	}

	@Override
	public Pagination queryPage(ResourceQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from Resource where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.hasText(queryModel.getId())) {
			hql.append(" and id =:id");
			params.put("id", queryModel.getId());
		}
		if (queryModel.getType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		if (!ObjectUtils.isEmpty(queryModel.getTypes())) {
			hql.append(" and type in :types");
			params.put("types", queryModel.getTypes());
		}
		if (StringUtils.hasText(queryModel.getName())) {
			hql.append(" and name like:name");
			params.put("name", "%" + queryModel.getName() + "%");
		}
		if (StringUtils.hasText(queryModel.getPid())) {
			hql.append(" and pid =:pid");
			params.put("pid", queryModel.getPid());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by pid,type,list asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> queryMenu(ResourceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from Resource where type=:type");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		return (List<Resource>) super.queryList(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> querySubMenu(ResourceQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from Resource where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryModel.getType() != null) {
			hql.append(" and type =:type");
			params.put("type", queryModel.getType());
		}
		if (queryModel.getPid() != null) {
			hql.append(" and pid =:pid");
			params.put("pid", queryModel.getPid());
		}
		else{//如果pid为空，则查询结果为空
			hql.append(" and 1=0");
		}
		return (List<Resource>) super.queryList(hql.toString(), params);
	}

}
