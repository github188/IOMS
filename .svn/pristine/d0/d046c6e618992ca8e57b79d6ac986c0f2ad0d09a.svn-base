package cn.com.atnc.ioms.dao.duty.fax.day.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.fax.day.IFaxProcessDayDao;
import cn.com.atnc.ioms.entity.duty.fax.day.FaxProcessDay;
import cn.com.atnc.ioms.model.duty.fax.day.FaxSystemQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * 转报系统进程检查（自动）日检-dao
 *
 * @author 韩天驭
 * @2017年2月14日 下午12:02:44
 */
@Repository("IFaxProcessDayDao")
public class FaxProcessDayDaoImpl extends MyBaseDao<FaxProcessDay> implements
		IFaxProcessDayDao {
	
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
public Pagination queryPage(FaxSystemQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from FaxProcessDay where  1=1");
		List<Object> queryParams = new ArrayList<Object>();
		
	
		if(!StringUtils.isEmpty(queryModel.getUsername())){
			hql.append(" and judgeUser.name like ? escape '/' ");
			queryParams.add( "%" + queryModel.getUsername() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getOperator())){
			hql.append(" and creater.name like ? escape '/' ");
			queryParams.add( "%" + queryModel.getOperator() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getStartOptTime())){
			
			hql.append(" and checkTime >= ?");
		    try {
		    	queryParams.add(startDate.parse(queryModel.getStartOptTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		if(!StringUtils.isEmpty(queryModel.getEndOptTime())){
		
			hql.append(" and checkTime <= ?");
		    try {
		    	queryParams.add(endDate.parse(queryModel.getEndOptTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by checkTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
}
