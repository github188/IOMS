/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-25 上午8:58:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.equip.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-25 上午8:58:39
 * @version:1.0
 */
@Repository("equipDao")
public class EquipDaoImpl extends MyBaseDao<Equip> implements IEquipDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.equip.IEquipDao#queryList(cn.com.atnc.ioms.model.basedata.EquipQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Equip> queryList(EquipQueryModel qm) {
		StringBuilder hql = new StringBuilder(" from Equip where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getCode())) {
			hql.append(" and code = ?");
			params.add(qm.getCode());
		}
		if (!StringUtils.isEmpty(qm.getCodeLike())) {
			hql.append(" and code like ?");
			params.add("%" + qm.getCodeLike() + "%");
		}
		if (!StringUtils.isEmpty(qm.getNameLike())) {
			hql.append(" and name like ?");
			params.add("%"+qm.getNameLike()+"%");
		}
		if (!StringUtils.isEmpty(qm.getName())) {
			hql.append(" and name = ?");
			params.add(qm.getName());
		}
		if (!StringUtils.isEmpty(qm.getInfo())) {
			hql.append(" and info = ?");
			params.add(qm.getInfo());
		}
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
			System.out.println(qm.getBureau());
		}
		if (null != qm.getType()) {
			hql.append(" and type= ?");
			params.add(qm.getType());
			//System.out.println(qm.getType());
		}else{
			hql.append(" and type in ('KU','TES')");
		}
		hql.append(" order by bureau asc,code asc,name asc,info asc,type asc");
		return (List<Equip>) super.queryList(hql.toString(), params.toArray());

	}
	@Override
	public Pagination queryPage(EquipQueryModel qm) {
		StringBuilder hql = new StringBuilder(" from Equip where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getCode())) {
			hql.append(" and code = ?");
			params.add(qm.getCode());
		}
		if (!StringUtils.isEmpty(qm.getCodeLike())) {
			hql.append(" and code like ?");
			params.add("%" + qm.getCodeLike() + "%");
		}
		if (!StringUtils.isEmpty(qm.getNameLike())) {
			hql.append(" and name like ?");
			params.add("%"+qm.getNameLike()+"%");
		}
		if (!StringUtils.isEmpty(qm.getName())) {
			hql.append(" and name = ?");
			params.add(qm.getName());
		}
		if (!StringUtils.isEmpty(qm.getInfo())) {
			hql.append(" and info = ?");
			params.add(qm.getInfo());
		}
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
			System.out.println(qm.getBureau());
		}
		if (null != qm.getType()) {
			hql.append(" and type= ?");
			params.add(qm.getType());
			//System.out.println(qm.getType());
		}else{
			/**
			 * 暂时只有ku维保使用
			 */
			hql.append(" and type in ('KU')");
		}
		hql.append(" order by bureau asc,code asc,name asc,info asc,type asc");
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Equip> atmNoteList(EquipQueryModel qm) {
		StringBuilder hql = new StringBuilder(" from Equip where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
		}		
		return (List<Equip>) super.queryList(hql.toString(), params.toArray());
	}
	
}
