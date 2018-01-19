package cn.com.atnc.ioms.dao.duty.vgduty.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.duty.vgduty.VGSystemDao;
import cn.com.atnc.ioms.entity.duty.vgduty.VGSystem;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;

/**
 * VG系统检查DAO实现类
 * @author 
 * @date 
 * @since 
 */
@Repository("vgSystemDao")
public class VGSystemDaoImpl extends MyBaseDao<VGSystem> implements 
		VGSystemDao {

	@Override
	public Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel) {
		//查询语句
		StringBuilder hql = new StringBuilder("from VGSystem v where 1=1");
		//查询参数值
		List<Object> queryParams = new ArrayList<Object>();
		//创建人
		if(StringUtils.isNotEmpty(queryModel.getCreater())) {
			hql.append(" and v.creater.name like ? escape '\\' ");
			queryParams.add("%" + queryModel.getCreater() + "%");
		}
		//审核人
		if(StringUtils.isNotEmpty(queryModel.getAuditer())) {
			hql.append(" and v.auditer.name like ? escape '\\' ");
			queryParams.add("%" + queryModel.getAuditer() + "%");
		}
		//记录查询条件-填写时间起
		if(!ObjectUtils.equals(queryModel.getFromCreateTime(), null)){
			hql.append(" and v.createTime >= ? ");
			queryParams.add(queryModel.getFromCreateTime());
		}
		//记录查询条件-填写时间至
		if(!ObjectUtils.equals(queryModel.getToCreateTime(), null)){
			hql.append(" and v.createTime <= ? ");
			queryParams.add(queryModel.getToCreateTime());
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), queryParams.toArray(),countHql,  
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
